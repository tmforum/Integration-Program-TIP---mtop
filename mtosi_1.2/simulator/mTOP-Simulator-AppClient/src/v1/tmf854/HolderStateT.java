
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for holderStateT.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="holderStateT">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="UNKNOWN"/>
 *     &lt;enumeration value="UNAVAILABLE"/>
 *     &lt;enumeration value="MISMATCH_OF_INSTALLED_AND_EXPECTED"/>
 *     &lt;enumeration value="INSTALLED_AND_NOT_EXPECTED"/>
 *     &lt;enumeration value="EXPECTED_AND_NOT_INSTALLED"/>
 *     &lt;enumeration value="INSTALLED_AND_EXPECTED"/>
 *     &lt;enumeration value="EMPTY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum HolderStateT {

    UNKNOWN,
    UNAVAILABLE,
    MISMATCH_OF_INSTALLED_AND_EXPECTED,
    INSTALLED_AND_NOT_EXPECTED,
    EXPECTED_AND_NOT_INSTALLED,
    INSTALLED_AND_EXPECTED,
    EMPTY;

    public String value() {
        return name();
    }

    public static HolderStateT fromValue(String v) {
        return valueOf(v);
    }

}
