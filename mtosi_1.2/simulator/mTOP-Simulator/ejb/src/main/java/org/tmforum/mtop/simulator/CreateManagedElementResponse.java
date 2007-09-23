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
    
    public CreateManagedElementResponse() {
    }
    
    public InventoryDataT createResponse(List<?> objs, String granularity) {
        MeList meList = new MeList();
        List<MEInventoryT> meInvs = meList.getMeInv();
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
                                
                                if (oldMeInv.getMeAttrs() == null || oldMeInv.getContainingMLSNNameList() == null) 
                                    setMeGranularity(granularity, oldMeInv, me);
                                  
                                    newMeInv = false;
                                  
                                    break;
                                }
                            } // for
                            
                            if (newMeInv) {
                                // me belongs to a new meInv
                                setMeGranularity(granularity, meInv, me);
                                oldMdInv.getMeList().getMeInv().add(meInv);
                            }
                        } else {
                            // first meInv under this mdInv
                            MeList meListOldMd = new MeList();
                            setMeGranularity(granularity, meInv, me);
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
                    setMeGranularity(granularity, meInv, me);
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
        
        public void setMeGranularity(String granularity, MEInventoryT meInv,ManagedElementT me) {
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
        }
        
        public InventoryDataT getInventoryData() {
            
            return inventoryData;
        }
    }
    
