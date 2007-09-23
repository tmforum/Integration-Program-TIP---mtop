
package v1.tmf854;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.*;

 /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="edgePTPInv" type="{tmf854.v1}PTP_Inventory_T" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "edgePTPInv"
    })
    @Entity
    public class EdgePTPList implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade={CascadeType.ALL})
     protected List<PTPInventoryT> edgePTPInv;
        
        /**
         * Gets the value of the edgePTPInv property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the edgePTPInv property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEdgePTPInv().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PTPInventoryT }
         *
         *
         */
        public List<PTPInventoryT> getEdgePTPInv() {
            if (edgePTPInv == null) {
                edgePTPInv = new ArrayList<PTPInventoryT>();
            }
            return this.edgePTPInv;
        }
        
    }