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
import v1.tmf854.MEInventoryT.EhList;
import v1.tmf854.SimpleFilterT.IncludedObjectType;
import ws.v1.tmf854.*;
import java.io.*;
import java.util.*;
import javax.jws.*;
import javax.xml.ws.*;
import javax.jws.soap.*;
import javax.jws.soap.SOAPBinding.*;
import javax.jws.WebParam.*;

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
import javax.jws.WebMethod;
import javax.persistence.*;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import me.*;
/**
 *
 * @author baptiste
 */

@Stateful
public class GetInventoryImpl implements GetInventory {
    
    @PersistenceContext
    private EntityManager em;
    private String objectTypeS = "";//ManagedElementT";
    private String granularityS = "ATTRS";
    private String baseInstanceS = "";//WHERE n.mdNm = md1 AND  n.meNm = me1";
    private long batchSequenceNumber = 0;
    private List<Object> equipmentsRetrieved = new ArrayList();
    
    public GetInventoryImpl(){
    }
    
    public v1.tmf854.GetInventoryResponseT getInventory(
            @WebParam(mode=Mode.INOUT, header=true) javax.xml.ws.Holder<v1.tmf854.HeaderT> mtosiHeader,
    v1.tmf854.GetInventoryT mtosiBody) throws ProcessingFailureException {
        System.out.println("************GetInventoryImpl:getInventory **************");
        GetInventoryResponseT getInventoryResponse = new GetInventoryResponseT();
        CreateResponse objectType = new CreateResponse();
        
        // try {
        // header parameters
        HeaderT header = mtosiHeader.value;
        if (header.getRequestedBatchSize().intValue() > 0) {
            header.setBatchSequenceNumber(new Long(1));
            header.setBatchSequenceEndOfReply(false);
            header.setIteratorReferenceURI("12345");
            header.setCorrelationId(header.getCorrelationId() + "1");
        }
        header.setRequestedBatchSize((Long) header.getRequestedBatchSize());
        header.setActivityName("getInventory");
        header.setMsgName("getInventory");
        //System.out.println("server: header.getCorrelationId " + header.getCorrelationId());
        header.setSenderURI("/MTOSI/InventoryOS");
        header.setDestinationURI("/MTOSI/EMS01");
        header.setCommunicationPattern(CommunicationPatternT.fromValue("MultipleBatchResponse"));
        header.setCommunicationStyle(CommunicationStyleT.RPC);
        header.setTimestamp("20051004140305");
        System.out.println("*****Cote serveur correlationId******** = " + mtosiHeader.value.getCorrelationId());
        mtosiHeader.value = header;
        
        // body parameters
        SimpleFilterT simpleFilter = mtosiBody.getFilter();
        
        // baseInstance
        A a = new A();
        List<NamingAttributesT> baseInstance = simpleFilter.getBaseInstance();
        List<IncludedObjectType> includedObjectTypes = simpleFilter.getIncludedObjectType();
        
        System.out.println("baseInstance.size() " + baseInstance.size());
        a.validBaseInstance(baseInstance);
        
        objectType.init();
        
        for (NamingAttributesT namingAttributes : baseInstance)  {
            // check if it is a valid baseInstance
            a.validBaseInstance(baseInstance);
            baseInstanceS = a.baseInstance(namingAttributes);
            GranularityT granularity = null;
            String granularityS = null;
            // String baseInstanceLeaf = a.baseInstanceLeaf();
            // includedObjectType
            
            System.out.println("includedObjectType.size() " + includedObjectTypes.size());
            for (IncludedObjectType includedObjectType : includedObjectTypes) {
                a.validIncludedObjectType(includedObjectType);
                granularityS = includedObjectType.getGranularity().value();
                objectTypeS = includedObjectType.getObjectType().name();
                System.out.println("objectTypeS0 " + objectTypeS);
                objectTypeS = a.tableName(objectTypeS);
                System.out.println("objectType1: " + objectTypeS);
                objectType = a.objectType(objectTypeS);
                System.out.println("objectType2: " + objectTypeS);
                System.out.println("granularity: " + granularityS);
                this.setBaseInstanceS(baseInstanceS);
                this.setObjectTypeS(objectTypeS);
                Query query1 = null;
                
               System.out.println("Requesttttttttttttt: " + "SELECT DISTINCT element FROM " + objectTypeS + " element JOIN element.name n  WHERE " + baseInstanceS);
               //System.out.println("objectTypeS:  " + objectTypeS);
                // retrieves equipments specified in the filter from the database
             
               query1 = em.createQuery("SELECT DISTINCT element FROM " + objectTypeS  + " element JOIN element.name n WHERE " + baseInstanceS);
                    
             
                if (header.getRequestedBatchSize().intValue() > 1) {
                    // equipments are returned in several batches
                    System.out.println("header.getRequestedBatchSize().intValue() > 1 and = " + header.getRequestedBatchSize().intValue());
                    query1.setMaxResults(2);
                    equipmentsRetrieved = query1.getResultList();
                } else {
                    equipmentsRetrieved = query1.getResultList();
                    
                    if (equipmentsRetrieved.size() == 0) {
                        ProcessingFailureExceptionT p = new ProcessingFailureExceptionT();
                        String s2 = objectTypeS.substring(0, objectTypeS.length()- 1);
                        p.setReason("No " + s2 + " in the database. ");
                        throw new ProcessingFailureException("error", p);
                    }
                    
                    System.out.println("inventory-> equipmentsRetrieved.size(): " + equipmentsRetrieved.size());
                }
                
                // creates the mdInv for current iot and adds it to mdList
                // CreateResponse resp = new  CreateResponse();
                //MDInventoryT mdInv = objectType.createResponse2(equipmentsRetrieved, granularityS);
                // mdInvs.add(mdInv);
                System.out.println("********objectType.createResponse2***********");
                System.out.println("objectType: " + objectTypeS);
                objectType.createResponse2(equipmentsRetrieved, granularityS);
                System.out.println("*********fin objectType.createResponse2******************************************");
                //createResponseList.add(objectType);
            } // for iot
        } // for bi
        
        
        MdList mdList = new MdList();
        mdList = CreateResponse.getMdList();
        InventoryDataT inventoryData = new InventoryDataT();
        inventoryData.setMdList(mdList);
        
        System.out.println("a: " + objectType.getA());
        //sort createResponseList on level in Naming Hierarchy
        //System.out.println("createResponseList.size() " + createResponseList.size());
        //Collections.sort(createResponseList);
        //Iterator it = createResponseList.iterator();
        //CreateResponse c0 = (CreateResponse) it.next();
        
       /*
        while (it.hasNext()) {
            c0.addChildList((CreateResponse)it.next());
        }*/
        
        // inventoryData = c0.getInventoryData();
        // for mdinv in mdi
        // take the highest ; add
        //  inventoryData.setMdList(objectType.getMdList());
        //System.out.println("pgpNm::::::::: " + mdList.getMd().get(0).getMeList().getMeInv().get(0).getEhList().getEhInv().get(0).getEhNm());
        
        getInventoryResponse.setInventoryData(inventoryData);
        // }
      /* catch (Exception e) {
            e.printStackTrace();
        }
       */
        System.out.println("*************************** Fin getInventory Call **********************************");
        
        return getInventoryResponse;
    }
    
