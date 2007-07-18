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
//import org.tmforum.mtop.simulator.entity.managedentities.FloatingTerminationPointT;

import v1.tmf854.*;
import v1.tmf854.InventoryDataT.MdList;
import v1.tmf854.SimpleFilterT.IncludedObjectType;
import v1.tmf854.FloatingTerminationPointT;
import v1.tmf854.MDInventoryT.MeList;
import v1.tmf854.FTPInventoryT.CtpList;
import v1.tmf854.MEInventoryT.FtpList;
//import org.tmforum.mtop.simulator.entity.managedinventories.*;
//import org.tmforum.mtop.simulator.entity.managedinventories.MDInventoryT.MeList;
//import org.tmforum.mtop.simulator.entity.managedinventories.FTPInventoryT.CtpList;
//import org.tmforum.mtop.simulator.entity.managedinventories.MEInventoryT.FtpList;

/**
 *
 * @author baptiste
 */
public class CreateFloatingTerminationPointResponse extends CreateGetInventoryResponse{
    
    /** Creates a new instance of CreateEquipmentHolderResponse */
    public CreateFloatingTerminationPointResponse() {
    }
    
    public InventoryDataT createResponse(List<?> objs, String granularity) {
        System.out.println("**************CreateFloatingTerminationPointResponse:createResponse2**************");
        System.out.println("objs.size " + objs.size());
        System.out.println("a: " + super.getA());
        
        //MDInventoryT mdInv = new MDInventoryT();
        FtpList FtpList = new FtpList();
        List<FTPInventoryT> ftpInvs = FtpList.getFtpInv();
        ListIterator<FTPInventoryT> litMe = ftpInvs.listIterator();
        FloatingTerminationPointT previousMe = null;
        String previousMdNm = null;
        String mdNm1 = "";
        String meNm1 = "";
        String ftpNm1 = "";
        // boolean newNode = false;
        boolean newMdInv = true;
        boolean newMeInv = true;
        
        FloatingTerminationPointT  firstManagedElement = (FloatingTerminationPointT) objs.get(0);
        System.out.println("CreateMultiLayerSubNetwork: mdList.size " + getMdList().getMd().size());
        
        if (getMdList().getMd().size() == 0) {
            MDInventoryT firstMdInv = new MDInventoryT();
            firstMdInv.setMdNm(firstManagedElement.getName().getMdNm());
            getMdList().getMd().add(firstMdInv);
        }
        
        
        
        
        // loop through all FloatingTerminationPoints retrieved
        for (Object o : objs) {
            FloatingTerminationPointT  ftp = (FloatingTerminationPointT) o;
            // creates the EhInventory
            FTPInventoryT ftpInv = new FTPInventoryT();
            ftpInv.setFtpNm(ftp.getName().getFtpNm());
            if (granularity.equals("ATTRS"))
                ftpInv.setFtpAttrs(ftp);
            
            ftpNm1 = ftp.getName().getFtpNm();
            
            // loop through all existing ManagementDomains
            for (MDInventoryT oldMdInv : getMdList().getMd()) {
                if (oldMdInv.getMdNm().equals(ftp.getName().getMdNm())) {
                    // FloatingTerminationPoint belongs to this ManagementDomain
                    
                    if (oldMdInv.getMeList() == null) {
                        MeList firstMeListOfMd = new MeList();
                        MEInventoryT firstMeInvOfMd = new MEInventoryT();
                        firstMeInvOfMd.setMeNm(ftp.getName().getMeNm());
                        firstMeListOfMd.getMeInv().add(firstMeInvOfMd);
                        oldMdInv.setMeList(firstMeListOfMd);
                    }
                    // loop through all existing ManagedElements
                    for (MEInventoryT oldMeInv : oldMdInv.getMeList().getMeInv()) {
                        if (oldMeInv.getMeNm().equals(ftp.getName().getMeNm())) {
                            //FloatingTerminationPoint belongs to this ManagedElement
                            if (oldMeInv.getFtpList() != null) {
                                // EqipmentHolder is not the first under this ManagedElement
                                oldMeInv.getFtpList().getFtpInv().add(ftpInv);
                            } else {
                                // FloatingTerminationPoint is the first under this ManagedElement
                                FtpList FtpListOldMe = new FtpList();
                                FtpListOldMe.getFtpInv().add(ftpInv);
                                oldMeInv.setFtpList(FtpListOldMe);
                            }
                            newMeInv = false;
                            break;
                        }
                        if (newMeInv) {
                            // FloatingTerminationPoint belongs to a new ManagedElement
                            MEInventoryT meInv = new MEInventoryT();
                            FtpList FtpListUnderNewMe = new FtpList();
                            FtpListUnderNewMe.getFtpInv().add(ftpInv);
                            meInv.setFtpList(FtpList);
                            // Add ManagedElement to ManagementDomain
                            oldMdInv.getMeList().getMeInv().add(meInv);
                        }
                    } // for me
                    newMdInv = false;
                    break;
                }
                if (newMdInv) {
                    // FloatingTerminationPoint belongs to a new ManagedElement and a new ManagementDomain
                    MDInventoryT mdInvUnderNewMd = new MDInventoryT();
                    mdInvUnderNewMd.setMdNm(ftp.getName().getMdNm());
                    MeList meListUnderNewMd = new MeList();
                    MEInventoryT meInvUnderNewMd = new MEInventoryT();
                    meInvUnderNewMd.setMeNm(ftp.getName().getMeNm());
                    FtpList FtpListUnderNewMd = new FtpList();
                    FtpListUnderNewMd.getFtpInv().add(ftpInv);
                    meInvUnderNewMd.setFtpList(FtpList);
                    meListUnderNewMd.getMeInv().add(meInvUnderNewMd);
                    mdInvUnderNewMd.setMeList(meListUnderNewMd);
                    
                    getMdList().getMd().add(mdInvUnderNewMd);
                }
            } // for md
        } // for objs
        // add the new MdList to final response
        refreshMdList(getMdList());
        
        //inventoryData.setMdList(mdList);
        System.out.println("***************fin CreateFloatingTerminationPointResponse*************");
        
        return inventoryData;
    }


}
        
       