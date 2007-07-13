
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for Granularity_T.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Granularity_T">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NAME"/>
 *     &lt;enumeration value="ATTRS"/>
 *     &lt;enumeration value="FULL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum GranularityT {

    NAME,
    ATTRS,
    FULL;

    public String value() {
        return name();
    }

    public static GranularityT fromValue(String v) {
        return valueOf(v);
    }

}
