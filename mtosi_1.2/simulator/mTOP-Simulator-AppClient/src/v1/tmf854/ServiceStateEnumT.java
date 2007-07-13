
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for serviceStateEnumT.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="serviceStateEnumT">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SERV_NA"/>
 *     &lt;enumeration value="OUT_OF_SERVICE_BY_MAINTENANCE"/>
 *     &lt;enumeration value="OUT_OF_SERVICE"/>
 *     &lt;enumeration value="IN_SERVICE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum ServiceStateEnumT {

    SERV_NA,
    OUT_OF_SERVICE_BY_MAINTENANCE,
    OUT_OF_SERVICE,
    IN_SERVICE;

    public String value() {
        return name();
    }

    public static ServiceStateEnumT fromValue(String v) {
        return valueOf(v);
    }

}
