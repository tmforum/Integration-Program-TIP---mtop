
package v1.tmf854;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.*;
import javax.xml.bind.annotation.*;
/**
 *
 * This aggregate defines the ProtectionGroup Object
 *
 *
 * <p>Java class for ProtectionGroup_T complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ProtectionGroup_T">
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
 *         &lt;element name="protectionGroupType" type="{tmf854.v1}ProtectionGroupType_T" minOccurs="0"/>
 *         &lt;element name="protectionSchemeState" type="{tmf854.v1}ProtectionSchemeState_T" minOccurs="0"/>
 *         &lt;element name="reversionMode" type="{tmf854.v1}ReversionMode_T" minOccurs="0"/>
 *         &lt;element name="rate" type="{tmf854.v1}LayerRate_T" minOccurs="0"/>
 *         &lt;element name="pgpParameters" type="{tmf854.v1}PGPParameters_T" minOccurs="0"/>
 *         &lt;element name="pgpTPList" type="{tmf854.v1}NamingAttributesList_T" minOccurs="0"/>
 *         &lt;element name="G_774_3_APSfunction" type="{tmf854.v1}G_774_3_APSfunction_T" minOccurs="0"/>
 *         &lt;element name="vendorExtensions" type="{tmf854.v1}PGVendorExtensions_T" minOccurs="0"/>
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
@XmlType(name = "ProtectionGroup_T", propOrder = {
    
})
@Entity
@Table(name = "PGP")
public class ProtectionGroupT implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name="PGP_ID")
    private Long id;
    @XmlTransient
    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="name_")
    protected NamingAttributesT name;
    @XmlTransient
    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="pgpInv")
    private PGPInventoryT pgpInventoryT;
    protected String discoveredName;
    protected String namingOS;
    protected String userLabel;
      @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="source_")
    protected SourceT source;
    protected String owner;
    @OneToOne(cascade={CascadeType.ALL})
     @JoinColumn(name="alNl")
    protected AliasNameListT aliasNameList;
    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="rsrcstate")
    protected ResourceStateT resourceState;
    protected String protectionGroupType;
    protected String protectionSchemeState;
    @Enumerated(EnumType.STRING)
    protected ReversionModeT reversionMode;
    protected String rate;
    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="pgpPa")
    protected PGPParametersT pgpParameters;
    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="pgpTPL")
    protected NamingAttributesListT pgpTPList;
    protected String g7743APSfunction;
    @Transient
    protected PGVendorExtensionsT vendorExtensions;
    protected String extAuthor;
    protected String extVersion;
    protected String tmf854Version;
    
     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Gets the value of the name property.
     *
     * @return
     *     possible object is
     *     {@link NamingAttributesT }
     *
     */
    public NamingAttributesT getName() {
        return name;
    }
    
    /**
     * Sets the value of the name property.
     *
     * @param value
     *     allowed object is
     *     {@link NamingAttributesT }
     *
     */
    public void setName(NamingAttributesT value) {
        this.name = value;
    }
    
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
     * Gets the value of the protectionGroupType property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getProtectionGroupType() {
        return protectionGroupType;
    }
    
    /**
     * Sets the value of the protectionGroupType property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setProtectionGroupType(String value) {
        this.protectionGroupType = value;
    }
    
    /**
     * Gets the value of the protectionSchemeState property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getProtectionSchemeState() {
        return protectionSchemeState;
    }
    
    /**
     * Sets the value of the protectionSchemeState property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setProtectionSchemeState(String value) {
        this.protectionSchemeState = value;
    }
    
    /**
     * Gets the value of the reversionMode property.
     *
     * @return
     *     possible object is
     *     {@link ReversionModeT }
     *
     */
    public ReversionModeT getReversionMode() {
        return reversionMode;
    }
    
    /**
     * Sets the value of the reversionMode property.
     *
     * @param value
     *     allowed object is
     *     {@link ReversionModeT }
     *
     */
    public void setReversionMode(ReversionModeT value) {
        this.reversionMode = value;
    }
    
    /**
     * Gets the value of the rate property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRate() {
        return rate;
    }
    
    /**
     * Sets the value of the rate property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRate(String value) {
        this.rate = value;
    }
    
    /**
     * Gets the value of the pgpParameters property.
     *
     * @return
     *     possible object is
     *     {@link PGPParametersT }
     *
     */
    public PGPParametersT getPgpParameters() {
        return pgpParameters;
    }
    
    /**
     * Sets the value of the pgpParameters property.
     *
     * @param value
     *     allowed object is
     *     {@link PGPParametersT }
     *
     */
    public void setPgpParameters(PGPParametersT value) {
        this.pgpParameters = value;
    }
    
    /**
     * Gets the value of the pgpTPList property.
     *
     * @return
     *     possible object is
     *     {@link NamingAttributesListT }
     *
     */
    public NamingAttributesListT getPgpTPList() {
        return pgpTPList;
    }
    
    /**
     * Sets the value of the pgpTPList property.
     *
     * @param value
     *     allowed object is
     *     {@link NamingAttributesListT }
     *
     */
    public void setPgpTPList(NamingAttributesListT value) {
        this.pgpTPList = value;
    }
    
    /**
     * Gets the value of the g7743APSfunction property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getG7743APSfunction() {
        return g7743APSfunction;
    }
    
    /**
     * Sets the value of the g7743APSfunction property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setG7743APSfunction(String value) {
        this.g7743APSfunction = value;
    }
    
    /**
     * Gets the value of the vendorExtensions property.
     *
     * @return
     *     possible object is
     *     {@link PGVendorExtensionsT }
     *
     */
    public PGVendorExtensionsT getVendorExtensions() {
        return vendorExtensions;
    }
    
    /**
     * Sets the value of the vendorExtensions property.
     *
     * @param value
     *     allowed object is
     *     {@link PGVendorExtensionsT }
     *
     */
    public void setVendorExtensions(PGVendorExtensionsT value) {
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

    public PGPInventoryT getPgpInventoryT() {
        return pgpInventoryT;
    }

    public void setPgpInventoryT(PGPInventoryT pgpInventoryT) {
        this.pgpInventoryT = pgpInventoryT;
    }

   
    
}
