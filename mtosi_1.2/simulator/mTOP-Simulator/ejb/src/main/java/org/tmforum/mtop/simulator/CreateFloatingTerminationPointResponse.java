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
import v1.tmf854.SimpleFilterT.IncludedObjectType;

/**
 *
 * Class which creates the response for FloatingTerminationPoint managed
 * entities.
 */
public class CreateFloatingTerminationPointResponse extends CreateGetInventoryResponse {
    
    public InventoryDataT createResponse(List<?> objs, String granularity) {
         System.out.println("*****CreateFTPResponse******");
        FtpList ftpList = new FtpList();
        List<FTPInventoryT> ftpInvs = ftpList.getFtpInv();
        String mdNm1 = "";
        String meNm1 = "";
        String ptpNm1 = "";
        boolean newMdInv = true;
        boolean newMeInv = true;
        boolean newFtpInv = true;
        FloatingTerminationPointT  firstManagedElement = (FloatingTerminationPointT) objs.get(0);
        
        if (getMdList().getMd().size() == 0) {
            MDInventoryT firstMdInv = new MDInventoryT();
            firstMdInv.setMdNm(firstManagedElement.getName().getMdNm());
            getMdList().getMd().add(firstMdInv);
        }
        
        // loop through all FloatingTerminationPoints retrieved
        for (Object o : objs) {
            FloatingTerminationPointT  ftp = (FloatingTerminationPointT) o;
            managedEntitiesIdsRetrieved.add(ftp.getId());
            FTPInventoryT ftpInv = new FTPInventoryT();
            ftpInv.setFtpNm(ftp.getName().getFtpNm());
            
            // loop through all existing mdInv
            for (MDInventoryT oldMdInv : getMdList().getMd()) {
                
                if (oldMdInv.getMdNm().equals(ftp.getName().getMdNm())) {
                    
                    if (oldMdInv.getMeList() != null) {
                        
                        // loop through all existing meInv under this mdInv
                        for (MEInventoryT oldMeInv : oldMdInv.getMeList().getMeInv()) {
                            
                            if (oldMeInv.getMeNm().equals(ftp.getName().getMeNm())) {
                                
                                //ftpInv belongs to this meInv
                                if (oldMeInv.getFtpList() != null) {
                                    // ftpInv is not the first under this meInv
                                    
                                    // loop through all existing ftpInv under this meinv
                                    for (FTPInventoryT oldFtpInv : oldMeInv.getFtpList().getFtpInv()) {
                                        
                                        if (oldFtpInv.getFtpNm().equals(ftp.getName().getFtpNm())) {
                                            
                                            if (granularity.equals("ATTRS") && oldFtpInv.getFtpAttrs() == null) {
                                                // first ME, ATTRS request for this ftpInv
                                                oldFtpInv.setFtpAttrs(ftp);
                                            }
                                            
                                            else if (granularity.equals("FULL") && oldFtpInv.getSupportingEquipList() == null) {
                                                // first PTP, FULL request for this ftpInv
                                                oldFtpInv.setFtpAttrs(ftp);
                                                NamingAttributesListT ptpFull = ftp.getFtpInventoryT().getSupportingEquipList();
                                                
                                                if (ptpFull != null)
                                                    oldFtpInv.setSupportingEquipList(ptpFull);
                                            }
                                            newFtpInv = false;
                                            
                                            break;
                                        }
                                    } //for oldFtpInv
                                    
                                    if (newFtpInv) {
                                        
                                        if (granularity.equals("ATTRS")) {
                                            // first ME, ATTRS request for this ftpInv
                                            ftpInv.setFtpAttrs(ftp);
                                        }
                                        
                                        else if (granularity.equals("FULL")){
                                            // first PTP, FULL request for this ftpInv
                                            ftpInv.setFtpAttrs(ftp);
                                            NamingAttributesListT ptpFull = ftp.getFtpInventoryT().getSupportingEquipList();
                                            
                                            if (ptpFull != null)
                                                ftpInv.setSupportingEquipList(ptpFull);
                                        }
                                        oldMeInv.getFtpList().getFtpInv().add(ftpInv);
                                    }
                                } else {
                                    // ftpInv is the first under this meInv
                                    FtpList ftpListOldMe = new FtpList();
                                    ftpListOldMe.getFtpInv().add(ftpInv);
                                    oldMeInv.setFtpList(ftpListOldMe);
                                }
                                newMeInv = false;
                                break;
                            }
                        } // for oldMeInv
                        
                        if (newMeInv) {
                            // ftpInv belongs to a new meInv
                            System.out.println("// ftpInv belongs to a new meInv ");
                            MEInventoryT meInv = new MEInventoryT();
                            FtpList ftpListUnderNewMe = new FtpList();
                            ftpInv.setFtpNm(ftp.getName().getFtpNm());
                            
                            if (granularity.equals("ATTRS")) {
                                // first ME, ATTRS request for this ftpInv
                                ftpInv.setFtpAttrs(ftp);
                            }
                            
                            else if (granularity.equals("FULL")) {
                                ftpInv.setFtpAttrs(ftp);
                                NamingAttributesListT ptpFull = ftp.getFtpInventoryT().getSupportingEquipList();
                                
                                if (ptpFull != null)
                                    ftpInv.setSupportingEquipList(ptpFull);
                            }
                            
                            ftpListUnderNewMe.getFtpInv().add(ftpInv);
                            meInv.setMeNm(ftp.getName().getMeNm());
                            meInv.setFtpList(ftpListUnderNewMe);
                            oldMdInv.getMeList().getMeInv().add(meInv);
                        }
                    } else {
                        // first meInv under this mdInv
                        System.out.println("oldMdInv.getMeList() == null");
                        MeList firstMeListOfMd = new MeList();
                        MEInventoryT firstMeInvOfMd = new MEInventoryT();
                        FtpList ftpListUnderNewMe = new FtpList();
                        ftpInv.setFtpNm(ftp.getName().getFtpNm());
                        
                        if (granularity.equals("ATTRS")) {
                            // first ME, ATTRS request for this ftpInv
                            ftpInv.setFtpAttrs(ftp);
                        }
                        
                        else if (granularity.equals("FULL")){
                            // first PTP, FULL request for this ftpInv
                            ftpInv.setFtpAttrs(ftp);
                            NamingAttributesListT ptpFull = ftp.getFtpInventoryT().getSupportingEquipList();
                            
                            if (ptpFull != null)
                                ftpInv.setSupportingEquipList(ptpFull);
                        }
                        
                        ftpListUnderNewMe.getFtpInv().add(ftpInv);
                        System.out.println("ftpListUnderNewMe.size " + ftpListUnderNewMe.getFtpInv().size());
                        firstMeInvOfMd.setMeNm(ftp.getName().getMeNm());
                        firstMeInvOfMd.setFtpList(ftpListUnderNewMe);
                        firstMeListOfMd.getMeInv().add(firstMeInvOfMd);
                        oldMdInv.setMeList(firstMeListOfMd);
                    }
                }
                newMdInv = false;
                
                break;
            } // for oldMdInv
            
            if (newMdInv) {
                // ftpInv belongs to a new mdInv
                MDInventoryT mdInvUnderNewMd = new MDInventoryT();
                mdInvUnderNewMd.setMdNm(ftp.getName().getMdNm());
                MeList meListUnderNewMd = new MeList();
                MEInventoryT meInvUnderNewMd = new MEInventoryT();
                meInvUnderNewMd.setMeNm(ftp.getName().getMeNm());
                FtpList ftpListUnderNewMd = new FtpList();
                ftpInv.setFtpNm(ftp.getName().getFtpNm());
                
                if (granularity.equals("ATTRS")) {
                    // first ME, ATTRS request for this ftpInv
                    ftpInv.setFtpAttrs(ftp);
                }
                
                else if (granularity.equals("FULL")) {
                    ftpInv.setFtpAttrs(ftp);
                    NamingAttributesListT ptpFull = ftp.getFtpInventoryT().getSupportingEquipList();
                    
                    if (ptpFull != null)
                        ftpInv.setSupportingEquipList(ptpFull);
                }
                
                ftpListUnderNewMd.getFtpInv().add(ftpInv);
                meInvUnderNewMd.setFtpList(ftpListUnderNewMd);
                meListUnderNewMd.getMeInv().add(meInvUnderNewMd);
                mdInvUnderNewMd.setMeList(meListUnderNewMd);
                
                getMdList().getMd().add(mdInvUnderNewMd);
            }
        } // for objs
        
        // add the new MdList to final response
        refreshMdList(getMdList());
        
        return inventoryData;
    }
    
    public InventoryDataT getInventoryData() {
        
        return inventoryData;
    }
}
