/*
 * CreateProtectionGroupResponse.java
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
import v1.tmf854.MDInventoryT.MeList;
import v1.tmf854.MEInventoryT.PgpList;
//import org.tmforum.mtop.simulator.entity.managedinventories.MDInventoryT.MeList;
//import org.tmforum.mtop.simulator.entity.managedinventories.*;
//import org.tmforum.mtop.simulator.entity.managedinventories.PGPInventoryT.CtpList;
//import org.tmforum.mtop.simulator.entity.managedinventories.MEInventoryT.PgpList;
import v1.tmf854.SimpleFilterT.IncludedObjectType;

//import org.tmforum.mtop.simulator.entity.managedentities.*;


/**
 *
 * @author baptiste
 */
public class CreateProtectionGroupResponse extends CreateGetInventoryResponse {
    
    /** Creates a new instance of CreateProtectionGroupResponse */
    public CreateProtectionGroupResponse() {
    }
    
    public InventoryDataT createResponse(List<?> objs, String granularity) {
        System.out.println("**************CreateProtectionGroupResponse:createResponse2**************");
        PgpList pgpList = new PgpList();
        List<PGPInventoryT> pgpInvs = pgpList.getPgpInv();
        String mdNm1 = "";
        String meNm1 = "";
        String pgpNm1 = "";
        // boolean newNode = false;
        boolean newMdInv = true;
        boolean newMeInv = true;
        boolean newPgpInv = true;
        
        ProtectionGroupT  firstManagedElement = (ProtectionGroupT) objs.get(0);
        System.out.println("CreateMultiLayerSubNetwork: mdList.size " + getMdList().getMd().size());
        
        if (getMdList().getMd().size() == 0) {
            MDInventoryT firstMdInv = new MDInventoryT();
            firstMdInv.setMdNm(firstManagedElement.getName().getMdNm());
            getMdList().getMd().add(firstMdInv);
        }
        
        // loop through all ProtectionGroups retrieved
        for (Object o : objs) {
            System.out.println("for objssssssssssssssssssssssssssssssssssssssssss");
            ProtectionGroupT  pgp = (ProtectionGroupT) o;
            // creates the PgpInventory
            PGPInventoryT pgpInv = new PGPInventoryT();
            pgpInv.setPgpNm(pgp.getName().getPgpNm());
            
//            if (granularity.equals("ATTRS"))
//                pgpInv.setPgpAttrs(ptp);
//            else if (granularity.equals("FULL")) {
//                pgpInv.setPgpAttrs(ptp);
//                NamingAttributesListT ptpFull = pgp.getPgpInventoryT().getSupportingEquipList();
//                if (ptpFull != null)
//                    pgpInv.setSupportingEquipList(ptpFull);
//            }
//
//            pgpNm1 = pgp.getName().getPgpNm();
//
            // loop through all existing mdInv
            for (MDInventoryT oldMdInv : getMdList().getMd()) {
                if (oldMdInv.getMdNm().equals(pgp.getName().getMdNm())) {
                    // pgpInv belongs to this mdInv
                    System.out.println("pgpInv belongs to this mdInv");
//                    if (oldMdInv.getMeList() == null) {
//                        System.out.println("oldMdInv.getMeList() == null");
//                        MeList firstMeListOfMd = new MeList();
//                        MEInventoryT firstMeInvOfMd = new MEInventoryT();
//                        firstMeInvOfMd.setMeNm(pgp.getName().getMeNm());
//                        firstMeListOfMd.getMeInv().add(firstMeInvOfMd);
//                        oldMdInv.setMeList(firstMeListOfMd);
//                    }
                    
                    if (oldMdInv.getMeList() != null) {
                        // loop through all existing meInv under this mdInv
                        for (MEInventoryT oldMeInv : oldMdInv.getMeList().getMeInv()) {
                            if (oldMeInv.getMeNm().equals(pgp.getName().getMeNm())) {
                                //pgpInv belongs to this meInv
                                System.out.println("pgpInv belongs to this meInv");
                                if (oldMeInv.getPgpList() != null) {
                                    // pgpInv is not the first under this meInv
                                    // loop through all existing pgpInv under this meinv
                                    for (PGPInventoryT oldPgpInv : oldMeInv.getPgpList().getPgpInv()) {
                                        if (oldPgpInv.getPgpNm().equals(pgp.getName().getPgpNm())) {
                                            System.out.println("ptpinv of current ptp already exists");
                                            // ptpinv of current ptp already exists
                                            // (PTP, NAME) has already been treated
                                            //*************************************************
                                            if ((granularity.equals("ATTRS") || granularity.equals("FULL")) && oldPgpInv.getPgpAttrs() == null) {
                                                // first ME, ATTRS request for this pgpInv
                                                oldPgpInv.setPgpAttrs(pgp);
                                            }
                                            //****************************************************
                                            newPgpInv = false;
                                            break;
                                        }
                                    } //for oldPgpInv
                                    if (newPgpInv) {
                                        System.out.println("new ptInv");
                                        // pgpInv belongs to a new pgpInv
                                        //**************************************
                                        if (granularity.equals("ATTRS") || granularity.equals("FULL")) {
                                            // first ME, ATTRS request for this pgpInv
                                            pgpInv.setPgpAttrs(pgp);
                                        }
                                        //**************************************
                                        oldMeInv.getPgpList().getPgpInv().add(pgpInv);
                                    }
                                    
                                } else {
                                    // pgpInv is the first under this meInv
                                    System.out.println("// pgpInv is the first under this meInv");
                                    PgpList pgpListOldMe = new PgpList();
                                    pgpListOldMe.getPgpInv().add(pgpInv);
                                    oldMeInv.setPgpList(pgpListOldMe);
                                }
                                newMeInv = false;
                                break;
                            }
                        } // for oldMeInv
                        
                        if (newMeInv) {
                            // pgpInv belongs to a new meInv
                            System.out.println("// pgpInv belongs to a new meInv ");
                            MEInventoryT meInv = new MEInventoryT();
                            PgpList pgpListUnderNewMe = new PgpList();
                            //*********************************************
                            pgpInv.setPgpNm(pgp.getName().getPgpNm());
                            if (granularity.equals("ATTRS") || granularity.equals("FULL")) {
                                // first ME, ATTRS request for this pgpInv
                                pgpInv.setPgpAttrs(pgp);
                            }
                            //**********************************************
                            pgpListUnderNewMe.getPgpInv().add(pgpInv);
                            meInv.setPgpList(pgpListUnderNewMe);
                            // Add ManagedElement to ManagementDomain
                            oldMdInv.getMeList().getMeInv().add(meInv);
                        }
                    } else {
                        // first meInv under this mdInv
                        System.out.println("oldMdInv.getMeList() == null");
                        MeList firstMeListOfMd = new MeList();
                        MEInventoryT firstMeInvOfMd = new MEInventoryT();
                        PgpList pgpListUnderNewMe = new PgpList();
                        //**************************************
                        pgpInv.setPgpNm(pgp.getName().getPgpNm());
                        if (granularity.equals("ATTRS") || granularity.equals("FULL")) {
                            // first ME, ATTRS request for this pgpInv
                            pgpInv.setPgpAttrs(pgp);
                        }
                        //**************************************
                        pgpListUnderNewMe.getPgpInv().add(pgpInv);
                        System.out.println("pgpListUnderNewMe.size " + pgpListUnderNewMe.getPgpInv().size());
                        firstMeInvOfMd.setMeNm(pgp.getName().getMeNm());
                        firstMeInvOfMd.setPgpList(pgpListUnderNewMe);
                        firstMeListOfMd.getMeInv().add(firstMeInvOfMd);
                        oldMdInv.setMeList(firstMeListOfMd);
                    }
                }
                newMdInv = false;
                break;
            } // for oldMdInv
            if (newMdInv) {
                System.out.println("// pgpInv belongs to a new mdInv");
                // pgpInv belongs to a new mdInv
                MDInventoryT mdInvUnderNewMd = new MDInventoryT();
                mdInvUnderNewMd.setMdNm(pgp.getName().getMdNm());
                MeList meListUnderNewMd = new MeList();
                MEInventoryT meInvUnderNewMd = new MEInventoryT();
                meInvUnderNewMd.setMeNm(pgp.getName().getMeNm());
                PgpList pgpListUnderNewMd = new PgpList();
                //******************************************************
                pgpInv.setPgpNm(pgp.getName().getPgpNm());
                if (granularity.equals("ATTRS") || granularity.equals("FULL")) {
                    // first ME, ATTRS request for this pgpInv
                    pgpInv.setPgpAttrs(pgp);
                }
                //******************************************************
                pgpListUnderNewMd.getPgpInv().add(pgpInv);
                meInvUnderNewMd.setPgpList(pgpListUnderNewMd);
                meListUnderNewMd.getMeInv().add(meInvUnderNewMd);
                mdInvUnderNewMd.setMeList(meListUnderNewMd);
                
                getMdList().getMd().add(mdInvUnderNewMd);
            }
        } // for objs
        
        // add the new MdList to final response
        refreshMdList(getMdList());
        
        //inventoryData.setMdList(mdList);
        System.out.println("***************fin CreateProtectionGroupResponse*************");
        
        return inventoryData;
    }
    
    public InventoryDataT getInventoryData() {
        
        return inventoryData;
    }
}
