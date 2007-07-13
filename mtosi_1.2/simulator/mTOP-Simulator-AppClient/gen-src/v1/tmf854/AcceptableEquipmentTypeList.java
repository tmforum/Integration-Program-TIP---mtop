
package v1.tmf854;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for acceptableEquipmentTypeList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="acceptableEquipmentTypeList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="acceptableEquipmentType" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="accs" type="{tmf854.v1}acceptableEquipmentType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "acceptableEquipmentTypeList", propOrder = {

})
public class AcceptableEquipmentTypeList {

    @XmlElement(nillable = true)
    protected List<String> acceptableEquipmentType;
    @XmlElement(nillable = true)
    protected List<AcceptableEquipmentType> accs;

    /**
     * Gets the value of the acceptableEquipmentType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the acceptableEquipmentType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAcceptableEquipmentType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAcceptableEquipmentType() {
        if (acceptableEquipmentType == null) {
            acceptableEquipmentType = new ArrayList<String>();
        }
        return this.acceptableEquipmentType;
    }

    /**
     * Gets the value of the accs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AcceptableEquipmentType }
     * 
     * 
     */
    public List<AcceptableEquipmentType> getAccs() {
        if (accs == null) {
            accs = new ArrayList<AcceptableEquipmentType>();
        }
        return this.accs;
    }

}
