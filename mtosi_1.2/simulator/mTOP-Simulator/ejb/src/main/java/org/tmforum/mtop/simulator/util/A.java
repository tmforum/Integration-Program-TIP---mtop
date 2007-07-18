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
import org.tmforum.mtop.simulator.creategetinventoryresponse.CreateConnectionTerminationPointResponse;
import org.tmforum.mtop.simulator.creategetinventoryresponse.CreateEProtectionGroupResponse;
import org.tmforum.mtop.simulator.creategetinventoryresponse.CreateEquipmentHolderResponse;
import org.tmforum.mtop.simulator.creategetinventoryresponse.CreateEquipmentResponse;
import org.tmforum.mtop.simulator.creategetinventoryresponse.CreateFloatingTerminationPointResponse;
import org.tmforum.mtop.simulator.creategetinventoryresponse.CreateManagedElementResponse;
import org.tmforum.mtop.simulator.creategetinventoryresponse.CreateManagementDomainResponse;
import org.tmforum.mtop.simulator.creategetinventoryresponse.CreateMultiLayerSubNetworkResponse;
import org.tmforum.mtop.simulator.creategetinventoryresponse.CreatePhysicalTerminationPointResponse;
import org.tmforum.mtop.simulator.creategetinventoryresponse.CreateProtectionGroupResponse;
import org.tmforum.mtop.simulator.creategetinventoryresponse.CreateGetInventoryResponse;
import org.tmforum.mtop.simulator.creategetinventoryresponse.CreateSubnetworkConnectionResponse;
import org.tmforum.mtop.simulator.creategetinventoryresponse.CreateTopologicalLinkResponse;
import org.tmforum.mtop.simulator.creategetinventoryresponse.CreateTpPoolResponse;
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
        System.out.println("mlsnNm: " + mlsnNm);
        String ehNm = namingAttributes.getEhNm();
        String ptpNm = namingAttributes.getPtpNm();
        String ftpNm = namingAttributes.getFtpNm();
        String pgpNm = namingAttributes.getPgpNm();
        String epgpNm = namingAttributes.getEpgpNm();
        String sncNm = namingAttributes.getSncNm();
        String tppoolNm = namingAttributes.getTppoolNm();
        String tlNm = namingAttributes.getTlNm();
        
        if (mdNm != null && mdNm != "" )  {
            // mdNm in BaseInstance
            baseInstanceS +=  " n.mdNm = " + "'" + mdNm + "'";
            baseInstanceLeaf = "MD";
        }
        if (meNm != null && meNm != "") {
            // meNm in BaseInstance
            baseInstanceS += " AND  n.meNm = " + "'" + meNm + "'";
            baseInstanceLeaf = "ME";
        }
        if (mlsnNm != null && mlsnNm != "") {
            // mlsnNm in BaseInstance
            System.out.println("mlsnNmmmmmmmmmmmmmmmmmmmm");
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
            // ehNm in BaseInstance
            baseInstanceS += " AND  n.epgpNm = " + "'" + epgpNm+ "'";
            baseInstanceLeaf = "EPGP";
        }
