
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for NetworkRouted_T.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NetworkRouted_T">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NR_NA"/>
 *     &lt;enumeration value="NR_NO"/>
 *     &lt;enumeration value="NR_YES"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum NetworkRoutedT {

    NR_NA,
    NR_NO,
    NR_YES;

    public String value() {
        return name();
    }

    public static NetworkRoutedT fromValue(String v) {
        return valueOf(v);
    }

}
