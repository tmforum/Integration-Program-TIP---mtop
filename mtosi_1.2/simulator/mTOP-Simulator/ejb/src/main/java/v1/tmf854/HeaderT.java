
package v1.tmf854;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *       		MTOSI Standard Header.
 *       	
 * 
 * <p>Java class for Header_T complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Header_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="activityName" type="{tmf854.v1}ActivityName_T"/>
 *         &lt;element name="msgName" type="{tmf854.v1}MsgName_T"/>
 *         &lt;element name="msgType" type="{tmf854.v1}MsgType_T"/>
 *         &lt;element name="senderURI" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="destinationURI" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="replyToURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="originatorURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="failureReplytoURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="activityStatus" type="{tmf854.v1}ActivityStatus_T" minOccurs="0"/>
 *         &lt;element name="correlationId" type="{tmf854.v1}CorrelationId_T" minOccurs="0"/>
 *         &lt;element name="security" type="{tmf854.v1}Security_T" minOccurs="0"/>
 *         &lt;element name="securityType" type="{tmf854.v1}SecurityType_T" minOccurs="0"/>
 *         &lt;element name="priority" type="{tmf854.v1}Priority_T" minOccurs="0"/>
 *         &lt;element name="msgSpecificProperties" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="property" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="propName" type="{tmf854.v1}PropName_T"/>
 *                             &lt;element name="propValue" type="{tmf854.v1}PropValue_T"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="communicationPattern" type="{tmf854.v1}CommunicationPattern_T"/>
 *         &lt;element name="communicationStyle" type="{tmf854.v1}CommunicationStyle_T"/>
 *         &lt;element name="requestedBatchSize" type="{tmf854.v1}RequestedBatchSize_T" minOccurs="0"/>
 *         &lt;element name="batchSequenceNumber" type="{tmf854.v1}BatchSequenceNumber_T" minOccurs="0"/>
 *         &lt;element name="batchSequenceEndOfReply" type="{tmf854.v1}BatchSequenceEndOfReply_T" minOccurs="0"/>
 *         &lt;element name="iteratorReferenceURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="fileLocationURI" type="{tmf854.v1}FileLocationURI_T" minOccurs="0"/>
 *         &lt;element name="compressionType" type="{tmf854.v1}CompressionType_T" minOccurs="0"/>
 *         &lt;element name="packingType" type="{tmf854.v1}PackingType_T" minOccurs="0"/>
 *         &lt;element name="timestamp" type="{tmf854.v1}ITU-Time_T" minOccurs="0"/>
 *         &lt;element name="vendorExtensions" type="{tmf854.v1}HdrVendorExtensions_T" minOccurs="0"/>
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
@XmlType(name = "Header_T", propOrder = {

})
public class HeaderT {

    @XmlElement(required = true)
    protected String activityName;
    @XmlElement(required = true)
    protected String msgName;
    @XmlElement(required = true)
    protected MsgTypeT msgType;
    @XmlElement(required = true)
    protected String senderURI;
    @XmlElement(required = true)
    protected String destinationURI;
    protected String replyToURI;
    protected String originatorURI;
    protected String failureReplytoURI;
    protected ActivityStatusT activityStatus;
    protected String correlationId;
    protected String security;
    protected String securityType;
    protected String priority;
    protected HeaderT.MsgSpecificProperties msgSpecificProperties;
    @XmlElement(required = true)
    protected CommunicationPatternT communicationPattern;
    @XmlElement(required = true)
    protected CommunicationStyleT communicationStyle;
    protected Long requestedBatchSize;
    protected Long batchSequenceNumber;
    protected Boolean batchSequenceEndOfReply;
    protected String iteratorReferenceURI;
    protected String fileLocationURI;
    protected String compressionType;
    protected String packingType;
    protected String timestamp;
    protected HdrVendorExtensionsT vendorExtensions;
    @XmlAttribute
    protected String extAuthor;
    @XmlAttribute
    protected String extVersion;
    @XmlAttribute
    protected String tmf854Version;

