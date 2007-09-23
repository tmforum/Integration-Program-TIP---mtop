
package org.tmforum.mtop.simulator;

import javax.ejb.Local;
import org.tmforum.mtop.simulator.ThinClientException;
import v1.tmf854.*;
import org.tmforum.mtop.simulator.ProcessingFailureException;
import java.util.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.*;
import java.io.File;

/**
 * Interface of GetInventoryBean.
 */
@Local
public interface GetInventory {
    
    public v1.tmf854.GetInventoryResponseT getInventory(
            @WebParam(mode=Mode.INOUT, header=true) 
            javax.xml.ws.Holder<v1.tmf854.HeaderT> mtosiHeader,
    v1.tmf854.GetInventoryT mtosiBody) throws ProcessingFailureException;
    
    public v1.tmf854.GetInventoryResponseT getInventoryIterator(
            @WebParam(mode=Mode.INOUT, header=true)
            javax.xml.ws.Holder<v1.tmf854.HeaderT> mtosiHeader,
    v1.tmf854.GetInventoryIteratorT mtosiBody) throws ProcessingFailureException;
    
    public File createThinClientRequest(
            Map baseInstances, Map includedObjectTypes,
            Long requestedBatchSize, boolean iteratorRequest)
    throws ThinClientException;

    public boolean endOfReply();

}
