package v1.tmf854;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.persistence.*;


public class EQVendorExtensionListT implements Serializable {

    private String toa;
 
    public EQVendorExtensionListT() {
    }
    
    public String getToa() {
        return toa;
    }

    public void setToa(String toa) {
        this.toa = toa;
    }
}
