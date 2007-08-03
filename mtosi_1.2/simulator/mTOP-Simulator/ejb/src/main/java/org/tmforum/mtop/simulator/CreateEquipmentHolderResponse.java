/*
 * CreateEquipmentHolderResponse.java
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
import v1.tmf854.MEInventoryT.EhList;
//import org.tmforum.mtop.simulator.entity.managedinventories.MDInventoryT.MeList;
//import org.tmforum.mtop.simulator.entity.managedinventories.*;
//import org.tmforum.mtop.simulator.entity.managedinventories.EHInventoryT.CtpList;
//import org.tmforum.mtop.simulator.entity.managedinventories.MEInventoryT.EhList;
import v1.tmf854.SimpleFilterT.IncludedObjectType;

//import org.tmforum.mtop.simulator.entity.managedentities.*;


/**
 *
 * @author baptiste
 */
public class CreateEquipmentHolderResponse extends CreateGetInventoryResponse {
    
    /** Creates a new instance of CreateEquipmentHolderResponse */
    public CreateEquipmentHolderResponse() {
    }
    
     public InventoryDataT createResponse(List<?> objs, String granularity) {
        System.out.println("**************CreateEquipmentHolderResponse:createResponse2**************");
        EhList ehList = new EhList();
        List<EHInventoryT> ehInvs = ehList.getEhInv();
        String mdNm1 = "";
        String meNm1 = "";
        String pgpNm1 = "";
        // boolean newNode = false;
        boolean newMdInv = true;
        boolean newMeInv = true;
        boolean newEhInv = true;
        
        EquipmentHolderT  firstManagedElement = (EquipmentHolderT) objs.get(0);
        System.out.println("CreateMultiLayerSubNetwork: mdList.size " + getMdList().getMd().size());
        
        if (getMdList().getMd().size() == 0) {
            MDInventoryT firstMdInv = new MDInventoryT();
            firstMdInv.setMdNm(firstManagedElement.getName().getMdNm());
            getMdList().getMd().add(firstMdInv);
        }
        
        // loop through all EquipmentHolders retrieved
        for (Object o : objs) {
            System.out.println("for objssssssssssssssssssssssssssssssssssssssssss");
            EquipmentHolderT eh = (EquipmentHolderT) o;
            // creates the EhInventory
            EHInventoryT ehInv = new EHInventoryT();
            ehInv.setEhNm(eh.getName().getEhNm());
            
//            if (granularity.equals("ATTRS"))
//                ehInv.setEhAttrs(ptp);
//            else if (granularity.equals("FULL")) {
//                ehInv.setEhAttrs(ptp);
//                NamingAttributesListT ptpFull = eh.getEhInventoryT().getSupportingEquipList();
//                if (ptpFull != null)
//                    ehInv.setSupportingEquipList(ptpFull);
//            }
//
//            pgpNm1 = eh.getName().getEhNm();
//
            // loop through all existing mdInv
            for (MDInventoryT oldMdInv : getMdList().getMd()) {
                if (oldMdInv.getMdNm().equals(eh.getName().getMdNm())) {
                    // ehInv belongs to this mdInv
                    System.out.println("ehInv belongs to this mdInv");
//                    if (oldMdInv.getMeList() == null) {
//                        System.out.println("oldMdInv.getMeList() == null");
//                        MeList firstMeListOfMd = new MeList();
//                        MEInventoryT firstMeInvOfMd = new MEInventoryT();
//                        firstMeInvOfMd.setMeNm(eh.getName().getMeNm());
//                        firstMeListOfMd.getMeInv().add(firstMeInvOfMd);
//                        oldMdInv.setMeList(firstMeListOfMd);
//                    }
                    
                    if (oldMdInv.getMeList() != null) {
                        // loop through all existing meInv under this mdInv
                        for (MEInventoryT oldMeInv : oldMdInv.getMeList().getMeInv()) {
                            if (oldMeInv.getMeNm().equals(eh.getName().getMeNm())) {
                                //ehInv belongs to this meInv
                                System.out.println("ehInv belongs to this meInv");
                                if (oldMeInv.getEhList() != null) {
                                    // ehInv is not the first under this meInv
                                    // loop through all existing ehInv under this meinv
                                    for (EHInventoryT oldEhInv : oldMeInv.getEhList().getEhInv()) {
                                        if (oldEhInv.getEhNm().equals(eh.getName().getEhNm())) {
                                            System.out.println("ptpinv of current ptp already exists");
                                            // ehInv of current eh already exists
                                            // (EH, NAME) has already been treated
                                            //*************************************************
                                            if ((granularity.equals("ATTRS") || granularity.equals("FULL")) && oldEhInv.getEhAttrs() == null) {
                                                // first ME, ATTRS request for this ehInv
                                                oldEhInv.setEhAttrs(eh);
                                            }
                                            //****************************************************
                                            newEhInv = false;
                                            break;
                                        }
                                    } //for oldEhInv
                                    if (newEhInv) {
                                        System.out.println("new ptInv");
                                        // ehInv belongs to a new ehInv
                                        //**************************************
                                        if (granularity.equals("ATTRS") || granularity.equals("FULL")) {
                                            // first ME, ATTRS request for this ehInv
                                            ehInv.setEhAttrs(eh);
                                        }
                                        //**************************************
                                        oldMeInv.getEhList().getEhInv().add(ehInv);
                                    }
                                    
                                } else {
                                    // ehInv is the first under this meInv
                                    System.out.println("// ehInv is the first under this meInv");
                                    EhList ehListOldMe = new EhList();
                                    ehListOldMe.getEhInv().add(ehInv);
                                    oldMeInv.setEhList(ehListOldMe);
                                }
                                newMeInv = false;
                                break;
                            }
                        } // for oldMeInv
                        
                        if (newMeInv) {
                            // ehInv belongs to a new meInv
                            System.out.println("// ehInv belongs to a new meInv ");
                            MEInventoryT meInv = new MEInventoryT();
                            EhList ehListUnderNewMe = new EhList();
                            //*********************************************
                            ehInv.setEhNm(eh.getName().getEhNm());
                            if (granularity.equals("ATTRS") || granularity.equals("FULL")) {
                                // first ME, ATTRS request for this ehInv
                                ehInv.setEhAttrs(eh);
                            }
                            //**********************************************
                            ehListUnderNewMe.getEhInv().add(ehInv);
                            meInv.setEhList(ehListUnderNewMe);
                            // Add ManagedElement to ManagementDomain
                            oldMdInv.getMeList().getMeInv().add(meInv);
                        }
                    } else {
                        // first meInv under this mdInv
                        System.out.println("oldMdInv.getMeList() == null");
                        MeList firstMeListOfMd = new MeList();
                        MEInventoryT firstMeInvOfMd = new MEInventoryT();
                        EhList ehListUnderNewMe = new EhList();
                        //**************************************
                        ehInv.setEhNm(eh.getName().getEhNm());
                        if (granularity.equals("ATTRS") || granularity.equals("FULL")) {
                            // first ME, ATTRS request for this ehInv
                            ehInv.setEhAttrs(eh);
                        }
                        //**************************************
                        ehListUnderNewMe.getEhInv().add(ehInv);
                        System.out.println("ehListUnderNewMe.size " + ehListUnderNewMe.getEhInv().size());
                        firstMeInvOfMd.setMeNm(eh.getName().getMeNm());
                        firstMeInvOfMd.setEhList(ehListUnderNewMe);
                        firstMeListOfMd.getMeInv().add(firstMeInvOfMd);
                        oldMdInv.setMeList(firstMeListOfMd);
                    }
                }
                newMdInv = false;
                break;
            } // for oldMdInv
            if (newMdInv) {
                System.out.println("// ehInv belongs to a new mdInv");
                // ehInv belongs to a new mdInv
                MDInventoryT mdInvUnderNewMd = new MDInventoryT();
                mdInvUnderNewMd.setMdNm(eh.getName().getMdNm());
                MeList meListUnderNewMd = new MeList();
                MEInventoryT meInvUnderNewMd = new MEInventoryT();
                meInvUnderNewMd.setMeNm(eh.getName().getMeNm());
                EhList ehListUnderNewMd = new EhList();
                //******************************************************
                ehInv.setEhNm(eh.getName().getEhNm());
                if (granularity.equals("ATTRS") || granularity.equals("FULL")) {
                    // first ME, ATTRS request for this ehInv
                    ehInv.setEhAttrs(eh);
                }
                //******************************************************
                ehListUnderNewMd.getEhInv().add(ehInv);
                meInvUnderNewMd.setEhList(ehListUnderNewMd);
                meListUnderNewMd.getMeInv().add(meInvUnderNewMd);
                mdInvUnderNewMd.setMeList(meListUnderNewMd);
                
                getMdList().getMd().add(mdInvUnderNewMd);
            }
        } // for objs
        
        // add the new MdList to final response
        refreshMdList(getMdList());
        
        //inventoryData.setMdList(mdList);
        System.out.println("***************fin CreateEquipmentHolderResponse*************");
        
        return inventoryData;
    }
    
    public InventoryDataT getInventoryData() {
        
        return inventoryData;
    }
}
