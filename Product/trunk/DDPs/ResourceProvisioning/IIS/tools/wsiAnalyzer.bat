REM PC batch file (script) for executing the WS-I Analyzer against
REM mTOP RP WS definitions (service interface SOAP/HTTP binding)

set WSI_HOME=..\..\..\..\..\..\tools\wsi-test-tools

call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiConnectionControl.xml
call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiCommonResourceProvisioning.xml
call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiEquipmentProvisioning.xml
call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiFlowDomainControl.xml
call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiGuiCutThroughControl.xml
call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiSoftwareAndDataControl.xml
call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiTerminationPointControl.xml
call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiTopologicalLinkControl.xml
call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiTrafficConditioningProfileControl.xml
call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiTransmissionDescriptorControl.xml

pause