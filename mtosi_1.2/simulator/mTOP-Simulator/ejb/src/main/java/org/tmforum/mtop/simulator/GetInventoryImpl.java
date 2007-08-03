/*
 * GetInventoryBean.java
 *
 * Created on 15 avril 2007, 15:20
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.tmforum.mtop.simulator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.util.*;
import javax.jws.*;
import javax.xml.ws.*;
import javax.jws.soap.*;
import javax.jws.soap.SOAPBinding.*;
import javax.jws.WebParam.*;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Marshaller;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.tmforum.mtop.simulator.util.A;

import v1.tmf854.*;
import v1.tmf854.InventoryDataT.MdList;
import v1.tmf854.SimpleFilterT.IncludedObjectType;
import org.tmforum.mtop.simulator.CreateGetInventoryResponse;
import ws.v1.tmf854.ProcessingFailureException;


/**
 *
 * @author baptiste
 */

@Stateful
public class GetInventoryImpl implements GetInventory {
    
    @PersistenceContext
    private EntityManager em;
    private String objectTypeS = "";
    private String granularityS = "NAME";
    private String baseInstanceS = "";
    private long batchSequenceNumber = 0;
    //private List<Object> managedEntitiesRetrieved = new ArrayList();
    private List<Long> managedEntitiesRetrievedIds = new ArrayList();
    //CreateGetInventoryResponse objectType;// = new CreateGetInventoryResponse();
    
    public GetInventoryImpl(){
    }
    
