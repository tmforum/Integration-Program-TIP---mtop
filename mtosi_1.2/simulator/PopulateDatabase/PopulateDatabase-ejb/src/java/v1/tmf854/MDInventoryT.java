
package v1.tmf854;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         The data structure of the Management Domain as returned in inventory report.
 *         Refer to the InventoryLayout supporting document.
 *       
 * 
 * <p>Java class for MD_Inventory_T complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MD_Inventory_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="mdNm" type="{tmf854.v1}NameValue_T" minOccurs="0"/>
 *         &lt;element name="mdAttrs" type="{tmf854.v1}ManagementDomain_T" minOccurs="0"/>
 *         &lt;element name="meList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="meInv" type="{tmf854.v1}ME_Inventory_T" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MD_Inventory_T", propOrder = {

})
public class MDInventoryT {

    protected String mdNm;
    protected ManagementDomainT mdAttrs;
    protected MDInventoryT.MeList meList;

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
     * Gets the value of the mdAttrs property.
     * 
     * @return
     *     possible object is
     *     {@link ManagementDomainT }
     *     
     */
    public ManagementDomainT getMdAttrs() {
        return mdAttrs;
    }

    /**
     * Sets the value of the mdAttrs property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagementDomainT }
     *     
     */
    public void setMdAttrs(ManagementDomainT value) {
        this.mdAttrs = value;
    }

    /**
     * Gets the value of the meList property.
     * 
     * @return
     *     possible object is
     *     {@link MDInventoryT.MeList }
     *     
     */
    public MDInventoryT.MeList getMeList() {
        return meList;
    }

    /**
     * Sets the value of the meList property.
     * 
     * @param value
     *     allowed object is
     *     {@link MDInventoryT.MeList }
     *     
     */
    public void setMeList(MDInventoryT.MeList value) {
        this.meList = value;
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
     *         &lt;element name="meInv" type="{tmf854.v1}ME_Inventory_T" maxOccurs="unbounded"/>
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
        "meInv"
    })
    public static class MeList {

        @XmlElement(required = true)
        protected List<MEInventoryT> meInv;

        /**
         * Gets the value of the meInv property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the meInv property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMeInv().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link MEInventoryT }
         * 
         * 
         */
        public List<MEInventoryT> getMeInv() {
            if (meInv == null) {
                meInv = new ArrayList<MEInventoryT>();
            }
            return this.meInv;
        }

    }

}
