/*
 * CreateManagementDomainResponse.java
 *
 * Created on 7 mai 2007, 23:25
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
public class CreateManagementDomainResponse extends CreateResponse {
    
    // protected List<MDInventoryT> mdInvs = mdList.getMd();
    /** Creates a new instance of CreateManagementDomainResponse */
    public CreateManagementDomainResponse() {
    }
    
    public InventoryDataT createResponse2(List<?> objs, String granularity) {
        System.out.println(" CreateManagementDomainResponse:createResponse");
        //InventoryDataT inventoryData = new InventoryDataT();
        // MdList mdList = new MdList();
        List<MDInventoryT> mdInvs = getMdList().getMd(); // new mdInv List
        MDInventoryT mdInv = new MDInventoryT();
        String mdNm1 = "";
        System.out.println("MD!!!!!!!!!!!!!!!!!!!!!!!!!");
        //ListIterator<MDInventoryT> litMd = mdInvs.listIterator();
        boolean newNode = false;
        
       ManagementDomainT  firstManagementDomain = (ManagementDomainT) objs.get(0);
       System.out.println("CreateManagementDomain: mdList.size " + getMdList().getMd().size());
        
        if (getMdList().getMd().size() == 0) {
            MDInventoryT firstMdInv = new MDInventoryT();
          firstMdInv.setMdNm(firstManagementDomain.getName().getMdNm());
            getMdList().getMd().add(firstMdInv);
        }
        
        for (Object o : objs) {
            ManagementDomainT md =  (ManagementDomainT) o;
            mdInv = new MDInventoryT();
            mdNm1 = md.getName().getMdNm();
            md.setName(null);
            md.setId(null);
            mdInv.setMdNm(mdNm1);
            if (granularity.equals("ATTRS"))
                mdInv.setMdAttrs(md);
            else if (granularity.equals("FULL")) {
                mdInv.setMdAttrs(md);
                SupportingOSNameList mdFull = md.getMdInventoryT().getSupportingOSNameList();
                mdInv.setSupportingOSNameList(mdFull);
            }
            mdInvs.add(mdInv);
        }
        inventoryData.setMdList(getMdList());
        
        return inventoryData;
    }
    /*
    public int levelInNamingTree() {
        return 0;
    }
     
    public void addChildList(CreateResponse c) {
        for (MDInventoryT mdInv0 : mdList.getMd()) {
            for(MDInventoryT mdInv1 : c.getInventoryData().getMdList().getMd()) {
                if (mdInv0.getMdNm().equals(mdInv1.getMdNm())) {
                    mdInv0.setMeList(mdInv1.getMeList());
                    break;
                }
            }
        }
    }
     */
    public InventoryDataT getInventoryData() {
        return inventoryData;
    }
}

