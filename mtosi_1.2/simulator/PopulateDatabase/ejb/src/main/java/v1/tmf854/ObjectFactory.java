
package v1.tmf854;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the v1.tmf854 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ManagedElementTManufacturerDate_QNAME = new QName("tmf854.v1", "manufacturerDate");
    private final static QName _ManagedElementTOwner_QNAME = new QName("tmf854.v1", "owner");
    private final static QName _ManagedElementTAliasNameList_QNAME = new QName("tmf854.v1", "aliasNameList");
    private final static QName _ManagedElementTProductName_QNAME = new QName("tmf854.v1", "productName");
    private final static QName _ManagedElementTNamingOS_QNAME = new QName("tmf854.v1", "namingOS");
    private final static QName _ManagedElementTName_QNAME = new QName("tmf854.v1", "name");
    private final static QName _ManagedElementTManufacturer_QNAME = new QName("tmf854.v1", "manufacturer");
    private final static QName _ManagedElementTSource_QNAME = new QName("tmf854.v1", "source");
    private final static QName _ManagedElementTVersion_QNAME = new QName("tmf854.v1", "version");
    private final static QName _ManagedElementTUserLabel_QNAME = new QName("tmf854.v1", "userLabel");
    private final static QName _ManagedElementTNetworkAccessDomain_QNAME = new QName("tmf854.v1", "networkAccessDomain");
    private final static QName _ManagedElementTCommunicationState_QNAME = new QName("tmf854.v1", "communicationState");
    private final static QName _ManagedElementTResourceState_QNAME = new QName("tmf854.v1", "resourceState");
    private final static QName _ManagedElementTSupportedRates_QNAME = new QName("tmf854.v1", "supportedRates");
    private final static QName _ManagedElementTInSyncState_QNAME = new QName("tmf854.v1", "InSyncState");
    private final static QName _ManagedElementTLocation_QNAME = new QName("tmf854.v1", "location");
    private final static QName _GetInventory_QNAME = new QName("tmf854.v1", "getInventory");
    private final static QName _MTOSIInventoryData_QNAME = new QName("tmf854.v1", "MTOSI_InventoryData");
    private final static QName _GetInventoryResponse_QNAME = new QName("tmf854.v1", "getInventoryResponse");
    private final static QName _EquipmentTInstalledPartNumber_QNAME = new QName("tmf854.v1", "installedPartNumber");
    private final static QName _EquipmentTServiceState_QNAME = new QName("tmf854.v1", "serviceState");
    private final static QName _EquipmentTInstalledEquipmentObjectType_QNAME = new QName("tmf854.v1", "installedEquipmentObjectType");
    private final static QName _EquipmentTAlarmReportingIndicator_QNAME = new QName("tmf854.v1", "alarmReportingIndicator");
    private final static QName _EquipmentTExpectedEquipmentObjectType_QNAME = new QName("tmf854.v1", "expectedEquipmentObjectType");
    private final static QName _EquipmentTInstalledSerialNumber_QNAME = new QName("tmf854.v1", "installedSerialNumber");
    private final static QName _EquipmentTDiscoveredName_QNAME = new QName("tmf854.v1", "discoveredName");
    private final static QName _EquipmentTVendorExtensions_QNAME = new QName("tmf854.v1", "vendorExtensions");
    private final static QName _EquipmentTInstalledVersion_QNAME = new QName("tmf854.v1", "installedVersion");
