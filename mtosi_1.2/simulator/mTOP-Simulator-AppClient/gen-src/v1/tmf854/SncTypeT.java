
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for sncTypeT.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="sncTypeT">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ST_EXPLICIT"/>
 *     &lt;enumeration value="ST_OPEN_ADD_DROP"/>
 *     &lt;enumeration value="ST_DOUBLE_ADD_DROP"/>
 *     &lt;enumeration value="ST_DOUBLE_INTERCONNECT"/>
 *     &lt;enumeration value="ST_INTERCONNECT"/>
 *     &lt;enumeration value="ST_ADD_DROP_Z"/>
 *     &lt;enumeration value="ST_ADD_DROP_A"/>
 *     &lt;enumeration value="ST_SIMPLE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum SncTypeT {

    ST_EXPLICIT,
    ST_OPEN_ADD_DROP,
    ST_DOUBLE_ADD_DROP,
    ST_DOUBLE_INTERCONNECT,
    ST_INTERCONNECT,
    ST_ADD_DROP_Z,
    ST_ADD_DROP_A,
    ST_SIMPLE;

    public String value() {
        return name();
    }

    public static SncTypeT fromValue(String v) {
        return valueOf(v);
    }

}
