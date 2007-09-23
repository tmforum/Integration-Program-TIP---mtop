
package v1.tmf854;

import java.math.BigInteger;
import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 * 
 *       The definition of the list of PGP parameters.
 *       It should be noted that although the term MSP was chosen as the original specific protection scheme to which the related behaviour applied was Multiplex Section Protection, the label is now more generally applied to any 1+1 or 1:N Trail protection scheme.
 *       PG type "1+1 trail protection" refers to ProtectionGroupType "MSP_1_PLUS_1",
 *       PG type "1:N trail protection" refers to ProtectionGroupType "MSP_1_FOR_N",
 *       PG type "2-F MSSPRING" refers to ProtectionGroupType "2_FIBER_BLSR",
 *       PG type "2-F MSSPRING" refers to ProtectionGroupType "4_FIBER_BLSR".
 *       
 * 
 * <p>Java class for PGPParameters_T complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PGPParameters_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="SwitchMode" type="{tmf854.v1}SwitchMode_T" minOccurs="0"/>
 *         &lt;element name="SPRINGProtocol" type="{tmf854.v1}SPRINGProtocol_T" minOccurs="0"/>
 *         &lt;element name="SPRINGNodeId" type="{tmf854.v1}SPRINGNodeId_T" minOccurs="0"/>
 *         &lt;element name="SwitchPosition" type="{tmf854.v1}SwitchPosition_T" minOccurs="0"/>
 *         &lt;element name="NonPreEmptibleTraffic" type="{tmf854.v1}NonPreEmptibleTraffic_T" minOccurs="0"/>
 *         &lt;element name="WtrTime" type="{tmf854.v1}WtrTime_T" minOccurs="0"/>
 *         &lt;element name="HoldOffTime" type="{tmf854.v1}HoldOffTime_T" minOccurs="0"/>
 *         &lt;element name="LODNumSwitches" type="{tmf854.v1}LODNumSwitches_T" minOccurs="0"/>
 *         &lt;element name="LODDuration" type="{tmf854.v1}LODDuration_T" minOccurs="0"/>
 *         &lt;element name="TandemSwitching" type="{tmf854.v1}TandemSwitching_T" minOccurs="0"/>
 *         &lt;element name="BundleSwitching" type="{tmf854.v1}BundleSwitching_T" minOccurs="0"/>
 *         &lt;element name="Hitless" type="{tmf854.v1}Hitless_T" minOccurs="0"/>
 *         &lt;element name="ExerciseOn" type="{tmf854.v1}ExerciseOn_T" minOccurs="0"/>
 *         &lt;element name="AvailabilityStatus" type="{tmf854.v1}AvailabilityStatus_T" minOccurs="0"/>
 *         &lt;element name="SwitchCriteriaEnable" type="{tmf854.v1}SwitchCriteriaEnable_T" minOccurs="0"/>
 *         &lt;element name="PrivilegedChannel" type="{tmf854.v1}PrivilegedChannel_T" minOccurs="0"/>
 *         &lt;element name="vendorExtensions" type="{tmf854.v1}PGPParametersExt_T" minOccurs="0"/>
 *       &lt;/all>
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
@XmlType(name = "PGPParameters_T", propOrder = {

})
@Entity
public class PGPParametersT implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @XmlElement(name = "SwitchMode")
    protected String switchMode;
    @XmlElement(name = "SPRINGProtocol")
    protected String springProtocol;
    @XmlElement(name = "SPRINGNodeId")
    protected String springNodeId;
    @XmlElement(name = "SwitchPosition")
    @Enumerated(EnumType.STRING)
    protected SwitchPositionT switchPosition;
    @XmlElement(name = "NonPreEmptibleTraffic")
    @Enumerated(EnumType.STRING)
    protected NonPreEmptibleTrafficT nonPreEmptibleTraffic;
    @XmlElement(name = "WtrTime")
    protected BigInteger wtrTime;
    @XmlElement(name = "HoldOffTime")
    protected String holdOffTime;
    @XmlElement(name = "LODNumSwitches")
    protected Long lodNumSwitches;
    @XmlElement(name = "LODDuration")
    protected BigInteger lodDuration;
    @XmlElement(name = "TandemSwitching")
    protected String tandemSwitching;
    @XmlElement(name = "BundleSwitching")
    protected String bundleSwitching;
    @XmlElement(name = "Hitless")
    @Enumerated(EnumType.STRING)
    protected HitlessT hitless;
    @XmlElement(name = "ExerciseOn")
    protected Boolean exerciseOn;
    @XmlElement(name = "AvailabilityStatus")
    protected String availabilityStatus;
    @XmlElement(name = "SwitchCriteriaEnable")
    protected String switchCriteriaEnable;
    @XmlElement(name = "PrivilegedChannel")
    protected String privilegedChannel;
    @Transient
    protected PGPParametersExtT vendorExtensions;
    @XmlAttribute
    protected String extAuthor;
    @XmlAttribute
    protected String extVersion;
    @XmlAttribute
    protected String tmf854Version;

    /**
     * Gets the value of the switchMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSwitchMode() {
        return switchMode;
    }

    /**
     * Sets the value of the switchMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSwitchMode(String value) {
        this.switchMode = value;
    }

    /**
     * Gets the value of the springProtocol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSPRINGProtocol() {
        return springProtocol;
    }

    /**
     * Sets the value of the springProtocol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSPRINGProtocol(String value) {
        this.springProtocol = value;
    }

    /**
     * Gets the value of the springNodeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSPRINGNodeId() {
        return springNodeId;
    }

    /**
     * Sets the value of the springNodeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSPRINGNodeId(String value) {
        this.springNodeId = value;
    }

    /**
     * Gets the value of the switchPosition property.
     * 
     * @return
     *     possible object is
     *     {@link SwitchPositionT }
     *     
     */
    public SwitchPositionT getSwitchPosition() {
        return switchPosition;
    }

    /**
     * Sets the value of the switchPosition property.
     * 
     * @param value
     *     allowed object is
     *     {@link SwitchPositionT }
     *     
     */
    public void setSwitchPosition(SwitchPositionT value) {
        this.switchPosition = value;
    }

    /**
     * Gets the value of the nonPreEmptibleTraffic property.
     * 
     * @return
     *     possible object is
     *     {@link NonPreEmptibleTrafficT }
     *     
     */
    public NonPreEmptibleTrafficT getNonPreEmptibleTraffic() {
        return nonPreEmptibleTraffic;
    }

    /**
     * Sets the value of the nonPreEmptibleTraffic property.
     * 
     * @param value
     *     allowed object is
     *     {@link NonPreEmptibleTrafficT }
     *     
     */
    public void setNonPreEmptibleTraffic(NonPreEmptibleTrafficT value) {
        this.nonPreEmptibleTraffic = value;
    }

    /**
     * Gets the value of the wtrTime property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getWtrTime() {
        return wtrTime;
    }

    /**
     * Sets the value of the wtrTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setWtrTime(BigInteger value) {
        this.wtrTime = value;
    }

    /**
     * Gets the value of the holdOffTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHoldOffTime() {
        return holdOffTime;
    }

    /**
     * Sets the value of the holdOffTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHoldOffTime(String value) {
        this.holdOffTime = value;
    }

    /**
     * Gets the value of the lodNumSwitches property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLODNumSwitches() {
        return lodNumSwitches;
    }

    /**
     * Sets the value of the lodNumSwitches property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLODNumSwitches(Long value) {
        this.lodNumSwitches = value;
    }

    /**
     * Gets the value of the lodDuration property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLODDuration() {
        return lodDuration;
    }

    /**
     * Sets the value of the lodDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLODDuration(BigInteger value) {
        this.lodDuration = value;
    }

    /**
     * Gets the value of the tandemSwitching property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTandemSwitching() {
        return tandemSwitching;
    }

    /**
     * Sets the value of the tandemSwitching property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTandemSwitching(String value) {
        this.tandemSwitching = value;
    }

    /**
     * Gets the value of the bundleSwitching property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBundleSwitching() {
        return bundleSwitching;
    }

    /**
     * Sets the value of the bundleSwitching property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBundleSwitching(String value) {
        this.bundleSwitching = value;
    }

    /**
     * Gets the value of the hitless property.
     * 
     * @return
     *     possible object is
     *     {@link HitlessT }
     *     
     */
    public HitlessT getHitless() {
        return hitless;
    }

    /**
     * Sets the value of the hitless property.
     * 
     * @param value
     *     allowed object is
     *     {@link HitlessT }
     *     
     */
    public void setHitless(HitlessT value) {
        this.hitless = value;
    }

    /**
     * Gets the value of the exerciseOn property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExerciseOn() {
        return exerciseOn;
    }

    /**
     * Sets the value of the exerciseOn property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExerciseOn(Boolean value) {
        this.exerciseOn = value;
    }

    /**
     * Gets the value of the availabilityStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    /**
     * Sets the value of the availabilityStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvailabilityStatus(String value) {
        this.availabilityStatus = value;
    }

    /**
     * Gets the value of the switchCriteriaEnable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSwitchCriteriaEnable() {
        return switchCriteriaEnable;
    }

    /**
     * Sets the value of the switchCriteriaEnable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSwitchCriteriaEnable(String value) {
        this.switchCriteriaEnable = value;
    }

    /**
     * Gets the value of the privilegedChannel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrivilegedChannel() {
        return privilegedChannel;
    }

    /**
     * Sets the value of the privilegedChannel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrivilegedChannel(String value) {
        this.privilegedChannel = value;
    }

    /**
     * Gets the value of the vendorExtensions property.
     * 
     * @return
     *     possible object is
     *     {@link PGPParametersExtT }
     *     
     */
    public PGPParametersExtT getVendorExtensions() {
        return vendorExtensions;
    }

    /**
     * Sets the value of the vendorExtensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link PGPParametersExtT }
     *     
     */
    public void setVendorExtensions(PGPParametersExtT value) {
        this.vendorExtensions = value;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
