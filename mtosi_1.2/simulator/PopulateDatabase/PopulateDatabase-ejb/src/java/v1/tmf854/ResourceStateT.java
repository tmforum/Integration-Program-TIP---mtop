
package v1.tmf854;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * 
 *       This is the definition of the object attribute that indicates the state of the resource Note: this object attribute accepts Overlap or Qualifiable extensions.
 * 		
 * 
 * <p>Java class for ResourceState_T complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResourceState_T">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;tmf854.v1>ResourceStateEnum_T">
 *       &lt;attribute name="overlap" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="qualifier" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourceState_T", propOrder = {
    "value"
})
public class ResourceStateT {

    @XmlValue
    protected ResourceStateEnumT value;
    @XmlAttribute
    protected String overlap;
    @XmlAttribute
    protected String qualifier;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceStateEnumT }
     *     
     */
    public ResourceStateEnumT getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceStateEnumT }
     *     
     */
    public void setValue(ResourceStateEnumT value) {
        this.value = value;
    }

    /**
     * Gets the value of the overlap property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOverlap() {
        return overlap;
    }

    /**
     * Sets the value of the overlap property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOverlap(String value) {
        this.overlap = value;
    }

    /**
     * Gets the value of the qualifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQualifier() {
        return qualifier;
    }

    /**
     * Sets the value of the qualifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQualifier(String value) {
        this.qualifier = value;
    }

}
