
package v1.tmf854;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

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
 * 
 * A crossConnect represents a connection within a single managed element. This structure is primarily used in the specification of routes
 *       
 * 
 * <p>Java class for CrossConnect_T complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CrossConnect_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="active" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="direction" type="{tmf854.v1}ConnectionDirection_T" minOccurs="0"/>
 *         &lt;element name="ccType" type="{tmf854.v1}SNCType_T" minOccurs="0"/>
 *         &lt;element name="aEndNameList">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="aEndName" type="{tmf854.v1}NamingAttributes_T" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="zEndNameList">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="zEndName" type="{tmf854.v1}NamingAttributes_T" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="vendorExtensions" type="{tmf854.v1}CCVendorExtensions_T" minOccurs="0"/>
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
@XmlType(name = "CrossConnect_T", propOrder = {

})
//@Entity
//@Table(name = "CC")
public class CrossConnectT  implements Serializable {
 @Id
    @XmlTransient
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCC;
    protected Boolean active;
    @Enumerated(EnumType.STRING)
    protected ConnectionDirectionT direction;
    @Transient
    protected SNCTypeT ccType;
    @Transient
    protected CrossConnectT.AEndNameList aEndNameList;
    protected CrossConnectT.ZEndNameList zEndNameList;
    @Transient
    protected CCVendorExtensionsT vendorExtensions;
    @XmlAttribute
    protected String extAuthor;
    @XmlAttribute
    protected String extVersion;
    @XmlAttribute
    protected String tmf854Version;

    /**
     * Gets the value of the active property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setActive(Boolean value) {
        this.active = value;
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
     * Gets the value of the ccType property.
     * 
     * @return
     *     possible object is
     *     {@link SNCTypeT }
     *     
     */
    public SNCTypeT getCcType() {
        return ccType;
    }

    /**
     * Sets the value of the ccType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SNCTypeT }
     *     
     */
    public void setCcType(SNCTypeT value) {
        this.ccType = value;
    }

    /**
     * Gets the value of the aEndNameList property.
     * 
     * @return
     *     possible object is
     *     {@link CrossConnectT.AEndNameList }
     *     
     */
    public CrossConnectT.AEndNameList getAEndNameList() {
        return aEndNameList;
    }

    /**
     * Sets the value of the aEndNameList property.
     * 
     * @param value
     *     allowed object is
     *     {@link CrossConnectT.AEndNameList }
     *     
     */
    public void setAEndNameList(CrossConnectT.AEndNameList value) {
        this.aEndNameList = value;
    }

    /**
     * Gets the value of the zEndNameList property.
     * 
     * @return
     *     possible object is
     *     {@link CrossConnectT.ZEndNameList }
     *     
     */
    public CrossConnectT.ZEndNameList getZEndNameList() {
        return zEndNameList;
    }

    /**
     * Sets the value of the zEndNameList property.
     * 
     * @param value
     *     allowed object is
     *     {@link CrossConnectT.ZEndNameList }
     *     
     */
    public void setZEndNameList(CrossConnectT.ZEndNameList value) {
        this.zEndNameList = value;
    }

    /**
     * Gets the value of the vendorExtensions property.
     * 
     * @return
     *     possible object is
     *     {@link CCVendorExtensionsT }
     *     
     */
    public CCVendorExtensionsT getVendorExtensions() {
        return vendorExtensions;
    }

    /**
     * Sets the value of the vendorExtensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link CCVendorExtensionsT }
     *     
     */
    public void setVendorExtensions(CCVendorExtensionsT value) {
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
     *         &lt;element name="aEndName" type="{tmf854.v1}NamingAttributes_T" maxOccurs="unbounded"/>
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
        "aEndName"
    })
    public static class AEndNameList {

        @XmlElement(required = true)
        protected List<NamingAttributesT> aEndName;

        /**
         * Gets the value of the aEndName property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the aEndName property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAEndName().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link NamingAttributesT }
         * 
         * 
         */
        public List<NamingAttributesT> getAEndName() {
            if (aEndName == null) {
                aEndName = new ArrayList<NamingAttributesT>();
            }
            return this.aEndName;
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
     *         &lt;element name="zEndName" type="{tmf854.v1}NamingAttributes_T" maxOccurs="unbounded"/>
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
        "zEndName"
    })
    public static class ZEndNameList {

        @XmlElement(required = true)
        protected List<NamingAttributesT> zEndName;

        /**
         * Gets the value of the zEndName property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the zEndName property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getZEndName().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link NamingAttributesT }
         * 
         * 
         */
        public List<NamingAttributesT> getZEndName() {
            if (zEndName == null) {
                zEndName = new ArrayList<NamingAttributesT>();
            }
            return this.zEndName;
        }

    }

    public Long getIdCC() {
        return idCC;
    }

    public void setIdCC(Long idCC) {
        this.idCC = idCC;
    }

}
