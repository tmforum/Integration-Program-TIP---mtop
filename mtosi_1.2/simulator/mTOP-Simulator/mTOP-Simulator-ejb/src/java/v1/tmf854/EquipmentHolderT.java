
package v1.tmf854;
/*
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
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
 * <p>Java class for EquipmentHolder_T complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EquipmentHolder_T">
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
 *         &lt;element name="alarmReportingIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="holderType" type="{tmf854.v1}EquipmentHolderType_T" minOccurs="0"/>
 *         &lt;element name="acceptableEquipmentTypeList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="acceptableEquipmentType" type="{tmf854.v1}EquipmentObjectType_T" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="expectedOrInstalledEquipment" type="{tmf854.v1}NamingAttributes_T" minOccurs="0"/>
 *         &lt;element name="holderState" type="{tmf854.v1}HolderState_T" minOccurs="0"/>
 *         &lt;element name="location" type="{tmf854.v1}Location_T" minOccurs="0"/>
 *         &lt;element name="manufacturer" type="{tmf854.v1}Manufacturer_T" minOccurs="0"/>
 *         &lt;element name="manufacturerDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vendorExtensions" type="{tmf854.v1}EHVendorExtensions_T" minOccurs="0"/>
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
/*@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EquipmentHolder_T", propOrder = {

})*/
@Entity
public class EquipmentHolderT implements Serializable {

  /*  @XmlElementRef(name = "name", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<NamingAttributesT> name;
    @XmlElementRef(name = "discoveredName", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<String> discoveredName;
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
    @XmlElementRef(name = "alarmReportingIndicator", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<Boolean> alarmReportingIndicator;
    @XmlElementRef(name = "holderType", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<String> holderType;
    @XmlElementRef(name = "acceptableEquipmentTypeList", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<EquipmentHolderT.AcceptableEquipmentTypeList> acceptableEquipmentTypeList;
    @XmlElementRef(name = "expectedOrInstalledEquipment", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<NamingAttributesT> expectedOrInstalledEquipment;
    @XmlElementRef(name = "holderState", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<HolderStateT> holderState;
    @XmlElementRef(name = "location", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<String> location;
    @XmlElementRef(name = "manufacturer", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<String> manufacturer;
    @XmlElementRef(name = "manufacturerDate", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<String> manufacturerDate;
    @XmlElementRef(name = "vendorExtensions", namespace = "tmf854.v1", type = JAXBElement.class)
    protected JAXBElement<EHVendorExtensionsT> vendorExtensions;
    @XmlAttribute
    protected String extAuthor;
    @XmlAttribute
    protected String extVersion;
    @XmlAttribute
    protected String tmf854Version;
*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "EQUIPMENTHOLDERT_ID")
    private int idEH;
    
   @OneToOne
    @JoinColumn(name="NAMEATT_ID", referencedColumnName="NAMEATT_ID")
    private NamingAttributesT nameAtt;
    @Column(name="DISCOVEREDNAME") 
   private String discoveredName;
     @Column(name="MANUFACTURER") 
     private String manufacturer;
      @Column(name="MANUFACTURERDATE") 
     private String manufacturerDate;
       @Column(name="HOLDERSTATE") 
    private HolderStateT holderState;

    public int getIdEH() {
        return idEH;
    }

    public void setIdEH(int idEH) {
        this.idEH = idEH;
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

    public String getManufacturerDate() {
        return manufacturerDate;
    }

    public void setManufacturerDate(String manufacturerDate) {
        this.manufacturerDate = manufacturerDate;
    }

    public HolderStateT getHolderState() {
        return holderState;
    }

    public void setHolderState(HolderStateT holderState) {
        this.holderState = holderState;
    }

   
   
   
}
