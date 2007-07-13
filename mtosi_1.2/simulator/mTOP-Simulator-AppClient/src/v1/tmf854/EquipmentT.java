
package v1.tmf854;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Equipment_T complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Equipment_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="eqInventoryT" type="{tmf854.v1}eqInventoryT" minOccurs="0"/>
 *         &lt;element name="discoveredName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="namingOS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="source" type="{tmf854.v1}Source_T" minOccurs="0"/>
 *         &lt;element name="owner" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="aliasNameList" type="{tmf854.v1}AliasNameList_T" minOccurs="0"/>
 *         &lt;element name="resourceState" type="{tmf854.v1}ResourceState_T" minOccurs="0"/>
 *         &lt;element name="alarmReportingIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="expectedEquipmentObjectType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="installedEquipmentObjectType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="installedPartNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="installedSerialNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serviceState" type="{tmf854.v1}ServiceState_T" minOccurs="0"/>
 *         &lt;element name="installedVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="manufacturer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="manufacturerDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vendorExtensions" type="{tmf854.v1}EqVendorExtensions_T" minOccurs="0"/>
 *         &lt;element name="src" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="resrcState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="extAuthor" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="extVersion" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="tmf854Version" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Equipment_T", propOrder = {

})
public class EquipmentT {

    protected EqInventoryT eqInventoryT;
    protected String discoveredName;
    protected String namingOS;
    protected String userLabel;
    protected SourceT source;
    protected String owner;
    protected AliasNameListT aliasNameList;
    protected ResourceStateT resourceState;
    protected Boolean alarmReportingIndicator;
    protected String expectedEquipmentObjectType;
    protected String installedEquipmentObjectType;
    protected String installedPartNumber;
    protected String installedSerialNumber;
    protected ServiceStateT serviceState;
    protected String installedVersion;
    protected String manufacturer;
    protected String manufacturerDate;
    protected EqVendorExtensionsT vendorExtensions;
    protected String src;
    protected String resrcState;
    @XmlAttribute
    protected String extAuthor;
    @XmlAttribute
    protected String extVersion;
    @XmlAttribute
    protected String tmf854Version;

    /**
     * Gets the value of the eqInventoryT property.
     * 
     * @return
     *     possible object is
     *     {@link EqInventoryT }
     *     
     */
    public EqInventoryT getEqInventoryT() {
        return eqInventoryT;
    }

    /**
     * Sets the value of the eqInventoryT property.
     * 
     * @param value
     *     allowed object is
     *     {@link EqInventoryT }
     *     
     */
    public void setEqInventoryT(EqInventoryT value) {
        this.eqInventoryT = value;
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
     * Gets the value of the expectedEquipmentObjectType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpectedEquipmentObjectType() {
        return expectedEquipmentObjectType;
    }

    /**
     * Sets the value of the expectedEquipmentObjectType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpectedEquipmentObjectType(String value) {
        this.expectedEquipmentObjectType = value;
    }

    /**
     * Gets the value of the installedEquipmentObjectType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstalledEquipmentObjectType() {
        return installedEquipmentObjectType;
    }

    /**
     * Sets the value of the installedEquipmentObjectType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstalledEquipmentObjectType(String value) {
        this.installedEquipmentObjectType = value;
    }

    /**
     * Gets the value of the installedPartNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstalledPartNumber() {
        return installedPartNumber;
    }

    /**
     * Sets the value of the installedPartNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstalledPartNumber(String value) {
        this.installedPartNumber = value;
    }

    /**
     * Gets the value of the installedSerialNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstalledSerialNumber() {
        return installedSerialNumber;
    }

    /**
     * Sets the value of the installedSerialNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstalledSerialNumber(String value) {
        this.installedSerialNumber = value;
    }

    /**
     * Gets the value of the serviceState property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceStateT }
     *     
     */
    public ServiceStateT getServiceState() {
        return serviceState;
    }

    /**
     * Sets the value of the serviceState property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceStateT }
     *     
     */
    public void setServiceState(ServiceStateT value) {
        this.serviceState = value;
    }

    /**
     * Gets the value of the installedVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstalledVersion() {
        return installedVersion;
    }

    /**
     * Sets the value of the installedVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstalledVersion(String value) {
        this.installedVersion = value;
    }

    /**
     * Gets the value of the manufacturer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Sets the value of the manufacturer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManufacturer(String value) {
        this.manufacturer = value;
    }

    /**
     * Gets the value of the manufacturerDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManufacturerDate() {
        return manufacturerDate;
    }

    /**
     * Sets the value of the manufacturerDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManufacturerDate(String value) {
        this.manufacturerDate = value;
    }

    /**
     * Gets the value of the vendorExtensions property.
     * 
     * @return
     *     possible object is
     *     {@link EqVendorExtensionsT }
     *     
     */
    public EqVendorExtensionsT getVendorExtensions() {
        return vendorExtensions;
    }

    /**
     * Sets the value of the vendorExtensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link EqVendorExtensionsT }
     *     
     */
    public void setVendorExtensions(EqVendorExtensionsT value) {
        this.vendorExtensions = value;
    }

    /**
     * Gets the value of the src property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrc() {
        return src;
    }

    /**
     * Sets the value of the src property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrc(String value) {
        this.src = value;
    }

    /**
     * Gets the value of the resrcState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResrcState() {
        return resrcState;
    }

    /**
     * Sets the value of the resrcState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResrcState(String value) {
        this.resrcState = value;
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
