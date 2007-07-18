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
import v1.tmf854.*;
/**
 * Entity class SupportingOSName
 * 
 * 
 * @author baptiste
 */
@Entity
@Table(name="SUPPOSN")
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

    /**
     * Determines whether another object is equal to this SupportingOSName.  The result is 
     * <code>true</code> if and only if the argument is not null and is a SupportingOSName object that 
     * has the same id field values as this object.
     * 
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupportingOSName)) {
            return false;
        }
        SupportingOSName other = (SupportingOSName)object;
        if (this.getId() != other.getId() && (this.getId() == null || !this.getId().equals(other.getId()))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "v1.tmf854.SupportingOSNm[id=" + getId() + "]";
    }

    public String getSupportingOSNm() {
        return supportingOSNm;
    }

    public void setSupportingOSNm(String supportingOSNm) {
        this.supportingOSNm = supportingOSNm;
    }
    
}
