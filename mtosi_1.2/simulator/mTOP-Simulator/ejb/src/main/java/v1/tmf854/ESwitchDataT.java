
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
 * <p>Java class for ESwitchData_T complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ESwitchData_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="eProtectionGroupType" type="{tmf854.v1}EProtectionGroupType_T"/>
 *         &lt;element name="eSwitchReason" type="{tmf854.v1}ESwitchReason_T"/>
 *         &lt;element name="ePGPName" type="{tmf854.v1}NamingAttributes_T"/>
 *         &lt;element name="protectedE" type="{tmf854.v1}NamingAttributes_T"/>
 *         &lt;element name="switchToE" type="{tmf854.v1}NamingAttributes_T"/>
 *         &lt;element name="vendorExtensions" type="{tmf854.v1}ESwitchDataExtensions_T" minOccurs="0"/>
 *       &lt;/sequence>
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
@XmlType(name = "ESwitchData_T", propOrder = {
    "eProtectionGroupType",
    "eSwitchReason",
    "epgpName",
    "protectedE",
    "switchToE",
    "vendorExtensions"
})
public class ESwitchDataT {

    @XmlElement(required = true, nillable = true)
    protected String eProtectionGroupType;
    @XmlElement(required = true, nillable = true)
    protected String eSwitchReason;
    @XmlElement(name = "ePGPName", required = true, nillable = true)
    protected NamingAttributesT epgpName;
    @XmlElement(required = true, nillable = true)
    protected NamingAttributesT protectedE;
    @XmlElement(required = true, nillable = true)
    protected NamingAttributesT switchToE;
    @XmlElement(nillable = true)
    protected ESwitchDataExtensionsT vendorExtensions;
    @XmlAttribute
    protected String extAuthor;
    @XmlAttribute
    protected String extVersion;
    @XmlAttribute
    protected String tmf854Version;

    /**
     * Gets the value of the eProtectionGroupType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEProtectionGroupType() {
        return eProtectionGroupType;
    }

    /**
     * Sets the value of the eProtectionGroupType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEProtectionGroupType(String value) {
        this.eProtectionGroupType = value;
    }

    /**
     * Gets the value of the eSwitchReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getESwitchReason() {
        return eSwitchReason;
    }

    /**
     * Sets the value of the eSwitchReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setESwitchReason(String value) {
        this.eSwitchReason = value;
    }

    /**
     * Gets the value of the epgpName property.
     * 
     * @return
     *     possible object is
     *     {@link NamingAttributesT }
     *     
     */
    public NamingAttributesT getEPGPName() {
        return epgpName;
    }

    /**
     * Sets the value of the epgpName property.
     * 
     * @param value
     *     allowed object is
     *     {@link NamingAttributesT }
     *     
     */
    public void setEPGPName(NamingAttributesT value) {
        this.epgpName = value;
    }

    /**
     * Gets the value of the protectedE property.
     * 
     * @return
     *     possible object is
     *     {@link NamingAttributesT }
     *     
     */
    public NamingAttributesT getProtectedE() {
        return protectedE;
    }

    /**
     * Sets the value of the protectedE property.
     * 
     * @param value
     *     allowed object is
     *     {@link NamingAttributesT }
     *     
     */
    public void setProtectedE(NamingAttributesT value) {
        this.protectedE = value;
    }

    /**
     * Gets the value of the switchToE property.
     * 
     * @return
     *     possible object is
     *     {@link NamingAttributesT }
     *     
     */
    public NamingAttributesT getSwitchToE() {
        return switchToE;
    }

    /**
     * Sets the value of the switchToE property.
     * 
     * @param value
     *     allowed object is
     *     {@link NamingAttributesT }
     *     
     */
    public void setSwitchToE(NamingAttributesT value) {
        this.switchToE = value;
    }

    /**
     * Gets the value of the vendorExtensions property.
     * 
     * @return
     *     possible object is
     *     {@link ESwitchDataExtensionsT }
     *     
     */
    public ESwitchDataExtensionsT getVendorExtensions() {
        return vendorExtensions;
    }

    /**
     * Sets the value of the vendorExtensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ESwitchDataExtensionsT }
     *     
     */
    public void setVendorExtensions(ESwitchDataExtensionsT value) {
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
