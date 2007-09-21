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
import v1.tmf854.SimpleFilterT.IncludedObjectType;
import v1.tmf854.EquipmentT;
import v1.tmf854.MDInventoryT.MeList;
import v1.tmf854.MEInventoryT.EhList;

/**
 * Class which creates the response for Equipment managed
 * entities.
 */
public class CreateEquipmentResponse extends CreateGetInventoryResponse {
    
    public InventoryDataT createResponse(List<?> objs, String granularity) {
        EhList ehList = new EhList();
        List<EHInventoryT> ehInvs = ehList.getEhInv();
        ListIterator<EHInventoryT> litMe = ehInvs.listIterator();
        EquipmentHolderT previousMe = null;
        String previousMdNm = null;
        String mdNm1 = "";
        String meNm1 = "";
        String ehNm1 = "";
        String eqNm1 = "";
        boolean newMdInv = true;
        boolean newMeInv = true;
        boolean newEqInv = true;
        boolean newEhInv = true;
        EquipmentT  firstEquipment = (EquipmentT) objs.get(0);
        
        if (getMdList().getMd().size() == 0) {
            MDInventoryT firstMdInv = new MDInventoryT();
            firstMdInv.setMdNm(firstEquipment.getName().getMdNm());
            getMdList().getMd().add(firstMdInv);
        }
        
        // loop through all Equipments retrieved
        for (Object o : objs) {
            EquipmentT  eq = (EquipmentT) o;
            managedEntitiesIdsRetrieved.add(eq.getId());
            EQInventoryT eqInv = new EQInventoryT();
            EHInventoryT ehInv = new EHInventoryT();
            mdNm1 = eq.getName().getMdNm();
            meNm1 = eq.getName().getMeNm();
            ehNm1 = eq.getName().getEhNm();
            eqNm1 = eq.getName().getEqNm();
            
            // loop through all existing mdInv
            for (MDInventoryT oldMdInv : getMdList().getMd()) {
                
                if (oldMdInv.getMdNm().equals(eq.getName().getMdNm())) {
                    
                    System.out.println("// eqInv belongs to this mdInv");
                    
                    if (oldMdInv.getMeList() == null) {
                        System.out.println("oldMdInv.getMeList= null ");
                        MeList firstMeListOfMd = new MeList();
                        MEInventoryT firstMeInvOfMd = new MEInventoryT();
                        firstMeInvOfMd.setMeNm(eq.getName().getMeNm());
                        firstMeListOfMd.getMeInv().add(firstMeInvOfMd);
                        oldMdInv.setMeList(firstMeListOfMd);
                    }
                    
                    // loop through all existing managedElements
                    for (MEInventoryT oldMeInv : oldMdInv.getMeList().getMeInv()) {
                        
                        if (oldMeInv.getMeNm().equals(eq.getName().getMeNm())) {
                            //EquipmentHolder belongs to this ManagedElement
                            System.out.println("oldMeInv.getEhList() " + oldMeInv.getEhList());
                            if (oldMeInv.getEhList() != null) {
                                // ehInv is not the first under this meInv
                                
                                // loop through all existing ehInv under this meinv
                                for (EHInventoryT oldEhInv : oldMeInv.getEhList().getEhInv()) {
                                    
                                    System.out.println("oldEhInv.getEhNm " + oldEhInv.getEhNm());
                                    if (oldEhInv.getEhNm().equals(eq.getName().getEhNm())) {
                                        // ehInv of current eqInv already exists
                                        
                                        if (oldEhInv.getEqInv() != null) {
                                            // eqInv of current ehInv already exists
                                            
                                            // (EH, NAME) has already been treated
                                            if ((granularity.equals("ATTRS") ||
                                                    granularity.equals("FULL")) &&
                                                    oldEhInv.getEqInv().getEqAttrs() == null) {
                                                // first ME, ATTRS request for this ehInv
                                                oldEhInv.getEqInv().setEqAttrs(eq);
                                            }
                                            newEqInv = false;
                                            
                                            break;
                                        } else {
                                            // first eqInv of ehInv
                                            eqInv.setEqNm(eq.getName().getEqNm());
                                            
                                            if (granularity.equals("ATTRS") || granularity.equals("FULL")) {
                                                // first ME, ATTRS request for this ehInv
                                                eqInv.setEqAttrs(eq);
                                            }
                                            
                                            oldEhInv.setEqInv(eqInv);
                                        }
                                        newEhInv = false;
                                        
                                        break;
                                    }
                                } // for oldEhInv
                                
                                if (newEhInv) {
                                    // eqInv belongs to a new ehInv
                                    eqInv.setEqNm(eq.getName().getEqNm());
                                    
                                    if (granularity.equals("ATTRS") || granularity.equals("FULL")) {
                                        // first ME, ATTRS request for this ehInv
                                        eqInv.setEqAttrs(eq);
                                    }
                                    
                                    ehInv.setEqInv(eqInv);
                                    ehInv.setEhNm(eq.getName().getEhNm());
                                    oldMeInv.getEhList().getEhInv().add(ehInv);
                                }
                            } else {
                                // ehInv is the first under this meInv
                                EhList ehListOldMe = new EhList();
                                // eqInv belongs to a new ehInv
                                eqInv.setEqNm(eq.getName().getEqNm());
                                
                                if (granularity.equals("ATTRS") || granularity.equals("FULL")) {
                                    // first ME, ATTRS request for this ehInv
                                    eqInv.setEqAttrs(eq);
                                }
                                
                                ehInv.setEqInv(eqInv);
                                ehInv.setEhNm(eq.getName().getEhNm());
                                ehListOldMe.getEhInv().add(ehInv);
                                oldMeInv.setEhList(ehListOldMe);
                            }
                            
                            newMeInv = false;
                            break;
                        }
                    } // for oldMeInv
                    
                    if (newMeInv) {
                        // eqInv belongs to a new meInv
                        eqInv.setEqNm(eq.getName().getEqNm());
                        
                        if (granularity.equals("ATTRS") ||
                                granularity.equals("FULL")) {
                            // first ME, ATTRS request for this ehInv
                            eqInv.setEqAttrs(eq);
                        }
                        ehInv.setEqInv(eqInv);
                        ehInv.setEhNm(eq.getName().getEhNm());
                        EhList ehListUnderNewMe = new EhList();
                        ehListUnderNewMe.getEhInv().add(ehInv);
                        MEInventoryT meInv = new MEInventoryT();
                        meInv.setEhList(ehListUnderNewMe);
                        oldMdInv.getMeList().getMeInv().add(meInv);
                    }
                }
                newMdInv = false;
                
                break;
            } // for oldMdInv
            
            if (newMdInv) {
                // eqInv belongs to a new mdInv
                eqInv.setEqNm(eq.getName().getEqNm());
                if (granularity.equals("ATTRS") ||
                        granularity.equals("FULL")) {
                    // first ME, ATTRS request for this ehInv
                    eqInv.setEqAttrs(eq);
                }
                ehInv.setEqInv(eqInv);
                ehInv.setEhNm(eq.getName().getEhNm());
                EhList ehListUnderNewMe = new EhList();
                ehListUnderNewMe.getEhInv().add(ehInv);
                MEInventoryT meInvUnderNewMd = new MEInventoryT();
                meInvUnderNewMd.setMeNm(eq.getName().getMeNm());
                meInvUnderNewMd.setEhList(ehListUnderNewMe);
                MeList meListUnderNewMd = new MeList();
                meListUnderNewMd.getMeInv().add(meInvUnderNewMd);
                MDInventoryT mdInvUnderNewMd = new MDInventoryT();
                mdInvUnderNewMd.setMdNm(eq.getName().getMdNm());
                mdInvUnderNewMd.setMeList(meListUnderNewMd);
                
                getMdList().getMd().add(mdInvUnderNewMd);
            }
        }// for objs
        
        // add the new MdList to final response
        refreshMdList(getMdList());
        
        return inventoryData;
    }
    
    public InventoryDataT getInventoryData() {
        
        return inventoryData;
    }
}

