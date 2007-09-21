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

/**
 * Class which creates the response for EquipmentHolder managed
 * entities.
 */
public class CreateManagedElementResponse extends CreateGetInventoryResponse {
    
    /** Creates a new instance of CreateEquipmentHolderResponse */
    public CreateManagedElementResponse() {
    }
    
    public InventoryDataT createResponse(List<?> objs, String granularity) {
        MeList meList = new MeList();
        List<MEInventoryT> meInvs = meList.getMeInv();
        ManagedElementT previousMe = null;
        String previousMdNm = null;
        String mdNm1 = "";
        String meNm1 = "";
        boolean isNewMdInv = true;
        boolean newMeInv = true;
        boolean firstMdList = (getMdList().getMd().size() == 0);
        ManagedElementT  firstManagedElement = (ManagedElementT) objs.get(0);
        
        if (firstMdList) {
            // Initialize mdList
            MDInventoryT firstMdInv = new MDInventoryT();
            firstMdInv.setMdNm(firstManagedElement.getName().getMdNm());
            getMdList().getMd().add(firstMdInv);
        }
        
        // loop through all ManagedElements retrieved
        for (Object o : objs) {
            // loop through all ManagedElements retrieved
            ManagedElementT  me = (ManagedElementT) o;
            managedEntitiesIdsRetrieved.add(me.getId());
      
            
            MEInventoryT meInv = new MEInventoryT();
            meInv.setMeNm(me.getName().getMeNm());
            
            // loop through all existing mdInv
            for (MDInventoryT oldMdInv : getMdList().getMd()) {
                
                if (me.getName().getMdNm().equals(oldMdInv.getMdNm())) {
                    // meinv belongs to this mdInv
                    
                    if (oldMdInv.getMeList() != null) {
                        newMeInv = true;
                        
                        // loop through all existing meInv under this mdinv
                        for (MEInventoryT oldMeInv : oldMdInv.getMeList().getMeInv()) {
                            
                            if (me.getName().getMeNm().equals(oldMeInv.getMeNm())) {
                                // meinv of current me already exists
                                // (ME, NAME) has already been treated
                                
                                if (granularity.equals("ATTRS") &&
                                        oldMeInv.getMeAttrs() == null) {
                                    // first ME, ATTRS request for this meInv
                                    
                                    if (me.getSupportedRates() != null) {
                                        me.getSupportedRates().initLayerRate();
                                    }
                                    oldMeInv.setMeAttrs(me);
                                } else if (granularity.equals("FULL") &&
                                        oldMeInv.getContainingMLSNNameList() == null) {
                                    
                                    if (me.getSupportedRates() != null) {
                                        me.getSupportedRates().initLayerRate();
                                    }
                                    
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
                                    me.getSupportedRates().initLayerRate();
                                }
                                meInv.setMeAttrs(me);
                            } else if (granularity.equals("FULL")) {
                                
                                if (me.getSupportedRates() != null) {
                                    me.getSupportedRates().initLayerRate();
                                }
                                meInv.setMeAttrs(me);
                                NamingAttributesListT meFull = me.getMeInventoryT().getContainingMLSNNameList();
                                meInv.setContainingMLSNNameList(meFull);
                            }
                            oldMdInv.getMeList().getMeInv().add(meInv);
                        }
                    } else {
                        // first meInv under this mdInv
                        MeList meListOldMd = new MeList();
                        
                        if (granularity.equals("ATTRS")) {
                            
                            if (me.getSupportedRates() != null) {
                                me.getSupportedRates().initLayerRate();
                            }
                            meInv.setMeAttrs(me);
                        }  else if (granularity.equals("FULL")) {
                           
                            if (me.getSupportedRates() != null) {
                                me.getSupportedRates().initLayerRate();
                             }
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
            
            if (isNewMdInv) {
                // me belongs to a new mdInv
                MDInventoryT mdInv = new MDInventoryT();
                MeList meListUnderNewMd = new MeList();
                meInv.setMeNm(me.getName().getMeNm());
                
                if (granularity.equals("ATTRS")) {
                    
                    if (me.getSupportedRates() != null) {
                        me.getSupportedRates().initLayerRate();
                    }
                    meInv.setMeAttrs(me);
                } else if (granularity.equals("FULL")) {
                    
                    if (me.getSupportedRates() != null) {
                        me.getSupportedRates().initLayerRate();
                    }
                    meInv.setMeAttrs(me);
                    
                    if (me.getMeInventoryT().getContainingMLSNNameList() == null) {
                        NamingAttributesListT meFull = me.getMeInventoryT().getContainingMLSNNameList();
                        
                        if (meFull != null)
                            meInv.setContainingMLSNNameList(meFull);
                    }
                }
                
                meListUnderNewMd.getMeInv().add(meInv);
                mdInv.setMdNm(me.getName().getMdNm());
                mdInv.setMeList(meListUnderNewMd);
                getMdList().getMd().add(mdInv);
            }
        } // for
        
        // add the new MdList to final response
        refreshMdList(getMdList());
        
        return inventoryData;
    }
    
    public InventoryDataT getInventoryData() {
        
        return inventoryData;
    }
}

