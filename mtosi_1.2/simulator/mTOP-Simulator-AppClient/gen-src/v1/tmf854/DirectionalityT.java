
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for directionalityT.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="directionalityT">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="D_SINK"/>
 *     &lt;enumeration value="D_SOURCE"/>
 *     &lt;enumeration value="D_BIDIRECTIONAL"/>
 *     &lt;enumeration value="D_NA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum DirectionalityT {

    D_SINK,
    D_SOURCE,
    D_BIDIRECTIONAL,
    D_NA;

    public String value() {
        return name();
    }

    public static DirectionalityT fromValue(String v) {
        return valueOf(v);
    }

}
