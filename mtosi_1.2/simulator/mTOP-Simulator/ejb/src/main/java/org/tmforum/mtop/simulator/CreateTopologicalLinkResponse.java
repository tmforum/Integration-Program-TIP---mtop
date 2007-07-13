/*
 * CreateEquipmentHolderResponse.java
 *
 * Created on 7 mai 2007, 23:25
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.tmforum.mtop.simulator;

import v1.tmf854.*;
import v1.tmf854.InventoryDataT.MdList;
import v1.tmf854.MDInventoryT.MlsnList;
import v1.tmf854.MLSNInventoryT.TlList;
import v1.tmf854.SimpleFilterT.IncludedObjectType;
import java.io.*;
import java.util.*;

/**
 *
 * @author baptiste
 */
public class CreateTopologicalLinkResponse extends CreateResponse{
    
    /** Creates a new instance of CreateEquipmentHolderResponse */
    public CreateTopologicalLinkResponse() {
    }
    
    
    public InventoryDataT createResponse(List<?> objs, String granularity) {
        System.out.println(" CreateTopologicalLinkResponse:createResponse");
        InventoryDataT inventoryData = new InventoryDataT();
        String mdNm1 = "";
        String mlsnNm1 = "";
        String tlNm1 = "";
        MdList mdList = new MdList();
        MDInventoryT mdInv = new MDInventoryT();
        List<MDInventoryT> mdInvs = mdList.getMd();
        MlsnList mlsnList = new MlsnList();
        MLSNInventoryT mlsnInv = new MLSNInventoryT();
        List<MLSNInventoryT> mlsnInvs = mlsnList.getMlsnInv();
        ListIterator<MLSNInventoryT> litMe = mlsnInvs.listIterator();
        MultiLayerSubnetworkT previousMlsn = null;
        TlList tlList = new TlList();
        List<TLInventoryT> tlInvs = tlList.getTlInv();
        ListIterator<TLInventoryT> litTl = tlInvs.listIterator();
        TopologicalLinkT previousTpl = null;
        String previousMdNm = null;
        String previousMlsnNm = null;
        String previousTplNm = null;
        boolean newNode = false;
        for (Object o : objs) {
            TopologicalLinkT tl = (TopologicalLinkT) o;
            TLInventoryT tlInv = new TLInventoryT();
            mdNm1 = tl.getName().getMdNm();
            mlsnNm1 = tl.getName().getMlsnNm();
            tlNm1 = tl.getName().getTlNm();
            
//            if (previousTpl != null) {
//                //System.out.println("mdNm " + mdNm1 + " previousMdNm " + previousMdNm);
//                if(!mlsnNm1.equals(previousMlsnNm)) {
//                    System.out.println("Change Me!!!!!!!!!!!!!!!!");
//                    //snc belongs to another me
//                    previousTpl.setName(null);
//                    previousTpl.setIdTPL(null);
//                    newNode = true;
//                    mlsnInv.setTlList(tlList);
//                    mlsnInv.setMlsnNm(previousMlsnNm);
//                    mlsnInvs.add(mlsnInv);
//                    tlInv = new TLInventoryT();
//                    tlList = new TlList();
//                    tlInvs = tlList.getTlInv();
//                    litTl = tlInvs.listIterator();
//                    mlsnInv = new MLSNInventoryT();
//                }
//            }
            if (granularity.equals("ATTRS") || granularity.equals("FULL"))
                tlInv.setTlAttrs(tl);
            tlInv.setTlNm(tlNm1);
            litTl.add(tlInv);
            
//            
//            if (previousTpl != null && !newNode){
//                previousTpl.setName(null);
//                previousTpl.setIdTPL(null);
//            }
            previousTpl = tl;
            previousMlsnNm = previousTpl.getName().getSncNm();
            newNode = false;
        }
        
        TopologicalLinkT lastTl = litTl.previous().getTlAttrs();
       if (lastTl != null)
        //lastTl.setIdTPL(null);
        lastTl.setName(null);
        mlsnInv.setTlList(tlList);
        mlsnInv.setMlsnNm(mlsnNm1);
        mlsnInvs.add(mlsnInv);
        mdInv.setMlsnList(mlsnList);
        mdInv.setMdNm(mdNm1);
        mdInvs.add(mdInv);
        
        inventoryData.setMdList(mdList);
        return inventoryData;
    }
}