//    private final static QName _EquipmentHolderTAcceptableEquipmentTypeList_QNAME = new QName("tmf854.v1", "acceptableEquipmentTypeList");
 //  private final static QName _EquipmentHolderTAcceptableEquipmentTypeList_QNAME = new QName("tmf854.v1", "acceptableEquipmentTypeList");
    private final static QName _EquipmentHolderTHolderState_QNAME = new QName("tmf854.v1", "holderState");
    private final static QName _EquipmentHolderTHolderType_QNAME = new QName("tmf854.v1", "holderType");
    private final static QName _EquipmentHolderTExpectedOrInstalledEquipment_QNAME = new QName("tmf854.v1", "expectedOrInstalledEquipment");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: v1.tmf854
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EHInventoryT }
     * 
     */
    public EHInventoryT createEHInventoryT() {
        return new EHInventoryT();
    }

    /**
     * Create an instance of {@link FileTransferStatusExtT }
     * 
     */
    public FileTransferStatusExtT createFileTransferStatusExtT() {
        return new FileTransferStatusExtT();
    }

    /**
     * Create an instance of {@link EHVendorExtensionsT }
     * 
     */
    public EHVendorExtensionsT createEHVendorExtensionsT() {
        return new EHVendorExtensionsT();
    }

    /**
     * Create an instance of {@link CCVendorExtensionsT }
     * 
     */
    public CCVendorExtensionsT createCCVendorExtensionsT() {
        return new CCVendorExtensionsT();
    }

    /**
     * Create an instance of {@link MEInventoryT }
     * 
     */
    public MEInventoryT createMEInventoryT() {
        return new MEInventoryT();
    }

    /**
     * Create an instance of {@link MDVendorExtensionsT }
     * 
     */
    public MDVendorExtensionsT createMDVendorExtensionsT() {
        return new MDVendorExtensionsT();
    }

    /**
     * Create an instance of {@link PGPParametersExtT }
     * 
     */
    public PGPParametersExtT createPGPParametersExtT() {
        return new PGPParametersExtT();
    }

    /**
     * Create an instance of {@link NameAndStringValueT }
     * 
     */
    public NameAndStringValueT createNameAndStringValueT() {
        return new NameAndStringValueT();
    }

    /**
     * Create an instance of {@link EquipmentOrHolderListT }
     * 
     */
    public EquipmentOrHolderListT createEquipmentOrHolderListT() {
        return new EquipmentOrHolderListT();
    }

    /**
     * Create an instance of {@link CTPVendorExtensionsT }
     * 
     */
    public CTPVendorExtensionsT createCTPVendorExtensionsT() {
        return new CTPVendorExtensionsT();
    }

    /**
     * Create an instance of {@link SimpleFilterT }
     * 
     */
    public SimpleFilterT createSimpleFilterT() {
        return new SimpleFilterT();
    }

    /**
     * Create an instance of {@link EPGVendorExtensionsT }
     * 
     */
    public EPGVendorExtensionsT createEPGVendorExtensionsT() {
        return new EPGVendorExtensionsT();
    }

    /**
     * Create an instance of {@link AlarmExtT }
     * 
     */
    public AlarmExtT createAlarmExtT() {
        return new AlarmExtT();
    }

    /**
     * Create an instance of {@link TPPoolVendorExtensionsT }
     * 
     */
    public TPPoolVendorExtensionsT createTPPoolVendorExtensionsT() {
        return new TPPoolVendorExtensionsT();
    }

    /**
     * Create an instance of {@link PGVendorExtensionsT }
     * 
     */
    public PGVendorExtensionsT createPGVendorExtensionsT() {
        return new PGVendorExtensionsT();
    }

    /**
     * Create an instance of {@link AliasNameListT.Alias }
     * 
     */
