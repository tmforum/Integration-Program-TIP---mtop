
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for switchPositionT.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="switchPositionT">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SWITCH"/>
 *     &lt;enumeration value="PASS_THROUGH"/>
 *     &lt;enumeration value="IDLE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum SwitchPositionT {

    SWITCH,
    PASS_THROUGH,
    IDLE;

    public String value() {
        return name();
    }

    public static SwitchPositionT fromValue(String v) {
        return valueOf(v);
    }

}
