
package v1.tmf854;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;


/**
 *
 * This aggregate defines the Subnetwork object.
 *
 *
 * <p>Java class for MultiLayerSubnetwork_T complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="MultiLayerSubnetwork_T">
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
 *         &lt;element name="subnetworkType" type="{tmf854.v1}Topology_T" minOccurs="0"/>
 *         &lt;element name="supportedRates" type="{tmf854.v1}LayerRateList_T" minOccurs="0"/>
 *         &lt;element name="networkAccessDomain" type="{tmf854.v1}NetworkAccessDomain_T" minOccurs="0"/>
 *         &lt;element name="vendorExtensions" type="{tmf854.v1}MLSVendorExtensions_T" minOccurs="0"/>
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
@XmlType(name = "MultiLayerSubnetwork_T", propOrder = {
})
@Entity
public class MultiLayerSubnetworkT implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     @XmlTransient
    @OneToOne(cascade={CascadeType.ALL})
    private MLSNInventoryT mlsnInventoryT;
    @XmlTransient
    @OneToOne(cascade={CascadeType.ALL})
    private NamingAttributesT name;
    protected String discoveredName;
    protected String namingOS;
    protected String userLabel;
    @OneToOne(cascade={CascadeType.ALL})
    protected SourceT source;
    protected String owner;
    @OneToOne(cascade={CascadeType.ALL})
    protected AliasNameListT aliasNameList;
    @OneToOne(cascade={CascadeType.ALL})
    protected ResourceStateT resourceState;
    protected String subnetworkType;
    @OneToOne(cascade={CascadeType.ALL})
    protected LayerRateListT supportedRates;
    protected String networkAccessDomain;
    @XmlTransient
    @Transient
    protected MLSVendorExtensionsT vendorExtensions;
    @XmlElement(name="vendorExtensions")
    private String vendorExtensionsS;
    @XmlAttribute
    protected String extAuthor;
    @XmlAttribute
    protected String extVersion;
    @XmlAttribute
    protected String tmf854Version;
    
    
    /**
     * Gets the value of the discoveredName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDiscoveredName() {
        return discoveredName;
    }
    
    /**
     * Sets the value of the discoveredName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDiscoveredName(String value) {
        this.discoveredName = value;
    }
    
    /**
     * Gets the value of the namingOS property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNamingOS() {
        return namingOS;
    }
    
    /**
     * Sets the value of the namingOS property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNamingOS(String value) {
        this.namingOS = value;
    }
    
    /**
     * Gets the value of the userLabel property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUserLabel() {
        return userLabel;
    }
    
    /**
     * Sets the value of the userLabel property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUserLabel(String value) {
        this.userLabel = value;
    }
    
    /**
     * Gets the value of the source property.
     *
     * @return
     *     possible object is
     *     {@link SourceT }
     *
     */
    public SourceT getSource() {
        return source;
    }
    
    /**
     * Sets the value of the source property.
     *
     * @param value
     *     allowed object is
     *     {@link SourceT }
     *
     */
    public void setSource(SourceT value) {
        this.source = value;
    }
    
    /**
     * Gets the value of the owner property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOwner() {
        return owner;
    }
    
    /**
     * Sets the value of the owner property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOwner(String value) {
        this.owner = value;
    }
    
    /**
     * Gets the value of the aliasNameList property.
     *
     * @return
     *     possible object is
     *     {@link AliasNameListT }
     *
     */
    public AliasNameListT getAliasNameList() {
        return aliasNameList;
    }
    
    /**
     * Sets the value of the aliasNameList property.
     *
     * @param value
     *     allowed object is
     *     {@link AliasNameListT }
     *
     */
    public void setAliasNameList(AliasNameListT value) {
        this.aliasNameList = value;
    }
    
    /**
     * Gets the value of the resourceState property.
     *
     * @return
     *     possible object is
     *     {@link ResourceStateT }
     *
     */
    public ResourceStateT getResourceState() {
        return resourceState;
    }
    
    /**
     * Sets the value of the resourceState property.
     *
     * @param value
     *     allowed object is
     *     {@link ResourceStateT }
     *
     */
    public void setResourceState(ResourceStateT value) {
        this.resourceState = value;
    }
    
    /**
     * Gets the value of the subnetworkType property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSubnetworkType() {
        return subnetworkType;
    }
    
    /**
     * Sets the value of the subnetworkType property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSubnetworkType(String value) {
        this.subnetworkType = value;
    }
    
    /**
     * Gets the value of the supportedRates property.
     *
     * @return
     *     possible object is
     *     {@link LayerRateListT }
     *
     */
    public LayerRateListT getSupportedRates() {
        return supportedRates;
    }
    
    /**
     * Sets the value of the supportedRates property.
     *
     * @param value
     *     allowed object is
     *     {@link LayerRateListT }
     *
     */
    public void setSupportedRates(LayerRateListT value) {
        this.supportedRates = value;
    }
    
    /**
     * Gets the value of the networkAccessDomain property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNetworkAccessDomain() {
        return networkAccessDomain;
    }
    
    /**
     * Sets the value of the networkAccessDomain property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNetworkAccessDomain(String value) {
        this.networkAccessDomain = value;
    }
    
    /**
     * Gets the value of the vendorExtensions property.
     *
     * @return
     *     possible object is
     *     {@link MLSVendorExtensionsT }
     *
     */
    public MLSVendorExtensionsT getVendorExtensions() {
        return vendorExtensions;
    }
    
    /**
     * Sets the value of the vendorExtensions property.
     *
     * @param value
     *     allowed object is
     *     {@link MLSVendorExtensionsT }
     *
     */
    public void setVendorExtensions(MLSVendorExtensionsT value) {
        this.vendorExtensions = value;
    }
    
    /**
     * Gets the value of the extAuthor property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getExtAuthor() {
        return extAuthor;
    }
    
    /**
     * Sets the value of the extAuthor property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setExtAuthor(String value) {
        this.extAuthor = value;
    }
    
    /**
     * Gets the value of the extVersion property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getExtVersion() {
        return extVersion;
    }
    
    /**
     * Sets the value of the extVersion property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setExtVersion(String value) {
        this.extVersion = value;
    }
    
    /**
     * Gets the value of the tmf854Version property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTmf854Version() {
        return tmf854Version;
    }
    
    /**
     * Sets the value of the tmf854Version property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTmf854Version(String value) {
        this.tmf854Version = value;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public MLSNInventoryT getMlsnInventoryT() {
        return mlsnInventoryT;
    }
    
    public void setMlsnInventoryT(MLSNInventoryT mlsnInventoryT) {
        this.mlsnInventoryT = mlsnInventoryT;
    }
    
    public NamingAttributesT getName() {
        return name;
    }
    
    public void setName(NamingAttributesT name) {
        this.name = name;
    }
    
    public String getVendorExtensionsS() {
        return vendorExtensionsS;
    }

    public void setVendorExtensionsS(String vendorExtensionsS) {
        this.vendorExtensionsS = vendorExtensionsS;
    }

}
