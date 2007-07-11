/*
 * D.java
 *
 * Created on 13 mai 2007, 10:04
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
import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.*;
/**
 * Entity class D
 * 
 * @author baptiste
 */
@Entity
@Table(name = "D")
public class D implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    private String acceptableEquipmentType;
    private String acc;
//    @ManyToOne
//   // @JoinColumn(name = "ACC_FK")
//    private AcceptableEquipmentTypeList accList;
//        @ManyToOne
//    @JoinColumn(name = "D_FK")
//    private AcceptableEquipmentTypeList accList;
    
//    @ManyToOne
    //@JoinColumn(name="D_ID", referencedColumnName="D_FK")
//    private EquipmentHolderT accList;
    
    
    /** Creates a new instance of D */
    public D() {
    }

    /**
     * Gets the id of this D.
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the id of this D to the specified value.
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "v1.tmf854.D[id=" + id + "]";
    }

    

//    public AcceptableEquipmentTypeList getAccList() {
//        return accList;
//    }
//
//    public void setAccList(AcceptableEquipmentTypeList accList) {
//        this.accList = accList;
//    }

//    public String getAcceptableEquipmentType() {
//        return acceptableEquipmentType;
//    }
//
//    public void setAcceptableEquipmentType(String acceptableEquipmentType) {
//        this.acceptableEquipmentType = acceptableEquipmentType;
//    }

//    public EquipmentHolderT getAccList() {
//        return accList;
//    }
//
//    public void setAccList(EquipmentHolderT accList) {
//        this.accList = accList;
//    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }
}
