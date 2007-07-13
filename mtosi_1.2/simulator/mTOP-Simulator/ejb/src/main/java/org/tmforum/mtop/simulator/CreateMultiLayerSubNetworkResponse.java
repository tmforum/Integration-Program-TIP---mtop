/*
 * CreateEquipmentHolderResponse.java
 *
 * Created on 7 mai 2007, 23:25
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.tmforum.mtop.simulator;

import v1.tmf854.*;
import v1.tmf854.InventoryDataT.MdList;
import v1.tmf854.MDInventoryT.MlsnList;
import v1.tmf854.SimpleFilterT.IncludedObjectType;
import java.io.*;
import java.util.*;

/**
 *
 * @author baptiste
 */
public class CreateMultiLayerSubNetworkResponse extends CreateResponse {
    
    /** Creates a new instance of CreateEquipmentHolderResponse */
    public CreateMultiLayerSubNetworkResponse() {
    }
    
   
    public InventoryDataT createResponse2(List<?> objs, String granularity) {
        System.out.println("**************CreateMultiLayerSubNetworkResponse:createResponse2**************");
       
        //MDInventoryT mdInv = new MDInventoryT();
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
            
            // creates the MLSNInventory
            MLSNInventoryT mlsnInv = new MLSNInventoryT();
            mlsnInv.setMlsnNm(mlsn.getName().getMlsnNm());
            if (granularity.equals("ATTRS"))
                mlsnInv.setMlsnAttrs(mlsn);
            else if (granularity.equals("FULL")) {
                mlsnInv.setMlsnAttrs(mlsn);
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

