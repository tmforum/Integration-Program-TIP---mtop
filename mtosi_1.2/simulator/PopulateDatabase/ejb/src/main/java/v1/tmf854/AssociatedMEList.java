package v1.tmf854;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "associatedMEList", propOrder = {
    "associatedME"
})
@Entity
public class AssociatedMEList implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade={CascadeType.ALL})
    protected List<AssociatedME> associatedME;
    
    /**
     * Gets the value of the associatedME property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the associatedME property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssociatedME().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MLSNInventoryT.AssociatedMEList.AssociatedME }
     *
     *
     */
    public List<AssociatedME> getAssociatedME() {
        if (associatedME == null) {
            associatedME = new ArrayList<AssociatedME>();
        }
        return this.associatedME;
    }
}
    
    