
package org.tmforum.mtop.simulator;

import java.util.*;

import v1.tmf854.*;
import v1.tmf854.SimpleFilterT.IncludedObjectType;
import v1.tmf854.InventoryDataT.MdList;
import v1.tmf854.MDInventoryT.MlsnList;

public class CreateMultiLayerSubnetworkResponse extends CreateGetInventoryResponse {
    
    public CreateMultiLayerSubnetworkResponse() {
    }
    
    public InventoryDataT createResponse(List<?> objs, String granularity) {
        MlsnList mlsnList = new MlsnList();
        List<MLSNInventoryT> mlsnInvs = mlsnList.getMlsnInv();
        ListIterator<MLSNInventoryT> litMlsn = mlsnInvs.listIterator();
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
            // creates the MLSNInventory
            MLSNInventoryT mlsnInv = new MLSNInventoryT();
            //mlsnInv.setMlsnNm("<element1>aa</element1>");
            mlsnInv.setMlsnNm(mlsn.getName().getMlsnNm());
            
            // loop through all existing mdInv
            for (MDInventoryT oldMdInv : getMdList().getMd()) {
                
                if (mlsn.getName().getMdNm().equals(oldMdInv.getMdNm())) {
                    // meinv belongs to this mdInv
                    
                    if (oldMdInv.getMlsnList() != null) {
                        
                        // loop through all existing mlsnInv under this mdinv
                        for (MLSNInventoryT oldMlsnInv : oldMdInv.getMlsnList().getMlsnInv()) {
                            
                            if (mlsn.getName().getMlsnNm().equals(oldMlsnInv.getMlsnNm())) {
                                // meinv of current me already exists
                                // (MLSN, NAMLSN) has already been treated
                                
                                if (oldMlsnInv.getMlsnAttrs() == null || oldMlsnInv.getAssociatedMEList() == null)
                                    setMlsnGranularity(granularity, mlsnInv, mlsn);
                                newMlsnInv = false;
                                
                                break;
                            }
                        } // for
                        
                        if (newMlsnInv) {
                            // me belongs to a new mlsnInv
                            setMlsnGranularity(granularity, mlsnInv, mlsn);
                            oldMdInv.getMlsnList().getMlsnInv().add(mlsnInv);
                        }
                    } else {
                        // first mlsnInv under this mdInv
                        MlsnList mlsnListOldMd = new MlsnList();
                        setMlsnGranularity(granularity, mlsnInv, mlsn);
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
                setMlsnGranularity(granularity, mlsnInv, mlsn);
                mlsnListUnderNewMd.getMlsnInv().add(mlsnInv);
                mdInv.setMdNm(mlsn.getName().getMdNm());
                mdInv.setMlsnList(mlsnListUnderNewMd);
                
                getMdList().getMd().add(mdInv);
            }
        } // for
        
        // add the new MdList to final response
        refreshMdList(getMdList());
        
        return inventoryData;
    }
    
    public void setMlsnGranularity(String granularity, MLSNInventoryT mlsnInv, MultiLayerSubnetworkT mlsn) {
        if (granularity.equals("ATTRS")) {
            
            if (mlsn.getSupportedRates() != null) {
                mlsn.getSupportedRates().getLrs().get(0).getLayerRat();
                mlsn.getSupportedRates().getLayerRate().get(0);
            }
            mlsnInv.setMlsnAttrs(mlsn);
        } else if (granularity.equals("FULL")) {
            mlsnInv.setMlsnAttrs(mlsn);
            AssociatedMEList mlsnFull = mlsn.getMlsnInventoryT().getAssociatedMEList();
            mlsnInv.setAssociatedMEList(mlsnFull);
        }
    }
    
    public InventoryDataT getInventoryData() {
        
        return inventoryData;
    }
}

