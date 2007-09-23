
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for ObjectAcronym_T.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ObjectAcronym_T">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MD"/>
 *     &lt;enumeration value="ME"/>
 *     &lt;enumeration value="EH"/>
 *     &lt;enumeration value="EQ"/>
 *     &lt;enumeration value="PTP"/>
 *     &lt;enumeration value="FTP"/>
 *     &lt;enumeration value="CTP"/>
 *     &lt;enumeration value="TPPool"/>
 *     &lt;enumeration value="EPGP"/>
 *     &lt;enumeration value="PGP"/>
 *     &lt;enumeration value="SNC"/>
 *     &lt;enumeration value="RT"/>
 *     &lt;enumeration value="CC"/>
 *     &lt;enumeration value="MLSN"/>
 *     &lt;enumeration value="TL"/>
 *     &lt;enumeration value="OS"/>
 *     &lt;enumeration value="TMD"/>
 *     &lt;enumeration value="VO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum ObjectAcronymT {

    MD("MD"),
    ME("ME"),
    EH("EH"),
    EQ("EQ"),
    PTP("PTP"),
    FTP("FTP"),
    CTP("CTP"),
    @XmlEnumValue("TPPool")
    TP_POOL("TPPool"),
    EPGP("EPGP"),
    PGP("PGP"),
    SNC("SNC"),
    RT("RT"),
    CC("CC"),
    MLSN("MLSN"),
    TL("TL"),
    OS("OS"),
    TMD("TMD"),
    VO("VO");
    private final String value;

    ObjectAcronymT(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ObjectAcronymT fromValue(String v) {
        for (ObjectAcronymT c: ObjectAcronymT.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}
