
package v1.tmf854;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ME_Inventory_T complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ME_Inventory_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="meNm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="meAttrs" type="{tmf854.v1}ManagedElement_T" minOccurs="0"/>
 *         &lt;element name="containingMLSNNameList" type="{tmf854.v1}NamingAttributesList_T" minOccurs="0"/>
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
 *         &lt;element name="ptpList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ptpInv" type="{tmf854.v1}PTP_Inventory_T" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ftpList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ftpInv" type="{tmf854.v1}FTP_Inventory_T" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ccList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ccAttr" type="{tmf854.v1}CrossConnect_T" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="pgpList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="pgpInv" type="{tmf854.v1}PGP_Inventory_T" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="epgpList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="epgpInv" type="{tmf854.v1}EPGP_Inventory_T" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="qualityIndicator" type="{tmf854.v1}DataQualityIndicator_T" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="extAuthor" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="extVersion" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="tmf854Version" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ME_Inventory_T", propOrder = {

})
public class MEInventoryT {

    protected String meNm;
    protected ManagedElementT meAttrs;
    protected NamingAttributesListT containingMLSNNameList;
    protected MEInventoryT.EhList ehList;
    protected MEInventoryT.PtpList ptpList;
    protected MEInventoryT.FtpList ftpList;
    protected MEInventoryT.CcList ccList;
    protected MEInventoryT.PgpList pgpList;
    protected MEInventoryT.EpgpList epgpList;
    protected DataQualityIndicatorT qualityIndicator;
    @XmlAttribute
    protected String extAuthor;
    @XmlAttribute
    protected String extVersion;
    @XmlAttribute
    protected String tmf854Version;

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
     * Gets the value of the meAttrs property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedElementT }
     *     
     */
    public ManagedElementT getMeAttrs() {
        return meAttrs;
    }

    /**
     * Sets the value of the meAttrs property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedElementT }
     *     
     */
    public void setMeAttrs(ManagedElementT value) {
        this.meAttrs = value;
    }

    /**
     * Gets the value of the containingMLSNNameList property.
     * 
     * @return
     *     possible object is
     *     {@link NamingAttributesListT }
     *     
     */
    public NamingAttributesListT getContainingMLSNNameList() {
        return containingMLSNNameList;
    }

    /**
     * Sets the value of the containingMLSNNameList property.
     * 
     * @param value
     *     allowed object is
     *     {@link NamingAttributesListT }
     *     
     */
    public void setContainingMLSNNameList(NamingAttributesListT value) {
        this.containingMLSNNameList = value;
    }

    /**
     * Gets the value of the ehList property.
     * 
     * @return
     *     possible object is
     *     {@link MEInventoryT.EhList }
     *     
     */
    public MEInventoryT.EhList getEhList() {
        return ehList;
    }

    /**
     * Sets the value of the ehList property.
     * 
     * @param value
     *     allowed object is
     *     {@link MEInventoryT.EhList }
     *     
     */
    public void setEhList(MEInventoryT.EhList value) {
        this.ehList = value;
    }

    /**
     * Gets the value of the ptpList property.
     * 
     * @return
     *     possible object is
     *     {@link MEInventoryT.PtpList }
     *     
     */
    public MEInventoryT.PtpList getPtpList() {
        return ptpList;
    }

    /**
     * Sets the value of the ptpList property.
     * 
     * @param value
     *     allowed object is
     *     {@link MEInventoryT.PtpList }
     *     
     */
    public void setPtpList(MEInventoryT.PtpList value) {
        this.ptpList = value;
    }

    /**
     * Gets the value of the ftpList property.
     * 
     * @return
     *     possible object is
     *     {@link MEInventoryT.FtpList }
     *     
     */
    public MEInventoryT.FtpList getFtpList() {
        return ftpList;
    }

    /**
     * Sets the value of the ftpList property.
     * 
     * @param value
     *     allowed object is
     *     {@link MEInventoryT.FtpList }
     *     
     */
    public void setFtpList(MEInventoryT.FtpList value) {
        this.ftpList = value;
    }

    /**
     * Gets the value of the ccList property.
     * 
     * @return
     *     possible object is
     *     {@link MEInventoryT.CcList }
     *     
     */
    public MEInventoryT.CcList getCcList() {
        return ccList;
    }

    /**
     * Sets the value of the ccList property.
     * 
     * @param value
     *     allowed object is
     *     {@link MEInventoryT.CcList }
     *     
     */
    public void setCcList(MEInventoryT.CcList value) {
        this.ccList = value;
    }

    /**
     * Gets the value of the pgpList property.
     * 
     * @return
     *     possible object is
     *     {@link MEInventoryT.PgpList }
     *     
     */
    public MEInventoryT.PgpList getPgpList() {
        return pgpList;
    }

    /**
     * Sets the value of the pgpList property.
     * 
     * @param value
     *     allowed object is
     *     {@link MEInventoryT.PgpList }
     *     
     */
    public void setPgpList(MEInventoryT.PgpList value) {
        this.pgpList = value;
    }

    /**
     * Gets the value of the epgpList property.
     * 
     * @return
     *     possible object is
     *     {@link MEInventoryT.EpgpList }
     *     
     */
    public MEInventoryT.EpgpList getEpgpList() {
        return epgpList;
    }

    /**
     * Sets the value of the epgpList property.
     * 
     * @param value
     *     allowed object is
     *     {@link MEInventoryT.EpgpList }
     *     
     */
    public void setEpgpList(MEInventoryT.EpgpList value) {
        this.epgpList = value;
    }

    /**
     * Gets the value of the qualityIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link DataQualityIndicatorT }
     *     
     */
    public DataQualityIndicatorT getQualityIndicator() {
        return qualityIndicator;
    }

    /**
     * Sets the value of the qualityIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataQualityIndicatorT }
     *     
     */
    public void setQualityIndicator(DataQualityIndicatorT value) {
        this.qualityIndicator = value;
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
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="ccAttr" type="{tmf854.v1}CrossConnect_T" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "ccAttr"
    })
    public static class CcList {

        @XmlElement(required = true)
        protected List<CrossConnectT> ccAttr;

        /**
         * Gets the value of the ccAttr property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the ccAttr property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCcAttr().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CrossConnectT }
         * 
         * 
         */
        public List<CrossConnectT> getCcAttr() {
            if (ccAttr == null) {
                ccAttr = new ArrayList<CrossConnectT>();
            }
            return this.ccAttr;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="ehInv" type="{tmf854.v1}EH_Inventory_T" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "ehInv"
    })
    public static class EhList {

        @XmlElement(required = true)
        protected List<EHInventoryT> ehInv;

        /**
         * Gets the value of the ehInv property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the ehInv property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEhInv().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link EHInventoryT }
         * 
         * 
         */
        public List<EHInventoryT> getEhInv() {
            if (ehInv == null) {
                ehInv = new ArrayList<EHInventoryT>();
            }
            return this.ehInv;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="epgpInv" type="{tmf854.v1}EPGP_Inventory_T" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "epgpInv"
    })
    public static class EpgpList {

        @XmlElement(required = true)
        protected List<EPGPInventoryT> epgpInv;

        /**
         * Gets the value of the epgpInv property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the epgpInv property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEpgpInv().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link EPGPInventoryT }
         * 
         * 
         */
        public List<EPGPInventoryT> getEpgpInv() {
            if (epgpInv == null) {
                epgpInv = new ArrayList<EPGPInventoryT>();
            }
            return this.epgpInv;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="ftpInv" type="{tmf854.v1}FTP_Inventory_T" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "ftpInv"
    })
    public static class FtpList {

        @XmlElement(required = true)
        protected List<FTPInventoryT> ftpInv;

        /**
         * Gets the value of the ftpInv property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the ftpInv property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFtpInv().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link FTPInventoryT }
         * 
         * 
         */
        public List<FTPInventoryT> getFtpInv() {
            if (ftpInv == null) {
                ftpInv = new ArrayList<FTPInventoryT>();
            }
            return this.ftpInv;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="pgpInv" type="{tmf854.v1}PGP_Inventory_T" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "pgpInv"
    })
    public static class PgpList {

        @XmlElement(required = true)
        protected List<PGPInventoryT> pgpInv;

        /**
         * Gets the value of the pgpInv property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the pgpInv property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPgpInv().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PGPInventoryT }
         * 
         * 
         */
        public List<PGPInventoryT> getPgpInv() {
            if (pgpInv == null) {
                pgpInv = new ArrayList<PGPInventoryT>();
            }
            return this.pgpInv;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="ptpInv" type="{tmf854.v1}PTP_Inventory_T" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "ptpInv"
    })
    public static class PtpList {

        @XmlElement(required = true)
        protected List<PTPInventoryT> ptpInv;

        /**
         * Gets the value of the ptpInv property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the ptpInv property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPtpInv().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PTPInventoryT }
         * 
         * 
         */
        public List<PTPInventoryT> getPtpInv() {
            if (ptpInv == null) {
                ptpInv = new ArrayList<PTPInventoryT>();
            }
            return this.ptpInv;
        }

    }

}
