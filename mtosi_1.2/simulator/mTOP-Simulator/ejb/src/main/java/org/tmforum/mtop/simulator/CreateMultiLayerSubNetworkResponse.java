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
import v1.tmf854.MDInventoryT.MlsnList;
//import org.tmforum.mtop.simulator.entity.managedinventories.*;
//import org.tmforum.mtop.simulator.entity.managedinventories.MDInventoryT.MlsnList;

//import org.tmforum.mtop.simulator.entity.managedentities.*;



/**
 *
 * @author baptiste
 */
public class CreateMultiLayerSubNetworkResponse extends CreateGetInventoryResponse {
    
    /** Creates a new instance of CreateEquipmentHolderResponse */
    public CreateMultiLayerSubNetworkResponse() {
    }
    
   
    public InventoryDataT createResponse(List<?> objs, String granularity) {
        System.out.println("**************CreateMultiLayerSubNetworkResponse:createResponse2**************");
       
        MlsnList mlsnList = new MlsnList();
        List<MLSNInventoryT> mlsnInvs = mlsnList.getMlsnInv();
        ListIterator<MLSNInventoryT> litMlsn = mlsnInvs.listIterator();
        MultiLayerSubnetworkT previousMlsn = null;
        String previousMdNm = null;
        String mdNm1 = "";
        String mlsnNm1 = "";
        // boolean newNode = false;
        boolean newMdInv = true;
        
        MultiLayerSubnetworkT  firstMultiLayerSubNetWork = (MultiLayerSubnetworkT) objs.get(0);
        System.out.println("CreateMultiLayerSubNetwork: mdList.size " + getMdList().getMd().size());
        
        if (getMdList().getMd().size() == 0) {
            MDInventoryT firstMdInv = new MDInventoryT();
          firstMdInv.setMdNm(firstMultiLayerSubNetWork.getName().getMdNm());
            getMdList().getMd().add(firstMdInv);
        }
         
        // loop through all MultiLayerSubNetwork retrieved and place them in the
        // final inventoryData response
        for (Object o : objs) {
            MultiLayerSubnetworkT  mlsn = (MultiLayerSubnetworkT) o;
           //construct supportedRates
            if (mlsn.getSupportedRates() != null) {
           System.out.println("" +  mlsn.getSupportedRates().getLrs().get(0).getLayerRat());
           System.out.println("" + mlsn.getSupportedRates().getLayerRate().get(0));
            }
             // creates the MLSNInventory
            MLSNInventoryT mlsnInv = new MLSNInventoryT();
            mlsnInv.setMlsnNm(mlsn.getName().getMlsnNm());
            if (granularity.equals("ATTRS"))
                mlsnInv.setMlsnAttrs(mlsn);
            else if (granularity.equals("FULL")) {
                mlsnInv.setMlsnAttrs(mlsn);
                System.out.println("mlsn.getMlsnInventoryTTTTTTTTTTTTTTTTT() " + mlsn.getMlsnInventoryT());
                AssociatedMEList mlsnFull = mlsn.getMlsnInventoryT().getAssociatedMEList();
                mlsnInv.setAssociatedMEList(mlsnFull);
            }
            
            mlsnNm1 = mlsn.getName().getMlsnNm();
            
            // loop through all existing ManagementDomains
            for (MDInventoryT oldMdInv : getMdList().getMd()) {
                System.out.println("oldMdInv.getMdNm() " + oldMdInv.getMdNm());
                
                if (oldMdInv.getMdNm().equals(mlsn.getName().getMdNm())) {
                    // MultiLayerSubNetwork belongs to an existing ManagementDomain
                    if (oldMdInv.getMlsnList() != null) {
                        // MultilayerSubNetwork is not the first under this ManagementDomain
                        oldMdInv.getMlsnList().getMlsnInv().add(mlsnInv);
                    } else {
                        // MultilayerSubNetwork is the first under this ManagementDomain
                        MlsnList mlsnListOldMd = new MlsnList();
                        mlsnListOldMd.getMlsnInv().add(mlsnInv);
                        oldMdInv.setMlsnList(mlsnListOldMd);
                    }
                    newMdInv = false;
                    break;
                }
            }
            if (newMdInv) {
                // MultiLayerSubNetwork belongs to a new ManagementDomain
                MDInventoryT mdInv = new MDInventoryT();
                MlsnList mlsnListUnderNewMd = new MlsnList();
                mlsnListUnderNewMd.getMlsnInv().add(mlsnInv);
                mdInv.setMdNm(mlsn.getName().getMdNm());
                mdInv.setMlsnList(mlsnListUnderNewMd);
                getMdList().getMd().add(mdInv);
            }
        } // for
          // add the new MdList to final response
         refreshMdList(getMdList());
        //inventoryData.setMdList(mdList);
        System.out.println("***************fin CreateMultiLayerSubNetworkResponse*************");
        
        return inventoryData;
    }
    
    public InventoryDataT getInventoryData() {
        
        return inventoryData;
    }
}

