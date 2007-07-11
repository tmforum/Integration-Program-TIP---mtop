/*
 * CreateEquipmentHolderResponse.java
 *
 * Created on 7 mai 2007, 23:25
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.tmforum.mtop.simulator;

import v1.tmf854.*;
import v1.tmf854.InventoryDataT.MdList;
import v1.tmf854.MDInventoryT.MlsnList;
import v1.tmf854.MLSNInventoryT.SncList;
import v1.tmf854.SimpleFilterT.IncludedObjectType;
import java.io.*;
import java.util.*;

/**
 *
 * @author baptiste
 */
public class CreateSubnetworkConnectionResponse extends CreateResponse {
    
    /** Creates a new instance of CreateEquipmentHolderResponse */
    public CreateSubnetworkConnectionResponse() {
    }
    
    
    public InventoryDataT createResponse(List<?> objs, String granularity) {
        System.out.println(" CreateSubnetworkConnectionResponse:createResponse");
        InventoryDataT inventoryData = new InventoryDataT();
        String mdNm1 = "";
        String mlsnNm1 = "";
        String sncNm1 = "";
        MdList mdList = new MdList();
        MDInventoryT mdInv = new MDInventoryT();
        List<MDInventoryT> mdInvs = mdList.getMd();
        MlsnList mlsnList = new MlsnList();
        MLSNInventoryT mlsnInv = new MLSNInventoryT();
        List<MLSNInventoryT> mlsnInvs = mlsnList.getMlsnInv();
        ListIterator<MLSNInventoryT> litMe = mlsnInvs.listIterator();
        MultiLayerSubnetworkT previousMlsn = null;
        SncList sncList = new SncList();
        List<SNCInventoryT> sncInvs = sncList.getSncInv();
        ListIterator<SNCInventoryT> litSnc = sncInvs.listIterator();
        SubnetworkConnectionT previousSnc = null;
        String previousMdNm = null;
        String previousMlsnNm = null;
        String previousSncNm = null;
        boolean newNode = false;
        for (Object o : objs) {
            SubnetworkConnectionT snc = (SubnetworkConnectionT) o;
            SNCInventoryT sncInv = new SNCInventoryT();
            mdNm1 = snc.getName().getMdNm();
            System.out.println("mdNm1 " + mdNm1);
            mlsnNm1 = snc.getName().getMlsnNm();
            System.out.println("mlsnNm1 " + mlsnNm1);
            sncNm1 = snc.getName().getSncNm();
            
            if (previousSnc != null) {
                //System.out.println("mdNm " + mdNm1 + " previousMdNm " + previousMdNm);
                if(!mlsnNm1.equals(previousMlsnNm)) {
                    System.out.println("Change Me!!!!!!!!!!!!!!!!");
                    //snc belongs to another me
                    previousSnc.setName(null);
                    previousSnc.setIdSNC(null);
                    newNode = true;
                    mlsnInv.setSncList(sncList);
                    mlsnInv.setMlsnNm(previousMlsnNm);
                    mlsnInvs.add(mlsnInv);
                    sncInv = new SNCInventoryT();
                    sncList = new SncList();
                    sncInvs = sncList.getSncInv();
                    litSnc = sncInvs.listIterator();
                    mlsnInv = new MLSNInventoryT();
                }
            }
            if (granularity.equals("ATTRS") || granularity.equals("FULL"))
                sncInv.setSncAttrs(snc);
            sncInv.setSncNm(sncNm1);
            litSnc.add(sncInv);
            
            
            if (previousSnc != null && !newNode){
                previousSnc.setName(null);
                previousSnc.setIdSNC(null);
            }
            previousSnc = snc;
            previousMlsnNm = previousSnc.getName().getSncNm();
            newNode = false;
        }
        
        SubnetworkConnectionT lastSnc = litSnc.previous().getSncAttrs();
        lastSnc.setIdSNC(null);
        lastSnc.setName(null);
        mlsnInv.setSncList(sncList);
        mlsnInv.setMlsnNm(mlsnNm1);
        mlsnInvs.add(mlsnInv);
        mdInv.setMlsnList(mlsnList);
        mdInv.setMdNm(mdNm1);
        mdInvs.add(mdInv);
        
        inventoryData.setMdList(mdList);
        return inventoryData;
    }
    
    
    public InventoryDataT createResponse2(List<?> objs, String granularity) {
        System.out.println("**************CreateSubnetworkConnectionResponse:createResponse2**************");
        System.out.println("objs.size " + objs.size());
        System.out.println("a: " + super.getA());
        
        //MDInventoryT mdInv = new MDInventoryT();
        SncList SncList = new SncList();
        List<SNCInventoryT> sncInvs = SncList.getSncInv();
        ListIterator<SNCInventoryT> litMe = sncInvs.listIterator();
        SubnetworkConnectionT previousMe = null;
        String previousMdNm = null;
        String mdNm1 = "";
        String meNm1 = "";
        String sncNm1 = "";
        // boolean newNode = false;
        boolean newMdInv = true;
        boolean newMlsnInv = true;
        
        SubnetworkConnectionT  firstMultiLayerSubNetwork = (SubnetworkConnectionT) objs.get(0);
        System.out.println("CreateMultiLayerSubNetwork: mdList.size " + getMdList().getMd().size());
        
        if (getMdList().getMd().size() == 0) {
            MDInventoryT firstMdInv = new MDInventoryT();
            firstMdInv.setMdNm(firstMultiLayerSubNetwork.getName().getMdNm());
            getMdList().getMd().add(firstMdInv);
        }
        
        
        
        
        // loop through all SubnetworkConnections retrieved
        for (Object o : objs) {
            SubnetworkConnectionT  snc = (SubnetworkConnectionT) o;
            // creates the EhInventory
            SNCInventoryT sncInv = new SNCInventoryT();
            sncInv.setSncNm(snc.getName().getSncNm());
            if (granularity.equals("ATTRS"))
                sncInv.setSncAttrs(snc);
            
            sncNm1 = snc.getName().getSncNm();
            
            // loop through all existing ManagementDomains
            for (MDInventoryT oldMdInv : getMdList().getMd()) {
                if (oldMdInv.getMdNm().equals(snc.getName().getMdNm())) {
                    // SubnetworkConnection belongs to this ManagementDomain
                    
                    if (oldMdInv.getMlsnList() == null) {
                        MlsnList firstMlsnListOfMd = new MlsnList();
                        MLSNInventoryT firstMlsnInvOfMd = new MLSNInventoryT();
                        firstMlsnInvOfMd.setMlsnNm(snc.getName().getMlsnNm());
                        firstMlsnListOfMd.getMlsnInv().add(firstMlsnInvOfMd);
                        oldMdInv.setMlsnList(firstMlsnListOfMd);
                    }
                    // loop through all existing MultiLayerSubNetworks
                    for (MLSNInventoryT oldMlsnInv : oldMdInv.getMlsnList().getMlsnInv()) {
                        if (oldMlsnInv.getMlsnNm().equals(snc.getName().getMlsnNm())) {
                            //SubnetworkConnection belongs to this MultiLayerSubNetwork
                            if (oldMlsnInv.getSncList() != null) {
                                // EqipmentHolder is not the first under this MultiLayerSubNetwork
                                oldMlsnInv.getSncList().getSncInv().add(sncInv);
                            } else {
                                // SubnetworkConnection is the first under this MultiLayerSubNetwork
                                SncList SncListOldMe = new SncList();
                                SncListOldMe.getSncInv().add(sncInv);
                                oldMlsnInv.setSncList(SncListOldMe);
                            }
                            newMlsnInv = false;
                            break;
                        }
                        if (newMlsnInv) {
                            // SubnetworkConnection belongs to a new MultiLayerSubNetwork
                            MLSNInventoryT mlsnInv = new MLSNInventoryT();
                            SncList SncListUnderNewMe = new SncList();
                            SncListUnderNewMe.getSncInv().add(sncInv);
                            mlsnInv.setSncList(SncList);
                            // Add MultiLayerSubNetwork to ManagementDomain
                            oldMdInv.getMlsnList().getMlsnInv().add(mlsnInv);
                        }
                    } // for me
                    newMdInv = false;
                    break;
                }
                if (newMdInv) {
                    // SubnetworkConnection belongs to a new MultiLayerSubNetwork and a new ManagementDomain
                    MDInventoryT mdInvUnderNewMd = new MDInventoryT();
                    mdInvUnderNewMd.setMdNm(snc.getName().getMdNm());
                    MlsnList mlsnListUnderNewMd = new MlsnList();
                    MLSNInventoryT mlsnInvUnderNewMd = new MLSNInventoryT();
                    mlsnInvUnderNewMd.setMlsnNm(snc.getName().getMlsnNm());
                    SncList SncListUnderNewMd = new SncList();
                    SncListUnderNewMd.getSncInv().add(sncInv);
                    mlsnInvUnderNewMd.setSncList(SncList);
                    mlsnListUnderNewMd.getMlsnInv().add(mlsnInvUnderNewMd);
                    mdInvUnderNewMd.setMlsnList(mlsnListUnderNewMd);
                    
                    getMdList().getMd().add(mdInvUnderNewMd);
                }
            } // for md
        } // for objs
        // add the new MdList to final response
        refreshMdList(getMdList());
        
        //inventoryData.setMdList(mdList);
        System.out.println("***************fin CreateSubnetworkConnectionResponse*************");
        
        return inventoryData;
    }
    
    
    
}


