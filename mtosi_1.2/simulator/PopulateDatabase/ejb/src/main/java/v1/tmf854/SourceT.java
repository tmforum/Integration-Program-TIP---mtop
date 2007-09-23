
package v1.tmf854;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.*;
import v1.tmf854.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Source_T", propOrder = {
})
@Entity
public class SourceT implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @XmlValue
    @Enumerated(EnumType.STRING)
    protected SourceEnumT value;
    @XmlAttribute
    protected String qualifier;
        
    
    public SourceEnumT getValue() {
        return value;
    }
    
    
    public void setValue(SourceEnumT value) {
        this.value = value;
    }
    
    
    public String getQualifier() {
        return qualifier;
    }
    
    
    public void setQualifier(String value) {
        this.qualifier = value;
    }
    


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
