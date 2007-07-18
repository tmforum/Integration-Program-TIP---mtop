
package org.tmforum.mtop.simulator.session;

import javax.ejb.Local;
import v1.tmf854.*;
import ws.v1.tmf854.ProcessingFailureException;
import java.util.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.*;

//import org.tmforum.mtop.simulator.exception.ProcessingFailureException;

/**
 * This is the business interface for InventoryRetrieval enterprise bean.
 */
@Local
public interface GetInventory {
    
    public v1.tmf854.GetInventoryResponseT getInventory(
            @WebParam(mode=Mode.INOUT, header=true) javax.xml.ws.Holder<v1.tmf854.HeaderT> mtosiHeader,
    v1.tmf854.GetInventoryT mtosiBody) throws ProcessingFailureException;
    
    public v1.tmf854.GetInventoryResponseT getInventoryIterator(
            @WebParam(mode=Mode.INOUT, header=true)  javax.xml.ws.Holder<v1.tmf854.HeaderT> mtosiHeader,
    v1.tmf854.GetInventoryIteratorT mtosiBody) throws ProcessingFailureException;
    
    java.io.File createGetInventoryRequest(Map baseInstances, Map includedObjectTypes);
    
    //  java.io.File marshallResponse(GetInventoryResponseT getInventoryResponse);
}
