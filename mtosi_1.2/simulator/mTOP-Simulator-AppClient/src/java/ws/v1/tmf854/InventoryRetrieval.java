
package ws.v1.tmf854;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Holder;
import v1.tmf854.GetInventoryIteratorT;
import v1.tmf854.GetInventoryResponseT;
import v1.tmf854.GetInventoryT;
import v1.tmf854.HeaderT;


/**
 * This class was generated by the JAXWS SI.
 * JAX-WS RI 2.0_03-b24-fcs
 * Generated source version: 2.0
 * 
 */
@WebService(name = "InventoryRetrieval", targetNamespace = "tmf854.v1.ws")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface InventoryRetrieval {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns v1.tmf854.GetInventoryResponseT
     * @throws ProcessingFailureException
     */
    @WebMethod
    @WebResult(partName = "return")
    public GetInventoryResponseT getInventory(
        @WebParam(name = "arg0", targetNamespace = "tmf854.v1.ws", header = true, mode = WebParam.Mode.INOUT, partName = "arg0")
        Holder<HeaderT> arg0,
        @WebParam(name = "arg1", partName = "arg1")
        GetInventoryT arg1)
        throws ProcessingFailureException
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns v1.tmf854.GetInventoryResponseT
     * @throws ProcessingFailureException
     */
    @WebMethod
    @WebResult(partName = "return")
    public GetInventoryResponseT getInventoryIterator(
        @WebParam(name = "arg0", targetNamespace = "tmf854.v1.ws", header = true, mode = WebParam.Mode.INOUT, partName = "arg0")
        Holder<HeaderT> arg0,
        @WebParam(name = "arg1", partName = "arg1")
        GetInventoryIteratorT arg1)
        throws ProcessingFailureException
    ;

}
