/*
 * Client.java
 *
 * Created on 24 juin 2007, 19:23
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mtopsimulatorappclient;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Marshaller;
import javax.xml.ws.*;
import java.io.FileInputStream;
import java.io.File;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import javax.xml.namespace.QName;
import util.Stylizer;

import v1.tmf854.*;
import ws.v1.tmf854.*;

/**
 * This is the getInventory and getInventoryIterator operations of the
 * GUI and send the request to the web service endpoint
 */
public class ApplicationClient {
    
    private Holder<HeaderT> mtosiHeader = new Holder<HeaderT>();
    private InventoryRetrievalService service = new InventoryRetrievalService();
    private InventoryRetrieval  port = service.getInventoryRetrievalHttp();
    private File responseXml = new File("response\\getInventory-response.xml");
    private File responseHtml = new File("response\\table.html");
    private File styleSheet = new File("styleSheet.xsl");
    private Long requestedBatchSize;
    private boolean lastRequest = false;
    
    public ApplicationClient() {
    }
    
    /**
     * Create the getInventory operation from the values entered in the GUI and
     * call the web service.  
     */
    public void sendGetInventory(Map baseInstancesMap, int nbBaseInstances,
            Map includedObjectTypesMap, int nbIncludedObjectTypes,
            Long requestedBatchSize) throws ProcessingFailureException {
           
        // Specify the header parameters of the request
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
        mtosiHeader.value = header;
      
        // Specify the body parameters of the request
        GetInventoryT mtosiBody = new GetInventoryT();
        SimpleFilterT simpleFilter = new SimpleFilterT();
        java.util.List<NamingAttributesT> baseInstance = simpleFilter.getBaseInstance();
       
        for (int i = 0; i < nbBaseInstances; i++) {
            NamingAttributesT namingAttrs1 = new NamingAttributesT();
        
            if (!notSpecified(baseInstancesMap.get("baseInstanceType"+i+"1"))) {
                // at least 1 BI type specified
               
                namingAttrs1.setMdNm(
                        (String)baseInstancesMap.get("baseInstanceValue"+i+"1"));
              
                if (baseInstancesMap.get("baseInstanceType"+i+"2") != null) {
                    // at least 2 BI types specified
                
                    if (((String)baseInstancesMap.get("baseInstanceType"+i+"2")).equals("ME")) {
                        namingAttrs1.setMeNm(
                                (String)baseInstancesMap.get("baseInstanceValue"+i+"2"));
                        // at least 3 BI types specified
                    
                        if (baseInstancesMap.get("baseInstanceType"+i+"3") != null) {
                        
                            if (((String)baseInstancesMap.get("baseInstanceType"+i+"3")).equals("EH")) {
                                namingAttrs1.setEhNm(
                                        (String)baseInstancesMap.get("baseInstanceValue"+i+"3"));
                            
                                if (baseInstancesMap.get("baseInstanceType"+i+"4") != null) {
                                
                                    if (((String)baseInstancesMap.get("baseInstanceType"+i+"4")).equals("EQ")) {
                                        namingAttrs1.setEqNm(
                                                (String)baseInstancesMap.get("baseInstanceValue"+i+"4"));
                                    }
                                }
                            } else if (((String)baseInstancesMap.get("baseInstanceType"+i+"3")).equals("PTP")) {
                                namingAttrs1.setPtpNm(
                                        (String)baseInstancesMap.get("baseInstanceValue"+i+"3"));
                                
                                if (baseInstancesMap.get("baseInstanceType"+i+"4") != null) {
                                
                                    if (((String)baseInstancesMap.get("baseInstanceType"+i+"4")).equals("CTP")) {
                                        namingAttrs1.setCtpNm(
                                                (String)baseInstancesMap.get("baseInstanceValue"+i+"4"));
                                    }
                                }
                            } else if (((String)baseInstancesMap.get("baseInstanceType"+i+"3")).equals("FTP")) {
                                namingAttrs1.setFtpNm((String)baseInstancesMap.get("baseInstanceValue"+i+"3"));
                                
                                if (baseInstancesMap.get("baseInstanceType"+i+"4") != null) {
                                
                                    if (((String)baseInstancesMap.get("baseInstanceType"+i+"4")).equals("CTP")) {
                                        namingAttrs1.setCtpNm(
                                                (String)baseInstancesMap.get("baseInstanceValue"+i+"4"));
                                    }
                                }
                            }
                        }
                    } else if (((String)baseInstancesMap.get("baseInstanceType"+i+"2")).equals("MLSN")){
                        namingAttrs1.setMlsnNm((String)baseInstancesMap.get("baseInstanceValue"+i+"2"));
                        
                        if (baseInstancesMap.get("baseInstanceType"+i+"3") != null) {
                        
                            if (((String)baseInstancesMap.get("baseInstanceType"+i+"3")).equals("SNC")) {
                                namingAttrs1.setSncNm(
                                        (String)baseInstancesMap.get("baseInstanceValue"+i+"3"));
                            } else if (((String)baseInstancesMap.get("baseInstanceType"+i+"3")).equals("TPPool")) {
                                namingAttrs1.setTppoolNm(
                                        (String)baseInstancesMap.get("baseInstanceValue"+i+"3"));
                            } else if (((String)baseInstancesMap.get("baseInstanceType"+i+"3")).equals("TL")) {
                                namingAttrs1.setTlNm(
                                        (String)baseInstancesMap.get("baseInstanceValue"+i+"3"));
                            }
                        }
                        // still AssocMe
                    } else if (((String)baseInstancesMap.get("baseInstanceType"+i+"2")).equals("TL")){
                        namingAttrs1.setTlNm(
                                (String)baseInstancesMap.get("baseInstanceValue"+i+"2"));
                    }
                }
                baseInstance.add(namingAttrs1);
            }
        }// end for bi

        List<SimpleFilterT.IncludedObjectType> includedObjectTypes = simpleFilter.getIncludedObjectType();
        
        for (int i = 0; i < nbIncludedObjectTypes; i++) {
            SimpleFilterT.IncludedObjectType includedObjectType = new SimpleFilterT.IncludedObjectType();
           
            if (!notSpecified(includedObjectTypesMap.get("objectAcronym"+i)) &&
                    !notSpecified(includedObjectTypesMap.get("granularity"+i))) {
                   
                // set the objectAcronym
               if (((String)includedObjectTypesMap.get("objectAcronym"+i)).equals("MD")) {
                    includedObjectType.setObjectType(ObjectAcronymT.MD);
                } else if (((String)includedObjectTypesMap.get("objectAcronym"+i)).equals("ME")) {
                    includedObjectType.setObjectType(ObjectAcronymT.ME);
                } else if  (((String)includedObjectTypesMap.get("objectAcronym"+i)).equals("MLSN")) {
                    includedObjectType.setObjectType(ObjectAcronymT.MLSN);
                } else if  (((String)includedObjectTypesMap.get("objectAcronym"+i)).equals("TL")) {
                    includedObjectType.setObjectType(ObjectAcronymT.TL);
                } else if  (((String)includedObjectTypesMap.get("objectAcronym"+i)).equals("EH")) {
                    includedObjectType.setObjectType(ObjectAcronymT.EH);
                } else if  (((String)includedObjectTypesMap.get("objectAcronym"+i)).equals("PTP")) {
                    includedObjectType.setObjectType(ObjectAcronymT.PTP);
                } else if  (((String)includedObjectTypesMap.get("objectAcronym"+i)).equals("FTP")) {
                    includedObjectType.setObjectType(ObjectAcronymT.FTP);
                } else if  (((String)includedObjectTypesMap.get("objectAcronym"+i)).equals("PGP")) {
                    includedObjectType.setObjectType(ObjectAcronymT.PGP);
                } else if  (((String)includedObjectTypesMap.get("objectAcronym"+i)).equals("EPGP")) {
                    includedObjectType.setObjectType(ObjectAcronymT.EPGP);
                }  else if  (((String)includedObjectTypesMap.get("objectAcronym"+i)).equals("CTP")) {
                    includedObjectType.setObjectType(ObjectAcronymT.CTP);
                } else if  (((String)includedObjectTypesMap.get("objectAcronym"+i)).equals("EQ")) {
                    includedObjectType.setObjectType(ObjectAcronymT.EQ);
                } else if  (((String)includedObjectTypesMap.get("objectAcronym"+i)).equals("SNC")) {
                    includedObjectType.setObjectType(ObjectAcronymT.SNC);
                } else if  (((String)includedObjectTypesMap.get("objectAcronym"+i)).equals("TPPool")) {
                    includedObjectType.setObjectType(ObjectAcronymT.TP_POOL);
                }
                
                // set the granularity
                if (((String)includedObjectTypesMap.get("granularity"+i)).equals("NAME")) {
                    includedObjectType.setGranularity(GranularityT.NAME);
                } else  if (((String)includedObjectTypesMap.get("granularity"+i)).equals("ATTRS")) {
                    includedObjectType.setGranularity(GranularityT.ATTRS);
                } else if (((String)includedObjectTypesMap.get("granularity"+i)).equals("FULL")) {
                    includedObjectType.setGranularity(GranularityT.FULL);
                } 
            } else if (notSpecified(includedObjectTypesMap.get("objectAcronym"+i)))  {
                includedObjectType.setGranularity(GranularityT.NAME);
            } else if (notSpecified(includedObjectTypesMap.get("granularity"+i)))  {
                includedObjectType.setObjectType(ObjectAcronymT.ME);
            }
            
            includedObjectTypes.add(includedObjectType);
        }// end for iot
       
        mtosiBody.setFilter(simpleFilter);
        service = new InventoryRetrievalService();
        port = service.getInventoryRetrievalHttp();
        
        // CALL GETINVENTORY WEB SERVICE 
        GetInventoryResponseT getInventoryResponse = 
                port.getInventory(mtosiHeader, mtosiBody);
       
        if (mtosiHeader.value.getRequestedBatchSize() != 0)
            setLastRequest(mtosiHeader.value.isBatchSequenceEndOfReply());
        
        // marshall the response into a xml file
        File responseFile = marshallResponse(getInventoryResponse);
    }
    
