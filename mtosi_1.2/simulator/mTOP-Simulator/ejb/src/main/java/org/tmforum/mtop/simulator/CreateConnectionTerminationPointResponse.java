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
import v1.tmf854.PTPInventoryT.CtpList;
import v1.tmf854.MDInventoryT.MeList;
import v1.tmf854.MEInventoryT.EhList;
import v1.tmf854.PTPInventoryT.CtpList;
import v1.tmf854.MEInventoryT.PtpList;
//import org.tmforum.mtop.simulator.entity.managedinventories.*;
//import org.tmforum.mtop.simulator.entity.managedinventories.PTPInventoryT.CtpList;
//import org.tmforum.mtop.simulator.entity.managedinventories.MDInventoryT.MeList;
//import org.tmforum.mtop.simulator.entity.managedinventories.MEInventoryT.EhList;
//import org.tmforum.mtop.simulator.entity.managedinventories.PTPInventoryT.CtpList;
//import org.tmforum.mtop.simulator.entity.managedinventories.MEInventoryT.PtpList;

//import org.tmforum.mtop.simulator.entity.managedentities.*;

/**
 *
 * @author baptiste
 */
public class CreateConnectionTerminationPointResponse extends CreateGetInventoryResponse{
    
    public InventoryDataT createResponse(List<?> objs, String granularity) {
        System.out.println("**************CreateConnectionTerminationPointResponse:createResponse**************");
        CtpList ctpList = new CtpList();
        String previousMdNm = null;
        String mdNm1 = "";
        String meNm1 = "";
        String ptpNm1 = "";
        String ctpNm1 = "";
        boolean newMdInv = true;
        boolean newMeInv = true;
        boolean newPtpInv = true;
        
        ConnectionTerminationPointT  firstManagedElement = (ConnectionTerminationPointT) objs.get(0);
        System.out.println("CreateMultiLayerSubNetwork: mdList.size " + getMdList().getMd().size());
        
        if (getMdList().getMd().size() == 0) {
            MDInventoryT firstMdInv = new MDInventoryT();
            firstMdInv.setMdNm(firstManagedElement.getName().getMdNm());
            getMdList().getMd().add(firstMdInv);
        }
        
        // loop through all ConnectionTerminationPoints retrieved
        for (Object o : objs) {
            ConnectionTerminationPointT  ctp = (ConnectionTerminationPointT) o;
           // creates the CtpInventory
            CTPInventoryT ctpInv = new CTPInventoryT();
            ctpInv.setCtpNm(ctp.getName().getCtpNm());
            
            if (granularity.equals("ATTRS") || granularity.equals("FULL"))
                ctpInv.setCtpAttrs(ctp);
            ctpNm1 = ctp.getName().getCtpNm();
            
            // loop through all existing ManagementDomains
            for (MDInventoryT oldMdInv : getMdList().getMd()) {
               
                if (oldMdInv.getMdNm().equals(ctp.getName().getMdNm())) {
                    // PhysicalTerminationPoint belongs to this ManagementDomain
                
                    if (oldMdInv.getMeList() == null) {
                        // ConnectionTerminationPoint is the first under this MD
                        MeList firstMeListOfMd = new MeList();
                        MEInventoryT firstMeInvOfMd = new MEInventoryT();
                        firstMeInvOfMd.setMeNm(ctp.getName().getMeNm());
                        firstMeListOfMd.getMeInv().add(firstMeInvOfMd);
                        oldMdInv.setMeList(firstMeListOfMd);
                    }
                    
                    // loop through all existing ManagedElements
                    for (MEInventoryT oldMeInv : oldMdInv.getMeList().getMeInv()) {
                        if (oldMeInv.getMeNm().equals(ctp.getName().getMeNm())) {
                            // ConnectionTerminationPoint belongs to this ManagedElement
                            if (oldMeInv.getPtpList() == null) {
                                // ConnectionTerminationPoint is the first under this ME
                                PtpList firstPtpListOfMe = new PtpList();
                                PTPInventoryT firstPtpInvOfMe = new PTPInventoryT();
                                firstPtpInvOfMe.setPtpNm(ctp.getName().getPtpNm());
                                firstPtpListOfMe.getPtpInv().add(firstPtpInvOfMe);
                                oldMeInv.setPtpList(firstPtpListOfMe);
                            }
                            // loop through all existing PhysicalTerminationPoints
                            for (PTPInventoryT oldPtpInv : oldMeInv.getPtpList().getPtpInv()) {
                                if (oldPtpInv.getPtpNm().equals(ctp.getName().getPtpNm())) {
                                    //ConnectionTerminationPoint belongs to this ManagedElement
                                    if (oldPtpInv.getCtpList() != null) {
                                        // Connection Termination Point is not the first under this PTP
                                        oldPtpInv.getCtpList().getCtpInv().add(ctpInv);
                                    } else {
                                        // ConnectionTerminationPoint is the first under this PTP
                                        CtpList ctpListOldPtp = new CtpList();
                                        ctpListOldPtp.getCtpInv().add(ctpInv);
                                        oldPtpInv.setCtpList(ctpListOldPtp);
                                    }
                                    newPtpInv = false;
                                    break;
                                }
                                if (newPtpInv) {
                                    // ConnectionTerminationPoint belongs to a new PTP
                                    PTPInventoryT ptpInv = new PTPInventoryT();
                                    CtpList ctpListUnderNewPtp = new CtpList();
                                    ctpListUnderNewPtp.getCtpInv().add(ctpInv);
                                    ptpInv.setCtpList(ctpListUnderNewPtp);
                                    // Add PTP to ManagedElement
                                    oldMeInv.getPtpList().getPtpInv().add(ptpInv);
                                }
                            } // for ptp
                            newMeInv = false;
                            break;
                        }
                        if (newMeInv) {
                            // ConnectionTerminationPoint belongs to a new ManagedElement
                            MEInventoryT meInvUnderNewMd = new MEInventoryT();
                            meInvUnderNewMd.setMeNm(ctp.getName().getMdNm());
                            PtpList ptpListUnderNewMd = new PtpList();
                            PTPInventoryT ptpInvUnderNewMd = new PTPInventoryT();
                            ptpInvUnderNewMd.setPtpNm(ctp.getName().getPtpNm());
                            meInvUnderNewMd.setPtpList(ptpListUnderNewMd);
                            CtpList ctpListUnderNewMd = new CtpList();
                            ctpListUnderNewMd.getCtpInv().add(ctpInv);
                            ptpInvUnderNewMd.setCtpList(ctpListUnderNewMd); 
                            ptpListUnderNewMd.getPtpInv().add(ptpInvUnderNewMd);
                            
                           oldMdInv.getMeList().getMeInv().add(meInvUnderNewMd);
                        }
                    } // for me
                    
                    newMdInv = false;
                    break;
                }
                if (newMdInv) {
                    // PhysicalTerminationPoint belongs to a new ManagementDomain
                    CtpList ctpListUnderNewMd = new CtpList();
                    ctpListUnderNewMd.getCtpInv().add(ctpInv);
                    PTPInventoryT ptpInv = new PTPInventoryT();
                    ptpInv.setCtpList(ctpListUnderNewMd);
                    
                    MDInventoryT mdInvUnderNewMd = new MDInventoryT();
                    mdInvUnderNewMd.setMdNm(ctp.getName().getMdNm());
                    MeList meListUnderNewMd = new MeList();
                    MEInventoryT meInvUnderNewMd = new MEInventoryT();
                    meInvUnderNewMd.setMeNm(ctp.getName().getMeNm());
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
        System.out.println("***************fin CreateConnectionTerminationPointResponse*************");
        
        return inventoryData;
    }
    
    public InventoryDataT getInventoryData() {
        return inventoryData;
    }
}






