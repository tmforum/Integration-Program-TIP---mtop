
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for TPConnectionState_T.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TPConnectionState_T">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TPCS_NA"/>
 *     &lt;enumeration value="TPCS_SOURCE_CONNECTED"/>
 *     &lt;enumeration value="TPCS_SINK_CONNECTED"/>
 *     &lt;enumeration value="TPCS_BI_CONNECTED"/>
 *     &lt;enumeration value="TPCS_NOT_CONNECTED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum TPConnectionStateT {

    TPCS_NA,
    TPCS_SOURCE_CONNECTED,
    TPCS_SINK_CONNECTED,
    TPCS_BI_CONNECTED,
    TPCS_NOT_CONNECTED;

    public String value() {
        return name();
    }

    public static TPConnectionStateT fromValue(String v) {
        return valueOf(v);
    }

}
