/*
 * FileChooser.java
 *
 * Created on 22 juin 2007, 16:04
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mtopsimulatorappclient;

/*
 * FileChooser.java
 *
 * Created on 22 juin 2007, 15:57
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */



/*******************************************************************************
 * * FileChooser class -> ok
 * *
 * * This class creates a FileChoser in a JPanel. This class returns file selection
 * * parameters.
 * *
 * * ***** Fields:
 * * - JButton openButton; -> button to open the selected file
 * * - JFileChooser fc; -> JFileChooser used to open files
 * * - String choosedFile; -> choosed file field
 * * - JTextField selectedDirectory;-> selected directory text field
 * *
 * * ***** Methods:
 * * + String getSelectedFile() -> return the selected file
 * * + void actionPerformed(ActionEvent e) -> event processing
 * *
 * * ***** Developper informations
 * * Developper : Onfroy Brice
 * * Date : 06/20/2006
 * * E-Mail : lambdacrash@gmail.com
 * *******************************************************************************/
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;

public class FileChooser extends JPanel implements ActionListener {
    /*******************************************************************************
     * Fields
     *******************************************************************************/
    private JButton openButton; // button to open the selected file
    private JFileChooser fc; // JFileChooser used to open files
    private String choosedFile; // choosed file field
    private JTextField selectedDirectory; // selected directory text field
    //private LangFileParser lang; // used to support multi language
    
    /*******************************************************************************
     * * Constructor with boolean border parameter
     *******************************************************************************/
    public FileChooser(boolean border) {
        // Set the JPanel layout manager
        setLayout(new BorderLayout());
        
        // Create a JPanel which contains buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        
        // Set the JPanel border if border==true
        if(border)
            buttonPanel.setBorder(BorderFactory.createTitledBorder("Ouvrir"));
        
        // Create the selected directory text field
        selectedDirectory = new JTextField(System.getProperty("user.home"), 35);
        
        // Create the file chooser open button
        openButton = new JButton("openButton");
        openButton.addActionListener(this);
        
        // Add elements into the buttonPanel
        buttonPanel.add(selectedDirectory);
        buttonPanel.add(openButton);
        
        // Add the buttonPanel into the parent JPanel
        add(buttonPanel, BorderLayout.NORTH);
    }
    
    /*******************************************************************************
     * Event processing
     * *******************************************************************************/
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openButton) {
            fc = new JFileChooser(selectedDirectory.getText());
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int returnVal = fc.showOpenDialog(FileChooser.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                choosedFile = fc.getSelectedFile().getPath();
                selectedDirectory.setText(choosedFile);
            }
        }
    }
    
    /*******************************************************************************
     * * Method
     * *******************************************************************************/
    // Retun the selected file
    public String getSelectedFile() {
        return choosedFile;
    }
}
