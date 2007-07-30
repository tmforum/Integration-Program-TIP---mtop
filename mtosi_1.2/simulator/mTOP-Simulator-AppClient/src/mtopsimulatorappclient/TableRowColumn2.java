/*
 * TableRowColumn2.java
 *
 * Created on 9 juin 2007, 18:42
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mtopsimulatorappclient;

//import com.sun.tools.ws.processor.model.java.JavaArrayType;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import ws.v1.tmf854.*;

public class TableRowColumn2 extends JFrame {
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
    private JButton viewResponseFile = new JButton("View Response File");
    private JButton viewResponseTable = new JButton("View Response Table");
    private JButton refreshButton = new JButton("Refresh");
    // panels
    private JPanel parametersPanel;
    private JPanel mainPanel = new JPanel(new BorderLayout());
    JPanel buttonPanel = new JPanel();
    
    // column header and predefined values
    private String[] baseInstanceType1 = { "", "MD" };
    private String[] baseInstanceType2 = { "", "MLSN", "ME" };
    private String[] baseInstanceType3 = { "", "EH", "PTP", "FTP", "PGP", "SNC" };
    private String[] baseInstanceType4 = { "", "EQ", "CTP" };
    private String[] includedObjectTypesType1 = { "", "MD", "ME", "MLSN", "EH", "EQ", "PTP", "FTP", "PGP", "EPGP", "SNC", "EQ", "CTP", "TPPool" };
    private String[] includedObjectTypesType2 = { "", "NAME", "ATTRS", "FULL" };
    private String[] baseInstancesColumnNames = { "Type 1", "Value 1", "Type 2", "Value 2", "Type 3", "Value 3", "Type 4", "Value 4" };
    private String[] includedObjectTypesColumnNames = { "ObjectAcronym", "Granularity" };
    //private boolean iterator = false;
    private boolean getInventoryRequest = true;
    private boolean exception = false;
    // private JFileChooser fc = new JFileChooser("C:\\DONNEES\\WORK\\MTOSI-2\\baptiste\\lundi-18-06\\mTOP-Simulator-AppClient");
    private JEditorPane viewer = new JEditorPane();
    int nbrequests = 0;
    // maps
    private static Map baseInstancesMap = new HashMap();
    private static Map includedObjectTypesMap = new HashMap();
    private Client client = new Client();
    
    public TableRowColumn2() {
        super("mTOP-Simulator Application Client");
        viewResponseTable.addActionListener(new OpenFile());
        viewResponseFile.addActionListener(new OpenFile());
        
        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setIcon(new ImageIcon("image2.png"));
        
        
        JPanel globalPanel = new JPanel(new BorderLayout());
        globalPanel.add(imageLabel, BorderLayout.NORTH);
        
        mainPanel.add(init(), BorderLayout.NORTH);
        mainPanel.setBorder(BorderFactory.createTitledBorder(" "));
        
        globalPanel.add(mainPanel, BorderLayout.CENTER);
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(globalPanel, BorderLayout.CENTER);
        setSize(100, 100);
        //setVisible(true);
        pack();
    }
    
    private JPanel init() {
        JPanel panelBI  = makePanelBaseInstances();
        JPanel panelIOT = makePanelIncludedObjectTypes();
        includedObjectTypeNameTextField.setEnabled(false);
        baseInstanceNameTextField.setEditable(false);
        requestedBatchSizeTextField.setText("0");
        
        // RequestedBatchSize Panel
        JPanel panelHeader = new JPanel(new BorderLayout());
        panelHeader.add(makePanelSpecifyBatchSize(), BorderLayout.WEST);
        
        // Body Filter Panel + Buttons add and remove filter parameters
        JPanel panelBody = new JPanel(new BorderLayout());
        panelBody.add(panelBI, BorderLayout.NORTH);
        panelBody.add(panelIOT, BorderLayout.WEST);
        panelBody.add(makePanelButtonsAddRemove(), BorderLayout.SOUTH);
        
        JPanel panelFilter = new JPanel(new BorderLayout());
        panelFilter.add(panelHeader, BorderLayout.NORTH);
        panelFilter.add(panelBody, BorderLayout.CENTER);
        
        JPanel returnedPanel = new JPanel(new BorderLayout());
        returnedPanel.add(panelFilter, BorderLayout.NORTH);
        returnedPanel.add(makePanelSubmitRequest(), BorderLayout.CENTER);
        
        return returnedPanel;
    }
    
    // **************************** Panels *************************************
    
    public JPanel makePanelBaseInstances() {
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
    
    public JPanel makePanelIncludedObjectTypes() {
        JPanel includedObjectTypesPanel = new JPanel();
        
        includedObjectTypesPanel.setLayout(new BorderLayout());
        
        // Base Instance JTable Panel
        model2 = new DefaultTableModel(includedObjectTypesColumnNames, 1);
        tableIncludedObjectTypes = new JTableX(model2);
        tableIncludedObjectTypes.setPreferredScrollableViewportSize(new Dimension(250, 150));
        
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
        
        tableIncludedObjectTypes.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "goToNewRow");
        tableIncludedObjectTypes.getActionMap().put("goToNewRow", new GoToNewRowAction());
        
        return includedObjectTypesPanel;
    }
    
    public JPanel makePanelSubmitRequest() {
        
        // buttonPanel.setBorder(BorderFactory.createTitledBorder("submitRequestPanel"));
        buttonPanel.add(submitGetInvRequest);
        submitGetInvRequest.addActionListener(new SubmitRequest());
        submitGetInvItRequest.addActionListener(new SubmitRequest());
        
        return buttonPanel;
    }
    
    public JPanel makePanelException() {
        JPanel exceptionPanel = new JPanel();
        exceptionPanel.setBorder(BorderFactory.createTitledBorder("ExceptionPanel"));
        exceptionPanel.add(exceptionLabel);
        
        return exceptionPanel;
    }
    
    public JPanel makePanelSpecifyBatchSize() {
        JPanel requestedBatchSizePanel = new JPanel();
        //requestedBatchSizePanel.setBorder(BorderFactory.createTitledBorder("requestedBatchSizePanel"));
        JLabel requestedBatchSizeLabel = new JLabel("Specify requestedBatchSize for next request: ");
        requestedBatchSizeLabel.setHorizontalTextPosition(SwingConstants.LEFT);
        requestedBatchSizePanel.add(requestedBatchSizeLabel);
        requestedBatchSizeTextField.setHorizontalAlignment(SwingConstants.LEFT);
        requestedBatchSizePanel.add(requestedBatchSizeTextField);
        
        return requestedBatchSizePanel;
    }
    
    public JPanel makePanelButtonsAddRemove() {
        JPanel buttonsAddRemovePanel = new JPanel(new GridLayout(1 ,1));
        buttonsAddRemovePanel.setBorder(BorderFactory.createTitledBorder(" "));//buttonsAddRemovePanel"));
        buttonsAddRemovePanel.setPreferredSize(new Dimension(100,50));
        GridLayout gaps = new GridLayout(1, 1);
        buttonsAddRemovePanel.setLayout(gaps);
        gaps.setHgap(5);
        gaps.setVgap(5);
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
    
    public JPanel makePanelWellPrintedRequest() {
        // Base Instance Name Panel
        JPanel panelInfos = new JPanel(new GridLayout(1,1));
        
        
        // first column
        JPanel colonne1 = new JPanel(new BorderLayout());
        // Panel of labels
        JPanel panelLabels1 = new JPanel();
        panelLabels1.setLayout(new GridLayout(2, 0));
        panelLabels1.add(new JLabel("Base Instance Request: "));
        panelLabels1.add(new JLabel("Included Object Type Request: "));
        colonne1.add(panelLabels1, BorderLayout.WEST);
        // Panel of text fields
        JPanel panelInfos1 = new JPanel();
        panelInfos1.setLayout(new GridLayout(2, 0));
        baseInstanceNameTextField.setEditable(false);
        includedObjectTypeNameTextField.setEditable(false);
        panelInfos1.add(baseInstanceNameTextField);
        panelInfos1.add(includedObjectTypeNameTextField);
        colonne1.add(panelInfos1, BorderLayout.CENTER);
        
        panelInfos.add(colonne1);
        
        //second column
    /*    JPanel buttonsAddRemovePanel = new JPanel(new GridLayout(2,1));
        buttonsAddRemovePanel.setBorder(BorderFactory.createTitledBorder("buttonsAddRemovePanel"));
        buttonsAddRemovePanel.setLayout(gaps);
        JButton buttonAddBaseInstance = new JButton("Add a BaseInstance");
        buttonAddBaseInstance.addActionListener(new AddBaseInstance());
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
     */
        
        // panelInfos.add(buttonsAddRemovePanel);
        //panelInfos.setPreferredSize(new Dimension(50, 300));
        
        return panelInfos;
        
    }
    
    // **************************** ACTIONS ************************************
    
    private  class GoToNewRowAction extends AbstractAction {
        public void actionPerformed( ActionEvent e ) {
            // if last row not empty new row
            model2.addRow(addIncludedObjectType());
            int row = tableIncludedObjectTypes.getRowCount() - 2;
            
            includedObjectTypesMap.put("objectAcronym"+row, model2.getValueAt(row, 0));
            includedObjectTypesMap.put("granularity"+row, model2.getValueAt(row, 1));
            tableIncludedObjectTypes.changeSelection(row, 0, false, false);
            tableIncludedObjectTypes.requestFocusInWindow();
        }
    }
    
    private class OpenFile implements ActionListener {
        public void actionPerformed( ActionEvent event ) {
            File aFile = getFile("getInventory-response.xml");
            if ( aFile != null ) {
                // Instancier un nouveau lecteur de clip avec fichierMedia.
                new OpenBrowser(aFile);
            }
        }
    }
    
    private class NewFrame extends JFrame {
        public NewFrame() {
            super("Response Table");
            setSize(800,600);
            getContentPane().setLayout(new BorderLayout());
            
        }
        
    }
    
    private class NewGetInventoy implements ActionListener {
        public void actionPerformed( ActionEvent e ) {
            try {
                //getContentPane().removeAll();
                TableRowColumn2 frame = new TableRowColumn2();
                //frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
                frame.pack();
                frame.setLocationRelativeTo( null );
                frame.setVisible(true);
            }catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private class Reset implements ActionListener {
        public void actionPerformed( ActionEvent e ) {
            try {
                getContentPane().remove(mainPanel);
                getContentPane().add(init());
                getContentPane().repaint();
            }catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private class AddBaseInstance implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int row = tableBaseInstances.getRowCount();
            
            if ((model1.getValueAt(tableBaseInstances.getRowCount() -1, 0) != null) &&
                    (model1.getValueAt(tableBaseInstances.getRowCount() -1, 0).toString() != ""))
                model1.addRow(addBaseInstance());
        }
    }
    
    private class AddIncludedObjectType implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model2.addRow(addIncludedObjectType());
            tableIncludedObjectTypes.changeSelection(tableIncludedObjectTypes.getRowCount() - 1, 0, false, false);
            tableIncludedObjectTypes.requestFocusInWindow();
        }
    }
    
    private class RemoveBaseInstance implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model1.removeRow(model1.getRowCount()-1);
            int row = tableBaseInstances.getRowCount() -1;
            tableBaseInstances.changeSelection(row, 0, false, false);
            tableBaseInstances.requestFocusInWindow();
        }
    }
    
    private class RemoveIncludedObjectType implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int row =  tableIncludedObjectTypes.getSelectedRow();
            model2.removeRow(row);
            row = tableIncludedObjectTypes.getRowCount() - 1;
            tableIncludedObjectTypes.changeSelection(row, 0, false, false);
            tableIncludedObjectTypes.requestFocusInWindow();
        }
    }
    
    private class SubmitRequest implements ActionListener {
        JPanel exceptionPanel = makePanelException();
        
        public void actionPerformed(ActionEvent e) {
            refreshButton.addActionListener(new RefreshMainPanel());
             requestedBatchSize = new Long(requestedBatchSizeTextField.getText());
            
// open the xml Response File
            
            // intialize BaseInstance and IncludedObjecType maps
            initializeMaps();
            try {
                if (getInventoryRequest) {
                    // *************** SEND GETINVENTORY REQUEST *************//
                    client.sendGetInventory(baseInstancesMap, tableBaseInstances.getRowCount(),
                            includedObjectTypesMap,tableIncludedObjectTypes.getRowCount(),
                            requestedBatchSize);
                } else {
                    
                    // *********** SEND GETINVENTORYITERATOR REQUEST *********//
                    System.out.println("// *********** SEND GETINVENTORYITERATOR REQUEST *********//");
                    client.sendGetInventoryIterator(requestedBatchSize);
                }
            } catch (ProcessingFailureException ex) {
                exceptionLabel.setForeground(Color.RED);
                exceptionLabel.setText(ex.getFaultInfo().getReason());
                System.out.println(ex.getFaultInfo().getReason());
                exception = true;
                buttonPanel.removeAll();
                buttonPanel.add(exceptionLabel);
                buttonPanel.add(submitGetInvRequest);
            }
            if (client.isLastRequest()) {
                System.out.println("*************client.isLastRequest()*************");
                // Display last request message
                JLabel endRequest =
                        new JLabel("GetInventoryIterator request is finished.");
                endRequest.setForeground(Color.BLUE);
                buttonPanel.add(endRequest);
                buttonPanel.add(refreshButton);
            } else if (!exception) {
                // Display the buttons: Send Request, View File and View Table
                buttonPanel.removeAll();
                viewResponseFile.setEnabled(true);
                buttonPanel.add(viewResponseFile);
                viewResponseTable.setEnabled(true);
                buttonPanel.add(viewResponseTable);
                buttonPanel.add(submitGetInvRequest);
                System.out.println("requestedBatchSize: " + requestedBatchSize.intValue());
                if (requestedBatchSize.intValue() > 0) {
                    freezeTables();
                    submitGetInvRequest.setText("Send GetInventoryIterator Request");
                    getInventoryRequest = false;
                }
            }
            
            exception = false;
            mainPanel.repaint();
            mainPanel.revalidate();
            System.out.println("********************END**********************");
        }
    }
    
    private class RefreshMainPanel implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            mainPanel.removeAll();
            //mainPanel.remove(buttonPanel);
            mainPanel.add(init(), BorderLayout.NORTH);
            buttonPanel.removeAll();
            mainPanel.add(makePanelSubmitRequest(), BorderLayout.CENTER);
            mainPanel.repaint();
            mainPanel.revalidate();
        }
    }
    
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
    
