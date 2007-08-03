/*
 * A.java
 *
 * Created on 7 mai 2007, 03:42
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.tmforum.mtop.simulator.util;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.tmforum.mtop.simulator.CreateConnectionTerminationPointResponse;
import org.tmforum.mtop.simulator.CreateEProtectionGroupResponse;
import org.tmforum.mtop.simulator.CreateEquipmentHolderResponse;
import org.tmforum.mtop.simulator.CreateEquipmentResponse;
import org.tmforum.mtop.simulator.CreateFloatingTerminationPointResponse;
import org.tmforum.mtop.simulator.CreateManagedElementResponse;
import org.tmforum.mtop.simulator.CreateManagementDomainResponse;
import org.tmforum.mtop.simulator.CreateMultiLayerSubnetworkResponse;
import org.tmforum.mtop.simulator.CreatePhysicalTerminationPointResponse;
import org.tmforum.mtop.simulator.CreateProtectionGroupResponse;
import org.tmforum.mtop.simulator.CreateGetInventoryResponse;
import org.tmforum.mtop.simulator.CreateSubnetworkConnectionResponse;
import org.tmforum.mtop.simulator.CreateTopologicalLinkResponse;
import org.tmforum.mtop.simulator.CreateTpPoolResponse;
import v1.tmf854.*;
import ws.v1.tmf854.*;
import v1.tmf854.SimpleFilterT.IncludedObjectType;
import java.util.*;
import ws.v1.tmf854.ProcessingFailureException;

/**
 * Entity class A
 *
 * @author baptiste
 */
public  class A  {
                 private static String baseInstanceLeaf ;
    
    public static String  tableName(String name) {
        System.out.println("*************A:tableName************");
        System.out.println("name: " + name);
        if (name.equals("MD")) {
            //System.out.println("oooooooooooooooooo");
            return   "ManagementDomainT";
        } else if (name.equals("ME"))
            return "ManagedElementT";
        else if (name.equals("MLSN"))
            return "MultiLayerSubnetworkT";
        else if (name.equals("EH")){
            return "EquipmentHolderT";
        } else if (name.equals("EQ"))
            return "EquipmentT";
        else if (name.equals("PTP"))
            return "PhysicalTerminationPointT";
        else if (name.equals("FTP"))
            return "FloatingTerminationPointT";
        else if (name.equals("PGP"))
            return "ProtectionGroupT";
        else if (name.equals("EPGP"))
            return "EProtectionGroupT";
        else if (name.equals("CC"))
            return "CrossConnectT";
        else if (name.equals("CTP"))
            return "ConnectionTerminationPointT";
        else if (name.equals("SNC"))
            return "SubnetworkConnectionT";
        else if (name.equals("TP_POOL")) {
            System.out.println("name equals TPPOOL");
            return "TPPoolT";
        } else if (name.equals("TL"))
            return "TopologicalLinkT";
        return null;
    }
    
    public static String baseInstance(NamingAttributesT namingAttributes) {
        System.out.println("*************A:baseInstance************");
        String baseInstanceS = "";
        String baseInstanceLast = null;
        String mdNm = namingAttributes.getMdNm();
        String meNm = namingAttributes.getMeNm();
        String mlsnNm = namingAttributes.getMlsnNm();
        String tlNm = namingAttributes.getTlNm();
        String ehNm = namingAttributes.getEhNm();
        String ptpNm = namingAttributes.getPtpNm();
        String ftpNm = namingAttributes.getFtpNm();
        String pgpNm = namingAttributes.getPgpNm();
        String epgpNm = namingAttributes.getEpgpNm();
        String sncNm = namingAttributes.getSncNm();
        String tppoolNm = namingAttributes.getTppoolNm();
        
        
        if (mdNm != null && mdNm != "" )  {
            // mdNm in BaseInstance
            baseInstanceS +=  " n.mdNm = " + "'" + mdNm + "'";
            baseInstanceLeaf = "MD";
        }
        if (tlNm != null && tlNm != "") {
            // tlNm in BaseInstance
            baseInstanceS += " AND  n.tlNm = " + "'" + tlNm + "'";
            baseInstanceLeaf = "TL";
        }
        if (meNm != null && meNm != "") {
            // meNm in BaseInstance
            baseInstanceS += " AND  n.meNm = " + "'" + meNm + "'";
            baseInstanceLeaf = "ME";
        }
        if (mlsnNm != null && mlsnNm != "") {
            // mlsnNm in BaseInstance
            baseInstanceS += " AND  n.mlsnNm = " + "'" + mlsnNm + "'";
            baseInstanceLeaf = "MLSN";
        }
        if (ehNm != null && ehNm != "") {
            // ehNm in BaseInstance
            baseInstanceS += " AND  n.ehNm = " + "'" + ehNm+ "'";
            baseInstanceLeaf = "EH";
        }
        if (ptpNm != null && ptpNm != "") {
            // ehNm in BaseInstance
            baseInstanceS += " AND  n.ptpNm = " + "'" + ptpNm+ "'";
            baseInstanceLeaf = "PTP";
        }
        ///////////////
        if (ftpNm != null && ftpNm != "") {
            // ftpNm in BaseInstance
            baseInstanceS += " AND  n.ftpNm = " + "'" + ftpNm+ "'";
            baseInstanceLeaf = "FTP";
        }
        if (pgpNm != null && pgpNm != "") {
            // ehNm in BaseInstance
            baseInstanceS += " AND  n.pgpNm = " + "'" + pgpNm+ "'";
            baseInstanceLeaf = "PGP";
        }
        if (epgpNm != null && epgpNm != "") {
            // epgpNm in BaseInstance
            baseInstanceS += " AND  n.epgpNm = " + "'" + epgpNm+ "'";
            baseInstanceLeaf = "EPGP";
        }
        if (sncNm != null && sncNm != "") {
            // sncNm in BaseInstance
            baseInstanceS += " AND  n.sncNm = " + "'" + sncNm+ "'";
            baseInstanceLeaf = "SNC";
        }
        if (tppoolNm != null && tppoolNm != "") {
            // tppNm in BaseInstance
            baseInstanceS += " AND  n.tppoolNm = " + "'" + tppoolNm+ "'";
            baseInstanceLeaf = "TPPOOL";
        }
        
        return baseInstanceS;
    }
    
