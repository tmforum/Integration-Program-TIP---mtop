
package v1.tmf854;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         The data structure of the Operations System as returned in inventory report.
 *         Refer to the InventoryLayout supporting document.
 *       
 * 
 * <p>Java class for OS_Inventory_T complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OS_Inventory_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="osNm" type="{tmf854.v1}NameValue_T" minOccurs="0"/>
 *         &lt;element name="osAttrs" type="{tmf854.v1}OperationsSystem_T" minOccurs="0"/>
 *         &lt;element name="subordinateOSNameList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="osNm" type="{tmf854.v1}NameValue_T" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="supportedMDNameList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="mdNm" type="{tmf854.v1}NameValue_T" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="qualityIndicator" type="{tmf854.v1}DataQualityIndicator_T" minOccurs="0"/>
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
@XmlType(name = "OS_Inventory_T", propOrder = {

})
public class OSInventoryT {

    protected String osNm;
    protected OperationsSystemT osAttrs;
    protected OSInventoryT.SubordinateOSNameList subordinateOSNameList;
    protected OSInventoryT.SupportedMDNameList supportedMDNameList;
    protected DataQualityIndicatorT qualityIndicator;
    @XmlAttribute
    protected String extAuthor;
    @XmlAttribute
    protected String extVersion;
    @XmlAttribute
    protected String tmf854Version;

    /**
     * Gets the value of the osNm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOsNm() {
        return osNm;
    }

    /**
     * Sets the value of the osNm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOsNm(String value) {
        this.osNm = value;
    }

    /**
     * Gets the value of the osAttrs property.
     * 
     * @return
     *     possible object is
     *     {@link OperationsSystemT }
     *     
     */
    public OperationsSystemT getOsAttrs() {
        return osAttrs;
    }

    /**
     * Sets the value of the osAttrs property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationsSystemT }
     *     
     */
    public void setOsAttrs(OperationsSystemT value) {
        this.osAttrs = value;
    }

    /**
     * Gets the value of the subordinateOSNameList property.
     * 
     * @return
     *     possible object is
     *     {@link OSInventoryT.SubordinateOSNameList }
     *     
     */
    public OSInventoryT.SubordinateOSNameList getSubordinateOSNameList() {
        return subordinateOSNameList;
    }

    /**
     * Sets the value of the subordinateOSNameList property.
     * 
     * @param value
     *     allowed object is
     *     {@link OSInventoryT.SubordinateOSNameList }
     *     
     */
    public void setSubordinateOSNameList(OSInventoryT.SubordinateOSNameList value) {
        this.subordinateOSNameList = value;
    }

    /**
     * Gets the value of the supportedMDNameList property.
     * 
     * @return
     *     possible object is
     *     {@link OSInventoryT.SupportedMDNameList }
     *     
     */
    public OSInventoryT.SupportedMDNameList getSupportedMDNameList() {
        return supportedMDNameList;
    }

    /**
     * Sets the value of the supportedMDNameList property.
     * 
     * @param value
     *     allowed object is
     *     {@link OSInventoryT.SupportedMDNameList }
     *     
     */
    public void setSupportedMDNameList(OSInventoryT.SupportedMDNameList value) {
        this.supportedMDNameList = value;
    }

    /**
     * Gets the value of the qualityIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link DataQualityIndicatorT }
     *     
     */
    public DataQualityIndicatorT getQualityIndicator() {
        return qualityIndicator;
    }

    /**
     * Sets the value of the qualityIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataQualityIndicatorT }
     *     
     */
    public void setQualityIndicator(DataQualityIndicatorT value) {
        this.qualityIndicator = value;
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


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="osNm" type="{tmf854.v1}NameValue_T" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "osNm"
    })
    public static class SubordinateOSNameList {

        @XmlElement(required = true)
        protected List<String> osNm;

        /**
         * Gets the value of the osNm property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the osNm property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOsNm().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getOsNm() {
            if (osNm == null) {
                osNm = new ArrayList<String>();
            }
            return this.osNm;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="mdNm" type="{tmf854.v1}NameValue_T" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "mdNm"
    })
    public static class SupportedMDNameList {

        @XmlElement(required = true)
        protected List<String> mdNm;

        /**
         * Gets the value of the mdNm property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the mdNm property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMdNm().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getMdNm() {
            if (mdNm == null) {
                mdNm = new ArrayList<String>();
            }
            return this.mdNm;
        }

    }

}
