
package v1.tmf854;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *       List of ManagedElements
 *       
 * 
 * <p>Java class for ManagedElementList_T complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ManagedElementList_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="me" type="{tmf854.v1}ManagedElement_T" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ManagedElementList_T", propOrder = {
    "me"
})
public class ManagedElementListT {

    protected List<ManagedElementT> me;

    /**
     * Gets the value of the me property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the me property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMe().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ManagedElementT }
     * 
     * 
     */
    public List<ManagedElementT> getMe() {
        if (me == null) {
            me = new ArrayList<ManagedElementT>();
        }
        return this.me;
    }

}
