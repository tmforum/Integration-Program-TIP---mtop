package org.tmforum.lab.mtop.maven.plugin.release.compilephase;

/*
 *
 * Copyright 2001-2006 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Based on an example contributed by Bluetetra Software
 * (from wsdldoc1.1api.zip/Example.java)
 *
 */

//import org.apache.maven.archiver.MavenArchiveConfiguration;
//import org.apache.maven.archiver.MavenArchiver;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
//import org.apache.maven.project.MavenProject;
//import org.apache.maven.project.MavenProjectHelper;
//import org.codehaus.plexus.archiver.jar.JarArchiver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.bluetetra.app.docdb.wsdl.WSDLDocException;
import com.bluetetra.app.driver.WSDLDocGenerator;
import com.bluetetra.app.html.common.CommonHtmlException;
import com.bluetetra.app.html.wsdl.WSDLHtmlException;
import com.bluetetra.app.html.xsd.XSDHtmlException;
import com.bluetetra.app.service.PropertyManager;
import com.bluetetra.lib.service.LogHandler;
import com.bluetetra.lib.wsdl.WSDLException;
import com.bluetetra.lib.xml.XMLIOException;
import com.bluetetra.lib.xsd.XSDException;


/**
 * Base class for creating a WSDLdoc generated documentation
 * from project classes.
 *
 * @author <a href="sgaito@tmforum.org">Stephen Gaito</a>
 * @version $Id $
 */
public class WSDLdocMojo
    extends AbstractMojo
    implements LogHandler {
    
    /**
     * Path to the Bluetetra WSDLdoc properties file
     * (eg: D:\\WSDLdoc\\config\\wsdldoc.properties)
     *
     * @parameter expression="${project.build.directory}"
     * @required
     */
    String propFile;
    
    /**
     * Directory containing the Bluetetra WSDLdoc templates
     * (eg: D:\\WSDLdoc\\template\\default)
     * @parameter expression="${project.build.directory}"
     * @required
     */
    String templateDir;
    
    /**
     * WSDLdoc generated web-page title
     *
     * @parameter expression="${project.build.directory}" default-value="WSDL documentation generated by Bluetetra\'s WSDLdoc"
     */
    String title;
    
    /**
     * Input directory which recursively contains the wsdl files
     * (use absolute path if necessary)
     *
     * @parameter expression="${project.build.directory}"
     * @required
     */
    String inputDir;

    /**
     * Output directory for the WSDLdoc generated documentation
     * (use absolute path if necessary)
     *
     * @parameter expression="${project.build.directory}"
     * @required
     */
    String outputDir;

    /**
     * Generates the WSDLdoc documentation files.
     *
     * @todo Add license files in META-INF directory.
     */
    public void generateDocumentation(List wsdlUrlList)
        throws MojoExecutionException {

	PropertyManager propertyManager;
      
	try {
	    propertyManager = new PropertyManager (propFile);
	} catch (Exception ex) {
            throw new MojoExecutionException( "Error: Missing WSDLdoc.properties file or config directory.", ex);
	}
        
	//set the directory path to the template files
	propertyManager.setProperty(PropertyManager.template_basedir, 
				    templateDir);

	String hrefPrefix = null; //use null 
	String pathPrefix = null; //use null
	String xmlInstanceDepth = null; //use null
		
	//construct a WSDLDocGenerator object
	WSDLDocGenerator wsdlGen = new WSDLDocGenerator (propertyManager);
	
	try{
	    //Generate documents. Last parameter is the LogHandler
	    wsdlGen.generateDoc (wsdlUrlList, title, outputDir, hrefPrefix, 
				 pathPrefix, xmlInstanceDepth, this);
	    
	} catch (XSDException ex0) {    
            throw new MojoExecutionException( "Error: XSD exception", ex0 );
	} catch (XMLIOException ex1) {
            throw new MojoExecutionException( "Error: XML IO exception", ex1 );
	} catch (WSDLException ex2) {
            throw new MojoExecutionException( "Error: WSDL exception", ex2 );
	} catch (WSDLDocException ex3) {
            throw new MojoExecutionException( "Error: WSDL doc exception", 
					      ex3 );
	} catch (WSDLHtmlException ex4) {
            throw new MojoExecutionException( "Error: WSDL html exception", 
					      ex4 );
	} catch (XSDHtmlException ex5) {
            throw new MojoExecutionException( "Error: XSD html exception", 
					      ex5 );
	} catch (CommonHtmlException ex7) {
            throw new MojoExecutionException( "Error: Common html exception", 
					      ex7 );
	} catch (Exception ex6) {
            throw new MojoExecutionException( "Error: unknown exception", 
					      ex6 );
	}                       
    }
    

    public void log (String mesg) {
	getLog().debug(mesg);
    }
    
    public void warning (String mesg) {
	getLog().warn(mesg);
    }
    
    public void error (String mesg) {
	getLog().error(mesg);
    }
    
    public void fatal (String mesg) {
	getLog().error(mesg);
    }


    private List wsdlUrlList;

    // find all files with a "wsdl" extension
    public void findAllWSDLfiles(File dir) {
	if (dir.isDirectory()) {
	    String[] children = dir.list();
	    for (int i=0; i<children.length; i++) {
		visitAllFiles(new File(dir, children[i]));
	    }
	} else {
	    //add all the xsd and wsdl url here
	    wsdlUrlList.add("file::///"+dir);
	}
    }
    
    /**
     * Finds the wsdl urls for WSDLdoc documentation.
     *
     * @todo Add license files in META-INF directory.
     */
    public void execute()
        throws MojoExecutionException {

	wsdlUrlList = new ArrayList();

	findAllWSDLfiles(File(inputDir));
	
	generateDocumentation(wsdlUrlList);
    }
}