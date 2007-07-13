
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for resourceStateEnumT.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="resourceStateEnumT">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="RETIRED"/>
 *     &lt;enumeration value="INSTALLED"/>
 *     &lt;enumeration value="PLANNED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum ResourceStateEnumT {

    RETIRED,
    INSTALLED,
    PLANNED;

    public String value() {
        return name();
    }

    public static ResourceStateEnumT fromValue(String v) {
        return valueOf(v);
    }

}
