
package v1.tmf854;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TPData_T complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TPData_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="tpName" type="{tmf854.v1}namingAttributesT"/>
 *         &lt;element name="tpMappingMode" type="{tmf854.v1}terminationModeT" minOccurs="0"/>
 *         &lt;element name="transmissionParams" type="{tmf854.v1}LayeredParametersList_T" minOccurs="0"/>
 *         &lt;element name="ingressTransmissionDescriptorName" type="{tmf854.v1}namingAttributesT" minOccurs="0"/>
 *         &lt;element name="egressTransmissionDescriptorName" type="{tmf854.v1}namingAttributesT" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TPData_T", propOrder = {

})
public class TPDataT {

    @XmlElement(required = true)
    protected NamingAttributesT tpName;
    @XmlElementRef(name = "tpMappingMode", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<TerminationModeT> tpMappingMode;
    @XmlElementRef(name = "transmissionParams", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<LayeredParametersListT> transmissionParams;
    @XmlElementRef(name = "ingressTransmissionDescriptorName", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<NamingAttributesT> ingressTransmissionDescriptorName;
    @XmlElementRef(name = "egressTransmissionDescriptorName", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<NamingAttributesT> egressTransmissionDescriptorName;

    /**
     * Gets the value of the tpName property.
     * 
     * @return
     *     possible object is
     *     {@link NamingAttributesT }
     *     
     */
    public NamingAttributesT getTpName() {
        return tpName;
    }

    /**
     * Sets the value of the tpName property.
     * 
     * @param value
     *     allowed object is
     *     {@link NamingAttributesT }
     *     
     */
    public void setTpName(NamingAttributesT value) {
        this.tpName = value;
    }

    /**
     * Gets the value of the tpMappingMode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TerminationModeT }{@code >}
     *     
     */
    public JAXBElement<TerminationModeT> getTpMappingMode() {
        return tpMappingMode;
    }

    /**
     * Sets the value of the tpMappingMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TerminationModeT }{@code >}
     *     
     */
    public void setTpMappingMode(JAXBElement<TerminationModeT> value) {
        this.tpMappingMode = ((JAXBElement<TerminationModeT> ) value);
    }

    /**
     * Gets the value of the transmissionParams property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LayeredParametersListT }{@code >}
     *     
     */
    public JAXBElement<LayeredParametersListT> getTransmissionParams() {
        return transmissionParams;
    }

    /**
     * Sets the value of the transmissionParams property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LayeredParametersListT }{@code >}
     *     
     */
    public void setTransmissionParams(JAXBElement<LayeredParametersListT> value) {
        this.transmissionParams = ((JAXBElement<LayeredParametersListT> ) value);
    }

    /**
     * Gets the value of the ingressTransmissionDescriptorName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link NamingAttributesT }{@code >}
     *     
     */
    public JAXBElement<NamingAttributesT> getIngressTransmissionDescriptorName() {
        return ingressTransmissionDescriptorName;
    }

    /**
     * Sets the value of the ingressTransmissionDescriptorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link NamingAttributesT }{@code >}
     *     
     */
    public void setIngressTransmissionDescriptorName(JAXBElement<NamingAttributesT> value) {
        this.ingressTransmissionDescriptorName = ((JAXBElement<NamingAttributesT> ) value);
    }

    /**
     * Gets the value of the egressTransmissionDescriptorName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link NamingAttributesT }{@code >}
     *     
     */
    public JAXBElement<NamingAttributesT> getEgressTransmissionDescriptorName() {
        return egressTransmissionDescriptorName;
    }

    /**
     * Sets the value of the egressTransmissionDescriptorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link NamingAttributesT }{@code >}
     *     
     */
    public void setEgressTransmissionDescriptorName(JAXBElement<NamingAttributesT> value) {
        this.egressTransmissionDescriptorName = ((JAXBElement<NamingAttributesT> ) value);
    }

}
