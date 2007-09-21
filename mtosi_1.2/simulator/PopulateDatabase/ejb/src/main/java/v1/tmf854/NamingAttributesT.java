package v1.tmf854;


import java.io.Serializable;
import javax.persistence.*;
import java.util.Map;
import javax.xml.bind.annotation.*;

@Entity
public class NamingAttributesT implements Serializable{
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name="NAMEATT_ID")
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
}
    
   