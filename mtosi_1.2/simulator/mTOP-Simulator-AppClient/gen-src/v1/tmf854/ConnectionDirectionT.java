
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for connectionDirectionT.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="connectionDirectionT">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CD_BI"/>
 *     &lt;enumeration value="CD_UNI"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum ConnectionDirectionT {

    CD_BI,
    CD_UNI;

    public String value() {
        return name();
    }

    public static ConnectionDirectionT fromValue(String v) {
        return valueOf(v);
    }

}
