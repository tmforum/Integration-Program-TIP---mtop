
package v1.tmf854;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import java.lang.*;
import java.util.*;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * Extension for MTOSI Subnetwork Connection
 *
 * <p>Java class for SNCVendorExtensions_T complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SNCVendorExtensions_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;any/>
 *       &lt;/sequence>
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
public class SNCVendorExtensionsT {
    @XmlTransient
    protected List<Object> any;
    @XmlAttribute
    protected String extAuthor;
    @XmlAttribute
    protected String extVersion;
    @XmlAttribute
    protected String tmf854Version;
    private String vdExt = "";
    
    /**
     * Gets the value of the any property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * {@link Element }
     *
     *
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
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
    
   public void setAny() {
        Iterator elementsIt = any.iterator();
        List<Node> nodes = new ArrayList<Node>();
        
        while (elementsIt.hasNext()){
            Node e = (Node) (elementsIt.next());
            System.out.println("e. " + e.getNodeName());
            vdExt += "<" + e.getNodeName() +  ">";
            setNodes(e);
            vdExt += "</" + e.getNodeName() +  ">";
        }
    }
    
    public void setNodes(Node node) {
        
        NodeList children = node.getChildNodes();
        int nbChildren = children.getLength();
        
        for (int i = 0; i < nbChildren; i++) {
            Node child = children.item(i);
           
            if (child.getNodeType() != child.TEXT_NODE) {
                vdExt += "<" + child.getNodeName() +  ">";
                setNodes(child);
                vdExt += "</" + child.getNodeName() +  ">";
                
            }
            
            if (child.getNodeValue() != null) {
            vdExt += child.getNodeValue();
            } 
        }
    }
   
    public void setVdext(String vdExt) {
        this.vdExt = vdExt;
    }
    
    public String getVdExt() {
        return vdExt;
    }
}

