
package org.tmforum.mtop.populatedatabase;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.*;
import javax.xml.bind.*;
import java.io.FileInputStream;
import java.io.File;
import java.util.*;

import v1.tmf854.*;

@Stateless
public class PopulateImpl implements Populate {
    
    @PersistenceContext
    private EntityManager em;
    
    /** Creates a new instance of GetInventoryBean */
    public PopulateImpl() {
    }
    
    /**
     * Persist all the managed entities of the xml file into the database
     * @param getInventoryResponse instance containing the xml file data
     * @return true if the database has been correctly populated
     */
    public boolean populateDatabase(GetInventoryResponseT getInventoryResponse) {
        try {
            InventoryDataT inventory = getInventoryResponse.getInventoryData();
            List<MDInventoryT> mdInvs = getInventoryResponse.getInventoryData().getMdList().getMd();
            
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
            
            // Loop through all Management Domain
            if (mdInvs != null) {
                
                for (MDInventoryT mdInv : mdInvs) {
                    String mdNm = mdInv.getMdNm();
                    ManagementDomainT mdAttrs = mdInv.getMdAttrs();
                    SupportingOSNameList mdFull = mdInv.getSupportingOSNameList();
                    
                    if (mdAttrs == null) 
                        mdAttrs = new ManagementDomainT();
                 
                    if (mdAttrs.getVendorExtensions() != null)
                        mdAttrs.initVendorExtensions();
                    
                    natMd = new NamingAttributesT();
                    natMd.setMdNm(mdNm);
                    mdAttrs.setName(natMd);
                    mdAttrs.setMdInventoryT(mdInv);
                    
                    if (mdInv.getSupportingOSNameList() != null) 
                        mdInv.getSupportingOSNameList().initSupportingOSNames();
                    
                    em.persist(mdAttrs);
                    em.persist(mdInv);
                    em.persist(natMd);
                    
                    // Loop through all Topological Link
                    if (mdInv.getTlList() != null) {
                        List<TLInventoryT> tlInvs = mdInv.getTlList().getTlInv();
                        
                        for (TLInventoryT tlInv : tlInvs) {
                            String tlNm = tlInv.getTlNm();
                            TopologicalLinkT tlAttrs = tlInv.getTlAttrs();
                            
                            if (tlAttrs == null)
                                tlAttrs = new TopologicalLinkT();
                            
                            if (tlAttrs.getVendorExtensions() != null)
                                tlAttrs.initVendorExtensions();
                            
                            natTl = new NamingAttributesT();
                            natTl.setMdNm(natMd.getMdNm());
                            natTl.setTlNm(tlNm);
                            tlAttrs.setName(natTl);
                            tlAttrs.setTlInventoryT(tlInv);
                            
                            em.persist(tlAttrs);
                            em.persist(tlInv);
                            em.persist(natTl);
                        }
                    }
                    
                    // Loop through all Managed Element
                    if (mdInv.getMeList() != null) {
                        List<MEInventoryT> meInvs = mdInv.getMeList().getMeInv();
                        
                        for (MEInventoryT meInv : meInvs) {
                            String meNm = meInv.getMeNm();
                            ManagedElementT meAttrs = meInv.getMeAttrs();
                            
                            if (meAttrs == null)
                                meAttrs = new ManagedElementT();
                            
                            if (meAttrs.getVendorExtensions() != null)
                                meAttrs.initVendorExtensions();
                            
                            NamingAttributesListT meFull = meInv.getContainingMLSNNameList();
                            natMe = new NamingAttributesT();
                            natMe.setMdNm(natMd.getMdNm());
                            natMe.setMeNm(meNm);
                            meAttrs.setName(natMe);
                            meAttrs.setMeInventoryT(meInv);
                            
                            if (meAttrs.getSupportedRates() != null)
                                meAttrs.getSupportedRates().initLrs();
                            
                            em.persist(meAttrs);
                            em.persist(meInv);
                            em.persist(natMe);
                            
                            // Loop through all Equipment Holder
                            if (meInv.getEhList() != null) {
                                List<EHInventoryT> ehInvs = meInv.getEhList().getEhInv();
                                
                                for (EHInventoryT ehInv : ehInvs) {
                                    String ehNm = ehInv.getEhNm();
                                    EquipmentHolderT ehAttrs = ehInv.getEhAttrs();
                                    
                                    if (ehAttrs == null)
                                        ehAttrs = new EquipmentHolderT();
                                    
                                    if (ehAttrs.getVendorExtensions() != null)
                                        ehAttrs.initVendorExtensions();
                                    
                                    natEh = new NamingAttributesT();
                                    natEh.setMdNm(natMe.getMdNm());
                                    natEh.setMeNm(natMe.getMeNm());
                                    natEh.setEhNm(ehNm);
                                    ehAttrs.setName(natEh);
                                    ehAttrs.setEhInventoryT(ehInv);
                                    
                                    if (ehAttrs.getAcceptableEquipmentTypeList() != null)
                                        ehAttrs.getAcceptableEquipmentTypeList().initAccs();
                                    
                                    em.persist(ehAttrs);
                                    em.persist(ehInv);
                                    em.persist(natEh);
                                    
                                    // Persist Equipments
                                    if (ehInv.getEqInv() != null) {
                                        EQInventoryT eqInv = ehInv.getEqInv();
                                        String eqNm = eqInv.getEqNm();
                                        EquipmentT eqAttrs = eqInv.getEqAttrs();
                                        
                                        if (eqAttrs == null)
                                            eqAttrs = new EquipmentT();
                                        
                                        if (eqAttrs.getVendorExtensions() != null)
                                            eqAttrs.initVendorExtensions();
                                    
                                        natEq = new NamingAttributesT();
                                        natEq.setMdNm(natEh.getMdNm());
                                        natEq.setMeNm(natEh.getMeNm());
                                        natEq.setEhNm(natEh.getEhNm());
                                        natEq.setEqNm(eqNm);
                                        eqAttrs.setName(natEq);
                                        eqAttrs.setEqInventoryT(eqInv);
                                        
                                        em.persist(eqAttrs);
                                        em.persist(eqInv);
                                        em.persist(natEq);
                                    }
                                } // for eh
                            } // ehList
                            
                            // Loop through all Physical Termination Point
                            if(meInv.getPtpList() != null) {
                                List<PTPInventoryT> ptpInvs = meInv.getPtpList().getPtpInv();
                                
                                for (PTPInventoryT ptpInv : ptpInvs) {
                                    String ptpNm = ptpInv.getPtpNm();
                                    PhysicalTerminationPointT ptpAttrs = ptpInv.getPtpAttrs();
                                    
                                   if (ptpAttrs == null) 
                                        ptpAttrs = new PhysicalTerminationPointT();
                                    
                                    if (ptpAttrs.getVendorExtensions() != null)
                                        ptpAttrs.initVendorExtensions();
                                    
                                    NamingAttributesListT ptpFull = ptpInv.getSupportingEquipList();
                                    natPtp = new NamingAttributesT();
                                    natPtp.setMdNm(natMe.getMdNm());
                                    natPtp.setMeNm(natMe.getMeNm());
                                    natPtp.setPtpNm(ptpNm);
                                    ptpAttrs.setName(natPtp);
                                    ptpAttrs.setPtpInventoryT(ptpInv);
                                    
                                    em.persist(ptpAttrs);
                                    em.persist(ptpInv);
                                    em.persist(natPtp);
                                    
                                    // Loop through all Connection Termination Point
                                    if(ptpInv.getCtpList() != null) {
                                        List<CTPInventoryT> ctpInvs  = ptpInv.getCtpList().getCtpInv();
                                        
                                        for (CTPInventoryT ctpInv : ctpInvs) {
                                            String ctpNm = ctpInv.getCtpNm();
                                            ConnectionTerminationPointT ctpAttrs = ctpInv.getCtpAttrs();
                                          
                                           if (ctpAttrs == null) 
                                                ctpAttrs = new ConnectionTerminationPointT();
                                            
                                            if (ctpAttrs.getVendorExtensions() != null)
                                                ctpAttrs.initVendorExtensions();
                                            
                                            natCtp = new NamingAttributesT();
                                            natCtp.setMdNm(natPtp.getMdNm());
                                            natCtp.setMeNm(natPtp.getMeNm());
                                            natCtp.setPtpNm(natPtp.getPtpNm());
                                            natCtp.setCtpNm(ctpNm);
                                            ctpAttrs.setName(natCtp);
                                            ctpAttrs.setCtpInventoryT(ctpInv);
                                           
                                            em.persist(ctpAttrs);
                                            em.persist(ctpInv);
                                            em.persist(natCtp);
                                        } // for ctp
                                    } // ctpList
                                } // for ptp
                            } // ptpList
                            
                            // Loop through all Floating Termination Point
                            if(meInv.getFtpList() != null) {
                                List<FTPInventoryT> ftpInvs = meInv.getFtpList().getFtpInv();
                                
                                for (FTPInventoryT ftpInv : ftpInvs) {
                                    String ftpNm = ftpInv.getFtpNm();
                                    FloatingTerminationPointT ftpAttrs = ftpInv.getFtpAttrs();
                                    NamingAttributesListT ftpFull = ftpInv.getSupportingEquipList();

                                    if (ftpAttrs == null) 
                                        ftpAttrs = new FloatingTerminationPointT();
                                    
                                    if (ftpAttrs.getVendorExtensions() != null)
                                        ftpAttrs.initVendorExtensions();
                                    
                                    natFtp = new NamingAttributesT();
                                    natFtp.setMdNm(natMd.getMdNm());
                                    natFtp.setMeNm(natMe.getMeNm());
                                    natFtp.setFtpNm(ftpNm);
                                    ftpAttrs.setName(natFtp);
                                    ftpAttrs.setFtpInventoryT(ftpInv);
                                    
                                    em.persist(ftpAttrs);
                                    em.persist(ftpInv);
                                    em.persist(natFtp);
                                    
                                    // Loop through all Connection Termination Point
                                    if(ftpInv.getCtpList() != null) {
                                        List<CTPInventoryT> ctpInvs  = ftpInv.getCtpList().getCtpInv();
                                        
                                        for (CTPInventoryT ctpInv : ctpInvs) {
                                            String ctpNm = ctpInv.getCtpNm();
                                            ConnectionTerminationPointT ctpAttrs = ctpInv.getCtpAttrs();
                                            
                                            if (ctpAttrs == null) 
                                                ctpAttrs = new ConnectionTerminationPointT();
                                            
                                            if (ctpAttrs.getVendorExtensions() != null)
                                                ctpAttrs.initVendorExtensions();
                                    
                                            natCtp = new NamingAttributesT();
                                            natCtp.setMdNm(natFtp.getMdNm());
                                            natCtp.setMeNm(natFtp.getMeNm());
                                            natCtp.setPtpNm(natFtp.getPtpNm());
                                            natCtp.setCtpNm(ctpNm);
                                            ctpAttrs.setName(natCtp);
                                            ctpAttrs.setCtpInventoryT(ctpInv);
                                            
                                            em.persist(ctpAttrs);
                                            em.persist(ctpInv);
                                            em.persist(natCtp);
                                        } // for ctp
                                    } // ctpList
                                } // for ftp
                            }// ftpList
                            
                            
                            // Loop through all Protection Groups
                            if(meInv.getPgpList() != null) {
                                List<PGPInventoryT> pgpInvs = meInv.getPgpList().getPgpInv();
                                
                                for (PGPInventoryT pgpInv : pgpInvs) {
                                    String pgpNm = pgpInv.getPgpNm();
                                    ProtectionGroupT pgpAttrs = pgpInv.getPgpAttrs();
                                    
                                    if (pgpAttrs == null) 
                                        pgpAttrs = new ProtectionGroupT();
                                   
                                    if (pgpAttrs.getVendorExtensions() != null)
                                        pgpAttrs.initVendorExtensions();
                                   
                                    natPgp = new NamingAttributesT();
                                    natPgp.setMdNm(natMd.getMdNm());
                                    natPgp.setMeNm(natMe.getMeNm());
                                    natPgp.setPgpNm(pgpNm);
                                    pgpAttrs.setName(natPgp);
                                    pgpAttrs.setPgpInventoryT(pgpInv);
                                    
                                    em.persist(pgpAttrs);
                                    em.persist(pgpInv);
                                    em.persist(natPgp);
                                } // for pgp
                            } // pgpList
                            
                            // Loop through all EProtection Groups
                            if(meInv.getEpgpList() != null) {
                                List<EPGPInventoryT> epgpInvs = meInv.getEpgpList().getEpgpInv();
                                
                                for (EPGPInventoryT epgpInv : epgpInvs) {
                                    String epgpNm = epgpInv.getEpgpNm();
                                    EProtectionGroupT epgpAttrs = epgpInv.getEpgpAttrs();
                                    
                                     if (epgpAttrs == null)
                                        epgpAttrs = new EProtectionGroupT();
                                    
                                    if (epgpAttrs.getVendorExtensions() != null)
                                        epgpAttrs.initVendorExtensions();
                                    
                                    natEpgp = new NamingAttributesT();
                                    natEpgp.setMdNm(natMd.getMdNm());
                                    natEpgp.setMeNm(natMe.getMeNm());
                                    natEpgp.setEpgpNm(epgpInv.getEpgpNm());
                                    epgpAttrs.setName(natEpgp);
                                    epgpAttrs.setEpgpInventoryT(epgpInv);
                                    
                                    em.persist(epgpAttrs);
                                    em.persist(epgpInv);
                                    em.persist(natEpgp);
                                } // for epgp
                            } // epgpList
                        } // for me
                    } // meList
                    
                    // Loop through all MultiLayer Subnetwork
                    if(mdInv.getMlsnList() != null) {
                        List<MLSNInventoryT> mlsnInvs = mdInv.getMlsnList().getMlsnInv();
                        
                        for (MLSNInventoryT mlsnInv : mlsnInvs) {
                            String mlsnNm = mlsnInv.getMlsnNm();
                            MultiLayerSubnetworkT mlsnAttrs = mlsnInv.getMlsnAttrs();
                            
                            if (mlsnAttrs == null) 
                                mlsnAttrs = new MultiLayerSubnetworkT();
                           
                            if (mlsnAttrs.getVendorExtensions() != null)
                                mlsnAttrs.initVendorExtensions();
                           
                            AssociatedMEList mlsnFull = mlsnInv.getAssociatedMEList();
                            natMlsn = new NamingAttributesT();
                            natMlsn.setMdNm(natMd.getMdNm());
                            natMlsn.setMlsnNm(mlsnNm);
                            mlsnAttrs.setName(natMlsn);
                            mlsnAttrs.setMlsnInventoryT(mlsnInv);
                            
                            em.persist(mlsnAttrs);
                            em.persist(mlsnInv);
                            em.persist(natMlsn);
                            
                            // Loop through all SubnetworkConnection
                            if (mlsnInv.getSncList() != null) {
                                List<SNCInventoryT> sncInvs  = mlsnInv.getSncList().getSncInv();
                                
                                for (SNCInventoryT sncInv : sncInvs) {
                                    String sncNm = sncInv.getSncNm();
                                    SubnetworkConnectionT sncAttrs = sncInv.getSncAttrs();
                                    
                                    if (sncAttrs == null) 
                                        sncAttrs = new SubnetworkConnectionT();
                                    
                                    if (sncAttrs.getVendorExtensions() != null)
                                        sncAttrs.initVendorExtensions();
                                    
                                    natSnc = new NamingAttributesT();
                                    natSnc.setMdNm(natMd.getMdNm());
                                    natSnc.setMlsnNm(natMlsn.getMlsnNm());
                                    natSnc.setSncNm(sncNm);
                                    sncAttrs.setName(natSnc);
                                    sncAttrs.setSncInventoryT(sncInv);
                                    
                                    em.persist(sncAttrs);
                                    em.persist(sncInv);
                                    em.persist(natSnc);
                                } // for snc
                            } // sncList
                            
                            // Loop through all TPPool
                            if (mlsnInv.getTpPoolList() != null) {
                                List<TPPoolInventoryT> tpPoolInvs  = mlsnInv.getTpPoolList().getTpPoolInv();
                                
                                // Loop through all TPP
                                for (TPPoolInventoryT tpPoolInv : tpPoolInvs) {
                                    String tpPoolNm = tpPoolInv.getTppoolNm();
                                    TPPoolT tpPoolAttrs = tpPoolInv.getTppoolAttrs();
                                    
                                    if (tpPoolAttrs == null) 
                                        tpPoolAttrs = new TPPoolT();
                                   
                                    if (tpPoolAttrs.getVendorExtensions() != null)
                                        tpPoolAttrs.initVendorExtensions();
                                    
                                    natTpPool = new NamingAttributesT();
                                    natTpPool.setMdNm(natMd.getMdNm());
                                    natTpPool.setMlsnNm(natMlsn.getMlsnNm());
                                    natTpPool.setTppoolNm(tpPoolNm);
                                    tpPoolAttrs.setName(natTpPool);
                                    tpPoolAttrs.setTpPoolInventoryT(tpPoolInv);
                                    
                                    em.persist(tpPoolAttrs);
                                    em.persist(tpPoolInv);
                                    em.persist(natTpPool);
                                } // for tpp
                            } // tppList
                        } // for mlsn
                    } // mlsnList
                } // for md
            } // if
            
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    } 
    
    
    /**
     * Function called by the servlet of the Web Module (PopulateServlet).
     * It deletes the old database records if needed and unmarshalls the xml file
     * before populating the database.
     * @param path absolute path of the xml file to unmarhsall
     */
    public boolean unmarshallXmlExample(String path, boolean deletePrevRecords) {
        GetInventoryResponseT getInventoryResponse = null;
        
        if (deletePrevRecords)
            deleteDB();
        
        try {
            JAXBContext jc = JAXBContext.newInstance( "v1.tmf854" );
            Unmarshaller u = jc.createUnmarshaller();
            JAXBElement<?> poElement = (JAXBElement<?>)u.unmarshal(new File(path));
            getInventoryResponse = (GetInventoryResponseT) poElement.getValue();
        } catch(JAXBException je) {
            je.printStackTrace();
            
            return false;
        }
        
        return populateDatabase(getInventoryResponse);
    }
    
    /**
     * Delete all the tables records of the database
     */
    public void deleteDB() {
        System.out.println("PopulateImpl:deleteDB()");
        
        Query q = em.createQuery("delete from ManagementDomainT");
        q.executeUpdate();
        System.out.println("delete MDInventoryT");
        q = em.createQuery("delete from MDInventoryT");
        q.executeUpdate();
        System.out.println("delete SupportingOSName");
        q = em.createQuery("delete from SupportingOSName");
        q.executeUpdate();
        System.out.println("delete SupportingOSNameList");
        q = em.createQuery("delete from SupportingOSNameList");
        q.executeUpdate();
        System.out.println("delete ME");
        q = em.createQuery("delete from ManagedElementT");
        q.executeUpdate();
        System.out.println("delete MEInventoryT");
        q = em.createQuery("delete from MEInventoryT");
        q.executeUpdate();
        System.out.println("delete EH");
        q = em.createQuery("delete from EquipmentHolderT");
        q.executeUpdate();
        System.out.println("delete EHInventoryT");
        q = em.createQuery("delete from EHInventoryT");
        q.executeUpdate();
        System.out.println("delete EQ");
        q = em.createQuery("delete from EquipmentT");
        q.executeUpdate();
        System.out.println("delete EQInventoryT");
        q = em.createQuery("delete from EQInventoryT");
        q.executeUpdate();
        System.out.println("delete MLSN");
        q = em.createQuery("delete from MultiLayerSubnetworkT");
        q.executeUpdate();
        System.out.println("delete MLSNINV");
        q = em.createQuery("delete from MLSNInventoryT");
        q.executeUpdate();
        System.out.println("delete AssocME");
        q = em.createQuery("delete from AssociatedME");
        q.executeUpdate();
        System.out.println("delete AssocMEList");
        q = em.createQuery("delete from AssociatedMEList");
        q.executeUpdate();
        System.out.println("delete PGP");
        q = em.createQuery("delete from ProtectionGroupT");
        q.executeUpdate();
        System.out.println("delete PGPInventoryT");
        q = em.createQuery("delete from PGPInventoryT");
        q.executeUpdate();
        System.out.println("delete EPGP");
        q = em.createQuery("delete from EProtectionGroupT");
        q.executeUpdate();
        System.out.println("delete EPGPInventoryT");
        q = em.createQuery("delete from EPGPInventoryT");
        q.executeUpdate();
        System.out.println("delete SNC");
        q = em.createQuery("delete from SubnetworkConnectionT");
        q.executeUpdate();
        System.out.println("delete SNCInventoryT");
        q = em.createQuery("delete from SNCInventoryT");
        q.executeUpdate();
        System.out.println("delete TL");
        q = em.createQuery("delete from TopologicalLinkT");
        q.executeUpdate();
        System.out.println("delete TLInventoryT");
        q = em.createQuery("delete from TLInventoryT");
        q.executeUpdate();
        System.out.println("delete TPPoolT");
        q = em.createQuery("delete from TPPoolT");
        q.executeUpdate();
        System.out.println("delete TPPoolInventoryT");
        q = em.createQuery("delete from TPPoolInventoryT");
        q.executeUpdate();
        System.out.println("delete PGPParametersT");
        q = em.createQuery("delete from PGPParametersT");
        q.executeUpdate();
        System.out.println("delete PTP");
        q = em.createQuery("delete from PhysicalTerminationPointT");
        q.executeUpdate();
        System.out.println("delete EDGEPTP");
        q = em.createQuery("delete from EdgePTPList");
        q.executeUpdate();
        System.out.println("delete PTPINV");
        q = em.createQuery("delete from PTPInventoryT");
        q.executeUpdate();
        System.out.println("delete FTP");
        q = em.createQuery("delete from FloatingTerminationPointT");
        q.executeUpdate();
        System.out.println("delete EDGEFTP");
        q = em.createQuery("delete from EdgeFTPList");
        q.executeUpdate();
        System.out.println("delete FTPINV");
        q = em.createQuery("delete from FTPInventoryT");
        q.executeUpdate();
        System.out.println("delete CTP");
        q = em.createQuery("delete from ConnectionTerminationPointT");
        q.executeUpdate();
        System.out.println("delete CTPINV");
        q = em.createQuery("delete from CTPInventoryT");
        q.executeUpdate();
        System.out.println("delete AcceptableEquipmentType");
        q = em.createQuery("delete from AcceptableEquipmentType");
        q.executeUpdate();
        System.out.println("delete AcceptableEquipmentTypeList");
        q = em.createQuery("delete from AcceptableEquipmentTypeList");
        q.executeUpdate();
        System.out.println("delete Alias");
        q = em.createQuery("delete from Alias");
        q.executeUpdate();
        System.out.println("delete AliasNameListT");
        q = em.createQuery("delete from AliasNameListT");
        q.executeUpdate();
        System.out.println("delete EPGPParametersT");
        q = em.createQuery("delete from EPGPParametersT");
        q.executeUpdate();
        System.out.println("delete LayerRate");
        q = em.createQuery("delete from LayerRate");
        q.executeUpdate();
        System.out.println("delete LayerRateListT");
        q = em.createQuery("delete from LayerRateListT");
        q.executeUpdate();
        System.out.println("delete LayeredParametersT");
        q = em.createQuery("delete from LayeredParametersT");
        q.executeUpdate();
        System.out.println("delete LayeredParametersListT");
        q = em.createQuery("delete from LayeredParametersListT");
        q.executeUpdate();
        System.out.println("delete LayeredParametersListT");
        q = em.createQuery("delete from LayeredParametersListT");
        q.executeUpdate();
        System.out.println("delete TPDataT");
        q = em.createQuery("delete from TPDataT");
        q.executeUpdate();
        System.out.println("delete TPDataTListT");
        q = em.createQuery("delete from TPDataListT");
        q.executeUpdate();
        System.out.println("delete NamingAttributesT");
        q = em.createQuery("delete from NamingAttributesT");
        q.executeUpdate();
        System.out.println("delete NamingAttributesListT");
        q = em.createQuery("delete from NamingAttributesListT");
        q.executeUpdate();
        System.out.println("delete SourceT");
        q = em.createQuery("delete from SourceT");
        q.executeUpdate();
        System.out.println("delete ServiceStateT");
        q = em.createQuery("delete from ServiceStateT");
        q.executeUpdate();
        System.out.println("delete ResourceStateT");
        q = em.createQuery("delete from ResourceStateT");
        q.executeUpdate();
        
        System.out.println("END !!!!!!");
        
        
    }
    
    public void persist(Object object) {
    }
    
}


