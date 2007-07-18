/*
 * CreateEquipmentHolderResponse.java
 *
 * Created on 7 mai 2007, 23:25
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.tmforum.mtop.simulator.creategetinventoryresponse;

import java.util.*;

import v1.tmf854.*;
import v1.tmf854.MDInventoryT.MlsnList;
import v1.tmf854.MLSNInventoryT.SncList;
import v1.tmf854.InventoryDataT.MdList;
import v1.tmf854.SimpleFilterT.IncludedObjectType;
//import org.tmforum.mtop.simulator.entity.managedinventories.*;
//import org.tmforum.mtop.simulator.entity.managedinventories.MDInventoryT.MlsnList;
//import org.tmforum.mtop.simulator.entity.managedinventories.MLSNInventoryT.SncList;
//import org.tmforum.mtop.simulator.entity.managedentities.*;

/**
 *
 * @author baptiste
 */
public class CreateSubnetworkConnectionResponse extends CreateGetInventoryResponse {
    
    /** Creates a new instance of CreateEquipmentHolderResponse */
    public CreateSubnetworkConnectionResponse() {
    }
    
    public InventoryDataT createResponse(List<?> objs, String granularity) {
        System.out.println("**************CreateSubnetworkConnectionResponse:createResponse2**************");
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