    public static Object baseInstanceLeaf(String name) {
        System.out.println("*************A:baseInstanceLeaf************");
        System.out.println("*************A:tableName************");
        if (name.equals("MD")) {
            return "ManagementDomainT";
        } else if (name.equals("ME"))
            return "ManagedElementT";
        else if (name.equals("MLSN"))
            return "MultiLayerSubnetworkT";
        else if (name.equals("EH")){
            return "EquipmentHolderT";
        } else if (name.equals("EQ"))
            return "EquipmentT";
        else if (name.equals("PTP"))
            return "PhysicalTerminationPointT";
        else if (name.equals("FTP"))
            return "FloatingTerminationPointT";
        else if (name.equals("PGP"))
            return "ProtectionGroupT";
        else if (name.equals("EPGP"))
            return "EProtectionGroupT";
        else if (name.equals("CC"))
            return "CrossConnectT";
        else if (name.equals("CTP"))
            return "ConnectionTerminationPointT";
        else if (name.equals("SNC"))
            return "SubnetworkConnectionT";
        else if (name.equals("TP_POOL"))
            return "TPPoolT";
        else if (name.equals("TL"))
            return "TopologicalLinkT";
        return null;
    }
    
    public CreateGetInventoryResponse objectType(String name) {
        System.out.println("*************A:objectType************");
        System.out.println("name " + name);
        if (name.equals("ManagementDomainT"))
            return new CreateManagementDomainResponse();
        if (name.equals("ManagedElementT"))
            return new CreateManagedElementResponse();
        if (name.equals("MultiLayerSubnetworkT"))
            return new CreateMultiLayerSubnetworkResponse();
        if (name.equals("EquipmentHolderT"))
            return new CreateEquipmentHolderResponse();
        if (name.equals("EquipmentT"))
            return new CreateEquipmentResponse();
        if (name.equals("PhysicalTerminationPointT"))
            return new CreatePhysicalTerminationPointResponse();
        if (name.equals("FloatingTerminationPointT"))
            return new CreateFloatingTerminationPointResponse();
        if (name.equals("ProtectionGroupT"))
            return new CreateProtectionGroupResponse();
        if (name.equals("EProtectionGroupT"))
            return new CreateEProtectionGroupResponse();
        if (name.equals("ConnectionTerminationPointT"))
            return new CreateConnectionTerminationPointResponse();
        if (name.equals("SubnetworkConnectionT"))
            return new CreateSubnetworkConnectionResponse();
        if (name.equals("TopologicalLinkT"))
            return new CreateTopologicalLinkResponse();
        if (name.equals("TPPoolT"))
            return new CreateTpPoolResponse();
        
        return null;
    }
    
