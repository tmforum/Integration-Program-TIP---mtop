package v1.tmf854;


import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Entity
public class AcceptableEquipmentType implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String acceptableEquipmentTyp;
   
    public AcceptableEquipmentType() {
    }
    
    public AcceptableEquipmentType(String s) {
        acceptableEquipmentTyp = s;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getAcceptableEquipmentTyp() {
        return acceptableEquipmentTyp;
    }
    
    public void setAcceptableEquipmentTyp(String acceptableEquipmentTyp) {
        this.acceptableEquipmentTyp = acceptableEquipmentTyp;
    }
}
