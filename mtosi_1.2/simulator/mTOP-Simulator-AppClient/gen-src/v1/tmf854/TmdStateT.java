
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for tmdStateT.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="tmdStateT">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MISMATCH"/>
 *     &lt;enumeration value="APPLIED"/>
 *     &lt;enumeration value="PENDING"/>
 *     &lt;enumeration value="NOT_APPLICABLE"/>
 *     &lt;enumeration value="TMD_MISSING"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum TmdStateT {

    MISMATCH,
    APPLIED,
    PENDING,
    NOT_APPLICABLE,
    TMD_MISSING;

    public String value() {
        return name();
    }

    public static TmdStateT fromValue(String v) {
        return valueOf(v);
    }

}
