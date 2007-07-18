
package v1.tmf854;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;p xmlns="tmf854.v1" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;This is the iterator request to return the next batch of object names from the OS to which an object name retrieval request was initially sent.&lt;/p&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;p xmlns="tmf854.v1" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Refer to the TMF 854 XML Solution Set document for details on the Message Exchange Pattern controls.&lt;/p&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;p xmlns="tmf854.v1" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Raises ProcessingFailureException 
 * &lt;li&gt;EXCPT_INTERNAL_ERROR - Raised in case of non-specific OS internal failure&lt;/li&gt;&lt;li&gt;EXCPT_INVALID_INPUT - Raised when an invalid input parameter is provided&lt;/li&gt;&lt;li&gt;EXCPT_COMM_FAILURE - Raised when communication to an entity (needed to help fulfill the request) is lost&lt;/li&gt;&lt;/p&gt;
 * </pre>
 * 
 * 
 * <p>Java class for getAllObjectNamesIterator_T complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAllObjectNamesIterator_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="extAuthor" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="extVersion" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="tmf854Version" type="{tmf854.v1}TMF854_Version_T" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllObjectNamesIterator_T")
public class GetAllObjectNamesIteratorT {

    @XmlAttribute
    protected String extAuthor;
    @XmlAttribute
    protected String extVersion;
    @XmlAttribute
    protected String tmf854Version;

    /**
     * Gets the value of the extAuthor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtAuthor() {
        return extAuthor;
    }

    /**
     * Sets the value of the extAuthor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtAuthor(String value) {
        this.extAuthor = value;
    }

    /**
     * Gets the value of the extVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtVersion() {
        return extVersion;
    }

    /**
     * Sets the value of the extVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtVersion(String value) {
        this.extVersion = value;
    }

    /**
     * Gets the value of the tmf854Version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTmf854Version() {
        return tmf854Version;
    }

    /**
     * Sets the value of the tmf854Version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTmf854Version(String value) {
        this.tmf854Version = value;
    }

}
