REM PC batch file (script) for executing the WS-I Analyzer against
REM mTOP MRI WS definitions (service interface SOAP/HTTP binding)

set WSI_HOME=..\..\..\..\..\..\tools\wsi-test-tools

call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiConnectionRetrieval.xml
call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiOperationsSystem.xml
call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiResourceInventoryRetrieval.xml
call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiResourceInventoryUpdate.xml
call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiMultiLayerSubnetworkRetrieval.xml
call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiManagementDomainRetrieval.xml
call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiManagedElementRetrieval.xml
call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiFlowDomainRetrieval.xml
call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiEquipmentInventoryRetrieval.xml
call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiTransmissionDescriptorRetrieval.xml
call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiTrafficConditioningProfileRetrieval.xml
call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiTopologicalLinkRetrieval.xml
call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiTerminationPointRetrieval.xml

pause