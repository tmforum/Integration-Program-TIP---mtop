
package v1.tmf854;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         The data structure of the Managed Element as returned in inventory report.
 *         Refer to the InventoryLayout supporting document.
 *       
 * 
 * <p>Java class for ME_Inventory_T complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ME_Inventory_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="meNm" type="{tmf854.v1}NameValue_T" minOccurs="0"/>
 *         &lt;element name="meAttrs" type="{tmf854.v1}ManagedElement_T" minOccurs="0"/>
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
@XmlType(name = "ME_Inventory_T", propOrder = {

})
public class MEInventoryT {

    protected String meNm;
    protected ManagedElementT meAttrs;
    protected MEInventoryT.EhList ehList;
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

}
