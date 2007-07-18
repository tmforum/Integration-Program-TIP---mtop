
package v1.tmf854;

import java.util.ArrayList;
import java.util.List;                      

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

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
 *         The data structure of the Equipment Holder as returned in inventory report.
 *         Refer to the InventoryLayout and the EquipmentModel supporting documents.
 *       
 * 
 * <p>Java class for EH_Inventory_T complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EH_Inventory_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="ehNm" type="{tmf854.v1}NameValue_T" minOccurs="0"/>
 *         &lt;element name="ehAttrs" type="{tmf854.v1}EquipmentHolder_T" minOccurs="0"/>
 *         &lt;element name="ehList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ehInv" type="{tmf854.v1}EH_Inventory_T" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="eqInv" type="{tmf854.v1}EQ_Inventory_T" minOccurs="0"/>
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

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EH_Inventory_T", propOrder = {
    
})
@Entity
@Table(name = "EHINV")
public class EHInventoryT implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="EH_ID")
    private Long id;
    protected String ehNm;
     @OneToOne(cascade={CascadeType.ALL})
    protected EquipmentHolderT ehAttrs;
   @Transient
    protected EHInventoryT.EhList ehList;
    @OneToOne(cascade={CascadeType.ALL})
    protected EQInventoryT eqInv;
    protected String extAutho;
    protected String extVersion;
    protected String tmf854Version;

    public String getEhNm() {
        return ehNm;
    }


    public void setEhNm(String value) {
        this.ehNm = value;
    }


    public EquipmentHolderT getEhAttrs() {
        return ehAttrs;
    }


    public void setEhAttrs(EquipmentHolderT value) {
        this.ehAttrs = value;
    }


    public EHInventoryT.EhList getEhList() {
        return ehList;
    }


    public void setEhList(EHInventoryT.EhList value) {
        this.ehList = value;
    }

    public EQInventoryT getEqInv() {
        return eqInv;
    }


    public void setEqInv(EQInventoryT value) {
        this.eqInv = value;
    }

    public String getExtAutho() {
        return extAutho;
    }


    public void setExtAutho(String value) {
        this.extAutho = value;
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


@XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "ehInv"
    })
    public static class EhList {


        protected List<EHInventoryT> ehInv;


        public List<EHInventoryT> getEhInv() {
            if (ehInv == null) {
                ehInv = new ArrayList<EHInventoryT>();
            }
            return this.ehInv;
        }

    }

}
