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
import v1.tmf854.MEInventoryT.EhList;
import v1.tmf854.PTPInventoryT.CtpList;
import v1.tmf854.SimpleFilterT.IncludedObjectType;
import v1.tmf854.MEInventoryT.PtpList;
import java.io.*;
import java.util.*;

/**
 *
 * @author baptiste
 */
public class CreateConnectionTerminationPointResponse extends CreateResponse{
    
    
    public InventoryDataT createResponse2(List<?> objs, String granularity) {
        System.out.println("**************CreatePhysicalTerminationPointResponse:createResponse2**************");
        System.out.println("objs.size " + objs.size());
        System.out.println("a: " + super.getA());
        
        //MDInventoryT mdInv = new MDInventoryT();
        CtpList ctpList = new CtpList();
        List<CTPInventoryT> ctpInvs = ctpList.getCtpInv();
        ListIterator<CTPInventoryT> litMe = ctpInvs.listIterator();
        ConnectionTerminationPointT previousMe = null;
        String previousMdNm = null;
        String mdNm1 = "";
        String meNm1 = "";
        String ptpNm1 = "";
        String ctpNm1 = "";
        // boolean newNode = false;
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
            // creates the EhInventory
            CTPInventoryT ctpInv = new CTPInventoryT();
            
            
            ctpInv.setCtpNm(ctp.getName().getCtpNm());
            if (granularity.equals("ATTRS"))
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
                                    
                                    CtpList ctpListUnderNewPtp = new CtpList();
                                    ctpListUnderNewPtp.getCtpInv().add(ctpInv);
                                    PTPInventoryT ptpInv = new PTPInventoryT();
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
                            CtpList ctpListUnderNewMe = new CtpList();
                            ctpListUnderNewMe.getCtpInv().add(ctpInv);
                            PTPInventoryT ptpInv = new PTPInventoryT();
                            ptpInv.setCtpList(ctpListUnderNewMe);
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
        System.out.println("***************fin CreatePhysicalTerminationPointResponse*************");
        
        return inventoryData;
    }
    
    
    public InventoryDataT getInventoryData() {
        return inventoryData;
    }
    
    
}