    public v1.tmf854.GetInventoryResponseT getInventory(
            @WebParam(mode=Mode.INOUT, header=true) javax.xml.ws.Holder<v1.tmf854.HeaderT> mtosiHeader,
    v1.tmf854.GetInventoryT mtosiBody) throws ProcessingFailureException {
        
        System.out.println("************GetInventoryImpl:getInventoryT **************");
        GetInventoryResponseT getInventoryResponse = new GetInventoryResponseT();
        
        // Set the header parameters
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
        header.setSenderURI("/MTOSI/InventoryOS");
        header.setDestinationURI("/MTOSI/EMS01");
        header.setCommunicationPattern(CommunicationPatternT.fromValue("MultipleBatchResponse"));
        header.setCommunicationStyle(CommunicationStyleT.RPC);
        header.setTimestamp("20051004140305");
        mtosiHeader.value = header;
        
        // set the body parameters : baseInstance and includedObjectType
        SimpleFilterT simpleFilter = mtosiBody.getFilter();
        List<NamingAttributesT> baseInstance = simpleFilter.getBaseInstance();
        List<IncludedObjectType> includedObjectTypes = simpleFilter.getIncludedObjectType();
        A a = new A();
        // check if the baseInstance is valid
        a.validRequest(baseInstance, includedObjectTypes);
        a.validBaseInstance(baseInstance);
        
        CreateGetInventoryResponse objectType = new CreateGetInventoryResponse();
        objectType.init();
        for (NamingAttributesT namingAttributes : baseInstance)  {
            
            baseInstanceS = a.baseInstance(namingAttributes);
            GranularityT granularity = null;
            for (IncludedObjectType includedObjectType : includedObjectTypes) {
                a.validIncludedObjectType(includedObjectType, namingAttributes, includedObjectTypes);
                granularityS = includedObjectType.getGranularity().value();
                objectTypeS = includedObjectType.getObjectType().name();
                objectTypeS = a.tableName(objectTypeS);
                objectType = a.objectType(objectTypeS);
                this.setBaseInstanceS(baseInstanceS);
                this.setObjectTypeS(objectTypeS);
                // Request which will be processed into the database
                String request = "SELECT DISTINCT element FROM " + objectTypeS  + " element JOIN element.name n WHERE " + baseInstanceS;
                System.out.println("Request processed into the database: " + request);
                //Query  queryManagedEntities = null;
                
                //List queryManagedEntities = em.createQuery(request).getResultList();
                Query queryManagedEntities = em.createQuery(request);
                //int nbManagedEntitiesRetrieved = queryManagedEntities.size();//.getResultList().size();
                int nbManagedEntitiesRetrieved = queryManagedEntities.getResultList().size();
                int nbManagedEntitiesToRetrieve = header.getRequestedBatchSize().intValue();
                System.out.println("nbManagedEntitiesRetrieved: " +  nbManagedEntitiesRetrieved);
                System.out.println("nbManagedEntitiesToRetrieve: " +   nbManagedEntitiesToRetrieve);
                
                if (nbManagedEntitiesRetrieved == 0) {
                    // No managed entities retrieved
                    ProcessingFailureExceptionT pfe = new ProcessingFailureExceptionT();
                    String objectMissing = objectTypeS.substring(0, objectTypeS.length()- 1);
                    pfe.setReason("No " + objectMissing + " in the database. ");
                    throw new ProcessingFailureException("error", pfe);
                } else if ((nbManagedEntitiesToRetrieve >= nbManagedEntitiesRetrieved) || nbManagedEntitiesToRetrieve == 0) {
                    // The response batch is the last one
                    System.out.println("BatchSequenceEndOfReply(true)");
                    header.setBatchSequenceEndOfReply(true);
                } else {
                    // The response batch is not the last one.
                    queryManagedEntities.setMaxResults(nbManagedEntitiesToRetrieve);
                    // Store the ids retrieved for next requests (getInventoryIterator)
                    Query queryIds = em.createQuery(
                            "SELECT DISTINCT element.id FROM " + objectTypeS  +
                            " element JOIN element.name n WHERE " + baseInstanceS);
                    queryIds.setMaxResults(header.getRequestedBatchSize().intValue());
                    managedEntitiesRetrievedIds = (List<Long>) queryIds.getResultList();
                }
                
                
                //System.out.println("queryManagedEntities.getResultList().size(): " + queryManagedEntities.getResultList().size());
                // Creates the getInventoryResponse
                //List<Object> managedEntitiesRetrieved = new ArrayList();
                List managedEntitiesRetrieved = queryManagedEntities.getResultList();
                //ManagementDomainT mdRetrieved = (ManagementDomainT) queryManagedEntities.get(0);
                //ManagementDomainT md = (ManagementDomainT) mdRetrieved.copyManagedEntity();
                // System.out.println("me.disco: " + me.getDiscoveredName());
                // me.setDiscoveredName("tata");
                //System.out.println("md.getMdInventoryT() " + md.getMdInventoryT());
                // System.out.println("mdRetrieved.getMdInventoryT() " + mdRetrieved.getMdInventoryT());
                //md.setMdInventoryT(null);
                objectType.createResponse(managedEntitiesRetrieved, granularityS);
                
            } // for iot
        } // for bi
        
        // add the created response to mdList
        MdList mdList = new MdList();
        InventoryDataT inventoryData = new InventoryDataT();
        mdList = CreateGetInventoryResponse.getMdList();
        inventoryData.setMdList(mdList);
        getInventoryResponse.setInventoryData(inventoryData);
        
        System.out.println("*************************** Fin getInventory Call **********************************");
        return getInventoryResponse;
        //return new GetInventoryResponseT();
    }
    
    
    public v1.tmf854.GetInventoryResponseT getInventoryIterator(
            @WebParam(mode=Mode.INOUT, header=true)  javax.xml.ws.Holder<v1.tmf854.HeaderT> mtosiHeader,
    v1.tmf854.GetInventoryIteratorT mtosiBody) throws ProcessingFailureException {
        
        System.out.println("*************GetInventoryImpl:getInventoryIterator***************** ");
        GetInventoryResponseT getInventoryResponse = new GetInventoryResponseT();
        System.out.println("batchsequenceNumber " + batchSequenceNumber);
        batchSequenceNumber++;
        
        try {
            // Set the header parameters
            HeaderT header = mtosiHeader.value;
            header.setBatchSequenceNumber(new Long(batchSequenceNumber));
            header.setBatchSequenceEndOfReply(false);
            header.setIteratorReferenceURI("12345");
            header.setTimestamp("20051004140305");
            header.setCorrelationId(header.getCorrelationId() + "1");
            
            ArrayList<Long> lid = new ArrayList();
            lid.add(new Long("2"));
            
            // Creates the request which will be processed into the database
            StringBuilder sb = new StringBuilder("SELECT DISTINCT element FROM " + objectTypeS + " element  WHERE element.id NOT IN (");
            String separator = "";
            for (Long id : managedEntitiesRetrievedIds) {
                System.out.println("managedIdsRetrieved: " + id);
                sb.append(separator);
                sb.append(id.longValue());
                separator = ", ";
            }
            sb.append(")");
            String ejbql = sb.toString();
            System.out.println("getInventoryIterator:::request " + ejbql);
            Query queryItManagedEntities = em.createQuery(ejbql);
            
            String tmp = ejbql.substring(24);
            String ejbql2 = "SELECT DISTINCT element.id " + tmp;
            System.out.println("**************ejbql2 " + ejbql2);
            Query queryItManagedEntitiesIds = em.createQuery(ejbql2);
            queryItManagedEntitiesIds.setMaxResults(header.getRequestedBatchSize().intValue());
            
            int nbManagedEntitiesRetrieved = queryItManagedEntities.getResultList().size();
            int nbManagedEntitiesToRetrieve = header.getRequestedBatchSize().intValue();
            if (nbManagedEntitiesToRetrieve > nbManagedEntitiesRetrieved)
                 nbManagedEntitiesToRetrieve = nbManagedEntitiesRetrieved;
            // Add the ids of managed entities retrieved to the list of retrieved Ids
            List<Long> managedEntitiesRetrievedAllIds = (List<Long>) queryItManagedEntitiesIds.getResultList();
            List<Long> managedEntitiesRetrievedIdsIt = managedEntitiesRetrievedAllIds.subList(0, nbManagedEntitiesToRetrieve);
            if (managedEntitiesRetrievedIdsIt.containsAll(managedEntitiesRetrievedAllIds)) {
                // The response batch is the last one
                header.setBatchSequenceEndOfReply(true);
                System.out.println("LASTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
                System.out.println("header.setBatchSequenceEndOfReply(true) ");
            }
            mtosiHeader.value = header;
            // System.out.println("managedEntitiesRetrievedIdsTmp.size " + managedEntitiesRetrievedIdsIt.size());
            managedEntitiesRetrievedIds.addAll(managedEntitiesRetrievedIdsIt);
            System.out.println("managedEntiesRetrievedIds.size " + managedEntitiesRetrievedIds.size());
            
            queryItManagedEntities.setMaxResults(nbManagedEntitiesToRetrieve);
            System.out.println("nbManagedEntitiesRetrieved: " +  nbManagedEntitiesRetrieved);
            System.out.println("nbManagedEntitiesToRetrieve: " +   nbManagedEntitiesToRetrieve);
            
            // Creates the response
            List managedEntitiesRetrieved = queryItManagedEntities.getResultList();
            CreateGetInventoryResponse objectType = new CreateGetInventoryResponse();
            objectType.init();
            A a = new A();
            System.out.println("ObjectTypeS:  " + objectTypeS);
            objectType = a.objectType(objectTypeS);
            objectType.createResponse(managedEntitiesRetrieved, granularityS);
            
            // add the created response to mdList
            MdList mdList = new MdList();
            InventoryDataT inventoryData = new InventoryDataT();
            mdList = CreateGetInventoryResponse.getMdList();
            inventoryData.setMdList(mdList);
            getInventoryResponse.setInventoryData(inventoryData);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //System.out.println("it name1: " + getInventoryResponse.getInventoryData().getMdList().getMd().get(0).getMeList().getMeInv().get(0).getMeNm());
        
        System.out.println("*************************** Fin getInventoryIterator Call **********************************");
        
        return getInventoryResponse;
    }
    
    
    
    /** Create the getInventory object from the values of the filter entered in the web page */
    public File createGetInventoryRequest(Map baseInstancesMap, Map includedObjectTypesMap) {
        System.out.println("********GetInventoryImpl:createGetInventoryRequest****** ");
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
        }catch(ProcessingFailureException p) {
            System.out.println("Error");
        }
        return null;//marshallResponse(resp);
    }
    /*
    public File marshallResponse(GetInventoryResponseT getInventoryResponse) {
        System.out.println("************InventoryRetrievalImpl:marshallResponse***********");
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
    }*/
    
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
