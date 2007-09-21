package v1.tmf854;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
@Entity
public class Alias implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    protected String aliasName;
    protected String aliasValue;
    
    public String getAliasName() {
        return aliasName;
    }
    
    public void setAliasName(String value) {
        this.aliasName = value;
    }
    
    public String getAliasValue() {
        return aliasValue;
    }
    
    public void setAliasValue(String value) {
        this.aliasValue = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}