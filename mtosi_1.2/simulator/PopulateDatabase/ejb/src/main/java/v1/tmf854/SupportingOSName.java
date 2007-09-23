/*
 * SupportingOSName.java
 *
 * Created on 8 juillet 2007, 17:31
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package v1.tmf854;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Entity
public class SupportingOSName implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String supportingOSNm;
    
    /**
     * Creates a new instance of SupportingOSName
     */
    public SupportingOSName() {
    }

     public SupportingOSName(String s) {
         supportingOSNm = s;
    }
    /**
     * Gets the id of this SupportingOSName.
     * 
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the id of this SupportingOSName to the specified value.
     * 
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    public String getSupportingOSNm() {
        return supportingOSNm;
    }

    public void setSupportingOSNm(String supportingOSNm) {
        this.supportingOSNm = supportingOSNm;
    }

     
    
    
}
