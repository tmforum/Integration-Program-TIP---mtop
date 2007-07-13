
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for sncStateT.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="sncStateT">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SNCS_PARTIAL"/>
 *     &lt;enumeration value="SNCS_ACTIVE"/>
 *     &lt;enumeration value="SNCS_PENDING"/>
 *     &lt;enumeration value="SNCS_NONEXISTENT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum SncStateT {

    SNCS_PARTIAL,
    SNCS_ACTIVE,
    SNCS_PENDING,
    SNCS_NONEXISTENT;

    public String value() {
        return name();
    }

    public static SncStateT fromValue(String v) {
        return valueOf(v);
    }

}
