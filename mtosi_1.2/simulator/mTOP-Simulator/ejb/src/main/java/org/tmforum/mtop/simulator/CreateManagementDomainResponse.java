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
        List<MDInventoryT> mdInvs = getMdList().getMd();
        String mdNm1 = "";
        boolean firstMdList = (getMdList().getMd().size() == 0);
        boolean updateRequired = false;
        ManagementDomainT  firstManagementDomain = (ManagementDomainT) objs.get(0);
        
        if (firstMdList) {
            // Initialize mdList with the first md retrieved 
            MDInventoryT firstMdInv = new MDInventoryT();
            firstMdInv.setMdNm(firstManagementDomain.getName().getMdNm());
            getMdList().getMd().add(firstMdInv);
        }
        
        for (Object o : objs) {
            ManagementDomainT mdRetrieved =(ManagementDomainT) o;
            ManagementDomainT md = (ManagementDomainT) mdRetrieved.copyManagedEntity();
            System.out.println("---------------------md.getMdInventory " + md.getMdInventoryT());
            md.setMdInventoryT(null);
            
            // Loop through all existing mdInv
            for (MDInventoryT oldMdInv : getMdList().getMd()) {
                if (md.getName().getMdNm().equals(oldMdInv.getMdNm())) {
                    // ManagementDomain belongs to an existing mdInv: (MD, NAME) has already
                    // been treated
                    if (granularity.equals("ATTRS")) {
                        // Look ig (MD, ATTRS) has already  been treated
                        if (oldMdInv.getMdAttrs() == null) {
                            updateRequired = true;
                            oldMdInv.setMdAttrs(md);
                       }
                    } else if (granularity.equals("FULL")) {
                        // Look (MD, FULL) has already  been treated
                        if (oldMdInv.getSupportingOSNameList() == null) {
                            updateRequired = true;
                            oldMdInv.setMdAttrs(md);
                            //mdInvReturned.setMdAttrs(md);
                            SupportingOSNameList mdFull = mdRetrieved.getMdInventoryT().getSupportingOSNameList();
                            if (mdFull != null) {
                                System.out.println("mdFull.getSupportingOSNames().size() " + mdFull.getSupportingOSNames());
                                for (SupportingOSName son : mdFull.getSupportingOSNames()) {
                                    System.out.println("setNull");
                                    son.setId(null);
                                }
                                //mdInvReturned.setSupportingOSNameList(mdFull);
                                oldMdInv.setSupportingOSNameList(mdFull);
                            }
                        }
                    }
                } else {
                    // md belongs to a new mdInv
                     md.setMdInventoryT(null);
                    MDInventoryT newMdInv = new MDInventoryT();
                    newMdInv.setMdNm(md.getName().getMdNm());
                    if (granularity.equals("ATTRS")) {
                        newMdInv.setMdAttrs(md);
                    } else if (granularity.equals("FULL")) {
                        if (md.getMdInventoryT().getSupportingOSNameList() == null) {
                            updateRequired = true;
                            newMdInv.setMdAttrs(md);
                            //mdInvReturned.setMdAttrs(md);
                            SupportingOSNameList mdFull = mdRetrieved.getMdInventoryT().getSupportingOSNameList();
                            if (mdFull != null) {
                                System.out.println("mdFull.getSupportingOSNames().size() " + mdFull.getSupportingOSNames());
                                for (SupportingOSName son : mdFull.getSupportingOSNames()) {
                                    System.out.println("setNull");
                                    son.setId(null);
                                }
                                //mdInvReturned.setSupportingOSNameList(mdFull);
                                newMdInv.setSupportingOSNameList(mdFull);
                            }
                        }
                    }
                    mdInvs.add(newMdInv);
                }
            } // for
        } // for
        
        inventoryData.setMdList(getMdList());
        
        return inventoryData;
        
    }
    
    public InventoryDataT getInventoryData() {
        return inventoryData;
    }
}


