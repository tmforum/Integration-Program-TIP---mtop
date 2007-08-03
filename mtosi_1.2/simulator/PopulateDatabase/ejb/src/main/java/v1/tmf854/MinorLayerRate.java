/*
 * MinorLayerRate.java
 *
 * Created on 28 mai 2007, 22:27
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package v1.tmf854;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author baptiste
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    
})
@Entity
@DiscriminatorValue("ML")
public class MinorLayerRate extends LayerRate implements Serializable {
    @XmlTransient
  
   private String value;
    
    public MinorLayerRate() {
        setValue(null);
    }
    
    public MinorLayerRate(String value) { this.setValue(value); }
    
    public String toString() {
        return "MINOR_"+getValue();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}