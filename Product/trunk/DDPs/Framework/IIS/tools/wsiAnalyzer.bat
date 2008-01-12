REM PC batch file (script) for executing the WS-I Analyzer against
REM mTOP Framework WS definitions (service interface SOAP/HTTP binding)

set WSI_HOME=..\..\..\..\..\..\tools\wsi-test-tools

call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiNotificationProducer.xml
call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiNotificationConsumer.xml
call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiNotificationBroker.xml
call %WSI_HOME%\java\bin\Analyzer.bat -config .\wsiMart.xml

pause