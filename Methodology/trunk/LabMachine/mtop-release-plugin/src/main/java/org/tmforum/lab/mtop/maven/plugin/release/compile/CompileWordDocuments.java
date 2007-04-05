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

import org.apache.maven.archiver.MavenArchiveConfiguration;
import org.apache.maven.archiver.MavenArchiver;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectHelper;
import org.codehaus.plexus.archiver.jar.JarArchiver;

import java.lang.Runtime;
import java.lang.Process;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;
import java.util.zip.ZipEntry;
import java.net.ConnectException;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;

/**
 * Base class for compiling the word documents into 
 * OpenDocument (OpenOffice) and PDF versions.
 *
 * @author <a href="sgaito@tmforum.org">Stephen Gaito</a>
 * @version $Id $
 * @goal convert-word-documents
 * @phase generate-sources
 */
public class CompileWordDocuments
    extends AbstractMojo {

    /**
     * Input directory which recursively contains the word documents
     * to be converted (use absolute path if necessary)
     *
     * @parameter expression="${mtop-release.word-input-dir}"
     * @required
     */
    private String wordInputDir;

    /**
     * Regular expression used to filter included word files
     *
     * @parameter expression="${mtop-release.word-include-regexp}" default-value="include-everything"
     * @required
     */
    private String wordIncludesRegexp;
    private Pattern includesPattern;

    /**
     * Regular expression used to filter excluded text files
     *
     * @parameter expression="${mtop-release.word-exclude-regexp}" default-value="exclude-nothing"
     * @required
     */
    private String wordExcludesRegexp;
    private Pattern excludesPattern;

    /**
     * Output directory for the JODConverter generated documents
     * (use absolute path if necessary)
     *
     * @parameter expression="${mtop-release.word-output-dir}"
     * @required
     */
    private String wordOutputDir;


    /**
     * Repository directory for the unZipped ODT files
     * (use absolute path if necessary)
     *
     * @parameter expression="${mtop-release.odt-output-dir}"
     * @required
     */
    private String odtOutputDir;

    /**
     * OpenOffice command to start up open office in headless mode
     *
     * @parameter expression="${mtop-release.open-office-command}" default-value="soffice -headless -accept=\"socket,port=8100;urp;\""
     * @required
     */
    private String openOfficeCommand;

    /**
     * OpenOffice port over which connections can be made on this computer
     *
     * @parameter expression="${mtop-release.open-office-port}" default-value=8100
     * @required
     */
    private int openOfficePort;

    /**
     * The number of millliseconds to pause while waiting for OpenOffice to 
     * start up.
     *
     * @parameter expression="${mtop-release.open-office-startup-pause}" default-value=2000
     */
    private int openOfficePause;

    /**
     * ArtifactName
     *
     * @parameter expression="${mtop-release.artiface-name}" default-value = "${project.artifactId}"
     * @required
     */
    private String artifactName;
    
    public void copyInputStream(InputStream in, OutputStream out)
	throws IOException {
	byte[] buffer = new byte[1024];
	int len;
	
	while((len = in.read(buffer)) >= 0)
	    out.write(buffer, 0, len);
	
	in.close();
	out.close();
    }
    
    /**
     * unZip the ODT file to the appropriate repository
     * and then upload the content.xml to the eXist xml database
     */
    public void unpackODTfile(File odtFile, SVNInfoForFile svnInfo) {
	String odtFilePath = odtFile.getPath();
	getLog().info("Unziping odt file: ["+odtFilePath+"]");

	getLog().info("output path: ["+odtOutputDir+"]");

	String odtOutputDirWithRevision = odtOutputDir.replace("file:","")
	    + File.separator 
	    + svnInfo.getRootRevision()
	    + File.separator
	    + artifactName;

	String outputFileNamePath 
	    = odtFilePath.replace(wordOutputDir, odtOutputDirWithRevision);
	File outputDirectory
	    = new File(outputFileNamePath.replace(".odt", ""));

	try {
	    ZipFile zipFile = new ZipFile(odtFile);
	    outputDirectory.mkdirs();

	    Enumeration entries = zipFile.entries();
	    
	    while(entries.hasMoreElements()) {
		ZipEntry entry = (ZipEntry)entries.nextElement();
		
		if(entry.isDirectory()) {
		    // Assume directories are stored parents first then children.
		    getLog().info("Extracting directory: " + entry.getName());
		    (new File(outputDirectory, entry.getName())).mkdirs();
		    continue;
		}
		
		getLog().info("Extracting file: " + entry.getName());
		File outputFile = new File(outputDirectory, entry.getName());
		outputFile.getParentFile().mkdirs();
		outputFile.createNewFile();
		FileOutputStream fos  = new FileOutputStream(outputFile);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		copyInputStream(zipFile.getInputStream(entry), bos);
		bos.close();
	    }
	    
	    zipFile.close();

	    File outputFile = new File(outputDirectory, "svn-meta-data.xml");
	    outputFile.createNewFile();
	    FileOutputStream fos = new FileOutputStream(outputFile);
	    PrintStream bos = new PrintStream(fos);
	    bos.print(svnInfo.getSVNxml());
	    bos.close();

	} catch (IOException ioe) {
	    getLog().warn("Unhandled exception:",ioe);
	}
    }


    /**
     * 
     */
    public void convertWordFile(File wordFile) {
	String wordFilePath = wordFile.getPath();
	getLog().info("Converting word file: ["+wordFilePath+"]");

	String outputFileNamePath 
	    = wordFilePath.replace(wordInputDir, wordOutputDir);

	String outputFileNamePDF 
	    = outputFileNamePath.replace(".doc", ".pdf");
	File outputFilePDF = new File(outputFileNamePDF);

	String outputFileNameODT 
	    = outputFileNamePath.replace(".doc", ".odt");
	File outputFileODT = new File(outputFileNameODT);

	if (outputFilePDF.exists() && outputFileODT.exists()) {
	    getLog().info("Both PDF and ODT files already exist... skipping OpenOffice step");
	} else 	try {
	    // connect to an OpenOffice.org instance running on port 8100
	    //	    Process openOfficeProcess 
	    //		= Runtime.getRuntime().exec(openOfficeCommand);
	    //	    getLog().info("Created openOffice process: "
	    //			  + openOfficeProcess.toString());
	    Thread.sleep(openOfficePause);
	    OpenOfficeConnection connection
		= new SocketOpenOfficeConnection(openOfficePort);
	    connection.connect();
	    
	    DocumentConverter converter
		= new OpenOfficeDocumentConverter(connection);

	    getLog().info("Converting to PDF: ["+outputFilePDF+"]");

	    // convert - 
	    // input and output formats are guessed from file extensions
	    converter.convert(wordFile, outputFilePDF);
	    
	    getLog().info("Converting to OpenDocument: ["+outputFileODT+"]");
	    
	    // convert - 
	    // input and output formats are guessed from file extensions
	    converter.convert(wordFile, outputFileODT);

	    // close the connection
	    connection.disconnect();
	    Thread.sleep(1000);
	    //	    getLog().info("Killing openOffice process: "
	    //			  + openOfficeProcess.toString());
	    //	    openOfficeProcess.destroy();
	    Thread.sleep(1000);
	} catch (Exception e) {
	    getLog().info("Could not connect to the OpenOffice server NOT CONVERTING DOCUMENTS", e);
	}

	unpackODTfile(outputFileODT, new SVNInfoForFile(wordFile));
	
	getLog().debug("Converted word file: ["+wordFile+"]");
    }
    
    // find all files with a word files
    public void findAllWordFiles(File dir) {
	if (dir.isDirectory()) {
	    // ignore .svn directories
	    if (!dir.toString().contains(".svn")) {
		String[] children = dir.list();
		for (int i=0; i<children.length; i++) {
		    findAllWordFiles(new File(dir, children[i]));
		}
	    }
	} else {
	    String filePath = dir.toString();
	    getLog().debug("Looking at: ["+filePath+"]");
	    if (includesPattern == null
		|| includesPattern.matcher(filePath).find()) {
		getLog().debug("Found at: ["+filePath+"]");
		if (excludesPattern == null
		    || !excludesPattern.matcher(filePath).find()) {
		    getLog().debug("Found Word file: ["+filePath+"]");
		    convertWordFile(dir);
		}
	    }
	}
    }

    /**
     * Generates the ZIP file.
     *
     * @todo Add license files in META-INF directory.
     */
    public void execute()
        throws MojoExecutionException {

	if (wordIncludesRegexp.equalsIgnoreCase("include-everything")) {
	    includesPattern = null;
	} else {
	    includesPattern = Pattern.compile(wordIncludesRegexp);
	}

	if (wordExcludesRegexp.equalsIgnoreCase("exclude-nothing")) {
	    excludesPattern = null;
	} else {
	    excludesPattern = Pattern.compile(wordExcludesRegexp);
	}


	findAllWordFiles(new File(wordInputDir));
	    
    }
}
