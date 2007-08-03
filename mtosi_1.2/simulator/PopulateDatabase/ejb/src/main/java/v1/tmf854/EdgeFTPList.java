/*
 * EdgeFTPList.java
 *
 * Created on 9 juillet 2007, 05:03
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package v1.tmf854;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.*;
import v1.tmf854.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "edgeFTPInv"
})
@Entity
@Table(name = "EDGEFTPL")
public class EdgeFTPList implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade={CascadeType.ALL})
    protected List<FTPInventoryT> edgeFTPInv;
    
    /**
     * Gets the value of the edgeFTPInv property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the edgeFTPInv property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEdgeFTPInv().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FTPInventoryT }
     *
     *
     */
    public List<FTPInventoryT> getEdgeFTPInv() {
        if (edgeFTPInv == null) {
            edgeFTPInv = new ArrayList<FTPInventoryT>();
        }
        return this.edgeFTPInv;
    }
    
}

