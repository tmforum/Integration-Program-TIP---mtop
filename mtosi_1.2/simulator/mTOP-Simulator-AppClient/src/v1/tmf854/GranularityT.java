
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for granularityT.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="granularityT">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FULL"/>
 *     &lt;enumeration value="ATTRS"/>
 *     &lt;enumeration value="NAME"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum GranularityT {

    FULL,
    ATTRS,
    NAME;

    public String value() {
        return name();
    }

    public static GranularityT fromValue(String v) {
        return valueOf(v);
    }

}
