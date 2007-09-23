
package v1.tmf854;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 *
 * This aggregate defines a set of attributes associated with a TP.
 *
 *
 * <p>Java class for TPData_T complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TPData_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="tpName" type="{tmf854.v1}NamingAttributes_T"/>
 *         &lt;element name="tpMappingMode" type="{tmf854.v1}TerminationMode_T" minOccurs="0"/>
 *         &lt;element name="transmissionParams" type="{tmf854.v1}LayeredParametersList_T" minOccurs="0"/>
 *         &lt;element name="ingressTransmissionDescriptorName" type="{tmf854.v1}NamingAttributes_T" minOccurs="0"/>
 *         &lt;element name="egressTransmissionDescriptorName" type="{tmf854.v1}NamingAttributes_T" minOccurs="0"/>
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
@Entity
public class TPDataT implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade={CascadeType.ALL})
    protected NamingAttributesT tpName;
    @Enumerated(EnumType.STRING)
    protected TerminationModeT tpMappingMode;
     @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="trParams")
    protected LayeredParametersListT transmissionParams;
    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="ingrTDN")
    protected NamingAttributesT ingressTransmissionDescriptorName;
    @OneToOne(cascade={CascadeType.ALL})
     @JoinColumn(name="egrTDN")
    protected NamingAttributesT egressTransmissionDescriptorName;
    
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
     *     {@link TerminationModeT }
     *
     */
    public TerminationModeT getTpMappingMode() {
        return tpMappingMode;
    }
    
    /**
     * Sets the value of the tpMappingMode property.
     *
     * @param value
     *     allowed object is
     *     {@link TerminationModeT }
     *
     */
    public void setTpMappingMode(TerminationModeT value) {
        this.tpMappingMode = value;
    }
    
    /**
     * Gets the value of the transmissionParams property.
     *
     * @return
     *     possible object is
     *     {@link LayeredParametersListT }
     *
     */
    public LayeredParametersListT getTransmissionParams() {
        return transmissionParams;
    }
    
    /**
     * Sets the value of the transmissionParams property.
     *
     * @param value
     *     allowed object is
     *     {@link LayeredParametersListT }
     *
     */
    public void setTransmissionParams(LayeredParametersListT value) {
        this.transmissionParams = value;
    }
    
    /**
     * Gets the value of the ingressTransmissionDescriptorName property.
     *
     * @return
     *     possible object is
     *     {@link NamingAttributesT }
     *
     */
    public NamingAttributesT getIngressTransmissionDescriptorName() {
        return ingressTransmissionDescriptorName;
    }
    
    /**
     * Sets the value of the ingressTransmissionDescriptorName property.
     *
     * @param value
     *     allowed object is
     *     {@link NamingAttributesT }
     *
     */
    public void setIngressTransmissionDescriptorName(NamingAttributesT value) {
        this.ingressTransmissionDescriptorName = value;
    }
    
    /**
     * Gets the value of the egressTransmissionDescriptorName property.
     *
     * @return
     *     possible object is
     *     {@link NamingAttributesT }
     *
     */
    public NamingAttributesT getEgressTransmissionDescriptorName() {
        return egressTransmissionDescriptorName;
    }
    
    /**
     * Sets the value of the egressTransmissionDescriptorName property.
     *
     * @param value
     *     allowed object is
     *     {@link NamingAttributesT }
     *
     */
    public void setEgressTransmissionDescriptorName(NamingAttributesT value) {
        this.egressTransmissionDescriptorName = value;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
}
