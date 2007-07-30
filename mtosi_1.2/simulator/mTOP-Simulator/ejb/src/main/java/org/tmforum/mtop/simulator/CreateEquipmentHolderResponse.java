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
import v1.tmf854.EquipmentHolderT;
import v1.tmf854.MDInventoryT.MeList;
import v1.tmf854.MEInventoryT.EhList;
//import org.tmforum.mtop.simulator.entity.managedinventories.*;
//import org.tmforum.mtop.simulator.entity.managedinventories.MDInventoryT.MeList;
//import org.tmforum.mtop.simulator.entity.managedinventories.MEInventoryT.EhList;

//import org.tmforum.mtop.simulator.entity.managedentities.*;

/**
 *
 * @author baptiste
 */
public class CreateEquipmentHolderResponse extends CreateGetInventoryResponse{
    
    /** Creates a new instance of CreateEquipmentHolderResponse */
    public CreateEquipmentHolderResponse() {
    }
    
    public InventoryDataT createResponse(List<?> objs, String granularity) {
        System.out.println("**************CreateEquipmentHolderResponse:createResponse2**************");
        EhList ehList = new EhList();
        List<EHInventoryT> ehInvs = ehList.getEhInv();
        ListIterator<EHInventoryT> litMe = ehInvs.listIterator();
        EquipmentHolderT previousMe = null;
        String previousMdNm = null;
        String mdNm1 = "";
        String meNm1 = "";
        String ehNm1 = "";
        // boolean newNode = false;
        boolean newMdInv = true;
        boolean newMeInv = true;
        
        EquipmentHolderT  firstManagedElement = (EquipmentHolderT) objs.get(0);
        
        if (getMdList().getMd().size() == 0) {
            MDInventoryT firstMdInv = new MDInventoryT();
            firstMdInv.setMdNm(firstManagedElement.getName().getMdNm());
            getMdList().getMd().add(firstMdInv);
        }
        
        // loop through all EquipmentHolders retrieved
        for (Object o : objs) {
            EquipmentHolderT  eh = (EquipmentHolderT) o;
            // creates the EhInventory
            EHInventoryT ehInv = new EHInventoryT();
            ehInv.setEhNm(eh.getName().getEhNm());
            
            if (granularity.equals("ATTRS") || granularity.equals("FULL")) 
                ehInv.setEhAttrs(eh);
            ehNm1 = eh.getName().getEhNm();
            
            // loop through all existing ManagementDomains
            for (MDInventoryT oldMdInv : getMdList().getMd()) {
               
                if (oldMdInv.getMdNm().equals(eh.getName().getMdNm())) {
                    // EquipmentHolder belongs to this ManagementDomain
                    
                    if (oldMdInv.getMeList() == null) {
                        MeList firstMeListOfMd = new MeList();
                        MEInventoryT firstMeInvOfMd = new MEInventoryT();
                        firstMeInvOfMd.setMeNm(eh.getName().getMeNm());
                        firstMeListOfMd.getMeInv().add(firstMeInvOfMd);
                        oldMdInv.setMeList(firstMeListOfMd);
                    }
                    
                    // loop through all existing ManagedElements
                    for (MEInventoryT oldMeInv : oldMdInv.getMeList().getMeInv()) {
                       
                        if (oldMeInv.getMeNm().equals(eh.getName().getMeNm())) {
                            //EquipmentHolder belongs to this ManagedElement
                        
                            if (oldMeInv.getEhList() != null) {
                                // EqipmentHolder is not the first under this ManagedElement
                                oldMeInv.getEhList().getEhInv().add(ehInv);
                            } else {
                                // EquipmentHolder is the first under this ManagedElement
                                EhList ehListOldMe = new EhList();
                                ehListOldMe.getEhInv().add(ehInv);
                                oldMeInv.setEhList(ehListOldMe);
                            }
                            newMeInv = false;
                            break;
                        }
                        
                        if (newMeInv) {
                            // EquipmentHolder belongs to a new ManagedElement
                            MEInventoryT meInv = new MEInventoryT();
                            EhList ehListUnderNewMe = new EhList();
                            ehListUnderNewMe.getEhInv().add(ehInv);
                            meInv.setEhList(ehList);
                            // Add ManagedElement to ManagementDomain
                            oldMdInv.getMeList().getMeInv().add(meInv);
                        }
                    } // for me
                    newMdInv = false;
                    break;
                }
                if (newMdInv) {
                    // EquipmentHolder belongs to a new ManagedElement and a new ManagementDomain
                    MDInventoryT mdInvUnderNewMd = new MDInventoryT();
                    mdInvUnderNewMd.setMdNm(eh.getName().getMdNm());
                    MeList meListUnderNewMd = new MeList();
                    MEInventoryT meInvUnderNewMd = new MEInventoryT();
                    meInvUnderNewMd.setMeNm(eh.getName().getMeNm());
                    EhList ehListUnderNewMd = new EhList();
                    ehListUnderNewMd.getEhInv().add(ehInv);
                    meInvUnderNewMd.setEhList(ehList);
                    meListUnderNewMd.getMeInv().add(meInvUnderNewMd);
                    mdInvUnderNewMd.setMeList(meListUnderNewMd);
                    
                    getMdList().getMd().add(mdInvUnderNewMd);
                }
            } // for md
        } // for objs
        // add the new MdList to final response
        refreshMdList(getMdList());
        
        //inventoryData.setMdList(mdList);
        System.out.println("***************fin CreateEquipmentHolderResponse*************");
        
        return inventoryData;
    }
    
    public InventoryDataT getInventoryData() {
        
        return inventoryData;
    }
}


