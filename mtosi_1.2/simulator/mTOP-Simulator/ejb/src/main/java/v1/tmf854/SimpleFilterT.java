
package v1.tmf854;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SimpleFilter_T complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SimpleFilter_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="baseInstance" type="{tmf854.v1}NamingAttributes_T" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="includedObjectType" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="objectType" type="{tmf854.v1}ObjectAcronym_T"/>
 *                   &lt;element name="granularity" type="{tmf854.v1}Granularity_T"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SimpleFilter_T", propOrder = {
    "baseInstance",
    "includedObjectType"
})
public class SimpleFilterT {

    protected List<NamingAttributesT> baseInstance;
    protected List<SimpleFilterT.IncludedObjectType> includedObjectType;

    /**
     * Gets the value of the baseInstance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the baseInstance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBaseInstance().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NamingAttributesT }
     * 
     * 
     */
    public List<NamingAttributesT> getBaseInstance() {
        if (baseInstance == null) {
            baseInstance = new ArrayList<NamingAttributesT>();
        }
        return this.baseInstance;
    }

    /**
     * Gets the value of the includedObjectType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the includedObjectType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIncludedObjectType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SimpleFilterT.IncludedObjectType }
     * 
     * 
     */
    public List<SimpleFilterT.IncludedObjectType> getIncludedObjectType() {
        if (includedObjectType == null) {
            includedObjectType = new ArrayList<SimpleFilterT.IncludedObjectType>();
        }
        return this.includedObjectType;
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
     *         &lt;element name="objectType" type="{tmf854.v1}ObjectAcronym_T"/>
     *         &lt;element name="granularity" type="{tmf854.v1}Granularity_T"/>
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
        "objectType",
        "granularity"
    })
    public static class IncludedObjectType {

        @XmlElement(required = true)
        protected ObjectAcronymT objectType;
        @XmlElement(required = true)
        protected GranularityT granularity;

        /**
         * Gets the value of the objectType property.
         * 
         * @return
         *     possible object is
         *     {@link ObjectAcronymT }
         *     
         */
        public ObjectAcronymT getObjectType() {
            return objectType;
        }

        /**
         * Sets the value of the objectType property.
         * 
         * @param value
         *     allowed object is
         *     {@link ObjectAcronymT }
         *     
         */
        public void setObjectType(ObjectAcronymT value) {
            this.objectType = value;
        }

        /**
         * Gets the value of the granularity property.
         * 
         * @return
         *     possible object is
         *     {@link GranularityT }
         *     
         */
        public GranularityT getGranularity() {
            return granularity;
        }

        /**
         * Sets the value of the granularity property.
         * 
         * @param value
         *     allowed object is
         *     {@link GranularityT }
         *     
         */
        public void setGranularity(GranularityT value) {
            this.granularity = value;
        }

    }

}
