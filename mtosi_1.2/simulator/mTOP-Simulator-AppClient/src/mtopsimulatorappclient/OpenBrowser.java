package mtopsimulatorappclient;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class OpenBrowser{ 

    final String WIN_ID = "Win"; 

    OpenBrowser(java.io.File file)

    { 
	if(isWindowsPlatform() )
	    { try{ Runtime.getRuntime().exec(tryCommand1()+file); }
		catch(Exception exc1) { 
		    try{ Runtime.getRuntime().exec(tryCommand2()+file); }
		    catch(Exception exc2) { 
			try{ Runtime.getRuntime().exec(tryCommand3()+file); }
			catch(Exception exc3) { 
			    new OpenBrowserHelper(file);
			}
		    } 
		}
	    }
	else {
	    try{
		Runtime.getRuntime().exec(tryCommand3()+file);
	    }catch(Exception exc4) { 
		new OpenBrowserHelper(file); }
	}
    }
    
    private boolean isWindowsPlatform(){ 
	
	String os = System.getProperty("os.name"); 
	if ( os != null && os.startsWith(WIN_ID)) 
	    return true; 
	return false; } 
    
    private String tryCommand1(){ 
	return "C:\\Program Files\\Internet Explorer\\Iexplore.exe file://"; } 
    private String tryCommand2(){ 
	return "start rundll32 url.dll,FileProtocolHandler file://"; } 
    private String tryCommand3(){ 
	return "file://"; } 
}