//    public AliasNameListT.Alias createAliasNameListTAlias() {
//        return new AliasNameListT.Alias();
//    }

    /**
     * Create an instance of {@link TLVendorExtensionsT }
     * 
     */
    public TLVendorExtensionsT createTLVendorExtensionsT() {
        return new TLVendorExtensionsT();
    }

    /**
     * Create an instance of {@link GetInventoryResponseT }
     * 
     */
    public GetInventoryResponseT createGetInventoryResponseT() {
        return new GetInventoryResponseT();
    }

    /**
     * Create an instance of {@link EPGPParametersExtT }
     * 
     */
    public EPGPParametersExtT createEPGPParametersExtT() {
        return new EPGPParametersExtT();
    }

    /**
     * Create an instance of {@link AttributeValueChangeExtT }
     * 
     */
    public AttributeValueChangeExtT createAttributeValueChangeExtT() {
        return new AttributeValueChangeExtT();
    }

    /**
     * Create an instance of {@link LayerRateListT }
     * 
     */
    public LayerRateListT createLayerRateListT() {
        return new LayerRateListT();
    }

    /**
     * Create an instance of {@link MEInventoryT.EhList }
     * 
     */
    public MEInventoryT.EhList createMEInventoryTEhList() {
        return new MEInventoryT.EhList();
    }

    /**
     * Create an instance of {@link HeartbeatExtT }
     * 
     */
    public HeartbeatExtT createHeartbeatExtT() {
        return new HeartbeatExtT();
    }

    /**
     * Create an instance of {@link ObjectDeletionExtT }
     * 
     */
    public ObjectDeletionExtT createObjectDeletionExtT() {
        return new ObjectDeletionExtT();
    }

    /**
     * Create an instance of {@link EHInventoryT.EhList }
     * 
     */
    public EHInventoryT.EhList createEHInventoryTEhList() {
        return new EHInventoryT.EhList();
    }

    /**
     * Create an instance of {@link StateChangeExtT }
     * 
     */
    public StateChangeExtT createStateChangeExtT() {
        return new StateChangeExtT();
    }

    /**
     * Create an instance of {@link VendorObjectExtensionsT }
     * 
     */
    public VendorObjectExtensionsT createVendorObjectExtensionsT() {
        return new VendorObjectExtensionsT();
    }

    /**
     * Create an instance of {@link VendorNotificationExtT }
     * 
     */
    public VendorNotificationExtT createVendorNotificationExtT() {
        return new VendorNotificationExtT();
    }

    /**
     * Create an instance of {@link ESwitchDataExtensionsT }
     * 
     */
    public ESwitchDataExtensionsT createESwitchDataExtensionsT() {
        return new ESwitchDataExtensionsT();
    }

    /**
     * Create an instance of {@link EventLossClearedExtT }
     * 
     */
    public EventLossClearedExtT createEventLossClearedExtT() {
        return new EventLossClearedExtT();
    }

    /**
     * Create an instance of {@link MDInventoryT }
     * 
     */
    public MDInventoryT createMDInventoryT() {
        return new MDInventoryT();
    }

    /**
     * Create an instance of {@link SNCVendorExtensionsT }
     * 
     */
    public SNCVendorExtensionsT createSNCVendorExtensionsT() {
        return new SNCVendorExtensionsT();
    }

    /**
     * Create an instance of {@link TMDVendorExtensionsT }
     * 
     */
    public TMDVendorExtensionsT createTMDVendorExtensionsT() {
        return new TMDVendorExtensionsT();
    }

    /**
     * Create an instance of {@link EventLossOccuredExtT }
     * 
     */
    public EventLossOccuredExtT createEventLossOccuredExtT() {
        return new EventLossOccuredExtT();
    }

    /**
     * Create an instance of {@link ProcessingFailureExceptionVendorExtensionsT }
     * 
     */
    public ProcessingFailureExceptionVendorExtensionsT createProcessingFailureExceptionVendorExtensionsT() {
        return new ProcessingFailureExceptionVendorExtensionsT();
    }

    /**
     * Create an instance of {@link EquipmentT }
     * 
     */
    public EquipmentT createEquipmentT() {
        return new EquipmentT();
    }

    /**
     * Create an instance of {@link ProcessingFailureExceptionAdditionalInfoT }
     * 
     */
    public ProcessingFailureExceptionAdditionalInfoT createProcessingFailureExceptionAdditionalInfoT() {
        return new ProcessingFailureExceptionAdditionalInfoT();
    }

    /**
     * Create an instance of {@link PTPVendorExtensionsT }
     * 
     */
    public PTPVendorExtensionsT createPTPVendorExtensionsT() {
        return new PTPVendorExtensionsT();
    }

    /**
     * Create an instance of {@link GetInventoryT }
     * 
     */
    public GetInventoryT createGetInventoryT() {
        return new GetInventoryT();
    }

    /**
     * Create an instance of {@link EquipmentHolderT }
     * 
     */
    public EquipmentHolderT createEquipmentHolderT() {
        return new EquipmentHolderT();
    }

    /**
     * Create an instance of {@link ServiceStateT }
     * 
     */
    public ServiceStateT createServiceStateT() {
        return new ServiceStateT();
    }

    /**
     * Create an instance of {@link NamingAttributesListT }
     * 
     */
    public NamingAttributesListT createNamingAttributesListT() {
        return new NamingAttributesListT();
    }

    /**
     * Create an instance of {@link ObjectDiscoveryExtT }
     * 
     */
    public ObjectDiscoveryExtT createObjectDiscoveryExtT() {
        return new ObjectDiscoveryExtT();
    }

    /**
     * Create an instance of {@link SimpleFilterT.IncludedObjectType }
     * 
     */
    public SimpleFilterT.IncludedObjectType createSimpleFilterTIncludedObjectType() {
        return new SimpleFilterT.IncludedObjectType();
    }

    /**
     * Create an instance of {@link EqVendorExtensionsT }
     * 
     */
    public EqVendorExtensionsT createEqVendorExtensionsT() {
        return new EqVendorExtensionsT();
    }

    /**
     * Create an instance of {@link NVSListT }
     * 
     */
    public NVSListT createNVSListT() {
        return new NVSListT();
    }

    /**
     * Create an instance of {@link MLSVendorExtensionsT }
     * 
     */
    public MLSVendorExtensionsT createMLSVendorExtensionsT() {
        return new MLSVendorExtensionsT();
    }

    /**
     * Create an instance of {@link RouteVendorExtensionsT }
     * 
     */
    public RouteVendorExtensionsT createRouteVendorExtensionsT() {
        return new RouteVendorExtensionsT();
    }

    /**
     * Create an instance of {@link OSVendorExtensionsT }
     * 
     */
    public OSVendorExtensionsT createOSVendorExtensionsT() {
        return new OSVendorExtensionsT();
    }

    /**
     * Create an instance of {@link SwitchDataExtensionsT }
     * 
     */
    public SwitchDataExtensionsT createSwitchDataExtensionsT() {
        return new SwitchDataExtensionsT();
    }

    /**
     * Create an instance of {@link EQInventoryT }
     * 
     */
    public EQInventoryT createEQInventoryT() {
        return new EQInventoryT();
    }

    /**
     * Create an instance of {@link ProtectionSwitchExtT }
     * 
     */
    public ProtectionSwitchExtT createProtectionSwitchExtT() {
        return new ProtectionSwitchExtT();
    }

    /**
     * Create an instance of {@link FTPVendorExtensionsT }
     * 
     */
    public FTPVendorExtensionsT createFTPVendorExtensionsT() {
        return new FTPVendorExtensionsT();
    }

    /**
     * Create an instance of {@link MDInventoryT.MeList }
     * 
     */
    public MDInventoryT.MeList createMDInventoryTMeList() {
        return new MDInventoryT.MeList();
    }

    /**
     * Create an instance of {@link ManagementDomainListT }
     * 
     */
    public ManagementDomainListT createManagementDomainListT() {
        return new ManagementDomainListT();
    }

    /**
     * Create an instance of {@link NamingAttributesT }
     * 
     */
    public NamingAttributesT createNamingAttributesT() {
        return new NamingAttributesT();
    }

