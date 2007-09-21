/*
 * CreateTpPoolResponse.java
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
import v1.tmf854.MDInventoryT.MlsnList;
import v1.tmf854.MLSNInventoryT.TpPoolList;
import v1.tmf854.SimpleFilterT.IncludedObjectType;

/**
 * Class which creates the response for TopologicalLink managed
 * entities.
 */
public class CreateTpPoolResponse extends CreateGetInventoryResponse {
    
   
    
    public InventoryDataT createResponse(List<?> objs, String granularity) {
        System.out.println("**************CreateTpPoolResponse:createResponse2**************");
        TpPoolList tppList = new TpPoolList();
        List<TPPoolInventoryT> tpPoolInvs = tppList.getTpPoolInv();
        String mdNm1 = "";
        String meNm1 = "";
        String pgpNm1 = "";
        boolean newMdInv = true;
        boolean newMlsnInv = true;
        boolean newTpPoolInv = true;
        TPPoolT  firstTPPoolT = (TPPoolT) objs.get(0);
        
        
        if (getMdList().getMd().size() == 0) {
            MDInventoryT firstMdInv = new MDInventoryT();
            firstMdInv.setMdNm(firstTPPoolT.getName().getMdNm());
            getMdList().getMd().add(firstMdInv);
        }
        
        // loop through all TpPools retrieved
        for (Object o : objs) {
            TPPoolT tpPool = (TPPoolT) o;
            managedEntitiesIdsRetrieved.add(tpPool.getId());
            // creates the TpPoolInventory
            TPPoolInventoryT tpPoolInv = new TPPoolInventoryT();
            tpPoolInv.setTppoolNm(tpPool.getName().getTppoolNm());
          
            // loop through all existing mdInv
            for (MDInventoryT oldMdInv : getMdList().getMd()) {
                
                if (oldMdInv.getMdNm().equals(tpPool.getName().getMdNm())) {
                    // tpPoolInv belongs to this mdInv
                  
                    if (oldMdInv.getMlsnList() != null) {
                  
                        // loop through all existing meInv under this mdInv
                        for (MLSNInventoryT oldMlsnInv : oldMdInv.getMlsnList().getMlsnInv()) {
                        
                            if (oldMlsnInv.getMlsnNm().equals(tpPool.getName().getMlsnNm())) {
                               
                                if (oldMlsnInv.getTpPoolList() != null) {
                               
                                    // tpPoolInv is not the first under this meInv
                                    // loop through all existing tpPoolInv under this meinv
                                    for (TPPoolInventoryT oldTpPoolInv : oldMlsnInv.getTpPoolList().getTpPoolInv()) {
                                        
                                        if (oldTpPoolInv.getTppoolNm().equals(tpPool.getName().getTppoolNm())) {
                                           
                                            if ((granularity.equals("ATTRS") || granularity.equals("FULL")) && oldTpPoolInv.getTppoolAttrs() == null) {
                                                // first ME, ATTRS request for this tpPoolInv
                                                oldTpPoolInv.setTppoolAttrs(tpPool);
                                            }
                                            
                                            newTpPoolInv = false;
                                            break;
                                        }
                                    } //for oldTpPoolInv
                                    
                                    if (newTpPoolInv) {
                                        // tpPoolInv belongs to a new tpPoolInv
                                       
                                        if (granularity.equals("ATTRS") || granularity.equals("FULL")) {
                                            tpPoolInv.setTppoolAttrs(tpPool);
                                        }
                                        oldMlsnInv.getTpPoolList().getTpPoolInv().add(tpPoolInv);
                                    }
                                    
                                } else {
                                    // tpPoolInv is the first under this meInv
                                    System.out.println("// tpPoolInv is the first under this meInv");
                                    TpPoolList tppListOldMe = new TpPoolList();
                                    tppListOldMe.getTpPoolInv().add(tpPoolInv);
                                    oldMlsnInv.setTpPoolList(tppListOldMe);
                                }
                                
                                newMlsnInv = false;
                                break;
                            }
                        } // for oldMlsnInv
                        
                        if (newMlsnInv) {
                            MLSNInventoryT meInv = new MLSNInventoryT();
                            TpPoolList tppListUnderNewMe = new TpPoolList();
                            tpPoolInv.setTppoolNm(tpPool.getName().getTppoolNm());
                           
                            if (granularity.equals("ATTRS") || granularity.equals("FULL")) {
                                // first ME, ATTRS request for this tpPoolInv
                                tpPoolInv.setTppoolAttrs(tpPool);
                            }
                            
                            tppListUnderNewMe.getTpPoolInv().add(tpPoolInv);
                            meInv.setTpPoolList(tppListUnderNewMe);
                            // Add TPPoolT to ManagementDomain
                            oldMdInv.getMlsnList().getMlsnInv().add(meInv);
                        }
                    } else {
                        // first meInv under this mdInv
                        System.out.println("oldMdInv.getMlsnList() == null");
                        MlsnList firstMlsnListOfMd = new MlsnList();
                        MLSNInventoryT firstMlsnInvOfMd = new MLSNInventoryT();
                        TpPoolList tppListUnderNewMe = new TpPoolList();
                      
                        tpPoolInv.setTppoolNm(tpPool.getName().getTppoolNm());
                        if (granularity.equals("ATTRS") || granularity.equals("FULL")) {
                            tpPoolInv.setTppoolAttrs(tpPool);
                        }
                    
                        tppListUnderNewMe.getTpPoolInv().add(tpPoolInv);
                        System.out.println("tppListUnderNewMe.size " + tppListUnderNewMe.getTpPoolInv().size());
                        firstMlsnInvOfMd.setMlsnNm(tpPool.getName().getMlsnNm());
                        firstMlsnInvOfMd.setTpPoolList(tppListUnderNewMe);
                        firstMlsnListOfMd.getMlsnInv().add(firstMlsnInvOfMd);
                        oldMdInv.setMlsnList(firstMlsnListOfMd);
                    }
                }
                newMdInv = false;
                break;
            }// for oldMdInv
            
            if (newMdInv) {
               
                // tpPoolInv belongs to a new mdInv
                MDInventoryT mdInvUnderNewMd = new MDInventoryT();
                mdInvUnderNewMd.setMdNm(tpPool.getName().getMdNm());
                MlsnList meListUnderNewMd = new MlsnList();
                MLSNInventoryT meInvUnderNewMd = new MLSNInventoryT();
                meInvUnderNewMd.setMlsnNm(tpPool.getName().getMlsnNm());
                TpPoolList tppListUnderNewMd = new TpPoolList();
                tpPoolInv.setTppoolNm(tpPool.getName().getTppoolNm());
                
                if (granularity.equals("ATTRS") || granularity.equals("FULL")) {
                    tpPoolInv.setTppoolAttrs(tpPool);
                }
                
                tppListUnderNewMd.getTpPoolInv().add(tpPoolInv);
                meInvUnderNewMd.setTpPoolList(tppListUnderNewMd);
                meListUnderNewMd.getMlsnInv().add(meInvUnderNewMd);
                mdInvUnderNewMd.setMlsnList(meListUnderNewMd);
                
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
