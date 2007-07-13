
package v1.tmf854;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SubnetworkConnection_T complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubnetworkConnection_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="name" type="{tmf854.v1}namingAttributesT" minOccurs="0"/>
 *         &lt;element name="sncInventoryT" type="{tmf854.v1}SNC_Inventory_T" minOccurs="0"/>
 *         &lt;element name="discoveredName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="namingOS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="source" type="{tmf854.v1}Source_T" minOccurs="0"/>
 *         &lt;element name="owner" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="aliasNameList" type="{tmf854.v1}AliasNameList_T" minOccurs="0"/>
 *         &lt;element name="resourceState" type="{tmf854.v1}ResourceState_T" minOccurs="0"/>
 *         &lt;element name="sncState" type="{tmf854.v1}sncStateT" minOccurs="0"/>
 *         &lt;element name="direction" type="{tmf854.v1}connectionDirectionT" minOccurs="0"/>
 *         &lt;element name="rate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="staticProtectionLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sncType" type="{tmf854.v1}sncTypeT" minOccurs="0"/>
 *         &lt;element name="aEnd" type="{tmf854.v1}TPDataList_T" minOccurs="0"/>
 *         &lt;element name="zEnd" type="{tmf854.v1}TPDataList_T" minOccurs="0"/>
 *         &lt;element name="rerouteAllowed" type="{tmf854.v1}rerouteT" minOccurs="0"/>
 *         &lt;element name="networkRouted" type="{tmf854.v1}networkRoutedT" minOccurs="0"/>
 *         &lt;element name="networkAccessDomain" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="alarmReportingIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="fixed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="vendorExtensions" type="{tmf854.v1}SNCVendorExtensions_T" minOccurs="0"/>
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
@XmlType(name = "SubnetworkConnection_T", propOrder = {

})
public class SubnetworkConnectionT {

    protected NamingAttributesT name;
    protected SNCInventoryT sncInventoryT;
    protected String discoveredName;
    protected String namingOS;
    protected String userLabel;
    protected SourceT source;
    protected String owner;
    protected AliasNameListT aliasNameList;
    protected ResourceStateT resourceState;
    protected SncStateT sncState;
    protected ConnectionDirectionT direction;
    protected String rate;
    protected String staticProtectionLevel;
    protected SncTypeT sncType;
    protected TPDataListT aEnd;
    protected TPDataListT zEnd;
    protected RerouteT rerouteAllowed;
    protected NetworkRoutedT networkRouted;
    protected String networkAccessDomain;
    protected Boolean alarmReportingIndicator;
    protected Boolean fixed;
    protected SNCVendorExtensionsT vendorExtensions;
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
     * Gets the value of the sncInventoryT property.
     * 
     * @return
     *     possible object is
     *     {@link SNCInventoryT }
     *     
     */
    public SNCInventoryT getSncInventoryT() {
        return sncInventoryT;
    }

    /**
     * Sets the value of the sncInventoryT property.
     * 
     * @param value
     *     allowed object is
     *     {@link SNCInventoryT }
     *     
     */
    public void setSncInventoryT(SNCInventoryT value) {
        this.sncInventoryT = value;
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
     * Gets the value of the sncState property.
     * 
     * @return
     *     possible object is
     *     {@link SncStateT }
     *     
     */
    public SncStateT getSncState() {
        return sncState;
    }

    /**
     * Sets the value of the sncState property.
     * 
     * @param value
     *     allowed object is
     *     {@link SncStateT }
     *     
     */
    public void setSncState(SncStateT value) {
        this.sncState = value;
    }

    /**
     * Gets the value of the direction property.
     * 
     * @return
     *     possible object is
     *     {@link ConnectionDirectionT }
     *     
     */
    public ConnectionDirectionT getDirection() {
        return direction;
    }

    /**
     * Sets the value of the direction property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConnectionDirectionT }
     *     
     */
    public void setDirection(ConnectionDirectionT value) {
        this.direction = value;
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
     * Gets the value of the staticProtectionLevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStaticProtectionLevel() {
        return staticProtectionLevel;
    }

    /**
     * Sets the value of the staticProtectionLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStaticProtectionLevel(String value) {
        this.staticProtectionLevel = value;
    }

    /**
     * Gets the value of the sncType property.
     * 
     * @return
     *     possible object is
     *     {@link SncTypeT }
     *     
     */
    public SncTypeT getSncType() {
        return sncType;
    }

    /**
     * Sets the value of the sncType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SncTypeT }
     *     
     */
    public void setSncType(SncTypeT value) {
        this.sncType = value;
    }

    /**
     * Gets the value of the aEnd property.
     * 
     * @return
     *     possible object is
     *     {@link TPDataListT }
     *     
     */
    public TPDataListT getAEnd() {
        return aEnd;
    }

    /**
     * Sets the value of the aEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPDataListT }
     *     
     */
    public void setAEnd(TPDataListT value) {
        this.aEnd = value;
    }

    /**
     * Gets the value of the zEnd property.
     * 
     * @return
     *     possible object is
     *     {@link TPDataListT }
     *     
     */
    public TPDataListT getZEnd() {
        return zEnd;
    }

    /**
     * Sets the value of the zEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPDataListT }
     *     
     */
    public void setZEnd(TPDataListT value) {
        this.zEnd = value;
    }

    /**
     * Gets the value of the rerouteAllowed property.
     * 
     * @return
     *     possible object is
     *     {@link RerouteT }
     *     
     */
    public RerouteT getRerouteAllowed() {
        return rerouteAllowed;
    }

    /**
     * Sets the value of the rerouteAllowed property.
     * 
     * @param value
     *     allowed object is
     *     {@link RerouteT }
     *     
     */
    public void setRerouteAllowed(RerouteT value) {
        this.rerouteAllowed = value;
    }

    /**
     * Gets the value of the networkRouted property.
     * 
     * @return
     *     possible object is
     *     {@link NetworkRoutedT }
     *     
     */
    public NetworkRoutedT getNetworkRouted() {
        return networkRouted;
    }

    /**
     * Sets the value of the networkRouted property.
     * 
     * @param value
     *     allowed object is
     *     {@link NetworkRoutedT }
     *     
     */
    public void setNetworkRouted(NetworkRoutedT value) {
        this.networkRouted = value;
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
     * Gets the value of the alarmReportingIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAlarmReportingIndicator() {
        return alarmReportingIndicator;
    }

    /**
     * Sets the value of the alarmReportingIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAlarmReportingIndicator(Boolean value) {
        this.alarmReportingIndicator = value;
    }

    /**
     * Gets the value of the fixed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFixed() {
        return fixed;
    }

    /**
     * Sets the value of the fixed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFixed(Boolean value) {
        this.fixed = value;
    }

    /**
     * Gets the value of the vendorExtensions property.
     * 
     * @return
     *     possible object is
     *     {@link SNCVendorExtensionsT }
     *     
     */
    public SNCVendorExtensionsT getVendorExtensions() {
        return vendorExtensions;
    }

    /**
     * Sets the value of the vendorExtensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link SNCVendorExtensionsT }
     *     
     */
    public void setVendorExtensions(SNCVendorExtensionsT value) {
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
