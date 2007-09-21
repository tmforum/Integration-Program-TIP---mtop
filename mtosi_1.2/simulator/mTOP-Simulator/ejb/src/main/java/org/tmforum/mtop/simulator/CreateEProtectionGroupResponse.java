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
import v1.tmf854.SimpleFilterT.IncludedObjectType;

/**
 * Class which creates the response for EProtectionGroup managed
 * entities.
 */
public class CreateEProtectionGroupResponse extends CreateGetInventoryResponse {
    
    public InventoryDataT createResponse(List<?> objs, String granularity) {
        EpgpList epgpList = new EpgpList();
        List<EPGPInventoryT> epgpInvs = epgpList.getEpgpInv();
        String mdNm1 = "";
        String meNm1 = "";
        String pgpNm1 = "";
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
            EProtectionGroupT pgp = (EProtectionGroupT) o;
             managedEntitiesIdsRetrieved.add(pgp.getId());
            // creates the EpgpInventory
            EPGPInventoryT pgpInv = new EPGPInventoryT();
            pgpInv.setEpgpNm(pgp.getName().getEpgpNm());
            
            // loop through all existing mdInv
            for (MDInventoryT oldMdInv : getMdList().getMd()) {
                
                if (oldMdInv.getMdNm().equals(pgp.getName().getMdNm())) {
                    // pgpInv belongs to this md
                    
                    if (oldMdInv.getMeList() != null) {
                        
                        // loop through all existing meInv under this mdInv
                        for (MEInventoryT oldMeInv : oldMdInv.getMeList().getMeInv()) {
                            
                            if (oldMeInv.getMeNm().equals(pgp.getName().getMeNm())) {
                                //pgpInv belongs to this meInv
                                
                                if (oldMeInv.getEpgpList() != null) {
                                    // pgpInv is not the first under this meInv
                                    
                                    // loop through all existing pgpInv under this meinv
                                    for (EPGPInventoryT oldEpgpInv : oldMeInv.getEpgpList().getEpgpInv()) {
                                        if (oldEpgpInv.getEpgpNm().equals(pgp.getName().getEpgpNm())) {
                                            // pgpInv of current pgp already exists
                                            
                                            if ((granularity.equals("ATTRS") ||
                                                    granularity.equals("FULL")) &&
                                                    oldEpgpInv.getEpgpAttrs() == null) {
                                                // first ME, ATTRS request for this pgpInv
                                                oldEpgpInv.setEpgpAttrs(pgp);
                                            }
                                            newEpgpInv = false;
                                            break;
                                        }
                                    } //for oldEpgpInv
                                    
                                    if (newEpgpInv) {
                                        // pgpInv belongs to a new pgpInv
                                        
                                        if (granularity.equals("ATTRS") ||
                                            granularity.equals("FULL")) {
                                            // first ME, ATTRS request for this pgpInv
                                            pgpInv.setEpgpAttrs(pgp);
                                        }
                                        oldMeInv.getEpgpList().getEpgpInv().add(pgpInv);
                                    }
                                } else {
                                    // pgpInv is the first under this meInv
                                    EpgpList epgpListOldMe = new EpgpList();
                                    epgpListOldMe.getEpgpInv().add(pgpInv);
                                    oldMeInv.setEpgpList(epgpListOldMe);
                                }
                                newMeInv = false;
                                break;
                            }
                        } // for oldMeInv
                        
                        if (newMeInv) {
                            // pgpInv belongs to a new meInv
                            MEInventoryT meInv = new MEInventoryT();
                            EpgpList epgpListUnderNewMe = new EpgpList();
                            pgpInv.setEpgpNm(pgp.getName().getEpgpNm());
                            
                            if (granularity.equals("ATTRS") || granularity.equals("FULL")) {
                                // first ME, ATTRS request for this pgpInv
                                pgpInv.setEpgpAttrs(pgp);
                            }
                            
                            epgpListUnderNewMe.getEpgpInv().add(pgpInv);
                            meInv.setMeNm(pgp.getName().getMeNm());
                            meInv.setEpgpList(epgpListUnderNewMe);
                            oldMdInv.getMeList().getMeInv().add(meInv);
                        }
                    } else {
                        // first meInv under this mdInv
                        MeList firstMeListOfMd = new MeList();
                        MEInventoryT firstMeInvOfMd = new MEInventoryT();
                        EpgpList epgpListUnderNewMe = new EpgpList();
                        pgpInv.setEpgpNm(pgp.getName().getEpgpNm());
                        
                        if (granularity.equals("ATTRS") || granularity.equals("FULL")) {
                            // first ME, ATTRS request for this pgpInv
                            pgpInv.setEpgpAttrs(pgp);
                        }
                        
                        epgpListUnderNewMe.getEpgpInv().add(pgpInv);
                        firstMeInvOfMd.setMeNm(pgp.getName().getMeNm());
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
                mdInvUnderNewMd.setMdNm(pgp.getName().getMdNm());
                MeList meListUnderNewMd = new MeList();
                MEInventoryT meInvUnderNewMd = new MEInventoryT();
                meInvUnderNewMd.setMeNm(pgp.getName().getMeNm());
                EpgpList epgpListUnderNewMd = new EpgpList();
                pgpInv.setEpgpNm(pgp.getName().getEpgpNm());
                
                if (granularity.equals("ATTRS") || granularity.equals("FULL")) {
                    // first ME, ATTRS request for this pgpInv
                    pgpInv.setEpgpAttrs(pgp);
                }
                
                epgpListUnderNewMd.getEpgpInv().add(pgpInv);
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
    
    public InventoryDataT getInventoryData() {
        
        return inventoryData;
    }
}
