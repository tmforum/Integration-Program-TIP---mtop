
package v1.tmf854;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.persistence.*;

@Entity
public class MEVendorExtensionListT implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String toa;
    public MEVendorExtensionListT() {
    }
    
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getToa() {
        return toa;
    }

    public void setToa(String toa) {
        this.toa = toa;
    }   
}
