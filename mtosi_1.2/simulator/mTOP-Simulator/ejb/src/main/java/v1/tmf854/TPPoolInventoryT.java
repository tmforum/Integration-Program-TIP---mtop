
package v1.tmf854;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;


/**
 * 
 *         The data structure of the TPPool as returned in inventory report.
 *         Refer to the InventoryLayout supporting document.
 *       
 * 
 * <p>Java class for TPPool_Inventory_T complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TPPool_Inventory_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="tppoolNm" type="{tmf854.v1}NameValue_T" minOccurs="0"/>
 *         &lt;element name="tppoolAttrs" type="{tmf854.v1}TPPool_T" minOccurs="0"/>
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
@XmlType(name = "TPPool_Inventory_T", propOrder = {

})
@Entity
public class TPPoolInventoryT implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    protected String tppoolNm;
     @Transient
    protected TPPoolT tppoolAttrs;
     @Transient
    protected DataQualityIndicatorT qualityIndicator;
    @XmlAttribute
    protected String extAuthor;
    @XmlAttribute
    protected String extVersion;
    @XmlAttribute
    protected String tmf854Version;

    /**
     * Gets the value of the tppoolNm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTppoolNm() {
        return tppoolNm;
    }

    /**
     * Sets the value of the tppoolNm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTppoolNm(String value) {
        this.tppoolNm = value;
    }

    /**
     * Gets the value of the tppoolAttrs property.
     * 
     * @return
     *     possible object is
     *     {@link TPPoolT }
     *     
     */
    public TPPoolT getTppoolAttrs() {
        return tppoolAttrs;
    }

    /**
     * Sets the value of the tppoolAttrs property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPPoolT }
     *     
     */
    public void setTppoolAttrs(TPPoolT value) {
        this.tppoolAttrs = value;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
