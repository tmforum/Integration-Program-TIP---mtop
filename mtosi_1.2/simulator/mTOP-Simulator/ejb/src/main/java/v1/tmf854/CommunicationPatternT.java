
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for CommunicationPattern_T.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CommunicationPattern_T">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SimpleResponse"/>
 *     &lt;enumeration value="MultipleBatchResponse"/>
 *     &lt;enumeration value="BulkResponse"/>
 *     &lt;enumeration value="Notification"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum CommunicationPatternT {

    @XmlEnumValue("SimpleResponse")
    SIMPLE_RESPONSE("SimpleResponse"),
    @XmlEnumValue("MultipleBatchResponse")
    MULTIPLE_BATCH_RESPONSE("MultipleBatchResponse"),
    @XmlEnumValue("BulkResponse")
    BULK_RESPONSE("BulkResponse"),
    @XmlEnumValue("Notification")
    NOTIFICATION("Notification");
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
