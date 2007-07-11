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
import v1.tmf854.MDInventoryT.MeList;
import v1.tmf854.SimpleFilterT.IncludedObjectType;
import java.io.*;
import java.util.*;

/**
 *
 * @author baptiste
 */
public class CreateManagedElementResponse extends CreateResponse {
    
    /** Creates a new instance of CreateEquipmentHolderResponse */
    public CreateManagedElementResponse() {
    }
    
    public InventoryDataT createResponse2(List<?> objs, String granularity) {
        System.out.println("**************CreateManagedElementResponse:createResponse2**************");
        System.out.println("objs.size " + objs.size());
        System.out.println("a: " + super.getA());
        super.setA(1);
        
        //MDInventoryT mdInv = new MDInventoryT();
        MeList meList = new MeList();
        List<MEInventoryT> meInvs = meList.getMeInv();
        ListIterator<MEInventoryT> litMe = meInvs.listIterator();
        ManagedElementT previousMe = null;
        String previousMdNm = null;
        String mdNm1 = "";
        String meNm1 = "";
        // boolean newNode = false;
        boolean newMdInv = true;
        
        ManagedElementT  firstManagedElement = (ManagedElementT) objs.get(0);
        System.out.println("CreateMultiLayerSubNetwork: mdList.size " + getMdList().getMd().size());
        
        if (getMdList().getMd().size() == 0) {
            MDInventoryT firstMdInv = new MDInventoryT();
            firstMdInv.setMdNm(firstManagedElement.getName().getMdNm());
            getMdList().getMd().add(firstMdInv);
        }
        
        // loop through all MultiLayerSubNetwork retrieved and place them in the
        // final inventoryData response
        for (Object o : objs) {
            ManagedElementT  me = (ManagedElementT) o;
            
            // creates the MEInventory
            MEInventoryT meInv = new MEInventoryT();
            meInv.setMeNm(me.getName().getMeNm());
            if (granularity.equals("ATTRS"))
                meInv.setMeAttrs(me);
            else if (granularity.equals("FULL")) {
                     meInv.setMeAttrs(me);
                     NamingAttributesListT meFull = me.getMeInventoryT().getContainingMLSNNameList();
                     meInv.setContainingMLSNNameList(meFull);
            }
            meNm1 = me.getName().getMeNm();
            
            
            // loop through all existing ManagementDomains
            for (MDInventoryT oldMdInv : getMdList().getMd()) {
                System.out.println("oldMdInv.getMdNm() " + oldMdInv.getMdNm());
                
                if (oldMdInv.getMdNm().equals(me.getName().getMdNm())) {
                    // MultiLayerSubNetwork belongs to this ManagementDomain
                    if (oldMdInv.getMeList() != null) {
                        // MultilayerSubNetwork is not the first under this ManagementDomain
                        oldMdInv.getMeList().getMeInv().add(meInv);
                    } else {
                        // MultilayerSubNetwork is the first under this ManagementDomain
                        MeList meListOldMd = new MeList();
                        meListOldMd.getMeInv().add(meInv);
                        oldMdInv.setMeList(meListOldMd);
                    }
                    newMdInv = false;
                    break;
                }
            }
            if (newMdInv) {
                // MultiLayerSubNetwork belongs to a new ManagementDomain
                MDInventoryT mdInv = new MDInventoryT();
                MeList meListUnderNewMd = new MeList();
                meListUnderNewMd.getMeInv().add(meInv);
                mdInv.setMdNm(me.getName().getMdNm());
                mdInv.setMeList(meListUnderNewMd);
                
                getMdList().getMd().add(mdInv);
            }
        } // for
        
        // add the new MdList to final response
        refreshMdList(getMdList());
        //inventoryData.setMdList(mdList);
        System.out.println("***************fin CreateManagedElementResponse*************");
        
        return inventoryData;
    }
    
    public InventoryDataT getInventoryData() {
        
        return inventoryData;
    }
}

