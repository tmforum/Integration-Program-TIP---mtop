package org.tmforum.mtop.simulator;

import java.util.*;

import v1.tmf854.*;
import v1.tmf854.InventoryDataT.MdList;
import v1.tmf854.SimpleFilterT.IncludedObjectType;
import v1.tmf854.MDInventoryT.MeList;
import v1.tmf854.MEInventoryT.EhList;

/**
 * Class which creates the response for ManagementDomain managed
 * entities.
 */
public class CreateManagementDomainResponse extends CreateGetInventoryResponse {
   
    /** Creates a new instance of CreateManagementDomainResponse */
    public CreateManagementDomainResponse() {
    }
    
    public InventoryDataT createResponse(List<?> objs, String granularity) {
        List<MDInventoryT> mdInvs = getMdList().getMd();
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
              managedEntitiesIdsRetrieved.add(mdRetrieved.getId());
            ManagementDomainT md = (ManagementDomainT) mdRetrieved.copyManagedEntity();
            md.setMdInventoryT(null);
            
            // Loop through all existing mdInv
            for (MDInventoryT oldMdInv : getMdList().getMd()) {
               
                if (md.getName().getMdNm().equals(oldMdInv.getMdNm())) {
                    // ManagementDomain belongs to an existing mdInv: (MD, NAME) has already
                    // been treated
                
                    if (granularity.equals("ATTRS")) {
                        
                        if (oldMdInv.getMdAttrs() == null) {
                            updateRequired = true;
                            md.setName(null);
                            oldMdInv.setMdAttrs(md);
                       }
                    } else if (granularity.equals("FULL")) {
                        
                         if (oldMdInv.getSupportingOSNameList() == null) {
                            updateRequired = true;
                            md.setName(null);
                            oldMdInv.setMdAttrs(md);
                              SupportingOSNameList mdFull = mdRetrieved.getMdInventoryT().getSupportingOSNameList();
                            mdFull.initOSNm();
                                    
                            if (mdFull != null) {
     
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
                            SupportingOSNameList mdFull = 
                                    mdRetrieved.getMdInventoryT().getSupportingOSNameList();
                          
                            if (mdFull != null) {
                               
                                for (SupportingOSName son : mdFull.getSupportingOSNames()) {
                                    son.setId(null);
                                }
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


