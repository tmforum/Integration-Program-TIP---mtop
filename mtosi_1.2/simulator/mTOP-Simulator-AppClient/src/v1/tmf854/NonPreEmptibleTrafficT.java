
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for nonPreEmptibleTrafficT.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="nonPreEmptibleTrafficT">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NOT_ALLOWED"/>
 *     &lt;enumeration value="ALLOWED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum NonPreEmptibleTrafficT {

    NOT_ALLOWED,
    ALLOWED;

    public String value() {
        return name();
    }

    public static NonPreEmptibleTrafficT fromValue(String v) {
        return valueOf(v);
    }

}
