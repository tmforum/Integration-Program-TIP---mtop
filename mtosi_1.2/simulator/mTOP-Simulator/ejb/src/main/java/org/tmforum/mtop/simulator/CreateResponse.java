/*
 * CreateResponse.java
 *
 * Created on 7 mai 2007, 22:58
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.tmforum.mtop.simulator;

import v1.tmf854.*;
import v1.tmf854.InventoryDataT.MdList;
import v1.tmf854.MDInventoryT.MeList;
import v1.tmf854.MEInventoryT.EhList;
import v1.tmf854.SimpleFilterT.IncludedObjectType;
import java.io.*;
import java.util.*;

/**
 *
 * @author baptiste
 */
public class CreateResponse {
    
    protected InventoryDataT inventoryData = new InventoryDataT();
    private static MdList mdList;
    
    protected static int a = 0;
   // protected  List<MDInventoryT> mdInvs = mdList.getMd();
    
    /** Creates a new instance of CreateResponse */
    public CreateResponse() {
       // inventoryData = new InventoryDataT();
      // mdList = new MdList();
        //mdInvs = mdList.getMd();
    }
     
    public void init() {
        mdList = new MdList();
    }
    
    public InventoryDataT createResponse2(List<?> objs, String granularity) {
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
