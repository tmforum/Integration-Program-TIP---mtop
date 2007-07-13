/*
 * NewEntity.java
 *
 * Created on 6 mai 2007, 14:24
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package v1.tmf854;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.*;
import java.util.*;

/**
 * Entity class NewEntity
 * 
 * @author baptiste
 */
@Entity
public class NewEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
       
    private String extVersion;
    protected String extAuthor;
    protected String tmf854Version;
//    @OneToMany   
//    private Collection<A> any1;
    /** Creates a new instance of NewEntity */
    public NewEntity() {
    }

    /**
     * Gets the id of this NewEntity.
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the id of this NewEntity to the specified value.
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
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
    
//      public Collection<A> getAny1() {
//        return any1;
//    }
//
//    public void setAny1(Collection<A> any1) {
//        this.any1 = any1;
//    }
}
