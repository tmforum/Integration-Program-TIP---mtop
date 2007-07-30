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
import v1.tmf854.MDInventoryT.MeList;
import v1.tmf854.MEInventoryT.EpgpList;
//import org.tmforum.mtop.simulator.entity.managedinventories.*;
//import org.tmforum.mtop.simulator.entity.managedinventories.MDInventoryT.MeList;
//import org.tmforum.mtop.simulator.entity.managedinventories.MEInventoryT.EpgpList;

//import org.tmforum.mtop.simulator.entity.managedentities.*;

/**
 *
 * @author baptiste
 */
public class CreateEProtectionGroupResponse extends CreateGetInventoryResponse{
    
    /** Creates a new instance of CreateEquipmentHolderResponse */
    public CreateEProtectionGroupResponse() {
    }
    
    public InventoryDataT createResponse(List<?> objs, String granularity) {
        System.out.println("**************CreateEEProtectionGroupResponse:createResponse2**************");
        System.out.println("objs.size " + objs.size());
        System.out.println("a: " + super.getA());
        
        //MDInventoryT mdInv = new MDInventoryT();
        EpgpList epgpList = new EpgpList();
        List<EPGPInventoryT> epgpInvs = epgpList.getEpgpInv();
        ListIterator<EPGPInventoryT> litMe = epgpInvs.listIterator();
        EProtectionGroupT previousMe = null;
        String previousMdNm = null;
        String mdNm1 = "";
        String meNm1 = "";
        String epgpNm1 = "";
        // boolean newNode = false;
        boolean newMdInv = true;
        boolean newMeInv = true;
        
        EProtectionGroupT  firstManagedElement = (EProtectionGroupT) objs.get(0);
     
         if (getMdList().getMd().size() == 0) {
            MDInventoryT firstMdInv = new MDInventoryT();
            firstMdInv.setMdNm(firstManagedElement.getName().getMdNm());
            getMdList().getMd().add(firstMdInv);
        }
     
        // loop through all EProtectionGroups retrieved
        for (Object o : objs) {
            EProtectionGroupT  epgp = (EProtectionGroupT) o;
            System.out.println("epgp.getNameeeeeeeeeee:  " + epgp.getName().getEpgpNm());
            
            // creates the EhInventory
            EPGPInventoryT epgpInv = new EPGPInventoryT();
            epgpInv.setEpgpNm(epgp.getName().getEpgpNm());
            if (granularity.equals("ATTRS") || granularity.equals("FULL"))
                epgpInv.setEpgpAttrs(epgp);
            
            epgpNm1 = epgp.getName().getEpgpNm();
            
            // loop through all existing ManagementDomains
            for (MDInventoryT oldMdInv : getMdList().getMd()) {
                if (oldMdInv.getMdNm().equals(epgp.getName().getMdNm())) {
                    // EProtectionGroup belongs to this ManagementDomain
                    
                    if (oldMdInv.getMeList() == null) {
                        MeList firstMeListOfMd = new MeList();
                        MEInventoryT firstMeInvOfMd = new MEInventoryT();
                        firstMeInvOfMd.setMeNm(epgp.getName().getMeNm());
                        firstMeListOfMd.getMeInv().add(firstMeInvOfMd);
                        oldMdInv.setMeList(firstMeListOfMd);
                    }
                    // loop through all existing ManagedElements
                    for (MEInventoryT oldMeInv : oldMdInv.getMeList().getMeInv()) {
                        if (oldMeInv.getMeNm().equals(epgp.getName().getMeNm())) {
                            //EProtectionGroup belongs to this ManagedElement
                            if (oldMeInv.getEpgpList() != null) {
                                // EqipmentHolder is not the first under this ManagedElement
                                oldMeInv.getEpgpList().getEpgpInv().add(epgpInv);
                            } else {
                                // EProtectionGroup is the first under this ManagedElement
                                EpgpList EpgpListOldMe = new EpgpList();
                                EpgpListOldMe.getEpgpInv().add(epgpInv);
                                oldMeInv.setEpgpList(EpgpListOldMe);
                            }
                            newMeInv = false;
                            break;
                        }
                        if (newMeInv) {
                            // EProtectionGroup belongs to a new ManagedElement
                            MEInventoryT meInv = new MEInventoryT();
                            EpgpList EpgpListUnderNewMe = new EpgpList();
                            EpgpListUnderNewMe.getEpgpInv().add(epgpInv);
                            meInv.setEpgpList(epgpList);
                            // Add ManagedElement to ManagementDomain
                            oldMdInv.getMeList().getMeInv().add(meInv);
                        }
                    } // for me
                    newMdInv = false;
                    break;
                }
                if (newMdInv) {
                    // EProtectionGroup belongs to a new ManagedElement and a new ManagementDomain
                    MDInventoryT mdInvUnderNewMd = new MDInventoryT();
                    mdInvUnderNewMd.setMdNm(epgp.getName().getMdNm());
                    MeList meListUnderNewMd = new MeList();
                    MEInventoryT meInvUnderNewMd = new MEInventoryT();
                    meInvUnderNewMd.setMeNm(epgp.getName().getMeNm());
                    EpgpList epgpListUnderNewMd = new EpgpList();
                    epgpListUnderNewMd.getEpgpInv().add(epgpInv);
                    meInvUnderNewMd.setEpgpList(epgpList);
                    meListUnderNewMd.getMeInv().add(meInvUnderNewMd);
                    mdInvUnderNewMd.setMeList(meListUnderNewMd);
                    
                    getMdList().getMd().add(mdInvUnderNewMd);
                }
            } // for md
        } // for objs
        // add the new MdList to final response
        refreshMdList(getMdList());
        
        //inventoryData.setMdList(mdList);
        System.out.println("eepgp epgpList " + getMdList().getMd().get(0).getMeList().getMeInv().get(0).getEpgpList().getEpgpInv().get(0).getEpgpNm());
        System.out.println("***************fin CreateEEProtectionGroupResponse*************");
        
        return inventoryData;
    }
}

        
       