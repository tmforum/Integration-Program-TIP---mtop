package org.tmforum.mtop.simulator;

import java.util.*;

import v1.tmf854.*;
import v1.tmf854.InventoryDataT.MdList;
import v1.tmf854.MDInventoryT.MeList;
import v1.tmf854.MEInventoryT.PtpList;
import v1.tmf854.PTPInventoryT.CtpList;
import v1.tmf854.SimpleFilterT.IncludedObjectType;

/**
 * Class which creates the response for ConnectionTerminationPoint managed
 * entities.
 */
public class CreateConnectionTerminationPointResponse extends CreateGetInventoryResponse {
    
    /** Creates a new instance of CreateConnectionTerminationPointResponse */
    public CreateConnectionTerminationPointResponse() {
    }
    
    public InventoryDataT createResponse(List<?> objs, String granularity) {
        CtpList ctpList = new CtpList();
        PtpList ptpList = new PtpList();
        List<PTPInventoryT> ptpInvs = ptpList.getPtpInv();
        boolean newMdInv = true;
        boolean newMeInv = true;
        boolean newCtpInv = true;
        boolean newPtpInv = true;
        ConnectionTerminationPointT  firstConnectionTerminationPoint =
                (ConnectionTerminationPointT) objs.get(0);
        
        if (getMdList().getMd().size() == 0) {
            MDInventoryT firstMdInv = new MDInventoryT();
            firstMdInv.setMdNm(firstConnectionTerminationPoint.getName().getMdNm());
            getMdList().getMd().add(firstMdInv);
        }
        
        // loop through all ConnectionTerminationPoints retrieved
        for (Object o : objs) {
            ConnectionTerminationPointT ctp = (ConnectionTerminationPointT) o;
            managedEntitiesIdsRetrieved.add(ctp.getId());
            // creates the CtpInventory
            CTPInventoryT ctpInv = new CTPInventoryT();
            ctpInv.setCtpNm(ctp.getName().getCtpNm());
            
            // loop through all existing mdInv
            for (MDInventoryT oldMdInv : getMdList().getMd()) {
                
                if (oldMdInv.getMdNm().equals(ctp.getName().getMdNm())) {
                    // CTPInv belongs to this md
                    
                    if (oldMdInv.getMeList() != null) {
                        
                        // loop through all existing meInv under this mdInv
                        for (MEInventoryT oldMeInv : oldMdInv.getMeList().getMeInv()) {
                            
                            if (oldMeInv.getMeNm().equals(ctp.getName().getMeNm())) {
                                //ctpInv belongs to this meInv
                                
                                if (oldMeInv.getPtpList() != null) {
                                    
                                    // loop through all existing PtpInv under this meInv
                                    for (PTPInventoryT oldPtpInv : oldMeInv.getPtpList().getPtpInv()) {
                                        System.out.println("oldPtpInv " + oldPtpInv.getPtpNm());
                                        
                                        if (oldPtpInv.getPtpNm().equals(ctp.getName().getPtpNm())) {
                                            // ctpInv is not the first under this ptpInv
                                            
                                            if (oldPtpInv.getCtpList() != null) {
                                                
                                                // loop through all existing ctpInv under this ptpinv
                                                for (CTPInventoryT oldCtpInv : oldPtpInv.getCtpList().getCtpInv()) {
                                                    
                                                    if (oldCtpInv.getCtpNm().equals(ctp.getName().getCtpNm())) {
                                                        // ctpInv of current ctp already exists
                                                        
                                                        if (oldCtpInv.getCtpAttrs() == null) {
                                                            // first ME, ATTRS request for this ctpInv
                                                            setCtpGranularity(granularity, oldCtpInv, ctp);
                                                        }
                                                        newCtpInv = false;
                                                        break;
                                                    }
                                                } //for oldCtpInv
                                                
                                                if (newCtpInv) {
                                                    // ctp belongs to a new ctpInv
                                                    setCtpGranularity(granularity, ctpInv, ctp);
                                                    oldPtpInv.getCtpList().getCtpInv().add(ctpInv);
                                                }
                                            } else {
                                                // ctp is the first under an old ctpInv
                                                CtpList ctpListOldPtp = new CtpList();
                                                ctpListOldPtp.getCtpInv().add(ctpInv);
                                                oldPtpInv.setCtpList(ctpListOldPtp);
                                            }
                                            newPtpInv = false;
                                            break;
                                        }
                                    } // for oldPtpInv
                                    if (newPtpInv) {
                                        // ctpInv belongs to a new ptpInv
                                        PTPInventoryT ptpInv = new PTPInventoryT();
                                        CtpList ctpListUnderNewPtp = new CtpList();
                                        setCtpGranularity(granularity, ctpInv, ctp);
                                        
                                        ctpListUnderNewPtp.getCtpInv().add(ctpInv);
                                        ptpInv.setPtpNm(ctp.getName().getPtpNm());
                                        ptpInv.setCtpList(ctpListUnderNewPtp);
                                        oldMeInv.getPtpList().getPtpInv().add(ptpInv);
                                    }
                                } else {
                                    // first ptpInv under this meInv
                                    PtpList firstPtpListOfMe = new PtpList();
                                    PTPInventoryT firstPtpInvOfMe = new PTPInventoryT();
                                    CtpList ctpListUnderNewPtp = new CtpList();
                                    setCtpGranularity(granularity, ctpInv, ctp);
                                    ctpListUnderNewPtp.getCtpInv().add(ctpInv);
                                    firstPtpInvOfMe.setPtpNm(ctp.getName().getPtpNm());
                                    firstPtpInvOfMe.setCtpList(ctpListUnderNewPtp);
                                    firstPtpListOfMe.getPtpInv().add(firstPtpInvOfMe);
                                    
                                    oldMeInv.setPtpList(firstPtpListOfMe);
                                }
                            }
                            newMeInv = false;
                            break;
                        } // for oldMeInv
                        
                        if (newMeInv) {
                            // ctpInv belongs to a new meInv
                            MEInventoryT meInvUnderNewMe = new MEInventoryT();
                            meInvUnderNewMe.setMeNm(ctp.getName().getMdNm());
                            //MeList meListUnderNewMd = new MeList();;
                            meInvUnderNewMe.setMeNm(ctp.getName().getMeNm());
                            PtpList ptpListUnderNewMe = new PtpList();
                            PTPInventoryT ptpInvUnderNewMe = new PTPInventoryT();
                            ptpInvUnderNewMe.setPtpNm(ctp.getName().getPtpNm());
                            CtpList ctpListUnderNewMe = new CtpList();
                            setCtpGranularity(granularity, ctpInv, ctp);
                            
                            ctpListUnderNewMe.getCtpInv().add(ctpInv);
                            ptpInvUnderNewMe.setCtpList(ctpListUnderNewMe);
                            ptpListUnderNewMe.getPtpInv().add(ptpInvUnderNewMe);
                            meInvUnderNewMe.setPtpList(ptpListUnderNewMe);
                            
                            oldMdInv.getMeList().getMeInv().add(meInvUnderNewMe);
                            
                        }
                    } else {
                        // first meInv under this mdInv
                        MeList firstMeListOfMd = new MeList();;
                        MEInventoryT firstMeInvOfMd = new MEInventoryT();
                        firstMeInvOfMd.setMeNm(ctp.getName().getMeNm());
                        
                        PtpList ptpListUnderNewMe = new PtpList();
                        PTPInventoryT ptpInvUnderNewMe = new PTPInventoryT();
                        ptpInvUnderNewMe.setPtpNm(ctp.getName().getPtpNm());
                        CtpList ctpListUnderNewMe = new CtpList();
                        setCtpGranularity(granularity, ctpInv, ctp);
                        
                        ctpListUnderNewMe.getCtpInv().add(ctpInv);
                        ptpInvUnderNewMe.setCtpList(ctpListUnderNewMe);
                        ptpListUnderNewMe.getPtpInv().add(ptpInvUnderNewMe);
                        firstMeInvOfMd.setPtpList(ptpListUnderNewMe);
                        firstMeListOfMd.getMeInv().add(firstMeInvOfMd);
                        
                        oldMdInv.setMeList(firstMeListOfMd);
                    }
                }
                newMdInv = false;
                break;
            }
            // for oldMeInv
            
            if (newMdInv) {
                // ehInv belongs to a new mdInv
                MDInventoryT mdInvUnderNewMd = new MDInventoryT();
                mdInvUnderNewMd.setMdNm(ctp.getName().getMdNm());
                
                MeList meListUnderNewMd = new MeList();
                MEInventoryT meInvUnderNewMd = new MEInventoryT();
                meInvUnderNewMd.setMeNm(ctp.getName().getMeNm());
                
                PtpList ptpListUnderNewMd = new PtpList();
                PTPInventoryT ptpInvUnderNewMd = new PTPInventoryT();
                ptpInvUnderNewMd.setPtpNm(ctp.getName().getPtpNm());
                
                CtpList ctpListUnderNewMd = new CtpList();
                setCtpGranularity(granularity, ctpInv, ctp);
                
                ctpListUnderNewMd.getCtpInv().add(ctpInv);
                ptpInvUnderNewMd.setCtpList(ctpListUnderNewMd);
                ptpListUnderNewMd.getPtpInv().add(ptpInvUnderNewMd);
                meInvUnderNewMd.setPtpList(ptpListUnderNewMd);
                meListUnderNewMd.getMeInv().add(meInvUnderNewMd);
                mdInvUnderNewMd.setMeList(meListUnderNewMd);
                
                getMdList().getMd().add(mdInvUnderNewMd);
            }
        } // for objs
        
        // add the new MdList to final response
        refreshMdList(getMdList());
        
        return inventoryData;
    }
    
    public void setCtpGranularity(String granularity, CTPInventoryT ctpInv, ConnectionTerminationPointT ctp) {
        
        if ((granularity.equals("ATTRS") || granularity.equals("FULL")) && ctpInv.getCtpAttrs() == null) 
            ctpInv.setCtpAttrs(ctp);
        
    }
    
    public InventoryDataT getInventoryData() {
        
        return inventoryData;
    }
}

