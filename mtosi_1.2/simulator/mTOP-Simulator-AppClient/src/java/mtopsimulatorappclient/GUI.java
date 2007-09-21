/*
 * TableRowColumn2.java
 *
 * Created on 9 juin 2007, 18:42
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mtopsimulatorappclient;

import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import util.ColEditorModel;
import util.JTableX;
import util.OpenBrowser;
import ws.v1.tmf854.*;

/**
 *  The Graphic User Interface of the application client. This GUI enables the
 *  user to enter the requestedBatchSize and filter parameters of the getInventory
 *  operation.<br>
 *  If the requestedBatchSize is > 0 the following operations might be getInventoryIterator.
 *  In that case only the requestBatcSize parameter can be changed. <br>
 *  The result is diplayed in two way:
 *  <ul>
 *  <li> the xml response file of the operation </li>
 *  <li> a html table which display the managed entites returned </li>
 *  </ul>
 *
 */
public class GUI extends JFrame {
    
    // text fields
    private JTextField baseInstanceNameTextField = new JTextField(30);
    private JTextField includedObjectTypeNameTextField = new JTextField(30);
    private JTextField requestedBatchSizeTextField = new JTextField(5);
    private Long requestedBatchSize = new Long(0);
    // labels
    private JLabel requestedLabel = new JLabel();
    private JLabel exceptionLabel = new JLabel();
    private String requestS = new String();
    // tables
    private  DefaultTableModel model1, model2;
    private JTableX tableBaseInstances, tableIncludedObjectTypes;
    private ColEditorModel cm1 = new ColEditorModel();
    // buttons
    private JButton submitGetInvRequest = new JButton("Send GetInventory Request");
    private JButton submitGetInvItRequest = new JButton("Send GetInventoryIterator");
    //private JButton viewResponseFile = new JButton("View Response File");
    //private JButton viewResponseTable = new JButton("View Response Table");
    private JButton viewResponse = new JButton("View Response");
    
    private JButton refreshButton = new JButton("Refresh");
    // panels
    private JPanel parametersPanel;
    private JPanel mainPanel = new JPanel(new BorderLayout());
    JPanel buttonPanel = new JPanel();
    JPanel exceptionPanel = new JPanel();
    // column header and predefined values
    private String[] baseInstanceType1 = { "", "MD" };
    private String[] baseInstanceType2 = { "", "ME", "MLSN", "TL" };
    private String[] baseInstanceType3 = { "", "EH", "PTP", "FTP", "PGP","EPGP", "SNC", "TPPool" };
    private String[] baseInstanceType4 = { "", "EQ", "CTP" };
    private String[] includedObjectTypesType1 = { "", "MD", "ME", "MLSN", "TL", "EH", "PTP", "FTP", "PGP", "EPGP", "SNC", "TPPool", "EQ", "CTP" };
    private String[] includedObjectTypesType2 = { "", "NAME", "ATTRS", "FULL" };
    private String[] baseInstancesColumnNames = { "Type 1", "Value 1", "Type 2", "Value 2", "Type 3", "Value 3", "Type 4", "Value 4" };
    private String[] includedObjectTypesColumnNames = { "ObjectAcronym", "Granularity" };
    // boolean
    private boolean getInventoryRequest = true;
    private boolean exception = false;
    int nbrequests = 0;
    // maps
    private static Map baseInstancesMap = new HashMap();
    private static Map includedObjectTypesMap = new HashMap();
    private ApplicationClient client = new ApplicationClient();
    
    
    public GUI() {
        super("mTOP-Simulator Application Client");
           viewResponse.addActionListener(new OpenFile());

        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setIcon(new ImageIcon("mtosi.jpg"));
        
        JPanel globalPanel = new JPanel(new BorderLayout());
        globalPanel.add(imageLabel, BorderLayout.NORTH);
        
        // inititalize the main Panel
        mainPanel.add(init(), BorderLayout.NORTH);
        mainPanel.add(makePanelSubmitRequest(), BorderLayout.SOUTH);
        exceptionPanel = new JPanel();
        mainPanel.add(exceptionPanel, BorderLayout.CENTER);
        mainPanel.setBorder(BorderFactory.createTitledBorder(" "));
        
        globalPanel.add(mainPanel, BorderLayout.CENTER);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(globalPanel, BorderLayout.CENTER);
        setSize(100, 100);
        
        pack();
    }
    