    public void validBaseInstance(List<NamingAttributesT> baseInstance) throws ProcessingFailureException {
        System.out.println("***************A.validBaseInstance()*****************************");
        if (baseInstance.size() == 0) {
            ProcessingFailureExceptionT p = new ProcessingFailureExceptionT();
            p.setReason("A value can't be specified without a type.");
            ProcessingFailureException pfe = new ProcessingFailureException("error", p);
            throw pfe;
        }
        
        for (NamingAttributesT namingAttributes : baseInstance)  {
            String mdNm = namingAttributes.getMdNm();
            // level 2
            String meNm = namingAttributes.getMeNm();
            String mlsnNm = namingAttributes.getMlsnNm();
            String tlNm = namingAttributes.getTlNm();
            // level 3
            String ehNm = namingAttributes.getEhNm();
            String pgpNm = namingAttributes.getPgpNm();
            String epgpNm = namingAttributes.getEpgpNm();
            String ptpNm = namingAttributes.getPtpNm();
            String ftpNm = namingAttributes.getFtpNm();
            String sncNm = namingAttributes.getSncNm();
            // level 4
            String eqNm = namingAttributes.getEqNm();
            String ctpNm = namingAttributes.getCtpNm();
            String tpPoolNm = namingAttributes.getTppoolNm();
            //String assocMe = namingAttributes.getMeNm();
            ProcessingFailureExceptionT p = new ProcessingFailureExceptionT();
            if (notSpecified(mdNm) && !emptyFilter()) {
                p.setReason("You must specify a value for md.");
                throw new ProcessingFailureException("error", p);
            } else if (notSpecified(meNm) &&
                    (!notSpecified(ehNm) || !notSpecified(pgpNm) || !notSpecified(epgpNm) ||
                    !notSpecified(ptpNm) || !notSpecified(ftpNm))) {
                p.setReason("You must specify a me.");
                throw new ProcessingFailureException("error", p);
            } else if (notSpecified(mlsnNm) &&
                    (!notSpecified(tlNm) || !notSpecified(tpPoolNm) || !notSpecified(sncNm))) {
                p.setReason("You must specify a mlsn.");
                throw new ProcessingFailureException("error", p);
            } else if (notSpecified(ehNm) && !notSpecified(eqNm)) {
                p.setReason("You must specify a eh.");
                throw new ProcessingFailureException("error", p);
            } else if (notSpecified(ptpNm) && !notSpecified(ctpNm)) {
                p.setReason("You must specify a ftp or ptp.");
                throw new ProcessingFailureException("error", p);
            }
        }
    }
    
    public void validIncludedObjectType(IncludedObjectType includedObjectType, NamingAttributesT baseInstance,
            List<IncludedObjectType> includedObjectTypes)  throws ProcessingFailureException {
        System.out.println("***************A.validIncludedObjectType()*****************************");
        System.out.println("includedObjectType.getObjectType() " + includedObjectType.getObjectType() );
        System.out.println("includedObjectType.getGranularity() " + includedObjectType.getGranularity() );
        
        if (notSpecified(includedObjectType.getObjectType())  &&
                !notSpecified(includedObjectType.getGranularity())) {
            ProcessingFailureExceptionT p = new ProcessingFailureExceptionT();
            ProcessingFailureException pfe = new ProcessingFailureException("error", p);
            p.setReason("Specify ObjectAcronym.");
            throw new ProcessingFailureException("error", p);
        } else if (!notSpecified(includedObjectType.getObjectType())  &&
                notSpecified(includedObjectType.getGranularity())) {
            ProcessingFailureExceptionT p = new ProcessingFailureExceptionT();
            ProcessingFailureException pfe = new ProcessingFailureException("error", p);
            p.setReason("Specify Granularity.");
            throw new ProcessingFailureException("error", p);
        }
        else if (!hasIotParent(includedObjectType, baseInstance, includedObjectTypes)) {
            ProcessingFailureExceptionT p = new ProcessingFailureExceptionT();
            ProcessingFailureException pfe = new ProcessingFailureException("error", p);
            p.setReason("IncludedObjecType " + includedObjectType.getObjectType().value() + " has no parent.");
            throw new ProcessingFailureException("error", p);
        }
    }
    
