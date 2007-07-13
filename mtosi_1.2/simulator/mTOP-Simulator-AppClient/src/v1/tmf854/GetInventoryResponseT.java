
package v1.tmf854;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getInventoryResponse_T complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getInventoryResponse_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="inventoryData" type="{tmf854.v1}InventoryData_T" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getInventoryResponse_T", propOrder = {
    "inventoryData"
})
public class GetInventoryResponseT {

    protected InventoryDataT inventoryData;

    /**
     * Gets the value of the inventoryData property.
     * 
     * @return
     *     possible object is
     *     {@link InventoryDataT }
     *     
     */
    public InventoryDataT getInventoryData() {
        return inventoryData;
    }

    /**
     * Sets the value of the inventoryData property.
     * 
     * @param value
     *     allowed object is
     *     {@link InventoryDataT }
     *     
     */
    public void setInventoryData(InventoryDataT value) {
        this.inventoryData = value;
    }

}
