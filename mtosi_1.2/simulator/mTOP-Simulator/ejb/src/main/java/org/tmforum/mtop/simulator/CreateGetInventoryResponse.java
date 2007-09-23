/*
 * CreateGetInventoryResponse.java
 *
 * Created on 7 mai 2007, 22:58
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.tmforum.mtop.simulator;

import java.util.*;

import v1.tmf854.*;
import v1.tmf854.InventoryDataT.MdList;
import v1.tmf854.SimpleFilterT.IncludedObjectType;
import v1.tmf854.InventoryDataT;

/**
 * CreateGetInventoryResponse allows the creation of the getInventory and getInventory
 * iterator response. To create the response for a specific managed entity
 * one must extend this class.
 * 
 */
public class CreateGetInventoryResponse {
    
    protected  InventoryDataT inventoryData = new InventoryDataT();
    protected  static InventoryDataT response = new InventoryDataT(); 
    private static MdList mdList;
    protected List<Long> managedEntitiesIdsRetrieved = new ArrayList();
   
    public CreateGetInventoryResponse() {
    }
     
    public void init() {
        mdList = new MdList();
    }
    
    public InventoryDataT createResponse(List<?> objs, String granularity) {
       inventoryData.setMdList(getMdList());
        
        return new InventoryDataT();
    }
    
    public static InventoryDataT getResponse() {
        response.setMdList(mdList);
        
        return response;
    }
    
    public static void setResponse(InventoryDataT inv) {
       response = inv;
    }
    
    public void refreshMdList(MdList mdList) {
         inventoryData.setMdList(mdList);
    }
    

    public static MdList getMdList() {
        
        return mdList;
    }
    
    public static void setMdList(MdList aMdList) {
        mdList = aMdList;
    }

    public List<Long> getManagedEntitiesIdsRetrieved() {
        
        return managedEntitiesIdsRetrieved;
    }

    public void setManagedEntitiesIdsRetrieved(List<Long> managedEntitiesIdsRetrieved) {
        
        this.managedEntitiesIdsRetrieved = managedEntitiesIdsRetrieved;
    }
}
