package org.tmforum.mtop.simulator;

import javax.ejb.*;
import javax.jws.WebService;
import javax.jws.soap.*;
import javax.jws.soap.SOAPBinding.*;
import javax.jws.WebParam.*;
import javax.jws.WebParam;
import javax.jws.WebMethod;
import org.tmforum.mtop.simulator.ProcessingFailureException;


/**
 * GetInventoryWS is the web service which is consumed by remote clients.
 * It exposes two operations: <i>getInventory</i> and <i>getInventoryIterator</i>.
 */
@Stateless
@WebService(name="InventoryRetrieval",  targetNamespace="tmf854.v1.ws", serviceName="InventoryRetrievalService", portName="InventoryRetrievalHttp")
@SOAPBinding(style=Style.RPC, use=Use.LITERAL)
public class GetInvWSBean {
    
    @EJB
    private GetInventory getInventory;
    
    @WebMethod
    public v1.tmf854.GetInventoryResponseT getInventory(
            @WebParam(mode=Mode.INOUT, header=true) javax.xml.ws.Holder<v1.tmf854.HeaderT> mtosiHeader,
    v1.tmf854.GetInventoryT mtosiBody) throws ProcessingFailureException {
        
        return  getInventory.getInventory(mtosiHeader, mtosiBody);
    }
    
    @WebMethod
    public v1.tmf854.GetInventoryResponseT getInventoryIterator(
            @WebParam(mode=Mode.INOUT, header=true) javax.xml.ws.Holder<v1.tmf854.HeaderT> mtosiHeader,
    v1.tmf854.GetInventoryIteratorT mtosiBody) throws ProcessingFailureException {
        
        return getInventory.getInventoryIterator(mtosiHeader, mtosiBody);
    }
}
