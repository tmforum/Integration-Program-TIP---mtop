
package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for objectAcronymT.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="objectAcronymT">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="VO"/>
 *     &lt;enumeration value="TMD"/>
 *     &lt;enumeration value="OS"/>
 *     &lt;enumeration value="TL"/>
 *     &lt;enumeration value="MLSN"/>
 *     &lt;enumeration value="CC"/>
 *     &lt;enumeration value="RT"/>
 *     &lt;enumeration value="SNC"/>
 *     &lt;enumeration value="PGP"/>
 *     &lt;enumeration value="EPGP"/>
 *     &lt;enumeration value="TPPool"/>
 *     &lt;enumeration value="CTP"/>
 *     &lt;enumeration value="FTP"/>
 *     &lt;enumeration value="PTP"/>
 *     &lt;enumeration value="EQ"/>
 *     &lt;enumeration value="EH"/>
 *     &lt;enumeration value="ME"/>
 *     &lt;enumeration value="MD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum ObjectAcronymT {

    VO("VO"),
    TMD("TMD"),
    OS("OS"),
    TL("TL"),
    MLSN("MLSN"),
    CC("CC"),
    RT("RT"),
    SNC("SNC"),
    PGP("PGP"),
    EPGP("EPGP"),
    @XmlEnumValue("TPPool")
    TP_POOL("TPPool"),
    CTP("CTP"),
    FTP("FTP"),
    PTP("PTP"),
    EQ("EQ"),
    EH("EH"),
    ME("ME"),
    MD("MD");
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
