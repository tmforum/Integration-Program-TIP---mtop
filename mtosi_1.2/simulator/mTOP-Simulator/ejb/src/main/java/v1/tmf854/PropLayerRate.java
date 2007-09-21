
package v1.tmf854;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
@Entity
@DiscriminatorValue("PL")
public class PropLayerRate extends LayerRate implements Serializable {
     @XmlTransient
  
   private String value;
    
    public PropLayerRate() {
        setValue(null);
    }
    
    public PropLayerRate(String value) { this.setValue(value); }
    
    public String toString() {
        return "PROP_"+getValue();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}