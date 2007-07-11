
package v1.tmf854;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.*;
import java.util.Collection;
import java.util.*;
import static javax.persistence.CascadeType.ALL;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlTransient;

import javax.xml.bind.annotation.*;
/**
 *
 * <p>Java class for EquipmentHolder_T complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="EquipmentHolder_T">
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
 *         &lt;element name="holderType" type="{tmf854.v1}EquipmentHolderType_T" minOccurs="0"/>
 *         &lt;element name="acceptableEquipmentTypeList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="acceptableEquipmentType" type="{tmf854.v1}EquipmentObjectType_T" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="expectedOrInstalledEquipment" type="{tmf854.v1}NamingAttributes_T" minOccurs="0"/>
 *         &lt;element name="holderState" type="{tmf854.v1}HolderState_T" minOccurs="0"/>
 *         &lt;element name="location" type="{tmf854.v1}Location_T" minOccurs="0"/>
 *         &lt;element name="manufacturer" type="{tmf854.v1}Manufacturer_T" minOccurs="0"/>
 *         &lt;element name="manufacturerDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vendorExtensions" type="{tmf854.v1}EHVendorExtensions_T" minOccurs="0"/>
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
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EquipmentHolder_T", propOrder = {
})
@Entity
@Table(name = "EH")
public class EquipmentHolderT implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="EH_ID")
    private Long id;
    @XmlTransient
    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="NAME_FK", referencedColumnName="NAMEATT_ID")
    private NamingAttributesT name;
     @OneToOne(cascade={CascadeType.ALL})
    private EHInventoryT ehInventoryT;
    protected String discoveredName;
    protected String namingOS;
    protected String userLabel;
    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="source_")
    protected SourceT source;
    protected String owner;
    @OneToOne(cascade={CascadeType.ALL})
    protected AliasNameListT aliasNameList;
    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="rsrcstate")
    protected ResourceStateT resourceState;
    protected Boolean alarmReportingIndicator;
    protected String holderType;
    // @OneToOne(cascade={CascadeType.ALL})
//    private EquipmentHolderT.AcceptableEquipmentTypeList acceptableEquipmentTypeList;
    @OneToOne(cascade={CascadeType.ALL})
    private AcceptableEquipmentTypeList acceptableEquipmentTypeList;
    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="EXP_FK", referencedColumnName="NAMEATT_ID")
    private NamingAttributesT expectedOrInstalledEquipment;
    @Enumerated(EnumType.STRING)
    protected HolderStateT holderState;
    protected String location;
    protected String manufacturer;
    protected String manufacturerDate;
    // @OneToOne(cascade={CascadeType.ALL})
    @Transient
    protected EHVendorExtensionsT vendorExtensions;
    protected String extAuthor;
    protected String extVersion;
    protected String tmf854Version;
    //baptiste
    private String src;
    private String resrcState;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    
    
    public String getDiscoveredName() {
        return discoveredName;
    }
    
    
    public void setDiscoveredName(String value) {
        this.discoveredName = value;
    }
    
    
    
    public String getNamingOS() {
        return namingOS;
    }
    
    
    public void setNamingOS(String value) {
        this.namingOS = value;
    }
    
    
    public String getUserLabel() {
        return userLabel;
    }
    
    
    public void setUserLabel(String value) {
        this.userLabel = value;
    }
    
    
    public SourceT getSource() {
        return source;
    }
    
    
    public void setSource(SourceT value) {
        this.source = value;
    }
    
    
    public String getOwner() {
        return owner;
    }
    
    
    public void setOwner(String value) {
        this.owner = value;
    }
    
    public AliasNameListT getAliasNameList() {
        return aliasNameList;
    }
    
    
    public void setAliasNameList(AliasNameListT value) {
        this.aliasNameList = value;
    }
    
    
    public ResourceStateT getResourceState() {
        return resourceState;
    }
    
    
    public void setResourceState(ResourceStateT value) {
        this.resourceState = value;
    }
    
    
    public Boolean getAlarmReportingIndicator() {
        return alarmReportingIndicator;
    }
    
    
    public void setAlarmReportingIndicator(Boolean value) {
        this.alarmReportingIndicator = value;
    }
    
    
    public String getHolderType() {
        return holderType;
    }
    
    
    public void setHolderType(String value) {
        this.holderType = value;
    }
    
    
    
    public NamingAttributesT getExpectedOrInstalledEquipment() {
        return expectedOrInstalledEquipment;
    }
    
    
    public void setExpectedOrInstalledEquipment(NamingAttributesT value) {
        this.expectedOrInstalledEquipment = value;
    }
    
    
    
    public HolderStateT getHolderState() {
        return holderState;
    }
    
    
    public void setHolderState(HolderStateT value) {
        this.holderState = value;
    }
    
    
    public String getLocation() {
        return location;
    }
    
    
    public void setLocation(String value) {
        this.location = value;
    }
    
    
    public String getManufacturer() {
        return manufacturer;
    }
    
    
    public void setManufacturer(String value) {
        this.manufacturer = value;
    }
    
    
    public String getManufacturerDate() {
        return manufacturerDate;
    }
    
    
    public void setManufacturerDate(String value) {
        this.manufacturerDate = value;
    }
    
    
    public EHVendorExtensionsT getVendorExtensions() {
        return vendorExtensions;
    }
    
    
    public void setVendorExtensions(EHVendorExtensionsT value) {
        this.vendorExtensions = value;
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
    
    
    
//    @XmlAccessorType(XmlAccessType.FIELD)
//    @XmlType(name = "acceptableEquipmentTypeLisT", propOrder = {
//        "acceptableEquipmentType"
//    })
//    public static class AcceptableEquipmentTypeList {
//        @Transient
//        protected List<String> acceptableEquipmentType;
//        private List<AcceptableEquipmentType> accs;
//
//        public List<String> getAcceptableEquipmentType() {
//            if (acceptableEquipmentType == null) {
//                acceptableEquipmentType = new ArrayList<String>();
//            }
//            return this.acceptableEquipmentType;
//        }
//
//        public List<AcceptableEquipmentType> getAccs() {
//            if (accs == null) {
//                accs = new ArrayList<AcceptableEquipmentType>();
//            }
//
//            for (String s : acceptableEquipmentType) {
//                AcceptableEquipmentType acc = new AcceptableEquipmentType(s);
//                accs.add(acc);
//            }
//
//            return this.accs;
//        }
//
//        public void setLrs(List<AcceptableEquipmentType> accs) {
//            this.accs = accs;
//        }
//    }
    
    
//    public EquipmentHolderT.AcceptableEquipmentTypeList getAcceptableEquipmentTypeList() {
//        return acceptableEquipmentTypeList;
//    }
//
//    public void setAcceptableEquipmentTypeList(EquipmentHolderT.AcceptableEquipmentTypeList acceptableEquipmentTypeList) {
//        this.acceptableEquipmentTypeList = acceptableEquipmentTypeList;
//    }
    
    public AcceptableEquipmentTypeList getAcceptableEquipmentTypeList() {
        return acceptableEquipmentTypeList;
    }
    
    public void setAcceptableEquipmentTypeList(AcceptableEquipmentTypeList acceptableEquipmentTypeList) {
        this.acceptableEquipmentTypeList = acceptableEquipmentTypeList;
    }

    public NamingAttributesT getName() {
        return name;
    }

    public void setName(NamingAttributesT name) {
        this.name = name;
    }

    public EHInventoryT getEhInventoryT() {
        return ehInventoryT;
    }

    public void setEhInventoryT(EHInventoryT ehInventoryT) {
        this.ehInventoryT = ehInventoryT;
    }
    
    
}









