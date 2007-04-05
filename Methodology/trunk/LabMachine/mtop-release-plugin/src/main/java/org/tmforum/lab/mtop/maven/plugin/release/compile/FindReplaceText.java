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

import java.io.File;
import java.util.regex.Pattern;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Base class for creating a zip file from project classes.
 *
 * @author <a href="sgaito@tmforum.org">Stephen Gaito</a>
 * @version $Id $
 * @goal find-replace-text
 * @phase process-sources
 */
public class FindReplaceText
    extends AbstractMojo {

    /**
     * Input directory which recursively contains the text files
     * to be fixed (use absolute path if necessary)
     *
     * @parameter expression="${mtop-release.text-dir}"
     * @required
     */
    private String textDir;

    /**
     * Regular expression used to filter included text files
     *
     * @parameter expression="${mtop-release.include-regexp}" default-value="include-everything"
     * @required
     */
    private String includesRegexp;
    private Pattern includesPattern;

    /**
     * Regular expression used to filter excluded text files
     *
     * @parameter expression="${mtop-release.exclude-regexp}" default-value="exclude-nothing"
     * @required
     */
    private String excludesRegexp;
    private Pattern excludesPattern;

    /**
     * Regular expression used to find substrings to be replaced
     *
     * @parameter expression="${mtop-release.find-pattern-regexp}"
     * @required
     */
    private String findPatternRegexp;
    private Pattern findPattern;

    /**
     * Replacement string
     *
     * @parameter expression="${mtop-release.replacement-string}" default-value="replace-with-the-empty-string"
     * @required
     */
    private String replacementString;

    /**
     * 
     */
    public void fixHTMLfile(File htmlFile) {
	getLog().debug("Fixing references in: ["+htmlFile+"]");
	try {
	    File tempFile = File.createTempFile("fixWSDLdoc","html");
	    BufferedReader in = 
		new BufferedReader( new FileReader(htmlFile));
	    BufferedWriter out = 
		new BufferedWriter( new FileWriter(tempFile));
	    String str;
	    while(( str = in.readLine()) != null) {
		str = findPattern.matcher(str).replaceAll(replacementString);
		out.write(str+'\n');
	    }
	    in.close();
	    out.close();
	    htmlFile.delete();
	    tempFile.renameTo(htmlFile);
	    getLog().debug("Fixed references in: ["+htmlFile+"]");
	} catch (IOException e) {
	    // do nothing ;-)
	}
    }

    // find all files with a "html" extension
    public void findAllHTMLfiles(File dir) {
	if (dir.isDirectory()) {
	    // ignore .svn directories
	    if (!dir.toString().contains(".svn")) {
		String[] children = dir.list();
		for (int i=0; i<children.length; i++) {
		    findAllHTMLfiles(new File(dir, children[i]));
		}
	    }
	} else {
	    //add all the xsd and wsdl url here
	    String fileURI = dir.toURI().toString();
	    getLog().debug("Looking at: ["+fileURI+"]");
	    //	    getLog().debug("Using positive: ["+includesPattern.pattern()+"]");
	    if (includesPattern == null
		|| includesPattern.matcher(fileURI).find()) {
		getLog().debug("Found at: ["+fileURI+"]");
		//		getLog().debug("Using negative: ["+excludesPattern.pattern()+"]");
		if (excludesPattern == null
		    || !excludesPattern.matcher(fileURI).find()) {
		    getLog().debug("Fixing WSDL file: ["+fileURI+"]");
		    fixHTMLfile(dir);
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

	if (includesRegexp.equalsIgnoreCase("include-everything")) {
	    includesPattern = null;
	} else {
	    includesPattern = Pattern.compile(includesRegexp);
	}

	if (excludesRegexp.equalsIgnoreCase("exclude-nothing")) {
	    excludesPattern = null;
	} else {
	    excludesPattern = Pattern.compile(excludesRegexp);
	}

	findPattern = Pattern.compile(findPatternRegexp);

	if (replacementString.equalsIgnoreCase("replace-with-the-empty-string")) {
	    replacementString = "";
	}
	
	findAllHTMLfiles(new File(textDir));
    }
}
