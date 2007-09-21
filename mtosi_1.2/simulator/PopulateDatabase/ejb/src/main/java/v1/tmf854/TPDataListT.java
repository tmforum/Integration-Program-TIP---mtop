
package v1.tmf854;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;


/**
 *
 * List of TPData_T elements.
 *
 *
 * <p>Java class for TPDataList_T complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TPDataList_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tpData" type="{tmf854.v1}TPData_T" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TPDataList_T", propOrder = {
    "tpData"
})
@Entity
public class TPDataListT implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade={CascadeType.ALL})
    private List<TPDataT> tpData;
    
    /**
     * Gets the value of the tpData property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tpData property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTpData().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TPDataT }
     *
     *
     */
    public List<TPDataT> getTpData() {
        if (tpData == null) {
            tpData = new ArrayList<TPDataT>();
        }
        return this.tpData;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setTpData(List<TPDataT> tpData) {
        this.tpData = tpData;
    }
    
}
