
package v1.tmf854;
/*
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
 */

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.*;

/**
 *
 *       This aggregate defines the Equipment object.
 *
 *
 * <p>Java class for Equipment_T complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Equipment_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="name" type="{tmf854.v1}NamingAttributes_T" minOccurs="0"/>
 *         &lt;element name="discoveredName" type="{tmf854.v1}DiscoveredName_T" minOccurs="0"/>
 *         &lt;element name="namingOS" type="{tmf854.v1}NamingOS_T" minOccurs="0"/>
 *         &lt;element name="userLabel" type="{tmf854.v1}UserLabel_T" minOccurs="0"/>
 *         &lt;element name="source" type="{tmf854.v1}Source_T" minOccurs="0"/>
 *         &lt;element name="owner" type="{tmf854.v1}Owner_T" minOccurs="0"/>
 *         &lt;element name="aliasNameList" type="{tmf854.v1}AliasNameList_T" minOccurs="0"/>
 *         &lt;element name="resourceState" type="{tmf854.v1}ResourceState_T" minOccurs="0"/>
 *         &lt;element name="alarmReportingIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="expectedEquipmentObjectType" type="{tmf854.v1}EquipmentObjectType_T" minOccurs="0"/>
 *         &lt;element name="installedEquipmentObjectType" type="{tmf854.v1}EquipmentObjectType_T" minOccurs="0"/>
 *         &lt;element name="installedPartNumber" type="{tmf854.v1}InstalledPartNumber_T" minOccurs="0"/>
 *         &lt;element name="installedSerialNumber" type="{tmf854.v1}InstalledSerialNumber_T" minOccurs="0"/>
 *         &lt;element name="serviceState" type="{tmf854.v1}ServiceState_T" minOccurs="0"/>
 *         &lt;element name="installedVersion" type="{tmf854.v1}InstalledVersion_T" minOccurs="0"/>
 *         &lt;element name="manufacturer" type="{tmf854.v1}Manufacturer_T" minOccurs="0"/>
 *         &lt;element name="vendorExtensions" type="{tmf854.v1}EqVendorExtensions_T" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="extAuthor" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="extVersion" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="tmf854Version" type="{tmf854.v1}TMF854_Version_T" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
/*@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Equipment_T", propOrder = {
 
})*/
@Entity
public class EquipmentT implements Serializable {
/*
    @XmlElementRef(name = "name", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<NamingAttributesT> name;
    @XmlElementRef(name = "discoveredName", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<String> discoveredName;
    @XmlElementRef(name = "namingOS", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<String> namingOS;
    @XmlElementRef(name = "userLabel", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<String> userLabel;
    @XmlElementRef(name = "source", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<SourceT> source;
    @XmlElementRef(name = "owner", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<String> owner;
    @XmlElementRef(name = "aliasNameList", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<AliasNameListT> aliasNameList;
    @XmlElementRef(name = "resourceState", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<ResourceStateT> resourceState;
    @XmlElementRef(name = "alarmReportingIndicator", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<Boolean> alarmReportingIndicator;
    @XmlElementRef(name = "expectedEquipmentObjectType", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<String> expectedEquipmentObjectType;
    @XmlElementRef(name = "installedEquipmentObjectType", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<String> installedEquipmentObjectType;
    @XmlElementRef(name = "installedPartNumber", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<String> installedPartNumber;
    @XmlElementRef(name = "installedSerialNumber", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<String> installedSerialNumber;
    @XmlElementRef(name = "serviceState", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<ServiceStateT> serviceState;
    @XmlElementRef(name = "installedVersion", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<String> installedVersion;
    @XmlElementRef(name = "manufacturer", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<String> manufacturer;
    @XmlElementRef(name = "vendorExtensions", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<EqVendorExtensionsT> vendorExtensions;
    @XmlAttribute
    protected String extAuthor;
    @XmlAttribute
    protected String extVersion;
    @XmlAttribute
    protected String tmf854Version;
 */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "EQUIPMENTT_ID")
    private int idEQ;
   @OneToOne
    @JoinColumn(name="NAMEATT_ID", referencedColumnName="NAMEATT_ID")
    private NamingAttributesT nameAtt;
   //@OneToOne
    //private SourceT sourceT;
     @Column(name="ALARMREPORTINGINDICATOR") 
    private Boolean alarmReportingIndicator;
      @Column(name="INSTALLEDEQUIPMENTOBJECTTYPE") 
    private String installedEquipmentObjectType;
       @Column(name="INSTALLEDPARTNUMBER") 
    private String installedPartNumber;
   // private ServiceStateT serviceState;
    @Column(name="INSTALLEDVERSION") 
       private String installedVersion;

    public int getIdEQ() {
        return idEQ;
    }

    public void setIdEQ(int idEQ) {
        this.idEQ = idEQ;
    }

    public NamingAttributesT getNameAtt() {
        return nameAtt;
    }

    public void setNameAtt(NamingAttributesT nameAtt) {
        this.nameAtt = nameAtt;
    }

    public Boolean getAlarmReportingIndicator() {
        return alarmReportingIndicator;
    }

    public void setAlarmReportingIndicator(Boolean alarmReportingIndicator) {
        this.alarmReportingIndicator = alarmReportingIndicator;
    }

    public String getInstalledEquipmentObjectType() {
        return installedEquipmentObjectType;
    }

    public void setInstalledEquipmentObjectType(String installedEquipmentObjectType) {
        this.installedEquipmentObjectType = installedEquipmentObjectType;
    }

    public String getInstalledPartNumber() {
        return installedPartNumber;
    }

    public void setInstalledPartNumber(String installedPartNumber) {
        this.installedPartNumber = installedPartNumber;
    }

    public String getInstalledVersion() {
        return installedVersion;
    }

    public void setInstalledVersion(String installedVersion) {
        this.installedVersion = installedVersion;
    }

    
   
    
}
