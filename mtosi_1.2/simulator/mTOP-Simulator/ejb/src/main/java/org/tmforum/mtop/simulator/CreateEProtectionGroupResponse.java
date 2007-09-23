package org.tmforum.mtop.simulator;

import java.util.*;

import v1.tmf854.*;
import v1.tmf854.InventoryDataT.MdList;
import v1.tmf854.MDInventoryT.MeList;
import v1.tmf854.MEInventoryT.EpgpList;
import v1.tmf854.SimpleFilterT.IncludedObjectType;

/**
 * Class which creates the response for EProtectionGroup managed
 * entities.
 */
public class CreateEProtectionGroupResponse extends CreateGetInventoryResponse {
    
    public InventoryDataT createResponse(List<?> objs, String granularity) {
        EpgpList epgpList = new EpgpList();
        List<EPGPInventoryT> epgpInvs = epgpList.getEpgpInv();
        boolean newMdInv = true;
        boolean newMeInv = true;
        boolean newEpgpInv = true;
        EProtectionGroupT  firstManagedElement = (EProtectionGroupT) objs.get(0);
        
        if (getMdList().getMd().size() == 0) {
            MDInventoryT firstMdInv = new MDInventoryT();
            firstMdInv.setMdNm(firstManagedElement.getName().getMdNm());
            getMdList().getMd().add(firstMdInv);
        }
        
        // loop through all EProtectionGroups retrieved
        for (Object o : objs) {
            EProtectionGroupT epgp = (EProtectionGroupT) o;
            managedEntitiesIdsRetrieved.add(epgp.getId());
            // creates the EpgpInventory
            EPGPInventoryT epgpInv = new EPGPInventoryT();
            epgpInv.setEpgpNm(epgp.getName().getEpgpNm());
            
            // loop through all existing mdInv
            for (MDInventoryT oldMdInv : getMdList().getMd()) {
                
                if (oldMdInv.getMdNm().equals(epgp.getName().getMdNm())) {
                    // epgpInv belongs to this md
                    
                    if (oldMdInv.getMeList() != null) {
                        
                        // loop through all existing meInv under this mdInv
                        for (MEInventoryT oldMeInv : oldMdInv.getMeList().getMeInv()) {
                            
                            if (oldMeInv.getMeNm().equals(epgp.getName().getMeNm())) {
                                // epgpInv belongs to this meInv
                                
                                if (oldMeInv.getEpgpList() != null) {
                                    // epgpInv is not the first under this meInv
                                    
                                    // loop through all existing epgpInv under this meinv
                                    for (EPGPInventoryT oldEpgpInv : oldMeInv.getEpgpList().getEpgpInv()) {
                                        if (oldEpgpInv.getEpgpNm().equals(epgp.getName().getEpgpNm())) {
                                            // epgpInv of current epgp already exists
                                            
                                            if (oldEpgpInv.getEpgpAttrs() == null) {
                                                // first ME, ATTRS request for this epgpInv
                                                setEpgpGranularity(granularity, oldEpgpInv, epgp);
                                            }
                                            
                                            newEpgpInv = false;
                                            break;
                                        }
                                    } //for oldEpgpInv
                                    
                                    if (newEpgpInv) {
                                        // epgpInv belongs to a new epgpInv
                                        setEpgpGranularity(granularity, epgpInv, epgp);
                                       oldMeInv.getEpgpList().getEpgpInv().add(epgpInv);
                                    }
                                } else {
                                    // epgpInv is the first under this meInv
                                    EpgpList epgpListOldMe = new EpgpList();
                                    setEpgpGranularity(granularity, epgpInv, epgp);
                                    epgpListOldMe.getEpgpInv().add(epgpInv);
                                    oldMeInv.setEpgpList(epgpListOldMe);
                                }
                                newMeInv = false;
                                break;
                            }
                        } // for oldMeInv
                        
                        if (newMeInv) {
                            // epgpInv belongs to a new meInv
                            MEInventoryT meInv = new MEInventoryT();
                            EpgpList epgpListUnderNewMe = new EpgpList();
                            epgpInv.setEpgpNm(epgp.getName().getEpgpNm());
                            setEpgpGranularity(granularity, epgpInv, epgp);
                            epgpListUnderNewMe.getEpgpInv().add(epgpInv);
                            meInv.setMeNm(epgp.getName().getMeNm());
                            meInv.setEpgpList(epgpListUnderNewMe);
                            oldMdInv.getMeList().getMeInv().add(meInv);
                        }
                    } else {
                        // first meInv under this mdInv
                        MeList firstMeListOfMd = new MeList();
                        MEInventoryT firstMeInvOfMd = new MEInventoryT();
                        EpgpList epgpListUnderNewMe = new EpgpList();
                        epgpInv.setEpgpNm(epgp.getName().getEpgpNm());
                        setEpgpGranularity(granularity, epgpInv, epgp);
                        epgpListUnderNewMe.getEpgpInv().add(epgpInv);
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
                // pgpInv belongs to a new mdInv
                MDInventoryT mdInvUnderNewMd = new MDInventoryT();
                mdInvUnderNewMd.setMdNm(epgp.getName().getMdNm());
                MeList meListUnderNewMd = new MeList();
                MEInventoryT meInvUnderNewMd = new MEInventoryT();
                meInvUnderNewMd.setMeNm(epgp.getName().getMeNm());
                EpgpList epgpListUnderNewMd = new EpgpList();
                epgpInv.setEpgpNm(epgp.getName().getEpgpNm());
                setEpgpGranularity(granularity, epgpInv, epgp);    
                epgpListUnderNewMd.getEpgpInv().add(epgpInv);
                meInvUnderNewMd.setEpgpList(epgpListUnderNewMd);
                meListUnderNewMd.getMeInv().add(meInvUnderNewMd);
                mdInvUnderNewMd.setMeList(meListUnderNewMd);
                
                getMdList().getMd().add(mdInvUnderNewMd);
            }
        } // for objs
        
        // add the new MdList to final response
        refreshMdList(getMdList());
        
        return inventoryData;
    }
    
    public void setEpgpGranularity(String granularity, EPGPInventoryT epgpInv, EProtectionGroupT epgp) {
        if ( (granularity.equals("ATTRS") ||  granularity.equals("FULL")) )
            epgpInv.setEpgpAttrs(epgp);
    }
    
    public InventoryDataT getInventoryData() {
        
        return inventoryData;
    }
}
