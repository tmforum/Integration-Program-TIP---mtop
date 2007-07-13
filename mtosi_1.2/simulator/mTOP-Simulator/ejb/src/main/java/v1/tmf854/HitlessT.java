
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for Hitless_T.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Hitless_T">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Yes"/>
 *     &lt;enumeration value="No"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum HitlessT {

    @XmlEnumValue("Yes")
    YES("Yes"),
    @XmlEnumValue("No")
    NO("No");
    private final String value;

    HitlessT(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HitlessT fromValue(String v) {
        for (HitlessT c: HitlessT.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}
