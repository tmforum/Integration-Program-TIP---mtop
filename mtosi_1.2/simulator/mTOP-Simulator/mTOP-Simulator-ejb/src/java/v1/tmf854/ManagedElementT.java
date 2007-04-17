
package v1.tmf854;
/*
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
*/
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.*;

/**
 * 
 *       This aggregate defines the Managed Element object.
 *       
 * 
 * <p>Java class for ManagedElement_T complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ManagedElement_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="name" type="{tmf854.v1}NamingAttributes_T" minOccurs="0"/>
 *         &lt;element name="discoveredName" type="{tmf854.v1}DiscoveredName_T" minOccurs="0"/>
 *         &lt;element name="namingOS" type="{tmf854.v1}NamingOS_T" minOccurs="0"/>
 *         &lt;element name="userLabel" type="{tmf854.v1}UserLabel_T" minOccurs="0"/>
 *         &lt;element name="source" type="{tmf854.v1}Source_T" minOccurs="0"/>
 *         &lt;element name="owner" type="{tmf854.v1}Owner_T" minOccurs="0"/>
 *         &lt;element name="aliasNameList" type="{tmf854.v1}AliasNameList_T" minOccurs="0"/>
 *         &lt;element name="resourceState" type="{tmf854.v1}ResourceState_T" minOccurs="0"/>
 *         &lt;element name="location" type="{tmf854.v1}Location_T" minOccurs="0"/>
 *         &lt;element name="manufacturer" type="{tmf854.v1}Manufacturer_T" minOccurs="0"/>
 *         &lt;element name="productName" type="{tmf854.v1}ProductName_T" minOccurs="0"/>
 *         &lt;element name="version" type="{tmf854.v1}Version_T" minOccurs="0"/>
 *         &lt;element name="InSyncState" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="supportedRates" type="{tmf854.v1}LayerRateList_T" minOccurs="0"/>
 *         &lt;element name="communicationState" type="{tmf854.v1}CommunicationState_T" minOccurs="0"/>
 *         &lt;element name="networkAccessDomain" type="{tmf854.v1}NetworkAccessDomain_T" minOccurs="0"/>
 *         &lt;element name="manufacturerDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
/*@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ManagedElement_T", propOrder = {

})*/
@Entity
public class ManagedElementT implements Serializable {

    /*@XmlElementRef(name = "name", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<NamingAttributesT> name;
    protected String discoveredName;
    @XmlElementRef(name = "namingOS", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<String> namingOS;
    @XmlElementRef(name = "userLabel", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<String> userLabel;
    @XmlElementRef(name = "source", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<SourceT> source;
    @XmlElementRef(name = "owner", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<String> owner;
    @XmlElementRef(name = "aliasNameList", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<AliasNameListT> aliasNameList;
    @XmlElementRef(name = "resourceState", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<ResourceStateT> resourceState;
    @XmlElementRef(name = "location", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<String> location;
    @XmlElementRef(name = "manufacturer", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<String> manufacturer;
    @XmlElementRef(name = "productName", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<String> productName;
    @XmlElementRef(name = "version", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<String> version;
    @XmlElementRef(name = "InSyncState", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<Boolean> inSyncState;
    @XmlElementRef(name = "supportedRates", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<LayerRateListT> supportedRates;
    @XmlElementRef(name = "communicationState", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<CommunicationStateT> communicationState;
    @XmlElementRef(name = "networkAccessDomain", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<String> networkAccessDomain;
    @XmlElementRef(name = "manufacturerDate", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<String> manufacturerDate;
*/
   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "MANAGEDELEMENTT_ID")
    private int idME;    
     @OneToOne
    @JoinColumn(name="NAMEATT_ID", referencedColumnName="NAMEATT_ID")
    private NamingAttributesT nameAtt;
     @Column(name="DISCOVEREDNAMEME") 
     private String discoveredName;
     @Column(name="MANUFACTURERME") 
     private String manufacturer;

    public int getIdME() {
        return idME;
    }

    public void setIdME(int idME) {
        this.idME = idME;
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

   
   
}
