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
import v1.tmf854.SimpleFilterT.IncludedObjectType;
import v1.tmf854.InventoryDataT.MdList;
import v1.tmf854.MDInventoryT.MeList;
//import org.tmforum.mtop.simulator.entity.managedinventories.*;
//import org.tmforum.mtop.simulator.entity.managedinventories.MDInventoryT.MeList;
//import org.tmforum.mtop.simulator.entity.managedentities.*;

/**
 *
 * @author baptiste
 */
public class CreateManagedElementResponse extends CreateGetInventoryResponse {
    
    /** Creates a new instance of CreateEquipmentHolderResponse */
    public CreateManagedElementResponse() {
    }
    
    public InventoryDataT createResponse(List<?> objs, String granularity) {
        System.out.println("**************CreateManagedElementResponse:createResponse**************");
        System.out.println("objs.size " + objs.size());
        MeList meList = new MeList();
        List<MEInventoryT> meInvs = meList.getMeInv();
        ListIterator<MEInventoryT> litMe = meInvs.listIterator();
        ManagedElementT previousMe = null;
        String previousMdNm = null;
        String mdNm1 = "";
        String meNm1 = "";
        boolean isNewMdInv = true;
        boolean newMeInv = true;
        boolean firstMdList = (getMdList().getMd().size() == 0);
        
        ManagedElementT  firstManagedElement = (ManagedElementT) objs.get(0);
        System.out.println("CreateManagementResponse: mdList.size " + getMdList().getMd().size());
        
        if (firstMdList) {
            // Initialize mdList
            System.out.println("firstMdList");
            MDInventoryT firstMdInv = new MDInventoryT();
            firstMdInv.setMdNm(firstManagedElement.getName().getMdNm());
            getMdList().getMd().add(firstMdInv);
        }
        System.out.println("objs.size() " + objs.size());
        for (Object o : objs) {
             System.out.println("for objssssssssssssssssssssssssssssssssssssssssss");
            ManagedElementT  me = (ManagedElementT) o;
            
            // creates the MEInventory
            MEInventoryT meInv = new MEInventoryT();
            //meInv.setMeNm("<element1>aa</element1>");
            meInv.setMeNm(me.getName().getMeNm());
            
            // loop through all existing mdInv
            for (MDInventoryT oldMdInv : getMdList().getMd()) {
                if (me.getName().getMdNm().equals(oldMdInv.getMdNm())) {
                    System.out.println("me.getName().getMdNm().equals(oldMdInv.getMdNm()");
                   
                    // meinv belongs to this mdInv
                    if (oldMdInv.getMeList() != null) {
                        System.out.println("oldMdInv.getMeList() != null");
                        // loop through all existing meInv under this mdinv
                        for (MEInventoryT oldMeInv : oldMdInv.getMeList().getMeInv()) {
                            if (me.getName().getMeNm().equals(oldMeInv.getMeNm())) {
                                // meinv of current me already exists
                                // (ME, NAME) has already been treated
                                if (granularity.equals("ATTRS") && oldMeInv.getMeAttrs() == null) {
                                    // first ME, ATTRS request for this meInv
                                    //construct supportedRates
                                    if (me.getSupportedRates() != null) {
                                        System.out.println("me.getSupportedRates() != null");
                                        System.out.println("me: " + me.getSupportedRates().getLrs().get(0).getLayerRat());
                                        System.out.println("layerRate: " + me.getSupportedRates().getLayerRate().get(0));
                                    }
                                    oldMeInv.setMeAttrs(me);
                                } else if (granularity.equals("FULL") && oldMeInv.getContainingMLSNNameList() == null) {
                                    System.out.println("000000000000000fullllllllllllllllllllllllllllllllllll");
                                    // first ME, FULL request for this meInv
                                    oldMeInv.setMeAttrs(me);
                                    NamingAttributesListT meFull = me.getMeInventoryT().getContainingMLSNNameList();
                                    if (meFull != null)
                                        oldMeInv.setContainingMLSNNameList(meFull);
                                }
                                newMeInv = false;
                                break;
                            }
                        } // for
                        if (newMeInv) {
                            // me belongs to a new meInv
                            if (granularity.equals("ATTRS")) {
                                if (me.getSupportedRates() != null) {
                                    System.out.println("me.getSupportedRates() != null");
                                    System.out.println("me: " + me.getSupportedRates().getLrs().get(0).getLayerRat());
                                    System.out.println("layerRate: " + me.getSupportedRates().getLayerRate().get(0));
                                }
                                meInv.setMeAttrs(me);
                            } else if (granularity.equals("FULL")) {
                                System.out.println("1111111111111fullllllllllllllllllllllllllllllllllll");
                                meInv.setMeAttrs(me);
                                NamingAttributesListT meFull = me.getMeInventoryT().getContainingMLSNNameList();
                                meInv.setContainingMLSNNameList(meFull);
                            }
                            oldMdInv.getMeList().getMeInv().add(meInv);
                        }
                    }
                    
                    else {
                         // first meInv under this mdInv
                        System.out.println("oldMdInv.getMeList() == null");
                        MeList meListOldMd = new MeList();
                        if (granularity.equals("ATTRS")) {
                            if (me.getSupportedRates() != null) {
                                System.out.println("me.getSupportedRates() != null");
                                System.out.println("me: " + me.getSupportedRates().getLrs().get(0).getLayerRat());
                                System.out.println("layerRate: " + me.getSupportedRates().getLayerRate().get(0));
                            }
                            meInv.setMeAttrs(me);
                        } else if (granularity.equals("FULL")) {
                            System.out.println("222222222222222fullllllllllllllllllllllllllllllllllll");
                            
                            System.out.println("nulllllllllllllll");
                            meInv.setMeAttrs(me);
                            NamingAttributesListT meFull = me.getMeInventoryT().getContainingMLSNNameList();
                            meInv.setContainingMLSNNameList(meFull);
                            
                        }
                        meListOldMd.getMeInv().add(meInv);
                        oldMdInv.setMeList(meListOldMd);
                    }
                    isNewMdInv = false;
                    break;
                }
            } // for
            System.out.println("isNewdInv " +  isNewMdInv);
            if (isNewMdInv) {
                System.out.println("isNewMdInv " + isNewMdInv);
                // me belongs to a new mdInv
                MDInventoryT mdInv = new MDInventoryT();
                MeList meListUnderNewMd = new MeList();
                // contruct meInv
                meInv.setMeNm(me.getName().getMeNm());
                if (granularity.equals("ATTRS")) {
                    if (me.getSupportedRates() != null) {
                        System.out.println("me.getSupportedRates() != null");
                        System.out.println("me: " + me.getSupportedRates().getLrs().get(0).getLayerRat());
                        System.out.println("layerRate: " + me.getSupportedRates().getLayerRate().get(0));
                    }
                    meInv.setMeAttrs(me);
                } else if (granularity.equals("FULL")) {
                    System.out.println("fullllllllllllllllllllllllllllllllllll");
                    if (me.getMeInventoryT().getContainingMLSNNameList() == null) {
                        meInv.setMeAttrs(me);
                        NamingAttributesListT meFull = me.getMeInventoryT().getContainingMLSNNameList();
                        if (meFull != null)
                            meInv.setContainingMLSNNameList(meFull);
                    }
                }
                meListUnderNewMd.getMeInv().add(meInv);
                mdInv.setMdNm(me.getName().getMdNm());
                System.out.println("mdInv.setMeList(meListUnderNewMd);");
                mdInv.setMeList(meListUnderNewMd);
                
                getMdList().getMd().add(mdInv);
            }
        } // for
        
        // add the new MdList to final response
        refreshMdList(getMdList());
        //inventoryData.setMdList(mdList);
        System.out.println("MeNm: " + getMdList().getMd().get(0).getMeList().getMeInv().get(0).getMeNm());
        System.out.println("***************fin CreateManagedElementResponse*************");
        
        return inventoryData;
    }
    
    public InventoryDataT getInventoryData() {
        
        return inventoryData;
    }
}

