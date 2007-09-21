package v1.tmf854;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InventoryData_T complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InventoryData_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="mdList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="md" type="{tmf854.v1}MD_Inventory_T" maxOccurs="unbounded"/>
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
@XmlType(name = "InventoryData_T", propOrder = {

})
public class InventoryDataT {

    protected InventoryDataT.MdList mdList;

    /**
     * Gets the value of the mdList property.
     * 
     * @return
     *     possible object is
     *     {@link InventoryDataT.MdList }
     *     
     */
    public InventoryDataT.MdList getMdList() {
        return mdList;
    }

    /**
     * Sets the value of the mdList property.
     * 
     * @param value
     *     allowed object is
     *     {@link InventoryDataT.MdList }
     *     
     */
    public void setMdList(InventoryDataT.MdList value) {
        this.mdList = value;
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
     *         &lt;element name="md" type="{tmf854.v1}MD_Inventory_T" maxOccurs="unbounded"/>
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
        "md"
    })
    public static class MdList {

        @XmlElement(required = true)
        protected List<MDInventoryT> md;

        /**
         * Gets the value of the md property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the md property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMd().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link MDInventoryT }
         * 
         * 
         */
        public List<MDInventoryT> getMd() {
            if (md == null) {
                md = new ArrayList<MDInventoryT>();
            }
            return this.md;
        }

    }

}
