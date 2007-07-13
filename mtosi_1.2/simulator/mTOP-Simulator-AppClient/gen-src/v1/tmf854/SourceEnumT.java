
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for sourceEnumT.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="sourceEnumT">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="networkEMS"/>
 *     &lt;enumeration value="OS"/>
 *     &lt;enumeration value="networkME"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum SourceEnumT {

    @XmlEnumValue("networkEMS")
    NETWORK_EMS("networkEMS"),
    OS("OS"),
    @XmlEnumValue("networkME")
    NETWORK_ME("networkME");
    private final String value;

    SourceEnumT(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SourceEnumT fromValue(String v) {
        for (SourceEnumT c: SourceEnumT.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}
