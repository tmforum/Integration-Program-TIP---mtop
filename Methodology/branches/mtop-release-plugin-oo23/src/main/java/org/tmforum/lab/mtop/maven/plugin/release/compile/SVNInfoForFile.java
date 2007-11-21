package org.tmforum.lab.mtop.maven.plugin.release.compilephase;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Pattern;


public class SVNInfoForFile {

    private String fileName = "unknown";
    public String getFileName() {
	return fileName;
    }

    private String rootRevision = "unknown";
    public String getRootRevision() {
	return rootRevision;
    }

    private String fileRevision = "unknown";
    public String getFileRevision() {
	return fileRevision;
    }


    private String fileLastChanged = "unknown";
    public String getFileLastChanged() {
	return fileLastChanged;
    }

    private String fileLastAuthor = "unknown";
    public String getFileLastAuthor() {
	return fileLastAuthor;
    }

    public String getSVNxml() {
	StringBuffer sb = new StringBuffer();
	sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
	sb.append("<svn-meta-data>\n");
	sb.append("  <fileName>"+fileName+"</fileName>\n");
	sb.append("  <rootRevision>"+rootRevision+"</rootRevision>\n");
	sb.append("  <fileRevision>"+fileRevision+"</fileRevision>\n");
	sb.append("  <fileLastChanged>"+fileLastChanged+"</fileLastChanged>\n");
	sb.append("  <fileLastAuthor>"+fileLastAuthor+"</fileLastAuthor>\n");
	sb.append("</svn-meta-data>\n");
	return sb.toString();
    }

    SVNInfoForFile(File aFile) {
	fileName = aFile.getName();
	File entriesFile = new File( aFile.getParentFile(), ".svn/entries");	
	try {
	    BufferedReader reader 
		= new BufferedReader( new FileReader( entriesFile ) );
	    String line = null;
	    while (( line = reader.readLine()) != null){
		if (line.contains("dir")) {
		    line = reader.readLine();
		    if (line != null) {
			rootRevision = line.trim();
		    }
		}
	    if (line.contains(fileName)) {
		for (int i = 0; i < 8; i++) line = reader.readLine();
		if (line != null) {
		    fileLastChanged = line.trim();
		    line = reader.readLine();
		}
		if (line != null) {
		    fileRevision = line.trim();
		    line = reader.readLine();
		}
		if (line != null) {
		    fileLastAuthor = line.trim();
		    break;
		}
	    }
	    }
	    reader.close();
	} catch (IOException ex) {
	    // ignore
	}
    }
    
}