    private JPanel init() {
        JPanel panelBI  = makePanelBaseInstances();
        JPanel panelIOT = makePanelIncludedObjectTypes();
        includedObjectTypeNameTextField.setEnabled(false);
        baseInstanceNameTextField.setEditable(false);
        requestedBatchSizeTextField.setText("0");
        
        // Button Send
        submitGetInvRequest.addActionListener(new SubmitRequest());
        submitGetInvItRequest.addActionListener(new SubmitRequest());
        
        // RequestedBatchSize Panel
        JPanel panelHeader = new JPanel(new BorderLayout());
        panelHeader.add(makePanelSpecifyBatchSize(), BorderLayout.WEST);
        
        // Body Filter Panel + Buttons add and remove filter parameters
        JPanel panelBody = new JPanel(new BorderLayout());
        panelBody.add(panelBI, BorderLayout.NORTH);
        panelBody.add(panelIOT, BorderLayout.WEST);
        
        // Panel which contains panelHeader, panelBody and buttons add/remove
        JPanel panelFilter = new JPanel(new BorderLayout());
        panelFilter.add(panelHeader, BorderLayout.NORTH);
        panelFilter.add(panelBody, BorderLayout.CENTER);
        panelBody.add(makePanelButtonsAddRemove(), BorderLayout.SOUTH);
        
        // Panel which contains panelFilter buttons Submit Requests and View Results
        JPanel returnedPanel = new JPanel(new BorderLayout());
        returnedPanel.add(panelFilter, BorderLayout.NORTH);
        //returnedPanel.add(makePanelSubmitRequest(), BorderLayout.CENTER);
        
        return returnedPanel;
    }
    
    // ------------------------- PANELS CREATION -------------------------------
    
    /**
     * The panel which contains the BaseInstance JTable
     */
    private JPanel makePanelBaseInstances() {
        JPanel baseInstancesPanel = new JPanel();
        baseInstancesPanel.setLayout(new BorderLayout());
        
        // Base Instance JTable Panel
        model1 = new DefaultTableModel(baseInstancesColumnNames, 1);
        tableBaseInstances = new JTableX(model1);
        
        //ColEditorModel cm1 = new ColEditorModel();
        tableBaseInstances.setColEditorModel(cm1);
        // type 1
        JComboBox cb = new JComboBox(baseInstanceType1);
        DefaultCellEditor ed = new DefaultCellEditor(cb);
        cm1.addEditorForRow(0, ed);
        // type 2
        cb = new JComboBox(baseInstanceType2);
        ed = new DefaultCellEditor(cb);
        cm1.addEditorForRow(2, ed);
        // type 3
        cb = new JComboBox(baseInstanceType3);
        ed = new DefaultCellEditor(cb);
        cm1.addEditorForRow(4, ed);
        // type 4
        cb = new JComboBox(baseInstanceType4);
        ed = new DefaultCellEditor(cb);
        cm1.addEditorForRow(6, ed);
        tableBaseInstances.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
        tableBaseInstances.setPreferredScrollableViewportSize(new Dimension(50, 150));
        JScrollPane scrollPane = new JScrollPane( tableBaseInstances );
        baseInstancesPanel.add(scrollPane, BorderLayout.CENTER);
        
        // Base Instance buttons Panel
        JPanel buttonBaseInstancePanel = new JPanel();
        baseInstancesPanel.add(buttonBaseInstancePanel, BorderLayout.SOUTH );
        
        return baseInstancesPanel;
    }
    
    /**
     * The panel which contains the IncludedObjectType JTable
     */
    private JPanel makePanelIncludedObjectTypes() {
        JPanel includedObjectTypesPanel = new JPanel();
        includedObjectTypesPanel.setLayout(new BorderLayout());
        
        // Base Instance JTable Panel
        model2 = new DefaultTableModel(includedObjectTypesColumnNames, 1);
        tableIncludedObjectTypes = new JTableX(model2);
        tableIncludedObjectTypes.setPreferredScrollableViewportSize(
                new Dimension(250, 150));
        ColEditorModel cm2 = new ColEditorModel();
        tableIncludedObjectTypes.setColEditorModel(cm2);
        
        // ObjectAcronym column
        JComboBox cb = new JComboBox(includedObjectTypesType1);
        DefaultCellEditor ed = new DefaultCellEditor(cb);
        cm2.addEditorForRow(0, ed);
        
        // IncludedObjectType column
        cb = new JComboBox(includedObjectTypesType2);
        ed = new DefaultCellEditor(cb);
        cm2.addEditorForRow(1, ed);
        JScrollPane scrollPane = new JScrollPane(tableIncludedObjectTypes);
        includedObjectTypesPanel.add(scrollPane, BorderLayout.CENTER);
        
        // Base Instance buttons Panel
        JPanel buttonIncludedObjectTypePanel = new JPanel();
        includedObjectTypesPanel.add(buttonIncludedObjectTypePanel, BorderLayout.SOUTH );
        
//        tableIncludedObjectTypes.getInputMap().put(
//                KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
//                "goToNewRow");
//        tableIncludedObjectTypes.getActionMap().put(
//                "goToNewRow",
//                new GoToNewRowAction());
        
        return includedObjectTypesPanel;
    }
    
