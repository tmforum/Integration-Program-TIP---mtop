package v1.tmf854;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for CommunicationStyle_T.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CommunicationStyle_T">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MSG"/>
 *     &lt;enumeration value="RPC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum CommunicationStyleT {

    MSG,
    RPC;

    public String value() {
        return name();
    }

    public static CommunicationStyleT fromValue(String v) {
        return valueOf(v);
    }

}
