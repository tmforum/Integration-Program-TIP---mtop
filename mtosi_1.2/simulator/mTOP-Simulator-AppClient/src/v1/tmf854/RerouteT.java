
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for rerouteT.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="rerouteT">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="RR_YES"/>
 *     &lt;enumeration value="RR_NO"/>
 *     &lt;enumeration value="RR_NA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum RerouteT {

    RR_YES,
    RR_NO,
    RR_NA;

    public String value() {
        return name();
    }

    public static RerouteT fromValue(String v) {
        return valueOf(v);
    }

}
