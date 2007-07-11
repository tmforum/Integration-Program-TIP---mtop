package org.tmforum.mtop.simulator;

import javax.ejb.*;
import javax.jws.WebService;
import javax.jws.soap.*;
import javax.jws.soap.SOAPBinding.*;
import javax.jws.WebParam.*;
import javax.jws.WebParam;
import javax.jws.WebMethod;
/**
 * This is the bean class for the GetInvWS enterprise bean.
 * Created 18 juin 2007 16:07:18
 * @author baptiste
 */
@Stateless
@WebService(name="InventoryRetrieval",  targetNamespace="tmf854.v1.ws", serviceName="InventoryRetrievalService", portName="InventoryRetrievalHttp")
@SOAPBinding(style=Style.RPC, use=Use.LITERAL)
public class GetInvWSBean {
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
    @EJB
    private GetInventory getInventory;
    
    @WebMethod
    public v1.tmf854.GetInventoryResponseT getInventory(
            @WebParam(mode=Mode.INOUT, header=true) javax.xml.ws.Holder<v1.tmf854.HeaderT> mtosiHeader,
    v1.tmf854.GetInventoryT mtosiBody) throws ws.v1.tmf854.ProcessingFailureException {
        
        return  getInventory.getInventory(mtosiHeader, mtosiBody);
    }
    
    @WebMethod
    public v1.tmf854.GetInventoryResponseT getInventoryIterator(
            @WebParam(mode=Mode.INOUT, header=true) javax.xml.ws.Holder<v1.tmf854.HeaderT> mtosiHeader,
    v1.tmf854.GetInventoryIteratorT mtosiBody) throws ws.v1.tmf854.ProcessingFailureException {
        
        return getInventory.getInventoryIterator(mtosiHeader, mtosiBody);
    }
}
