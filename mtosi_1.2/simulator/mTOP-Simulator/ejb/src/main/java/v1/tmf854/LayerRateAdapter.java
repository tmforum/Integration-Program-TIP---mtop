/*
 * LayerRateAdapter.java
 *
 * Created on 28 mai 2007, 22:47
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package v1.tmf854;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import v1.tmf854.*;

/**
 *
 * @author baptiste
 */
public class LayerRateAdapter  extends XmlAdapter<String,LayerRate> {
    
    /** Creates a new instance of LayerRateAdapter */
    public LayerRateAdapter() {
    }
    public LayerRate unmarshal(String value) {
    if(value.startsWith("MINOR_"))
      return new MinorLayerRate(value.substring(6));
    if(value.startsWith("PROP_"))
      return new PropLayerRate(value.substring(5));
    else
        return null;
     // return WellknownLayerRateEnum.valueOf(value);
  }
  
  public String marshal(LayerRate lr) {
    return lr.toString();
  }
}