    public boolean isIotUnderBi(IncludedObjectType includedObjectType, NamingAttributesT baseInstance) throws ProcessingFailureException {
        ProcessingFailureExceptionT p = new ProcessingFailureExceptionT();
         System.out.println("includedObjectType.getObjectType().value() " + includedObjectType.getObjectType().value());
        if ((baseInstanceLeaf.equals("MD") &&
                (includedObjectType.getObjectType().value().equals("MD") ||
                includedObjectType.getObjectType().value().equals("ME") ||
                includedObjectType.getObjectType().value().equals("TL") ||
                includedObjectType.getObjectType().value().equals("MLSN")))) {
            return true;
        } else if ((baseInstanceLeaf.equals("ME") &&
                (includedObjectType.getObjectType().value().equals("ME")||
                includedObjectType.getObjectType().value().equals("EH")||
                includedObjectType.getObjectType().value().equals("PTP") ||
                includedObjectType.getObjectType().value().equals("FTP") ||
                includedObjectType.getObjectType().value().equals("EPGP") ||
                includedObjectType.getObjectType().value().equals("PGP")))) {
            return true;
        } else if ((baseInstanceLeaf.equals("MLSN") &&
                (includedObjectType.getObjectType().value().equals("MLSN") ||
                includedObjectType.getObjectType().value().equals("SNC") ||
                includedObjectType.getObjectType().value().equals("TPPool") ||
                includedObjectType.getObjectType().value().equals("TL")))) {
            return true;
        } else if ((baseInstanceLeaf.equals("EH") &&
                (includedObjectType.getObjectType().value().equals("EH") ||
                includedObjectType.getObjectType().value().equals("EQ")))) {
            return true;
        } else if ((baseInstanceLeaf.equals("PTP") &&
                (includedObjectType.getObjectType().value().equals("PTP") ||
                includedObjectType.getObjectType().value().equals("CTP")))) {
            return true;
        } else if ((baseInstanceLeaf.equals("FTP") &&
                (includedObjectType.getObjectType().value().equals("FTP") ||
                includedObjectType.getObjectType().value().equals("CTP")))) {
            return true;
        } else if ((baseInstanceLeaf.equals("EPGP") &&
                (includedObjectType.getObjectType().value().equals("EPGP")))) {
            return true;
        } else if ((baseInstanceLeaf.equals("PGP") &&
                (includedObjectType.getObjectType().value().equals("PGP")))) {
            return true;
        }  else if ((baseInstanceLeaf.equals("SNC") &&
                (includedObjectType.getObjectType().value().equals("SNC")))) {
            return true;
        }  else if ((baseInstanceLeaf.equals("TP_POOL") &&
                (includedObjectType.getObjectType().value().equals("TP_POOL")))) {
            System.out.println("trueeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
            return true;
        }  else if ((baseInstanceLeaf.equals("ASSOCME") &&
                (includedObjectType.getObjectType().value().equals("ASSOCME")))) {
            return true;
        }
        return false;
    }
    
    public boolean isIotUnderOtherIot(IncludedObjectType iotChild, List<IncludedObjectType> includedObjectTypes) {
         for (IncludedObjectType iot : includedObjectTypes) {
            if (isChild(iotChild, iot))
                return true;
        }
        return false;
    }
    
    public boolean hasIotParent(IncludedObjectType includedObjectType, NamingAttributesT baseInstance,
            List<IncludedObjectType> includedObjectTypes) throws ProcessingFailureException {
        
        return  (isIotUnderBi(includedObjectType, baseInstance) || isIotUnderOtherIot(includedObjectType, includedObjectTypes));
        
       
    }
    
public boolean isChild(IncludedObjectType child, IncludedObjectType father) {
        System.out.println("*******isChild()************ ");
        System.out.println("child: " + child.getObjectType().value() + "father: " + father.getObjectType().value());
        if ((child.getObjectType().value().equals("ME") ||
                child.getObjectType().value().equals("MLSN") ||
                child.getObjectType().value().equals("TL"))
                && father.getObjectType().value().equals("MD"))
            return true;
        else if ((child.getObjectType().value().equals("EH") ||
                child.getObjectType().value().equals("PTP") ||
                child.getObjectType().value().equals("FTP") ||
                child.getObjectType().value().equals("PGP") ||
                child.getObjectType().value().equals("EPGP")) &&
                father.getObjectType().value().equals("ME")) {
         System.out.println("isChild:true");
            return true;
        }
        else if (child.getObjectType().value().equals("EQ") &&
                father.getObjectType().value().equals("EH"))
            return true;
        else if (child.getObjectType().value().equals("CTP") &&
                (father.getObjectType().value().equals("FTP") || father.getObjectType().value().equals("PTP")))
            return true;
        else if ((child.getObjectType().value().equals("SNC") ||
                child.getObjectType().value().equals("TPPOOL")) &&
                father.getObjectType().value().equals("FTP") || father.getObjectType().value().equals("PTP"))
            return true;
        return false;
    }
    
    public void validRequest(List<NamingAttributesT> bis, List<IncludedObjectType> iots) {
        
    }
    
    public boolean notSpecified(Object s) {
        
        return (s == null || s.toString().equals(""));
    }
    
    public boolean emptyFilter() {
        return false;
    }
    
}


