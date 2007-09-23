
package v1.tmf854;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import java.util.Map;
import javax.xml.bind.annotation.*;

@Entity
public class NamingAttributesT implements Serializable{
   
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    protected String osNm;
    protected String mdNm;
    protected String meNm;
    protected String ehNm;
    protected String eqNm;
    protected String ptpNm;
    protected String ftpNm;
    protected String ctpNm;
    protected String tppoolNm;
    protected String pgpNm;
    protected String epgpNm;
    protected String mlsnNm;
    protected String sncNm;
    protected String tmdNm;
    protected String tlNm;
    protected String aidNm;
    protected String propNm;
    protected String extAuthor;
    protected String extVersion;
    protected String tmf854Version;
    
    public Long getId() {
        return id;
    }
    
    public void setIdNatt(Long idNatt) {
        this.id = id;
    }
    
    public String getOsNm() {
        return osNm;
    }
    
    public void setOsNm(String value) {
        this.osNm = value;
    }
    
    public String getMdNm() {
        return mdNm;
    }
    
    
    public void setMdNm(String value) {
        this.mdNm = value;
    }
    
    public String getMeNm() {
        return meNm;
    }
    
    
    public void setMeNm(String value) {
        this.meNm = value;
    }
    
    
    public String getEhNm() {
        return ehNm;
    }
    
    
    public void setEhNm(String value) {
        this.ehNm = value;
    }
    
    
    public String getEqNm() {
        return eqNm;
    }
    
    
    public void setEqNm(String value) {
        this.eqNm = value;
    }
    
    
    public String getPtpNm() {
        return ptpNm;
    }
    
    public void setPtpNm(String value) {
        this.ptpNm = value;
    }
    
    
    public String getFtpNm() {
        return ftpNm;
    }
    
    
    public void setFtpNm(String value) {
        this.ftpNm = value;
    }
    
    
    public String getCtpNm() {
        return ctpNm;
    }
    
    
    public void setCtpNm(String value) {
        this.ctpNm = value;
    }
    
    public String getTppoolNm() {
        return tppoolNm;
    }
    
    public void setTppoolNm(String value) {
        this.tppoolNm = value;
    }
    
    
    public String getPgpNm() {
        return pgpNm;
    }
    
    public void setPgpNm(String value) {
        this.pgpNm = value;
    }
    
    
    public String getEpgpNm() {
        return epgpNm;
    }
    
    
    public void setEpgpNm(String value) {
        this.epgpNm = value;
    }
    
    
    public String getMlsnNm() {
        return mlsnNm;
    }
    
    
    public void setMlsnNm(String value) {
        this.mlsnNm = value;
    }
    
    public String getSncNm() {
        return sncNm;
    }
    
    
    public void setSncNm(String value) {
        this.sncNm = value;
    }
    
    public String getTmdNm() {
        return tmdNm;
    }
    
    public void setTmdNm(String value) {
        this.tmdNm = value;
    }
    