    /**
     * Gets the value of the activityName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivityName() {
        return activityName;
    }

    /**
     * Sets the value of the activityName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivityName(String value) {
        this.activityName = value;
    }

    /**
     * Gets the value of the msgName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgName() {
        return msgName;
    }

    /**
     * Sets the value of the msgName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgName(String value) {
        this.msgName = value;
    }

    /**
     * Gets the value of the msgType property.
     * 
     * @return
     *     possible object is
     *     {@link MsgTypeT }
     *     
     */
    public MsgTypeT getMsgType() {
        return msgType;
    }

    /**
     * Sets the value of the msgType property.
     * 
     * @param value
     *     allowed object is
     *     {@link MsgTypeT }
     *     
     */
    public void setMsgType(MsgTypeT value) {
        this.msgType = value;
    }

    /**
     * Gets the value of the senderURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenderURI() {
        return senderURI;
    }

    /**
     * Sets the value of the senderURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenderURI(String value) {
        this.senderURI = value;
    }

    /**
     * Gets the value of the destinationURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationURI() {
        return destinationURI;
    }

    /**
     * Sets the value of the destinationURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationURI(String value) {
        this.destinationURI = value;
    }

    /**
     * Gets the value of the replyToURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReplyToURI() {
        return replyToURI;
    }

    /**
     * Sets the value of the replyToURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReplyToURI(String value) {
        this.replyToURI = value;
    }

    /**
     * Gets the value of the originatorURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginatorURI() {
        return originatorURI;
    }

    /**
     * Sets the value of the originatorURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginatorURI(String value) {
        this.originatorURI = value;
    }

    /**
     * Gets the value of the failureReplytoURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFailureReplytoURI() {
        return failureReplytoURI;
    }

    /**
     * Sets the value of the failureReplytoURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFailureReplytoURI(String value) {
        this.failureReplytoURI = value;
    }

    /**
     * Gets the value of the activityStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ActivityStatusT }
     *     
     */
    public ActivityStatusT getActivityStatus() {
        return activityStatus;
    }

    /**
     * Sets the value of the activityStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivityStatusT }
     *     
     */
    public void setActivityStatus(ActivityStatusT value) {
        this.activityStatus = value;
    }

    /**
     * Gets the value of the correlationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorrelationId() {
        return correlationId;
    }

    /**
     * Sets the value of the correlationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorrelationId(String value) {
        this.correlationId = value;
    }

    /**
     * Gets the value of the security property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecurity() {
        return security;
    }

    /**
     * Sets the value of the security property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecurity(String value) {
        this.security = value;
    }

    /**
     * Gets the value of the securityType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecurityType() {
        return securityType;
    }

    /**
     * Sets the value of the securityType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecurityType(String value) {
        this.securityType = value;
    }

    /**
     * Gets the value of the priority property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriority(String value) {
        this.priority = value;
    }

    /**
     * Gets the value of the msgSpecificProperties property.
     * 
     * @return
     *     possible object is
     *     {@link HeaderT.MsgSpecificProperties }
     *     
     */
    public HeaderT.MsgSpecificProperties getMsgSpecificProperties() {
        return msgSpecificProperties;
    }

    /**
     * Sets the value of the msgSpecificProperties property.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderT.MsgSpecificProperties }
     *     
     */
    public void setMsgSpecificProperties(HeaderT.MsgSpecificProperties value) {
        this.msgSpecificProperties = value;
    }

    /**
     * Gets the value of the communicationPattern property.
     * 
     * @return
     *     possible object is
     *     {@link CommunicationPatternT }
     *     
     */
    public CommunicationPatternT getCommunicationPattern() {
        return communicationPattern;
    }

    /**
     * Sets the value of the communicationPattern property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommunicationPatternT }
     *     
     */
    public void setCommunicationPattern(CommunicationPatternT value) {
        this.communicationPattern = value;
    }

    /**
     * Gets the value of the communicationStyle property.
     * 
     * @return
     *     possible object is
     *     {@link CommunicationStyleT }
     *     
     */
    public CommunicationStyleT getCommunicationStyle() {
        return communicationStyle;
    }

