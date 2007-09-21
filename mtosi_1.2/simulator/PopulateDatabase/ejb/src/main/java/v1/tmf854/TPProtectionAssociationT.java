
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for TPProtectionAssociation_T.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TPProtectionAssociation_T">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TPPA_NA"/>
 *     &lt;enumeration value="TPPA_PSR_RELATED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum TPProtectionAssociationT {

    TPPA_NA,
    TPPA_PSR_RELATED;

    public String value() {
        return name();
    }

    public static TPProtectionAssociationT fromValue(String v) {
        return valueOf(v);
    }

}
