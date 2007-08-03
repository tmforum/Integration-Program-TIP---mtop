
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for CommunicationState_T.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CommunicationState_T">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CS_AVAILABLE"/>
 *     &lt;enumeration value="CS_UNAVAILABLE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum CommunicationStateT {

    CS_AVAILABLE,
    CS_UNAVAILABLE;

    public String value() {
        return name();
    }

    public static CommunicationStateT fromValue(String v) {
        return valueOf(v);
    }

}
