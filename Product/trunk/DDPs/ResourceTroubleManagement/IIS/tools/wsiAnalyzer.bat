REM PC batch file (script) for executing the WS-I Analyzer against
REM mTOP RTM WS definitions (service interface SOAP/HTTP binding)

set WSI_HOME=..\..\..\..\..\..\tools\wsi-test-tools

call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiAlarmControl.xml
call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiAlarmHandling.xml
call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiAlarmRetrieval.xml
call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiAsapControl.xml
call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiAsapRetrieval.xml
call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiMaintenanceControl.xml
call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiProtectionControl.xml
call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiProtectionRetrieval.xml

pause