
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for HolderState_T.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HolderState_T">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="EMPTY"/>
 *     &lt;enumeration value="INSTALLED_AND_EXPECTED"/>
 *     &lt;enumeration value="EXPECTED_AND_NOT_INSTALLED"/>
 *     &lt;enumeration value="INSTALLED_AND_NOT_EXPECTED"/>
 *     &lt;enumeration value="MISMATCH_OF_INSTALLED_AND_EXPECTED"/>
 *     &lt;enumeration value="UNAVAILABLE"/>
 *     &lt;enumeration value="UNKNOWN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum HolderStateT {

    EMPTY,
    INSTALLED_AND_EXPECTED,
    EXPECTED_AND_NOT_INSTALLED,
    INSTALLED_AND_NOT_EXPECTED,
    MISMATCH_OF_INSTALLED_AND_EXPECTED,
    UNAVAILABLE,
    UNKNOWN;

    public String value() {
        return name();
    }

    public static HolderStateT fromValue(String v) {
        return valueOf(v);
    }

}
