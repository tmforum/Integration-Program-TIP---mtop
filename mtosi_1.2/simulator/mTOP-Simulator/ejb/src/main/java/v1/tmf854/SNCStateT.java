
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for SNCState_T.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SNCState_T">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SNCS_NONEXISTENT"/>
 *     &lt;enumeration value="SNCS_PENDING"/>
 *     &lt;enumeration value="SNCS_ACTIVE"/>
 *     &lt;enumeration value="SNCS_PARTIAL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum SNCStateT {

    SNCS_NONEXISTENT,
    SNCS_PENDING,
    SNCS_ACTIVE,
    SNCS_PARTIAL;

    public String value() {
        return name();
    }

    public static SNCStateT fromValue(String v) {
        return valueOf(v);
    }

}
