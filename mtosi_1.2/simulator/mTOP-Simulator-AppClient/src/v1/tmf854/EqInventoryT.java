
package v1.tmf854;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eqInventoryT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="eqInventoryT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="eqAttrs" type="{tmf854.v1}Equipment_T" minOccurs="0"/>
 *         &lt;element name="eqNm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="extAuthor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="extVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tmf854Version" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eqInventoryT", propOrder = {
    "eqAttrs",
    "eqNm",
    "extAuthor",
    "extVersion",
    "tmf854Version"
})
public class EqInventoryT {

    protected EquipmentT eqAttrs;
    protected String eqNm;
    protected String extAuthor;
    protected String extVersion;
    protected String tmf854Version;

    /**
     * Gets the value of the eqAttrs property.
     * 
     * @return
     *     possible object is
     *     {@link EquipmentT }
     *     
     */
    public EquipmentT getEqAttrs() {
        return eqAttrs;
    }

    /**
     * Sets the value of the eqAttrs property.
     * 
     * @param value
     *     allowed object is
     *     {@link EquipmentT }
     *     
     */
    public void setEqAttrs(EquipmentT value) {
        this.eqAttrs = value;
    }

    /**
     * Gets the value of the eqNm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEqNm() {
        return eqNm;
    }

    /**
     * Sets the value of the eqNm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEqNm(String value) {
        this.eqNm = value;
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
