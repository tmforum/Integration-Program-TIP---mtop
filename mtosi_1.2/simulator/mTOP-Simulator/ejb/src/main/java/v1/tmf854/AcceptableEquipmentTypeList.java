package v1.tmf854;

import java.io.Serializable;
import javax.xml.bind.annotation.*;
import javax.persistence.*;
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
    @XmlTransient
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
    
    public void initAcceptableEquipmentType() {
         if (acceptableEquipmentType == null) {
             acceptableEquipmentType = new ArrayList<String>();

        }
        
          for (AcceptableEquipmentType acc : accs) {
            acceptableEquipmentType.add(acc.getAcceptableEquipmentTyp());
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