package util;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
 

// The class opens a simple helper window displying the 
// file:// URL of the local file if the browser does not open with
// the OpenBrowser.class<br>
class OpenBrowserHelper extends JDialog{

   protected OpenBrowserHelper(java.io.File file){

      setTitle(" Open browser help:");
      setDefaultCloseOperation( DISPOSE_ON_CLOSE );

      final JCheckBox box = new JCheckBox("Do not show this message again");

      addWindowListener(new WindowAdapter(){
         public void windowClosing(WindowEvent we){
            dispose();
            //if(box.isSelected() ) 
		//setOpenBrowserHelper(false);
	 }
	 
	 public void windowDeactivated(WindowEvent we){
	     toFront();
	 }
      }); 

      getContentPane().add(new JLabel("<html><center>"+
          "  html_Editor failed to detect your browser.  <br><br>"+
          "  You will have to open this browser manually.  <br>"+ 
          "  You can copy the file name below and paste  <br>"+
          "  this into the browser window address bar.<br></center></html>"), BorderLayout.NORTH);
      getContentPane().add(new JTextField(file.toString() ), BorderLayout.CENTER);
      getContentPane().add(box, BorderLayout.SOUTH); 
      pack();
      Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
      setLocation( (dim.width/2)-(getWidth()/2), (dim.height/2)-(getHeight()/2) );
      setVisible(true);     
   }
}