    public void initBIs(Map baseInstancesMap, List<NamingAttributesT> baseInstance) {
        int nbNatts = baseInstancesMap.size() / 8;
       
        for (int i = 0; i < nbNatts ; i++) {
            
            Integer biNumberI = (Integer) baseInstancesMap.get("nbBaseInstances");
            NamingAttributesT namingAttrs1 = new NamingAttributesT();
            String biNumber = biNumberI.toString();
            setOsNm((String)baseInstancesMap.get("biFieldOs"));
           
            if (!notSpecified(baseInstancesMap.get("baseInstanceType1"+i))) {
                // at least 1 ObjectType type specified
                namingAttrs1.setMdNm((String)baseInstancesMap.get("baseInstanceValue1"+i));
               
                if (!notSpecified(baseInstancesMap.get("baseInstanceType2"+i))) {
                    
                    if (((String)baseInstancesMap.get("baseInstanceType2"+i)).equals("ME")) {
                        namingAttrs1.setMeNm((String)baseInstancesMap.get("baseInstanceValue2"+i));
                        
                        if (!notSpecified(baseInstancesMap.get("baseInstanceType3"+i))) {
                            
                            if (((String)baseInstancesMap.get("baseInstanceType3"+i)).equals("EH")) {
                                namingAttrs1.setEhNm((String)baseInstancesMap.get("baseInstanceValue3"+i));
                                
                                if (!notSpecified(baseInstancesMap.get("baseInstanceType4"+i))) {
                                    
                                    if (baseInstancesMap.get("baseInstanceType4"+i) != null) {
                                        
                                        if (((String)baseInstancesMap.get("baseInstanceType4"+i)).equals("EQ")) {
                                            namingAttrs1.setEqNm((String)baseInstancesMap.get("baseInstanceValue4"+i));
                                        }
                                    }}
                            } else if (((String)baseInstancesMap.get("baseInstanceType3"+i)).equals("PTP")) {
                                namingAttrs1.setPtpNm((String)baseInstancesMap.get("baseInstanceValue3"+i));
                                
                                if (!notSpecified(baseInstancesMap.get("baseInstanceType4"+i))) {
                                    
                                    if (baseInstancesMap.get("baseInstanceType4"+i) != null) {
                                        
                                        if (((String)baseInstancesMap.get("baseInstanceType4"+i)).equals("CTP")) {
                                            namingAttrs1.setCtpNm((String)baseInstancesMap.get("baseInstanceValue4"+i));
                                        }
                                    }}
                            } else if (((String)baseInstancesMap.get("baseInstanceType3"+i)).equals("FTP")) {
                                namingAttrs1.setFtpNm((String)baseInstancesMap.get("baseInstanceValue3"+i));
                                
                                if (!notSpecified(baseInstancesMap.get("baseInstanceType4"+i))) {
                                    
                                    if (baseInstancesMap.get("baseInstanceType4"+i) != null) {
                                        
                                        if (((String)baseInstancesMap.get("baseInstanceType4"+i)).equals("CTP")) {
                                            namingAttrs1.setCtpNm((String)baseInstancesMap.get("baseInstanceValue4"+i));
                                        }
                                    }
                                }
                            } else if (((String)baseInstancesMap.get("baseInstanceType3"+i)).equals("PGP")) {
                                namingAttrs1.setPgpNm((String)baseInstancesMap.get("baseInstanceValue3"+i));
                            } else if (((String)baseInstancesMap.get("baseInstanceType3"+i)).equals("EPGP")) {
                                namingAttrs1.setEpgpNm((String)baseInstancesMap.get("baseInstanceValue3"+i));
                            }
                        }
                    } else if (((String)baseInstancesMap.get("baseInstanceType2"+i)).equals("MLSN")) {
                        namingAttrs1.setMlsnNm((String)baseInstancesMap.get("baseInstanceValue2"+i));
                        
                        
                        if (!notSpecified(baseInstancesMap.get("baseInstanceType3"+i))) {
                            
                            if (((String)baseInstancesMap.get("baseInstanceType3"+i)).equals("SNC")) {
                                namingAttrs1.setSncNm((String)baseInstancesMap.get("baseInstanceValue3"+i));
                            } else if (((String)baseInstancesMap.get("baseInstanceType3"+i)).equals("TPPool")) {
                                namingAttrs1.setTppoolNm((String)baseInstancesMap.get("baseInstanceValue3"+i));
                            }
                        }
                    }
                } 
                baseInstance.add(namingAttrs1);
            } 
        } // end for baseInstance
    }
    
