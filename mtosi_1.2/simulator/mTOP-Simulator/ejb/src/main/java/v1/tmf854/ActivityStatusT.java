
package v1.tmf854;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * 
 * Add to the initial enumerations the Qualifiable extension.
 * 		
 * 
 * <p>Java class for ActivityStatus_T complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActivityStatus_T">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;tmf854.v1>ActivityStatusEnum_T">
 *       &lt;attribute name="qualifier" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActivityStatus_T", propOrder = {
    "value"
})
public class ActivityStatusT {

    @XmlValue
    protected ActivityStatusEnumT value;
    @XmlAttribute
    protected String qualifier;

    /**
     * 
     * Specifies the high-level response status for an activity.  Required for response messages, including error responses.
     * 		
     * 
     * @return
     *     possible object is
     *     {@link ActivityStatusEnumT }
     *     
     */
    public ActivityStatusEnumT getValue() {
        return value;
    }

    /**
     * 
     * Specifies the high-level response status for an activity.  Required for response messages, including error responses.
     * 		
     * 
     * @param value
     *     allowed object is
     *     {@link ActivityStatusEnumT }
     *     
     */
    public void setValue(ActivityStatusEnumT value) {
        this.value = value;
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
