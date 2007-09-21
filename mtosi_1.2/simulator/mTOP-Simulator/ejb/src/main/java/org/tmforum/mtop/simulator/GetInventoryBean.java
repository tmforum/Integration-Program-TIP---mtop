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
import org.tmforum.mtop.simulator.exception.*;

import v1.tmf854.*;
import v1.tmf854.InventoryDataT.MdList;
import v1.tmf854.SimpleFilterT.IncludedObjectType;
import org.tmforum.mtop.simulator.CreateGetInventoryResponse;

@Stateful
public class GetInventoryBean implements GetInventory {

    @PersistenceContext
    private EntityManager em;
    private String objectTypeClassName = "";
    private String granularityS = "NAME";
    private String baseInstanceS = "";
    private long batchSequenceNumber = 0;
    private List<Long> managedEntitiesAlreadyRetrievedIds = new ArrayList();
    private String join = "";
    private boolean  managedEntityIsAUnit = true;
    private boolean endOfReply = false;
    private boolean createdResponse = false;
    private Map elementsLeftMap = new HashMap();
    private GetInventoryT filterBody = new GetInventoryT();
    private InventoryDataT previousInventoryData;
    
    /**
     * This function implements the semantic of the getInventory operation.
     * @param mtosiHeader the header parameters of the getInventory operation
     * @param mtosiBody the body parameters (filter) of the getInventory operation
     * @return returns the getInventory response corresponding to the request
     */
    public v1.tmf854.GetInventoryResponseT getInventory(
            @WebParam(mode=Mode.INOUT, header=true) javax.xml.ws.Holder<v1.tmf854.HeaderT> mtosiHeader,
    v1.tmf854.GetInventoryT mtosiBody) throws ProcessingFailureException {
        System.out.println("************GetInventoryImpl:getInventoryyT **************");
        
        // initialize global variables
        this.objectTypeClassName = "";
        this.baseInstanceS = "";
        this.batchSequenceNumber = 0;
        this.managedEntitiesAlreadyRetrievedIds = new ArrayList();
        this.filterBody = mtosiBody;
        this.elementsLeftMap = new HashMap();
        this.endOfReply = false;
        this.createdResponse = false;
        // initalize local variables
        int nbElementsRetrieved = 0;
        int nbIOTsTreated = 0;
        int nbBIsTreated = 0;
        boolean getInventoryRequestFinished = false;
        GetInventoryResponseT getInventoryResponse = new GetInventoryResponseT();
        CreateGetInventoryResponse objectType = new CreateGetInventoryResponse();
        Util util = new Util();
        
        // set the header parameters
        HeaderT header = mtosiHeader.value;
        mtosiHeader.value = setHeaderParameters(header);
        
        // set the body parameters : baseInstance and includedObjectType
        SimpleFilterT simpleFilter = mtosiBody.getFilter();
        List<NamingAttributesT> baseInstance = simpleFilter.getBaseInstance();
        List<IncludedObjectType> includedObjectTypes = simpleFilter.getIncludedObjectType();
        
        int requestedBatchSize = header.getRequestedBatchSize().intValue();
        // the number of managed entities still to retrieve
        int nbMaxElementsToRetrieve = requestedBatchSize;
        
        // check if the baseInstance is valid
        util.validBaseInstance(baseInstance);
        objectType.init();
        
        // loop through all baseInstances
        for (NamingAttributesT namingAttributes : baseInstance) {
            nbBIsTreated++;
            
            if (getInventoryRequestFinished)
                break;
            
            elementsLeftMap = new HashMap();
            baseInstanceS = util.createBaseInstanceInRequest(namingAttributes);
            GranularityT granularity = null;
            
            // for each base instance loop through all includedObjectTypes
            for (IncludedObjectType includedObjectType : includedObjectTypes) {
                
                nbIOTsTreated++;
                
                // check if the includedObjectType is valid
                util.validIncludedObjectType(includedObjectType,
                        namingAttributes, includedObjectTypes);
                granularityS = includedObjectType.getGranularity().value();
                
                String objectTypeAcronym =
                        includedObjectType.getObjectType().name();
                
                // the managed entity class name to retrieve from the database
                objectTypeClassName = util.managedEntityClassName(objectTypeAcronym);
                managedEntityIsAUnit = util.isUnit(objectTypeClassName);
                objectType = util.createObjectTypeInstance(objectTypeClassName);
                
                
                String request = "SELECT DISTINCT element FROM " + objectTypeClassName  +
                        " element JOIN element.name n WHERE " + baseInstanceS;
                join = " element JOIN element.name n WHERE " + baseInstanceS;
                System.out.println("getInventory:request" +
                        " processed into the database: " + request);
                
                // process the request into the database
                Query queryManagedEntities = em.createQuery(request);
                nbElementsRetrieved = queryManagedEntities.getResultList().size();
                
                if (requestedBatchSize > 0 ) // && managedEntityIsAUnit
                    queryManagedEntities.setMaxResults(nbMaxElementsToRetrieve);
                
                List managedEntitiesReturned = queryManagedEntities.getResultList();
                
                if (nbElementsRetrieved == 0) {
                    // no managed entities retrieved
                    
                    if ( (nbIOTsTreated == includedObjectTypes.size()) &&
                            (nbBIsTreated == baseInstance.size()) )   {
                        // last iot of last base instance
                        header.setBatchSequenceEndOfReply(true);
                        endOfReply = true;
                        
                        if(!createdResponse) {
                            // no response were created for this request
                            ProcessingFailureExceptionT pfe =
                                    new ProcessingFailureExceptionT();
                            String objectMissing =
                                    objectTypeClassName.substring(
                                    0,
                                    objectTypeClassName.length()- 1);
                            pfe.setReason("No " + objectMissing + " in the database. ");
                            throw new ProcessingFailureException("error", pfe);
                        } else
                            break;
                    }
                } else if ((nbElementsRetrieved <= nbMaxElementsToRetrieve)) {
                    // all managed entities for this ejbql request have been retrieved.
                    elementsLeftMap.put(objectTypeClassName, 0);
                    nbMaxElementsToRetrieve =  nbMaxElementsToRetrieve - nbElementsRetrieved;
                } else { // there are still some managed entities to retrieve for this ejbql request
                    elementsLeftMap.put(objectTypeClassName, nbElementsRetrieved - nbMaxElementsToRetrieve);
                    nbMaxElementsToRetrieve = 0;
                }
                
                if (nbElementsRetrieved > 0) {
                    try {
                        // create the response
                        objectType.createResponse(managedEntitiesReturned, granularityS);
                        previousInventoryData = CreateGetInventoryResponse.getResponse();
                        createdResponse = true;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    
                    // add the ids retrieved to the list
                    managedEntitiesAlreadyRetrievedIds.addAll(objectType.getManagedEntitiesIdsRetrieved());
                    int left = ((Integer)elementsLeftMap.get(objectTypeClassName)).intValue();
                    
                    if ( (nbIOTsTreated == includedObjectTypes.size()) &&
                            (nbBIsTreated == baseInstance.size()) &&
                            (left == 0) ) {
                        header.setBatchSequenceEndOfReply(true);
                        endOfReply = true;
                    }
                    
                    // trace for tests purposes
                    System.out.println("nbMaxElementsToRetrieve " + nbMaxElementsToRetrieve);
                    System.out.println("nbElements still to Retrieve for this ejbql request " + elementsLeftMap.get(objectTypeClassName));
                    System.out.println("nbIOTsTreated " + nbIOTsTreated + " includedObjectTypes.size() " + includedObjectTypes.size() );
                    System.out.println("nbBIsTreated " + nbBIsTreated + " baseInstance.size() " + baseInstance.size() );
                    System.out.println("requestedBatchSize: " + requestedBatchSize);
                    System.out.println("endOfReply: " + endOfReply);
                    System.out.println("header.isBatchSequenceEndOfReply: " + header.isBatchSequenceEndOfReply());
                    
                    if ((nbMaxElementsToRetrieve == 0) && (requestedBatchSize > 0) ) {
                        // end of getInventory request
                        getInventoryRequestFinished = true;
                        System.out.println("break");
                        break;
                    }
                }
            } // for iot
        } // for bi
        
        if ( (nbMaxElementsToRetrieve > 0) || (requestedBatchSize == 0) ) {
            header.setBatchSequenceEndOfReply(true);
            endOfReply = true;
        }
        
        mtosiHeader.value = header;
        InventoryDataT inventoryData = previousInventoryData;
        getInventoryResponse.setInventoryData(inventoryData);
        
        System.out.println("*************************** Fin getInventory Call **********************************");
        
        return getInventoryResponse;
    }
    
    /**
     * This function implements the semantic of the getInventoryIterator operation.
     * @param mtosiHeader the header parameters of the getInventoryIterator operation
     * @param mtosiBody the body parameters (filter) of the getInventoryIterator operation
     * @return returns the getInventoryIterator response corresponding to the request
     */
    public v1.tmf854.GetInventoryResponseT getInventoryIterator(
            @WebParam(mode=Mode.INOUT, header=true)  javax.xml.ws.Holder<v1.tmf854.HeaderT> mtosiHeader,
    v1.tmf854.GetInventoryIteratorT mtosiBody) throws ProcessingFailureException {
        
        System.out.println("*************GetInventoryImpl:getInventoryIterator***************** ");
        
        // initialize global variables
        this.createdResponse = false;
        this.endOfReply = false; // ??
        
        // initialize local variables
        int nbElementsRetrieved = 0;
        int nbIOTsTreated = 0;
        int nbBIsTreated = 0;
        boolean getInvItFinished = false;
        boolean newObjectType = true;
        
        // set the header parameters
        HeaderT header = mtosiHeader.value;
        header.setBatchSequenceNumber(new Long(batchSequenceNumber));
        header.setBatchSequenceEndOfReply(false);
        header.setIteratorReferenceURI("12345");
        header.setTimestamp("20051004140305");
        header.setCorrelationId(header.getCorrelationId() + "1");
        batchSequenceNumber++;
        
        // set the body parameters : baseInstance and includedObjectType
        SimpleFilterT simpleFilter = filterBody.getFilter();
        List<NamingAttributesT> baseInstance = simpleFilter.getBaseInstance();
        List<IncludedObjectType> includedObjectTypes = simpleFilter.getIncludedObjectType();
        GetInventoryResponseT getInventoryResponse = new GetInventoryResponseT();
        CreateGetInventoryResponse objectType = new CreateGetInventoryResponse();
        
        Util util = new Util();
        objectType.init();
        
        int requestedBatchSize = header.getRequestedBatchSize().intValue();
        int nbMaxElementsToRetrieve = requestedBatchSize;
        int nbLeftForElement = requestedBatchSize;
        
        if (requestedBatchSize == 0) {
             header.setBatchSequenceEndOfReply(true);
             this.setEndOfReply(true);
        }
            
        // loop through all baseInstances
        for (NamingAttributesT namingAttributes : baseInstance) {
            nbBIsTreated++;
            nbIOTsTreated = 0;
            String newBaseInstanceS = util.createBaseInstanceInRequest(namingAttributes);
            GranularityT granularity = null;
            
            if (getInvItFinished)
                break;
            
            if (!newBaseInstanceS.equals(baseInstanceS))
                elementsLeftMap = new HashMap();
            
            baseInstanceS =  newBaseInstanceS;
            
            for (IncludedObjectType includedObjectType : includedObjectTypes) {
                nbIOTsTreated++;
                granularityS = includedObjectType.getGranularity().value();
                String objectTypeAcronym = includedObjectType.getObjectType().name();
                // the managed entity class name to retrieve from the database
                String newObjectTypeClassName = util.managedEntityClassName(objectTypeAcronym);
                objectTypeClassName =  newObjectTypeClassName;
                
                Integer nbLeftForElementI = (Integer)elementsLeftMap.get(objectTypeClassName);
                nbLeftForElement = requestedBatchSize;
                
                if (nbLeftForElementI != null) {
                    nbLeftForElement = nbLeftForElementI.intValue();
                    newObjectType = false;
                } else
                    newObjectType = true;
                
                if ((nbLeftForElement > 0) || (newObjectType)) {
                    // The ejbql request is not finished
                    objectType = util.createObjectTypeInstance(objectTypeClassName);
                    
                    join = " element JOIN element.name n WHERE " + baseInstanceS;
                    // create the ejbql request
                    String request = this.createGetInventoryIteratorEJBQLRequest();
                    System.out.println("getInventoryIterator:request " + request);
                    // process the request into the database
                    
                    Query queryItManagedEntities = em.createQuery(request);
                    nbElementsRetrieved = queryItManagedEntities.getResultList().size();
                    queryItManagedEntities.setMaxResults(nbMaxElementsToRetrieve);
                    List managedEntitiesReturned = queryItManagedEntities.getResultList();
                    
                    if (nbElementsRetrieved == 0) {
                        // no managed entities retrieved;
                        
                        if ( (nbIOTsTreated == includedObjectTypes.size()) &&
                                (nbBIsTreated == baseInstance.size()) )  {
                            // last iot of last bi
                            header.setBatchSequenceEndOfReply(true);
                            endOfReply = true;
                            
                            if (createdResponse) {
                                // if some elements were retrieved for this getInventoyIterator request
                                // return the created response
                                getInventoryResponse.setInventoryData(CreateGetInventoryResponse.getResponse());
                                
                                return  getInventoryResponse;
                            } else {
                                ProcessingFailureExceptionT pfe =
                                        new ProcessingFailureExceptionT();
                                String objectMissing =
                                        objectTypeClassName.substring(
                                        0,
                                        objectTypeClassName.length()- 1);
                                pfe.setReason("No " + objectMissing + " in the database. ");
                                throw new ProcessingFailureException("error", pfe);
                            }
                        }
                    }
                    
                    if (nbElementsRetrieved > 0) {
                        nbMaxElementsToRetrieve = setNbMaxElementsToRetrieve(
                                nbElementsRetrieved,
                                nbMaxElementsToRetrieve,
                                elementsLeftMap,
                                request);
                        
                        // creates the response
                        objectType = util.createObjectTypeInstance(objectTypeClassName);
                        
                        try {
                            objectType.createResponse(managedEntitiesReturned, granularityS);
                            createdResponse = true;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        
                        // add the ids retrieved to the list
                        managedEntitiesAlreadyRetrievedIds.addAll(objectType.getManagedEntitiesIdsRetrieved());
                        
                        // trace for test purposes
                        System.out.println("nbElements retrieved for this ejbql request " + nbElementsRetrieved);
                        System.out.println("nbElements still To Retrieve for this ejbql request " + elementsLeftMap.get(objectTypeClassName));
                        System.out.println("nbMaxElementsToRetrieve after" + nbMaxElementsToRetrieve);
                        System.out.println(baseInstance.lastIndexOf(namingAttributes) + "--" + (baseInstance.size() - 1));
                        System.out.println(includedObjectTypes.lastIndexOf(includedObjectType) + "--" + (includedObjectTypes.size() - 1));
                        System.out.println("nbIOTsTreated " + nbIOTsTreated );
                        System.out.println("nbBIsTreated " + nbBIsTreated );
                        
                        int left = ((Integer)elementsLeftMap.get(objectTypeClassName)).intValue();
                        
                        if ( (nbIOTsTreated == includedObjectTypes.size()) &&
                                (nbBIsTreated == baseInstance.size()) &&
                                (left == 0) ) {
                            header.setBatchSequenceEndOfReply(true);
                            endOfReply = true;
                        }
                        
                        if (nbMaxElementsToRetrieve == 0) { // end of getInventory request
                            getInvItFinished = true;
                            
                            break;
                        }
                    }
                } // if ejbql not finished
            } // for iot
        } // for bi
        
        if ( (nbMaxElementsToRetrieve > 0) ) {
            header.setBatchSequenceEndOfReply(true);
            endOfReply = true;
        }
        
        // add inventoryData to the final response
        InventoryDataT inventoryData = CreateGetInventoryResponse.getResponse();
        getInventoryResponse.setInventoryData(inventoryData);
        
        System.out.println("*************************** Fin getInventoryIterator Call **********************************");
        
        return getInventoryResponse;
    }
    
    /**
     * Function called by the servlet <i>GetInventoryServlet</i> of the web module.
     * @param baseInstancesMap map which contains the baseInstances values entered in the thin client.
     * @param includedObjectTypesMap map which containts the included object types entered in the thin client.
     * @param requestedBatchsize parameter which specify the number of managed entities to be returned (0 to return
     * all
     */
    public File createThinClientRequest(
            Map baseInstancesMap, Map includedObjectTypesMap,
            Long requestedBatchSize, boolean iteratorRequest) {
            //throws ThinClientException {
        System.out.println("********GetInventoryImpl:createThinClientRequest****** ");
        
        HeaderT header = new HeaderT();
        header.setActivityName("getInventory");
        header.setMsgName("getInventory");
        header.setCorrelationId("0001");
        header.setSenderURI("/MTOSI/InventoryOS");
        header.setDestinationURI("/MTOSI/EMS01");
        header.setCommunicationPattern(CommunicationPatternT.fromValue("MultipleBatchResponse"));
        header.setCommunicationStyle(CommunicationStyleT.RPC);
        header.setTimestamp("20051004140305");
        header.setRequestedBatchSize(requestedBatchSize);
        header.setBatchSequenceEndOfReply(false);
        Holder<HeaderT> mtosiHeader = new Holder<HeaderT>();
        mtosiHeader.value = header;
        
        GetInventoryResponseT resp = new GetInventoryResponseT();
        GetInventoryT mtosiBody = new GetInventoryT();
        SimpleFilterT simpleFilter = new SimpleFilterT();
        NamingAttributesT namingAttrs = new NamingAttributesT();
        List<NamingAttributesT> baseInstance = simpleFilter.getBaseInstance();
        List<IncludedObjectType> includedObjectTypes = simpleFilter.getIncludedObjectType();
        
        // set the web client baseInstance
        namingAttrs.initBIs(baseInstancesMap, baseInstance);
        
        // set the web client includedObjectTypes
        namingAttrs.initIOTs(includedObjectTypesMap, includedObjectTypes);
        
        // set the web client filter
        mtosiBody.setFilter(simpleFilter);
        
        try {
            // call getInventoryIterator or getInventory operations
            if (iteratorRequest) {
                GetInventoryIteratorT mtosiBodyIterator = new GetInventoryIteratorT();
                resp = getInventoryIterator(mtosiHeader , mtosiBodyIterator);
            } else {
                resp = getInventory(mtosiHeader , mtosiBody);
            }
        } catch(ProcessingFailureException p) {
            //ThinClientException ptce = new ThinClientException(p.getFaultInfo().getReason());
            //throw ptce;
            System.out.println("error");
        }
        
        return marshallResponse(resp);
    }
    
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
            File res = new File("response.xml");
            OutputStream os = new FileOutputStream(res);
            marshaller.marshal(getInv, os );
            
            return res;
            
        }   catch(IOException e){
            e.printStackTrace();
        } catch( JAXBException je ) {
            je.printStackTrace();
        } catch(NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void persist(Object object) {
        // TODO:
        // em.persist(object);
    }
    
    public boolean endOfReply() {
        
        return endOfReply;
    }
    
    private boolean notSpecified(String s) {
        
        return (s == null || s.equals(""));
    }
    
    private HeaderT setHeaderParameters(HeaderT header) {
        // set the header parameters
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
        
        return header;
    }
    
    /*
     * Creates the request which will be processed into the database
     * Only managed entities which are not in managedEntitiesAlreadyRetrievedIds
     * are to be retrieved
     * @return the getInventoryIterator ejbql string query
     */
    private String createGetInventoryIteratorEJBQLRequest() {
        System.out.println("********createGetInventoryIteratorEJBQLREsuqyest***********");
        
        StringBuilder sb =
                new StringBuilder("SELECT DISTINCT element FROM " +
                objectTypeClassName + join + "  AND element.id NOT IN (");
        String separator = "";
        
        for (Long id : managedEntitiesAlreadyRetrievedIds) {
            sb.append(separator);
            sb.append(id.longValue());
            separator = ", ";
        }
        sb.append(")");
        
        String ejbql = sb.toString();
        
        return ejbql;
    }
    
    private void setEndOfReply(boolean endOfReply) {
        this.endOfReply = endOfReply;
    }

    private int setNbMaxElementsToRetrieve(
            int nbElementsRetrieved,
            int nbMaxElementsToRetrieve,
            Map elementsLefMap, String request) {
        
        if ((nbElementsRetrieved <= nbMaxElementsToRetrieve)) {
            // all managed entities for this ejbql request have been retrieved.
            elementsLeftMap.put(objectTypeClassName, 0);
            nbMaxElementsToRetrieve =  nbMaxElementsToRetrieve - nbElementsRetrieved;
        }
        
        else {
            elementsLeftMap.put(objectTypeClassName, nbElementsRetrieved - nbMaxElementsToRetrieve);
            nbMaxElementsToRetrieve = 0;
        }
        
        return nbMaxElementsToRetrieve;
    }
}