//         if (ccNm != null && ccNm != "") {
//            // ehNm in BaseInstance
//            System.out.println("ccNm!=nulllllllllllllllllll");
//            baseInstanceS += " AND  n.ccNm = " + "'" + ccNm+ "'";
//            baseInstanceLeaf = "CC";
//        }
        if (sncNm != null && sncNm != "") {
            // ehNm in BaseInstance
            System.out.println("sncNm!=nulllllllllllllllllll");
            baseInstanceS += " AND  n.sncNm = " + "'" + sncNm+ "'";
            baseInstanceLeaf = "SNC";
        }
        if (tppoolNm != null && tppoolNm != "") {
            // ehNm in BaseInstance
            System.out.println("tppoolNm!=nulllllllllllllllllll");
            baseInstanceS += " AND  n.tppoolNm = " + "'" + tppoolNm+ "'";
            baseInstanceLeaf = "TPPOOL";
        }
        System.out.println("baseInstanceSSSSSSSSSSSSSS " + baseInstanceS);
        return baseInstanceS;
    }
    
    public static Object baseInstanceLeaf(String name) {
        System.out.println("*************A:baseInstanceLeaf************");
        System.out.println("*************A:tableName************");
        if (name.equals("MD")) {
            //System.out.println("oooooooooooooooooo");
            return "ManagementDomainT";
        } else if (name.equals("ME"))
            return "ManagedElementT";
        else if (name.equals("MLSN"))
            return "MultiLayerSubnetworkT";
        else if (name.equals("EH")){
            System.out.println("EHHHHHH");
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
        else if (name.equals("TPPOOL"))
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
            return new CreateMultiLayerSubNetworkResponse();
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
        //if (name.equals("ConnectionTerminationPointT"))
        //  return new CreateConnectionTerminationPointResponse();
        if (name.equals("TopologicalLinkT"))
            return new CreateTopologicalLinkResponse();
        if (name.equals("TPPoolT"))
            return new CreateTpPoolResponse();
        
        return null;
    }
    
    public void validBaseInstance(List<NamingAttributesT> baseInstance) throws ProcessingFailureException {
        System.out.println("***************A.validBaseInstance()*****************************");
        if (baseInstance.size() == 0) {
            System.out.println("BI000000000000000000");
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
            String tlNm = namingAttributes.getTlNm();
            //String assocMe = namingAttributes.getMeNm();
            ProcessingFailureExceptionT p = new ProcessingFailureExceptionT();
            if (notSpecified(mdNm) && !emptyFilter()) {
                p.setReason("You must specify a value for md.");
                throw new ProcessingFailureException("error", p);
            } else if (notSpecified(meNm) &&
                    (!notSpecified(ehNm) || !notSpecified(pgpNm) || !notSpecified(epgpNm) ||
                    !notSpecified(ptpNm) || !notSpecified(ftpNm) || !notSpecified(sncNm))) {
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
    
    public void validIncludedObjectType(IncludedObjectType includedObjectType)  throws ProcessingFailureException {
        System.out.println("***************A.validIncludedObjectType()*****************************");
        System.out.println("includedObjectType.getObjectType() " + includedObjectType.getObjectType() );
        System.out.println("includedObjectType.getGranularity() " + includedObjectType.getGranularity() );
        
        if (notSpecified(includedObjectType.getObjectType())  &&
                !notSpecified(includedObjectType.getGranularity())) {
            System.out.println("Specify Acronymmmmmmmmmmmmmmmmmmmmm ");
            ProcessingFailureExceptionT p = new ProcessingFailureExceptionT();
            ProcessingFailureException pfe = new ProcessingFailureException("error", p);
            p.setReason("Specify ObjectAcronym.");
            throw new ProcessingFailureException("error", p);
        } else if (!notSpecified(includedObjectType.getObjectType())  &&
                notSpecified(includedObjectType.getGranularity())) {
            System.out.println("Specify Granularityyyyyyyyyyy ");
            ProcessingFailureExceptionT p = new ProcessingFailureExceptionT();
            ProcessingFailureException pfe = new ProcessingFailureException("error", p);
            p.setReason("Specify Granularity.");
            throw new ProcessingFailureException("error", p);
        }
    }
    
    public void iotUnderBi(NamingAttributesT baseInstance, IncludedObjectType includedObjectType) throws ProcessingFailureException {
        ProcessingFailureExceptionT p = new ProcessingFailureExceptionT();
        if ((baseInstanceLeaf.equals("MD") &&
                !(includedObjectType.getObjectType().value().equals("MD") ||
                includedObjectType.getObjectType().value().equals("ME") ||
                includedObjectType.getObjectType().value().equals("MLSN")))) {
            p.setReason("ObjectAcronym Type " +
                         includedObjectType.getObjectType().value() + 
                        " is not under " + baseInstanceLeaf);
            throw new ProcessingFailureException("error", p);
        } else if ((baseInstanceLeaf.equals("ME") &&
                !(includedObjectType.getObjectType().value().equals("ME")||
                includedObjectType.getObjectType().value().equals("EH")||
                includedObjectType.getObjectType().value().equals("PTP") ||
                includedObjectType.getObjectType().value().equals("FTP") ||
                includedObjectType.getObjectType().value().equals("EPGP") ||
                includedObjectType.getObjectType().value().equals("PGP")))) {
            p.setReason("ObjectAcronym Type " +
                         includedObjectType.getObjectType().value() + 
                        " is not under " + baseInstanceLeaf);
            throw new ProcessingFailureException("error", p);
        } else if ((baseInstanceLeaf.equals("MLSN") &&
                !(includedObjectType.getObjectType().value().equals("MLSN") ||
                includedObjectType.getObjectType().value().equals("SNC") ||
                includedObjectType.getObjectType().value().equals("TPPOOL") ||
                includedObjectType.getObjectType().value().equals("TL")))) {
             p.setReason("ObjectAcronym Type " +
                         includedObjectType.getObjectType().value() + 
                        " is not under " + baseInstanceLeaf);
        } else if ((baseInstanceLeaf.equals("EH") &&
                !(includedObjectType.getObjectType().value().equals("EH") ||
                includedObjectType.getObjectType().value().equals("EQ")))) {
             p.setReason("ObjectAcronym Type " +
                         includedObjectType.getObjectType().value() + 
                        " is not under " + baseInstanceLeaf);
            throw new ProcessingFailureException("error", p);
        } else if ((baseInstanceLeaf.equals("PTP") &&
                !(includedObjectType.getObjectType().value().equals("PTP") || 
                includedObjectType.getObjectType().value().equals("CTP")))) {
            p.setReason("ObjectAcronym Type " +
                         includedObjectType.getObjectType().value() + 
                        " is not under " + baseInstanceLeaf);
            throw new ProcessingFailureException("error", p);
        } else if ((baseInstanceLeaf.equals("FTP") &&
                !(includedObjectType.getObjectType().value().equals("FTP") ||
                includedObjectType.getObjectType().value().equals("CTP")))) {
             p.setReason("ObjectAcronym Type " +
                         includedObjectType.getObjectType().value() + 
                        " is not under " + baseInstanceLeaf);
            throw new ProcessingFailureException("error", p);
        } else if ((baseInstanceLeaf.equals("EPGP") &&
                !(includedObjectType.getObjectType().value().equals("EPGP")))) {
            p.setReason("ObjectAcronym Type " +
                         includedObjectType.getObjectType().value() + 
                        " is not under " + baseInstanceLeaf);
            throw new ProcessingFailureException("error", p);
        } else if ((baseInstanceLeaf.equals("PGP") &&
                !(includedObjectType.getObjectType().value().equals("PGP")))) {
            p.setReason("ObjectAcronym Type " +
                         includedObjectType.getObjectType().value() + 
                        " is not under " + baseInstanceLeaf);
            throw new ProcessingFailureException("error", p);
        }  else if ((baseInstanceLeaf.equals("SNC") &&
                !(includedObjectType.getObjectType().value().equals("SNC")))) {
            p.setReason("ObjectAcronym Type " +
                         includedObjectType.getObjectType().value() + 
                        " is not under " + baseInstanceLeaf);
            throw new ProcessingFailureException("error", p);
        }  else if ((baseInstanceLeaf.equals("TPPOOL") &&
                !(includedObjectType.getObjectType().value().equals("TPPOOL")))) {
            p.setReason("ObjectAcronym Type " +
                         includedObjectType.getObjectType().value() + 
                        " is not under " + baseInstanceLeaf);
            throw new ProcessingFailureException("error", p);
        }  else if ((baseInstanceLeaf.equals("ASSOCME") &&
                !(includedObjectType.getObjectType().value().equals("ASSOCME")))) {
            p.setReason("ObjectAcronym Type " +
                         includedObjectType.getObjectType().value() + 
                        " is not under " + baseInstanceLeaf);
            throw new ProcessingFailureException("error", p);
        }
    }
    
    public boolean notSpecified(Object s) {
        
        return (s == null || s.toString().equals(""));
    }
    
    public boolean emptyFilter() {
        return false;
    }
    
}

