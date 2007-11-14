#!/bin/sh -xe

##
## Generate the Java code from the Framework DDP IIS (WSDL/XSD modules).
## This script uses:
##  - the Apache XMLBeans (installed) application from http://xmlbeans.apache.org/
##  - Java required by XMLBeans
## 

##
## Initialize build
##
DDP_HOME=..
CODE_HOME=$DDP_HOME/Java
SRC_HOME=$CODE_HOME/src
CLASS_HOME=$CODE_HOME/class

rm -rf $CODE_HOME
mkdir $CODE_HOME

x=`which javac`
xdir=`dirname "$x"`
xdir2=`dirname "$xdir"`
export JAVA_HOME=`cygpath -m "$xdir2"`
export JAVA_HOME_CYGWIN=`cygpath -u -a :"$xdir2"`
echo "Using JAVA_HOME $JAVA_HOME"

export XMLBEANS_LIB=../../../../../../tools/xmlBeansLib
cp=$XMLBEANS_LIB/xbean.jar:$XMLBEANS_LIB/jsr173_1.0_api.jar:$XMLBEANS_LIB/resolver.jar:$JAVA_HOME/lib/tools.jar
cp=`cygpath -w -p "$cp"`

##
## Generate the library (JAR) of all java classes
## 
#    cp=`cygpath -w -p "$cp"`
java -Xmx256m -classpath "$cp" org.apache.xmlbeans.impl.tool.SchemaCompiler -mx 800m  -d $CLASS_HOME -src $SRC_HOME -out $DDP_HOME/Framework.jar -javasource 1.5 -debug ../xsd

##
## Generate the ZIP of all java source files
## 

cd $SRC_HOME
jar -cvf $DDP_HOME/FrameworkJava.zip . 
cd ../../tools

exit 0

