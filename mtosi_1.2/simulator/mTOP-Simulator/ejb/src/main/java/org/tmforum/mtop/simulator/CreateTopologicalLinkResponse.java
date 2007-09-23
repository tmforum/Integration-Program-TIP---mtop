package org.tmforum.mtop.simulator;

import java.util.*;

import v1.tmf854.*;
import v1.tmf854.SimpleFilterT.IncludedObjectType;
import v1.tmf854.InventoryDataT.MdList;
import v1.tmf854.MDInventoryT.TlList;

/**
 * Class which creates the response for TopologicalLink managed
 * entities.
 */
public class CreateTopologicalLinkResponse extends CreateGetInventoryResponse {
    
    public InventoryDataT createResponse(List<?> objs, String granularity) {
        TlList tlList = new TlList();
        List<TLInventoryT> tlInvs = tlList.getTlInv();
        ListIterator<TLInventoryT> litMe = tlInvs.listIterator();
        boolean isNewMdInv = true;
        boolean newTlInv = true;
        boolean firstMdList = (getMdList().getMd().size() == 0);
        TopologicalLinkT  firstTopologicalLink = (TopologicalLinkT) objs.get(0);
        
        if (firstMdList) {
            // Initialize mdList
            MDInventoryT firstMdInv = new MDInventoryT();
            firstMdInv.setMdNm(firstTopologicalLink.getName().getMdNm());
            getMdList().getMd().add(firstMdInv);
        }
        
        for (Object o : objs) {
            TopologicalLinkT  tl = (TopologicalLinkT) o;
            managedEntitiesIdsRetrieved.add(tl.getId());
            TLInventoryT tlInv = new TLInventoryT();
            tlInv.setTlNm(tl.getName().getTlNm());
            
            // loop through all existing mdInv
            for (MDInventoryT oldMdInv : getMdList().getMd()) {
                
                if (tl.getName().getMdNm().equals(oldMdInv.getMdNm())) {
                    
                    if (oldMdInv.getTlList() != null) {
                        
                        // loop through all existing tlInv under this mdinv
                        for (TLInventoryT oldTlInv : oldMdInv.getTlList().getTlInv()) {
                            
                            if (tl.getName().getTlNm().equals(oldTlInv.getTlNm())) {
                                
                                if (oldTlInv.getTlAttrs() == null)
                                    setTlGranularity(granularity, tlInv, tl);
                                
                                newTlInv = false;
                                break;
                            }
                        } // for
                        
                        if (newTlInv) {
                            setTlGranularity(granularity, tlInv, tl);
                            oldMdInv.getTlList().getTlInv().add(tlInv);
                        }
                    } else {
                        TlList tlListOldMd = new TlList();
                        setTlGranularity(granularity, tlInv, tl);
                        tlListOldMd.getTlInv().add(tlInv);
                        oldMdInv.setTlList(tlListOldMd);
                    }
                    
                    isNewMdInv = false;
                    break;
                }
            } // for
            
            if (isNewMdInv) {
                MDInventoryT mdInv = new MDInventoryT();
                TlList tlListUnderNewMd = new TlList();
                tlInv.setTlNm(tl.getName().getTlNm());
                setTlGranularity(granularity, tlInv, tl);
                tlListUnderNewMd.getTlInv().add(tlInv);
                mdInv.setMdNm(tl.getName().getMdNm());
                mdInv.setTlList(tlListUnderNewMd);
                
                getMdList().getMd().add(mdInv);
            }
        } // for
        
        // add the new MdList to final response
        refreshMdList(getMdList());
        
        return inventoryData;
    }
    
    public void setTlGranularity(String granularity, TLInventoryT tlInv, TopologicalLinkT tl) {
        if (granularity.equals("ATTRS") || granularity.equals("FULL")) {
            tlInv.setTlAttrs(tl);
        }
    }
    
    public InventoryDataT getInventoryData() {
        
        return inventoryData;
    }
}

