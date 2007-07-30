
package v1.tmf854;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * 
 *         A union containment of all forms of TerminationPoints (PTP, FTP, and CTP)
 *       
 * 
 * <p>Java class for TerminationPoint_T complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TerminationPoint_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="ptp" type="{tmf854.v1}PhysicalTerminationPoint_T"/>
 *         &lt;element name="ftp" type="{tmf854.v1}FloatingTerminationPoint_T"/>
 *         &lt;element name="ctp" type="{tmf854.v1}ConnectionTerminationPoint_T"/>
 *       &lt;/choice>
 *       &lt;attribute name="extAuthor" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="extVersion" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="tmf854Version" type="{tmf854.v1}TMF854_Version_T" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TerminationPoint_T", propOrder = {
    "ptp",
    "ftp",
    "ctp"
})
@Entity
@Table(name = "TPT")
public class TerminationPointT implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="TPoint_ID")
    private Long idTPoint;
    @OneToOne(cascade={CascadeType.ALL})
    protected PhysicalTerminationPointT ptp;
    @OneToOne(cascade={CascadeType.ALL})
    protected FloatingTerminationPointT ftp;
    @OneToOne(cascade={CascadeType.ALL})
    protected ConnectionTerminationPointT ctp;
    @XmlAttribute
    protected String extAuthor;
    @XmlAttribute
    protected String extVersion;
    @XmlAttribute
    protected String tmf854Version;

    /**
     * Gets the value of the ptp property.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalTerminationPointT }
     *     
     */
    public PhysicalTerminationPointT getPtp() {
        return ptp;
    }

    /**
     * Sets the value of the ptp property.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalTerminationPointT }
     *     
     */
    public void setPtp(PhysicalTerminationPointT value) {
        this.ptp = value;
    }

    /**
     * Gets the value of the ftp property.
     * 
     * @return
     *     possible object is
     *     {@link FloatingTerminationPointT }
     *     
     */
    public FloatingTerminationPointT getFtp() {
        return ftp;
    }

    /**
     * Sets the value of the ftp property.
     * 
     * @param value
     *     allowed object is
     *     {@link FloatingTerminationPointT }
     *     
     */
    public void setFtp(FloatingTerminationPointT value) {
        this.ftp = value;
    }

    /**
     * Gets the value of the ctp property.
     * 
     * @return
     *     possible object is
     *     {@link ConnectionTerminationPointT }
     *     
     */
    public ConnectionTerminationPointT getCtp() {
        return ctp;
    }

    /**
     * Sets the value of the ctp property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConnectionTerminationPointT }
     *     
     */
    public void setCtp(ConnectionTerminationPointT value) {
        this.ctp = value;
    }

    /**
     * Gets the value of the extAuthor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtAuthor() {
        return extAuthor;
    }

    /**
     * Sets the value of the extAuthor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtAuthor(String value) {
        this.extAuthor = value;
    }

    /**
     * Gets the value of the extVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtVersion() {
        return extVersion;
    }

    /**
     * Sets the value of the extVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtVersion(String value) {
        this.extVersion = value;
    }

    /**
     * Gets the value of the tmf854Version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTmf854Version() {
        return tmf854Version;
    }

    /**
     * Sets the value of the tmf854Version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTmf854Version(String value) {
        this.tmf854Version = value;
    }

    public Long getIdTPoint() {
        return idTPoint;
    }

    public void setIdTPoint(Long idTPoint) {
        this.idTPoint = idTPoint;
    }

    

}
