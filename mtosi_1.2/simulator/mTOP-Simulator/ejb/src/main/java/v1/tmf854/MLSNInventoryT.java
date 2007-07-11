
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
 *         The data structure of the Multi Layer Subnetwork as returned in inventory report.
 *         Refer to the InventoryLayout supporting document.
 *
 *
 * <p>Java class for MLSN_Inventory_T complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="MLSN_Inventory_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="mlsnNm" type="{tmf854.v1}NameValue_T" minOccurs="0"/>
 *         &lt;element name="mlsnAttrs" type="{tmf854.v1}MultiLayerSubnetwork_T" minOccurs="0"/>
 *         &lt;element name="sncList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="sncInv" type="{tmf854.v1}SNC_Inventory_T" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="tpPoolList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="tpPoolInv" type="{tmf854.v1}TPPool_Inventory_T" maxOccurs="unbounded" minOccurs="0"/>
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
 *                   &lt;element name="tlInv" type="{tmf854.v1}TL_Inventory_T" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="associatedMEList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="associatedME" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="name" type="{tmf854.v1}NamingAttributes_T"/>
 *                             &lt;element name="edgePTPList" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="edgePTPInv" type="{tmf854.v1}PTP_Inventory_T" maxOccurs="unbounded" minOccurs="0"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="edgeFTPList" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="edgeFTPInv" type="{tmf854.v1}FTP_Inventory_T" maxOccurs="unbounded" minOccurs="0"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/all>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
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
@XmlType(name = "MLSN_Inventory_T", propOrder = {
    
})
@Entity
@Table(name = "MLSNINV")
public class MLSNInventoryT implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="MLSN_ID")
    private Long id;
    protected String mlsnNm;
     @Transient
    protected MultiLayerSubnetworkT mlsnAttrs;
    @Transient
    protected MLSNInventoryT.SncList sncList;
    @Transient
    protected MLSNInventoryT.TpPoolList tpPoolList;
    @Transient
    protected MLSNInventoryT.TlList tlList;
    @OneToOne(cascade={CascadeType.ALL})
    protected AssociatedMEList associatedMEList;
    @Transient
    protected DataQualityIndicatorT qualityIndicator;
    @XmlAttribute
    protected String extAuthor;
    @XmlAttribute
    protected String extVersion;
    @XmlAttribute
    protected String tmf854Version;
    
    /**
     * Gets the value of the mlsnNm property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMlsnNm() {
        return mlsnNm;
    }
    
    /**
     * Sets the value of the mlsnNm property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMlsnNm(String value) {
        this.mlsnNm = value;
    }
    
    /**
     * Gets the value of the mlsnAttrs property.
     *
     * @return
     *     possible object is
     *     {@link MultiLayerSubnetworkT }
     *
     */
    public MultiLayerSubnetworkT getMlsnAttrs() {
        return mlsnAttrs;
    }
    
    /**
     * Sets the value of the mlsnAttrs property.
     *
     * @param value
     *     allowed object is
     *     {@link MultiLayerSubnetworkT }
     *
     */
    public void setMlsnAttrs(MultiLayerSubnetworkT value) {
        this.mlsnAttrs = value;
    }
    
    /**
     * Gets the value of the sncList property.
     *
     * @return
     *     possible object is
     *     {@link MLSNInventoryT.SncList }
     *
     */
    public MLSNInventoryT.SncList getSncList() {
        return sncList;
    }
    
    /**
     * Sets the value of the sncList property.
     *
     * @param value
     *     allowed object is
     *     {@link MLSNInventoryT.SncList }
     *
     */
    public void setSncList(MLSNInventoryT.SncList value) {
        this.sncList = value;
    }
    
    /**
     * Gets the value of the tpPoolList property.
     *
     * @return
     *     possible object is
     *     {@link MLSNInventoryT.TpPoolList }
     *
     */
    public MLSNInventoryT.TpPoolList getTpPoolList() {
        return tpPoolList;
    }
    
    /**
     * Sets the value of the tpPoolList property.
     *
     * @param value
     *     allowed object is
     *     {@link MLSNInventoryT.TpPoolList }
     *
     */
    public void setTpPoolList(MLSNInventoryT.TpPoolList value) {
        this.tpPoolList = value;
    }
    
    /**
     * Gets the value of the tlList property.
     *
     * @return
     *     possible object is
     *     {@link MLSNInventoryT.TlList }
     *
     */
    public MLSNInventoryT.TlList getTlList() {
        return tlList;
    }
    
    /**
     * Sets the value of the tlList property.
     *
     * @param value
     *     allowed object is
     *     {@link MLSNInventoryT.TlList }
     *
     */
    public void setTlList(MLSNInventoryT.TlList value) {
        this.tlList = value;
    }
    
    /**
     * Gets the value of the associatedMEList property.
     *
     * @return
     *     possible object is
     *     {@link MLSNInventoryT.AssociatedMEList }
     *
     */
    public AssociatedMEList getAssociatedMEList() {
        return associatedMEList;
    }
    
    /**
     * Sets the value of the associatedMEList property.
     *
     * @param value
     *     allowed object is
     *     {@link MLSNInventoryT.AssociatedMEList }
     *
     */
    public void setAssociatedMEList(AssociatedMEList value) {
        this.associatedMEList = value;
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
     *         &lt;element name="sncInv" type="{tmf854.v1}SNC_Inventory_T" maxOccurs="unbounded" minOccurs="0"/>
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
        "sncInv"
    })
    public static class SncList {
        
        protected List<SNCInventoryT> sncInv;
        
        /**
         * Gets the value of the sncInv property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the sncInv property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSncInv().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SNCInventoryT }
         *
         *
         */
        public List<SNCInventoryT> getSncInv() {
            if (sncInv == null) {
                sncInv = new ArrayList<SNCInventoryT>();
            }
            return this.sncInv;
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
     *         &lt;element name="tlInv" type="{tmf854.v1}TL_Inventory_T" maxOccurs="unbounded" minOccurs="0"/>
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
     *         &lt;element name="tpPoolInv" type="{tmf854.v1}TPPool_Inventory_T" maxOccurs="unbounded" minOccurs="0"/>
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
        "tpPoolInv"
    })
    public static class TpPoolList {
        
        protected List<TPPoolInventoryT> tpPoolInv;
        
        /**
         * Gets the value of the tpPoolInv property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the tpPoolInv property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTpPoolInv().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TPPoolInventoryT }
         *
         *
         */
        public List<TPPoolInventoryT> getTpPoolInv() {
            if (tpPoolInv == null) {
                tpPoolInv = new ArrayList<TPPoolInventoryT>();
            }
            return this.tpPoolInv;
        }
        
    }
    
}
