
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for Reroute_T.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Reroute_T">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="RR_NA"/>
 *     &lt;enumeration value="RR_NO"/>
 *     &lt;enumeration value="RR_YES"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum RerouteT {

    RR_NA,
    RR_NO,
    RR_YES;

    public String value() {
        return name();
    }

    public static RerouteT fromValue(String v) {
        return valueOf(v);
    }

}
