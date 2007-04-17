
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
public class EHInventoryT {

    protected String ehNm;
    protected EquipmentHolderT ehAttrs;
    protected EHInventoryT.EhList ehList;
    protected EQInventoryT eqInv;
    @XmlAttribute
    protected String extAuthor;
    @XmlAttribute
    protected String extVersion;
    @XmlAttribute
    protected String tmf854Version;

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
     * Gets the value of the ehAttrs property.
     * 
     * @return
     *     possible object is
     *     {@link EquipmentHolderT }
     *     
     */
    public EquipmentHolderT getEhAttrs() {
        return ehAttrs;
    }

    /**
     * Sets the value of the ehAttrs property.
     * 
     * @param value
     *     allowed object is
     *     {@link EquipmentHolderT }
     *     
     */
    public void setEhAttrs(EquipmentHolderT value) {
        this.ehAttrs = value;
    }

    /**
     * Gets the value of the ehList property.
     * 
     * @return
     *     possible object is
     *     {@link EHInventoryT.EhList }
     *     
     */
    public EHInventoryT.EhList getEhList() {
        return ehList;
    }

    /**
     * Sets the value of the ehList property.
     * 
     * @param value
     *     allowed object is
     *     {@link EHInventoryT.EhList }
     *     
     */
    public void setEhList(EHInventoryT.EhList value) {
        this.ehList = value;
    }

    /**
     * Gets the value of the eqInv property.
     * 
     * @return
     *     possible object is
     *     {@link EQInventoryT }
     *     
     */
    public EQInventoryT getEqInv() {
        return eqInv;
    }

    /**
     * Sets the value of the eqInv property.
     * 
     * @param value
     *     allowed object is
     *     {@link EQInventoryT }
     *     
     */
    public void setEqInv(EQInventoryT value) {
        this.eqInv = value;
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
