
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for ReversionMode_T.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReversionMode_T">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="RM_UNKNOWN"/>
 *     &lt;enumeration value="RM_NON_REVERTIVE"/>
 *     &lt;enumeration value="RM_REVERTIVE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum ReversionModeT {

    RM_UNKNOWN,
    RM_NON_REVERTIVE,
    RM_REVERTIVE;

    public String value() {
        return name();
    }

    public static ReversionModeT fromValue(String v) {
        return valueOf(v);
    }

}
