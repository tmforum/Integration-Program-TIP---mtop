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

//import org.tmforum.mtop.simulator.entity.managedinventories.*;
//import org.tmforum.mtop.simulator.entity.managedinventories.MDInventoryT.MeList;
//import org.tmforum.mtop.simulator.entity.managedinventories.MEInventoryT.EhList;


/**
 *
 * @author baptiste
 */
public class CreateGetInventoryResponse {

    protected InventoryDataT inventoryData = new InventoryDataT();
    private static MdList mdList;

    protected static int a = 0;
   // protected  List<MDInventoryT> mdInvs = mdList.getMd();

    /**
     * Creates a new instance of CreateGetInventoryResponse
     */
    public CreateGetInventoryResponse() {
       // inventoryData = new InventoryDataT();
      // mdList = new MdList();
        //mdInvs = mdList.getMd();
    }
     
    public void init() {
        mdList = new MdList();
    }
    
    public InventoryDataT createResponse(List<?> objs, String granularity) {
       System.out.println("****CreateGetInventoryResponse*******");
       inventoryData.setMdList(getMdList());
        
        return new InventoryDataT();
    }
    
    public void refreshMdList(MdList mdList) {
         inventoryData.setMdList(mdList);
    }
    
    
    public InventoryDataT getInventoryData() {
        return inventoryData;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public static MdList getMdList() {
        return mdList;
    }

    public static void setMdList(MdList aMdList) {
        mdList = aMdList;
    }

}
