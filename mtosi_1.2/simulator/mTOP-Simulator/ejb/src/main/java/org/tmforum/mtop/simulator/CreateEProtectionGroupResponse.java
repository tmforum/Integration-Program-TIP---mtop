/*
 * CreateEProtectionGroupResponse.java
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
import v1.tmf854.MEInventoryT.EpgpList;
//import org.tmforum.mtop.simulator.entity.managedinventories.MDInventoryT.MeList;
//import org.tmforum.mtop.simulator.entity.managedinventories.*;
//import org.tmforum.mtop.simulator.entity.managedinventories.EPGPInventoryT.CtpList;
//import org.tmforum.mtop.simulator.entity.managedinventories.MEInventoryT.EpgpList;
import v1.tmf854.SimpleFilterT.IncludedObjectType;

//import org.tmforum.mtop.simulator.entity.managedentities.*;


/**
 *
 * @author baptiste
 */
public class CreateEProtectionGroupResponse extends CreateGetInventoryResponse {
    
    /** Creates a new instance of CreateEProtectionGroupResponse */
    public CreateEProtectionGroupResponse() {
    }
    
    public InventoryDataT createResponse(List<?> objs, String granularity) {
        System.out.println("**************CreateEProtectionGroupResponse:createResponse2**************");
        EpgpList epgpList = new EpgpList();
        List<EPGPInventoryT> epgpInvs = epgpList.getEpgpInv();
        String mdNm1 = "";
        String meNm1 = "";
        String epgpNm1 = "";
        // boolean newNode = false;
        boolean newMdInv = true;
        boolean newMeInv = true;
        boolean newEpgpInv = true;
        
        EProtectionGroupT  firstManagedElement = (EProtectionGroupT) objs.get(0);
        System.out.println("CreateMultiLayerSubNetwork: mdList.size " + getMdList().getMd().size());
        
        if (getMdList().getMd().size() == 0) {
            MDInventoryT firstMdInv = new MDInventoryT();
            firstMdInv.setMdNm(firstManagedElement.getName().getMdNm());
            getMdList().getMd().add(firstMdInv);
        }
        
        // loop through all EProtectionGroups retrieved
        for (Object o : objs) {
            System.out.println("for objssssssssssssssssssssssssssssssssssssssssss");
            EProtectionGroupT  epgp = (EProtectionGroupT) o;
            // creates the EpgpInventory
            EPGPInventoryT epgpInv = new EPGPInventoryT();
            epgpInv.setEpgpNm(epgp.getName().getEpgpNm());
            
//            if (granularity.equals("ATTRS"))
//                epgpInv.setEpgpAttrs(ptp);
//            else if (granularity.equals("FULL")) {
//                epgpInv.setEpgpAttrs(ptp);
//                NamingAttributesListT ptpFull = eepgp.getEpgpInventoryT().getSupportingEquipList();
//                if (ptpFull != null)
//                    epgpInv.setSupportingEquipList(ptpFull);
//            }
//
//            epgpNm1 = eepgp.getName().getEpgpNm();
//
            // loop through all existing mdInv
            for (MDInventoryT oldMdInv : getMdList().getMd()) {
                if (oldMdInv.getMdNm().equals(epgp.getName().getMdNm())) {
                    // epgpInv belongs to this mdInv
                    System.out.println("epgpInv belongs to this mdInv");
//                    if (oldMdInv.getMeList() == null) {
//                        System.out.println("oldMdInv.getMeList() == null");
//                        MeList firstMeListOfMd = new MeList();
//                        MEInventoryT firstMeInvOfMd = new MEInventoryT();
//                        firstMeInvOfMd.setMeNm(eepgp.getName().getMeNm());
//                        firstMeListOfMd.getMeInv().add(firstMeInvOfMd);
//                        oldMdInv.setMeList(firstMeListOfMd);
//                    }
                    
                    if (oldMdInv.getMeList() != null) {
                        // loop through all existing meInv under this mdInv
                        for (MEInventoryT oldMeInv : oldMdInv.getMeList().getMeInv()) {
                            if (oldMeInv.getMeNm().equals(epgp.getName().getMeNm())) {
                                //epgpInv belongs to this meInv
                                System.out.println("epgpInv belongs to this meInv");
                                if (oldMeInv.getEpgpList() != null) {
                                    // epgpInv is not the first under this meInv
                                    // loop through all existing epgpInv under this meinv
                                    for (EPGPInventoryT oldEpgpInv : oldMeInv.getEpgpList().getEpgpInv()) {
                                        if (oldEpgpInv.getEpgpNm().equals(epgp.getName().getEpgpNm())) {
                                            System.out.println("ptpinv of current ptp already exists");
                                            // ptpinv of current ptp already exists
                                            // (PTP, NAME) has already been treated
                                            //*************************************************
                                            if ((granularity.equals("ATTRS") || granularity.equals("FULL")) && oldEpgpInv.getEpgpAttrs() == null) {
                                                // first ME, ATTRS request for this epgpInv
                                                oldEpgpInv.setEpgpAttrs(epgp);
                                            }
                                            //****************************************************
                                            newEpgpInv = false;
                                            break;
                                        }
                                    } //for oldEpgpInv
                                    if (newEpgpInv) {
                                        System.out.println("new ptInv");
                                        // epgpInv belongs to a new epgpInv
                                        //**************************************
                                        if (granularity.equals("ATTRS") || granularity.equals("FULL")) {
                                            // first ME, ATTRS request for this epgpInv
                                            epgpInv.setEpgpAttrs(epgp);
                                        }
                                        //**************************************
                                        oldMeInv.getEpgpList().getEpgpInv().add(epgpInv);
                                    }
                                    
                                } else {
                                    // epgpInv is the first under this meInv
                                    System.out.println("// epgpInv is the first under this meInv");
                                    EpgpList epgpListOldMe = new EpgpList();
                                    epgpListOldMe.getEpgpInv().add(epgpInv);
                                    oldMeInv.setEpgpList(epgpListOldMe);
                                }
                                newMeInv = false;
                                break;
                            }
                        } // for oldMeInv
                        
                        if (newMeInv) {
                            // epgpInv belongs to a new meInv
                            System.out.println("// epgpInv belongs to a new meInv ");
                            MEInventoryT meInv = new MEInventoryT();
                            EpgpList epgpListUnderNewMe = new EpgpList();
                            //*********************************************
                            epgpInv.setEpgpNm(epgp.getName().getEpgpNm());
                            if (granularity.equals("ATTRS") || granularity.equals("FULL")) {
                                // first ME, ATTRS request for this epgpInv
                                epgpInv.setEpgpAttrs(epgp);
                            }
                            //**********************************************
                            epgpListUnderNewMe.getEpgpInv().add(epgpInv);
                            meInv.setEpgpList(epgpListUnderNewMe);
                            // Add ManagedElement to ManagementDomain
                            oldMdInv.getMeList().getMeInv().add(meInv);
                        }
                    } else {
                        // first meInv under this mdInv
                        System.out.println("oldMdInv.getMeList() == null");
                        MeList firstMeListOfMd = new MeList();
                        MEInventoryT firstMeInvOfMd = new MEInventoryT();
                        EpgpList epgpListUnderNewMe = new EpgpList();
                        //**************************************
                        epgpInv.setEpgpNm(epgp.getName().getEpgpNm());
                        if (granularity.equals("ATTRS") || granularity.equals("FULL")) {
                            // first ME, ATTRS request for this epgpInv
                            epgpInv.setEpgpAttrs(epgp);
                        }
                        //**************************************
                        epgpListUnderNewMe.getEpgpInv().add(epgpInv);
                        System.out.println("epgpListUnderNewMe.size " + epgpListUnderNewMe.getEpgpInv().size());
                        firstMeInvOfMd.setMeNm(epgp.getName().getMeNm());
                        firstMeInvOfMd.setEpgpList(epgpListUnderNewMe);
                        firstMeListOfMd.getMeInv().add(firstMeInvOfMd);
                        oldMdInv.setMeList(firstMeListOfMd);
                    }
                }
                newMdInv = false;
                break;
            } // for oldMdInv
            if (newMdInv) {
                System.out.println("// epgpInv belongs to a new mdInv");
                // epgpInv belongs to a new mdInv
                MDInventoryT mdInvUnderNewMd = new MDInventoryT();
                mdInvUnderNewMd.setMdNm(epgp.getName().getMdNm());
                MeList meListUnderNewMd = new MeList();
                MEInventoryT meInvUnderNewMd = new MEInventoryT();
                meInvUnderNewMd.setMeNm(epgp.getName().getMeNm());
                EpgpList epgpListUnderNewMd = new EpgpList();
                //******************************************************
                epgpInv.setEpgpNm(epgp.getName().getEpgpNm());
                if (granularity.equals("ATTRS") || granularity.equals("FULL")) {
                    // first ME, ATTRS request for this epgpInv
                    epgpInv.setEpgpAttrs(epgp);
                }
                //******************************************************
                epgpListUnderNewMd.getEpgpInv().add(epgpInv);
                meInvUnderNewMd.setEpgpList(epgpListUnderNewMd);
                meListUnderNewMd.getMeInv().add(meInvUnderNewMd);
                mdInvUnderNewMd.setMeList(meListUnderNewMd);
                
                getMdList().getMd().add(mdInvUnderNewMd);
            }
        } // for objs
        
        // add the new MdList to final response
        refreshMdList(getMdList());
        
        //inventoryData.setMdList(mdList);
        System.out.println("***************fin CreateEProtectionGroupResponse*************");
        
        return inventoryData;
    }
    
    public InventoryDataT getInventoryData() {
        
        return inventoryData;
    }
}
