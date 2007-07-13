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
import v1.tmf854.MDInventoryT.MeList;
import v1.tmf854.MEInventoryT.EhList;
import v1.tmf854.SimpleFilterT.IncludedObjectType;
import java.io.*;
import java.util.*;

/**
 *
 * @author baptiste
 */
public class CreateEquipmentResponse extends CreateResponse{
    
    /** Creates a new instance of CreateEquipmentHolderResponse */
    public CreateEquipmentResponse() {
    }
    
    
    public InventoryDataT createResponse(List<?> objs, String granularity) {
        System.out.println("**************CreateEquipmentT:createResponse**************");
        InventoryDataT inventoryData = new InventoryDataT();
        MdList mdList = new MdList();
        List<MDInventoryT> mdInvs = mdList.getMd(); // new mdInv List
        MDInventoryT mdInv = new MDInventoryT();
        MeList meList = new MeList();
        MEInventoryT meInv = new MEInventoryT();
        List<MEInventoryT> meInvs = meList.getMeInv();
        EhList ehList = new EhList();
        List<EHInventoryT> ehInvs = ehList.getEhInv();
        ListIterator<EHInventoryT> litEh = ehInvs.listIterator();
        EquipmentHolderT previousEh = null;
        String previousMeNm = null;
        String previousMdNm = null;
        boolean newNode = false;
        EquipmentHolderT eh = null;
        String mdNm1 = "";
        String meNm1 = "";
        String ehNm1 = "";
        String eqNm1 ="";
        
        for (Object o : objs) {
            EquipmentT  eq = (EquipmentT) o;
            EQInventoryT eqInv = new EQInventoryT();
            EHInventoryT ehInv = new EHInventoryT();
            mdNm1 = eq.getName().getMdNm();
            meNm1 = eq.getName().getMeNm();
            ehNm1 = eq.getName().getEhNm();
            eqNm1 = eq.getName().getEqNm();
            if (granularity.equals("ATTRS"))
                eqInv.setEqAttrs(eq);
            eqInv.setEqNm(eqNm1);
            ehInv.setEhNm(ehNm1);
            ehInv.setEqInv(eqInv);
            ehInvs.add(ehInv);
        }//for
        
        
        
        
        
//             (previousEh != null) {
//                System.out.println("meNm " + meNm1 + "previousMeNm " + previousMeNm);
//                if(!(meNm1.equals(previousMeNm)) && (mdNm1.equals(previousMdNm))) {
//                    System.out.println("Change Me!!!!!!!!!!!!!!!!");
//                    previousEh.setName(null);
//                    // previousEh.setIdEh(null);
//                    newNode = true;
//                    //System.out.println("eh belongs to another me");
//                    //eh belongs to another me
//                    meInv.setEhList(ehList);
//                    meInv.setMeNm(previousMeNm);
//                    meInvs.add(meInv);
//                    meInv = new MEInventoryT();
//                    ehList = new EhList();
//                    ehInvs = ehList.getEhInv();
//                    litEh = ehInvs.listIterator();
//                }//change me
//                if (!mdNm1.equals(previousMdNm)) {
//                    System.out.println("Change Md!!!!!!!!!!!!!!!!");
//                    //eh belongs to another md
//                    previousEh.setName(null);
//                    // previousEh.setIdEh(null);
//                    newNode = true;
//                    //System.out.println("eh belongs to another me");
//                    //eh belongs to another me
//                    meInv.setEhList(ehList);
//                    meInv.setMeNm(previousMeNm);
//                    meInvs.add(meInv);
//                    mdInv.setMeList(meList);
//                    mdInv.setMdNm(previousMdNm);
//                    mdInvs.add(mdInv);
//                    ehList = new EhList();
//                    ehInvs = ehList.getEhInv();
//                    litEh = ehInvs.listIterator();
//                    meInv = new MEInventoryT();
//                    meList = new MeList();
//                    meInvs = meList.getMeInv();
//                    mdInv = new MDInventoryT();
//                }// change md
//            }
//
        meInv.setEhList(ehList);
        meInv.setMeNm(meNm1);
        meInvs.add(meInv);
        mdInv.setMeList(meList);
        mdInv.setMdNm(mdNm1);
        mdInvs.add(mdInv);
        
        inventoryData.setMdList(mdList);
        return inventoryData;
        
    }
    
