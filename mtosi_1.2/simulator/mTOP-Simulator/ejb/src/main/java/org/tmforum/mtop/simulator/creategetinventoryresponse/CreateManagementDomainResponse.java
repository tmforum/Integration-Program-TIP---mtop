/*
 * CreateManagementDomainResponse.java
 *
 * Created on 7 mai 2007, 23:25
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.tmforum.mtop.simulator.creategetinventoryresponse;

import java.util.*;

import v1.tmf854.*;
import v1.tmf854.InventoryDataT.MdList;
import v1.tmf854.SimpleFilterT.IncludedObjectType;
import v1.tmf854.MDInventoryT.MeList;
import v1.tmf854.MEInventoryT.EhList;
//import org.tmforum.mtop.simulator.entity.managedinventories.*;
//import org.tmforum.mtop.simulator.entity.managedinventories.MDInventoryT.MeList;
//import org.tmforum.mtop.simulator.entity.managedinventories.MEInventoryT.EhList;
//import org.tmforum.mtop.simulator.entity.managedentities.*;

/**
 *
 * @author baptiste
 */
public class CreateManagementDomainResponse extends CreateGetInventoryResponse {
    // protected List<MDInventoryT> mdInvs = mdList.getMd();
    /** Creates a new instance of CreateManagementDomainResponse */
    public CreateManagementDomainResponse() {
    }
    
    public InventoryDataT createResponse(List<?> objs, String granularity) {
        System.out.println(" CreateManagementDomainResponse:createResponse");
        List<MDInventoryT> mdInvs = getMdList().getMd(); // new mdInv List
        MDInventoryT mdInv = new MDInventoryT();
        String mdNm1 = "";
        //boolean newNode = false;
        boolean firstMd = false; 
        
        ManagementDomainT  firstManagementDomain = (ManagementDomainT) objs.get(0);
        System.out.println("CreateManagementDomain: mdList.size " + getMdList().getMd().size());
        
        /*
        if (getMdList().getMd().size() == 0) {
            firstMd = true;
            MDInventoryT firstMdInv = new MDInventoryT();
            System.out.println("firstManagementDomain.getName().getMdNm(): " + firstManagementDomain.getName().getMdNm());
            // the first mdInv has the same name as the first md
            firstMdInv.setMdNm(firstManagementDomain.getName().getMdNm());
            getMdList().getMd().add(firstMdInv);
        }*/
        
        for (Object o : objs) {
            ManagementDomainT md =  (ManagementDomainT) o;
            mdInv = new MDInventoryT();
            mdNm1 = md.getName().getMdNm();
            md.setName(null);
            md.setId(null);
            //md.setMdInventoryT(null);
            mdInv.setMdNm(mdNm1);
          
            if (granularity.equals("ATTRS")) {
                md.setMdInventoryT(null);
                mdInv.setMdAttrs(md);
            }
            else if (granularity.equals("FULL")) {
                mdInv.setMdAttrs(md);
                SupportingOSNameList mdFull = md.getMdInventoryT().getSupportingOSNameList();
                md.setMdInventoryT(null);
             //   mdInv.setMdAttrs(md);
                //System.out.println("mdFull.getSupportingOSNames().size() " + mdFull.getSupportingOSNames());
                   for (SupportingOSName son : mdFull.getSupportingOSNames()) {
                    System.out.println("setNull");
                    son.setId(null);
                }
                    mdInv.getMdAttrs().setMdInventoryT(null);
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
     
    public void addChildList(CreateGetInventoryResponse c) {
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

