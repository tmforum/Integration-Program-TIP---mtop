
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for TMDState_T.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TMDState_T">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TMD_MISSING"/>
 *     &lt;enumeration value="NOT_APPLICABLE"/>
 *     &lt;enumeration value="PENDING"/>
 *     &lt;enumeration value="APPLIED"/>
 *     &lt;enumeration value="MISMATCH"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum TMDStateT {

    TMD_MISSING,
    NOT_APPLICABLE,
    PENDING,
    APPLIED,
    MISMATCH;

    public String value() {
        return name();
    }

    public static TMDStateT fromValue(String v) {
        return valueOf(v);
    }

}
