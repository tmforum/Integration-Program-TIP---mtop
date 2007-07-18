/*
 * GetInventoryBean.java
 *
 * Created on 15 avril 2007, 15:20
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.tmforum.mtop.simulator.session;

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
import org.tmforum.mtop.simulator.creategetinventoryresponse.CreateGetInventoryResponse;
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
    private String granularityS = "ATTRS";
    private String baseInstanceS = "";
    private long batchSequenceNumber = 0;
    private List<Object> managedEntitiesRetrieved = new ArrayList();
    
    public GetInventoryImpl(){
    }
    
    public v1.tmf854.GetInventoryResponseT getInventory(
            @WebParam(mode=Mode.INOUT, header=true) javax.xml.ws.Holder<v1.tmf854.HeaderT> mtosiHeader,
    v1.tmf854.GetInventoryT mtosiBody) throws ProcessingFailureException {
        System.out.println("************GetInventoryImpl:getInventory **************");
        GetInventoryResponseT getInventoryResponse = new GetInventoryResponseT();
        CreateGetInventoryResponse objectType = new CreateGetInventoryResponse();
        
        // set the header parameters
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
        // check if the baseInstance is valid (an exception is thrown if not)
        a.validBaseInstance(baseInstance);
        objectType.init();
        
        for (NamingAttributesT namingAttributes : baseInstance)  {
            // loop threw all namingAttributes specified in the baseInstance
            // a.validBaseInstance(baseInstance); ??
            baseInstanceS = a.baseInstance(namingAttributes);
            GranularityT granularity = null;
            String granularityS = null;
            
            for (IncludedObjectType includedObjectType : includedObjectTypes) {
                a.validIncludedObjectType(includedObjectType);
                a.iotUnderBi(namingAttributes, includedObjectType);
                granularityS = includedObjectType.getGranularity().value();
                objectTypeS = includedObjectType.getObjectType().name();
                objectTypeS = a.tableName(objectTypeS);
                objectType = a.objectType(objectTypeS);
                this.setBaseInstanceS(baseInstanceS);
                this.setObjectTypeS(objectTypeS);
                Query query1 = null;
                
                // defines the request which will be processed into the database
                String request = "SELECT DISTINCT element FROM " + objectTypeS  + " element JOIN element.name n WHERE " + baseInstanceS;
                System.out.println("Request: " + request);
                query1 = em.createQuery(request);
                
                if (header.getRequestedBatchSize().intValue() > 1) {
                    // managed entities are returned in several batches
                    System.out.println("header.getRequestedBatchSize().intValue() > 1 and = " + header.getRequestedBatchSize().intValue());
                    query1.setMaxResults(header.getRequestedBatchSize().intValue());
                    managedEntitiesRetrieved = query1.getResultList();
                } else {
                    // managed entities are returned in one batch
                    managedEntitiesRetrieved = query1.getResultList();
                    if (managedEntitiesRetrieved.size() == 0) {
                        // no managed entities retrieved
                        ProcessingFailureExceptionT pfe = new ProcessingFailureExceptionT();
                        String objectMissing = objectTypeS.substring(0, objectTypeS.length()- 1);
                        pfe.setReason("No " + objectMissing + " in the database. ");
                        throw new ProcessingFailureException("error", pfe);
                    }
                    System.out.println("inventory-> managedEntitiesRetrieved.size(): " + managedEntitiesRetrieved.size());
                }
                // creates the getInventoryResponse
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
    }
    
    public v1.tmf854.GetInventoryResponseT getInventoryIterator(
            @WebParam(mode=Mode.INOUT, header=true)  javax.xml.ws.Holder<v1.tmf854.HeaderT> mtosiHeader,
    v1.tmf854.GetInventoryIteratorT mtosiBody) throws ProcessingFailureException {
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
            
            // list of managedentities id already retrieved
            List<Long> managedEntitiesRetrievedIds = new ArrayList();
            // defines the request which will be processed into the database
            StringBuilder sb = new StringBuilder("SELECT DISTINCT element FROM " + objectTypeS + " element  WHERE element.id NOT IN (");
            String separator = "";
            for (Long id : managedEntitiesRetrievedIds) {
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
            managedEntitiesRetrieved = query2.getResultList();
            System.out.println("iterator-> objs.size(): " + managedEntitiesRetrieved.size());
            CreateGetInventoryResponse objectType = new  CreateGetInventoryResponse();
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
