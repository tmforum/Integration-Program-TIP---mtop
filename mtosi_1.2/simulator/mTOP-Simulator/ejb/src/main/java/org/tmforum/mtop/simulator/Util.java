package org.tmforum.mtop.simulator;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.*;
import org.tmforum.mtop.simulator.exception.ProcessingFailureException;

import v1.tmf854.*;
import v1.tmf854.SimpleFilterT.IncludedObjectType;

/**
 * This class is the utility class of the mTOP-Simulator application.
 * It has two main purposes <br>
 * <ul>
 * <li> checking that the filter parameters, baseInstance and includedObjectType
 * are valid.
 * <li> defining all the values of the managed entities.If a new managed entity
 * is added to the mtosi naming hierarchy tree it will need to be present
 * in this class.
 */
public  class Util  {
    
    private static String baseInstanceLeaf ;
    
    /**
     *  Creates the string corresponding to the base instance in the ejb-ql query.
     *  @param namingAttributes
     *  @return the string used after the "where" in the ejb-ql query.
     */
    public static String createBaseInstanceInRequest(NamingAttributesT namingAttributes) {
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
        System.out.println("baseInstanceLeaf: " + baseInstanceLeaf);
        
        return baseInstanceS;
    }
    
    /**
     * @param the name of the managed entity for which a response has to be created.
     * @return an instance of the class for the managed entity response to create
     */
    public CreateGetInventoryResponse createObjectTypeInstance(String name) {
        //System.out.println("*************A:objectType************");
        //System.out.println("name " + name);
        
        if (name.equals("ManagementDomainT")) {
            return new CreateManagementDomainResponse();
        }
        
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
        //System.out.println("***************A.validBaseInstance()*****************************");
        
        if (baseInstance.size() == 0) {
            // System.out.println("baseInstanceSize = 0");
            ProcessingFailureExceptionT p = new ProcessingFailureExceptionT();
            p.setReason("A value can't be specified without a type.");
            ProcessingFailureException pfe = new ProcessingFailureException("error", p);
            throw pfe;
        }
        // System.out.println("baseInstance.size = " + baseInstance.size());
        
        for (NamingAttributesT namingAttributes : baseInstance)  {
            String mdNm = namingAttributes.getMdNm();
            // System.out.println("namingAttributes.getMdNm= " + namingAttributes.getMdNm());
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
            }
            
            else if (notSpecified(meNm) &&
                    (!notSpecified(ehNm) || !notSpecified(pgpNm) || !notSpecified(epgpNm) ||
                    !notSpecified(ptpNm) || !notSpecified(ftpNm))) {
                p.setReason("You must specify a me.");
                throw new ProcessingFailureException("error", p);
            }
            
            else if (notSpecified(mlsnNm) &&
                    (!notSpecified(tpPoolNm) || !notSpecified(sncNm))) {
                p.setReason("You must specify a mlsn.");
                throw new ProcessingFailureException("error", p);
            }
            
            else if (notSpecified(ehNm) && !notSpecified(eqNm)) {
                p.setReason("You must specify a eh.");
                throw new ProcessingFailureException("error", p);
            }
            
            else if (notSpecified(ptpNm) && !notSpecified(ctpNm)) {
                p.setReason("You must specify a ftp or ptp.");
                throw new ProcessingFailureException("error", p);
            }
        }
    }
    
    /**
     * Check if the includedObjectType is valid given a baseInstance and other
     * includedObjectTypes.
     * @param includedObjectType the includedObjectType of the request
     * @param baseInstance the baseInstance of the request
     * @param includedObjectTypes the list of includedObjectTypes of the request
     * @throws ProcessingFailureException if the includedObjectType is not valid
     */
    public void validIncludedObjectType(IncludedObjectType includedObjectType,
            NamingAttributesT baseInstance,
            List<IncludedObjectType> includedObjectTypes)
            throws ProcessingFailureException {
        // System.out.println("***************A.validIncludedObjectType()*****************************");
        
        if (notSpecified(includedObjectType.getObjectType())  &&
                !notSpecified(includedObjectType.getGranularity())) {
            ProcessingFailureExceptionT p = new ProcessingFailureExceptionT();
            ProcessingFailureException pfe = new ProcessingFailureException("error", p);
            p.setReason("Specify ObjectAcronym.");
            throw new ProcessingFailureException("error", p);
        }
        
        else if (!notSpecified(includedObjectType.getObjectType())  &&
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
    
    /**
     * Returns the class which matches the objectAcronym parameter
     * @param the name of the objectAcronym
     * @return the name of the managed entity class
     */
    public static String managedEntityClassName(String name) {
        // System.out.println("*************A:tableName************");
        // System.out.println("name: " + name);
        
        if (name.equals("MD"))
            return   "ManagementDomainT";
        
        else if (name.equals("ME"))
            return "ManagedElementT";
        
        else if (name.equals("MLSN"))
            return "MultiLayerSubnetworkT";
        
        else if (name.equals("EH"))
            return "EquipmentHolderT";
        
        else if (name.equals("EQ"))
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
    
    /**
     * Check if the managed entity is a unit. A unit is one of the following:
     * <ul>
     * <li> one management domain object </li>
     * <li> one transmission descriptor object <li>
     * <li> one OS object </li>
     * <li> one topologicalLink </li>
     * <li> one managed element object and all contained objects passing the filter </li>
     * <li> one subnetwork object and all contained objects passing the filter. </li>
     * </ul>
     */
    public boolean isUnit(String className) {
        
        return (className.equals("ManagementDomainT") ||
                className.equals("TransmissionDescriptorT") ||
                className.equals("TopologicalLinkT") ||
                className.equals("ManagedElementT") ||
                className.equals("EquipmentHolderT") ||
                className.equals("ProtectionGroupT") ||
                className.equals("EProtectionGroupT") ||
                className.equals("FloatingTerminationPointT") ||
                className.equals("PhysicalTerminationPointT") ||
                className.equals("EquipmentHolderT") ||
                className.equals("SubnetworkConnectionT"));
    }
    
    /************************** Private Functions *****************************/
    /**
     * @param includedObjectType
     * @param baseInstance
     * @return true if the includedObjectType is a child of the baseInstance in
     *  the naming hierarchy tree
     */
    private boolean isIotUnderBi(IncludedObjectType includedObjectType,
            NamingAttributesT baseInstance) throws ProcessingFailureException {
        
        ProcessingFailureExceptionT p = new ProcessingFailureExceptionT();
        
        if ((baseInstanceLeaf.equals("MD") &&
                (includedObjectType.getObjectType().value().equals("MD") ||
                includedObjectType.getObjectType().value().equals("ME") ||
                includedObjectType.getObjectType().value().equals("TL") ||
                includedObjectType.getObjectType().value().equals("MLSN")))) {
            
            return true;
        }
        
        else if ((baseInstanceLeaf.equals("ME") &&
                (includedObjectType.getObjectType().value().equals("ME")||
                includedObjectType.getObjectType().value().equals("EH")||
                includedObjectType.getObjectType().value().equals("PTP") ||
                includedObjectType.getObjectType().value().equals("FTP") ||
                includedObjectType.getObjectType().value().equals("EPGP") ||
                includedObjectType.getObjectType().value().equals("PGP")))) {
            
            return true;
        }
        
        else if ((baseInstanceLeaf.equals("MLSN") &&
                (includedObjectType.getObjectType().value().equals("MLSN") ||
                includedObjectType.getObjectType().value().equals("SNC") ||
                includedObjectType.getObjectType().value().equals("TPPool") ||
                includedObjectType.getObjectType().value().equals("TL")))) {
            
            return true;
        }
        
        else if ((baseInstanceLeaf.equals("EH") &&
                (includedObjectType.getObjectType().value().equals("EH") ||
                includedObjectType.getObjectType().value().equals("EQ")))) {
            
            return true;
        }
        
        else if ((baseInstanceLeaf.equals("PTP") &&
                (includedObjectType.getObjectType().value().equals("PTP") ||
                includedObjectType.getObjectType().value().equals("CTP")))) {
            
            return true;
        }
        
        else if ((baseInstanceLeaf.equals("FTP") &&
                (includedObjectType.getObjectType().value().equals("FTP") ||
                includedObjectType.getObjectType().value().equals("CTP")))) {
            
            return true;
        }
        
        else if ((baseInstanceLeaf.equals("EPGP") &&
                (includedObjectType.getObjectType().value().equals("EPGP")))) {
            
            return true;
        }
        
        else if ((baseInstanceLeaf.equals("PGP") &&
                (includedObjectType.getObjectType().value().equals("PGP")))) {
            
            return true;
        }
        
        else if ((baseInstanceLeaf.equals("SNC") &&
                (includedObjectType.getObjectType().value().equals("SNC")))) {
            
            return true;
        }
        
        else if ((baseInstanceLeaf.equals("TPPOOL") &&
                (includedObjectType.getObjectType().value().equals("TPPool")))) {
            
            return true;
        }
        
        else if ((baseInstanceLeaf.equals("ASSOCME") &&
                (includedObjectType.getObjectType().value().equals("ASSOCME")))) {
            
            return true;
        }
        System.out.println("sssssssssss");
        return false;
    }
    
    /**
     * @param iotChild
     * @param includedObjectTypes
     * @return true if the includedObjectType iotChild is the child of another one
     * in the includedObjectTypes list
     */
    private boolean isIotUnderOtherIot(IncludedObjectType iotChild, List<IncludedObjectType> includedObjectTypes) {
//        for (IncludedObjectType iot : includedObjectTypes) {
//            
//            if (isChild(iotChild, iot)) {
//                
//                return true;
//            }
//        }
//        
        return true;
        //return false;
    }
    
    /**
     * @param includedObjectType
     * @param baseInstance
     * @param includedObjectTypes
     * @return true if the includedObjectType is the child of another one
     * in the includedObjectTypes list or a child of the baseInstance
     */
    private boolean hasIotParent(IncludedObjectType includedObjectType, NamingAttributesT baseInstance,
            List<IncludedObjectType> includedObjectTypes) throws ProcessingFailureException {
        return true;
//        System.out.println("isIOTUNderbiiiiiiiiiiiiii " + isIotUnderBi(includedObjectType, baseInstance));
//        System.out.println("isIOTUNderOTHERIOT " + isIotUnderOtherIot(includedObjectType, includedObjectTypes));
//        
//        return  (isIotUnderBi(includedObjectType, baseInstance) || isIotUnderOtherIot(includedObjectType, includedObjectTypes));
        
        
    }
    
    /**
     * Check if an includedObjectType is the child of another one.
     * @param iot1
     * @param iot2
     * @return true if io1 is a child of iot2
     */
    private boolean isChild(IncludedObjectType iot1, IncludedObjectType iot2) {
        System.out.println("*******isChild())))))))))))************ ");
         System.out.println(iot1.getObjectType().value() +"-"+ iot2.getObjectType().value());
        
        
        if ((iot1.getObjectType().value().equals("ME") ||
                iot1.getObjectType().value().equals("MLSN") ||
                iot1.getObjectType().value().equals("TL")) &&
                iot2.getObjectType().value().equals("MD")) {
           
            return true;
            
        } else if ((iot1.getObjectType().value().equals("EH") ||
                iot1.getObjectType().value().equals("PTP") ||
                iot1.getObjectType().value().equals("FTP") ||
                iot1.getObjectType().value().equals("PGP") ||
                iot1.getObjectType().value().equals("EPGP")) &&
                iot2.getObjectType().value().equals("ME")) {
           
            return true;
            
        } else if (iot1.getObjectType().value().equals("EQ") &&
                iot2.getObjectType().value().equals("EH")) {
            
            return true;
            
        } else if (iot1.getObjectType().value().equals("CTP") &&
                (iot2.getObjectType().value().equals("FTP") ||
                iot2.getObjectType().value().equals("PTP"))) {
          
            return true;
            
        } else if ( ( (iot1.getObjectType().value().equals("SNC")) ||
                      (iot1.getObjectType().value().equals("TPPool")) ) &&
                      (iot2.getObjectType().value().equals("MLSN")) ) {
             
            return true;
        }
        
      
        
        return false;
    }
    
    /**
     * @param s
     * @return true if parameter is null or emply
     */
    private boolean notSpecified(Object s) {
        
        return (s == null || s.toString().equals(""));
    }
    
    private boolean emptyFilter() {
        return false;
    }
}