    /**
     * The panel which contains the submit Request button
     */
    private JPanel makePanelSubmitRequest() {
        buttonPanel.add(submitGetInvRequest);
        
        return buttonPanel;
    }
    
    /**
     * The panel which displays the exception message
     */
    private JPanel makePanelException() {
        JPanel exceptionPanel = new JPanel();
        exceptionPanel.setBorder(BorderFactory.createTitledBorder("ExceptionPanel"));
        exceptionPanel.add(exceptionLabel);
        
        return exceptionPanel;
    }
    
    /**
     * The panel which contains the requestedBatchSize parameter
     */
    private JPanel makePanelSpecifyBatchSize() {
        JPanel requestedBatchSizePanel = new JPanel();
        //requestedBatchSizePanel.setBorder(BorderFactory.createTitledBorder("requestedBatchSizePanel"));
        JLabel requestedBatchSizeLabel = new JLabel("Specify requestedBatchSize for next request: ");
        requestedBatchSizeLabel.setHorizontalTextPosition(SwingConstants.LEFT);
        requestedBatchSizePanel.add(requestedBatchSizeLabel);
        requestedBatchSizeTextField.setHorizontalAlignment(SwingConstants.LEFT);
        requestedBatchSizePanel.add(requestedBatchSizeTextField);
        
        return requestedBatchSizePanel;
    }
    
    /**
     * The panel which contains the add/remove buttons
     */
    private JPanel makePanelButtonsAddRemove() {
        JPanel buttonsAddRemovePanel = new JPanel(new GridLayout(1 ,1));
        buttonsAddRemovePanel.setBorder(BorderFactory.createTitledBorder(" "));//buttonsAddRemovePanel"));
        buttonsAddRemovePanel.setPreferredSize(new Dimension(100,50));
        GridLayout gaps = new GridLayout(1, 1);
        buttonsAddRemovePanel.setLayout(gaps);
        gaps.setHgap(5);
        gaps.setVgap(5);
        
        // AddBaseInstance button
        JButton buttonAddBaseInstance = new JButton("Add a BaseInstance");
        buttonAddBaseInstance.addActionListener(new AddBaseInstance());
        buttonAddBaseInstance.setMaximumSize(new Dimension(10,5));
        // RemoveBaseInstance Button
        JButton buttonRemoveBaseInstance = new JButton("Remove selected BaseInstance");
        buttonRemoveBaseInstance.addActionListener(new RemoveBaseInstance());
        // AddIncludedObjectype button
        JButton buttonAddIncludedObjectType = new JButton("Add IncludedObjectType");
        buttonAddIncludedObjectType.addActionListener(new AddIncludedObjectType());
        // RemoveIncludedObjectype button
        JButton buttonRemoveIncludedObjectType = new JButton("Remove selected IncludedObjectType");
        buttonRemoveIncludedObjectType.addActionListener(new RemoveIncludedObjectType());
        
        buttonsAddRemovePanel.add(buttonAddBaseInstance);
        buttonsAddRemovePanel.add(buttonRemoveBaseInstance);
        buttonsAddRemovePanel.add(buttonAddIncludedObjectType);
        buttonsAddRemovePanel.add(buttonRemoveIncludedObjectType);
        
        return buttonsAddRemovePanel;
    }
    
    // ----------------------------- ACTIONS ----------------------------------
    
    /**
     * Action which opens the File Browser
     */
    private class OpenFile implements ActionListener {
        
        public void actionPerformed( ActionEvent event ) {
            File aFile = getFile("response");
            if ( aFile != null ) {
                new OpenBrowser(aFile);
            }
        }
    }
    
    /**
     * Action which adds a new row to the BaseInstance JTable
     */
    private class AddBaseInstance implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            model1.addRow(addBaseInstance());
            tableBaseInstances.changeSelection(tableBaseInstances.getRowCount() - 1, 0, false, false);
            tableBaseInstances.requestFocusInWindow();
            
