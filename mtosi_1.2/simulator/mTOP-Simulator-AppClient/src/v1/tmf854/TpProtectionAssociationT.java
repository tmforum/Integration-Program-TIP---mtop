
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for tpProtectionAssociationT.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="tpProtectionAssociationT">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TPPA_PSR_RELATED"/>
 *     &lt;enumeration value="TPPA_NA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum TpProtectionAssociationT {

    TPPA_PSR_RELATED,
    TPPA_NA;

    public String value() {
        return name();
    }

    public static TpProtectionAssociationT fromValue(String v) {
        return valueOf(v);
    }

}
