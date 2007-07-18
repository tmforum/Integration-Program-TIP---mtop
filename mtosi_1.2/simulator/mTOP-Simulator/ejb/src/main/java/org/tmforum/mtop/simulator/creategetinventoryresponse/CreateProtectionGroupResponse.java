/*
 * CreateEquipmentHolderResponse.java
 *
 * Created on 7 mai 2007, 23:25
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.tmforum.mtop.simulator.creategetinventoryresponse;

import java.util.*;

import v1.tmf854.*;
import v1.tmf854.InventoryDataT.MdList;
import v1.tmf854.MDInventoryT.MeList;
import v1.tmf854.MEInventoryT.PgpList;
//import org.tmforum.mtop.simulator.entity.managedinventories.*;
//import org.tmforum.mtop.simulator.entity.managedinventories.MDInventoryT.MeList;
//import org.tmforum.mtop.simulator.entity.managedinventories.MEInventoryT.PgpList;
import v1.tmf854.SimpleFilterT.IncludedObjectType;

//import org.tmforum.mtop.simulator.entity.managedentities.*;

/**
 *
 * @author baptiste
 */
public class CreateProtectionGroupResponse extends CreateGetInventoryResponse{
    
    /** Creates a new instance of CreateEquipmentHolderResponse */
    public CreateProtectionGroupResponse() {
    }
    
    public InventoryDataT createResponse(List<?> objs, String granularity) {
        System.out.println("**************CreateProtectionGroupResponse:createResponse2**************");
        PgpList pgpList = new PgpList();
        List<PGPInventoryT> pgpInvs = pgpList.getPgpInv();
        ListIterator<PGPInventoryT> litMe = pgpInvs.listIterator();
        ProtectionGroupT previousMe = null;
        String previousMdNm = null;
        String mdNm1 = "";
        String meNm1 = "";
        String pgpNm1 = "";
        // boolean newNode = false;
        boolean newMdInv = true;
        boolean newMeInv = true;
        
        ProtectionGroupT  firstManagedElement = (ProtectionGroupT) objs.get(0);
        
        if (getMdList().getMd().size() == 0) {
            MDInventoryT firstMdInv = new MDInventoryT();
            firstMdInv.setMdNm(firstManagedElement.getName().getMdNm());
            getMdList().getMd().add(firstMdInv);
        }
        
        // loop through all ProtectionGroups retrieved
        for (Object o : objs) {
            ProtectionGroupT  pgp = (ProtectionGroupT) o;
            System.out.println("pgp.getNameeeeeeeeeee:  " + pgp.getName().getPgpNm());
            
            // creates the EhInventory
            PGPInventoryT pgpInv = new PGPInventoryT();
            pgpInv.setPgpNm(pgp.getName().getPgpNm());
            if (granularity.equals("ATTRS") || granularity.equals("FULL"))
                pgpInv.setPgpAttrs(pgp);
            
            pgpNm1 = pgp.getName().getPgpNm();
            
            // loop through all existing ManagementDomains
            for (MDInventoryT oldMdInv : getMdList().getMd()) {
                if (oldMdInv.getMdNm().equals(pgp.getName().getMdNm())) {
                    // ProtectionGroup belongs to this ManagementDomain
                    
                    if (oldMdInv.getMeList() == null) {
                        MeList firstMeListOfMd = new MeList();
                        MEInventoryT firstMeInvOfMd = new MEInventoryT();
                        firstMeInvOfMd.setMeNm(pgp.getName().getMeNm());
                        firstMeListOfMd.getMeInv().add(firstMeInvOfMd);
                        oldMdInv.setMeList(firstMeListOfMd);
                    }
                    // loop through all existing ManagedElements
                    for (MEInventoryT oldMeInv : oldMdInv.getMeList().getMeInv()) {
                        if (oldMeInv.getMeNm().equals(pgp.getName().getMeNm())) {
                            //ProtectionGroup belongs to this ManagedElement
                            if (oldMeInv.getPgpList() != null) {
                                // EqipmentHolder is not the first under this ManagedElement
                                oldMeInv.getPgpList().getPgpInv().add(pgpInv);
                            } else {
                                // ProtectionGroup is the first under this ManagedElement
                                PgpList PgpListOldMe = new PgpList();
                                PgpListOldMe.getPgpInv().add(pgpInv);
                                oldMeInv.setPgpList(PgpListOldMe);
                            }
                            newMeInv = false;
                            break;
                        }
                        if (newMeInv) {
                            // ProtectionGroup belongs to a new ManagedElement
                            MEInventoryT meInv = new MEInventoryT();
                            PgpList PgpListUnderNewMe = new PgpList();
                            PgpListUnderNewMe.getPgpInv().add(pgpInv);
                            meInv.setPgpList(pgpList);
                            // Add ManagedElement to ManagementDomain
                            oldMdInv.getMeList().getMeInv().add(meInv);
                        }
                    } // for me
                    newMdInv = false;
                    break;
                }
                if (newMdInv) {
                    // ProtectionGroup belongs to a new ManagedElement and a new ManagementDomain
                    MDInventoryT mdInvUnderNewMd = new MDInventoryT();
                    mdInvUnderNewMd.setMdNm(pgp.getName().getMdNm());
                    MeList meListUnderNewMd = new MeList();
                    MEInventoryT meInvUnderNewMd = new MEInventoryT();
                    meInvUnderNewMd.setMeNm(pgp.getName().getMeNm());
                    PgpList pgpListUnderNewMd = new PgpList();
                    pgpListUnderNewMd.getPgpInv().add(pgpInv);
                    meInvUnderNewMd.setPgpList(pgpList);
                    meListUnderNewMd.getMeInv().add(meInvUnderNewMd);
                    mdInvUnderNewMd.setMeList(meListUnderNewMd);
                    
                    getMdList().getMd().add(mdInvUnderNewMd);
                }
            } // for md
        } // for objs
        // add the new MdList to final response
        refreshMdList(getMdList());
        
        //inventoryData.setMdList(mdList);
        System.out.println("epgp pgpList " + getMdList().getMd().get(0).getMeList().getMeInv().get(0).getPgpList().getPgpInv().get(0).getPgpNm());
        System.out.println("***************fin CreateProtectionGroupResponse*************");
        
        return inventoryData;
    }
}


