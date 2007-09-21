
package v1.tmf854;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 * 
 * This aggregate defines the TransmissionDescriptor Object
 *       
 * 
 * <p>Java class for TransmissionDescriptor_T complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransmissionDescriptor_T">
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
 *         &lt;element name="transmissionParams" type="{tmf854.v1}LayeredParametersList_T" minOccurs="0"/>
 *         &lt;element name="additionalTPInfo" type="{tmf854.v1}NVSList_T" minOccurs="0"/>
 *         &lt;element name="containingTMDName" type="{tmf854.v1}NamingAttributes_T" minOccurs="0"/>
 *         &lt;element name="externalRepresentationReference" type="{tmf854.v1}ExternalRepresentationReference_T" minOccurs="0"/>
 *         &lt;element name="vendorExtensions" type="{tmf854.v1}TMDVendorExtensions_T" minOccurs="0"/>
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
@XmlType(name = "TransmissionDescriptor_T", propOrder = {

})
@Entity
public class TransmissionDescriptorT implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade={CascadeType.ALL})
    protected NamingAttributesT name;
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
    @Transient
    protected LayeredParametersListT transmissionParams;
    @XmlElement(nillable = true)
    @Transient
    protected NVSListT additionalTPInfo;
    @OneToOne(cascade={CascadeType.ALL})
    protected NamingAttributesT containingTMDName;
    @XmlElement(nillable = true)
    protected String externalRepresentationReference;
    @Transient
    protected TMDVendorExtensionsT vendorExtensions;
    @XmlAttribute
    protected String extAuthor;
    @XmlAttribute
    protected String extVersion;
    @XmlAttribute
    protected String tmf854Version;

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
     * Gets the value of the transmissionParams property.
     * 
     * @return
     *     possible object is
     *     {@link LayeredParametersListT }
     *     
     */
    public LayeredParametersListT getTransmissionParams() {
        return transmissionParams;
    }

    /**
     * Sets the value of the transmissionParams property.
     * 
     * @param value
     *     allowed object is
     *     {@link LayeredParametersListT }
     *     
     */
    public void setTransmissionParams(LayeredParametersListT value) {
        this.transmissionParams = value;
    }

    /**
     * Gets the value of the additionalTPInfo property.
     * 
     * @return
     *     possible object is
     *     {@link NVSListT }
     *     
     */
    public NVSListT getAdditionalTPInfo() {
        return additionalTPInfo;
    }

    /**
     * Sets the value of the additionalTPInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link NVSListT }
     *     
     */
    public void setAdditionalTPInfo(NVSListT value) {
        this.additionalTPInfo = value;
    }

    /**
     * Gets the value of the containingTMDName property.
     * 
     * @return
     *     possible object is
     *     {@link NamingAttributesT }
     *     
     */
    public NamingAttributesT getContainingTMDName() {
        return containingTMDName;
    }

    /**
     * Sets the value of the containingTMDName property.
     * 
     * @param value
     *     allowed object is
     *     {@link NamingAttributesT }
     *     
     */
    public void setContainingTMDName(NamingAttributesT value) {
        this.containingTMDName = value;
    }

    /**
     * Gets the value of the externalRepresentationReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalRepresentationReference() {
        return externalRepresentationReference;
    }

    /**
     * Sets the value of the externalRepresentationReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalRepresentationReference(String value) {
        this.externalRepresentationReference = value;
    }

    /**
     * Gets the value of the vendorExtensions property.
     * 
     * @return
     *     possible object is
     *     {@link TMDVendorExtensionsT }
     *     
     */
    public TMDVendorExtensionsT getVendorExtensions() {
        return vendorExtensions;
    }

    /**
     * Sets the value of the vendorExtensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link TMDVendorExtensionsT }
     *     
     */
    public void setVendorExtensions(TMDVendorExtensionsT value) {
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

}
