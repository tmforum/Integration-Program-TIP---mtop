
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for activityStatusEnumT.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="activityStatusEnumT">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="WARNING"/>
 *     &lt;enumeration value="FAILURE"/>
 *     &lt;enumeration value="SUCCESS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum ActivityStatusEnumT {

    WARNING,
    FAILURE,
    SUCCESS;

    public String value() {
        return name();
    }

    public static ActivityStatusEnumT fromValue(String v) {
        return valueOf(v);
    }

}
