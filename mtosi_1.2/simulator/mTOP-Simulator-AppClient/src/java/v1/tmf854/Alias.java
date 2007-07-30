/*
 * Alias.java
 *
 * Created on 20 mai 2007, 12:37
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package v1.tmf854;


import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;
/**
 * Entity class Alias
 *
 * @author baptiste
 */
@XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
@Entity
@Table(name = "ALIAS_")
public class Alias implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    protected String aliasName;
    protected String aliasValue;
    
    
    public String getAliasName() {
        return aliasName;
    }
    
    
    public void setAliasName(String value) {
        this.aliasName = value;
    }
    
    
    public String getAliasValue() {
        return aliasValue;
    }
    
    
    public void setAliasValue(String value) {
        this.aliasValue = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}