package org.tmforum.mtop.simulator;

import java.util.*;

import v1.tmf854.*;
import v1.tmf854.InventoryDataT.MdList;
import v1.tmf854.MDInventoryT.MeList;
import v1.tmf854.MEInventoryT.EhList;
import v1.tmf854.SimpleFilterT.IncludedObjectType;

/**
 * Class which allows to create the response for EquipmentHolder managed
 * entities.
 */
public class CreateEquipmentHolderResponse extends CreateGetInventoryResponse {
    
    /** Creates a new instance of CreateEquipmentHolderResponse */
    public CreateEquipmentHolderResponse() {
    }
    
    public InventoryDataT createResponse(List<?> objs, String granularity) {
        EhList ehList = new EhList();
        List<EHInventoryT> ehInvs = ehList.getEhInv();
        boolean newMdInv = true;
        boolean newMeInv = true;
        boolean newEhInv = true;
        EquipmentHolderT  firstManagedElement = (EquipmentHolderT) objs.get(0);
        
        if (getMdList().getMd().size() == 0) {
            MDInventoryT firstMdInv = new MDInventoryT();
            firstMdInv.setMdNm(firstManagedElement.getName().getMdNm());
            getMdList().getMd().add(firstMdInv);
        }
        
        // loop through all EquipmentHolders retrieved
        for (Object o : objs) {
            EquipmentHolderT eh = (EquipmentHolderT) o;    
            managedEntitiesIdsRetrieved.add(eh.getId());
            // creates the EhInventory
            EHInventoryT ehInv = new EHInventoryT();
            ehInv.setEhNm(eh.getName().getEhNm());
            
            // loop through all existing mdInv
            for (MDInventoryT oldMdInv : getMdList().getMd()) {
                
                if (oldMdInv.getMdNm().equals(eh.getName().getMdNm())) {
                    // ehInv belongs to this md
                    
                    if (oldMdInv.getMeList() != null) {
                        // loop through all existing meInv under this mdInv
                        for (MEInventoryT oldMeInv : oldMdInv.getMeList().getMeInv()) {
                            
                            if (oldMeInv.getMeNm().equals(eh.getName().getMeNm())) {
                                //ehInv belongs to this meInv
                               
                                if (oldMeInv.getEhList() != null) {
                                    // ehInv is not the first under this meInv
                                    
                                    // loop through all existing ehInv under this meinv
                                    for (EHInventoryT oldEhInv : oldMeInv.getEhList().getEhInv()) {
                                       
                                        if (oldEhInv.getEhNm().equals(eh.getName().getEhNm())) {
                                            // ehInv of current eh already exists
                                            
                                            if (oldEhInv.getEhAttrs() == null) 
                                              setEhGranularity(granularity, oldEhInv, eh);
                                            
                                            newEhInv = false;
                                            
                                            break;
                                        }
                                    } //for oldEhInv
                                    
                                    if (newEhInv) {
                                        // ehInv belongs to a new ehInv
                                        setEhGranularity(granularity, ehInv, eh);
                                        oldMeInv.getEhList().getEhInv().add(ehInv);
                                    }
                                } else {
                                    // ehInv is the first under this meInv
                                    EhList ehListOldMe = new EhList();
                                    setEhGranularity(granularity, ehInv, eh);
                                    ehListOldMe.getEhInv().add(ehInv);
                                    oldMeInv.setEhList(ehListOldMe);
                                }
                                newMeInv = false;
                                break;
                            }
                        } // for oldMeInv
                        
                        if (newMeInv) {
                            // ehInv belongs to a new meInv
                            MEInventoryT meInv = new MEInventoryT();
                            EhList ehListUnderNewMe = new EhList();
                            ehInv.setEhNm(eh.getName().getEhNm());
                            setEhGranularity(granularity, ehInv, eh);
                            ehListUnderNewMe.getEhInv().add(ehInv);
                            meInv.setMeNm(eh.getName().getMeNm());
                            meInv.setEhList(ehListUnderNewMe);
                            oldMdInv.getMeList().getMeInv().add(meInv);
                        }
                    } else {
                        // first meInv under this mdInv
                        MeList firstMeListOfMd = new MeList();
                        MEInventoryT firstMeInvOfMd = new MEInventoryT();
                        EhList ehListUnderNewMe = new EhList();
                        ehInv.setEhNm(eh.getName().getEhNm());
                        setEhGranularity(granularity, ehInv, eh);
                        ehListUnderNewMe.getEhInv().add(ehInv);
                        firstMeInvOfMd.setMeNm(eh.getName().getMeNm());
                        firstMeInvOfMd.setEhList(ehListUnderNewMe);
                        firstMeListOfMd.getMeInv().add(firstMeInvOfMd);
                        oldMdInv.setMeList(firstMeListOfMd);
                    }
                }
                newMdInv = false;
                
                break;
            } // for oldMdInv
            
            if (newMdInv) {
                // ehInv belongs to a new mdInv
                MDInventoryT mdInvUnderNewMd = new MDInventoryT();
                mdInvUnderNewMd.setMdNm(eh.getName().getMdNm());
                MeList meListUnderNewMd = new MeList();
                MEInventoryT meInvUnderNewMd = new MEInventoryT();
                meInvUnderNewMd.setMeNm(eh.getName().getMeNm());
                EhList ehListUnderNewMd = new EhList();
                ehInv.setEhNm(eh.getName().getEhNm());
                setEhGranularity(granularity, ehInv, eh);
                ehListUnderNewMd.getEhInv().add(ehInv);
                meInvUnderNewMd.setEhList(ehListUnderNewMd);
                meListUnderNewMd.getMeInv().add(meInvUnderNewMd);
                mdInvUnderNewMd.setMeList(meListUnderNewMd);
                
                getMdList().getMd().add(mdInvUnderNewMd);
            }
        } // for objs
        
        // add the new MdList to final response
        refreshMdList(getMdList());
        
        return inventoryData;
    }
    
     public void setEhGranularity(String granularity, EHInventoryT ehInv, EquipmentHolderT eh) {
        if ( (granularity.equals("ATTRS") ||  granularity.equals("FULL")) ) {
            if (eh.getAcceptableEquipmentTypeList() != null)
                        eh.getAcceptableEquipmentTypeList().initAcceptableEquipmentType();
                   ehInv.setEhAttrs(eh);
        }
     }
    
    public InventoryDataT getInventoryData() {
        
        return inventoryData;
    }
}
