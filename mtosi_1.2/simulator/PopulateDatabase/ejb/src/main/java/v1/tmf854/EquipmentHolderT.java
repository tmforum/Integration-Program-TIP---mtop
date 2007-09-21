
package v1.tmf854;

import java.io.Serializable;
import javax.xml.bind.annotation.*;
import javax.persistence.*;

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
public class EquipmentHolderT implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @XmlTransient
    @OneToOne(cascade={CascadeType.ALL})
    private EHInventoryT ehInventoryT;
    @OneToOne(cascade={CascadeType.ALL})
    private NamingAttributesT name;
    private String discoveredName;
    private String namingOS;
    private String userLabel;
    @OneToOne(cascade={CascadeType.ALL})
    private SourceT source;
    private String owner;
    @OneToOne(cascade={CascadeType.ALL})
    private AliasNameListT aliasNameList;
    @OneToOne(cascade={CascadeType.ALL})
    private ResourceStateT resourceState;
    private Boolean alarmReportingIndicator;
    private String holderType;
    @OneToOne(cascade={CascadeType.ALL})
    private AcceptableEquipmentTypeList acceptableEquipmentTypeList;
    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="expeq_fk")
    private NamingAttributesT expectedOrInstalledEquipment;
    @Enumerated(EnumType.STRING)
    private HolderStateT holderState;
    private String location;
    private String manufacturer;
    private String manufacturerDate;
    @Transient
    private EHVendorExtensionsT vendorExtensions;
    private String vendorExtensionsS;
    private String extAuthor;
    protected String extVersion;
    protected String tmf854Version;
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
    
    public void initVendorExtensions() {
        this.getVendorExtensions().setAny();
        setVendorExtensionsS(this.getVendorExtensions().getVdExt());
    }
    
    public String getVendorExtensionsS() {
        return vendorExtensionsS;
    }
    
    public void setVendorExtensionsS(String vendorExtensionsS) {
        this.vendorExtensionsS = vendorExtensionsS;
    }
    
}













