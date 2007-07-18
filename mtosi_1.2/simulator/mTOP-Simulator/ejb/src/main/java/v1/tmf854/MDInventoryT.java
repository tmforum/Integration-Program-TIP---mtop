
package v1.tmf854;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;

/**
 *
 *         The data structure of the Management Domain as returned in inventory report.
 *         Refer to the InventoryLayout supporting document.
 *
 *
 * <p>Java class for MD_Inventory_T complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="MD_Inventory_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="mdNm" type="{tmf854.v1}NameValue_T" minOccurs="0"/>
 *         &lt;element name="mdAttrs" type="{tmf854.v1}ManagementDomain_T" minOccurs="0"/>
 *         &lt;element name="supportingOSNameList" minOccurs="0">
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
 *         &lt;element name="meList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="meInv" type="{tmf854.v1}ME_Inventory_T" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="mlsnList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="mlsnInv" type="{tmf854.v1}MLSN_Inventory_T" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="tlList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="tlInv" type="{tmf854.v1}TL_Inventory_T" maxOccurs="unbounded"/>
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
@XmlType(name = "MD_Inventory_T", propOrder = {
    
})
@Entity
@Table(name = "MDINV")
public class MDInventoryT implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name="MDINV_ID")
    private Long id;
    protected String mdNm;
     @Transient
    protected ManagementDomainT mdAttrs;
    @OneToOne(cascade={CascadeType.ALL})
    // full
     protected SupportingOSNameList supportingOSNameList;
    @Transient
    protected MDInventoryT.MeList meList;
    @Transient
    protected MDInventoryT.MlsnList mlsnList;
    @Transient
    protected MDInventoryT.TlList tlList;
    @Transient
    protected DataQualityIndicatorT qualityIndicator;
    @XmlAttribute
    protected String extAuthor;
    @XmlAttribute
    protected String extVersion;
    @XmlAttribute
    protected String tmf854Version;
    
    /**
     * Gets the value of the mdNm property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMdNm() {
        return mdNm;
    }
    
    /**
     * Sets the value of the mdNm property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMdNm(String value) {
        this.mdNm = value;
    }
    
    /**
     * Gets the value of the mdAttrs property.
     *
     * @return
     *     possible object is
     *     {@link ManagementDomainT }
     *
     */
    public ManagementDomainT getMdAttrs() {
        return mdAttrs;
    }
    
    /**
     * Sets the value of the mdAttrs property.
     *
     * @param value
     *     allowed object is
     *     {@link ManagementDomainT }
     *
     */
    public void setMdAttrs(ManagementDomainT value) {
        this.mdAttrs = value;
    }
    
    /**
     * Gets the value of the supportingOSNameList property.
     *
     * @return
     *     possible object is
     *     {@link MDInventoryT.SupportingOSNameList }
     *
     */
    public SupportingOSNameList getSupportingOSNameList() {
        return supportingOSNameList;
    }
    
    /**
     * Sets the value of the supportingOSNameList property.
     *
     * @param value
     *     allowed object is
     *     {@link MDInventoryT.SupportingOSNameList }
     *
     */
    public void setSupportingOSNameList(SupportingOSNameList value) {
        this.supportingOSNameList = value;
    }
    
    /**
     * Gets the value of the meList property.
     *
     * @return
     *     possible object is
     *     {@link MDInventoryT.MeList }
     *
     */
    public MDInventoryT.MeList getMeList() {
        return meList;
    }
    
    /**
     * Sets the value of the meList property.
     *
     * @param value
     *     allowed object is
     *     {@link MDInventoryT.MeList }
     *
     */
    public void setMeList(MDInventoryT.MeList value) {
        this.meList = value;
    }
    
    /**
     * Gets the value of the mlsnList property.
     *
     * @return
     *     possible object is
     *     {@link MDInventoryT.MlsnList }
     *
     */
    public MDInventoryT.MlsnList getMlsnList() {
        return mlsnList;
    }
    
    /**
     * Sets the value of the mlsnList property.
     *
     * @param value
     *     allowed object is
     *     {@link MDInventoryT.MlsnList }
     *
     */
    public void setMlsnList(MDInventoryT.MlsnList value) {
        this.mlsnList = value;
    }
    
    /**
     * Gets the value of the tlList property.
     *
     * @return
     *     possible object is
     *     {@link MDInventoryT.TlList }
     *
     */
    public MDInventoryT.TlList getTlList() {
        return tlList;
    }
    
    /**
     * Sets the value of the tlList property.
     *
     * @param value
     *     allowed object is
     *     {@link MDInventoryT.TlList }
     *
     */
    public void setTlList(MDInventoryT.TlList value) {
        this.tlList = value;
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
     *         &lt;element name="meInv" type="{tmf854.v1}ME_Inventory_T" maxOccurs="unbounded"/>
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
        "meInv"
    })
    public static class MeList {
        
        @XmlElement(required = true)
        protected List<MEInventoryT> meInv;
        
        /**
         * Gets the value of the meInv property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the meInv property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMeInv().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link MEInventoryT }
         *
         *
         */
        public List<MEInventoryT> getMeInv() {
            if (meInv == null) {
                meInv = new ArrayList<MEInventoryT>();
            }
            return this.meInv;
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
     *         &lt;element name="mlsnInv" type="{tmf854.v1}MLSN_Inventory_T" maxOccurs="unbounded"/>
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
        "mlsnInv"
    })
    public static class MlsnList {
        
        @XmlElement(required = true)
        protected List<MLSNInventoryT> mlsnInv;
        
        /**
         * Gets the value of the mlsnInv property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the mlsnInv property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMlsnInv().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link MLSNInventoryT }
         *
         *
         */
        public List<MLSNInventoryT> getMlsnInv() {
            if (mlsnInv == null) {
                mlsnInv = new ArrayList<MLSNInventoryT>();
            }
            return this.mlsnInv;
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
     *         &lt;element name="tlInv" type="{tmf854.v1}TL_Inventory_T" maxOccurs="unbounded"/>
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
        "tlInv"
    })
    public static class TlList {
        
        @XmlElement(required = true)
        protected List<TLInventoryT> tlInv;
        
        /**
         * Gets the value of the tlInv property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the tlInv property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTlInv().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TLInventoryT }
         *
         *
         */
        public List<TLInventoryT> getTlInv() {
            if (tlInv == null) {
                tlInv = new ArrayList<TLInventoryT>();
            }
            return this.tlInv;
        }
        
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
}
