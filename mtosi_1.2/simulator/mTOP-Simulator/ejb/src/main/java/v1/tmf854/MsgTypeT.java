
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for MsgType_T.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MsgType_T">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="REQUEST"/>
 *     &lt;enumeration value="RESPONSE"/>
 *     &lt;enumeration value="NOTIFICATION"/>
 *     &lt;enumeration value="ERROR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum MsgTypeT {

    REQUEST,
    RESPONSE,
    NOTIFICATION,
    ERROR;

    public String value() {
        return name();
    }

    public static MsgTypeT fromValue(String v) {
        return valueOf(v);
    }

}
