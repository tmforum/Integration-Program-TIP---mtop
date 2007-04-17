
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for ResourceStateEnum_T.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ResourceStateEnum_T">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PLANNED"/>
 *     &lt;enumeration value="INSTALLED"/>
 *     &lt;enumeration value="RETIRED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum ResourceStateEnumT {

    PLANNED,
    INSTALLED,
    RETIRED;

    public String value() {
        return name();
    }

    public static ResourceStateEnumT fromValue(String v) {
        return valueOf(v);
    }

}
