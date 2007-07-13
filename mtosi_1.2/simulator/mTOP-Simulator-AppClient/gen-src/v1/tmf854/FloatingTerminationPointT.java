
package v1.tmf854;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="discoveredName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="namingOS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="source" type="{tmf854.v1}Source_T" minOccurs="0"/>
 *         &lt;element name="owner" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="aliasNameList" type="{tmf854.v1}AliasNameList_T" minOccurs="0"/>
 *         &lt;element name="resourceState" type="{tmf854.v1}ResourceState_T" minOccurs="0"/>
 *         &lt;element name="direction" type="{tmf854.v1}directionalityT" minOccurs="0"/>
 *         &lt;element name="tpProtectionAssociation" type="{tmf854.v1}tpProtectionAssociationT" minOccurs="0"/>
 *         &lt;element name="edgePoint" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="networkAccessDomain" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="equipmentProtected" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="egressTMDState" type="{tmf854.v1}tmdStateT" minOccurs="0"/>
 *         &lt;element name="ingressTMDState" type="{tmf854.v1}tmdStateT" minOccurs="0"/>
 *         &lt;element name="connectionState" type="{tmf854.v1}tpConnectionStateT" minOccurs="0"/>
 *         &lt;element name="tpMappingMode" type="{tmf854.v1}terminationModeT" minOccurs="0"/>
 *         &lt;element name="ingressTransmissionDescriptorName" type="{tmf854.v1}namingAttributesT" minOccurs="0"/>
 *         &lt;element name="egressTransmissionDescriptorName" type="{tmf854.v1}namingAttributesT" minOccurs="0"/>
 *         &lt;element name="transmissionParams" type="{tmf854.v1}LayeredParametersList_T" minOccurs="0"/>
 *         &lt;element name="vendorExtensions" type="{tmf854.v1}FTPVendorExtensions_T" minOccurs="0"/>
 *         &lt;element name="extAuthor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="extVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tmf854Version" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
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
public class FloatingTerminationPointT {

    protected String discoveredName;
    protected String namingOS;
    protected String userLabel;
    protected SourceT source;
    protected String owner;
    protected AliasNameListT aliasNameList;
    protected ResourceStateT resourceState;
    protected DirectionalityT direction;
    protected TpProtectionAssociationT tpProtectionAssociation;
    protected Boolean edgePoint;
    protected String networkAccessDomain;
    protected Boolean equipmentProtected;
    protected TmdStateT egressTMDState;
    protected TmdStateT ingressTMDState;
    protected TpConnectionStateT connectionState;
    protected TerminationModeT tpMappingMode;
    protected NamingAttributesT ingressTransmissionDescriptorName;
    protected NamingAttributesT egressTransmissionDescriptorName;
    protected LayeredParametersListT transmissionParams;
    protected FTPVendorExtensionsT vendorExtensions;
    protected String extAuthor;
    protected String extVersion;
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
     *     {@link TpProtectionAssociationT }
     *     
     */
    public TpProtectionAssociationT getTpProtectionAssociation() {
        return tpProtectionAssociation;
    }

    /**
     * Sets the value of the tpProtectionAssociation property.
     * 
     * @param value
     *     allowed object is
     *     {@link TpProtectionAssociationT }
     *     
     */
    public void setTpProtectionAssociation(TpProtectionAssociationT value) {
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
     *     {@link TmdStateT }
     *     
     */
    public TmdStateT getEgressTMDState() {
        return egressTMDState;
    }

    /**
     * Sets the value of the egressTMDState property.
     * 
     * @param value
     *     allowed object is
     *     {@link TmdStateT }
     *     
     */
    public void setEgressTMDState(TmdStateT value) {
        this.egressTMDState = value;
    }

    /**
     * Gets the value of the ingressTMDState property.
     * 
     * @return
     *     possible object is
     *     {@link TmdStateT }
     *     
     */
    public TmdStateT getIngressTMDState() {
        return ingressTMDState;
    }

    /**
     * Sets the value of the ingressTMDState property.
     * 
     * @param value
     *     allowed object is
     *     {@link TmdStateT }
     *     
     */
    public void setIngressTMDState(TmdStateT value) {
        this.ingressTMDState = value;
    }

    /**
     * Gets the value of the connectionState property.
     * 
     * @return
     *     possible object is
     *     {@link TpConnectionStateT }
     *     
     */
    public TpConnectionStateT getConnectionState() {
        return connectionState;
    }

    /**
     * Sets the value of the connectionState property.
     * 
     * @param value
     *     allowed object is
     *     {@link TpConnectionStateT }
     *     
     */
    public void setConnectionState(TpConnectionStateT value) {
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

}
