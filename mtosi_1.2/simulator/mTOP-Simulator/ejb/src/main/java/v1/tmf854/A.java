/*
 * A.java
 *
 * Created on 7 mai 2007, 03:42
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package v1.tmf854;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.tmforum.mtop.simulator.*;
import ws.v1.tmf854.*;
import v1.tmf854.SimpleFilterT.IncludedObjectType;
import java.util.*;
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
    
    public CreateResponse objectType(String name) {
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
    
    public boolean notSpecified(Object s) {
        
        return (s == null || s.toString().equals(""));
    }
    
    public boolean emptyFilter() {
        return false;
    }
    
}

