
package v1.tmf854;

import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LayerRateList_T", propOrder = {
})
@Entity
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
    @OneToMany(cascade={CascadeType.ALL})
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
        
        return this.lrs;
    }
    
    public void initLrs() {
        if (lrs == null) {
            lrs = new ArrayList<LayerRate>();
        }
        
        for (String s : layerRate) {
            LayerRate lr = new LayerRate(s);
            lrs.add(lr);
        }
    }
    
    public void setLrs(List<LayerRate> lrs) {
        this.lrs = lrs;
    }
}
