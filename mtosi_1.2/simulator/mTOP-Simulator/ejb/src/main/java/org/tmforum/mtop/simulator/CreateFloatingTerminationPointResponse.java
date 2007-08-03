/*
 * CreateFloatingTerminationPointResponse.java
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
import v1.tmf854.FTPInventoryT.CtpList;
import v1.tmf854.MEInventoryT.FtpList;
//import org.tmforum.mtop.simulator.entity.managedinventories.MDInventoryT.MeList;
//import org.tmforum.mtop.simulator.entity.managedinventories.*;
//import org.tmforum.mtop.simulator.entity.managedinventories.FTPInventoryT.CtpList;
//import org.tmforum.mtop.simulator.entity.managedinventories.MEInventoryT.FtpList;
import v1.tmf854.SimpleFilterT.IncludedObjectType;

//import org.tmforum.mtop.simulator.entity.managedentities.*;


/**
 *
 * @author baptiste
 */
public class CreateFloatingTerminationPointResponse extends CreateGetInventoryResponse {
    
    /** Creates a new instance of CreateFloatingTerminationPointResponse */
    public CreateFloatingTerminationPointResponse() {
    }
    
    public InventoryDataT createResponse(List<?> objs, String granularity) {
        System.out.println("**************CreateFloatingTerminationPointResponse:createResponse2**************");
        FtpList ptpList = new FtpList();
        List<FTPInventoryT> ftpInvs = ptpList.getFtpInv();
        String mdNm1 = "";
        String meNm1 = "";
        String ptpNm1 = "";
        // boolean newNode = false;
        boolean newMdInv = true;
        boolean newMeInv = true;
        boolean newFtpInv = true;
        
        FloatingTerminationPointT  firstManagedElement = (FloatingTerminationPointT) objs.get(0);
        System.out.println("CreateMultiLayerSubNetwork: mdList.size " + getMdList().getMd().size());
        
        if (getMdList().getMd().size() == 0) {
            MDInventoryT firstMdInv = new MDInventoryT();
            firstMdInv.setMdNm(firstManagedElement.getName().getMdNm());
            getMdList().getMd().add(firstMdInv);
        }
        
        // loop through all FloatingTerminationPoints retrieved
        for (Object o : objs) {
            System.out.println("for objssssssssssssssssssssssssssssssssssssssssss");
            FloatingTerminationPointT  ftp = (FloatingTerminationPointT) o;
            // creates the FtpInventory
            FTPInventoryT ftpInv = new FTPInventoryT();
            ftpInv.setFtpNm(ftp.getName().getFtpNm());
            
//            if (granularity.equals("ATTRS"))
//                ftpInv.setFtpAttrs(ptp);
//            else if (granularity.equals("FULL")) {
//                ftpInv.setFtpAttrs(ptp);
//                NamingAttributesListT ptpFull = ftp.getFtpInventoryT().getSupportingEquipList();
//                if (ptpFull != null)
//                    ftpInv.setSupportingEquipList(ptpFull);
//            }
//
//            ptpNm1 = ftp.getName().getFtpNm();
//
            // loop through all existing mdInv
            for (MDInventoryT oldMdInv : getMdList().getMd()) {
                if (oldMdInv.getMdNm().equals(ftp.getName().getMdNm())) {
                    // ftpInv belongs to this mdInv
                    System.out.println("ftpInv belongs to this mdInv");
//                    if (oldMdInv.getMeList() == null) {
//                        System.out.println("oldMdInv.getMeList() == null");
//                        MeList firstMeListOfMd = new MeList();
//                        MEInventoryT firstMeInvOfMd = new MEInventoryT();
//                        firstMeInvOfMd.setMeNm(ftp.getName().getMeNm());
//                        firstMeListOfMd.getMeInv().add(firstMeInvOfMd);
//                        oldMdInv.setMeList(firstMeListOfMd);
//                    }
                    
                    if (oldMdInv.getMeList() != null) {
                        // loop through all existing meInv under this mdInv
                        for (MEInventoryT oldMeInv : oldMdInv.getMeList().getMeInv()) {
                            if (oldMeInv.getMeNm().equals(ftp.getName().getMeNm())) {
                                //ftpInv belongs to this meInv
                                System.out.println("ftpInv belongs to this meInv");
                                if (oldMeInv.getFtpList() != null) {
                                    // ftpInv is not the first under this meInv
                                    // loop through all existing ftpInv under this meinv
                                    for (FTPInventoryT oldFtpInv : oldMeInv.getFtpList().getFtpInv()) {
                                        if (oldFtpInv.getFtpNm().equals(ftp.getName().getFtpNm())) {
                                            System.out.println("ptpinv of current ptp already exists");
                                            // ptpinv of current ptp already exists
                                            // (PTP, NAME) has already been treated
                                            //*************************************************
                                            if (granularity.equals("ATTRS") && oldFtpInv.getFtpAttrs() == null) {
                                                // first ME, ATTRS request for this ftpInv
                                                oldFtpInv.setFtpAttrs(ftp);
                                            } else if (granularity.equals("FULL") && oldFtpInv.getSupportingEquipList() == null) {
                                                // first PTP, FULL request for this ftpInv
                                                oldFtpInv.setFtpAttrs(ftp);
                                                NamingAttributesListT ptpFull = ftp.getFtpInventoryT().getSupportingEquipList();
                                                if (ptpFull != null)
                                                    oldFtpInv.setSupportingEquipList(ptpFull);
                                            }
                                            //****************************************************
                                            newFtpInv = false;
                                            break;
                                        }
                                    } //for oldFtpInv
                                    if (newFtpInv) {
                                        System.out.println("new ptInv");
                                        // ftpInv belongs to a new ftpInv
                                        //**************************************
                                        if (granularity.equals("ATTRS")) {
                                            // first ME, ATTRS request for this ftpInv
                                            ftpInv.setFtpAttrs(ftp);
                                        } else if (granularity.equals("FULL")){
                                            // first PTP, FULL request for this ftpInv
                                            ftpInv.setFtpAttrs(ftp);
                                            NamingAttributesListT ptpFull = ftp.getFtpInventoryT().getSupportingEquipList();
                                            if (ptpFull != null)
                                                ftpInv.setSupportingEquipList(ptpFull);
                                        }
                                        //**************************************
                                        oldMeInv.getFtpList().getFtpInv().add(ftpInv);
                                    }
                                    
                                } else {
                                    // ftpInv is the first under this meInv
                                    System.out.println("// ftpInv is the first under this meInv");
                                    FtpList ptpListOldMe = new FtpList();
                                    ptpListOldMe.getFtpInv().add(ftpInv);
                                    oldMeInv.setFtpList(ptpListOldMe);
                                }
                                newMeInv = false;
                                break;
                            }
                        } // for oldMeInv
                      
                        if (newMeInv) {
                            // ftpInv belongs to a new meInv
                            System.out.println("// ftpInv belongs to a new meInv ");
                            MEInventoryT meInv = new MEInventoryT();
                            FtpList ptpListUnderNewMe = new FtpList();
                            //*********************************************
                            ftpInv.setFtpNm(ftp.getName().getFtpNm());
                            if (granularity.equals("ATTRS")) {
                                // first ME, ATTRS request for this ftpInv
                                ftpInv.setFtpAttrs(ftp);
                            } else if (granularity.equals("FULL")) {
                                ftpInv.setFtpAttrs(ftp);
                                NamingAttributesListT ptpFull = ftp.getFtpInventoryT().getSupportingEquipList();
                                if (ptpFull != null)
                                    ftpInv.setSupportingEquipList(ptpFull);
                            }
                            //**********************************************
                            ptpListUnderNewMe.getFtpInv().add(ftpInv);
                            meInv.setFtpList(ptpListUnderNewMe);
                            // Add ManagedElement to ManagementDomain
                            oldMdInv.getMeList().getMeInv().add(meInv);
                        }
                    } else {
                        // first meInv under this mdInv
                        System.out.println("oldMdInv.getMeList() == null");
                        MeList firstMeListOfMd = new MeList();
                        MEInventoryT firstMeInvOfMd = new MEInventoryT();
                        FtpList ptpListUnderNewMe = new FtpList();
                        //**************************************
                        ftpInv.setFtpNm(ftp.getName().getFtpNm());
                        if (granularity.equals("ATTRS")) {
                            // first ME, ATTRS request for this ftpInv
                            ftpInv.setFtpAttrs(ftp);
                        } else if (granularity.equals("FULL")){
                            // first PTP, FULL request for this ftpInv
                            ftpInv.setFtpAttrs(ftp);
                            NamingAttributesListT ptpFull = ftp.getFtpInventoryT().getSupportingEquipList();
                            if (ptpFull != null)
                                ftpInv.setSupportingEquipList(ptpFull);
                        }
                        //**************************************
                        ptpListUnderNewMe.getFtpInv().add(ftpInv);
                        System.out.println("ptpListUnderNewMe.size " + ptpListUnderNewMe.getFtpInv().size());
                        firstMeInvOfMd.setMeNm(ftp.getName().getMeNm());
                        firstMeInvOfMd.setFtpList(ptpListUnderNewMe);
                        firstMeListOfMd.getMeInv().add(firstMeInvOfMd);
                        oldMdInv.setMeList(firstMeListOfMd);
                    }
                }
                newMdInv = false;
                break;
            } // for oldMdInv
            if (newMdInv) {
                System.out.println("// ftpInv belongs to a new mdInv");
                // ftpInv belongs to a new mdInv
                MDInventoryT mdInvUnderNewMd = new MDInventoryT();
                mdInvUnderNewMd.setMdNm(ftp.getName().getMdNm());
                MeList meListUnderNewMd = new MeList();
                MEInventoryT meInvUnderNewMd = new MEInventoryT();
                meInvUnderNewMd.setMeNm(ftp.getName().getMeNm());
                FtpList ptpListUnderNewMd = new FtpList();
                //******************************************************
                ftpInv.setFtpNm(ftp.getName().getFtpNm());
                if (granularity.equals("ATTRS")) {
                    // first ME, ATTRS request for this ftpInv
                    ftpInv.setFtpAttrs(ftp);
                } else if (granularity.equals("FULL")) {
                    ftpInv.setFtpAttrs(ftp);
                    NamingAttributesListT ptpFull = ftp.getFtpInventoryT().getSupportingEquipList();
                    if (ptpFull != null)
                        ftpInv.setSupportingEquipList(ptpFull);
                }
                //******************************************************
                ptpListUnderNewMd.getFtpInv().add(ftpInv);
                meInvUnderNewMd.setFtpList(ptpListUnderNewMd);
                meListUnderNewMd.getMeInv().add(meInvUnderNewMd);
                mdInvUnderNewMd.setMeList(meListUnderNewMd);
                
                getMdList().getMd().add(mdInvUnderNewMd);
            }
        } // for objs
        
        // add the new MdList to final response
        refreshMdList(getMdList());
        
        //inventoryData.setMdList(mdList);
        System.out.println("***************fin CreateFloatingTerminationPointResponse*************");
        
        return inventoryData;
    }
    
    public InventoryDataT getInventoryData() {
        
        return inventoryData;
    }
}