    public InventoryDataT createResponse2(List<?> objs, String granularity) {
        System.out.println("**************CreateEquipmentHolderResponse:createResponse2**************");
        System.out.println("objs.size " + objs.size());
        System.out.println("a: " + super.getA());
        
        //MDInventoryT mdInv = new MDInventoryT();
        EhList ehList = new EhList();
        List<EHInventoryT> ehInvs = ehList.getEhInv();
        ListIterator<EHInventoryT> litMe = ehInvs.listIterator();
        EquipmentHolderT previousMe = null;
        String previousMdNm = null;
        String mdNm1 = "";
        String meNm1 = "";
        String ehNm1 = "";
        String eqNm1 ="";
        // boolean newNode = false;
        boolean newMdInv = true;
        boolean newMeInv = true;
        
        EquipmentT  firstManagedElement = (EquipmentT) objs.get(0);
        
        if (getMdList().getMd().size() == 0) {
            MDInventoryT firstMdInv = new MDInventoryT();
            firstMdInv.setMdNm(firstManagedElement.getName().getMdNm());
            getMdList().getMd().add(firstMdInv);
        }
        
        // loop through all EquipmentHolders retrieved
        for (Object o : objs) {
            EquipmentT  eq = (EquipmentT) o;
            // creates the EqInventory
            EQInventoryT eqInv = new EQInventoryT();
            EHInventoryT ehInv = new EHInventoryT();
            mdNm1 = eq.getName().getMdNm();
            meNm1 = eq.getName().getMeNm();
            ehNm1 = eq.getName().getEhNm();
            eqNm1 = eq.getName().getEqNm();
            if (granularity.equals("ATTRS"))
                eqInv.setEqAttrs(eq);
            eqInv.setEqNm(eqNm1);
            ehInv.setEhNm(ehNm1);
            ehInv.setEqInv(eqInv);
            ehInvs.add(ehInv);
            
            //
            
            // loop through all existing ManagementDomains
            for (MDInventoryT oldMdInv : getMdList().getMd()) {
                if (oldMdInv.getMdNm().equals(eq.getName().getMdNm())) {
                    // EquipmentHolder belongs to this ManagementDomain
                    if (oldMdInv.getMeList() == null) {
                        MeList firstMeListOfMd = new MeList();
                        MEInventoryT firstMeInvOfMd = new MEInventoryT();
                        firstMeInvOfMd.setMeNm(eq.getName().getMeNm());
                        firstMeListOfMd.getMeInv().add(firstMeInvOfMd);
                        oldMdInv.setMeList(firstMeListOfMd);
                    }
                    // loop through all existing ManagedElements
                    for (MEInventoryT oldMeInv : oldMdInv.getMeList().getMeInv()) {
                        if (oldMeInv.getMeNm().equals(eq.getName().getMeNm())) {
                            //EquipmentHolder belongs to this ManagedElement
                            if (oldMeInv.getEhList() != null) {
                                // EqipmentHolder is not the first under this ManagedElement
                                oldMeInv.getEhList().getEhInv().add(ehInv);
                            } else {
                                // EquipmentHolder is the first under this ManagedElement
                                EhList ehListOldMe = new EhList();
                                ehListOldMe.getEhInv().add(ehInv);
                                oldMeInv.setEhList(ehListOldMe);
                            }
                            newMeInv = false;
                            break;
                        }
                        if (newMeInv) {
                            // EquipmentHolder belongs to a new ManagedElement
                            MEInventoryT meInv = new MEInventoryT();
                            EhList ehListUnderNewMe = new EhList();
                            ehListUnderNewMe.getEhInv().add(ehInv);
                            meInv.setEhList(ehList);
                            // Add ManagedElement to ManagementDomain
                            oldMdInv.getMeList().getMeInv().add(meInv);
                        }
                    } // for me
                    newMdInv = false;
                    break;
                }
                if (newMdInv) {
                    // EquipmentHolder belongs to a new ManagedElement and a new ManagementDomain
                    MDInventoryT mdInvUnderNewMd = new MDInventoryT();
                    mdInvUnderNewMd.setMdNm(eq.getName().getMdNm());
                    MeList meListUnderNewMd = new MeList();
                    MEInventoryT meInvUnderNewMd = new MEInventoryT();
                    meInvUnderNewMd.setMeNm(eq.getName().getMeNm());
                    EhList ehListUnderNewMd = new EhList();
                    ehListUnderNewMd.getEhInv().add(ehInv);
                    meInvUnderNewMd.setEhList(ehList);
                    meListUnderNewMd.getMeInv().add(meInvUnderNewMd);
                    mdInvUnderNewMd.setMeList(meListUnderNewMd);
                    
                    getMdList().getMd().add(mdInvUnderNewMd);
                }
            } // for md
        } // for objs
        // add the new MdList to final response
        refreshMdList(getMdList());
        
        //inventoryData.setMdList(mdList);
        System.out.println("***************fin CreateEquipmentHolderResponse*************");
        
        return inventoryData;
    }
}


