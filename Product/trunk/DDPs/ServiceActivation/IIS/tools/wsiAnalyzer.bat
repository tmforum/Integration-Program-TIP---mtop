REM PC batch file (script) for executing the WS-I Analyzer against
REM mTOP RTM WS definitions (service interface SOAP/HTTP binding)

set WSI_HOME=..\..\..\..\..\..\tools\wsi-test-tools

call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiServiceActivationInterface.xml
call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiServiceComponentActivationInterface.xml

pause