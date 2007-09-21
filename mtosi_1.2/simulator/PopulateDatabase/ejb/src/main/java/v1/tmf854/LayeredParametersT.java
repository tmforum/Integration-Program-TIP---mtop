
package v1.tmf854;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 *
 *       LayeredParameters_T is a structure that includes the layer rate with the applicable list of transmissions parameters
 *
 *
 * <p>Java class for LayeredParameters_T complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="LayeredParameters_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="layer" type="{tmf854.v1}LayerRate_T"/>
 *         &lt;element name="transmissionParams" type="{tmf854.v1}NVSList_T" minOccurs="0"/>
 *         &lt;element name="vendorExtensions" type="{tmf854.v1}TransmissionParametersExt_T" minOccurs="0"/>
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
@XmlType(name = "LayeredParameters_T", propOrder = {
})
@Entity
public class LayeredParametersT implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @XmlElement(required = true)
    protected String layer;
    @OneToOne(cascade={CascadeType.ALL})
    protected NVSListT transmissionParams;
    @Transient
    protected TransmissionParametersExtT vendorExtensions;
    protected String vendorExtensionsS;
    @XmlAttribute
    protected String extAuthor;
    @XmlAttribute
    protected String extVersion;
    @XmlAttribute
    protected String tmf854Version;
    
    /**
     * Gets the value of the layer property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLayer() {
        return layer;
    }
    
    /**
     * Sets the value of the layer property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLayer(String value) {
        this.layer = value;
    }
    
    /**
     * Gets the value of the transmissionParams property.
     *
     * @return
     *     possible object is
     *     {@link NVSListT }
     *
     */
    public NVSListT getTransmissionParams() {
        return transmissionParams;
    }
    
    /**
     * Sets the value of the transmissionParams property.
     *
     * @param value
     *     allowed object is
     *     {@link NVSListT }
     *
     */
    public void setTransmissionParams(NVSListT value) {
        this.transmissionParams = value;
    }
    
    /**
     * Gets the value of the vendorExtensions property.
     *
     * @return
     *     possible object is
     *     {@link TransmissionParametersExtT }
     *
     */
    public TransmissionParametersExtT getVendorExtensions() {
        return vendorExtensions;
    }
    
    /**
     * Sets the value of the vendorExtensions property.
     *
     * @param value
     *     allowed object is
     *     {@link TransmissionParametersExtT }
     *
     */
    public void setVendorExtensions(TransmissionParametersExtT value) {
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
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void initVendorExtensions() {
        this.getVendorExtensions().setAny();
        setVendorExtensionsS(this.getVendorExtensions().getVdExt());
    }
    
    public String getVendorExtensionsS() {
        return vendorExtensionsS;
    }
    
    public void setVendorExtensionsS(String vendorExtensionsS) {
        this.vendorExtensionsS = vendorExtensionsS;
    }
}


