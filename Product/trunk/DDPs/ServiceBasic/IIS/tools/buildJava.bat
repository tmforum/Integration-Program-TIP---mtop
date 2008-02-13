REM PC batch file (script) for generating the Java library of this DDP using XMLBeans

set DDP_HOME=..
set CODE_HOME=%DDP_HOME%\Java
set SRC_HOME=%CODE_HOME%\src
set CLASS_HOME=%CODE_HOME%\class

set XMLBEANS_LIB=..\..\..\..\..\..\tools\xmlBeansLib
set CP=%XMLBEANS_LIB%/xbean.jar;%XMLBEANS_LIB%\jsr173_1.0_api.jar;%XMLBEANS_LIB%\resolver.jar;%JAVA_HOME%\lib\tools.jar

REM Generate using XMLBeans
java -Xmx256m -classpath "%cp%" org.apache.xmlbeans.impl.tool.SchemaCompiler -mx 800m  -d %CLASS_HOME% -src %SRC_HOME% -out %DDP_HOME%\derived\New_ServiceBasic.jar -javasource 1.5 -debug ..\xsd

REM Package into library
cd %SRC_HOME%
jar -cvf ..\..\derived\New_ServiceBasicJava.zip .
cd ..\..\tools

pause