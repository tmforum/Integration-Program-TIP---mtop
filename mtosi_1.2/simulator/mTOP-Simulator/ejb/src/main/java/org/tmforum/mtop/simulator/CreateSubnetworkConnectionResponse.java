/*
 * CreateSubnetworkConnectionResponse.java
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
import v1.tmf854.MLSNInventoryT.SncList;
import v1.tmf854.SimpleFilterT.IncludedObjectType;

/**
 * Class which creates the response for SubnetworkConnection managed
 * entities.
 */
public class CreateSubnetworkConnectionResponse extends CreateGetInventoryResponse {
    
       public InventoryDataT createResponse(List<?> objs, String granularity) {
        SncList sncList = new SncList();
        List<SNCInventoryT> sncInvs = sncList.getSncInv();
        String mdNm1 = "";
        String meNm1 = "";
        String pgpNm1 = "";
        boolean newMdInv = true;
        boolean newMlsnInv = true;
        boolean newSncInv = true;
        
        SubnetworkConnectionT  firstManagedElement = (SubnetworkConnectionT) objs.get(0);
        
        if (getMdList().getMd().size() == 0) {
            MDInventoryT firstMdInv = new MDInventoryT();
            firstMdInv.setMdNm(firstManagedElement.getName().getMdNm());
            getMdList().getMd().add(firstMdInv);
        }
        
        // loop through all SubnetworkConnections retrieved
        for (Object o : objs) {
            SubnetworkConnectionT  snc = (SubnetworkConnectionT) o;
            managedEntitiesIdsRetrieved.add(snc.getId());
            SNCInventoryT sncInv = new SNCInventoryT();
            sncInv.setSncNm(snc.getName().getSncNm());
            
            // loop through all existing mdInv
            for (MDInventoryT oldMdInv : getMdList().getMd()) {
               
                if (oldMdInv.getMdNm().equals(snc.getName().getMdNm())) {
                    // snc belongs to this md
                    
                    if (oldMdInv.getMlsnList() != null) {
                    
                        // loop through all existing meInv under this mdInv
                        for (MLSNInventoryT oldMlsnInv : oldMdInv.getMlsnList().getMlsnInv()) {
                        
                            if (oldMlsnInv.getMlsnNm().equals(snc.getName().getMlsnNm())) {
                            // sncInv belongs to this meInv
                           
                                if (oldMlsnInv.getSncList() != null) {
                                    // sncInv is not the first under this meInv
                                    
                                    // loop through all existing sncInv under this meinv
                                    for (SNCInventoryT oldSncInv : oldMlsnInv.getSncList().getSncInv()) {
                                        
                                        if (oldSncInv.getSncNm().equals(snc.getName().getSncNm())) {
                                            
                                            if ((granularity.equals("ATTRS") ||
                                                    granularity.equals("FULL")) &&
                                                    oldSncInv.getSncAttrs() == null) {
                                                oldSncInv.setSncAttrs(snc);
                                            }
                                           
                                            newSncInv = false;
                                            break;
                                        }
                                    } //for oldSncInv
                                   
                                    if (newSncInv) {
                                       
                                        if (granularity.equals("ATTRS") || granularity.equals("FULL")) {
                                           sncInv.setSncAttrs(snc);
                                        }
                                         oldMlsnInv.getSncList().getSncInv().add(sncInv);
                                    } 
                                } else {
                                    // sncInv is the first under this meInv
                                    System.out.println("// sncInv is the first under this meInv");
                                    SncList sncListOldMe = new SncList();
                                    sncListOldMe.getSncInv().add(sncInv);
                                    oldMlsnInv.setSncList(sncListOldMe);
                                }
                                
                                newMlsnInv = false;
                                break;
                            }
                        } // for oldMlsnInv
                        
                        if (newMlsnInv) {
                            // sncInv belongs to a new meInv
                            MLSNInventoryT meInv = new MLSNInventoryT();
                            SncList sncListUnderNewMe = new SncList();
                            
                            sncInv.setSncNm(snc.getName().getSncNm());
                           
                            if (granularity.equals("ATTRS") || granularity.equals("FULL")) {
                                sncInv.setSncAttrs(snc);
                            }
                           
                            sncListUnderNewMe.getSncInv().add(sncInv);
                            meInv.setSncList(sncListUnderNewMe);
                            // Add ManagedElement to ManagementDomain
                            oldMdInv.getMlsnList().getMlsnInv().add(meInv);
                        }
                    } else {
                        // first meInv under this mdInv
                        MlsnList firstMlsnListOfMd = new MlsnList();
                        MLSNInventoryT firstMlsnInvOfMd = new MLSNInventoryT();
                        SncList sncListUnderNewMe = new SncList();
                        sncInv.setSncNm(snc.getName().getSncNm());
                       
                        if (granularity.equals("ATTRS") || granularity.equals("FULL")) {
                           sncInv.setSncAttrs(snc);
                        }
                       
                        sncListUnderNewMe.getSncInv().add(sncInv);
                        firstMlsnInvOfMd.setMlsnNm(snc.getName().getMlsnNm());
                        firstMlsnInvOfMd.setSncList(sncListUnderNewMe);
                        firstMlsnListOfMd.getMlsnInv().add(firstMlsnInvOfMd);
                        oldMdInv.setMlsnList(firstMlsnListOfMd);
                    }
                }
                newMdInv = false;
                break;
            } // for oldMdInv
            
            if (newMdInv) {
                // sncInv belongs to a new mdInv
                MDInventoryT mdInvUnderNewMd = new MDInventoryT();
                mdInvUnderNewMd.setMdNm(snc.getName().getMdNm());
                MlsnList meListUnderNewMd = new MlsnList();
                MLSNInventoryT meInvUnderNewMd = new MLSNInventoryT();
                meInvUnderNewMd.setMlsnNm(snc.getName().getMlsnNm());
                SncList sncListUnderNewMd = new SncList();
                sncInv.setSncNm(snc.getName().getSncNm());
               
               if (granularity.equals("ATTRS") || granularity.equals("FULL")) {
                    // first ME, ATTRS request for this sncInv
                    sncInv.setSncAttrs(snc);
                }
                
                sncListUnderNewMd.getSncInv().add(sncInv);
                meInvUnderNewMd.setSncList(sncListUnderNewMd);
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
