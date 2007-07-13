
package v1.tmf854;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for namingAttributesT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="namingAttributesT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="aidNm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ctpNm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ehNm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="epgpNm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="eqNm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="extAuthor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="extVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ftpNm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mdNm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="meNm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mlsnNm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="osNm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pgpNm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="propNm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ptpNm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sncNm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tlNm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tmdNm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tmf854Version" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tppoolNm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "namingAttributesT", propOrder = {
    "aidNm",
    "ctpNm",
    "ehNm",
    "epgpNm",
    "eqNm",
    "extAuthor",
    "extVersion",
    "ftpNm",
    "mdNm",
    "meNm",
    "mlsnNm",
    "osNm",
    "pgpNm",
    "propNm",
    "ptpNm",
    "sncNm",
    "tlNm",
    "tmdNm",
    "tmf854Version",
    "tppoolNm"
})
public class NamingAttributesT {

    protected String aidNm;
    protected String ctpNm;
    protected String ehNm;
    protected String epgpNm;
    protected String eqNm;
    protected String extAuthor;
    protected String extVersion;
    protected String ftpNm;
    protected String mdNm;
    protected String meNm;
    protected String mlsnNm;
    protected String osNm;
    protected String pgpNm;
    protected String propNm;
    protected String ptpNm;
    protected String sncNm;
    protected String tlNm;
    protected String tmdNm;
    protected String tmf854Version;
    protected String tppoolNm;

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
     * Gets the value of the extAuthor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtAuthor() {
        return extAuthor;
    }

    /**
     * Sets the value of the extAuthor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtAuthor(String value) {
        this.extAuthor = value;
    }

    /**
     * Gets the value of the extVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtVersion() {
        return extVersion;
    }

    /**
     * Sets the value of the extVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtVersion(String value) {
        this.extVersion = value;
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
     * Gets the value of the tmf854Version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTmf854Version() {
        return tmf854Version;
    }

    /**
     * Sets the value of the tmf854Version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTmf854Version(String value) {
        this.tmf854Version = value;
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

}
