
package org.tmforum.mtop.simulator;

import javax.ejb.Local;
import v1.tmf854.*;
import java.util.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.*;
/**
 * This is the business interface for GetInventory enterprise bean.
 */
@Local
//@WebService
public interface GetInventory {//extends java.rmi.Remote{
    //@WebMethod
    public v1.tmf854.GetInventoryResponseT getInventory(
            @WebParam(mode=Mode.INOUT, header=true) javax.xml.ws.Holder<v1.tmf854.HeaderT> mtosiHeader,
             v1.tmf854.GetInventoryT mtosiBody) throws ws.v1.tmf854.ProcessingFailureException;
    
    public v1.tmf854.GetInventoryResponseT getInventoryIterator(
            @WebParam(mode=Mode.INOUT, header=true)  javax.xml.ws.Holder<v1.tmf854.HeaderT> mtosiHeader,
    v1.tmf854.GetInventoryIteratorT mtosiBody) throws ws.v1.tmf854.ProcessingFailureException;
    
    java.io.File createGetInventoryRequest(Map baseInstances, Map includedObjectTypes);

    // java.io.File marshallResponse(GetInventoryResponseT getInventoryResponse);
}
