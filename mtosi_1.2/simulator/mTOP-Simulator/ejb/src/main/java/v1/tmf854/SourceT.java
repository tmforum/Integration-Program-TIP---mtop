
package v1.tmf854;


import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;


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
