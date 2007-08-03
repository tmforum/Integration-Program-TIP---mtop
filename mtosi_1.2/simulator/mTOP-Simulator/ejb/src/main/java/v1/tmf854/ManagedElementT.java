
package v1.tmf854;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.*;

/**
 *
 *       This aggregate defines the Managed Element object.
 *
 *
 * <p>Java class for ManagedElement_T complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ManagedElement_T">
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
 *         &lt;element name="location" type="{tmf854.v1}Location_T" minOccurs="0"/>
 *         &lt;element name="manufacturer" type="{tmf854.v1}Manufacturer_T" minOccurs="0"/>
 *         &lt;element name="productName" type="{tmf854.v1}ProductName_T" minOccurs="0"/>
 *         &lt;element name="version" type="{tmf854.v1}Version_T" minOccurs="0"/>
 *         &lt;element name="InSyncState" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="supportedRates" type="{tmf854.v1}LayerRateList_T" minOccurs="0"/>
 *         &lt;element name="communicationState" type="{tmf854.v1}CommunicationState_T" minOccurs="0"/>
 *         &lt;element name="networkAccessDomain" type="{tmf854.v1}NetworkAccessDomain_T" minOccurs="0"/>
 *         &lt;element name="manufacturerDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ManagedElement_T", propOrder = {
})
@Entity
@Table(name = "ME")
public class ManagedElementT implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name="ME_ID")
    private Long id;
    @XmlTransient
    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="meInv")
    private MEInventoryT meInventoryT;
    @XmlTransient
    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="name_", referencedColumnName="NAMEATT_ID")
    private NamingAttributesT name;
    private String discoveredName;
    private String namingOS;
    private String userLabel;
    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="source_")
    private SourceT source;
    protected String owner;
    @OneToOne(cascade={CascadeType.ALL})
    protected AliasNameListT aliasNameList;
    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="rsrcstate_")
    protected ResourceStateT resourceState;
    private String location;
    private String manufacturer;
    private String productName;
    private String version;
    @XmlElement(name = "InSyncState", nillable = true)
    private Boolean InSyncState;
    @OneToOne(cascade={CascadeType.ALL})
    // @JoinColumn(name="spR")
    protected LayerRateListT supportedRates;
    @Enumerated(EnumType.STRING)
    protected CommunicationStateT communicationState;
    protected String networkAccessDomain;
    protected String manufacturerDate;
    @OneToOne(cascade={CascadeType.ALL})
    @XmlTransient
    protected MEVendorExtensionsT vendorExtensions;
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
    
    public NamingAttributesT getName() {
        return name;
    }
    
    public void setName(NamingAttributesT name) {
        this.name = name;
    }
    
    public String getDiscoveredName() {
        return discoveredName;
    }
    
    public void setDiscoveredName(String discoveredName) {
        this.discoveredName = discoveredName;
    }
    
    public String getManufacturer() {
        return manufacturer;
    }
    
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    
    public String getNamingOS() {
        return namingOS;
    }
    
    public void setNamingOS(String namingOS) {
        this.namingOS = namingOS;
    }
    
    public String getUserLabel() {
        return userLabel;
    }
    
    public void setUserLabel(String userLabel) {
        this.userLabel = userLabel;
    }
    
    public SourceT getSource() {
        return source;
    }
    
    public void setSource(SourceT source) {
        this.source = source;
    }
    
    public String getOwner() {
        return owner;
    }
    
    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public String getProductName() {
        return productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public String getVersion() {
        return version;
    }
    
    public void setVersion(String version) {
        this.version = version;
    }
    
    public Boolean getInSyncState() {
        return InSyncState;
    }
    
    public void setInSyncState(Boolean InSyncState) {
        this.InSyncState = InSyncState;
    }
    
    
    public LayerRateListT getSupportedRates() {
        return supportedRates;
    }
    
    public void setSupportedRates(LayerRateListT supportedRates) {
        this.supportedRates = supportedRates;
    }
    
    public CommunicationStateT getCommunicationState() {
        return communicationState;
    }
    
    public void setCommunicationState(CommunicationStateT communicationState) {
        this.communicationState = communicationState;
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
    
    
    public String getNetworkAccessDomain() {
        return networkAccessDomain;
    }
    
    public void setNetworkAccessDomain(String networkAccessDomain) {
        this.networkAccessDomain = networkAccessDomain;
    }
    
    public String getManufacturerDate() {
        return manufacturerDate;
    }
    
    public void setManufacturerDate(String manufacturerDate) {
        this.manufacturerDate = manufacturerDate;
    }
    
    public String getExtAuthor() {
        return extAuthor;
    }
    
    public void setExtAuthor(String extAuthor) {
        this.extAuthor = extAuthor;
    }
    
    public String getExtVersion() {
        return extVersion;
    }
    
    public void setExtVersion(String extVersion) {
        this.extVersion = extVersion;
    }
    
    public String getTmf854Version() {
        return tmf854Version;
    }
    
    public void setTmf854Version(String tmf854Version) {
        this.tmf854Version = tmf854Version;
    }
    
    public MEVendorExtensionsT getVendorExtensions() {
        return vendorExtensions;
    }
    
    public void setVendorExtensions(MEVendorExtensionsT vendorExtensions) {
        this.vendorExtensions = vendorExtensions;
    }
    
    public MEInventoryT getMeInventoryT() {
        return meInventoryT;
    }
    
    public void setMeInventoryT(MEInventoryT meInventoryT) {
        this.meInventoryT = meInventoryT;
    }
    
    
    
}