//    /**
//     * Create an instance of {@link EquipmentHolderT.AcceptableEquipmentTypeList }
//     * 
//     */
//    public EquipmentHolderT.AcceptableEquipmentTypeList createEquipmentHolderTAcceptableEquipmentTypeList() {
//        return new EquipmentHolderT.AcceptableEquipmentTypeList();
//    }

    /**
     * Create an instance of {@link InventoryDataT.MdList }
     * 
     */
    public InventoryDataT.MdList createInventoryDataTMdList() {
        return new InventoryDataT.MdList();
    }

    /**
     * Create an instance of {@link AliasNameListT }
     * 
     */
    public AliasNameListT createAliasNameListT() {
        return new AliasNameListT();
    }

    /**
     * Create an instance of {@link SourceT }
     * 
     */
    public SourceT createSourceT() {
        return new SourceT();
    }

    /**
     * Create an instance of {@link EProtectionSwitchExtT }
     * 
     */
    public EProtectionSwitchExtT createEProtectionSwitchExtT() {
        return new EProtectionSwitchExtT();
    }

    /**
     * Create an instance of {@link ManagedElementT }
     * 
     */
    public ManagedElementT createManagedElementT() {
        return new ManagedElementT();
    }

    /**
     * Create an instance of {@link ManagedElementListT }
     * 
     */
    public ManagedElementListT createManagedElementListT() {
        return new ManagedElementListT();
    }

    /**
     * Create an instance of {@link ObjectCreationExtT }
     * 
     */
    public ObjectCreationExtT createObjectCreationExtT() {
        return new ObjectCreationExtT();
    }

    /**
     * Create an instance of {@link ManagementDomainT }
     * 
     */
    public ManagementDomainT createManagementDomainT() {
        return new ManagementDomainT();
    }

    /**
     * Create an instance of {@link TransmissionParametersExtT }
     * 
     */
    public TransmissionParametersExtT createTransmissionParametersExtT() {
        return new TransmissionParametersExtT();
    }

    /**
     * Create an instance of {@link ResourceStateT }
     * 
     */
    public ResourceStateT createResourceStateT() {
        return new ResourceStateT();
    }

    /**
     * Create an instance of {@link MEVendorExtensionsT }
     * 
     */
    public MEVendorExtensionsT createMEVendorExtensionsT() {
        return new MEVendorExtensionsT();
    }

    /**
     * Create an instance of {@link InventoryDataT }
     * 
     */
    public InventoryDataT createInventoryDataT() {
        return new InventoryDataT();
    }

    /**
     * Create an instance of {@link EquipmentOrHolderT }
     * 
     */
    public EquipmentOrHolderT createEquipmentOrHolderT() {
        return new EquipmentOrHolderT();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "manufacturerDate", scope = ManagedElementT.class)
    public JAXBElement<String> createManagedElementTManufacturerDate(String value) {
        return new JAXBElement<String>(_ManagedElementTManufacturerDate_QNAME, String.class, ManagedElementT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "owner", scope = ManagedElementT.class)
    public JAXBElement<String> createManagedElementTOwner(String value) {
        return new JAXBElement<String>(_ManagedElementTOwner_QNAME, String.class, ManagedElementT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AliasNameListT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "aliasNameList", scope = ManagedElementT.class)
    public JAXBElement<AliasNameListT> createManagedElementTAliasNameList(AliasNameListT value) {
        return new JAXBElement<AliasNameListT>(_ManagedElementTAliasNameList_QNAME, AliasNameListT.class, ManagedElementT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "productName", scope = ManagedElementT.class)
    public JAXBElement<String> createManagedElementTProductName(String value) {
        return new JAXBElement<String>(_ManagedElementTProductName_QNAME, String.class, ManagedElementT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "namingOS", scope = ManagedElementT.class)
    public JAXBElement<String> createManagedElementTNamingOS(String value) {
        return new JAXBElement<String>(_ManagedElementTNamingOS_QNAME, String.class, ManagedElementT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NamingAttributesT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "name", scope = ManagedElementT.class)
    public JAXBElement<NamingAttributesT> createManagedElementTName(NamingAttributesT value) {
        return new JAXBElement<NamingAttributesT>(_ManagedElementTName_QNAME, NamingAttributesT.class, ManagedElementT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "manufacturer", scope = ManagedElementT.class)
    public JAXBElement<String> createManagedElementTManufacturer(String value) {
        return new JAXBElement<String>(_ManagedElementTManufacturer_QNAME, String.class, ManagedElementT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SourceT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "source", scope = ManagedElementT.class)
    public JAXBElement<SourceT> createManagedElementTSource(SourceT value) {
        return new JAXBElement<SourceT>(_ManagedElementTSource_QNAME, SourceT.class, ManagedElementT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "version", scope = ManagedElementT.class)
    public JAXBElement<String> createManagedElementTVersion(String value) {
        return new JAXBElement<String>(_ManagedElementTVersion_QNAME, String.class, ManagedElementT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "userLabel", scope = ManagedElementT.class)
    public JAXBElement<String> createManagedElementTUserLabel(String value) {
        return new JAXBElement<String>(_ManagedElementTUserLabel_QNAME, String.class, ManagedElementT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "networkAccessDomain", scope = ManagedElementT.class)
    public JAXBElement<String> createManagedElementTNetworkAccessDomain(String value) {
        return new JAXBElement<String>(_ManagedElementTNetworkAccessDomain_QNAME, String.class, ManagedElementT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommunicationStateT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "communicationState", scope = ManagedElementT.class)
    public JAXBElement<CommunicationStateT> createManagedElementTCommunicationState(CommunicationStateT value) {
        return new JAXBElement<CommunicationStateT>(_ManagedElementTCommunicationState_QNAME, CommunicationStateT.class, ManagedElementT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResourceStateT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "resourceState", scope = ManagedElementT.class)
    public JAXBElement<ResourceStateT> createManagedElementTResourceState(ResourceStateT value) {
        return new JAXBElement<ResourceStateT>(_ManagedElementTResourceState_QNAME, ResourceStateT.class, ManagedElementT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LayerRateListT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "supportedRates", scope = ManagedElementT.class)
    public JAXBElement<LayerRateListT> createManagedElementTSupportedRates(LayerRateListT value) {
        return new JAXBElement<LayerRateListT>(_ManagedElementTSupportedRates_QNAME, LayerRateListT.class, ManagedElementT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "InSyncState", scope = ManagedElementT.class)
    public JAXBElement<Boolean> createManagedElementTInSyncState(Boolean value) {
        return new JAXBElement<Boolean>(_ManagedElementTInSyncState_QNAME, Boolean.class, ManagedElementT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "location", scope = ManagedElementT.class)
    public JAXBElement<String> createManagedElementTLocation(String value) {
        return new JAXBElement<String>(_ManagedElementTLocation_QNAME, String.class, ManagedElementT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInventoryT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "getInventory")
    public JAXBElement<GetInventoryT> createGetInventory(GetInventoryT value) {
        return new JAXBElement<GetInventoryT>(_GetInventory_QNAME, GetInventoryT.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InventoryDataT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "MTOSI_InventoryData")
    public JAXBElement<InventoryDataT> createMTOSIInventoryData(InventoryDataT value) {
        return new JAXBElement<InventoryDataT>(_MTOSIInventoryData_QNAME, InventoryDataT.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInventoryResponseT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "getInventoryResponse")
    public JAXBElement<GetInventoryResponseT> createGetInventoryResponse(GetInventoryResponseT value) {
        return new JAXBElement<GetInventoryResponseT>(_GetInventoryResponse_QNAME, GetInventoryResponseT.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "installedPartNumber", scope = EquipmentT.class)
    public JAXBElement<String> createEquipmentTInstalledPartNumber(String value) {
        return new JAXBElement<String>(_EquipmentTInstalledPartNumber_QNAME, String.class, EquipmentT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "owner", scope = EquipmentT.class)
    public JAXBElement<String> createEquipmentTOwner(String value) {
        return new JAXBElement<String>(_ManagedElementTOwner_QNAME, String.class, EquipmentT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AliasNameListT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "aliasNameList", scope = EquipmentT.class)
    public JAXBElement<AliasNameListT> createEquipmentTAliasNameList(AliasNameListT value) {
        return new JAXBElement<AliasNameListT>(_ManagedElementTAliasNameList_QNAME, AliasNameListT.class, EquipmentT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceStateT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "serviceState", scope = EquipmentT.class)
    public JAXBElement<ServiceStateT> createEquipmentTServiceState(ServiceStateT value) {
        return new JAXBElement<ServiceStateT>(_EquipmentTServiceState_QNAME, ServiceStateT.class, EquipmentT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "namingOS", scope = EquipmentT.class)
    public JAXBElement<String> createEquipmentTNamingOS(String value) {
        return new JAXBElement<String>(_ManagedElementTNamingOS_QNAME, String.class, EquipmentT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NamingAttributesT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "name", scope = EquipmentT.class)
    public JAXBElement<NamingAttributesT> createEquipmentTName(NamingAttributesT value) {
        return new JAXBElement<NamingAttributesT>(_ManagedElementTName_QNAME, NamingAttributesT.class, EquipmentT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "manufacturer", scope = EquipmentT.class)
    public JAXBElement<String> createEquipmentTManufacturer(String value) {
        return new JAXBElement<String>(_ManagedElementTManufacturer_QNAME, String.class, EquipmentT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "installedEquipmentObjectType", scope = EquipmentT.class)
    public JAXBElement<String> createEquipmentTInstalledEquipmentObjectType(String value) {
        return new JAXBElement<String>(_EquipmentTInstalledEquipmentObjectType_QNAME, String.class, EquipmentT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SourceT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "source", scope = EquipmentT.class)
    public JAXBElement<SourceT> createEquipmentTSource(SourceT value) {
        return new JAXBElement<SourceT>(_ManagedElementTSource_QNAME, SourceT.class, EquipmentT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "alarmReportingIndicator", scope = EquipmentT.class)
    public JAXBElement<Boolean> createEquipmentTAlarmReportingIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_EquipmentTAlarmReportingIndicator_QNAME, Boolean.class, EquipmentT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "expectedEquipmentObjectType", scope = EquipmentT.class)
    public JAXBElement<String> createEquipmentTExpectedEquipmentObjectType(String value) {
        return new JAXBElement<String>(_EquipmentTExpectedEquipmentObjectType_QNAME, String.class, EquipmentT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "userLabel", scope = EquipmentT.class)
    public JAXBElement<String> createEquipmentTUserLabel(String value) {
        return new JAXBElement<String>(_ManagedElementTUserLabel_QNAME, String.class, EquipmentT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "installedSerialNumber", scope = EquipmentT.class)
    public JAXBElement<String> createEquipmentTInstalledSerialNumber(String value) {
        return new JAXBElement<String>(_EquipmentTInstalledSerialNumber_QNAME, String.class, EquipmentT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResourceStateT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "resourceState", scope = EquipmentT.class)
    public JAXBElement<ResourceStateT> createEquipmentTResourceState(ResourceStateT value) {
        return new JAXBElement<ResourceStateT>(_ManagedElementTResourceState_QNAME, ResourceStateT.class, EquipmentT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "discoveredName", scope = EquipmentT.class)
    public JAXBElement<String> createEquipmentTDiscoveredName(String value) {
        return new JAXBElement<String>(_EquipmentTDiscoveredName_QNAME, String.class, EquipmentT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EqVendorExtensionsT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "vendorExtensions", scope = EquipmentT.class)
    public JAXBElement<EqVendorExtensionsT> createEquipmentTVendorExtensions(EqVendorExtensionsT value) {
        return new JAXBElement<EqVendorExtensionsT>(_EquipmentTVendorExtensions_QNAME, EqVendorExtensionsT.class, EquipmentT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "installedVersion", scope = EquipmentT.class)
    public JAXBElement<String> createEquipmentTInstalledVersion(String value) {
        return new JAXBElement<String>(_EquipmentTInstalledVersion_QNAME, String.class, EquipmentT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NamingAttributesT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "name", scope = ManagementDomainT.class)
    public JAXBElement<NamingAttributesT> createManagementDomainTName(NamingAttributesT value) {
        return new JAXBElement<NamingAttributesT>(_ManagedElementTName_QNAME, NamingAttributesT.class, ManagementDomainT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "manufacturerDate", scope = EquipmentHolderT.class)
    public JAXBElement<String> createEquipmentHolderTManufacturerDate(String value) {
        return new JAXBElement<String>(_ManagedElementTManufacturerDate_QNAME, String.class, EquipmentHolderT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "owner", scope = EquipmentHolderT.class)
    public JAXBElement<String> createEquipmentHolderTOwner(String value) {
        return new JAXBElement<String>(_ManagedElementTOwner_QNAME, String.class, EquipmentHolderT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EquipmentHolderT.AcceptableEquipmentTypeList }{@code >}}
     * 
//     */
//    @XmlElementDecl(namespace = "tmf854.v1", name = "acceptableEquipmentTypeList", scope = EquipmentHolderT.class)
//    public JAXBElement<EquipmentHolderT.AcceptableEquipmentTypeList> createEquipmentHolderTAcceptableEquipmentTypeList(EquipmentHolderT.AcceptableEquipmentTypeList value) {
//        return new JAXBElement<EquipmentHolderT.AcceptableEquipmentTypeList>(_EquipmentHolderTAcceptableEquipmentTypeList_QNAME, EquipmentHolderT.AcceptableEquipmentTypeList.class, EquipmentHolderT.class, value);
//    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AliasNameListT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "aliasNameList", scope = EquipmentHolderT.class)
    public JAXBElement<AliasNameListT> createEquipmentHolderTAliasNameList(AliasNameListT value) {
        return new JAXBElement<AliasNameListT>(_ManagedElementTAliasNameList_QNAME, AliasNameListT.class, EquipmentHolderT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HolderStateT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "holderState", scope = EquipmentHolderT.class)
    public JAXBElement<HolderStateT> createEquipmentHolderTHolderState(HolderStateT value) {
        return new JAXBElement<HolderStateT>(_EquipmentHolderTHolderState_QNAME, HolderStateT.class, EquipmentHolderT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "namingOS", scope = EquipmentHolderT.class)
    public JAXBElement<String> createEquipmentHolderTNamingOS(String value) {
        return new JAXBElement<String>(_ManagedElementTNamingOS_QNAME, String.class, EquipmentHolderT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NamingAttributesT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "name", scope = EquipmentHolderT.class)
    public JAXBElement<NamingAttributesT> createEquipmentHolderTName(NamingAttributesT value) {
        return new JAXBElement<NamingAttributesT>(_ManagedElementTName_QNAME, NamingAttributesT.class, EquipmentHolderT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "manufacturer", scope = EquipmentHolderT.class)
    public JAXBElement<String> createEquipmentHolderTManufacturer(String value) {
        return new JAXBElement<String>(_ManagedElementTManufacturer_QNAME, String.class, EquipmentHolderT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SourceT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "source", scope = EquipmentHolderT.class)
    public JAXBElement<SourceT> createEquipmentHolderTSource(SourceT value) {
        return new JAXBElement<SourceT>(_ManagedElementTSource_QNAME, SourceT.class, EquipmentHolderT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "alarmReportingIndicator", scope = EquipmentHolderT.class)
    public JAXBElement<Boolean> createEquipmentHolderTAlarmReportingIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_EquipmentTAlarmReportingIndicator_QNAME, Boolean.class, EquipmentHolderT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "userLabel", scope = EquipmentHolderT.class)
    public JAXBElement<String> createEquipmentHolderTUserLabel(String value) {
        return new JAXBElement<String>(_ManagedElementTUserLabel_QNAME, String.class, EquipmentHolderT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResourceStateT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "resourceState", scope = EquipmentHolderT.class)
    public JAXBElement<ResourceStateT> createEquipmentHolderTResourceState(ResourceStateT value) {
        return new JAXBElement<ResourceStateT>(_ManagedElementTResourceState_QNAME, ResourceStateT.class, EquipmentHolderT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "holderType", scope = EquipmentHolderT.class)
    public JAXBElement<String> createEquipmentHolderTHolderType(String value) {
        return new JAXBElement<String>(_EquipmentHolderTHolderType_QNAME, String.class, EquipmentHolderT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "discoveredName", scope = EquipmentHolderT.class)
    public JAXBElement<String> createEquipmentHolderTDiscoveredName(String value) {
        return new JAXBElement<String>(_EquipmentTDiscoveredName_QNAME, String.class, EquipmentHolderT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EHVendorExtensionsT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "vendorExtensions", scope = EquipmentHolderT.class)
    public JAXBElement<EHVendorExtensionsT> createEquipmentHolderTVendorExtensions(EHVendorExtensionsT value) {
        return new JAXBElement<EHVendorExtensionsT>(_EquipmentTVendorExtensions_QNAME, EHVendorExtensionsT.class, EquipmentHolderT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NamingAttributesT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "expectedOrInstalledEquipment", scope = EquipmentHolderT.class)
    public JAXBElement<NamingAttributesT> createEquipmentHolderTExpectedOrInstalledEquipment(NamingAttributesT value) {
        return new JAXBElement<NamingAttributesT>(_EquipmentHolderTExpectedOrInstalledEquipment_QNAME, NamingAttributesT.class, EquipmentHolderT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "location", scope = EquipmentHolderT.class)
    public JAXBElement<String> createEquipmentHolderTLocation(String value) {
        return new JAXBElement<String>(_ManagedElementTLocation_QNAME, String.class, EquipmentHolderT.class, value);
    }

}
