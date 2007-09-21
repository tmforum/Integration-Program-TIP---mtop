package v1.tmf854;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 *
 *       This is the definition of the object attribute that contains the list of aliases for the network entity. The attribute is a name-value list. The name refers to the type of alias (e.g., nativeEMSname) and the value component holds the alias itself
 *
 *
 * <p>Java class for AliasNameList_T complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AliasNameList_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="alias" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="aliasName" type="{tmf854.v1}AliasName_T"/>
 *                   &lt;element name="aliasValue" type="{tmf854.v1}AliasValue_T"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
@XmlType(name = "AliasNameList_T", propOrder = {
    "alias"
})
@Entity
public class AliasNameListT implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade={CascadeType.ALL})
    protected List<Alias> alias;
    @XmlAttribute
    protected String extAuthor;
    @XmlAttribute
    protected String extVersion;
    @XmlAttribute
    protected String tmf854Version;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public List<Alias> getAlias() {
        if (alias == null) {
            alias = new ArrayList<Alias>();
        }
        return this.alias;
    }
    
    public String getExtAuthor() {
        return extAuthor;
    }
    
    public void setExtAuthor(String value) {
        this.extAuthor = value;
    }
    
    
    public String getExtVersion() {
        return extVersion;
    }
    
    public void setExtVersion(String value) {
        this.extVersion = value;
    }
    
    
    public String getTmf854Version() {
        return tmf854Version;
    }
    
    
    public void setTmf854Version(String value) {
        this.tmf854Version = value;
    }
    
    
    
}
