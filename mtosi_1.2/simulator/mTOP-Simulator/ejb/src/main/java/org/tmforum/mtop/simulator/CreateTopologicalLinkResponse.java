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
import v1.tmf854.MDInventoryT.TlList;
//import org.tmforum.mtop.simulator.entity.managedinventories.*;
//import org.tmforum.mtop.simulator.entity.managedinventories.MDInventoryT.TlList;
//import org.tmforum.mtop.simulator.entity.managedentities.*;

/**
 *
 * @author baptiste
 */
public class CreateTopologicalLinkResponse extends CreateGetInventoryResponse {
    
    /** Creates a new instance of CreateEquipmentHolderResponse */
    public CreateTopologicalLinkResponse() {
    }
    
    public InventoryDataT createResponse(List<?> objs, String granularity) {
        System.out.println("**************CreateTopologicalLinkResponse:createResponse**************");
        System.out.println("objs.size " + objs.size());
        TlList tlList = new TlList();
        List<TLInventoryT> tlInvs = tlList.getTlInv();
        ListIterator<TLInventoryT> litMe = tlInvs.listIterator();
        TopologicalLinkT previousMe = null;
        String previousMdNm = null;
        String mdNm1 = "";
        String tlNm1 = "";
        boolean isNewMdInv = true;
        boolean newTlInv = true;
        boolean firstMdList = (getMdList().getMd().size() == 0);
        
        TopologicalLinkT  firstTopologicalLink = (TopologicalLinkT) objs.get(0);
        System.out.println("CreateManagementResponse: mdList.size " + getMdList().getMd().size());
        
        if (firstMdList) {
            // Initialize mdList
            System.out.println("firstMdList");
            MDInventoryT firstMdInv = new MDInventoryT();
            firstMdInv.setMdNm(firstTopologicalLink.getName().getMdNm());
            getMdList().getMd().add(firstMdInv);
        }
        System.out.println("objs.size() " + objs.size());
        for (Object o : objs) {
            TopologicalLinkT  tl = (TopologicalLinkT) o;
           
            // creates the MEInventory
            TLInventoryT tlInv = new TLInventoryT();
            //tlInv.setTlNm("<element1>aa</element1>");
            tlInv.setTlNm(tl.getName().getTlNm());
            
            // loop through all existing mdInv
            for (MDInventoryT oldMdInv : getMdList().getMd()) {
                if (tl.getName().getMdNm().equals(oldMdInv.getMdNm())) {
                    System.out.println("tl.getName().getMdNm().equals(oldMdInv.getMdNm()");
                    // meinv belongs to this mdInv
                    if (oldMdInv.getTlList() != null) {
                        System.out.println("oldMdInv.getTlList() != null");
                        // loop through all existing tlInv under this mdinv
                        for (TLInventoryT oldTlInv : oldMdInv.getTlList().getTlInv()) {
                            if (tl.getName().getTlNm().equals(oldTlInv.getTlNm())) {
                                // meinv of current me already exists
                                // (ME, NAME) has already been treated
                                if ((granularity.equals("ATTRS") || granularity.equals("FULL")) && oldTlInv.getTlAttrs() == null) {
                                    // first ME, ATTRS request for this tlInv
                                     //construct supportedRates
                                    oldTlInv.setTlAttrs(tl);
                                } 
                                newTlInv = false;
                                break;
                            }
                        } // for
                            if (newTlInv) {
                                // me belongs to a new tlInv
                            if (granularity.equals("ATTRS")  || granularity.equals("FULL")) {
                                tlInv.setTlAttrs(tl);
                            } 
                            oldMdInv.getTlList().getTlInv().add(tlInv);
                            }
                        } else {
                            System.out.println("oldMdInv.getTlList() == null");
                            TlList tlListOldMd = new TlList();
                            // first tlInv under this mdInv
                            if (granularity.equals("ATTRS")) {
                                tlInv.setTlAttrs(tl);
                            } else if (granularity.equals("ATTRS") || granularity.equals("FULL")) {
                                 tlInv.setTlAttrs(tl);
                            }
                            tlListOldMd.getTlInv().add(tlInv);
                            oldMdInv.setTlList(tlListOldMd);
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
                    TlList tlListUnderNewMd = new TlList();
                    // contruct tlInv
                    tlInv.setTlNm(tl.getName().getTlNm());
                    if (granularity.equals("ATTRS") || granularity.equals("FULL")) {
                        tlInv.setTlAttrs(tl);
                    } 
                    tlListUnderNewMd.getTlInv().add(tlInv);
                    mdInv.setMdNm(tl.getName().getMdNm());
                    System.out.println("mdInv.setTlList(tlListUnderNewMd);");
                    mdInv.setTlList(tlListUnderNewMd);
                    
                    getMdList().getMd().add(mdInv);
                }
            } // for
            
            // add the new MdList to final response
            refreshMdList(getMdList());
            //inventoryData.setMdList(mdList);
            System.out.println("TlNm: " + getMdList().getMd().get(0).getTlList().getTlInv().get(0).getTlNm());
            System.out.println("***************fin CreateTopologicalLinkResponse*************");
            
            return inventoryData;
        }
        
        public InventoryDataT getInventoryData() {
            
            return inventoryData;
        }
    }
    
