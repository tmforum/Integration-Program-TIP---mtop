package v1.tmf854;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Entity
//@DiscriminatorColumn(name="DISC", discriminatorType=DiscriminatorType.STRING)
//@DiscriminatorValue("LAYERRATE")
@XmlJavaTypeAdapter(LayerRateAdapter.class)
public class LayerRate implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String layerRat;

    public LayerRate() {}

    public LayerRate(String s) {
        layerRat = s;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLayerRat() {
        return layerRat;
    }

    public void setLayerRat(String layerRat) {
        this.layerRat = layerRat;
    }
}
