/*
 * CreateTPPoolResponse.java
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
import v1.tmf854.MLSNInventoryT.TpPoolList;
import v1.tmf854.SimpleFilterT.IncludedObjectType;
import java.io.*;
import java.util.*;

/**
 *
 * @author baptiste
 */
public class CreateTpPoolResponse extends CreateResponse{
    
    /** Creates a new instance of CreateTPPoolResponse */
    public CreateTpPoolResponse() {
    }
    
    public InventoryDataT createResponse2(List<?> objs, String granularity) {
        System.out.println("**************CreateTPPoolResponse:createResponse2**************");
        System.out.println("objs.size " + objs.size());
        System.out.println("a: " + super.getA());
        
        //MDInventoryT mdInv = new MDInventoryT();
        TpPoolList tpPoolList = new TpPoolList();
        List<TPPoolInventoryT> tpPoolInvs = tpPoolList.getTpPoolInv();
        ListIterator<TPPoolInventoryT> litMe = tpPoolInvs.listIterator();
        TPPoolT previousMe = null;
        String previousMdNm = null;
        String mdNm1 = "";
        String meNm1 = "";
        String tpPoolNm1 = "";
        // boolean newNode = false;
        boolean newMdInv = true;
        boolean newMlsnInv = true;
        
        TPPoolT  firstManagedElement = (TPPoolT) objs.get(0);
        
        if (getMdList().getMd().size() == 0) {
            MDInventoryT firstMdInv = new MDInventoryT();
            firstMdInv.setMdNm(firstManagedElement.getName().getMdNm());
            getMdList().getMd().add(firstMdInv);
        }
        
        // loop through all TPPools retrieved
        for (Object o : objs) {
            TPPoolT  tpPool = (TPPoolT) o;
            // creates the TpPoolInventory
            TPPoolInventoryT tpPoolInv = new TPPoolInventoryT();
            tpPoolInv.setTppoolNm(tpPool.getName().getTppoolNm());
            if (granularity.equals("ATTRS") || granularity.equals("FULL"))
                tpPoolInv.setTppoolAttrs(tpPool);
            
            tpPoolNm1 = tpPool.getName().getTppoolNm();
            
            // loop through all existing ManagementDomains
            for (MDInventoryT oldMdInv : getMdList().getMd()) {
                if (oldMdInv.getMdNm().equals(tpPool.getName().getMdNm())) {
                    // TPPool belongs to this ManagementDomain
                    
                    if (oldMdInv.getMlsnList() == null) {
                        MlsnList firstMlsnListOfMd = new MlsnList();
                        MLSNInventoryT firstMlsnInvOfMd = new MLSNInventoryT();
                        firstMlsnInvOfMd.setMlsnNm(tpPool.getName().getMlsnNm());
                        firstMlsnListOfMd.getMlsnInv().add(firstMlsnInvOfMd);
                        oldMdInv.setMlsnList(firstMlsnListOfMd);
                    }
                    // loop through all existing ManagedElements
                    for (MLSNInventoryT oldMlsnInv : oldMdInv.getMlsnList().getMlsnInv()) {
                        if (oldMlsnInv.getMlsnNm().equals(tpPool.getName().getMlsnNm())) {
                            //TPPool belongs to this ManagedElement
                            if (oldMlsnInv.getTpPoolList() != null) {
                                // EqipmentHolder is not the first under this ManagedElement
                                oldMlsnInv.getTpPoolList().getTpPoolInv().add(tpPoolInv);
                            } else {
                                // TPPool is the first under this ManagedElement
                                TpPoolList tpPoolListOldMe = new TpPoolList();
                                tpPoolListOldMe.getTpPoolInv().add(tpPoolInv);
                                oldMlsnInv.setTpPoolList(tpPoolListOldMe);
                            }
                            newMlsnInv = false;
                            break;
                        }
                        if (newMlsnInv) {
                            // TPPool belongs to a new ManagedElement
                            MLSNInventoryT mslnInv = new MLSNInventoryT();
                            TpPoolList tpPoolListUnderNewMe = new TpPoolList();
                            tpPoolListUnderNewMe.getTpPoolInv().add(tpPoolInv);
                            mslnInv.setTpPoolList(tpPoolList);
                            // Add ManagedElement to ManagementDomain
                            oldMdInv.getMlsnList().getMlsnInv().add(mslnInv);
                        }
                    } // for me
                    newMdInv = false;
                    break;
                }
                if (newMdInv) {
                    // TPPool belongs to a new ManagedElement and a new ManagementDomain
                    MDInventoryT mdInvUnderNewMd = new MDInventoryT();
                    mdInvUnderNewMd.setMdNm(tpPool.getName().getMdNm());
                    MlsnList mslnListUnderNewMd = new MlsnList();
                    MLSNInventoryT mslnInvUnderNewMd = new MLSNInventoryT();
                    mslnInvUnderNewMd.setMlsnNm(tpPool.getName().getMlsnNm());
                    TpPoolList tpPoolListUnderNewMd = new TpPoolList();
                    tpPoolListUnderNewMd.getTpPoolInv().add(tpPoolInv);
                    mslnInvUnderNewMd.setTpPoolList(tpPoolList);
                    mslnListUnderNewMd.getMlsnInv().add(mslnInvUnderNewMd);
                    mdInvUnderNewMd.setMlsnList(mslnListUnderNewMd);
                    
                    getMdList().getMd().add(mdInvUnderNewMd);
                }
            } // for md
        } // for objs
        // add the new MdList to final response
        refreshMdList(getMdList());
        
        //inventoryData.setMdList(mdList);
        System.out.println("***************fin CreateTPPoolResponse*************");
        
        return inventoryData;
    }
    
    public InventoryDataT getInventoryData() {
        
        return inventoryData;
    }
}


