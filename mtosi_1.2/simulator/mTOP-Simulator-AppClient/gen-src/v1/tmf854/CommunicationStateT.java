
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for communicationStateT.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="communicationStateT">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CS_UNAVAILABLE"/>
 *     &lt;enumeration value="CS_AVAILABLE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum CommunicationStateT {

    CS_UNAVAILABLE,
    CS_AVAILABLE;

    public String value() {
        return name();
    }

    public static CommunicationStateT fromValue(String v) {
        return valueOf(v);
    }

}
