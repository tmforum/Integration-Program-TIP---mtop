package v1.tmf854;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LayerRateAdapter  extends XmlAdapter<String,LayerRate> {
    
    public LayerRateAdapter() {
    }
    public LayerRate unmarshal(String value) {
    if(value.startsWith("MINOR_"))
      return new MinorLayerRate(value.substring(6));
    if(value.startsWith("PROP_"))
      return new PropLayerRate(value.substring(5));
    else
        return null;
  }
  
  public String marshal(LayerRate lr) {
    return lr.toString();
  }
}

