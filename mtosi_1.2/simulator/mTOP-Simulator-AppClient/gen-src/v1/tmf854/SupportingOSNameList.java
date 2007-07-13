
package v1.tmf854;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for supportingOSNameList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="supportingOSNameList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="osNm" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="supportingOSNames" type="{tmf854.v1}supportingOSName" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "supportingOSNameList", propOrder = {

})
public class SupportingOSNameList {

    @XmlElement(nillable = true)
    protected List<String> osNm;
    @XmlElement(nillable = true)
    protected List<SupportingOSName> supportingOSNames;

    /**
     * Gets the value of the osNm property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the osNm property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOsNm().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getOsNm() {
        if (osNm == null) {
            osNm = new ArrayList<String>();
        }
        return this.osNm;
    }

    /**
     * Gets the value of the supportingOSNames property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supportingOSNames property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportingOSNames().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SupportingOSName }
     * 
     * 
     */
    public List<SupportingOSName> getSupportingOSNames() {
        if (supportingOSNames == null) {
            supportingOSNames = new ArrayList<SupportingOSName>();
        }
        return this.supportingOSNames;
    }

}
