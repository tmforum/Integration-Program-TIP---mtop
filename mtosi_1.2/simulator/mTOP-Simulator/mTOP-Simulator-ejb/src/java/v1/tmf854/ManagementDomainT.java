
package v1.tmf854;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.*;
/**
 * 
 *       This aggregate defines the Management Domain Object
 *       
 * 
 * <p>Java class for ManagementDomain_T complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ManagementDomain_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="name" type="{tmf854.v1}NamingAttributes_T" minOccurs="0"/>
 *         &lt;element name="discoveredName" type="{tmf854.v1}DiscoveredName_T" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
/*
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ManagementDomain_T", propOrder = {

})*/
@Entity
public class ManagementDomainT implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "MANAGEMENTDOMAINT_ID")
    private int idMD;
     @OneToOne
    @JoinColumn(name="NAMEATT_ID", referencedColumnName="NAMEATT_ID")
    private NamingAttributesT nameAtt;
    @Column(name="DISCOVEREDNAME") 
    private String discoveredName;

    public int getIdMD() {
        return idMD;
    }

    public void setIdMD(int idMD) {
        this.idMD = idMD;
    }

    public NamingAttributesT getNameAtt() {
        return nameAtt;
    }

    public void setNameAtt(NamingAttributesT nameAtt) {
        this.nameAtt = nameAtt;
    }

    public String getDiscoveredName() {
        return discoveredName;
    }

    public void setDiscoveredName(String discoveredName) {
        this.discoveredName = discoveredName;
    }

  

}