            int row = tableBaseInstances.getRowCount();
            if ((model1.getValueAt(tableBaseInstances.getRowCount() -1, 0) != null) &&
                    (model1.getValueAt(tableBaseInstances.getRowCount() -1, 0).toString() != ""))
                model1.addRow(addBaseInstance());
        }
    }
    
    /**
     * Action which adds a new row to the IncludedObjectType JTable
     */
    private class AddIncludedObjectType implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            model2.addRow(addIncludedObjectType());
            tableIncludedObjectTypes.changeSelection(tableIncludedObjectTypes.getRowCount() - 1, 0, false, false);
            tableIncludedObjectTypes.requestFocusInWindow();
        }
    }
    
    /**
     * Action which removes a row to the BaseInstance JTable
     */
    private class RemoveBaseInstance implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            int row = tableBaseInstances.getSelectedRow();
            int nbRows = tableBaseInstances.getRowCount();
            if (nbRows > 1) {
                model1.removeRow(row);
                row = tableBaseInstances.getRowCount() - 1;
                tableBaseInstances.changeSelection(row, 0, false, false);
                tableBaseInstances.requestFocusInWindow();
            }
        }
    }
    
    /**
     * Action which removes a row to the IncludedObjectType JTable
     */
    private class RemoveIncludedObjectType implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            int row =  tableIncludedObjectTypes.getSelectedRow();
            int nbRows = tableIncludedObjectTypes.getRowCount();
            if (nbRows > 1) {
                model2.removeRow(row);
                row = tableIncludedObjectTypes.getRowCount() - 1;
                tableIncludedObjectTypes.changeSelection(row, 0, false, false);
                tableIncludedObjectTypes.requestFocusInWindow();
            }
        }
    }
    
    /*
     * Action which call the application client to submit the getInventory and
     * getInventoryIterato operations
     */
    private class SubmitRequest implements ActionListener {
        int nbIteratorRequest = 0;
        
        public void actionPerformed(ActionEvent e) {
            refreshButton.addActionListener(new RefreshMainPanel());
            requestedBatchSize = new Long(requestedBatchSizeTextField.getText());
            
            // intialize BaseInstance and IncludedObjecType maps
            initializeMaps();
            try {
                if (getInventoryRequest) {
                    // *************** SEND GETINVENTORY REQUEST *************//
                    System.out.println("SENDING GETINVENTORY REQUEST... ");
                    client.sendGetInventory(baseInstancesMap, tableBaseInstances.getRowCount(),
                            includedObjectTypesMap,tableIncludedObjectTypes.getRowCount(),
                            requestedBatchSize);

                } else {

                    // *********** SEND GETINVENTORYITERATOR REQUEST *********//
                    System.out.println("SENDING GETINVENTORYITERATOR REQUEST...");
                    client.sendGetInventoryIterator(requestedBatchSize);
                    nbIteratorRequest++;
                    
                }
            } catch (ProcessingFailureException ex) {
                exceptionLabel.setForeground(Color.RED);
                exceptionLabel.setText(ex.getFaultInfo().getReason());
                System.out.println(ex.getFaultInfo().getReason());
                exception = true;
                exceptionPanel.removeAll();
                exceptionPanel.add(exceptionLabel);
                
                if (!getInventoryRequest)
                    client.setLastRequest(true);
            }
            
            if (client.isLastRequest()) {
                 nbIteratorRequest = 0;
                // Display last request message
                exceptionLabel.setForeground(Color.BLUE);
                exceptionLabel.setText("All managed entities were retrieved. GetInventoryIterator is finished.");

                if (getInventoryRequest)
                   exceptionLabel.setText("All managed entities were retrieved in first batch.");

                exceptionPanel.removeAll();
                exceptionPanel.add(exceptionLabel);

                viewResponse.setEnabled(true);
                buttonPanel.add(viewResponse);
                submitGetInvRequest.setText("Send GetInventory Request");
                buttonPanel.add(submitGetInvRequest);
                getInventoryRequest = true;
                tableBaseInstances.setEnabled(true);
                tableIncludedObjectTypes.setEnabled(true);
                client.setLastRequest(false);
            } else if (!exception) {
                // Display the buttons: Send Request, View File and View Table
                buttonPanel.removeAll();
                //exceptionPanel.removeAll();
                exceptionLabel.setForeground(Color.BLUE);
                exceptionLabel.setText("GetInventoryIterator n: " + nbIteratorRequest);
                exceptionPanel.removeAll();
                if (!getInventoryRequest && !(client.isLastRequest()))
                    exceptionPanel.add(exceptionLabel);
                viewResponse.setEnabled(true);
                buttonPanel.add(viewResponse);
                buttonPanel.add(submitGetInvRequest);
                System.out.println("requestedBatchSize: " + requestedBatchSize.intValue());
                if (requestedBatchSize.intValue() > 0) {
                    tableBaseInstances.setEnabled(false);
                    tableIncludedObjectTypes.setEnabled(false);
                    submitGetInvRequest.setText("Send GetInventoryIterator Request");
                    getInventoryRequest = false;
                }

            }

            exception = false;
            mainPanel.repaint();
            mainPanel.revalidate();
            System.out.println("********END OF REQUEST ********\n");
        }
    }

    /*
     * Action which refresh the GUI when a request is finished
     */
    private class RefreshMainPanel implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            mainPanel.removeAll();
            mainPanel.add(init(), BorderLayout.NORTH);
            buttonPanel.removeAll();
            submitGetInvRequest.setText("Send GetInventory");
            
            mainPanel.add(makePanelSubmitRequest(), BorderLayout.CENTER);
            mainPanel.repaint();
            mainPanel.revalidate();
        }
    }
    
    // -------------------------- UTIL FUNCTIONS -------------------------------
    
    private Object[] addBaseInstance() {
        Object[] newRow1 = new Object[3];
        int row1 = tableBaseInstances.getRowCount() + 1;
        
        return newRow1;
    }
    
    private Object[] addIncludedObjectType() {
        Object[] newRow2 = new Object[2];
        int row2 = tableIncludedObjectTypes.getRowCount() + 1;
        
        return newRow2;
    }
    
    public File getFile(String fileName) {
        JFileChooser fc = new JFileChooser(fileName);
        fc.setFileSelectionMode(
                JFileChooser.FILES_ONLY );
        int resultat = fc.showOpenDialog( this );
        
        if ( resultat == JFileChooser.CANCEL_OPTION )
            return null;
        
        else
            return fc.getSelectedFile();
    }
    
    public boolean empty(String s) {
        return (s == null|| s.equals(""));
    }
    
    public void freezeTables() {
        tableBaseInstances.setEnabled(false);
        tableIncludedObjectTypes.setEnabled(false);
    }
    
    public String getRequestedBatchSize() {
        return requestedBatchSizeTextField.getText();
    }
    
    /* Initialize BaseInstance and IncludedObjectType maps from the values entered
     * in the two JTables.
     */
    public void initializeMaps() {
        boolean biAlreadyPresent = false;
        boolean objectAcronymAlreadyPresent = false;
        
        // baseInstances
        for (int i = 0; i < tableBaseInstances.getRowCount(); i++) {
            
            for (int j = 0; j < i; j++) {
                if (i >= 1) {
                    if  ( (baseInstancesMap.containsValue(model1.getValueAt(i, 1)) && model1.getValueAt(i, 1)!= null) &&
                            (baseInstancesMap.containsValue(model1.getValueAt(i, 3)) && model1.getValueAt(i, 3)!= null) &&
                            (baseInstancesMap.containsValue(model1.getValueAt(i, 2)) && model1.getValueAt(i, 2)!= null) &&
                            (baseInstancesMap.containsValue(model1.getValueAt(i, 5)) && model1.getValueAt(i, 5)!= null) &&
                            (baseInstancesMap.containsValue(model1.getValueAt(i, 7)) && model1.getValueAt(i, 7)!= null) ) {
                        // same bi already exists: skip it
                        biAlreadyPresent = true;
                        
                        break;
                    }
                }
            }
            if (!biAlreadyPresent) {
                baseInstancesMap.put("baseInstanceType"+i+"1", model1.getValueAt(i, 0));
                baseInstancesMap.put("baseInstanceValue"+i+"1", model1.getValueAt(i, 1));
                baseInstancesMap.put("baseInstanceType"+i+"2", model1.getValueAt(i, 2));
                baseInstancesMap.put("baseInstanceValue"+i+"2", model1.getValueAt(i, 3));
                baseInstancesMap.put("baseInstanceType"+i+"3", model1.getValueAt(i, 4));
                baseInstancesMap.put("baseInstanceValue"+i+"3", model1.getValueAt(i, 5));
                baseInstancesMap.put("baseInstanceType"+i+"4", model1.getValueAt(i, 6));
                baseInstancesMap.put("baseInstanceValue"+i+"4", model1.getValueAt(i, 7));
            }
        }
        
        // includedObjectTypes
        for (int i = 0; i < tableIncludedObjectTypes.getRowCount(); i++) {
            includedObjectTypesMap.put("objectAcronym"+i, model2.getValueAt(i, 0));
            includedObjectTypesMap.put("granularity"+i, model2.getValueAt(i, 1));
        }
    }
    
    public static void main(String[] args) {
        GUI frame = new GUI();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setSize(900,700);
        frame.setVisible(true);
    }
}