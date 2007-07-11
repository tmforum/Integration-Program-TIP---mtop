
package v1.tmf854;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
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
 * <p>Java class for FloatingTerminationPoint_T complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="FloatingTerminationPoint_T">
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
 *         &lt;element name="connectionState" type="{tmf854.v1}TPConnectionState_T" minOccurs="0"/>
 *         &lt;element name="tpMappingMode" type="{tmf854.v1}TerminationMode_T" minOccurs="0"/>
 *         &lt;element name="ingressTransmissionDescriptorName" type="{tmf854.v1}NamingAttributes_T" minOccurs="0"/>
 *         &lt;element name="egressTransmissionDescriptorName" type="{tmf854.v1}NamingAttributes_T" minOccurs="0"/>
 *         &lt;element name="transmissionParams" type="{tmf854.v1}LayeredParametersList_T" minOccurs="0"/>
 *         &lt;element name="vendorExtensions" type="{tmf854.v1}FTPVendorExtensions_T" minOccurs="0"/>
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
@XmlType(name = "FloatingTerminationPoint_T", propOrder = {
    
})
@Entity
@Table(name = "FTP")
public class FloatingTerminationPointT implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="FTP_ID")
    private Long idFTP;
     @XmlTransient
    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="NAME_FK", referencedColumnName="NAMEATT_ID")//, insertable=false, updatable=false)
    protected NamingAttributesT name;
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
    @Transient
    protected TPConnectionStateT connectionState;
    @Transient
    protected TerminationModeT tpMappingMode;
    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="ITDNM_FK", referencedColumnName="NAMEATT_ID")
    protected NamingAttributesT ingressTransmissionDescriptorName;
    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="ETDNM_FK", referencedColumnName="NAMEATT_ID")
    protected NamingAttributesT egressTransmissionDescriptorName;
    @Transient
    protected LayeredParametersListT transmissionParams;
    @Transient
    protected FTPVendorExtensionsT vendorExtensions;
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
     * Gets the value of the connectionState property.
     *
     * @return
     *     possible object is
     *     {@link TPConnectionStateT }
     *
     */
    public TPConnectionStateT getConnectionState() {
        return connectionState;
    }
    
    /**
     * Sets the value of the connectionState property.
     *
     * @param value
     *     allowed object is
     *     {@link TPConnectionStateT }
     *
     */
    public void setConnectionState(TPConnectionStateT value) {
        this.connectionState = value;
    }
    
    /**
     * Gets the value of the tpMappingMode property.
     *
     * @return
     *     possible object is
     *     {@link TerminationModeT }
     *
     */
    public TerminationModeT getTpMappingMode() {
        return tpMappingMode;
    }
    
    /**
     * Sets the value of the tpMappingMode property.
     *
     * @param value
     *     allowed object is
     *     {@link TerminationModeT }
     *
     */
    public void setTpMappingMode(TerminationModeT value) {
        this.tpMappingMode = value;
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
     * Gets the value of the vendorExtensions property.
     *
     * @return
     *     possible object is
     *     {@link FTPVendorExtensionsT }
     *
     */
    public FTPVendorExtensionsT getVendorExtensions() {
        return vendorExtensions;
    }
    
    /**
     * Sets the value of the vendorExtensions property.
     *
     * @param value
     *     allowed object is
     *     {@link FTPVendorExtensionsT }
     *
     */
    public void setVendorExtensions(FTPVendorExtensionsT value) {
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
    
    public Long getIdFTP() {
        return idFTP;
    }
    
    public void setIdFTP(Long idFTP) {
        this.idFTP = idFTP;
    }
    
}
