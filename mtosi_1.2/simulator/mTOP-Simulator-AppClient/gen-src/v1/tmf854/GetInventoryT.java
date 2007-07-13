
package v1.tmf854;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getInventory_T complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getInventory_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="filter" type="{tmf854.v1}SimpleFilter_T" minOccurs="0"/>
 *         &lt;element name="diffDateAndTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getInventory_T", propOrder = {
    "filter",
    "diffDateAndTime"
})
public class GetInventoryT {

    protected SimpleFilterT filter;
    protected String diffDateAndTime;

    /**
     * Gets the value of the filter property.
     * 
     * @return
     *     possible object is
     *     {@link SimpleFilterT }
     *     
     */
    public SimpleFilterT getFilter() {
        return filter;
    }

    /**
     * Sets the value of the filter property.
     * 
     * @param value
     *     allowed object is
     *     {@link SimpleFilterT }
     *     
     */
    public void setFilter(SimpleFilterT value) {
        this.filter = value;
    }

    /**
     * Gets the value of the diffDateAndTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiffDateAndTime() {
        return diffDateAndTime;
    }

    /**
     * Sets the value of the diffDateAndTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiffDateAndTime(String value) {
        this.diffDateAndTime = value;
    }

}
