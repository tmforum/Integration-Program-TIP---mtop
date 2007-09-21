/*
 * SupportingOSNameList.java
 *
 * Created on 8 juillet 2007, 17:15
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
@XmlType(name = "supportingOSNameList", propOrder = {
})
@Entity
public  class SupportingOSNameList implements Serializable {
  
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Transient
    private List<String> osNm = new ArrayList<String>();
    @XmlTransient
    @OneToMany(cascade={CascadeType.ALL})
    private List<SupportingOSName> supportingOSNames;
    
    
    /**
     * Gets the value of the osNm property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the osNm property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOsNm().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     *
     */
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public List<String> getOsNm() {
        if (osNm == null) {
            osNm = new ArrayList<String>();
        }
        return this.osNm;
    }
    
    public void setOsNm(List<String> osNm) {
        this.osNm= osNm;
    }
    
    public List<SupportingOSName> getSupportingOSNames() {
        
        return supportingOSNames;
    }
    
    public void setSupportingOSNames(List<SupportingOSName> supportingOSNames) {
        
        this.supportingOSNames = supportingOSNames;
    }
    
    public void initOSNm() {
        if (supportingOSNames == null) {
            setSupportingOSNames(new ArrayList<SupportingOSName>());
        }
          
        for (SupportingOSName s : supportingOSNames) {
            osNm.add(s.getSupportingOSNm());
        }
        
    }
    
    public void breakCycle() {
        
        for (SupportingOSName s : supportingOSNames) {
            s.setSupportingOSNm(null);
            
        }
    }
    
}
