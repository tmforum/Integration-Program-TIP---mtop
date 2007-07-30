
package v1.tmf854;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * This structure is used to respond to queries regarding the current protection switch status of an equipment protection group.
 *       	
 * 
 * <p>Java class for SwitchData_T complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SwitchData_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="protectionType" type="{tmf854.v1}ProtectionType_T"/>
 *         &lt;element name="SwitchReason" type="{tmf854.v1}SwitchReason_T"/>
 *         &lt;element name="layerRate" type="{tmf854.v1}LayerRate_T"/>
 *         &lt;element name="groupName" type="{tmf854.v1}NamingAttributes_T"/>
 *         &lt;element name="protectedTP" type="{tmf854.v1}NamingAttributes_T"/>
 *         &lt;element name="switchToTP" type="{tmf854.v1}NamingAttributes_T"/>
 *         &lt;element name="vendorExtensions" type="{tmf854.v1}SwitchDataExtensions_T" minOccurs="0"/>
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
@XmlType(name = "SwitchData_T", propOrder = {

})
public class SwitchDataT {

    @XmlElement(required = true, nillable = true)
    protected String protectionType;
    @XmlElement(name = "SwitchReason", required = true, nillable = true)
    protected String switchReason;
    @XmlElement(required = true, nillable = true)
    protected String layerRate;
    @XmlElement(required = true, nillable = true)
    protected NamingAttributesT groupName;
    @XmlElement(required = true, nillable = true)
    protected NamingAttributesT protectedTP;
    @XmlElement(required = true, nillable = true)
    protected NamingAttributesT switchToTP;
    @XmlElement(nillable = true)
    protected SwitchDataExtensionsT vendorExtensions;
    @XmlAttribute
    protected String extAuthor;
    @XmlAttribute
    protected String extVersion;
    @XmlAttribute
    protected String tmf854Version;

    /**
     * Gets the value of the protectionType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProtectionType() {
        return protectionType;
    }

    /**
     * Sets the value of the protectionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProtectionType(String value) {
        this.protectionType = value;
    }

    /**
     * Gets the value of the switchReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSwitchReason() {
        return switchReason;
    }

    /**
     * Sets the value of the switchReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSwitchReason(String value) {
        this.switchReason = value;
    }

    /**
     * Gets the value of the layerRate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLayerRate() {
        return layerRate;
    }

    /**
     * Sets the value of the layerRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLayerRate(String value) {
        this.layerRate = value;
    }

    /**
     * Gets the value of the groupName property.
     * 
     * @return
     *     possible object is
     *     {@link NamingAttributesT }
     *     
     */
    public NamingAttributesT getGroupName() {
        return groupName;
    }

    /**
     * Sets the value of the groupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link NamingAttributesT }
     *     
     */
    public void setGroupName(NamingAttributesT value) {
        this.groupName = value;
    }

    /**
     * Gets the value of the protectedTP property.
     * 
     * @return
     *     possible object is
     *     {@link NamingAttributesT }
     *     
     */
    public NamingAttributesT getProtectedTP() {
        return protectedTP;
    }

    /**
     * Sets the value of the protectedTP property.
     * 
     * @param value
     *     allowed object is
     *     {@link NamingAttributesT }
     *     
     */
    public void setProtectedTP(NamingAttributesT value) {
        this.protectedTP = value;
    }

    /**
     * Gets the value of the switchToTP property.
     * 
     * @return
     *     possible object is
     *     {@link NamingAttributesT }
     *     
     */
    public NamingAttributesT getSwitchToTP() {
        return switchToTP;
    }

    /**
     * Sets the value of the switchToTP property.
     * 
     * @param value
     *     allowed object is
     *     {@link NamingAttributesT }
     *     
     */
    public void setSwitchToTP(NamingAttributesT value) {
        this.switchToTP = value;
    }

    /**
     * Gets the value of the vendorExtensions property.
     * 
     * @return
     *     possible object is
     *     {@link SwitchDataExtensionsT }
     *     
     */
    public SwitchDataExtensionsT getVendorExtensions() {
        return vendorExtensions;
    }

    /**
     * Sets the value of the vendorExtensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link SwitchDataExtensionsT }
     *     
     */
    public void setVendorExtensions(SwitchDataExtensionsT value) {
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
