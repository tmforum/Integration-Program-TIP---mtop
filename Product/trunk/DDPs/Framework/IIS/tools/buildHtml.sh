#!/bin/sh -xe

##
## Generate the HTML documentation from the Framework DDP IIS (WSDL/XSD modules).
## This script uses:
##  - the WSDLdoc (MUST BE installed locally) application from http://www.bluetetra.com/
##  - Java required by WSDLdoc
##  - Perl and other various UNIX utilities
## 

##
## Initialize build
##
HTML_HOME=../html
WSDL_HOME="../../../../../../../Apps/WSDLdoc"

rm -rf $HTML_HOME
mkdir $HTML_HOME

##
## Generate doc
##
java -DWSDL_HOME=$WSDL_HOME -Xmx256m -jar $WSDL_HOME/wsdldoc.jar -title "MTOSI R2.0 Framework DDP IIS" -verbose -dir $HTML_HOME ../wsdl/Mart/* ../wsdl/NotificationBroker/* ../wsdl/NotificationConsumer/* ../wsdl/NotificationProducer/* ../xsd/Event*

#
# Fix absolute path issues with WSDLdoc HTML generation
#
perl -pi -e 's/\/xsd\/xsd/\/xsd/g' $HTML_HOME/overview.html

perl -pi -e 's/href="file:\/.:\/GForge_mTOP\/Product\/trunk\/DDPs\/Framework\/IIS\//href="\.\.\//g' $HTML_HOME/overview.html

perl -pi -e 's/>file:\/.:\/GForge_mTOP\/Product\/trunk\/DDPs\/Framework\/IIS\//>file:\//g' $HTML_HOME/overview.html

find $HTML_HOME/ -name "*.html" | xargs perl -pi -e 's/href="file:\/.:\/GForge_mTOP\/Product\/trunk\/DDPs\/Framework\/IIS\//href="\.\.\/\.\.\/\.\.\/\.\.\//g'

find $HTML_HOME/ -name "*.html" | xargs perl -pi -e 's/>file:\/.:\/GForge_mTOP\/Product\/trunk\/DDPs\/Framework\/IIS\//>file:\//g'

find $HTML_HOME/ -name "*.html.bak" -delete

cd ..
jar -cvf ./derived/FrameworkHtml.zip ./html ./xsd ./wsdl
cd tools

exit 0