    public void initIOTs(Map includedObjectTypesMap, 
            List<SimpleFilterT.IncludedObjectType> includedObjectTypes) {
        
         int nbIots = includedObjectTypesMap.size() / 2;
       
        for (int i = 0; i < nbIots; i++) {
            SimpleFilterT.IncludedObjectType includedObjectType = new SimpleFilterT.IncludedObjectType();
           
            if (!notSpecified(includedObjectTypesMap.get("objectAcronym"+i)) &&
                    !notSpecified(includedObjectTypesMap.get("granularity"+i))) {
                // set the objectAcronym
                if (((String)includedObjectTypesMap.get("objectAcronym"+i)).equals("MD")) {
                    includedObjectType.setObjectType(ObjectAcronymT.MD);
                } else if (((String)includedObjectTypesMap.get("objectAcronym"+i)).equals("ME")) {
                    includedObjectType.setObjectType(ObjectAcronymT.ME);
                } else if  (((String)includedObjectTypesMap.get("objectAcronym"+i)).equals("MLSN")) {
                    includedObjectType.setObjectType(ObjectAcronymT.MLSN);
                } else if  (((String)includedObjectTypesMap.get("objectAcronym"+i)).equals("TL")) {
                    includedObjectType.setObjectType(ObjectAcronymT.TL);
                } else if  (((String)includedObjectTypesMap.get("objectAcronym"+i)).equals("EH")) {
                    includedObjectType.setObjectType(ObjectAcronymT.EH);
                } else if  (((String)includedObjectTypesMap.get("objectAcronym"+i)).equals("PTP")) {
                    includedObjectType.setObjectType(ObjectAcronymT.PTP);
                } else if  (((String)includedObjectTypesMap.get("objectAcronym"+i)).equals("FTP")) {
                    includedObjectType.setObjectType(ObjectAcronymT.FTP);
                } else if  (((String)includedObjectTypesMap.get("objectAcronym"+i)).equals("PGP")) {
                    includedObjectType.setObjectType(ObjectAcronymT.PGP);
                } else if  (((String)includedObjectTypesMap.get("objectAcronym"+i)).equals("EPGP")) {
                    includedObjectType.setObjectType(ObjectAcronymT.EPGP);
                }  else if  (((String)includedObjectTypesMap.get("objectAcronym"+i)).equals("CTP")) {
                    includedObjectType.setObjectType(ObjectAcronymT.CTP);
                } else if  (((String)includedObjectTypesMap.get("objectAcronym"+i)).equals("EQ")) {
                    includedObjectType.setObjectType(ObjectAcronymT.EQ);
                } else if  (((String)includedObjectTypesMap.get("objectAcronym"+i)).equals("SNC")) {
                    includedObjectType.setObjectType(ObjectAcronymT.SNC);
                } else if  (((String)includedObjectTypesMap.get("objectAcronym"+i)).equals("TPPool")) {
                    includedObjectType.setObjectType(ObjectAcronymT.TP_POOL);
                }
                // set the granularity
                if (((String)includedObjectTypesMap.get("granularity"+i)).equals("NAME")) {
                    includedObjectType.setGranularity(GranularityT.NAME);
                } else  if (((String)includedObjectTypesMap.get("granularity"+i)).equals("ATTRS")) {
                    includedObjectType.setGranularity(GranularityT.ATTRS);
                } else if (((String)includedObjectTypesMap.get("granularity"+i)).equals("FULL")) {
                    includedObjectType.setGranularity(GranularityT.FULL);
                } 
            } else if (notSpecified(includedObjectTypesMap.get("objectAcronym"+i)))  {
                includedObjectType.setGranularity(GranularityT.NAME);
            } else if (notSpecified(includedObjectTypesMap.get("granularity"+i)))  {
                includedObjectType.setObjectType(ObjectAcronymT.ME);   
            }
            
            includedObjectTypes.add(includedObjectType);
        }// end for iot
        
    }
    
    public String getTlNm() {
        return tlNm;
    }
    
    public void setTlNm(String value) {
        this.tlNm = value;
    }
    
    
    public String getAidNm() {
        return aidNm;
    }
    
    
    public void setAidNm(String value) {
        this.aidNm = value;
    }
    
    
    public String getPropNm() {
        return propNm;
    }
    
    
    public void setPropNm(String value) {
        this.propNm = value;
    }
    
    
    public String getExtAuthor() {
        return extAuthor;
    }
    
    public void setExtAuthor(String value) {
        this.extAuthor = value;
    }
    
    
    public String getExtVersion() {
        return extVersion;
    }
    
    
    public void setExtVersion(String value) {
        this.extVersion = value;
    }
    
    
    public String getTmf854Version() {
        return tmf854Version;
    }
    
    public void setTmf854Version(String value) {
        this.tmf854Version = value;
    }
    
    public boolean notSpecified(Object o) {
       
        return (o == null || o.toString().equals(""));
    }
}

