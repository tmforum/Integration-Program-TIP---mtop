
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for TerminationMode_T.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TerminationMode_T">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TM_NA"/>
 *     &lt;enumeration value="TM_NEITHER_TERMINATED_NOR_AVAILABLE_FOR_MAPPING"/>
 *     &lt;enumeration value="TM_TERMINATED_AND_AVAILABLE_FOR_MAPPING"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum TerminationModeT {

    TM_NA,
    TM_NEITHER_TERMINATED_NOR_AVAILABLE_FOR_MAPPING,
    TM_TERMINATED_AND_AVAILABLE_FOR_MAPPING;

    public String value() {
        return name();
    }

    public static TerminationModeT fromValue(String v) {
        return valueOf(v);
    }

}
