/*
 * A.java
 *
 * Created on 6 mai 2007, 11:13
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

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




/**
 * Entity class A
 *
 * @author baptiste
 */
@Entity
//@Table(name = "A_T")
public class MEVendorExtensionListT implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="MEVL_ID")
    private Long idMEVL;
    private String toa;
    /** Creates a new instance of A */
    public MEVendorExtensionListT() {
    }
    
   
    /**
     * Gets the id of this A.
     * @return the id
     */
    public Long getIdMEVL() {
        return this.idMEVL;
    }
    
    /**
     * Sets the id of this A to the specified value.
     * @param id the new id
     */
    public void setIdMEVL(Long idMEVL) {
        this.idMEVL = idMEVL;
    }

    public String getToa() {
        return toa;
    }

    public void setToa(String toa) {
        this.toa = toa;
    }
    
    
    
}
