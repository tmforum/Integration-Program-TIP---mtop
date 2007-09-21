package v1.tmf854;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "acceptableEquipmentTypeList", propOrder = {
})
@Entity
public class AcceptableEquipmentTypeList implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Transient
    protected List<String> acceptableEquipmentType;
    @OneToMany(cascade={CascadeType.ALL})
    private List<AcceptableEquipmentType> accs;
    
    public List<String> getAcceptableEquipmentType() {
        if (acceptableEquipmentType == null) {
            acceptableEquipmentType = new ArrayList<String>();
        }
        return this.acceptableEquipmentType;
    }
    
    public List<AcceptableEquipmentType> getAccs() {
    
        return this.accs;
    }
    
    public void initAccs() {
         if (accs == null) {
            setAccs(new ArrayList<AcceptableEquipmentType>());
        }
        
        for (String s : acceptableEquipmentType) {
            AcceptableEquipmentType acc = new AcceptableEquipmentType(s);
            accs.add(acc);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAccs(List<AcceptableEquipmentType> accs) {
        this.accs = accs;
    }
}