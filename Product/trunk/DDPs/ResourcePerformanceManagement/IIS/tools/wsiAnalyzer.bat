REM PC batch file (script) for executing the WS-I Analyzer against
REM mTOP RPM WS definitions (service interface SOAP/HTTP binding)

set WSI_HOME=..\..\..\..\..\..\tools\wsi-test-tools

call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiPerformanceManagementControl.xml
call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiPerformanceManagementRetrieval.xml
call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiThresholdCrossingAlertControl.xml

pause