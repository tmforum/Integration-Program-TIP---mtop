
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

    private final static QName _GetInventory_QNAME = new QName("tmf854.v1", "getInventory");
    private final static QName _ProcessingFailureException_QNAME = new QName("tmf854.v1", "ProcessingFailureException");
    private final static QName _MTOSIInventoryData_QNAME = new QName("tmf854.v1", "MTOSI_InventoryData");
    private final static QName _GetInventoryResponse_QNAME = new QName("tmf854.v1", "getInventoryResponse");
    private final static QName _MultiLayerSubnetworkTSupportedRates_QNAME = new QName("tmf854.v1", "supportedRates");
    private final static QName _MultiLayerSubnetworkTVendorExtensions_QNAME = new QName("tmf854.v1", "vendorExtensions");
    private final static QName _ManagedElementTInSyncState_QNAME = new QName("tmf854.v1", "InSyncState");
    private final static QName _TPDataTIngressTransmissionDescriptorName_QNAME = new QName("tmf854.v1", "ingressTransmissionDescriptorName");
    private final static QName _TPDataTEgressTransmissionDescriptorName_QNAME = new QName("tmf854.v1", "egressTransmissionDescriptorName");
    private final static QName _TPDataTTransmissionParams_QNAME = new QName("tmf854.v1", "transmissionParams");
    private final static QName _TPDataTTpMappingMode_QNAME = new QName("tmf854.v1", "tpMappingMode");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: v1.tmf854
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PGPInventoryT }
     * 
     */
    public PGPInventoryT createPGPInventoryT() {
        return new PGPInventoryT();
    }

    /**
     * Create an instance of {@link LayerRate }
     * 
     */
    public LayerRate createLayerRate() {
        return new LayerRate();
    }

    /**
     * Create an instance of {@link PGVendorExtensionsT }
     * 
     */
    public PGVendorExtensionsT createPGVendorExtensionsT() {
        return new PGVendorExtensionsT();
    }

    /**
     * Create an instance of {@link EquipmentT }
     * 
     */
    public EquipmentT createEquipmentT() {
        return new EquipmentT();
    }

    /**
     * Create an instance of {@link ObjectDiscoveryExtT }
     * 
     */
    public ObjectDiscoveryExtT createObjectDiscoveryExtT() {
        return new ObjectDiscoveryExtT();
    }

    /**
     * Create an instance of {@link MEInventoryT.PtpList }
     * 
     */
    public MEInventoryT.PtpList createMEInventoryTPtpList() {
        return new MEInventoryT.PtpList();
    }

    /**
     * Create an instance of {@link EquipmentHolderT }
     * 
     */
    public EquipmentHolderT createEquipmentHolderT() {
        return new EquipmentHolderT();
    }

    /**
     * Create an instance of {@link SNCInventoryT }
     * 
     */
    public SNCInventoryT createSNCInventoryT() {
        return new SNCInventoryT();
    }

    /**
     * Create an instance of {@link NameAndStringValueT }
     * 
     */
    public NameAndStringValueT createNameAndStringValueT() {
        return new NameAndStringValueT();
    }

    /**
     * Create an instance of {@link PTPVendorExtensionsT }
     * 
     */
    public PTPVendorExtensionsT createPTPVendorExtensionsT() {
        return new PTPVendorExtensionsT();
    }

    /**
     * Create an instance of {@link NamingAttributesT }
     * 
     */
    public NamingAttributesT createNamingAttributesT() {
        return new NamingAttributesT();
    }

    /**
     * Create an instance of {@link EquipmentOrHolderListT }
     * 
     */
    public EquipmentOrHolderListT createEquipmentOrHolderListT() {
        return new EquipmentOrHolderListT();
    }

    /**
     * Create an instance of {@link ESwitchDataExtensionsT }
     * 
     */
    public ESwitchDataExtensionsT createESwitchDataExtensionsT() {
        return new ESwitchDataExtensionsT();
    }

    /**
     * Create an instance of {@link TLVendorExtensionsT }
     * 
     */
    public TLVendorExtensionsT createTLVendorExtensionsT() {
        return new TLVendorExtensionsT();
    }

    /**
     * Create an instance of {@link MEInventoryT }
     * 
     */
    public MEInventoryT createMEInventoryT() {
        return new MEInventoryT();
    }

    /**
     * Create an instance of {@link DataQualityIndicatorT }
     * 
     */
    public DataQualityIndicatorT createDataQualityIndicatorT() {
        return new DataQualityIndicatorT();
    }

    /**
     * Create an instance of {@link TopologicalLinkT }
     * 
     */
    public TopologicalLinkT createTopologicalLinkT() {
        return new TopologicalLinkT();
    }

    /**
     * Create an instance of {@link EHInventoryT }
     * 
     */
    public EHInventoryT createEHInventoryT() {
        return new EHInventoryT();
    }

    /**
     * Create an instance of {@link ProcessingFailureExceptionAdditionalInfoT }
     * 
     */
    public ProcessingFailureExceptionAdditionalInfoT createProcessingFailureExceptionAdditionalInfoT() {
        return new ProcessingFailureExceptionAdditionalInfoT();
    }

    /**
     * Create an instance of {@link ActivityStatusT }
     * 
     */
    public ActivityStatusT createActivityStatusT() {
        return new ActivityStatusT();
    }

    /**
     * Create an instance of {@link TPPoolInventoryT }
     * 
     */
    public TPPoolInventoryT createTPPoolInventoryT() {
        return new TPPoolInventoryT();
    }

    /**
     * Create an instance of {@link TLInventoryT }
     * 
     */
    public TLInventoryT createTLInventoryT() {
        return new TLInventoryT();
    }

    /**
     * Create an instance of {@link EventLossOccuredExtT }
     * 
     */
    public EventLossOccuredExtT createEventLossOccuredExtT() {
        return new EventLossOccuredExtT();
    }

    /**
     * Create an instance of {@link PGPParametersT }
     * 
     */
    public PGPParametersT createPGPParametersT() {
        return new PGPParametersT();
    }

    /**
     * Create an instance of {@link EPGVendorExtensionsT }
     * 
     */
    public EPGVendorExtensionsT createEPGVendorExtensionsT() {
        return new EPGVendorExtensionsT();
    }

    /**
     * Create an instance of {@link RouteT }
     * 
     */
    public RouteT createRouteT() {
        return new RouteT();
    }

    /**
     * Create an instance of {@link FTPVendorExtensionsT }
     * 
     */
    public FTPVendorExtensionsT createFTPVendorExtensionsT() {
        return new FTPVendorExtensionsT();
    }

    /**
     * Create an instance of {@link SupportingOSNameList }
     * 
     */
    public SupportingOSNameList createSupportingOSNameList() {
        return new SupportingOSNameList();
    }

    /**
     * Create an instance of {@link LayerRateListT }
     * 
     */
    public LayerRateListT createLayerRateListT() {
        return new LayerRateListT();
    }

    /**
     * Create an instance of {@link FloatingTerminationPointT }
     * 
     */
    public FloatingTerminationPointT createFloatingTerminationPointT() {
        return new FloatingTerminationPointT();
    }

    /**
     * Create an instance of {@link CCVendorExtensionsT }
     * 
     */
    public CCVendorExtensionsT createCCVendorExtensionsT() {
        return new CCVendorExtensionsT();
    }

    /**
     * Create an instance of {@link TPPoolT }
     * 
     */
    public TPPoolT createTPPoolT() {
        return new TPPoolT();
    }

    /**
     * Create an instance of {@link SNCVendorExtensionsT }
     * 
     */
    public SNCVendorExtensionsT createSNCVendorExtensionsT() {
        return new SNCVendorExtensionsT();
    }

    /**
     * Create an instance of {@link AliasNameListT }
     * 
     */
    public AliasNameListT createAliasNameListT() {
        return new AliasNameListT();
    }

    /**
     * Create an instance of {@link FTPInventoryT.CtpList }
     * 
     */
    public FTPInventoryT.CtpList createFTPInventoryTCtpList() {
        return new FTPInventoryT.CtpList();
    }

    /**
     * Create an instance of {@link InventoryDataT.MdList }
     * 
     */
    public InventoryDataT.MdList createInventoryDataTMdList() {
        return new InventoryDataT.MdList();
    }

    /**
     * Create an instance of {@link CrossConnectT.ZEndNameList }
     * 
     */
    public CrossConnectT.ZEndNameList createCrossConnectTZEndNameList() {
        return new CrossConnectT.ZEndNameList();
    }

    /**
     * Create an instance of {@link NamingAttributesListT }
     * 
     */
    public NamingAttributesListT createNamingAttributesListT() {
        return new NamingAttributesListT();
    }

    /**
     * Create an instance of {@link HeaderT.MsgSpecificProperties }
     * 
     */
    public HeaderT.MsgSpecificProperties createHeaderTMsgSpecificProperties() {
        return new HeaderT.MsgSpecificProperties();
    }

    /**
     * Create an instance of {@link PTPInventoryT.CtpList }
     * 
     */
    public PTPInventoryT.CtpList createPTPInventoryTCtpList() {
        return new PTPInventoryT.CtpList();
    }

    /**
     * Create an instance of {@link MDInventoryT.MlsnList }
     * 
     */
    public MDInventoryT.MlsnList createMDInventoryTMlsnList() {
        return new MDInventoryT.MlsnList();
    }

    /**
     * Create an instance of {@link EPGPInventoryT }
     * 
     */
    public EPGPInventoryT createEPGPInventoryT() {
        return new EPGPInventoryT();
    }

    /**
     * Create an instance of {@link TMDVendorExtensionsT }
     * 
     */
    public TMDVendorExtensionsT createTMDVendorExtensionsT() {
        return new TMDVendorExtensionsT();
    }

    /**
     * Create an instance of {@link AssociatedMEList }
     * 
     */
    public AssociatedMEList createAssociatedMEList() {
        return new AssociatedMEList();
    }

    /**
     * Create an instance of {@link SimpleFilterT }
     * 
     */
    public SimpleFilterT createSimpleFilterT() {
        return new SimpleFilterT();
    }

    /**
     * Create an instance of {@link HeartbeatExtT }
     * 
     */
    public HeartbeatExtT createHeartbeatExtT() {
        return new HeartbeatExtT();
    }

    /**
     * Create an instance of {@link MEVendorExtensionsT }
     * 
     */
    public MEVendorExtensionsT createMEVendorExtensionsT() {
        return new MEVendorExtensionsT();
    }

    /**
     * Create an instance of {@link SourceT }
     * 
     */
    public SourceT createSourceT() {
        return new SourceT();
    }

    /**
     * Create an instance of {@link MLSNInventoryT.TpPoolList }
     * 
     */
    public MLSNInventoryT.TpPoolList createMLSNInventoryTTpPoolList() {
        return new MLSNInventoryT.TpPoolList();
    }

    /**
     * Create an instance of {@link EventLossClearedExtT }
     * 
     */
    public EventLossClearedExtT createEventLossClearedExtT() {
        return new EventLossClearedExtT();
    }

    /**
     * Create an instance of {@link PhysicalTerminationPointT }
     * 
     */
    public PhysicalTerminationPointT createPhysicalTerminationPointT() {
        return new PhysicalTerminationPointT();
    }

    /**
     * Create an instance of {@link ResourceStateT }
     * 
     */
    public ResourceStateT createResourceStateT() {
        return new ResourceStateT();
    }

    /**
     * Create an instance of {@link HdrVendorExtensionsT }
     * 
     */
    public HdrVendorExtensionsT createHdrVendorExtensionsT() {
        return new HdrVendorExtensionsT();
    }

    /**
     * Create an instance of {@link MLSNInventoryT.TlList }
     * 
     */
    public MLSNInventoryT.TlList createMLSNInventoryTTlList() {
        return new MLSNInventoryT.TlList();
    }

    /**
     * Create an instance of {@link EPGPParametersExtT }
     * 
     */
    public EPGPParametersExtT createEPGPParametersExtT() {
        return new EPGPParametersExtT();
    }

    /**
     * Create an instance of {@link LayeredParametersListT }
     * 
     */
    public LayeredParametersListT createLayeredParametersListT() {
        return new LayeredParametersListT();
    }

    /**
     * Create an instance of {@link EquipmentOrHolderT }
     * 
     */
    public EquipmentOrHolderT createEquipmentOrHolderT() {
        return new EquipmentOrHolderT();
    }

    /**
     * Create an instance of {@link ServiceStateT }
     * 
     */
    public ServiceStateT createServiceStateT() {
        return new ServiceStateT();
    }

    /**
     * Create an instance of {@link ProtectionGroupT }
     * 
     */
    public ProtectionGroupT createProtectionGroupT() {
        return new ProtectionGroupT();
    }

    /**
     * Create an instance of {@link RouteVendorExtensionsT }
     * 
     */
    public RouteVendorExtensionsT createRouteVendorExtensionsT() {
        return new RouteVendorExtensionsT();
    }

    /**
     * Create an instance of {@link FileTransferStatusExtT }
     * 
     */
    public FileTransferStatusExtT createFileTransferStatusExtT() {
        return new FileTransferStatusExtT();
    }

    /**
     * Create an instance of {@link AcceptableEquipmentType }
     * 
     */
    public AcceptableEquipmentType createAcceptableEquipmentType() {
        return new AcceptableEquipmentType();
    }

    /**
     * Create an instance of {@link TPPoolVendorExtensionsT }
     * 
     */
    public TPPoolVendorExtensionsT createTPPoolVendorExtensionsT() {
        return new TPPoolVendorExtensionsT();
    }

    /**
     * Create an instance of {@link AliasNameListT.Alias }
     * 
     */
    public AliasNameListT.Alias createAliasNameListTAlias() {
        return new AliasNameListT.Alias();
    }

    /**
     * Create an instance of {@link MultiLayerSubnetworkT }
     * 
     */
    public MultiLayerSubnetworkT createMultiLayerSubnetworkT() {
        return new MultiLayerSubnetworkT();
    }

    /**
     * Create an instance of {@link CTPVendorExtensionsT }
     * 
     */
    public CTPVendorExtensionsT createCTPVendorExtensionsT() {
        return new CTPVendorExtensionsT();
    }

    /**
     * Create an instance of {@link MEInventoryT.FtpList }
     * 
     */
    public MEInventoryT.FtpList createMEInventoryTFtpList() {
        return new MEInventoryT.FtpList();
    }

    /**
     * Create an instance of {@link GetInventoryResponseT }
     * 
     */
    public GetInventoryResponseT createGetInventoryResponseT() {
        return new GetInventoryResponseT();
    }

    /**
     * Create an instance of {@link StateChangeExtT }
     * 
     */
    public StateChangeExtT createStateChangeExtT() {
        return new StateChangeExtT();
    }

    /**
     * Create an instance of {@link MLSNInventoryT }
     * 
     */
    public MLSNInventoryT createMLSNInventoryT() {
        return new MLSNInventoryT();
    }

    /**
     * Create an instance of {@link ProtectionSwitchExtT }
     * 
     */
    public ProtectionSwitchExtT createProtectionSwitchExtT() {
        return new ProtectionSwitchExtT();
    }

    /**
     * Create an instance of {@link EHVendorExtensionsT }
     * 
     */
    public EHVendorExtensionsT createEHVendorExtensionsT() {
        return new EHVendorExtensionsT();
    }

    /**
     * Create an instance of {@link MDInventoryT.TlList }
     * 
     */
    public MDInventoryT.TlList createMDInventoryTTlList() {
        return new MDInventoryT.TlList();
    }

    /**
     * Create an instance of {@link HeaderT }
     * 
     */
    public HeaderT createHeaderT() {
        return new HeaderT();
    }

    /**
     * Create an instance of {@link TPDataListT }
     * 
     */
    public TPDataListT createTPDataListT() {
        return new TPDataListT();
    }

    /**
     * Create an instance of {@link CTPInventoryT }
     * 
     */
    public CTPInventoryT createCTPInventoryT() {
        return new CTPInventoryT();
    }

    /**
     * Create an instance of {@link MLSNInventoryT.SncList }
     * 
     */
    public MLSNInventoryT.SncList createMLSNInventoryTSncList() {
        return new MLSNInventoryT.SncList();
    }

    /**
     * Create an instance of {@link SupportingOSName }
     * 
     */
    public SupportingOSName createSupportingOSName() {
        return new SupportingOSName();
    }

    /**
     * Create an instance of {@link NVSListT }
     * 
     */
    public NVSListT createNVSListT() {
        return new NVSListT();
    }

    /**
     * Create an instance of {@link HeaderT.MsgSpecificProperties.Property }
     * 
     */
    public HeaderT.MsgSpecificProperties.Property createHeaderTMsgSpecificPropertiesProperty() {
        return new HeaderT.MsgSpecificProperties.Property();
    }

    /**
     * Create an instance of {@link CrossConnectT }
     * 
     */
    public CrossConnectT createCrossConnectT() {
        return new CrossConnectT();
    }

    /**
     * Create an instance of {@link EProtectionGroupT }
     * 
     */
    public EProtectionGroupT createEProtectionGroupT() {
        return new EProtectionGroupT();
    }

    /**
     * Create an instance of {@link OSVendorExtensionsT }
     * 
     */
    public OSVendorExtensionsT createOSVendorExtensionsT() {
        return new OSVendorExtensionsT();
    }

    /**
     * Create an instance of {@link EHInventoryT.EhList }
     * 
     */
    public EHInventoryT.EhList createEHInventoryTEhList() {
        return new EHInventoryT.EhList();
    }

    /**
     * Create an instance of {@link LayeredParametersT }
     * 
     */
    public LayeredParametersT createLayeredParametersT() {
        return new LayeredParametersT();
    }

    /**
     * Create an instance of {@link MDInventoryT.MeList }
     * 
     */
    public MDInventoryT.MeList createMDInventoryTMeList() {
        return new MDInventoryT.MeList();
    }

    /**
     * Create an instance of {@link ManagementDomainT }
     * 
     */
    public ManagementDomainT createManagementDomainT() {
        return new ManagementDomainT();
    }

    /**
     * Create an instance of {@link GetInventoryT }
     * 
     */
    public GetInventoryT createGetInventoryT() {
        return new GetInventoryT();
    }

    /**
     * Create an instance of {@link ProcessingFailureExceptionT }
     * 
     */
    public ProcessingFailureExceptionT createProcessingFailureExceptionT() {
        return new ProcessingFailureExceptionT();
    }

    /**
     * Create an instance of {@link MEInventoryT.EpgpList }
     * 
     */
    public MEInventoryT.EpgpList createMEInventoryTEpgpList() {
        return new MEInventoryT.EpgpList();
    }

    /**
     * Create an instance of {@link AssociatedMEList.AssociatedME }
     * 
     */
    public AssociatedMEList.AssociatedME createAssociatedMEListAssociatedME() {
        return new AssociatedMEList.AssociatedME();
    }

    /**
     * Create an instance of {@link TPDataT }
     * 
     */
    public TPDataT createTPDataT() {
        return new TPDataT();
    }

    /**
     * Create an instance of {@link VendorObjectExtensionsT }
     * 
     */
    public VendorObjectExtensionsT createVendorObjectExtensionsT() {
        return new VendorObjectExtensionsT();
    }

    /**
     * Create an instance of {@link AlarmExtT }
     * 
     */
    public AlarmExtT createAlarmExtT() {
        return new AlarmExtT();
    }

    /**
     * Create an instance of {@link FTPInventoryT }
     * 
     */
    public FTPInventoryT createFTPInventoryT() {
        return new FTPInventoryT();
    }

    /**
     * Create an instance of {@link EPGPParametersT }
     * 
     */
    public EPGPParametersT createEPGPParametersT() {
        return new EPGPParametersT();
    }

    /**
     * Create an instance of {@link SubnetworkConnectionT }
     * 
     */
    public SubnetworkConnectionT createSubnetworkConnectionT() {
        return new SubnetworkConnectionT();
    }

    /**
     * Create an instance of {@link CrossConnectListT }
     * 
     */
    public CrossConnectListT createCrossConnectListT() {
        return new CrossConnectListT();
    }

    /**
     * Create an instance of {@link PTPInventoryT }
     * 
     */
    public PTPInventoryT createPTPInventoryT() {
        return new PTPInventoryT();
    }

    /**
     * Create an instance of {@link SwitchDataExtensionsT }
     * 
     */
    public SwitchDataExtensionsT createSwitchDataExtensionsT() {
        return new SwitchDataExtensionsT();
    }

    /**
     * Create an instance of {@link EqVendorExtensionsT }
     * 
     */
    public EqVendorExtensionsT createEqVendorExtensionsT() {
        return new EqVendorExtensionsT();
    }

    /**
     * Create an instance of {@link MEInventoryT.PgpList }
     * 
     */
    public MEInventoryT.PgpList createMEInventoryTPgpList() {
        return new MEInventoryT.PgpList();
    }

    /**
     * Create an instance of {@link AssociatedMEList.AssociatedME.EdgeFTPList }
     * 
     */
    public AssociatedMEList.AssociatedME.EdgeFTPList createAssociatedMEListAssociatedMEEdgeFTPList() {
        return new AssociatedMEList.AssociatedME.EdgeFTPList();
    }

    /**
     * Create an instance of {@link ManagementDomainListT }
     * 
     */
    public ManagementDomainListT createManagementDomainListT() {
        return new ManagementDomainListT();
    }

    /**
     * Create an instance of {@link MDVendorExtensionsT }
     * 
     */
    public MDVendorExtensionsT createMDVendorExtensionsT() {
        return new MDVendorExtensionsT();
    }

    /**
     * Create an instance of {@link ProcessingFailureExceptionVendorExtensionsT }
     * 
     */
    public ProcessingFailureExceptionVendorExtensionsT createProcessingFailureExceptionVendorExtensionsT() {
        return new ProcessingFailureExceptionVendorExtensionsT();
    }

    /**
     * Create an instance of {@link CrossConnectT.AEndNameList }
     * 
     */
    public CrossConnectT.AEndNameList createCrossConnectTAEndNameList() {
        return new CrossConnectT.AEndNameList();
    }

    /**
     * Create an instance of {@link ManagedElementT }
     * 
     */
    public ManagedElementT createManagedElementT() {
        return new ManagedElementT();
    }

    /**
     * Create an instance of {@link AcceptableEquipmentTypeList }
     * 
     */
    public AcceptableEquipmentTypeList createAcceptableEquipmentTypeList() {
        return new AcceptableEquipmentTypeList();
    }

    /**
     * Create an instance of {@link EqInventoryT }
     * 
     */
    public EqInventoryT createEqInventoryT() {
        return new EqInventoryT();
    }

    /**
     * Create an instance of {@link AssociatedMEList.AssociatedME.EdgePTPList }
     * 
     */
    public AssociatedMEList.AssociatedME.EdgePTPList createAssociatedMEListAssociatedMEEdgePTPList() {
        return new AssociatedMEList.AssociatedME.EdgePTPList();
    }

    /**
     * Create an instance of {@link InventoryDataT }
     * 
     */
    public InventoryDataT createInventoryDataT() {
        return new InventoryDataT();
    }

    /**
     * Create an instance of {@link VendorNotificationExtT }
     * 
     */
    public VendorNotificationExtT createVendorNotificationExtT() {
        return new VendorNotificationExtT();
    }

    /**
     * Create an instance of {@link MDInventoryT }
     * 
     */
    public MDInventoryT createMDInventoryT() {
        return new MDInventoryT();
    }

    /**
     * Create an instance of {@link MEInventoryT.CcList }
     * 
     */
    public MEInventoryT.CcList createMEInventoryTCcList() {
        return new MEInventoryT.CcList();
    }

    /**
     * Create an instance of {@link MEInventoryT.EhList }
     * 
     */
    public MEInventoryT.EhList createMEInventoryTEhList() {
        return new MEInventoryT.EhList();
    }

    /**
     * Create an instance of {@link TransmissionParametersExtT }
     * 
     */
    public TransmissionParametersExtT createTransmissionParametersExtT() {
        return new TransmissionParametersExtT();
    }

    /**
     * Create an instance of {@link ObjectDeletionExtT }
     * 
     */
    public ObjectDeletionExtT createObjectDeletionExtT() {
        return new ObjectDeletionExtT();
    }

    /**
     * Create an instance of {@link EProtectionSwitchExtT }
     * 
     */
    public EProtectionSwitchExtT createEProtectionSwitchExtT() {
        return new EProtectionSwitchExtT();
    }

    /**
     * Create an instance of {@link SimpleFilterT.IncludedObjectType }
     * 
     */
    public SimpleFilterT.IncludedObjectType createSimpleFilterTIncludedObjectType() {
        return new SimpleFilterT.IncludedObjectType();
    }

    /**
     * Create an instance of {@link AttributeValueChangeExtT }
     * 
     */
    public AttributeValueChangeExtT createAttributeValueChangeExtT() {
        return new AttributeValueChangeExtT();
    }

    /**
     * Create an instance of {@link PGPParametersExtT }
     * 
     */
    public PGPParametersExtT createPGPParametersExtT() {
        return new PGPParametersExtT();
    }

    /**
     * Create an instance of {@link ObjectCreationExtT }
     * 
     */
    public ObjectCreationExtT createObjectCreationExtT() {
        return new ObjectCreationExtT();
    }

    /**
     * Create an instance of {@link ConnectionTerminationPointT }
     * 
     */
    public ConnectionTerminationPointT createConnectionTerminationPointT() {
        return new ConnectionTerminationPointT();
    }

    /**
     * Create an instance of {@link MLSVendorExtensionsT }
     * 
     */
    public MLSVendorExtensionsT createMLSVendorExtensionsT() {
        return new MLSVendorExtensionsT();
    }

    /**
     * Create an instance of {@link ExceptionVendorExtensionsT }
     * 
     */
    public ExceptionVendorExtensionsT createExceptionVendorExtensionsT() {
        return new ExceptionVendorExtensionsT();
    }

    /**
     * Create an instance of {@link ManagedElementListT }
     * 
     */
    public ManagedElementListT createManagedElementListT() {
        return new ManagedElementListT();
    }

    /**
     * Create an instance of {@link GetInventoryIteratorT }
     * 
     */
    public GetInventoryIteratorT createGetInventoryIteratorT() {
        return new GetInventoryIteratorT();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcessingFailureExceptionT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "ProcessingFailureException")
    public JAXBElement<ProcessingFailureExceptionT> createProcessingFailureException(ProcessingFailureExceptionT value) {
        return new JAXBElement<ProcessingFailureExceptionT>(_ProcessingFailureException_QNAME, ProcessingFailureExceptionT.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link LayerRateListT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "supportedRates", scope = MultiLayerSubnetworkT.class)
    public JAXBElement<LayerRateListT> createMultiLayerSubnetworkTSupportedRates(LayerRateListT value) {
        return new JAXBElement<LayerRateListT>(_MultiLayerSubnetworkTSupportedRates_QNAME, LayerRateListT.class, MultiLayerSubnetworkT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MLSVendorExtensionsT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "vendorExtensions", scope = MultiLayerSubnetworkT.class)
    public JAXBElement<MLSVendorExtensionsT> createMultiLayerSubnetworkTVendorExtensions(MLSVendorExtensionsT value) {
        return new JAXBElement<MLSVendorExtensionsT>(_MultiLayerSubnetworkTVendorExtensions_QNAME, MLSVendorExtensionsT.class, MultiLayerSubnetworkT.class, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link NamingAttributesT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "ingressTransmissionDescriptorName", scope = TPDataT.class)
    public JAXBElement<NamingAttributesT> createTPDataTIngressTransmissionDescriptorName(NamingAttributesT value) {
        return new JAXBElement<NamingAttributesT>(_TPDataTIngressTransmissionDescriptorName_QNAME, NamingAttributesT.class, TPDataT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NamingAttributesT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "egressTransmissionDescriptorName", scope = TPDataT.class)
    public JAXBElement<NamingAttributesT> createTPDataTEgressTransmissionDescriptorName(NamingAttributesT value) {
        return new JAXBElement<NamingAttributesT>(_TPDataTEgressTransmissionDescriptorName_QNAME, NamingAttributesT.class, TPDataT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LayeredParametersListT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "transmissionParams", scope = TPDataT.class)
    public JAXBElement<LayeredParametersListT> createTPDataTTransmissionParams(LayeredParametersListT value) {
        return new JAXBElement<LayeredParametersListT>(_TPDataTTransmissionParams_QNAME, LayeredParametersListT.class, TPDataT.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TerminationModeT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "tmf854.v1", name = "tpMappingMode", scope = TPDataT.class)
    public JAXBElement<TerminationModeT> createTPDataTTpMappingMode(TerminationModeT value) {
        return new JAXBElement<TerminationModeT>(_TPDataTTpMappingMode_QNAME, TerminationModeT.class, TPDataT.class, value);
    }

}
