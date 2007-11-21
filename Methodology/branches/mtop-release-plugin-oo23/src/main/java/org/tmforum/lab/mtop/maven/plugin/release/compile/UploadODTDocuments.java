package org.tmforum.lab.mtop.maven.plugin.release.compilephase;

/*
 * BASED UPON 
 *  maven-jar-plugin
 *  src/main/java/org/apache/maven/plugin/jar/AbstractJarMojo.java
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
 */

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectHelper;
import org.codehaus.plexus.archiver.jar.JarArchiver;

import java.io.File;
import java.util.regex.Pattern;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.lang.Exception;

import org.xmldb.api.base.*;
import org.xmldb.api.modules.*;
import org.xmldb.api.*;
import org.exist.xmldb.XQueryService;

/**
 * Upload the important contents of the mTOP word files
 * into the eXist XML database for further processing
 *
 * @author <a href="sgaito@tmforum.org">Stephen Gaito</a>
 * @version $Id $
 * @goal upload-odt-documents
 * @phase compile
 */
public class UploadODTDocuments
    extends AbstractMojo {

    /**
     * Input directory which recursively contains the odt files
     * to be fixed (use absolute path if necessary)
     *
     * @parameter expression="${mtop-release.odt-dir}"
     * @required
     */
    private String odtDir;

    /**
     * URI for the eXist xml database for uploading the xml parts
     * of the unZipped ODT files
     *
     * @parameter expression="${mtop-release.exist-xml-database-uri}"
     * @required
     */
    private String existUri;

    /**
     * Collection path for the eXist xml database for uploading the xml parts
     * of the unZipped ODT files
     *
     * @parameter expression="${mtop-release.exist-xml-database-collection}"
     * @required
     */
    private String existCollection;


    /**
     * Username for eXist connection
     *
     * @parameter expression="${mtop-release.exist-user-name}"
     * @required
     */
    private String existUserName;

    /**
     * Password for eXist connection
     *
     * @parameter expression="${mtop-release.exist-password}"
     * @required
     */
    private String existPassword;

    /**
     * 
     */
    public void uploadXMLfile(File xmlFile) {
	getLog().info("Uploading xml file: ["+xmlFile+"]");
	String finalCollectionPath = xmlFile.getParent().replace(odtDir,"");
	String fileName = xmlFile.getName();
	String fullCollectionPath = existCollection + finalCollectionPath;
	getLog().info("eXist uri: ["+existUri+"]");
	getLog().info("eXist base collection: ["+existCollection+"]");
	getLog().info("full collection: ["+fullCollectionPath+"]");
	getLog().info("file name: ["+fileName+"]");

	try {
	    
	    // initialize driver
	    String driver = "org.exist.xmldb.DatabaseImpl";
	    Class cl = Class.forName(driver);
	    Database database = (Database)cl.newInstance();
	    DatabaseManager.registerDatabase(database);
	    
	    // try to get collection
	    Collection col =
		DatabaseManager.getCollection(existUri + fullCollectionPath,
					      existUserName, existPassword);
	    
	    if(col == null) {
		// NEED TO WALK UP TO full existUri
		//
		// collection does not exist: get root collection and create
		// for simplicity, we assume that the new collection is a
		// direct child of the root collection, e.g. /db/test.
		// the example will fail otherwise.
		Collection root = DatabaseManager.getCollection(existUri
								+ "/db",
								existUserName,
								existPassword);
		CollectionManagementService mgtService 
		    = (CollectionManagementService)
		    root.getService("CollectionManagementService", "1.0");
		col = mgtService.createCollection(fullCollectionPath.substring("/db".length()));
	    }

	    // create new XMLResource; 
	    // an id will be assigned to the new resource
	    XMLResource document 
		= (XMLResource)col.createResource(fileName, "XMLResource");
	    document.setContent(xmlFile);
	    getLog().info("storing document " + document.getId() + "...");
	    col.storeResource(document);
	    getLog().info("Uploaded xml in: ["+xmlFile+"]");
	} catch (Exception ex) {
	    getLog().warn("Exception",ex);
	}
    }
    
    // find all files with a "xml" extension
    public void findAllXMLfiles(File dir) {
	if (dir.isDirectory()) {
	    // ignore .svn directories
	    if (!dir.toString().contains(".svn")) {
		String[] children = dir.list();
		for (int i=0; i<children.length; i++) {
		    findAllXMLfiles(new File(dir, children[i]));
		}
	    }
	} else {
	    //add all the xsd and wsdl url here
	    String fileURI = dir.toURI().toString();
	    getLog().debug("Looking at: ["+fileURI+"]");
	    if (fileURI.contains("content.xml") 
		|| fileURI.contains("meta.xml")
		|| fileURI.contains("svn-meta-data.xml")) {
		getLog().debug("Found xml file: ["+fileURI+"]");
		uploadXMLfile(dir);
	    }
	}
    }

    /**
     * Uploads xml files to eXist xml database.
     *
     * @todo Add license files in META-INF directory.
     */
    public void execute()
        throws MojoExecutionException {

	odtDir = odtDir.replace("file:","");
	findAllXMLfiles(new File(odtDir));
    }
}
