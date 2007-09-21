
package v1.tmf854;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;
/**
 * <p>Java class for PhysicalTerminationPoint_T complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PhysicalTerminationPoint_T">
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
 *         &lt;element name="direction" type="{tmf854.v1}Directionality_T" minOccurs="0"/>
 *         &lt;element name="tpProtectionAssociation" type="{tmf854.v1}TPProtectionAssociation_T" minOccurs="0"/>
 *         &lt;element name="edgePoint" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="networkAccessDomain" type="{tmf854.v1}NetworkAccessDomain_T" minOccurs="0"/>
 *         &lt;element name="equipmentProtected" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="egressTMDState" type="{tmf854.v1}TMDState_T" minOccurs="0"/>
 *         &lt;element name="ingressTMDState" type="{tmf854.v1}TMDState_T" minOccurs="0"/>
 *         &lt;element name="ingressTransmissionDescriptorName" type="{tmf854.v1}NamingAttributes_T" minOccurs="0"/>
 *         &lt;element name="egressTransmissionDescriptorName" type="{tmf854.v1}NamingAttributes_T" minOccurs="0"/>
 *         &lt;element name="transmissionParams" type="{tmf854.v1}LayeredParametersList_T" minOccurs="0"/>
 *         &lt;element name="vendorExtensions" type="{tmf854.v1}PTPVendorExtensions_T" minOccurs="0"/>
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
@XmlType(name = "PhysicalTerminationPoint_T", propOrder = {
    
})
@Entity
public class PhysicalTerminationPointT implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @XmlTransient
    @OneToOne(cascade={CascadeType.ALL})
    protected NamingAttributesT name;
    @XmlTransient
    @OneToOne(cascade={CascadeType.ALL})
    private PTPInventoryT ptpInventoryT;
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
    @Enumerated(EnumType.STRING)
    protected DirectionalityT direction;
    @Enumerated(EnumType.STRING)
    protected TPProtectionAssociationT tpProtectionAssociation;
    protected Boolean edgePoint;
    protected String networkAccessDomain;
    protected Boolean equipmentProtected;
    @Enumerated(EnumType.STRING)
    protected TMDStateT egressTMDState;
    @Enumerated(EnumType.STRING)
    protected TMDStateT ingressTMDState;
    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="itdnm_fk")
    protected NamingAttributesT ingressTransmissionDescriptorName;
    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="etdnm_fk")
    protected NamingAttributesT egressTransmissionDescriptorName;
    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="transParams")
    protected LayeredParametersListT transmissionParams;
    @Transient
    protected PTPVendorExtensionsT vendorExtensions;
    protected String vendorExtensionsS;
    protected String extAuthor;
    protected String extVersion;
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
     * Gets the value of the direction property.
     *
     * @return
     *     possible object is
     *     {@link DirectionalityT }
     *
     */
    public DirectionalityT getDirection() {
        return direction;
    }
    
    /**
     * Sets the value of the direction property.
     *
     * @param value
     *     allowed object is
     *     {@link DirectionalityT }
     *
     */
    public void setDirection(DirectionalityT value) {
        this.direction = value;
    }
    
    /**
     * Gets the value of the tpProtectionAssociation property.
     *
     * @return
     *     possible object is
     *     {@link TPProtectionAssociationT }
     *
     */
    public TPProtectionAssociationT getTpProtectionAssociation() {
        return tpProtectionAssociation;
    }
    
    /**
     * Sets the value of the tpProtectionAssociation property.
     *
     * @param value
     *     allowed object is
     *     {@link TPProtectionAssociationT }
     *
     */
    public void setTpProtectionAssociation(TPProtectionAssociationT value) {
        this.tpProtectionAssociation = value;
    }
    
    /**
     * Gets the value of the edgePoint property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean isEdgePoint() {
        return edgePoint;
    }
    
    /**
     * Sets the value of the edgePoint property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setEdgePoint(Boolean value) {
        this.edgePoint = value;
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
     * Gets the value of the equipmentProtected property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean isEquipmentProtected() {
        return equipmentProtected;
    }
    
    /**
     * Sets the value of the equipmentProtected property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setEquipmentProtected(Boolean value) {
        this.equipmentProtected = value;
    }
    
    /**
     * Gets the value of the egressTMDState property.
     *
     * @return
     *     possible object is
     *     {@link TMDStateT }
     *
     */
    public TMDStateT getEgressTMDState() {
        return egressTMDState;
    }
    
    /**
     * Sets the value of the egressTMDState property.
     *
     * @param value
     *     allowed object is
     *     {@link TMDStateT }
     *
     */
    public void setEgressTMDState(TMDStateT value) {
        this.egressTMDState = value;
    }
    
    /**
     * Gets the value of the ingressTMDState property.
     *
     * @return
     *     possible object is
     *     {@link TMDStateT }
     *
     */
    public TMDStateT getIngressTMDState() {
        return ingressTMDState;
    }
    
    /**
     * Sets the value of the ingressTMDState property.
     *
     * @param value
     *     allowed object is
     *     {@link TMDStateT }
     *
     */
    public void setIngressTMDState(TMDStateT value) {
        this.ingressTMDState = value;
    }
    
    /**
     * Gets the value of the ingressTransmissionDescriptorName property.
     *
     * @return
     *     possible object is
     *     {@link NamingAttributesT }
     *
     */
    public NamingAttributesT getIngressTransmissionDescriptorName() {
        return ingressTransmissionDescriptorName;
    }
    
    /**
     * Sets the value of the ingressTransmissionDescriptorName property.
     *
     * @param value
     *     allowed object is
     *     {@link NamingAttributesT }
     *
     */
    public void setIngressTransmissionDescriptorName(NamingAttributesT value) {
        this.ingressTransmissionDescriptorName = value;
    }
    
    /**
     * Gets the value of the egressTransmissionDescriptorName property.
     *
     * @return
     *     possible object is
     *     {@link NamingAttributesT }
     *
     */
    public NamingAttributesT getEgressTransmissionDescriptorName() {
        return egressTransmissionDescriptorName;
    }
    
    /**
     * Sets the value of the egressTransmissionDescriptorName property.
     *
     * @param value
     *     allowed object is
     *     {@link NamingAttributesT }
     *
     */
    public void setEgressTransmissionDescriptorName(NamingAttributesT value) {
        this.egressTransmissionDescriptorName = value;
    }
    
    
    /**
     * Gets the value of the vendorExtensions property.
     *
     * @return
     *     possible object is
     *     {@link PTPVendorExtensionsT }
     *
     */
    public PTPVendorExtensionsT getVendorExtensions() {
        return vendorExtensions;
    }
    
    /**
     * Sets the value of the vendorExtensions property.
     *
     * @param value
     *     allowed object is
     *     {@link PTPVendorExtensionsT }
     *
     */
    public void setVendorExtensions(PTPVendorExtensionsT value) {
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
    
    public PTPInventoryT getPtpInventoryT() {
        return ptpInventoryT;
    }
    
    public void setPtpInventoryT(PTPInventoryT ptpInventoryT) {
        this.ptpInventoryT = ptpInventoryT;
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


