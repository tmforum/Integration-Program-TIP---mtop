
package org.tmforum.mtop.populatedatabase;

import javax.ejb.Local;
import v1.tmf854.*;

/**
 * This is the business interface for GetInventory enterprise bean.
 */
@Local
public interface Populate {
    
    boolean populateDatabase(GetInventoryResponseT getInventoryResponse);
    
    boolean  unmarshallXmlExample(String path);
    
}
