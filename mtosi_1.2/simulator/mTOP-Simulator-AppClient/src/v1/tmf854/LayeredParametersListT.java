
package v1.tmf854;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LayeredParametersList_T complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LayeredParametersList_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="layeredParameters" type="{tmf854.v1}LayeredParameters_T" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LayeredParametersList_T", propOrder = {
    "layeredParameters"
})
public class LayeredParametersListT {

    @XmlElement(nillable = true)
    protected List<LayeredParametersT> layeredParameters;

    /**
     * Gets the value of the layeredParameters property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the layeredParameters property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLayeredParameters().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LayeredParametersT }
     * 
     * 
     */
    public List<LayeredParametersT> getLayeredParameters() {
        if (layeredParameters == null) {
            layeredParameters = new ArrayList<LayeredParametersT>();
        }
        return this.layeredParameters;
    }

}
