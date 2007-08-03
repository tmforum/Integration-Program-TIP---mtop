/*
 * CreateSubnetworkConnectionResponse.java
 *
 * Created on 7 mai 2007, 23:25
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.tmforum.mtop.simulator;

import java.util.*;

import v1.tmf854.*;
import v1.tmf854.InventoryDataT.MdList;
import v1.tmf854.MDInventoryT.MlsnList;
import v1.tmf854.MLSNInventoryT.SncList;
//import org.tmforum.mtop.simulator.entity.managedinventories.MDInventoryT.MlsnList;
//import org.tmforum.mtop.simulator.entity.managedinventories.*;
//import org.tmforum.mtop.simulator.entity.managedinventories.SNCInventoryT.CtpList;
//import org.tmforum.mtop.simulator.entity.managedinventories.MLSNInventoryT.SncList;
import v1.tmf854.SimpleFilterT.IncludedObjectType;

//import org.tmforum.mtop.simulator.entity.managedentities.*;


/**
 *
 * @author baptiste
 */
public class CreateSubnetworkConnectionResponse extends CreateGetInventoryResponse {
    
    /** Creates a new instance of CreateSubnetworkConnectionResponse */
    public CreateSubnetworkConnectionResponse() {
    }
    
    public InventoryDataT createResponse(List<?> objs, String granularity) {
        System.out.println("**************CreateSubnetworkConnectionResponse:createResponse2**************");
        SncList sncList = new SncList();
        List<SNCInventoryT> sncInvs = sncList.getSncInv();
        String mdNm1 = "";
        String meNm1 = "";
        String pgpNm1 = "";
        // boolean newNode = false;
        boolean newMdInv = true;
        boolean newMlsnInv = true;
        boolean newSncInv = true;
        
        SubnetworkConnectionT  firstManagedElement = (SubnetworkConnectionT) objs.get(0);
        System.out.println("CreateMultiLayerSubNetwork: mdList.size " + getMdList().getMd().size());
        
        if (getMdList().getMd().size() == 0) {
            MDInventoryT firstMdInv = new MDInventoryT();
            firstMdInv.setMdNm(firstManagedElement.getName().getMdNm());
            getMdList().getMd().add(firstMdInv);
        }
        
        // loop through all SubnetworkConnections retrieved
        for (Object o : objs) {
            System.out.println("for objssssssssssssssssssssssssssssssssssssssssss");
            SubnetworkConnectionT  snc = (SubnetworkConnectionT) o;
            // creates the SncInventory
            SNCInventoryT sncInv = new SNCInventoryT();
            sncInv.setSncNm(snc.getName().getSncNm());
            
//            if (granularity.equals("ATTRS"))
//                sncInv.setSncAttrs(ptp);
//            else if (granularity.equals("FULL")) {
//                sncInv.setSncAttrs(ptp);
//                NamingAttributesListT ptpFull = snc.getSncInventoryT().getSupportingEquipList();
//                if (ptpFull != null)
//                    sncInv.setSupportingEquipList(ptpFull);
//            }
//
//            pgpNm1 = snc.getName().getSncNm();
//
            // loop through all existing mdInv
            for (MDInventoryT oldMdInv : getMdList().getMd()) {
                if (oldMdInv.getMdNm().equals(snc.getName().getMdNm())) {
                    // sncInv belongs to this mdInv
                    System.out.println("sncInv belongs to this mdInv");
//                    if (oldMdInv.getMlsnList() == null) {
//                        System.out.println("oldMdInv.getMlsnList() == null");
//                        MlsnList firstMlsnListOfMd = new MlsnList();
//                        MLSNInventoryT firstMlsnInvOfMd = new MLSNInventoryT();
//                        firstMlsnInvOfMd.setMlsnNm(snc.getName().getMlsnNm());
//                        firstMlsnListOfMd.getMlsnInv().add(firstMlsnInvOfMd);
//                        oldMdInv.setMlsnList(firstMlsnListOfMd);
//                    }
                    
                    if (oldMdInv.getMlsnList() != null) {
                        // loop through all existing meInv under this mdInv
                        for (MLSNInventoryT oldMlsnInv : oldMdInv.getMlsnList().getMlsnInv()) {
                            if (oldMlsnInv.getMlsnNm().equals(snc.getName().getMlsnNm())) {
                                //sncInv belongs to this meInv
                                System.out.println("sncInv belongs to this meInv");
                                if (oldMlsnInv.getSncList() != null) {
                                    // sncInv is not the first under this meInv
                                    // loop through all existing sncInv under this meinv
                                    for (SNCInventoryT oldSncInv : oldMlsnInv.getSncList().getSncInv()) {
                                        if (oldSncInv.getSncNm().equals(snc.getName().getSncNm())) {
                                            System.out.println("ptpinv of current ptp already exists");
                                            // ptpinv of current ptp already exists
                                            // (PTP, NAME) has already been treated
                                            //*************************************************
                                            if ((granularity.equals("ATTRS") || granularity.equals("FULL")) && oldSncInv.getSncAttrs() == null) {
                                                // first ME, ATTRS request for this sncInv
                                                oldSncInv.setSncAttrs(snc);
                                            }
                                            //****************************************************
                                            newSncInv = false;
                                            break;
                                        }
                                    } //for oldSncInv
                                    if (newSncInv) {
                                        System.out.println("new ptInv");
                                        // sncInv belongs to a new sncInv
                                        //**************************************
                                        if (granularity.equals("ATTRS") || granularity.equals("FULL")) {
                                            // first ME, ATTRS request for this sncInv
                                            sncInv.setSncAttrs(snc);
                                        }
                                        //**************************************
                                        oldMlsnInv.getSncList().getSncInv().add(sncInv);
                                    }
                                    
                                } else {
                                    // sncInv is the first under this meInv
                                    System.out.println("// sncInv is the first under this meInv");
                                    SncList sncListOldMe = new SncList();
                                    sncListOldMe.getSncInv().add(sncInv);
                                    oldMlsnInv.setSncList(sncListOldMe);
                                }
                                newMlsnInv = false;
                                break;
                            }
                        } // for oldMlsnInv
                        
                        if (newMlsnInv) {
                            // sncInv belongs to a new meInv
                            System.out.println("// sncInv belongs to a new meInv ");
                            MLSNInventoryT meInv = new MLSNInventoryT();
                            SncList sncListUnderNewMe = new SncList();
                            //*********************************************
                            sncInv.setSncNm(snc.getName().getSncNm());
                            if (granularity.equals("ATTRS") || granularity.equals("FULL")) {
                                // first ME, ATTRS request for this sncInv
                                sncInv.setSncAttrs(snc);
                            }
                            //**********************************************
                            sncListUnderNewMe.getSncInv().add(sncInv);
                            meInv.setSncList(sncListUnderNewMe);
                            // Add ManagedElement to ManagementDomain
                            oldMdInv.getMlsnList().getMlsnInv().add(meInv);
                        }
                    } else {
                        // first meInv under this mdInv
                        System.out.println("oldMdInv.getMlsnList() == null");
                        MlsnList firstMlsnListOfMd = new MlsnList();
                        MLSNInventoryT firstMlsnInvOfMd = new MLSNInventoryT();
                        SncList sncListUnderNewMe = new SncList();
                        //**************************************
                        sncInv.setSncNm(snc.getName().getSncNm());
                        if (granularity.equals("ATTRS") || granularity.equals("FULL")) {
                            // first ME, ATTRS request for this sncInv
                            sncInv.setSncAttrs(snc);
                        }
                        //**************************************
                        sncListUnderNewMe.getSncInv().add(sncInv);
                        System.out.println("sncListUnderNewMe.size " + sncListUnderNewMe.getSncInv().size());
                        firstMlsnInvOfMd.setMlsnNm(snc.getName().getMlsnNm());
                        firstMlsnInvOfMd.setSncList(sncListUnderNewMe);
                        firstMlsnListOfMd.getMlsnInv().add(firstMlsnInvOfMd);
                        oldMdInv.setMlsnList(firstMlsnListOfMd);
                    }
                }
                newMdInv = false;
                break;
            } // for oldMdInv
            if (newMdInv) {
                System.out.println("// sncInv belongs to a new mdInv");
                // sncInv belongs to a new mdInv
                MDInventoryT mdInvUnderNewMd = new MDInventoryT();
                mdInvUnderNewMd.setMdNm(snc.getName().getMdNm());
                MlsnList meListUnderNewMd = new MlsnList();
                MLSNInventoryT meInvUnderNewMd = new MLSNInventoryT();
                meInvUnderNewMd.setMlsnNm(snc.getName().getMlsnNm());
                SncList sncListUnderNewMd = new SncList();
                //******************************************************
                sncInv.setSncNm(snc.getName().getSncNm());
                if (granularity.equals("ATTRS") || granularity.equals("FULL")) {
                    // first ME, ATTRS request for this sncInv
                    sncInv.setSncAttrs(snc);
                }
                //******************************************************
                sncListUnderNewMd.getSncInv().add(sncInv);
                meInvUnderNewMd.setSncList(sncListUnderNewMd);
                meListUnderNewMd.getMlsnInv().add(meInvUnderNewMd);
                mdInvUnderNewMd.setMlsnList(meListUnderNewMd);
                
                getMdList().getMd().add(mdInvUnderNewMd);
            }
        } // for objs
        
        // add the new MdList to final response
        refreshMdList(getMdList());
        
        //inventoryData.setMdList(mdList);
        System.out.println("***************fin CreateSubnetworkConnectionResponse*************");
        
        return inventoryData;
    }
    
    public InventoryDataT getInventoryData() {
        
        return inventoryData;
    }
}
