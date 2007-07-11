/*
 * EquipmentsRetrieved.java
 *
 * Created on 18 juin 2007, 19:45
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package me;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity class EquipmentsRetrieved
 * 
 * 
 * 
 * @author baptiste
 */
@Entity
public class EquipmentsRetrieved implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private long num;
    private Object objectType;
    
    /**
     * Creates a new instance of EquipmentsRetrieved
     */
    public EquipmentsRetrieved() {
    }

    /**
     * Gets the id of this EquipmentsRetrieved.
     * 
     * 
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the id of this EquipmentsRetrieved to the specified value.
     * 
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
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this EquipmentsRetrieved.  The result is 
     * <code>true</code> if and only if the argument is not null and is a EquipmentsRetrieved object that 
     * has the same id field values as this object.
     * 
     * 
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipmentsRetrieved)) {
            return false;
        }
        EquipmentsRetrieved other = (EquipmentsRetrieved)object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "util.Iterator[id=" + id + "]";
    }

    public long getNum() {
        return num;
    }

    public void setNumber(long num) {
        this.num = num;
    }

    public Object getObjectType() {
        return objectType;
    }

    public void setObjectType(Object objectType) {
        this.objectType = objectType;
    }
    
}
