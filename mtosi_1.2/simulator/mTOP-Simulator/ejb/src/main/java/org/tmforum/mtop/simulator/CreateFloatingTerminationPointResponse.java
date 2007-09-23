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
        FtpList ftpList = new FtpList();
        List<FTPInventoryT> ftpInvs = ftpList.getFtpInv();
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
                                            
                                            if (oldFtpInv.getFtpAttrs() == null || oldFtpInv.getSupportingEquipList() == null)
                                                setFtpGranularity(granularity, oldFtpInv, ftp);
                                            
                                            newFtpInv = false;
                                            
                                            break;
                                        }
                                    } //for oldFtpInv
                                    
                                    if (newFtpInv) {
                                        setFtpGranularity(granularity, ftpInv, ftp);
                                        oldMeInv.getFtpList().getFtpInv().add(ftpInv);
                                    }
                                } else {
                                    // ftpInv is the first under this meInv
                                    FtpList ftpListOldMe = new FtpList();
                                    setFtpGranularity(granularity, ftpInv, ftp);
                                    ftpListOldMe.getFtpInv().add(ftpInv);
                                    oldMeInv.setFtpList(ftpListOldMe);
                                }
                                newMeInv = false;
                                break;
                            }
                        } // for oldMeInv
                        
                        if (newMeInv) {
                            // ftpInv belongs to a new meInv
                            MEInventoryT meInv = new MEInventoryT();
                            FtpList ftpListUnderNewMe = new FtpList();
                            ftpInv.setFtpNm(ftp.getName().getFtpNm());
                            setFtpGranularity(granularity, ftpInv, ftp);
                            ftpListUnderNewMe.getFtpInv().add(ftpInv);
                            meInv.setMeNm(ftp.getName().getMeNm());
                            meInv.setFtpList(ftpListUnderNewMe);
                            oldMdInv.getMeList().getMeInv().add(meInv);
                        }
                    } else {
                        // first meInv under this mdInv
                        MeList firstMeListOfMd = new MeList();
                        MEInventoryT firstMeInvOfMd = new MEInventoryT();
                        FtpList ftpListUnderNewMe = new FtpList();
                        ftpInv.setFtpNm(ftp.getName().getFtpNm());
                        setFtpGranularity(granularity, ftpInv, ftp);
                        ftpListUnderNewMe.getFtpInv().add(ftpInv);
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
                setFtpGranularity(granularity, ftpInv, ftp);
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
    
    public void setFtpGranularity(String granularity, FTPInventoryT ftpInv, FloatingTerminationPointT ftp) {
        if (granularity.equals("ATTRS"))
            ftpInv.setFtpAttrs(ftp);
        else if (granularity.equals("FULL")) {
            ftpInv.setFtpAttrs(ftp);
            NamingAttributesListT ftpFull = ftp.getFtpInventoryT().getSupportingEquipList();
            
            if (ftpFull != null)
                ftpInv.setSupportingEquipList(ftpFull);
        }
    }
    
    public InventoryDataT getInventoryData() {
        
        return inventoryData;
    }
}
