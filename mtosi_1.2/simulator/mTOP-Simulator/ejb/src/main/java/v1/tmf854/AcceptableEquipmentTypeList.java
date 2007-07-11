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
import javax.persistence.ManyToOne;
import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.*;
import v1.tmf854.*;
/**
 * 
 *
 * @author baptiste
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "acceptableEquipmentTypeList", propOrder = {
})
@Entity
@Table(name = "ACCEQTL")
public class AcceptableEquipmentTypeList implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Transient
    protected List<String> acceptableEquipmentType;
    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
    private List<AcceptableEquipmentType> accs;
    
    public List<String> getAcceptableEquipmentType() {
        if (acceptableEquipmentType == null) {
            acceptableEquipmentType = new ArrayList<String>();
        }
        return this.acceptableEquipmentType;
    }
    
    public List<AcceptableEquipmentType> getAccs() {
        if (accs == null) {
            setAccs(new ArrayList<AcceptableEquipmentType>());
        }
        
        for (String s : acceptableEquipmentType) {
            AcceptableEquipmentType acc = new AcceptableEquipmentType(s);
            accs.add(acc);
        }
        return this.accs;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAccs(List<AcceptableEquipmentType> accs) {
        this.accs = accs;
    }
}