
package v1.tmf854;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for associatedMEList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="associatedMEList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="associatedME" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="name" type="{tmf854.v1}namingAttributesT" minOccurs="0"/>
 *                   &lt;element name="edgePTPList" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="edgePTPInv" type="{tmf854.v1}PTP_Inventory_T" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="edgeFTPList" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="edgeFTPInv" type="{tmf854.v1}FTP_Inventory_T" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/all>
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
@XmlType(name = "associatedMEList", propOrder = {
    "associatedME"
})
public class AssociatedMEList {

    @XmlElement(nillable = true)
    protected List<AssociatedMEList.AssociatedME> associatedME;

    /**
     * Gets the value of the associatedME property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the associatedME property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssociatedME().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AssociatedMEList.AssociatedME }
     * 
     * 
     */
    public List<AssociatedMEList.AssociatedME> getAssociatedME() {
        if (associatedME == null) {
            associatedME = new ArrayList<AssociatedMEList.AssociatedME>();
        }
        return this.associatedME;
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
     *       &lt;all>
     *         &lt;element name="name" type="{tmf854.v1}namingAttributesT" minOccurs="0"/>
     *         &lt;element name="edgePTPList" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="edgePTPInv" type="{tmf854.v1}PTP_Inventory_T" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="edgeFTPList" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="edgeFTPInv" type="{tmf854.v1}FTP_Inventory_T" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/all>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class AssociatedME {

        protected NamingAttributesT name;
        protected AssociatedMEList.AssociatedME.EdgePTPList edgePTPList;
        protected AssociatedMEList.AssociatedME.EdgeFTPList edgeFTPList;

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link NamingAttributesT }
         *     
         */
        public NamingAttributesT getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link NamingAttributesT }
         *     
         */
        public void setName(NamingAttributesT value) {
            this.name = value;
        }

        /**
         * Gets the value of the edgePTPList property.
         * 
         * @return
         *     possible object is
         *     {@link AssociatedMEList.AssociatedME.EdgePTPList }
         *     
         */
        public AssociatedMEList.AssociatedME.EdgePTPList getEdgePTPList() {
            return edgePTPList;
        }

        /**
         * Sets the value of the edgePTPList property.
         * 
         * @param value
         *     allowed object is
         *     {@link AssociatedMEList.AssociatedME.EdgePTPList }
         *     
         */
        public void setEdgePTPList(AssociatedMEList.AssociatedME.EdgePTPList value) {
            this.edgePTPList = value;
        }

        /**
         * Gets the value of the edgeFTPList property.
         * 
         * @return
         *     possible object is
         *     {@link AssociatedMEList.AssociatedME.EdgeFTPList }
         *     
         */
        public AssociatedMEList.AssociatedME.EdgeFTPList getEdgeFTPList() {
            return edgeFTPList;
        }

        /**
         * Sets the value of the edgeFTPList property.
         * 
         * @param value
         *     allowed object is
         *     {@link AssociatedMEList.AssociatedME.EdgeFTPList }
         *     
         */
        public void setEdgeFTPList(AssociatedMEList.AssociatedME.EdgeFTPList value) {
            this.edgeFTPList = value;
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
         *         &lt;element name="edgeFTPInv" type="{tmf854.v1}FTP_Inventory_T" maxOccurs="unbounded" minOccurs="0"/>
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
            "edgeFTPInv"
        })
        public static class EdgeFTPList {

            @XmlElement(nillable = true)
            protected List<FTPInventoryT> edgeFTPInv;

            /**
             * Gets the value of the edgeFTPInv property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the edgeFTPInv property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getEdgeFTPInv().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link FTPInventoryT }
             * 
             * 
             */
            public List<FTPInventoryT> getEdgeFTPInv() {
                if (edgeFTPInv == null) {
                    edgeFTPInv = new ArrayList<FTPInventoryT>();
                }
                return this.edgeFTPInv;
            }

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
         *         &lt;element name="edgePTPInv" type="{tmf854.v1}PTP_Inventory_T" maxOccurs="unbounded" minOccurs="0"/>
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
            "edgePTPInv"
        })
        public static class EdgePTPList {

            @XmlElement(nillable = true)
            protected List<PTPInventoryT> edgePTPInv;

            /**
             * Gets the value of the edgePTPInv property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the edgePTPInv property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getEdgePTPInv().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link PTPInventoryT }
             * 
             * 
             */
            public List<PTPInventoryT> getEdgePTPInv() {
                if (edgePTPInv == null) {
                    edgePTPInv = new ArrayList<PTPInventoryT>();
                }
                return this.edgePTPInv;
            }

        }

    }

}
