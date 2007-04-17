
package org.tmforum.mtop.simulator;

import javax.ejb.Local;
import v1.tmf854.*;

/**
 * This is the business interface for GetInventory enterprise bean.
 */
@Local
public interface GetInventory {
    v1.tmf854.GetInventoryResponseT getInventory(GetInventoryT mtosiBody);
    
    java.io.File createGetInventoryRequest(String bi, String iot, String gran);
    
     java.io.File marshallResponse(GetInventoryResponseT getInventoryResponse);
}
