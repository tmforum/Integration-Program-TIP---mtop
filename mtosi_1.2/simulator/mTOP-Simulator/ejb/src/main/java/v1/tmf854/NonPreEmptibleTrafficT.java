
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for NonPreEmptibleTraffic_T.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NonPreEmptibleTraffic_T">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ALLOWED"/>
 *     &lt;enumeration value="NOT_ALLOWED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum NonPreEmptibleTrafficT {

    ALLOWED,
    NOT_ALLOWED;

    public String value() {
        return name();
    }

    public static NonPreEmptibleTrafficT fromValue(String v) {
        return valueOf(v);
    }

}
