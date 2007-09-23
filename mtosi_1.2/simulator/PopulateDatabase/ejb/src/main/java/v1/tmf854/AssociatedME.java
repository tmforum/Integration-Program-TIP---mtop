package v1.tmf854;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
})
@Entity
public class AssociatedME implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @XmlTransient
    @OneToOne(cascade={CascadeType.ALL})
    protected NamingAttributesT name;
    @OneToOne(cascade={CascadeType.ALL})
    protected EdgePTPList edgePTPList;
    @OneToOne(cascade={CascadeType.ALL})
    protected EdgeFTPList edgeFTPList;
    
    /**
     * Gets the value of the name property.
     *
     * @return
     *     possible object is
     *     {@link NamingAttributesT }
     *
     */
    public NamingAttributesT getName() {
        return name;
    }
    
    /**
     * Sets the value of the name property.
     *
     * @param value
     *     allowed object is
     *     {@link NamingAttributesT }
     *
     */
    public void setName(NamingAttributesT value) {
        this.name = value;
    }
    
    /**
     * Gets the value of the edgePTPList property.
     *
     * @return
     *     possible object is
     *     {@link MLSNInventoryT.AssociatedMEList.AssociatedME.EdgePTPList }
     *
     */
    public EdgePTPList getEdgePTPList() {
        return edgePTPList;
    }
    
    /**
     * Sets the value of the edgePTPList property.
     *
     * @param value
     *     allowed object is
     *     {@link MLSNInventoryT.AssociatedMEList.AssociatedME.EdgePTPList }
     *
     */
    public void setEdgePTPList(EdgePTPList value) {
        this.edgePTPList = value;
    }
    
    /**
     * Gets the value of the edgeFTPList property.
     *
     * @return
     *     possible object is
     *     {@link MLSNInventoryT.AssociatedMEList.AssociatedME.EdgeFTPList }
     *
     */
    public EdgeFTPList getEdgeFTPList() {
        return edgeFTPList;
    }
    
    /**
     * Sets the value of the edgeFTPList property.
     *
     * @param value
     *     allowed object is
     *     {@link MLSNInventoryT.AssociatedMEList.AssociatedME.EdgeFTPList }
     *
     */
    public void setEdgeFTPList(EdgeFTPList value) {
        this.edgeFTPList = value;
    }
}

