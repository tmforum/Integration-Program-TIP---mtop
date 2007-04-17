
package v1.tmf854;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *       This is the definition of the name attribute, which represents a unique identifier for the MTOSI object on the CCV. Once set by the naming OS, the name is invariant for the life of the object and should be used when referring to the object over the CCV. Name attribute of an object instance shall always be assigned a value, unless the object instance is first discovered by an OS that is not the naming OS for the object instance. In such a case, the discovering OS shall provide a value for the Discovered Name attribute of the object. The naming OS shall provide a value for the Name attribute of the object once it becomes aware of the new object
 *       Refer to the MTOSI supporting document SD2-7.
 *       
 * 
 * <p>Java class for NamingAttributes_T complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NamingAttributes_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="osNm" type="{tmf854.v1}NameValue_T" minOccurs="0"/>
 *         &lt;element name="mdNm" type="{tmf854.v1}NameValue_T" minOccurs="0"/>
 *         &lt;element name="meNm" type="{tmf854.v1}NameValue_T" minOccurs="0"/>
 *         &lt;element name="ehNm" type="{tmf854.v1}NameValue_T" minOccurs="0"/>
 *         &lt;element name="eqNm" type="{tmf854.v1}NameValue_T" minOccurs="0"/>
 *         &lt;element name="ptpNm" type="{tmf854.v1}NameValue_T" minOccurs="0"/>
 *         &lt;element name="ftpNm" type="{tmf854.v1}NameValue_T" minOccurs="0"/>
 *         &lt;element name="ctpNm" type="{tmf854.v1}NameValue_T" minOccurs="0"/>
 *         &lt;element name="tppoolNm" type="{tmf854.v1}NameValue_T" minOccurs="0"/>
 *         &lt;element name="pgpNm" type="{tmf854.v1}NameValue_T" minOccurs="0"/>
 *         &lt;element name="epgpNm" type="{tmf854.v1}NameValue_T" minOccurs="0"/>
 *         &lt;element name="mlsnNm" type="{tmf854.v1}NameValue_T" minOccurs="0"/>
 *         &lt;element name="sncNm" type="{tmf854.v1}NameValue_T" minOccurs="0"/>
 *         &lt;element name="tmdNm" type="{tmf854.v1}NameValue_T" minOccurs="0"/>
 *         &lt;element name="tlNm" type="{tmf854.v1}NameValue_T" minOccurs="0"/>
 *         &lt;element name="aidNm" type="{tmf854.v1}NameValue_T" minOccurs="0"/>
 *         &lt;element name="propNm" type="{tmf854.v1}NameValue_T" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
/*@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NamingAttributes_T", propOrder = {
    "osNm",
    "mdNm",
    "meNm",
    "ehNm",
    "eqNm",
    "ptpNm",
    "ftpNm",
    "ctpNm",
    "tppoolNm",
    "pgpNm",
    "epgpNm",
    "mlsnNm",
    "sncNm",
    "tmdNm",
    "tlNm",
    "aidNm",
    "propNm"
})*/
@Entity
public class NamingAttributesT implements Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)  
  @Column(name="NAMEATT_ID")
  private int idNatt;
 

    protected String osNm;
    protected String mdNm;
    protected String meNm;
    protected String ehNm;
    protected String eqNm;
    protected String ptpNm;
    protected String ftpNm;
    protected String ctpNm;
    protected String tppoolNm;
    protected String pgpNm;
    protected String epgpNm;
    protected String mlsnNm;
    protected String sncNm;
    protected String tmdNm;
    protected String tlNm;
    protected String aidNm;
    protected String propNm;

    
     public int getIdNatt() {
        return idNatt;
    }

    public void setIdNatt(int idNatt) {
        this.idNatt = idNatt;
    }
    
    /**
     * Gets the value of the osNm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOsNm() {
        return osNm;
    }

    /**
     * Sets the value of the osNm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOsNm(String value) {
        this.osNm = value;
    }

    /**
     * Gets the value of the mdNm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMdNm() {
        return mdNm;
    }

    /**
     * Sets the value of the mdNm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMdNm(String value) {
        this.mdNm = value;
    }

    /**
     * Gets the value of the meNm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeNm() {
        return meNm;
    }

    /**
     * Sets the value of the meNm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeNm(String value) {
        this.meNm = value;
    }

    /**
     * Gets the value of the ehNm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEhNm() {
        return ehNm;
    }

    /**
     * Sets the value of the ehNm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEhNm(String value) {
        this.ehNm = value;
    }

    /**
     * Gets the value of the eqNm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEqNm() {
        return eqNm;
    }

    /**
     * Sets the value of the eqNm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEqNm(String value) {
        this.eqNm = value;
    }

    /**
     * Gets the value of the ptpNm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPtpNm() {
        return ptpNm;
    }

    /**
     * Sets the value of the ptpNm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPtpNm(String value) {
        this.ptpNm = value;
    }

    /**
     * Gets the value of the ftpNm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFtpNm() {
        return ftpNm;
    }

    /**
     * Sets the value of the ftpNm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFtpNm(String value) {
        this.ftpNm = value;
    }

    /**
     * Gets the value of the ctpNm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCtpNm() {
        return ctpNm;
    }

    /**
     * Sets the value of the ctpNm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCtpNm(String value) {
        this.ctpNm = value;
    }

    /**
     * Gets the value of the tppoolNm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTppoolNm() {
        return tppoolNm;
    }

    /**
     * Sets the value of the tppoolNm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTppoolNm(String value) {
        this.tppoolNm = value;
    }

    /**
     * Gets the value of the pgpNm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPgpNm() {
        return pgpNm;
    }

    /**
     * Sets the value of the pgpNm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPgpNm(String value) {
        this.pgpNm = value;
    }

    /**
     * Gets the value of the epgpNm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEpgpNm() {
        return epgpNm;
    }

    /**
     * Sets the value of the epgpNm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEpgpNm(String value) {
        this.epgpNm = value;
    }

    /**
     * Gets the value of the mlsnNm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMlsnNm() {
        return mlsnNm;
    }

    /**
     * Sets the value of the mlsnNm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMlsnNm(String value) {
        this.mlsnNm = value;
    }

    /**
     * Gets the value of the sncNm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSncNm() {
        return sncNm;
    }

    /**
     * Sets the value of the sncNm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSncNm(String value) {
        this.sncNm = value;
    }

    /**
     * Gets the value of the tmdNm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTmdNm() {
        return tmdNm;
    }

    /**
     * Sets the value of the tmdNm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTmdNm(String value) {
        this.tmdNm = value;
    }

    /**
     * Gets the value of the tlNm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTlNm() {
        return tlNm;
    }

    /**
     * Sets the value of the tlNm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTlNm(String value) {
        this.tlNm = value;
    }

    /**
     * Gets the value of the aidNm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAidNm() {
        return aidNm;
    }

    /**
     * Sets the value of the aidNm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAidNm(String value) {
        this.aidNm = value;
    }

    /**
     * Gets the value of the propNm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropNm() {
        return propNm;
    }

    /**
     * Sets the value of the propNm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropNm(String value) {
        this.propNm = value;
    }

    

}