    public v1.tmf854.GetInventoryResponseT getInventoryIterator(
            @WebParam(mode=Mode.INOUT, header=true)  javax.xml.ws.Holder<v1.tmf854.HeaderT> mtosiHeader,
    v1.tmf854.GetInventoryIteratorT mtosiBody) throws ws.v1.tmf854.ProcessingFailureException {
        
        System.out.println("*************GetInventoryImpl:getInventoryIterator***************** ");
        GetInventoryResponseT getInventoryResponse = new GetInventoryResponseT();
        System.out.println("batchsequenceNumber " + batchSequenceNumber);
        batchSequenceNumber++;
        
        try {
            // header parameters
            HeaderT header = mtosiHeader.value;
            header.setBatchSequenceNumber(new Long(batchSequenceNumber));
            header.setBatchSequenceEndOfReply(false);
            header.setIteratorReferenceURI("12345");
            header.setTimestamp("20051004140305");
            header.setCorrelationId(header.getCorrelationId() + "1");
            mtosiHeader.value = header;
            ArrayList<Long> lid = new ArrayList();
            lid.add(new Long("2"));
            //lid.add(new Long("md1-me1-discoveredName"));
            //test
            /*List<String> names = new ArrayList();
            names.add("toto");
            names.add("md1-me1-discoveredName");
            names.add("md1-me2-discoveredName");*/
            
            // list of equipments retrieved ids
            List<Long> equipmentsRetrievedIds = new ArrayList();
            equipmentsRetrievedIds.add(new Long(206));
            equipmentsRetrievedIds.add(new Long(8));
            // creates the request query
            StringBuilder sb = new StringBuilder("SELECT DISTINCT element FROM " + objectTypeS + " element  WHERE element.id NOT IN (");
            String separator = "";
            for (Long id : equipmentsRetrievedIds) {
                sb.append(separator);
                //sb.append("'");
                sb.append(id.longValue());
                //sb.append("'");
                separator = ", ";
            }
            sb.append(")");
            String ejbql = sb.toString();
            System.out.println("getInventoryIterator->ejbql request: " + ejbql);
            Query query2 = em.createQuery(ejbql);
            
            // retrieves equipments which have not been retrieved yet
            // Query query2 = em.createQuery("SELECT e FROM ManagedElementT e  JOIN e.name n  WHERE n.mdNm =  'md1'  AND e.id NOT IN (SELECT er.num from EquipmentsRetrieved er)");
            //Query query2 = em.createQuery("SELECT e FROM ManagedElementT e  JOIN e.name n " + baseInstanceS + " AND e.id NOT IN (SELECT er.num from EquipmentsRetrieved er)");
            //Query query2 = em.createQuery("SELECT e FROM ManagedElementT e where e.id NOT IN ("));//(SELECT er.num from EquipmentsRetrieved er)");
            //List<ManagedElementT> ms = (List<ManagedElementT>)em.createQuery("dsfs").setParameter() createNamedQuery("query9").setParameter("baseInstanceS", baseInstanceS).setParameter("id", new Long(1)).getResultList();
            //List ids = new ArrayList();
            //ids.add(new Integer(1));
            //query2. .setParameter(1, new Integer(1));
            System.out.println("iterator-> header.getRequestedBatchSize()  " + header.getRequestedBatchSize().intValue());
            //query2.setMaxResults(header.getRequestedBatchSize().intValue());
            equipmentsRetrieved = query2.getResultList();
            //List<ManagedElementT> ms =  query2.getResultList();
            //System.out.println("iterator-> objs.size(): " + ms.size());
            System.out.println("iterator-> objs.size(): " + equipmentsRetrieved.size());
            
            // persists retrieved equipments in EquipmentsRetrieved Table
           /* for (Object m : equipmentsRetrieved) {
                long num = m.getId().longValue();
                EquipmentsRetrieved eq = new EquipmentsRetrieved();
                eq.setNumber(num);
                em.persist(eq);
                System.out.println("ms persiste!");
            }*/
            
            CreateResponse objectType = new  CreateResponse();
            objectType.createResponse2(equipmentsRetrieved, granularityS);
            
            MdList mdList = new MdList();
            mdList = CreateResponse.getMdList();
            InventoryDataT inventoryData = new InventoryDataT();
            inventoryData.setMdList(mdList);
            
            getInventoryResponse.setInventoryData(inventoryData);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("*************************** Fin getInventoryIterator Call **********************************");
        return getInventoryResponse;
    }
    
    /** Create the getInventory object from the values of the filter entered in the web page */
    public File createGetInventoryRequest(Map baseInstancesMap, Map includedObjectTypesMap) {
        System.out.println("********GetInventoryImpl:createGetInventoryRequest****** ");
        
        //affichage des maps
//      System.out.println("affichage de bis");
//        printMap(bis);
//      System.out.println("affichage de includedObjectTypes");
//       printMap(includedObjectTypes);
        
        GetInventoryT mtosiBody = new GetInventoryT();
        SimpleFilterT simpleFilter = new SimpleFilterT();
        
        // set the baseInstance
        NamingAttributesT namingAttrs = new NamingAttributesT();
        // set the namingAttributes from the values in the baseInstancesMap
        //namingAttrs.init(baseInstancesMap, namingAttrs);
        //System.out.println("namingAttrs  " + namingAttrs.getMdNm());
        List<NamingAttributesT> baseInstance = simpleFilter.getBaseInstance();
        baseInstance.add(namingAttrs);
        
        // set the includedObjectType
        List<IncludedObjectType> includedObjectTypes = simpleFilter.getIncludedObjectType();
        IncludedObjectType includedObjectType = new IncludedObjectType();
        String objectTypeS = (String) includedObjectTypesMap.get("objectAcronym1");
        includedObjectType.setObjectType(ObjectAcronymT.fromValue(objectTypeS));
        String granularityS = (String) includedObjectTypesMap.get("granularity1");
        includedObjectType.setGranularity(GranularityT.fromValue(granularityS));
        includedObjectTypes.add(includedObjectType);
        
        System.out.print("SimpleFilterincludedObjectType: " + includedObjectTypes.get(0).getObjectType().name());
        mtosiBody.setFilter(simpleFilter);
        
        // call the getInventory operation
        try {
            GetInventoryResponseT resp = getInventory(null , mtosiBody);
        }catch(ws.v1.tmf854.ProcessingFailureException p) {
            System.out.println("Error");
        }
        return null;//marshallResponse(resp);
    }
    
    public File marshallResponse(GetInventoryResponseT getInventoryResponse) {
        System.out.println("************GetInventoryImpl:marshallResponse***********");
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
        }catch(NullPointerException e) {
            System.err.println("Element Object Type is not in the database");
        }
        return null;
    }
    
    public void printMap(Map map) {
        System.out.println("**************GetInventoryImpl:printMap************** ");
        System.out.println("taille de la map " + map.size());
        Set entries = map.entrySet();
        Iterator iter = entries.iterator();
        while(iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println("key=" + key + ", value=" + value );
        }
    }
    
    public void persist(Object object) {
        // TODO:
        // em.persist(object);
    }
    
    public String getObjectTypeS() {
        return objectTypeS;
    }
    
    public void setObjectTypeS(String objectTypeS) {
        this.objectTypeS = objectTypeS;
    }
    
    public String getBaseInstanceS() {
        return baseInstanceS;
    }
    
    public void setBaseInstanceS(String baseInstanceS) {
        this.baseInstanceS = baseInstanceS;
    }
    
    public boolean notSpecified(String s) {
        
        return (s == null || s.equals(""));
    }
}
