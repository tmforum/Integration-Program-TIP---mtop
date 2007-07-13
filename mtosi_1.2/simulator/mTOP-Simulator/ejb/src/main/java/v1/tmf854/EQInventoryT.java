
package v1.tmf854;
         /*
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
           */
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;

/**
 * 
 *         The data structure of the Equipment as returned in inventory report.
 *         Refer to the InventoryLayout supporting document.
 *       
 * 
 * <p>Java class for EQ_Inventory_T complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EQ_Inventory_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="eqNm" type="{tmf854.v1}NameValue_T" minOccurs="0"/>
 *         &lt;element name="eqAttrs" type="{tmf854.v1}Equipment_T" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="extAuthor" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="extVersion" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="tmf854Version" type="{tmf854.v1}TMF854_Version_T" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Entity
@Table(name = "EQINV")
public class EQInventoryT implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="EQ_ID")
    private Long id;
    protected String eqNm;
    @Transient
    protected EquipmentT eqAttrs;

    protected String extAuthor;

    protected String extVersion;

    protected String tmf854Version;


    public String getEqNm() {
        return eqNm;
    }


    public void setEqNm(String value) {
        this.eqNm = value;
    }


    public EquipmentT getEqAttrs() {
        return eqAttrs;
    }


    public void setEqAttrs(EquipmentT value) {
        this.eqAttrs = value;
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

}
