
package v1.tmf854;


import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.*;
import javax.xml.bind.annotation.*;
import v1.tmf854.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LayerRateList_T", propOrder = {
})
@Entity
@Table(name = "LRL")
public class LayerRateListT  implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Transient
    private List<String> layerRate;
    @XmlAttribute
    protected String extAuthor;
    @XmlAttribute
    protected String extVersion;
    @XmlAttribute
    protected String tmf854Version;
    //me
   @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
    private List<LayerRate> lrs;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public List<String> getLayerRate() {
        if (layerRate == null) {
            layerRate = new ArrayList<String>();
        }
        return this.layerRate;
    }
    
    
    
    public String getExtAuthor() {
        return extAuthor;
    }
    
    
    public void setExtAuthor(String value) {
        this.extAuthor = value;
    }
    
    
    public String getExtVersion() {
        return extVersion;
    }
    
    
    public void setExtVersion(String value) {
        this.extVersion = value;
    }
    
    
    public String getTmf854Version() {
        return tmf854Version;
    }
    
    
    public void setTmf854Version(String value) {
        this.tmf854Version = value;
    }
    
    public List<LayerRate> getLrs() {
        if (lrs == null) {
            lrs = new ArrayList<LayerRate>();
        }
        System.out.println("********LayerRateListT.getLrs()*********");
        System.out.println("layerRate.size() " + layerRate.size());
        for (String s : layerRate) {
            System.out.println("layerRate.0 " + layerRate.get(0));
            //System.out.println("layerRate.1 " + layerRate.get(1));
            LayerRate lr = new LayerRate(s);
            lrs.add(lr);
        }
        
        System.out.println("FINNNNNNNNNNNNNNN:getLrs()");
        return this.lrs;
    }
    
    public void setLrs(List<LayerRate> lrs) {
        this.lrs = lrs;
    }
}
