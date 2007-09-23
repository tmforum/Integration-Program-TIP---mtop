package v1.tmf854;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;

@Entity
public class ManagementDomainT implements Serializable {
    @XmlTransient
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @XmlTransient
    @OneToOne(cascade={CascadeType.ALL})
    private MDInventoryT mdInventoryT;
    @XmlTransient
    @OneToOne(cascade={CascadeType.ALL})
    private NamingAttributesT name;
    protected String discoveredName;
    protected String namingOS;
    protected String userLabel;
    @OneToOne(cascade={CascadeType.ALL})
    protected SourceT source;
    protected String owner;
    @OneToOne(cascade={CascadeType.ALL})
    protected AliasNameListT aliasNameList;
    @OneToOne(cascade={CascadeType.ALL})
    protected ResourceStateT resourceState;
    protected String networkAccessDomain;
    @Transient
    private MDVendorExtensionsT vendorExtensions;
    private String vendorExtensionsS;
    protected String extVersion;
    protected String extAuthor;
    protected String tmf854Version;
    private String src;
    private String resrcState;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getDiscoveredName() {
        return discoveredName;
    }
    
    public void setDiscoveredName(String value) {
        this.discoveredName = value;
    }
    
    public String getNamingOS() {
        return namingOS;
    }
    
    public void setNamingOS(String value) {
        this.namingOS = value;
    }
    
    public String getUserLabel() {
        return userLabel;
    }
    
    
    public void setUserLabel(String value) {
        this.userLabel = value;
    }
    
    
    public SourceT getSource() {
        return source;
    }
    
    public void setSource(SourceT value) {
        this.source = value;
    }
    
    public String getOwner() {
        return owner;
    }
    
    public void setOwner(String value) {
        this.owner = value;
    }
    
    
    public AliasNameListT getAliasNameList() {
        return aliasNameList;
    }
    
    
    public void setAliasNameList(AliasNameListT value) {
        this.aliasNameList = value;
    }
    
    
    public ResourceStateT getResourceState() {
        return resourceState;
    }
    
    public void setResourceState(ResourceStateT value) {
        this.resourceState = value;
    }
    
    
    public String getNetworkAccessDomain() {
        return networkAccessDomain;
    }
    
    
    public void setNetworkAccessDomain(String value) {
        this.networkAccessDomain = value;
    }
    
    
    public MDVendorExtensionsT getVendorExtensions() {
        return vendorExtensions;
    }
    
    
    public void setVendorExtensions(MDVendorExtensionsT value) {
        this.vendorExtensions = value;
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
    
    public String getSrc() {
        return src;
    }
    
    public void setSrc(String src) {
        this.src = src;
    }
    
    public String getResrcState() {
        return resrcState;
    }
    
    public void setResrcState(String resrcState) {
        this.resrcState = resrcState;
    }
    
    public MDInventoryT getMdInventoryT() {
        return mdInventoryT;
    }
    
    public void setMdInventoryT(MDInventoryT mdInventoryT) {
        this.mdInventoryT = mdInventoryT;
    }
    
    public NamingAttributesT getName() {
        return name;
    }
    
    public void setName(NamingAttributesT name) {
        this.name = name;
    }

   public void initVendorExtensions() {
       this.getVendorExtensions().setAny();
        setVendorExtensionsS(this.getVendorExtensions().getVdExt());
    }

    public String getVendorExtensionsS() {
        return vendorExtensionsS;
    }

    public void setVendorExtensionsS(String vendorExtensionsS) {
        this.vendorExtensionsS = vendorExtensionsS;
    }
        
}

