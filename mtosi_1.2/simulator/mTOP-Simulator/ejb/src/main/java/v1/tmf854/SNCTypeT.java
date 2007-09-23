
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for SNCType_T.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SNCType_T">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ST_SIMPLE"/>
 *     &lt;enumeration value="ST_ADD_DROP_A"/>
 *     &lt;enumeration value="ST_ADD_DROP_Z"/>
 *     &lt;enumeration value="ST_INTERCONNECT"/>
 *     &lt;enumeration value="ST_DOUBLE_INTERCONNECT"/>
 *     &lt;enumeration value="ST_DOUBLE_ADD_DROP"/>
 *     &lt;enumeration value="ST_OPEN_ADD_DROP"/>
 *     &lt;enumeration value="ST_EXPLICIT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum SNCTypeT {

    ST_SIMPLE,
    ST_ADD_DROP_A,
    ST_ADD_DROP_Z,
    ST_INTERCONNECT,
    ST_DOUBLE_INTERCONNECT,
    ST_DOUBLE_ADD_DROP,
    ST_OPEN_ADD_DROP,
    ST_EXPLICIT;

    public String value() {
        return name();
    }

    public static SNCTypeT fromValue(String v) {
        return valueOf(v);
    }

}
