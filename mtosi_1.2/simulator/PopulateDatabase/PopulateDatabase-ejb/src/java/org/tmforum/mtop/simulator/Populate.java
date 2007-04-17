
package org.tmforum.mtop.simulator;

import javax.ejb.Local;
import v1.tmf854.*;

/**
 * This is the business interface for GetInventory enterprise bean.
 */
@Local
public interface Populate {
    
    void populateDatabase(GetInventoryResponseT getInventoryResponse);
    
    void  unmarshallXmlExample(String path);
    
}