// **************************** Utils **************************************
    
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
        // baseInstances
        for (int i = 0; i < tableBaseInstances.getRowCount(); i++) {
            baseInstancesMap.put("baseInstanceType"+i+"1", model1.getValueAt(i, 0));
            baseInstancesMap.put("baseInstanceValue"+i+"1", model1.getValueAt(i, 1));
            baseInstancesMap.put("baseInstanceType"+i+"2", model1.getValueAt(i, 2));
            baseInstancesMap.put("baseInstanceValue"+i+"2", model1.getValueAt(i, 3));
            baseInstancesMap.put("baseInstanceType"+i+"3", model1.getValueAt(i, 4));
            baseInstancesMap.put("baseInstanceValue"+i+"3", model1.getValueAt(i, 5));
            baseInstancesMap.put("baseInstanceType"+i+"4", model1.getValueAt(i, 6));
            baseInstancesMap.put("baseInstanceValue"+i+"4", model1.getValueAt(i, 7));
        }
        // includedObjectTypes
        for (int i = 0; i < tableIncludedObjectTypes.getRowCount(); i++) {
            includedObjectTypesMap.put("objectAcronym"+i, model2.getValueAt(i, 0));
            includedObjectTypesMap.put("granularity"+i, model2.getValueAt(i, 1));
        }
    }
    
    public static void main(String[] args) {
        TableRowColumn2 frame = new TableRowColumn2();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setSize(900, 600);
        frame.setVisible(true);
    }
}