     /**
     * Create the getInventoryIteration operation from the values entered in the
     * GUI and call the web service.   
     */
    public void sendGetInventoryIterator(Long requestedBatchSize)  throws ProcessingFailureException {
        mtosiHeader.value.setBatchSequenceNumber(new Long(2));
        mtosiHeader.value.setRequestedBatchSize(requestedBatchSize);
        GetInventoryIteratorT mtosiBodyIterator = new GetInventoryIteratorT();
        
        // CALL GETINVENTORYITERATOR WEB SERVICE
        GetInventoryResponseT getInventoryResponse = 
                port.getInventoryIterator(mtosiHeader, mtosiBodyIterator);
        
        setLastRequest(mtosiHeader.value.isBatchSequenceEndOfReply());
        
        // marshall the response into a xml file
        File responseFile = marshallResponse(getInventoryResponse);
        
    }
    
    /**
     * Marshall the getInventory response into a xml file
     */
    public File marshallResponse(GetInventoryResponseT getInventoryResponse) {
        try {
            InventoryDataT inv = getInventoryResponse.getInventoryData();
            JAXBContext jc = JAXBContext.newInstance("v1.tmf854");
            GetInventoryResponseT getInv = new GetInventoryResponseT();
            getInv.setInventoryData(inv);
            Marshaller marshaller= jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            OutputStream os = new FileOutputStream(getResponseXml());
            
            // marshall the response into the xml file
            marshaller.marshal(getInv, os );
            
            // creates the html response file
            Stylizer stylizer = new Stylizer();
            stylizer.transform(getStyleSheet(), getResponseXml(), getResponseHtml());
            
            return getResponseXml();
            
        } catch(IOException e){
            e.printStackTrace();
        } catch( JAXBException je ) {
            je.printStackTrace();
        } catch(NullPointerException e) {
            System.err.println("Element Object Type is not in the database");
        }
        
        return null;
    }
    
    public boolean notSpecified(Object o) {

        return (o == null || o.toString().equals(""));
    }
    
    public File getResponseXml() {
        return responseXml;
    }
    
    public File getResponseHtml() {
        return responseHtml;
    }
    
    public File getStyleSheet() {
        return styleSheet;
    }
    
    public boolean isLastRequest() {
        return lastRequest;
    }
    
    public void setLastRequest(boolean lastRequest) {
        this.lastRequest = lastRequest;
    }
    
}
