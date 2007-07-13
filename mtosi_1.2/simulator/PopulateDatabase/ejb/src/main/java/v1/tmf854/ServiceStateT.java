
package v1.tmf854;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceState_T", propOrder = {
})
@Entity
@Table(name = "SERVICE_STATE")
public class ServiceStateT implements Serializable{
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @XmlValue
    @Enumerated(EnumType.STRING)
    @Column(name="value_")
    protected ServiceStateEnumT value;
    @XmlAttribute
    protected String qualifier;
    
    /**
     * Gets the value of the value property.
     *
     * @return
     *     possible object is
     *     {@link ServiceStateEnumT }
     *
     */
    public ServiceStateEnumT getValue() {
        return value;
    }
    
    /**
     * Sets the value of the value property.
     *
     * @param value
     *     allowed object is
     *     {@link ServiceStateEnumT }
     *
     */
    public void setValue(ServiceStateEnumT value) {
        this.value = value;
    }
    
    /**
     * Gets the value of the qualifier property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getQualifier() {
        return qualifier;
    }
    
    /**
     * Sets the value of the qualifier property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setQualifier(String value) {
        this.qualifier = value;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
}
