
package v1.tmf854;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *         The data structure of the Floating Termination Point as returned in inventory report.
 *         Refer to the InventoryLayout supporting document.
 *
 *
 * <p>Java class for FTP_Inventory_T complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="FTP_Inventory_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="ftpNm" type="{tmf854.v1}NameValue_T" minOccurs="0"/>
 *         &lt;element name="ftpAttrs" type="{tmf854.v1}FloatingTerminationPoint_T" minOccurs="0"/>
 *         &lt;element name="supportingEquipList" type="{tmf854.v1}NamingAttributesList_T" minOccurs="0"/>
 *         &lt;element name="ctpList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ctpInv" type="{tmf854.v1}CTP_Inventory_T" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "FTP_Inventory_T", propOrder = {
    
})
@Entity
@Table(name = "FTPINV")
public class FTPInventoryT  implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="FTP_ID")
    private Long id;
    protected String ftpNm;
     @Transient
    protected FloatingTerminationPointT ftpAttrs;
    @OneToOne(cascade={CascadeType.ALL})
    protected NamingAttributesListT supportingEquipList;
    @Transient
    protected FTPInventoryT.CtpList ctpList;
    @Transient
    protected DataQualityIndicatorT qualityIndicator;
    @XmlAttribute
    protected String extAuthor;
    @XmlAttribute
    protected String extVersion;
    @XmlAttribute
    protected String tmf854Version;
    
    /**
     * Gets the value of the ftpNm property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFtpNm() {
        return ftpNm;
    }
    
    /**
     * Sets the value of the ftpNm property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFtpNm(String value) {
        this.ftpNm = value;
    }
    
    /**
     * Gets the value of the ftpAttrs property.
     *
     * @return
     *     possible object is
     *     {@link FloatingTerminationPointT }
     *
     */
    public FloatingTerminationPointT getFtpAttrs() {
        return ftpAttrs;
    }
    
    /**
     * Sets the value of the ftpAttrs property.
     *
     * @param value
     *     allowed object is
     *     {@link FloatingTerminationPointT }
     *
     */
    public void setFtpAttrs(FloatingTerminationPointT value) {
        this.ftpAttrs = value;
    }
    
    /**
     * Gets the value of the supportingEquipList property.
     *
     * @return
     *     possible object is
     *     {@link NamingAttributesListT }
     *
     */
    public NamingAttributesListT getSupportingEquipList() {
        return supportingEquipList;
    }
    
    /**
     * Sets the value of the supportingEquipList property.
     *
     * @param value
     *     allowed object is
     *     {@link NamingAttributesListT }
     *
     */
    public void setSupportingEquipList(NamingAttributesListT value) {
        this.supportingEquipList = value;
    }
    
    /**
     * Gets the value of the ctpList property.
     *
     * @return
     *     possible object is
     *     {@link FTPInventoryT.CtpList }
     *
     */
    public FTPInventoryT.CtpList getCtpList() {
        return ctpList;
    }
    
    /**
     * Sets the value of the ctpList property.
     *
     * @param value
     *     allowed object is
     *     {@link FTPInventoryT.CtpList }
     *
     */
    public void setCtpList(FTPInventoryT.CtpList value) {
        this.ctpList = value;
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
     *         &lt;element name="ctpInv" type="{tmf854.v1}CTP_Inventory_T" maxOccurs="unbounded" minOccurs="0"/>
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
        "ctpInv"
    })
    public static class CtpList {
        
        protected List<CTPInventoryT> ctpInv;
        
        /**
         * Gets the value of the ctpInv property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the ctpInv property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCtpInv().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CTPInventoryT }
         *
         *
         */
        public List<CTPInventoryT> getCtpInv() {
            if (ctpInv == null) {
                ctpInv = new ArrayList<CTPInventoryT>();
            }
            return this.ctpInv;
        }
        
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
}
