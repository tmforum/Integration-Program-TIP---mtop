
package v1.tmf854;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.*;
import javax.xml.bind.annotation.*;
import v1.tmf854.*;
import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import java.lang.*;
import org.w3c.dom.*;
import java.util.*;


/**
 * Extension for MTOSI managed elements
 *
 * <p>Java class for MEVendorExtensions_T complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="MEVendorExtensions_T">
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

@Entity
@Table(name = "MEV")
public class MEVendorExtensionsT implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @XmlAnyElement(lax = true)
    @Transient
    protected List<Object> any;
    private String mev;
    @XmlAttribute
    protected String extAuthor;
    @XmlAttribute
    protected String extVersion;
    @XmlAttribute
    protected String tmf854Version;
    
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
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getMev() {
        String result = "";
        String result2 = "";
        mev="";
        try {
            for (Object o : any) {
                Node n1 = (Node) o;
                StringWriter output = new StringWriter();
                //TransformerFactory.newInstance().newTransformer().transform(new DOMSource(n1), new StreamResult(output));
                 TransformerFactory transfac = TransformerFactory.newInstance();
                Transformer trans = transfac.newTransformer();
                trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
                trans.setOutputProperty(OutputKeys.INDENT, "no");
                 trans.setOutputProperty(OutputKeys.METHOD, "xml");
                 trans.setOutputProperty(OutputKeys.ENCODING,"ISO-8859-1");
               // Print the DOM node
                StringWriter sw = new StringWriter();
                StreamResult result3 = new StreamResult(sw);
                DOMSource source = new DOMSource(n1);
                trans.transform(source, result3);
                String xmlString = sw.toString();
                String wf = wellFormed(xmlString);
                 System.out.println("xmlString: " + xmlString);
                System.out.println("wf: " + wf);
                mev += wf;
                }
            
//            for (Object o : any) {
//                Node n1 = (Node) o;
//                // Set up the output transformer
//                TransformerFactory transfac = TransformerFactory.newInstance();
//                Transformer trans = transfac.newTransformer();
//                trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
//                trans.setOutputProperty(OutputKeys.INDENT, "no");
//
//
//                // Print the DOM node
//
//                StringWriter sw = new StringWriter();
//                StreamResult result3 = new StreamResult(sw);
//                DOMSource source = new DOMSource(n1);
//                trans.transform(source, result3);
//                String xmlString = sw.toString();
//                mev += xmlString;
//                //System.out.println("xmlString: " + xmlString);
//            }
        } catch (TransformerException e) {
            e.printStackTrace();
        }
       // mev = result2;
        //System.out.println("result: " + result);
        //System.out.println("result2: " + result2);
        System.out.println("mev: " + mev);
        return mev;
    }
    
    public void setMev(String mev) {
        this.mev = mev;
    }
    public String wellFormed(String s) {
          
            System.out.println("before s: " + s);
            StringTokenizer st = new StringTokenizer(s);
            String end = "";
            //System.out.println("st: " + st.nextToken());
            String firstTok =st.nextToken();
            System.out.println("firstToken " + firstTok + ">");
             String element = firstTok + ">";
              while (st.hasMoreTokens()) {
	            String tok = st.nextToken();
	            //System.out.println("tok:" +  tok.substring(0,5) + "I");
	             //System.out.println(tok.substring(0,5).equals("xmlns"));
	            if (!tok.substring(0,5).equals("xmlns")) {
                      System.out.println("tok: " + tok);// + "tok.substring(0,2): " + tok.substring(0,2));
                      element += tok;
                      //}
            }
            }
              System.out.println("element " + element);
              
              return element;
        
    } 
}
