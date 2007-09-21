
package v1.tmf854;

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
import v1.tmf854.*;


/**
 * 
 *       LayeredParametersList_T is used in the TP definition and as a consequence is available for use in a connection specification where a TP is specified.
 *       
 * 
 * <p>Java class for LayeredParametersList_T complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LayeredParametersList_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="layeredParameters" type="{tmf854.v1}LayeredParameters_T" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LayeredParametersList_T", propOrder = {
    "layeredParameters"
})
@Entity
public class LayeredParametersListT implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade={CascadeType.ALL})
    protected List<LayeredParametersT> layeredParameters;

    /**
     * Gets the value of the layeredParameters property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the layeredParameters property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLayeredParameters().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LayeredParametersT }
     * 
     * 
     */
    public List<LayeredParametersT> getLayeredParameters() {
        if (layeredParameters == null) {
            layeredParameters = new ArrayList<LayeredParametersT>();
        }
        return this.layeredParameters;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
