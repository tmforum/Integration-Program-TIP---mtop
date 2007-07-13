
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for communicationPatternT.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="communicationPatternT">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Notification"/>
 *     &lt;enumeration value="BulkResponse"/>
 *     &lt;enumeration value="MultipleBatchResponse"/>
 *     &lt;enumeration value="SimpleResponse"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum CommunicationPatternT {

    @XmlEnumValue("Notification")
    NOTIFICATION("Notification"),
    @XmlEnumValue("BulkResponse")
    BULK_RESPONSE("BulkResponse"),
    @XmlEnumValue("MultipleBatchResponse")
    MULTIPLE_BATCH_RESPONSE("MultipleBatchResponse"),
    @XmlEnumValue("SimpleResponse")
    SIMPLE_RESPONSE("SimpleResponse");
    private final String value;

    CommunicationPatternT(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CommunicationPatternT fromValue(String v) {
        for (CommunicationPatternT c: CommunicationPatternT.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}
