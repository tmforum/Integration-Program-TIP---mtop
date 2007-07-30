/*
 * CreateManagementDomainResponse.java
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
        String mdNm1 = "";
        //boolean firstMd = false;
        ManagementDomainT  firstManagementDomain = (ManagementDomainT) objs.get(0);
        System.out.println("CreateManagementDomain: mdList.size " + getMdList().getMd().size());
        System.out.println("firstManagementDomain.getName(): " + firstManagementDomain.getDiscoveredName());
    
        
        for (Object o : objs) {
            ManagementDomainT mdRetrieved =(ManagementDomainT) o;
            ManagementDomainT md = (ManagementDomainT) mdRetrieved.copyManagedEntity();
            System.out.println("---------------------md.getMdInventory " + md.getMdInventoryT());
            md.setMdInventoryT(null);
            MDInventoryT mdInvReturned = new MDInventoryT();
            mdInvReturned.setMdNm(md.getName().getMdNm());
            //MDInventoryT mdInvTmp = new MDInventoryT();
           // mdInvTmp.setSupportingOSNameList(md.getMdInventoryT().getSupportingOSNameList());
            
            if (granularity.equals("ATTRS")) {
                mdInvReturned.setMdAttrs(md);
               // mdInv.getMdAttrs().setMdInventoryT(null);
            } else if (granularity.equals("FULL")) {
                mdInvReturned.setMdAttrs(md);
                SupportingOSNameList mdFull = mdRetrieved.getMdInventoryT().getSupportingOSNameList();
                System.out.println("mdFull.getSupportingOSNames().size() " + mdFull.getSupportingOSNames());
                for (SupportingOSName son : mdFull.getSupportingOSNames()) {
                    System.out.println("setNull");
                    son.setId(null);
                }
                //mdInvReturned.getMdAttrs().setMdInventoryT(null);
                mdInvReturned.setSupportingOSNameList(mdFull);
            }
            mdInvs.add(mdInvReturned);
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

