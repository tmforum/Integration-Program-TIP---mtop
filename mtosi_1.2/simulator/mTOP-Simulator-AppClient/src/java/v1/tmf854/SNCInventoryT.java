
package v1.tmf854;

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
 *         The data structure of the Subnetwork Connection as returned in inventory report.
 *         Refer to the InventoryLayout supporting document.
 *
 *
 * <p>Java class for SNC_Inventory_T complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SNC_Inventory_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="sncNm" type="{tmf854.v1}NameValue_T" minOccurs="0"/>
 *         &lt;element name="sncAttrs" type="{tmf854.v1}SubnetworkConnection_T" minOccurs="0"/>
 *         &lt;element name="route" type="{tmf854.v1}Route_T" minOccurs="0"/>
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
@XmlType(name = "SNC_Inventory_T", propOrder = {
    
})
@Entity
@Table(name = "SNCINV")
public class SNCInventoryT implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="SNC_ID")
    private Long id;
    protected String sncNm;
    @OneToOne(cascade={CascadeType.ALL})
    protected SubnetworkConnectionT sncAttrs;
     @Transient
    protected RouteT route;
     @Transient
     protected DataQualityIndicatorT qualityIndicator;
    @XmlAttribute
    protected String extAuthor;
    @XmlAttribute
    protected String extVersion;
    @XmlAttribute
    protected String tmf854Version;
    
    /**
     * Gets the value of the sncNm property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSncNm() {
        return sncNm;
    }
    
    /**
     * Sets the value of the sncNm property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSncNm(String value) {
        this.sncNm = value;
    }
    
    /**
     * Gets the value of the sncAttrs property.
     *
     * @return
     *     possible object is
     *     {@link SubnetworkConnectionT }
     *
     */
    public SubnetworkConnectionT getSncAttrs() {
        return sncAttrs;
    }
    
    /**
     * Sets the value of the sncAttrs property.
     *
     * @param value
     *     allowed object is
     *     {@link SubnetworkConnectionT }
     *
     */
    public void setSncAttrs(SubnetworkConnectionT value) {
        this.sncAttrs = value;
    }
    
    /**
     * Gets the value of the route property.
     *
     * @return
     *     possible object is
     *     {@link RouteT }
     *
     */
    public RouteT getRoute() {
        return route;
    }
    
    /**
     * Sets the value of the route property.
     *
     * @param value
     *     allowed object is
     *     {@link RouteT }
     *
     */
    public void setRoute(RouteT value) {
        this.route = value;
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
