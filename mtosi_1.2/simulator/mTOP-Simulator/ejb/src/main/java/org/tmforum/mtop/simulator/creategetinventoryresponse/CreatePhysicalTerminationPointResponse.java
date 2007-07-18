/*
 * CreatePhysicalTerminationPointResponse.java
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
import v1.tmf854.PTPInventoryT.CtpList;
import v1.tmf854.MEInventoryT.PtpList;
//import org.tmforum.mtop.simulator.entity.managedinventories.MDInventoryT.MeList;
//import org.tmforum.mtop.simulator.entity.managedinventories.*;
//import org.tmforum.mtop.simulator.entity.managedinventories.PTPInventoryT.CtpList;
//import org.tmforum.mtop.simulator.entity.managedinventories.MEInventoryT.PtpList;
import v1.tmf854.SimpleFilterT.IncludedObjectType;

//import org.tmforum.mtop.simulator.entity.managedentities.*;


/**
 *
 * @author baptiste
 */
public class CreatePhysicalTerminationPointResponse extends CreateGetInventoryResponse {
    
    /** Creates a new instance of CreatePhysicalTerminationPointResponse */
    public CreatePhysicalTerminationPointResponse() {
    }
   
    public InventoryDataT createResponse(List<?> objs, String granularity) {
        System.out.println("**************CreatePhysicalTerminationPointResponse:createResponse2**************");
        PtpList PtpList = new PtpList();
        List<PTPInventoryT> ptpInvs = PtpList.getPtpInv();
        ListIterator<PTPInventoryT> litMe = ptpInvs.listIterator();
        PhysicalTerminationPointT previousMe = null;
        String previousMdNm = null;
        String mdNm1 = "";
        String meNm1 = "";
        String ptpNm1 = "";
        // boolean newNode = false;
        boolean newMdInv = true;
        boolean newMeInv = true;
        
        PhysicalTerminationPointT  firstManagedElement = (PhysicalTerminationPointT) objs.get(0);
        System.out.println("CreateMultiLayerSubNetwork: mdList.size " + getMdList().getMd().size());
        
        if (getMdList().getMd().size() == 0) {
            MDInventoryT firstMdInv = new MDInventoryT();
            firstMdInv.setMdNm(firstManagedElement.getName().getMdNm());
            getMdList().getMd().add(firstMdInv);
        }
        
        
        
        
        // loop through all PhysicalTerminationPoints retrieved
        for (Object o : objs) {
            PhysicalTerminationPointT  ptp = (PhysicalTerminationPointT) o;
            // creates the EhInventory
            PTPInventoryT ptpInv = new PTPInventoryT();
            ptpInv.setPtpNm(ptp.getName().getPtpNm());
            if (granularity.equals("ATTRS"))
                ptpInv.setPtpAttrs(ptp);
             else if (granularity.equals("FULL")) {
                ptpInv.setPtpAttrs(ptp);
                NamingAttributesListT ptpFull = ptp.getPtpInventoryT().getSupportingEquipList();
                ptpInv.setSupportingEquipList(ptpFull);
            }
            
            ptpNm1 = ptp.getName().getPtpNm();
            
            // loop through all existing ManagementDomains
            for (MDInventoryT oldMdInv : getMdList().getMd()) {
                if (oldMdInv.getMdNm().equals(ptp.getName().getMdNm())) {
                    // PhysicalTerminationPoint belongs to this ManagementDomain
                    
                    if (oldMdInv.getMeList() == null) {
                        MeList firstMeListOfMd = new MeList();
                        MEInventoryT firstMeInvOfMd = new MEInventoryT();
                        firstMeInvOfMd.setMeNm(ptp.getName().getMeNm());
                        firstMeListOfMd.getMeInv().add(firstMeInvOfMd);
                        oldMdInv.setMeList(firstMeListOfMd);
                    }
                    // loop through all existing ManagedElements
                    for (MEInventoryT oldMeInv : oldMdInv.getMeList().getMeInv()) {
                        if (oldMeInv.getMeNm().equals(ptp.getName().getMeNm())) {
                            //PhysicalTerminationPoint belongs to this ManagedElement
                            if (oldMeInv.getPtpList() != null) {
                                // EqipmentHolder is not the first under this ManagedElement
                                oldMeInv.getPtpList().getPtpInv().add(ptpInv);
                            } else {
                                // PhysicalTerminationPoint is the first under this ManagedElement
                                PtpList ptpListOldMe = new PtpList();
                                ptpListOldMe.getPtpInv().add(ptpInv);
                                oldMeInv.setPtpList(ptpListOldMe);
                            }
                            newMeInv = false;
                            break;
                        }
                        if (newMeInv) {
                            // PhysicalTerminationPoint belongs to a new ManagedElement
                            MEInventoryT meInv = new MEInventoryT();
                            PtpList ptpListUnderNewMe = new PtpList();
                            ptpListUnderNewMe.getPtpInv().add(ptpInv);
                            meInv.setPtpList(ptpListUnderNewMe);
                            // Add ManagedElement to ManagementDomain
                            oldMdInv.getMeList().getMeInv().add(meInv);
                        }
                    } // for me
                    newMdInv = false;
                    break;
                }
                if (newMdInv) {
                    // PhysicalTerminationPoint belongs to a new ManagedElement and a new ManagementDomain
                    MDInventoryT mdInvUnderNewMd = new MDInventoryT();
                    mdInvUnderNewMd.setMdNm(ptp.getName().getMdNm());
                    MeList meListUnderNewMd = new MeList();
                    MEInventoryT meInvUnderNewMd = new MEInventoryT();
                    meInvUnderNewMd.setMeNm(ptp.getName().getMeNm());
                    PtpList ptpListUnderNewMd = new PtpList();
                    ptpListUnderNewMd.getPtpInv().add(ptpInv);
                    meInvUnderNewMd.setPtpList(ptpListUnderNewMd);
                    meListUnderNewMd.getMeInv().add(meInvUnderNewMd);
                    mdInvUnderNewMd.setMeList(meListUnderNewMd);
                    
                    getMdList().getMd().add(mdInvUnderNewMd);
                }
            } // for md
        } // for objs
        // add the new MdList to final response
        refreshMdList(getMdList());
        
        //inventoryData.setMdList(mdList);
        System.out.println("***************fin CreatePhysicalTerminationPointResponse*************");
        
        return inventoryData;
    }

}