    /**
     * Sets the value of the communicationStyle property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommunicationStyleT }
     *     
     */
    public void setCommunicationStyle(CommunicationStyleT value) {
        this.communicationStyle = value;
    }

    /**
     * Gets the value of the requestedBatchSize property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRequestedBatchSize() {
        return requestedBatchSize;
    }

    /**
     * Sets the value of the requestedBatchSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRequestedBatchSize(Long value) {
        this.requestedBatchSize = value;
    }

    /**
     * Gets the value of the batchSequenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBatchSequenceNumber() {
        return batchSequenceNumber;
    }

    /**
     * Sets the value of the batchSequenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBatchSequenceNumber(Long value) {
        this.batchSequenceNumber = value;
    }

    /**
     * Gets the value of the batchSequenceEndOfReply property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBatchSequenceEndOfReply() {
        return batchSequenceEndOfReply;
    }

    /**
     * Sets the value of the batchSequenceEndOfReply property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBatchSequenceEndOfReply(Boolean value) {
        this.batchSequenceEndOfReply = value;
    }

    /**
     * Gets the value of the iteratorReferenceURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIteratorReferenceURI() {
        return iteratorReferenceURI;
    }

    /**
     * Sets the value of the iteratorReferenceURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIteratorReferenceURI(String value) {
        this.iteratorReferenceURI = value;
    }

    /**
     * Gets the value of the fileLocationURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileLocationURI() {
        return fileLocationURI;
    }

    /**
     * Sets the value of the fileLocationURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileLocationURI(String value) {
        this.fileLocationURI = value;
    }

    /**
     * Gets the value of the compressionType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompressionType() {
        return compressionType;
    }

    /**
     * Sets the value of the compressionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompressionType(String value) {
        this.compressionType = value;
    }

    /**
     * Gets the value of the packingType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackingType() {
        return packingType;
    }

    /**
     * Sets the value of the packingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackingType(String value) {
        this.packingType = value;
    }

    /**
     * Gets the value of the timestamp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the value of the timestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimestamp(String value) {
        this.timestamp = value;
    }

    /**
     * Gets the value of the vendorExtensions property.
     * 
     * @return
     *     possible object is
     *     {@link HdrVendorExtensionsT }
     *     
     */
    public HdrVendorExtensionsT getVendorExtensions() {
        return vendorExtensions;
    }

    /**
     * Sets the value of the vendorExtensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link HdrVendorExtensionsT }
     *     
     */
    public void setVendorExtensions(HdrVendorExtensionsT value) {
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


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="property" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="propName" type="{tmf854.v1}PropName_T"/>
     *                   &lt;element name="propValue" type="{tmf854.v1}PropValue_T"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "property"
    })
    public static class MsgSpecificProperties {

        @XmlElement(required = true)
        protected List<HeaderT.MsgSpecificProperties.Property> property;

        /**
         * Gets the value of the property property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the property property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getProperty().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link HeaderT.MsgSpecificProperties.Property }
         * 
         * 
         */
        public List<HeaderT.MsgSpecificProperties.Property> getProperty() {
            if (property == null) {
                property = new ArrayList<HeaderT.MsgSpecificProperties.Property>();
            }
            return this.property;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="propName" type="{tmf854.v1}PropName_T"/>
         *         &lt;element name="propValue" type="{tmf854.v1}PropValue_T"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "propName",
            "propValue"
        })
        public static class Property {

            @XmlElement(required = true)
            protected String propName;
            @XmlElement(required = true)
            protected String propValue;

            /**
             * Gets the value of the propName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPropName() {
                return propName;
            }

            /**
             * Sets the value of the propName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPropName(String value) {
                this.propName = value;
            }

            /**
             * Gets the value of the propValue property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPropValue() {
                return propValue;
            }

            /**
             * Sets the value of the propValue property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPropValue(String value) {
                this.propValue = value;
            }

        }

    }

}
