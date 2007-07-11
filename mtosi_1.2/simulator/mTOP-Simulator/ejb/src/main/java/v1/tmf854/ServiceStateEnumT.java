
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for ServiceStateEnum_T.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ServiceStateEnum_T">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IN_SERVICE"/>
 *     &lt;enumeration value="OUT_OF_SERVICE"/>
 *     &lt;enumeration value="OUT_OF_SERVICE_BY_MAINTENANCE"/>
 *     &lt;enumeration value="SERV_NA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum ServiceStateEnumT {

    IN_SERVICE,
    OUT_OF_SERVICE,
    OUT_OF_SERVICE_BY_MAINTENANCE,
    SERV_NA;

    public String value() {
        return name();
    }

    public static ServiceStateEnumT fromValue(String v) {
        return valueOf(v);
    }

}
