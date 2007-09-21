/*
 * CreateTransmissionDescriptorResponse.java
 *
 * Created on 7 mai 2007, 23:25
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.tmforum.mtop.simulator;

import java.util.*;

import v1.tmf854.*;
import v1.tmf854.InventoryDataT.MdList;
import v1.tmf854.SimpleFilterT.IncludedObjectType;
import v1.tmf854.TMDInventoryT;

/**
 * Class which creates the response for TransmissionDescriptor managed
 * entities.
 */
public class CreateTransmissionDescriptorResponse extends CreateGetInventoryResponse {
    
    public InventoryDataT createResponse(List<?> objs, String granularity) {

        return null;
    }
    
    public InventoryDataT getInventoryData() {
        return inventoryData;
    }
}


