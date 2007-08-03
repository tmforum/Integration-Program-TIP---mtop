
package v1.tmf854;


 /*
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
  */

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.*;
import java.util.Map;
import javax.xml.bind.annotation.*;

@Entity
@Table(name = "NAMINGATTRIBUTES")
public class NamingAttributesT implements Serializable{
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="NAMEATT_ID")
    private Long id;
    protected String osNm;
    protected String mdNm;
    protected String meNm;
    protected String ehNm;
    protected String eqNm;
    protected String ptpNm;
    protected String ftpNm;
    protected String ctpNm;
    protected String tppoolNm;
    protected String pgpNm;
    protected String epgpNm;
    protected String mlsnNm;
    protected String sncNm;
    protected String tmdNm;
    protected String tlNm;
    protected String aidNm;
    protected String propNm;
    protected String extAuthor;
    protected String extVersion;
    protected String tmf854Version;
    
    // @Id
    // @Column(name="NAME_ID")
    public Long getId() {
        return id;
    }
    
    public void setIdNatt(Long idNatt) {
        this.id = id;
    }
    
    public String getOsNm() {
        return osNm;
    }
    
    public void setOsNm(String value) {
        this.osNm = value;
    }
    
    public String getMdNm() {
        return mdNm;
    }
    
    
    public void setMdNm(String value) {
        this.mdNm = value;
    }
    
    public String getMeNm() {
        return meNm;
    }
    
    
    public void setMeNm(String value) {
        this.meNm = value;
    }
    
    
    public String getEhNm() {
        return ehNm;
    }
    
    
    public void setEhNm(String value) {
        this.ehNm = value;
    }
    
    
    public String getEqNm() {
        return eqNm;
    }
    
    
    public void setEqNm(String value) {
        this.eqNm = value;
    }
    
    
    public String getPtpNm() {
        return ptpNm;
    }
    
    public void setPtpNm(String value) {
        this.ptpNm = value;
    }
    
    
    public String getFtpNm() {
        return ftpNm;
    }
    
    
    public void setFtpNm(String value) {
        this.ftpNm = value;
    }
    
    
    public String getCtpNm() {
        return ctpNm;
    }
    
    
    public void setCtpNm(String value) {
        this.ctpNm = value;
    }
    
    public String getTppoolNm() {
        return tppoolNm;
    }
    
    public void setTppoolNm(String value) {
        this.tppoolNm = value;
    }
    
    
    public String getPgpNm() {
        return pgpNm;
    }
    
    public void setPgpNm(String value) {
        this.pgpNm = value;
    }
    
    
    public String getEpgpNm() {
        return epgpNm;
    }
    
    
    public void setEpgpNm(String value) {
        this.epgpNm = value;
    }
    
    
    public String getMlsnNm() {
        return mlsnNm;
    }
    
    
    public void setMlsnNm(String value) {
        this.mlsnNm = value;
    }
    
    public String getSncNm() {
        return sncNm;
    }
    
    
    public void setSncNm(String value) {
        this.sncNm = value;
    }
    
    
    public String getTmdNm() {
        return tmdNm;
    }
    
    
    public void setTmdNm(String value) {
        this.tmdNm = value;
    }
    
    
    public String getTlNm() {
        return tlNm;
    }
    
    public void setTlNm(String value) {
        this.tlNm = value;
    }
    
    
    public String getAidNm() {
        return aidNm;
    }
    
    
    public void setAidNm(String value) {
        this.aidNm = value;
    }
    
    
    public String getPropNm() {
        return propNm;
    }
    
    
    public void setPropNm(String value) {
        this.propNm = value;
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
    
    
    public void init(Map[] bis, NamingAttributesT n) {
        
        for (int i = 0; i < bis.length; i++) {
            Map bi = bis[i];
            String biNumber = (String) bi.get("biNumber");
            System.out.println("biNumber::::: " + biNumber);
            NamingAttributesT namingAttrs1 = new NamingAttributesT();
            setOsNm((String)bi.get("biFieldOs"));
            if (biNumber.equals("1")) {
                setMdNm((String)bi.get("bi1Field1"));
                setMeNm((String)bi.get("bi1Field2"));
                setEhNm((String)bi.get("bi1Field3"));
                setEqNm((String)bi.get("biFieldEq"));
            } else if (biNumber.equals("2")) {
                setMdNm("md1");
                setMeNm((String)bi.get("bi2Field2"));
                setPtpNm((String)bi.get("bi2Field3"));
                setCtpNm((String)bi.get("bi2Field4"));
            } else if (biNumber.equals("3")) {
                setMdNm("md1");
                setMeNm((String)bi.get("bi3Field2"));
                setFtpNm((String)bi.get("bi3Field3"));
                //setCtpNm((String)bi.get("bi2Field4"));
            } else if (biNumber.equals("4")) {
                setMdNm("md1");
                setMeNm((String)bi.get("bi4Field2"));
                setPgpNm((String)bi.get("bi4Field3"));
                // setCtpNm((String)bi.get("bi4Field4"));
            } else if (biNumber.equals("5")) {
                setMdNm("md1");
                setMeNm((String)bi.get("bi5Field2"));
                setEpgpNm((String)bi.get("bi5Field3"));
                //setCtpNm((String)bi.get("bi5Field4"));
            }
//            else if (biNumber.equals("6")) {
//            setMdNm("Networks/XdrEMS/Server10");
//            setMeNm((String)bi.get("bi6Field2"));
//            setCcNm((String)bi.get("bi6Field3"));
//            }
            else if (biNumber.equals("7")) {
                setMdNm("md1");
                setMlsnNm((String)bi.get("bi7Field2"));
                setSncNm((String)bi.get("bi7Field3"));
                //setCtpNm((String)bi.get("bi7Field4"));
            } else if (biNumber.equals("8")) {
                setMdNm("md1");
                setMlsnNm((String)bi.get("bi8Field2"));
                setTppoolNm((String)bi.get("bi8Field3"));
                //setCtpNm((String)bi.get("bi2Field4"));
            } else if (biNumber.equals("9")) {
                setMdNm("md1");
                setMlsnNm((String)bi.get("bi9Field2"));
                setTlNm((String)bi.get("bi9Field3"));
                //setCtpNm((String)bi.get("bi9Field4"));
            }
            ///////////////////////////
            // setPtpNm((String)bi.get("bi2Field3"));
            // setFtpNm((String)bi.get("biFieldFtp"));
            //setCtpNm((String)bi.get("biFieldCtp"));
//            setTppoolNm((String)bi.get("biFieldTppoolNm"));
//            setEpgpNm((String)bi.get("biFieldEpgpNm"));
//            setMlsnNm((String)bi.get("biFieldMlsnNm"));
//            n.setSncNm((String)bi.get("biFieldSncNm"));
//            n.setTmdNm((String)bi.get("biFieldTmdNm"));
//            n.setTlNm((String)bi.get("biFieldTlNm"));
//            n.setAidNm((String)bi.get("biFieldAidNm"));
//            n.setPropNm((String)bi.get("biFieldPropNm"));
        }
    }
    
    
    
}

