/*
 * GetInventoryBean.java
 *
 * Created on 15 avril 2007, 15:20
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.tmforum.mtop.simulator;

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

/**
 *
 * @author baptiste
 */
@Stateless
public class GetInventoryImpl implements GetInventory {
    
    @PersistenceContext
    private EntityManager em;
    
    /** Creates a new instance of GetInventoryBean */
    public GetInventoryImpl() {
    }
    
    public GetInventoryResponseT getInventory(GetInventoryT mtosiBody) {
        GetInventoryResponseT getInventoryResponse = new GetInventoryResponseT();
        try {
            // First baseInstance
            SimpleFilterT simpleFilter2 = mtosiBody.getFilter();
            List<NamingAttributesT> baseInstance2 = simpleFilter2.getBaseInstance();
            NamingAttributesT namingAttributes2 = baseInstance2.get(0);
            String mdNm = namingAttributes2.getMdNm();
            System.out.println("BaseInstance: " + mdNm);
            List<IncludedObjectType> includedObjectTypes2 = simpleFilter2.getIncludedObjectType();
            // First includedObjectType
            IncludedObjectType includedObjectType2 = includedObjectTypes2.get(0);
            ObjectAcronymT objectAcronym = includedObjectType2.getObjectType();
            GranularityT granularity2 = includedObjectType2.getGranularity();
            System.out.println("IncludedObjectType: " + "{(Objectype: " + objectAcronym.value() +
                    " Granularity: " + granularity2.value() + ")}");
            InventoryDataT inventoryData = new InventoryDataT();
            // Process the requests on the database (ex: BaseInstance: {(Server2)} IncludedObjectType: {(ME,ATTRS)}
            // Get the ManagementDomain of the mdNm specified
            Query query0 = em.createQuery("SELECT DISTINCT md from ManagementDomainT md JOIN md.nameAtt n  WHERE n.mdNm = " +  "'" + mdNm + "'");
            ManagementDomainT md = (ManagementDomainT) query0.getResultList().get(0);
            System.out.println("discoveredName du md: " + md.getDiscoveredName());
            //if (objectAcronym.value()== "ME"){
            // Get the ManagedElements of ManagementDomain mdNm
            Query query1 = em.createQuery("SELECT DISTINCT me FROM ManagedElementT me JOIN me.nameAtt n WHERE n.mdNm = " +  "'" + mdNm + "'");
            List<ManagedElementT> meS= (List<ManagedElementT>) query1.getResultList();
            MeList meList = new MeList();
            List<MEInventoryT> meinvs = meList.getMeInv();
            MEInventoryT meinv = new MEInventoryT();
            ListIterator<MEInventoryT> lit = meinvs.listIterator();
            int i = 0;
            for (ManagedElementT me : meS) {
                NamingAttributesT me_nas = me.getNameAtt();
                MEInventoryT meinv1 = new MEInventoryT();
                meinv1.setMeNm(me_nas.getMeNm());
                meinv1.setMeAttrs(me);
                lit.add(meinv1);
            }
            // Create the mdinv list
            MDInventoryT mdinv = new MDInventoryT();
            mdinv.setMeList(meList);
            mdinv.setMdNm(md.getNameAtt().getMdNm());
            mdinv.setMdAttrs(md);
            MdList mdList = new MdList();
            List<MDInventoryT> mdinvs = mdList.getMd();
            mdinvs.add(mdinv);
            inventoryData.setMdList(mdList);
            // Set the response
            getInventoryResponse.setInventoryData(inventoryData);
            MDInventoryT mdinvr = getInventoryResponse.getInventoryData().getMdList().getMd().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<MDInventoryT> mdInvsr = getInventoryResponse.getInventoryData().getMdList().getMd();
        List<MEInventoryT> meInvsr1 = mdInvsr.get(0).getMeList().getMeInv();
        System.out.println("meNm1: " + meInvsr1.get(0).getMeNm());
        System.out.println("meNm2: "+ meInvsr1.get(1).getMeNm());
        
        return getInventoryResponse;
    }
    
    
    // Create the getInventory object from the values of the filter entered in the web page
    public File createGetInventoryRequest(String bi, String obj, String gran) {
        GetInventoryT mtosiBody = new GetInventoryT();
        SimpleFilterT simpleFilter = new SimpleFilterT();
        // baseInsanceList
        List<NamingAttributesT> baseInstance = simpleFilter.getBaseInstance();
        NamingAttributesT namingAttrs1 = new NamingAttributesT();
        namingAttrs1.setMdNm(bi);
        baseInstance.add(namingAttrs1);
        // includedObjectTypes
        List<IncludedObjectType> includedObjectTypes = simpleFilter.getIncludedObjectType();
        IncludedObjectType includedObjectType = new IncludedObjectType();
        includedObjectType.setObjectType(ObjectAcronymT.valueOf(obj));
        includedObjectType.setGranularity(GranularityT.valueOf(gran));
        includedObjectTypes.add(includedObjectType);
        mtosiBody.setFilter(simpleFilter);
        // call the getInventory operation
        GetInventoryResponseT resp = getInventory(mtosiBody);
        // TODO process print of the response
        
        return marshallResponse(resp);
    }
    
    public File marshallResponse(GetInventoryResponseT getInventoryResponse) {
        try {
            InventoryDataT inv = getInventoryResponse.getInventoryData();
            JAXBContext jc = JAXBContext.newInstance("v1.tmf854");
            ObjectFactory objFactory = new ObjectFactory();
            GetInventoryResponseT getInv = objFactory.createGetInventoryResponseT();
            getInv.setInventoryData(inv);
            Marshaller marshaller= jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            //StringWriter writer = new StringWriter();
            File res = new File("response.xml");
            OutputStream os = new FileOutputStream(res);
            marshaller.marshal(getInv, os );
            return res;
        }   catch(IOException e){
            e.printStackTrace();
        } catch( JAXBException je ) {
            je.printStackTrace();
        }
        return null;
        
    }
    
    public void persist(Object object) {
        // TODO:
        // em.persist(object);
    }
}
