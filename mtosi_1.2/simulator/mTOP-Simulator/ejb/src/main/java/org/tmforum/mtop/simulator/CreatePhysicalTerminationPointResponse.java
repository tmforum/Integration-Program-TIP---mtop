/*
 * CreatePhysicalTerminationPointResponse.java
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
import v1.tmf854.MDInventoryT.MeList;
import v1.tmf854.PTPInventoryT.CtpList;
import v1.tmf854.MEInventoryT.PtpList;
//import org.tmforum.mtop.simulator.entity.managedinventories.MDInventoryT.MeList;
//import org.tmforum.mtop.simulator.entity.managedinventories.*;
//import org.tmforum.mtop.simulator.entity.managedinventories.PTPInventoryT.CtpList;
//import org.tmforum.mtop.simulator.entity.managedinventories.MEInventoryT.PtpList;
import v1.tmf854.SimpleFilterT.IncludedObjectType;

//import org.tmforum.mtop.simulator.entity.managedentities.*;


/**
 *
 * @author baptiste
 */
public class CreatePhysicalTerminationPointResponse extends CreateGetInventoryResponse {
    
    /** Creates a new instance of CreatePhysicalTerminationPointResponse */
    public CreatePhysicalTerminationPointResponse() {
    }
    
    public InventoryDataT createResponse(List<?> objs, String granularity) {
        System.out.println("**************CreatePhysicalTerminationPointResponse:createResponse2**************");
        PtpList ptpList = new PtpList();
        List<PTPInventoryT> ptpInvs = ptpList.getPtpInv();
        String mdNm1 = "";
        String meNm1 = "";
        String ptpNm1 = "";
        // boolean newNode = false;
        boolean newMdInv = true;
        boolean newMeInv = true;
        boolean newPtpInv = true;
        
        PhysicalTerminationPointT  firstManagedElement = (PhysicalTerminationPointT) objs.get(0);
        System.out.println("CreateMultiLayerSubNetwork: mdList.size " + getMdList().getMd().size());
        
        if (getMdList().getMd().size() == 0) {
            MDInventoryT firstMdInv = new MDInventoryT();
            firstMdInv.setMdNm(firstManagedElement.getName().getMdNm());
            getMdList().getMd().add(firstMdInv);
        }
        
        // loop through all PhysicalTerminationPoints retrieved
        for (Object o : objs) {
            System.out.println("for objssssssssssssssssssssssssssssssssssssssssss");
            PhysicalTerminationPointT  ptp = (PhysicalTerminationPointT) o;
            // creates the PtpInventory
            PTPInventoryT ptpInv = new PTPInventoryT();
            ptpInv.setPtpNm(ptp.getName().getPtpNm());
            
//            if (granularity.equals("ATTRS"))
//                ptpInv.setPtpAttrs(ptp);
//            else if (granularity.equals("FULL")) {
//                ptpInv.setPtpAttrs(ptp);
//                NamingAttributesListT ptpFull = ptp.getPtpInventoryT().getSupportingEquipList();
//                if (ptpFull != null)
//                    ptpInv.setSupportingEquipList(ptpFull);
//            }
//
//            ptpNm1 = ptp.getName().getPtpNm();
//
            // loop through all existing mdInv
            for (MDInventoryT oldMdInv : getMdList().getMd()) {
                if (oldMdInv.getMdNm().equals(ptp.getName().getMdNm())) {
                    // ptpInv belongs to this mdInv
                    System.out.println("ptpInv belongs to this mdInv");
//                    if (oldMdInv.getMeList() == null) {
//                        System.out.println("oldMdInv.getMeList() == null");
//                        MeList firstMeListOfMd = new MeList();
//                        MEInventoryT firstMeInvOfMd = new MEInventoryT();
//                        firstMeInvOfMd.setMeNm(ptp.getName().getMeNm());
//                        firstMeListOfMd.getMeInv().add(firstMeInvOfMd);
//                        oldMdInv.setMeList(firstMeListOfMd);
//                    }
                    
                    if (oldMdInv.getMeList() != null) {
                        // loop through all existing meInv under this mdInv
                        for (MEInventoryT oldMeInv : oldMdInv.getMeList().getMeInv()) {
                            if (oldMeInv.getMeNm().equals(ptp.getName().getMeNm())) {
                                //ptpInv belongs to this meInv
                                System.out.println("ptpInv belongs to this meInv");
                                if (oldMeInv.getPtpList() != null) {
                                    // ptpInv is not the first under this meInv
                                    // loop through all existing ptpInv under this meinv
                                    for (PTPInventoryT oldPtpInv : oldMeInv.getPtpList().getPtpInv()) {
                                        if (oldPtpInv.getPtpNm().equals(ptp.getName().getPtpNm())) {
                                            System.out.println("ptpinv of current ptp already exists");
                                            // ptpinv of current ptp already exists
                                            // (PTP, NAME) has already been treated
                                            //*************************************************
                                            if (granularity.equals("ATTRS") && oldPtpInv.getPtpAttrs() == null) {
                                                // first ME, ATTRS request for this ptpInv
                                                oldPtpInv.setPtpAttrs(ptp);
                                            } else if (granularity.equals("FULL") && oldPtpInv.getSupportingEquipList() == null) {
                                                // first PTP, FULL request for this ptpInv
                                                oldPtpInv.setPtpAttrs(ptp);
                                                NamingAttributesListT ptpFull = ptp.getPtpInventoryT().getSupportingEquipList();
                                                if (ptpFull != null)
                                                    oldPtpInv.setSupportingEquipList(ptpFull);
                                            }
                                            //****************************************************
                                            newPtpInv = false;
                                            break;
                                        }
                                    } //for oldPtpInv
                                    if (newPtpInv) {
                                        System.out.println("new ptInv");
                                        // ptpInv belongs to a new ptpInv
                                        //**************************************
                                        if (granularity.equals("ATTRS")) {
                                            // first ME, ATTRS request for this ptpInv
                                            ptpInv.setPtpAttrs(ptp);
                                        } else if (granularity.equals("FULL")){
                                            // first PTP, FULL request for this ptpInv
                                            ptpInv.setPtpAttrs(ptp);
                                            NamingAttributesListT ptpFull = ptp.getPtpInventoryT().getSupportingEquipList();
                                            if (ptpFull != null)
                                                ptpInv.setSupportingEquipList(ptpFull);
                                        }
                                        //**************************************
                                        oldMeInv.getPtpList().getPtpInv().add(ptpInv);
                                    }
                                    
                                } else {
                                    // ptpInv is the first under this meInv
                                    System.out.println("// ptpInv is the first under this meInv");
                                    PtpList ptpListOldMe = new PtpList();
                                    ptpListOldMe.getPtpInv().add(ptpInv);
                                    oldMeInv.setPtpList(ptpListOldMe);
                                }
                                newMeInv = false;
                                break;
                            }
                        } // for oldMeInv
                      
                        if (newMeInv) {
                            // ptpInv belongs to a new meInv
                            System.out.println("// ptpInv belongs to a new meInv ");
                            MEInventoryT meInv = new MEInventoryT();
                            PtpList ptpListUnderNewMe = new PtpList();
                            //*********************************************
                            ptpInv.setPtpNm(ptp.getName().getPtpNm());
                            if (granularity.equals("ATTRS")) {
                                // first ME, ATTRS request for this ptpInv
                                ptpInv.setPtpAttrs(ptp);
                            } else if (granularity.equals("FULL")) {
                                ptpInv.setPtpAttrs(ptp);
                                NamingAttributesListT ptpFull = ptp.getPtpInventoryT().getSupportingEquipList();
                                if (ptpFull != null)
                                    ptpInv.setSupportingEquipList(ptpFull);
                            }
                            //**********************************************
                            ptpListUnderNewMe.getPtpInv().add(ptpInv);
                            meInv.setPtpList(ptpListUnderNewMe);
                            // Add ManagedElement to ManagementDomain
                            oldMdInv.getMeList().getMeInv().add(meInv);
                        }
                    } else {
                        // first meInv under this mdInv
                        System.out.println("oldMdInv.getMeList() == null");
                        MeList firstMeListOfMd = new MeList();
                        MEInventoryT firstMeInvOfMd = new MEInventoryT();
                        PtpList ptpListUnderNewMe = new PtpList();
                        //**************************************
                        ptpInv.setPtpNm(ptp.getName().getPtpNm());
                        if (granularity.equals("ATTRS")) {
                            // first ME, ATTRS request for this ptpInv
                            ptpInv.setPtpAttrs(ptp);
                        } else if (granularity.equals("FULL")){
                            // first PTP, FULL request for this ptpInv
                            ptpInv.setPtpAttrs(ptp);
                            NamingAttributesListT ptpFull = ptp.getPtpInventoryT().getSupportingEquipList();
                            if (ptpFull != null)
                                ptpInv.setSupportingEquipList(ptpFull);
                        }
                        //**************************************
                        ptpListUnderNewMe.getPtpInv().add(ptpInv);
                        System.out.println("ptpListUnderNewMe.size " + ptpListUnderNewMe.getPtpInv().size());
                        firstMeInvOfMd.setMeNm(ptp.getName().getMeNm());
                        firstMeInvOfMd.setPtpList(ptpListUnderNewMe);
                        firstMeListOfMd.getMeInv().add(firstMeInvOfMd);
                        oldMdInv.setMeList(firstMeListOfMd);
                    }
                }
                newMdInv = false;
                break;
            } // for oldMdInv
            if (newMdInv) {
                System.out.println("// ptpInv belongs to a new mdInv");
                // ptpInv belongs to a new mdInv
                MDInventoryT mdInvUnderNewMd = new MDInventoryT();
                mdInvUnderNewMd.setMdNm(ptp.getName().getMdNm());
                MeList meListUnderNewMd = new MeList();
                MEInventoryT meInvUnderNewMd = new MEInventoryT();
                meInvUnderNewMd.setMeNm(ptp.getName().getMeNm());
                PtpList ptpListUnderNewMd = new PtpList();
                //******************************************************
                ptpInv.setPtpNm(ptp.getName().getPtpNm());
                if (granularity.equals("ATTRS")) {
                    // first ME, ATTRS request for this ptpInv
                    ptpInv.setPtpAttrs(ptp);
                } else if (granularity.equals("FULL")) {
                    ptpInv.setPtpAttrs(ptp);
                    NamingAttributesListT ptpFull = ptp.getPtpInventoryT().getSupportingEquipList();
                    if (ptpFull != null)
                        ptpInv.setSupportingEquipList(ptpFull);
                }
                //******************************************************
                ptpListUnderNewMd.getPtpInv().add(ptpInv);
                meInvUnderNewMd.setPtpList(ptpListUnderNewMd);
                meListUnderNewMd.getMeInv().add(meInvUnderNewMd);
                mdInvUnderNewMd.setMeList(meListUnderNewMd);
                
                getMdList().getMd().add(mdInvUnderNewMd);
            }
        } // for objs
        
        // add the new MdList to final response
        refreshMdList(getMdList());
        
        //inventoryData.setMdList(mdList);
        System.out.println("***************fin CreatePhysicalTerminationPointResponse*************");
        
        return inventoryData;
    }
    
    public InventoryDataT getInventoryData() {
        
        return inventoryData;
    }
}
