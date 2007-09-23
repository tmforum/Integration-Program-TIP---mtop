
package org.tmforum.mtop.populatedatabase;

import javax.ejb.Local;
import v1.tmf854.*;

/**
 * Interface for GetInventory enterprise bean.
 */
@Local
public interface Populate {
    
    boolean populateDatabase(GetInventoryResponseT getInventoryResponse);
    
    boolean  unmarshallXmlExample(String path, boolean deletePrevRecords);
    
     public void deleteDB();

    void persist(Object object);
    
    
    
}
