/*
 * GetInventoryBean.java
 *
 * Created on 15 avril 2007, 15:20
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.tmforum.mtop.populatedatabase;

import v1.tmf854.*;
import v1.tmf854.InventoryDataT.MdList;
import v1.tmf854.MDInventoryT.MeList;
import v1.tmf854.SimpleFilterT.IncludedObjectType;
import java.io.*;
import java.util.List;
import java.util.ListIterator;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Marshaller;
import java.io.FileInputStream;
import java.io.File;
import java.util.*;

/**
 *
 * @author baptiste
 */
@Stateless
public class PopulateImpl implements Populate {
    
    @PersistenceContext
    private EntityManager em;
    
    /** Creates a new instance of GetInventoryBean */
    public PopulateImpl() {
    }

    // Populate the database with the unmarshalled InventoryDataT object
    public boolean populateDatabase(GetInventoryResponseT getInventoryResponse) {
        System.out.println("*************PopulateImpl:getInventoryResponse()*************");
//        //test
//            NamingAttributesT nat1 = new NamingAttributesT();
//            nat1.setMdNm("mdNm111111111");
//            EquipmentT eq1 = new EquipmentT();
//            eq1.setName(nat1);
//            ManagedElementT me1 = new ManagedElementT();
//            me1.setName(nat1);
//            em.persist(eq1);
//            em.persist(me1);
//            em.persist(nat1);
//           //fin test
        
        InventoryDataT inventory = getInventoryResponse.getInventoryData();
        List<MDInventoryT> mdInvs = getInventoryResponse.getInventoryData().getMdList().getMd();
        System.out.println("mdInvs.size: " + mdInvs.size());
        //new
        NamingAttributesT natMd = null;
        NamingAttributesT natMe = null;
        NamingAttributesT natEh = null;
        NamingAttributesT natEq = null;
        NamingAttributesT natPtp = null;
        NamingAttributesT natFtp = null;
        NamingAttributesT natCtp = null;
        NamingAttributesT natPgp = null;
        NamingAttributesT natEpgp = null;
        NamingAttributesT natTl = null;
        NamingAttributesT natMlsn = null;
        NamingAttributesT natSnc = null;
        NamingAttributesT natTpPool = null;
        
//        try {
        //************* Loop through all Management Domain ****************//
        for (MDInventoryT mdInv : mdInvs) {
            String mdNm = mdInv.getMdNm();
            ManagementDomainT mdAttrs = mdInv.getMdAttrs();
            SupportingOSNameList mdFull = mdInv.getSupportingOSNameList();
            natMd = new NamingAttributesT();
            natMd.setMdNm(mdNm);
            if (mdAttrs == null) {
                mdAttrs = new ManagementDomainT();
            }
            mdAttrs.setName(natMd);
            mdAttrs.setMdInventoryT(mdInv);
            if (mdInv.getSupportingOSNameList() != null)
                System.out.println("supportinOSNameList " + mdInv.getSupportingOSNameList().getSupportingOSNames());
            System.out.println("mdInv persisttttttttttttttttttttttttttttttttttttt");
            em.persist(mdAttrs);
            em.persist(mdInv);
            em.persist(natMd);
            
            //************* Loop through all Topological Link ****************//
            if (mdInv.getTlList() != null) {
                List<TLInventoryT> tlInvs = mdInv.getTlList().getTlInv();
                for (TLInventoryT tlInv : tlInvs) {
                    String tlNm = tlInv.getTlNm();
                    TopologicalLinkT tlAttrs = tlInv.getTlAttrs();
                    natTl = new NamingAttributesT();
                    natTl.setMdNm(natMd.getMdNm());
                    natTl.setTlNm(tlNm);
                    if (tlAttrs == null) {
                        tlAttrs = new TopologicalLinkT();
                    }
                    tlAttrs.setName(natTl);
                    tlAttrs.setTlInventoryT(tlInv);
                    
                    em.persist(tlAttrs);
                    em.persist(tlInv);
                    em.persist(natTl);            
                }
            }
            
            //************* Loop through all Managed Element ****************//
            if (mdInv.getMeList() != null) {
                List<MEInventoryT> meInvs = mdInv.getMeList().getMeInv();
                System.out.println("meInvs.size(): " + meInvs.size());
                for (MEInventoryT meInv : meInvs) {
                    String meNm = meInv.getMeNm();
                    ManagedElementT meAttrs = meInv.getMeAttrs();
                    
                    NamingAttributesListT meFull = meInv.getContainingMLSNNameList();
                    natMe = new NamingAttributesT();
                    natMe.setMdNm(natMd.getMdNm());
                    natMe.setMeNm(meNm);
                    if (meAttrs == null) {
                        meAttrs = new ManagedElementT();
                    }
                    meAttrs.setName(natMe);
                    meAttrs.setMeInventoryT(meInv);
                    
                    if (meAttrs.getSupportedRates() != null)
                        System.out.println("me.getLayRateList(0) " + meAttrs.getSupportedRates().getLrs());//.get(0));
                    if (meAttrs.getVendorExtensions() != null)
                        System.out.println("me.getVendorExtensions() " + meAttrs.getVendorExtensions().getMev());
                    em.persist(meAttrs);
                    em.persist(meInv);
                    em.persist(natMe);
                    
                    //************* Loop through all Equipment Holder ****************//
                    if (meInv.getEhList() != null) {
                        List<EHInventoryT> ehInvs = meInv.getEhList().getEhInv();
                        System.out.println("ehInvs.size(): " + ehInvs.size());
                        for (EHInventoryT ehInv : ehInvs) {
                            String ehNm = ehInv.getEhNm();
                            EquipmentHolderT ehAttrs = ehInv.getEhAttrs();
                            natEh = new NamingAttributesT();
                            natEh.setMdNm(natMe.getMdNm());
                            natEh.setMeNm(natMe.getMeNm());
                            natEh.setEhNm(ehNm);
                            if (ehAttrs == null) {
                                ehAttrs = new EquipmentHolderT();
                            }
                            ehAttrs.setName(natEh);
                            ehAttrs.setEhInventoryT(ehInv);
                            if (ehAttrs.getAcceptableEquipmentTypeList() != null)
                                System.out.println("eh.acceptableEquipmentTypeList(0) " + ehAttrs.getAcceptableEquipmentTypeList().getAccs());
                            em.persist(ehAttrs);
                            em.persist(ehInv);
                            em.persist(natEh);
                            //System.out.println("eh.acclist0 " + eh.getAcceptableEquipmentTypeList().getAcceptableEquipmentType().get(0));
                            //System.out.println("eh.acclist1 " + eh.getAcceptableEquipmentTypeList().getAcceptableEquipmentType().get(1));
//                            //test
//                            List<String> la = null;
//                            if(eh.getAcceptableEquipmentTypeList() != null) {
//                                la = eh.getAcceptableEquipmentTypeList().getAcceptableEquipmentType();
//                            }
//                            if (la != null) {
//                                System.out.println("la.size " + la.size());
//                                System.out.println("la.0 " + la.get(0));
//                                List<D> dss = new ArrayList<D>();
//                                for(String s : la) {
//                                    D d1 = new D();
//                                    d1.setAcc(s);
//                                    em.persist(d1);
//                                    dss.add(d1);
//                                }
//
//                                eh.setDs(dss);
//                            }
                            //fin test
                            
                            //************* Loop through all Equipment ****************//
                            if (ehInv.getEqInv() != null) {
                                EQInventoryT eqInv = ehInv.getEqInv();
                                String eqNm = eqInv.getEqNm();
                                EquipmentT eqAttrs = eqInv.getEqAttrs();
                                natEq = new NamingAttributesT();
                                natEq.setMdNm(natEh.getMdNm());
                                natEq.setMeNm(natEh.getMeNm());
                                natEq.setEhNm(natEh.getEhNm());
                                natEq.setEqNm(eqNm);
                                if (eqAttrs == null) {
                                    eqAttrs = new EquipmentT();
                                }
                                eqAttrs.setName(natEq);
                                eqAttrs.setEqInventoryT(eqInv);
                                // full??
                                em.persist(eqAttrs);
                                em.persist(eqInv);
                                em.persist(natEq);
                            }
                            
                        }//ehList
                        
                        //************* Loop through all Physical Termination Point ****************//
                        
                        if(meInv.getPtpList() != null) {
                            List<PTPInventoryT> ptpInvs = meInv.getPtpList().getPtpInv();
                            System.out.println("ptpInvs.size(): " + ptpInvs.size());
                            for (PTPInventoryT ptpInv : ptpInvs) {
                                String ptpNm = ptpInv.getPtpNm();
                                PhysicalTerminationPointT ptpAttrs = ptpInv.getPtpAttrs();
                                NamingAttributesListT ptpFull = ptpInv.getSupportingEquipList();
                                natPtp = new NamingAttributesT();
                                natPtp.setMdNm(natMe.getMdNm());
                                natPtp.setMeNm(natMe.getMeNm());
                                natPtp.setPtpNm(ptpNm);
                                if (ptpAttrs == null) {
                                    ptpAttrs = new PhysicalTerminationPointT();
                                }
                                ptpAttrs.setName(natPtp);
                                ptpAttrs.setPtpInventoryT(ptpInv);
                                em.persist(ptpAttrs);
                                em.persist(ptpInv);
                                em.persist(natPtp);
                                
                                //************* Loop through all Connection Termination Point ****************//
                                if(ptpInv.getCtpList() != null) {
                                    List<CTPInventoryT> ctpInvs  = ptpInv.getCtpList().getCtpInv();
                                    System.out.println("ctpinvs.size(): " + ctpInvs.size());
                                    for (CTPInventoryT ctpInv : ctpInvs) {
                                        String ctpNm = ctpInv.getCtpNm();
                                        ConnectionTerminationPointT ctpAttrs = ctpInv.getCtpAttrs();
                                        natCtp = new NamingAttributesT();
                                        natCtp.setMdNm(natPtp.getMdNm());
                                        natCtp.setMeNm(natPtp.getMeNm());
                                        natCtp.setPtpNm(natPtp.getPtpNm());
                                        natCtp.setCtpNm(ctpNm);
                                        if (ctpAttrs == null) {
                                            ctpAttrs = new ConnectionTerminationPointT();
                                        }
                                        ctpAttrs.setName(natCtp);
                                        ctpAttrs.setCtpInventoryT(ctpInv);
                                        em.persist(ctpAttrs);
                                        em.persist(ctpInv);
                                        em.persist(natCtp);
                                    }
                                }
                            }
                        }//PTP
                        
                        
                        //************* Loop through all Floating Termination Point ****************//
                        
                        if(meInv.getFtpList() != null) {
                            List<FTPInventoryT> ftpInvs = meInv.getFtpList().getFtpInv();
                            System.out.println("ftpInvs.size(): " + ftpInvs.size());
                            for (FTPInventoryT ftpInv : ftpInvs) {
                                String ftpNm = ftpInv.getFtpNm();
                                FloatingTerminationPointT ftpAttrs = ftpInv.getFtpAttrs();
                                NamingAttributesListT ftpFull = ftpInv.getSupportingEquipList();
                                natFtp = new NamingAttributesT();
                                natFtp.setMdNm(natMd.getMdNm());
                                natFtp.setMeNm(natMe.getMeNm());
                                natFtp.setFtpNm(ftpNm);
                                if (ftpAttrs == null) {
                                    ftpAttrs = new FloatingTerminationPointT();
                                }
                                ftpAttrs.setName(natFtp);
                                ftpAttrs.setFtpInventoryT(ftpInv);
                                em.persist(ftpAttrs);
                                em.persist(ftpInv);
                                em.persist(natFtp);
                                //************* Loop through all Connection Termination Point ****************//
                                if(ftpInv.getCtpList() != null) {
                                    List<CTPInventoryT> ctpInvs  = ftpInv.getCtpList().getCtpInv();
                                    System.out.println("ctpInvs.size() " + ctpInvs.size());
                                    for (CTPInventoryT ctpInv : ctpInvs) {
                                        String ctpNm = ctpInv.getCtpNm();
                                        ConnectionTerminationPointT ctpAttrs = ctpInv.getCtpAttrs();
                                        natCtp = new NamingAttributesT();
                                        natCtp.setMdNm(natPtp.getMdNm());
                                        natCtp.setMeNm(natPtp.getMeNm());
                                        natCtp.setPtpNm(natPtp.getPtpNm());
                                        natCtp.setCtpNm(ctpNm);
                                        if (ctpAttrs == null) {
                                            ctpAttrs = new ConnectionTerminationPointT();
                                        }
                                        ctpAttrs.setName(natCtp);
                                        ctpAttrs.setCtpInventoryT(ctpInv);
                                        em.persist(ctpAttrs);
                                        em.persist(ctpInv);
                                        em.persist(natCtp);
                                    }
                                }
                            }
                        }//FTP
                        
                        //************* Loop through all Protection Groups  ****************//
                        
                        if(meInv.getPgpList() != null) {
                            List<PGPInventoryT> pgpInvs = meInv.getPgpList().getPgpInv();
                            for (PGPInventoryT pgpInv : pgpInvs) {
                                String pgpNm = pgpInv.getPgpNm();
                                ProtectionGroupT pgpAttrs = pgpInv.getPgpAttrs();
                                natPgp = new NamingAttributesT();
                                natPgp.setMdNm(natMd.getMdNm());
                                natPgp.setMeNm(natMe.getMeNm());
                                natPgp.setPgpNm(pgpNm);
                                if (pgpAttrs == null) {
                                    pgpAttrs = new ProtectionGroupT();
                                }
                                pgpAttrs.setName(natPgp);
                                pgpAttrs.setPgpInventoryT(pgpInv);
                                em.persist(pgpAttrs);
                                em.persist(pgpInv);
                                em.persist(natPgp);
                            }
                        }
                        
                        //EPGP
                        if(meInv.getEpgpList() != null) {
                            List<EPGPInventoryT> epgpInvs = meInv.getEpgpList().getEpgpInv();
                            for (EPGPInventoryT epgpInv : epgpInvs) {
                                String epgpNm = epgpInv.getEpgpNm();
                                EProtectionGroupT epgpAttrs = epgpInv.getEpgpAttrs();
                                natEpgp = new NamingAttributesT();
                                natEpgp.setMdNm(natMd.getMdNm());
                                natEpgp.setMeNm(natMe.getMeNm());
                                natEpgp.setEpgpNm(epgpInv.getEpgpNm());
                                if (epgpAttrs == null) {
                                    epgpAttrs = new EProtectionGroupT();
                                }
                                epgpAttrs.setName(natEpgp);
                                epgpAttrs.setEpgpInventoryT(epgpInv);
                                em.persist(epgpAttrs);
                                em.persist(epgpInv);
                                em.persist(natEpgp);
                                
                            }
                        }
                    }
                }//ME*/
                
                
                //************* Loop through all MultiLayer Subnetwork ****************//
                if(mdInv.getMlsnList() != null) {
                    System.out.println("******************MSLN Persist*****************");
                    List<MLSNInventoryT> mlsnInvs = mdInv.getMlsnList().getMlsnInv();
                    System.out.println("mlsnInvs.size() " + mlsnInvs.size());
                    for (MLSNInventoryT mlsnInv : mlsnInvs) {
                        String mlsnNm = mlsnInv.getMlsnNm();
                        MultiLayerSubnetworkT mlsnAttrs = mlsnInv.getMlsnAttrs();
                        AssociatedMEList mlsnFull = mlsnInv.getAssociatedMEList();
                        natMlsn = new NamingAttributesT();
                        natMlsn.setMdNm(natMd.getMdNm());
                        natMlsn.setMlsnNm(mlsnNm);
                        if (mlsnAttrs == null) {
                            mlsnAttrs = new MultiLayerSubnetworkT();
                        }
                        mlsnAttrs.setName(natMlsn);
                        mlsnAttrs.setMlsnInventoryT(mlsnInv);
                        em.persist(mlsnAttrs);
                        em.persist(mlsnInv);
                        em.persist(natMlsn);
                        //************* Loop through all  Subnetwork ****************//
                        if (mlsnInv.getSncList() != null) {
                            List<SNCInventoryT> sncInvs  = mlsnInv.getSncList().getSncInv();
                            System.out.println("sncInvs.size() " + sncInvs.size());
                            for (SNCInventoryT sncInv : sncInvs) {
                                String sncNm = sncInv.getSncNm();
                                SubnetworkConnectionT sncAttrs = sncInv.getSncAttrs();
                                natSnc = new NamingAttributesT();
                                natSnc.setMdNm(natMd.getMdNm());
                                natSnc.setMlsnNm(natMlsn.getMlsnNm());
                                natSnc.setSncNm(sncNm);
                                if (sncAttrs == null) {
                                    sncAttrs = new SubnetworkConnectionT();
                                }
                                sncAttrs.setName(natSnc);
                                sncAttrs.setSncInventoryT(sncInv);
                                em.persist(sncAttrs);
                                em.persist(sncInv);
                                em.persist(natSnc);
                            }
                        }
                        
                        //************* Loop through all  TPPool ****************//
                        if (mlsnInv.getTpPoolList() != null) {
                            List<TPPoolInventoryT> tpPoolInvs  = mlsnInv.getTpPoolList().getTpPoolInv();
                            for (TPPoolInventoryT tpPoolInv : tpPoolInvs) {
                                String tpPoolNm = tpPoolInv.getTppoolNm();
                                TPPoolT tpPoolAttrs = tpPoolInv.getTppoolAttrs();
                                natTpPool = new NamingAttributesT();
                                natTpPool.setMdNm(natMd.getMdNm());
                                natTpPool.setMlsnNm(natMlsn.getMlsnNm());
                                natTpPool.setTppoolNm(tpPoolNm);
                                if (tpPoolAttrs == null) {
                                    tpPoolAttrs = new TPPoolT();
                                }
                                tpPoolAttrs.setName(natTpPool);
                                tpPoolAttrs.setTpPoolInventoryT(tpPoolInv);
                                em.persist(tpPoolAttrs);
                                em.persist(tpPoolInv);
                                em.persist(natTpPool);
                            }
                        }
                        
                        //************* Loop through all  Tl ****************//
                      /*  if (mlsnInv.getTlList() != null) {
                            List<TLInventoryT> tlInvs  = mlsnInv.getTlList().getTlInv();
                            System.out.println("tlInvs.size() " + tlInvs.size());
                            for (TLInventoryT tlInv : tlInvs) {
                                String tlNm = tlInv.getTlNm();
                                TopologicalLinkT tlAttrs = tlInv.getTlAttrs();
                                em.persist(tlAttrs);
                                em.persist(tlInv);
                            }
                        } */
                    }
                }
            }
        }// md
        
        return true;
    }
    
    
// Unmarshall the InventoryData xml example file into a InventoryDataT object.
    public boolean unmarshallXmlExample(String path) {
        System.out.println("*************PopulateImpl:unmarshallXmlExample()*************");
        GetInventoryResponseT getInventoryResponse = null;
        try {
            JAXBContext jc = JAXBContext.newInstance( "v1.tmf854" );
            //ObjectFactory factory = new ObjectFactory();
            Unmarshaller u = jc.createUnmarshaller();
            JAXBElement<?> poElement = (JAXBElement<?>)u.unmarshal( new File(path) );
            getInventoryResponse = (GetInventoryResponseT) poElement.getValue();
        } catch( JAXBException je ) {
            je.printStackTrace();
        }
        return populateDatabase(getInventoryResponse);
    }
    
    public void persist(Object object) {
        // TODO:
        // em.persist(object);
    }
}

