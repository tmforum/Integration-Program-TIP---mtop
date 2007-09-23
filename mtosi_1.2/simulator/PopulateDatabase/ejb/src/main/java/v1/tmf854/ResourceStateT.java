
package v1.tmf854;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourceState_T", propOrder = {
})
@Entity
public class ResourceStateT implements Serializable{
    
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @XmlValue
    @Enumerated(EnumType.STRING)
    protected ResourceStateEnumT value;
    @XmlAttribute
    protected String overlap;
    @XmlAttribute
    protected String qualifier;
    
    
    
    public ResourceStateEnumT getValue() {
        return value;
    }
    
    
    public void setValue(ResourceStateEnumT value) {
        this.value = value;
    }
    
    
    public String getOverlap() {
        return overlap;
    }
    
    
    public void setOverlap(String value) {
        this.overlap = value;
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
