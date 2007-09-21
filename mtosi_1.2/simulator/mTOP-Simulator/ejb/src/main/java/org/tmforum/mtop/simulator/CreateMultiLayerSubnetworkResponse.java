
package org.tmforum.mtop.simulator;

import java.util.*;

import v1.tmf854.*;
import v1.tmf854.SimpleFilterT.IncludedObjectType;
import v1.tmf854.InventoryDataT.MdList;
import v1.tmf854.MDInventoryT.MlsnList;

public class CreateMultiLayerSubnetworkResponse extends CreateGetInventoryResponse {
    
    /** Creates a new instance of CreateEquipmentHolderResponse */
    public CreateMultiLayerSubnetworkResponse() {
    }
    
    public InventoryDataT createResponse(List<?> objs, String granularity) {
        MlsnList mlsnList = new MlsnList();
        List<MLSNInventoryT> mlsnInvs = mlsnList.getMlsnInv();
        ListIterator<MLSNInventoryT> litMlsn = mlsnInvs.listIterator();
        MultiLayerSubnetworkT previousMe = null;
        String previousMdNm = null;
        String mdNm1 = "";
        String meNm1 = "";
        boolean isNewMdInv = true;
        boolean newMlsnInv = true;
        boolean firstMdList = (getMdList().getMd().size() == 0);
        
        MultiLayerSubnetworkT  firstMultiLayerSubnetwork = (MultiLayerSubnetworkT) objs.get(0);
        
        if (firstMdList) {
            // Initialize mdList
            MDInventoryT firstMdInv = new MDInventoryT();
            firstMdInv.setMdNm(firstMultiLayerSubnetwork.getName().getMdNm());
            getMdList().getMd().add(firstMdInv);
        }
       
         for (Object o : objs) {
            MultiLayerSubnetworkT  mlsn = (MultiLayerSubnetworkT) o;
            managedEntitiesIdsRetrieved.add(mlsn.getId());
            // creates the MEInventory
            MLSNInventoryT mlsnInv = new MLSNInventoryT();
            //mlsnInv.setMlsnNm("<element1>aa</element1>");
            mlsnInv.setMlsnNm(mlsn.getName().getMlsnNm());
            
            // loop through all existing mdInv
            for (MDInventoryT oldMdInv : getMdList().getMd()) {
                
                if (mlsn.getName().getMdNm().equals(oldMdInv.getMdNm())) {
                    // meinv belongs to this mdInv
                
                    if (oldMdInv.getMlsnList() != null) {
                        System.out.println("oldMdInv.getMlsnList() != null");
                    
                        // loop through all existing mlsnInv under this mdinv
                        for (MLSNInventoryT oldMlsnInv : oldMdInv.getMlsnList().getMlsnInv()) {
                        
                            if (mlsn.getName().getMlsnNm().equals(oldMlsnInv.getMlsnNm())) {
                                // meinv of current me already exists
                                // (ME, NAME) has already been treated
                            
                                if (granularity.equals("ATTRS") && oldMlsnInv.getMlsnAttrs() == null) {
                                    // first ME, ATTRS request for this mlsnInv
                                   
                                    if (mlsn.getSupportedRates() != null) {
                                        mlsn.getSupportedRates().getLrs().get(0).getLayerRat();
                                        mlsn.getSupportedRates().getLayerRate().get(0);
                                    }
                                    oldMlsnInv.setMlsnAttrs(mlsn);
                                } else if (granularity.equals("FULL") && oldMlsnInv.getAssociatedMEList() == null) {
                                   // first ME, FULL request for this mlsnInv
                                    oldMlsnInv.setMlsnAttrs(mlsn);
                                    AssociatedMEList mlsnFull =  mlsn.getMlsnInventoryT().getAssociatedMEList();
                                    oldMlsnInv.setAssociatedMEList(mlsnFull);
                                    }
                                newMlsnInv = false;
                               
                                break;
                            }
                        } // for
                        
                        if (newMlsnInv) {
                          
                            // me belongs to a new mlsnInv
                            if (granularity.equals("ATTRS")) {
                            
                                if (mlsn.getSupportedRates() != null) {
                                    System.out.println("mlsn.getSupportedRates() != null");
                                    System.out.println("mlsn: " + mlsn.getSupportedRates().getLrs().get(0).getLayerRat());
                                    System.out.println("layerRate: " + mlsn.getSupportedRates().getLayerRate().get(0));
                                }
                                mlsnInv.setMlsnAttrs(mlsn);
                            } else if (granularity.equals("FULL")) {
                                mlsnInv.setMlsnAttrs(mlsn);
                              
                                AssociatedMEList mlsnFull = mlsn.getMlsnInventoryT().getAssociatedMEList();
                                mlsnInv.setAssociatedMEList(mlsnFull);
                            }
                            oldMdInv.getMlsnList().getMlsnInv().add(mlsnInv);
                        }
                    } else {
                        System.out.println("oldMdInv.getMlsnList() == null");
                        MlsnList mlsnListOldMd = new MlsnList();
                        // first mlsnInv under this mdInv
                        
                        if (granularity.equals("ATTRS")) {
                            
                            if (mlsn.getSupportedRates() != null) {
                                System.out.println("me: " + mlsn.getSupportedRates().getLrs().get(0).getLayerRat());
                                System.out.println("layerRate: " + mlsn.getSupportedRates().getLayerRate().get(0));
                            }
                            mlsnInv.setMlsnAttrs(mlsn);
                        } else if (granularity.equals("FULL")) {
                            mlsnInv.setMlsnAttrs(mlsn);
                            AssociatedMEList mlsnFull = mlsn.getMlsnInventoryT().getAssociatedMEList();
                            mlsnInv.setAssociatedMEList(mlsnFull);
                            
                        }
                        mlsnListOldMd.getMlsnInv().add(mlsnInv);
                        oldMdInv.setMlsnList(mlsnListOldMd);
                    }
                    isNewMdInv = false;
                   
                    break;
                }
            } // for
           
            if (isNewMdInv) {
                // me belongs to a new mdInv
                MDInventoryT mdInv = new MDInventoryT();
                MlsnList mlsnListUnderNewMd = new MlsnList();
                // contruct mlsnInv
                mlsnInv.setMlsnNm(mlsn.getName().getMlsnNm());
                
                if (granularity.equals("ATTRS")) {
                    
                    if (mlsn.getSupportedRates() != null) {
                        System.out.println("me.getSupportedRates() != null");
                        System.out.println("me: " + mlsn.getSupportedRates().getLrs().get(0).getLayerRat());
                        System.out.println("layerRate: " + mlsn.getSupportedRates().getLayerRate().get(0));
                    }
                    mlsnInv.setMlsnAttrs(mlsn);
                } else if (granularity.equals("FULL")) {
                    mlsnInv.setMlsnAttrs(mlsn);
                    AssociatedMEList mlsnFull = mlsn.getMlsnInventoryT().getAssociatedMEList();
                    mlsnInv.setAssociatedMEList(mlsnFull);
                }
                
                mlsnListUnderNewMd.getMlsnInv().add(mlsnInv);
                mdInv.setMdNm(mlsn.getName().getMdNm());
                System.out.println("mdInv.setMlsnList(mlsnListUnderNewMd);");
                mdInv.setMlsnList(mlsnListUnderNewMd);
                
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

