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
    private JButton submit = new JButton("Send GetInventory Request");
    private JButton getInventoryIteratorButton = new JButton("Send GetInventoryIterator");
    //private JButton viewResult = new JButton("View Response File");
    //private JButton viewResponseTable = new JButton("View Response Table");
    private JButton aa  = new JButton("aa");
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
        
        // Positionnement de la fenêtre (la taille n'est pas utilisée si pack())
        /*Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int hauteurEcran = d.height;
        int largeurEcran = d.width;
        setSize(largeurEcran/2, hauteurEcran/2);
        setLocation(largeurEcran/4, hauteurEcran/4);
         */
        
        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setIcon(new ImageIcon("image2.png"));
        
        JPanel mainPanel0 = new JPanel(new BorderLayout());
        mainPanel0.add(imageLabel, BorderLayout.NORTH);
        
        mainPanel.add(init(), BorderLayout.NORTH);
        mainPanel.add(makePanelSubmitRequest(), BorderLayout.CENTER);
        mainPanel.setBorder(BorderFactory.createTitledBorder(" "));
        
        mainPanel0.add(mainPanel, BorderLayout.CENTER);
        //JPanel mainPanel0 = new JPanel(new BorderLayout());
        //mainPanel0.setBorder(BorderFactory.createTitledBorder("panel0"));
        //mainPanel0.add(mainPanel, BorderLayout.NORTH);
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mainPanel0, BorderLayout.CENTER);
        setSize(300, 250);
        setVisible(true);
        pack();
    }
    
    private JPanel init() {
        JPanel pBI  = makePanelBaseInstances();
        JPanel pIOT = makePanelIncludedObjectTypes();
        includedObjectTypeNameTextField.setEnabled(false);
        baseInstanceNameTextField.setEditable(false);
        requestedBatchSizeTextField.setText("1");
        
        JPanel boxFilter00 = new JPanel(new BorderLayout());
        boxFilter00.add(makePanelSpecifyBatchSize(), BorderLayout.WEST);
        
        JPanel boxFilter0 = new JPanel(new BorderLayout());
        boxFilter0.add(boxFilter00, BorderLayout.NORTH);
        
        JPanel boxFilter = new JPanel(new BorderLayout());
        boxFilter.add(pBI, BorderLayout.NORTH);
        JPanel tmp = new JPanel(new BorderLayout());
        tmp.add(pIOT, BorderLayout.WEST);
        // tmp.add(makePanelWellPrintedRequest(), BorderLayout.CENTER);
        
        boxFilter.add(tmp, BorderLayout.WEST);
        boxFilter.add(makePanelWellPrintedRequest(), BorderLayout.EAST);
        boxFilter.add(makePanelButtonsAddRemove(), BorderLayout.SOUTH);
        
        boxFilter0.add(boxFilter, BorderLayout.CENTER);
        
       
        /*
        // header
        JPanel headerPanel = makePanelSpecifyBatchSize();
        parametersPanel = new JPanel();
        parametersPanel.setLayout(new BorderLayout());
        parametersPanel.setBorder(BorderFactory.createTitledBorder("parameters"));
        parametersPanel.add(bodyPanel, BorderLayout.NORTH);
         
        requestedLabel.setText("You requested : " + baseInstanceNameTextField.getText());
        main.setLayout(new BorderLayout());
        main.add(bodyPanel, BorderLayout.NORTH);
        main.add(headerPanel, BorderLayout.WEST);
        main.add(makePanelSubmitRequest(), BorderLayout.SOUTH);
         */
        JPanel main0 = new JPanel(new BorderLayout());
        main0.add(boxFilter0, BorderLayout.NORTH);
        //main0.add(makePanelSubmitRequest(), BorderLayout.CENTER);
        
        return main0;
    }
    
    // **************************** Panels *************************************
    
    public JPanel makePanelBaseInstances() {
        JPanel baseInstancesPanel = new JPanel();
        
        baseInstancesPanel.setLayout(new BorderLayout());
        
        // Base Instance JTable Panel
        model1 = new DefaultTableModel(baseInstancesColumnNames, 1);
        tableBaseInstances = new JTableX(model1);
        /*tableBaseInstances.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e) {
                int index = tableBaseInstances.getSelectedRow();
                System.out.println("indexxxxxxxxxxxxxxxxxxxxxx " + index);
                // when "enter key is pressed" ....
                // tableBaseInstances.changeSelection(row, col, false, false);
                e.consume();
            }
        });
         */
        // Double Click  toggle actions
       /*
        tableBaseInstances.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {*/
        
                                /*	DefaultCellEditor CellEditor = (DefaultCellEditor)jTable.getCellEditor();
                                        CellEditor.isCellEditable(false);*/
        /*
        int index = tableBaseInstances.getSelectedRow();
                System.out.println("indexxxxxxxxxxxxxxxxxxxxxx22 " + index);
                System.out.println("rowcell01: " +  model1.getValueAt(index, 1));
         
         
                String s =  "{ ( " + model1.getValueAt(index, 0) + "=" +  model1.getValueAt(index, 1) + ";";
         
                if (model1.getValueAt(index, 2) != null)
                    s +=  model1.getValueAt(index, 2) + "=" +  model1.getValueAt(index, 3) + ";";
         
         
                if (model1.getValueAt(index, 4) != null)
                    s +=  model1.getValueAt(index, 4) + "=" +  model1.getValueAt(index, 5) + ";";
                s += " ) }";
                System.out.println("ssssssssssss " + s);
                requestS = s;
                requestedLabel.setText(s);
                // makePanelDisplayResult().remove(requestedLabel);
                baseInstanceNameTextField.setText(requestS);
         
                //makePanelDisplayResult().add(requestedLabel);
                makePanelDisplayResult().revalidate();
                makePanelDisplayResult().repaint();
         
         
         
            }
        });*/
        
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
        // AddBaseInstance Button
        //  JButton buttonAddBaseInstance = new JButton("Add a BaseInstance");
        //  buttonBaseInstancePanel.add(buttonAddBaseInstance);
        //  buttonAddBaseInstance.addActionListener(new AddBaseInstance());
        // RemoveBaseInstance Button
        //   JButton buttonRemoveBaseInstance = new JButton("Remove a BaseInstance");
        //   buttonBaseInstancePanel.add(buttonRemoveBaseInstance);
        //   buttonRemoveBaseInstance.addActionListener(new RemoveBaseInstance());
        
        return baseInstancesPanel;
    }
    
    public JPanel makePanelIncludedObjectTypes() {
        JPanel includedObjectTypesPanel = new JPanel();
        //JPanel includedObjectTypeNamePanel0 = new JPanel();
        //JPanel includedObjectTypeNamePanel = new JPanel();
        
        includedObjectTypesPanel.setLayout(new BorderLayout());
        //  includedObjectTypesPanel.setBorder(BorderFactory.createTitledBorder("IncludedObjectTypesPanel"));
        
        // Base Instance Name Panel
        /*includedObjectTypeNamePanel0.setLayout(new BorderLayout());
        includedObjectTypeNamePanel.setLayout(new BorderLayout());
        includedObjectTypeNamePanel0.add(includedObjectTypeNamePanel, BorderLayout.WEST);
        includedObjectTypeNamePanel.add(new JLabel("IncludedObject Type Name"), BorderLayout.WEST);
        includedObjectTypeNamePanel.add(includedObjectTypeNameTextField, BorderLayout.CENTER);
        includedObjectTypesPanel.add(includedObjectTypeNamePanel0, BorderLayout.NORTH);
         */
        
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
        // AddIncludedObjectype button
        //JButton buttonAddIncludedObjectType = new JButton("Add IncludedObjectType");
        //buttonIncludedObjectTypePanel.add(buttonAddIncludedObjectType);
        //buttonAddIncludedObjectType.addActionListener(new AddIncludedObjectType());
        
        tableIncludedObjectTypes.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "goToNewRow");
        tableIncludedObjectTypes.getActionMap().put("goToNewRow", new GoToNewRowAction());
        
        // RemoveIncludedObjectype button
        //JButton buttonRemoveIncludedObjectType = new JButton("Remove selected IncludedObjectType");
        //buttonIncludedObjectTypePanel.add(buttonRemoveIncludedObjectType);
        //buttonRemoveIncludedObjectType.addActionListener(new RemoveIncludedObjectType());
        
        return includedObjectTypesPanel;
    }
    
    public JPanel makePanelSubmitRequest() {
        
        // buttonPanel.setBorder(BorderFactory.createTitledBorder("submitRequestPanel"));
        buttonPanel.add(submit);
        submit.addActionListener(new SubmitRequest());
        
        return buttonPanel;
    }
    
    public JPanel makePanelDisplayResult() {
        //  JPanel requestedPanel0 = new JPanel();
        
        JPanel requestedPanel = new JPanel();
        JButton viewResult0 = new JButton("View Result File");
        viewResult0.addActionListener(new ActionListener() {
            public void actionPerformed( ActionEvent event ) {
                File aFile = getFichier();
                if ( aFile != null ) {
                    // Instancier un nouveau lecteur de clip avec fichierMedia.
                    new OpenBrowser(aFile);
                }
            }
        });
        JButton viewResponseTable0 = new JButton("View Response Table");
        viewResponseTable0.addActionListener(new OpenTable());
        requestedPanel.add(viewResult0);
        requestedPanel.add(viewResponseTable0);
        
        return requestedPanel;
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
    
    // **************************** Actions ************************************
    
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
    /*
    private class OpenDialog implements ActionListener {
        public void actionPerformed( ActionEvent e ) {
            // if last row not empty new row
            if (e.getSource() == viewResult) {
                int returnVal = fc.showOpenDialog(TableRowColumn2.this);
     
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                }
            }
        }
    }*/
    
    private class OpenTable implements ActionListener {
        public void actionPerformed( ActionEvent e ) {
            try {
                String pathStyleSheet =  "styleSheet4.xsl";
                //String pathStyleSheet = "styleSheet3.xsl";
                String pathTable = "table.html";
                File s = new File(pathStyleSheet);
                File r = new File("getInventory-response.xml");
                File table = new File(pathTable);
                Stylizer stylizer = new Stylizer();
                stylizer.transform(s, r, table);
                
                FileReader reader = new FileReader(pathTable);//"C:\\DONNEES\\a.html");
                
                JEditorPane editor = new JEditorPane();
                editor.setContentType( "text/html" );
                editor.read(reader, null);
                editor.setEditable(false);
                JScrollPane scrollPane = new JScrollPane( editor );
                scrollPane.setPreferredSize( new Dimension(50, 600) );
                
                //getContentPane().add( scrollPane );
                NewFrame tableFrame = new NewFrame();
                tableFrame.add(scrollPane, BorderLayout.CENTER);
                tableFrame.setVisible(true);
            } catch(Exception ex) {
                ex.printStackTrace();
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
            
            //makePanelDisplayResult().remove(requestedLabel);
            // baseInstanceNameTextField.setText(requestS);
            
            //makePanelDisplayResult().add(requestedLabel);
            //makePanelDisplayResult().revalidate();
            //makePanelDisplayResult().repaint();
            
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
        JPanel displayResultPanel = makePanelDisplayResult();
        JButton newRequestButton = new JButton("Send another request");
        JButton getInventoryIteratorButton = new JButton("Send getInventoryIterator");
        JButton viewResult = new JButton("View Result File");
        JButton viewResponseTable = new JButton("View Response Table");
        
        
        public void actionPerformed(ActionEvent e) {
            getInventoryIteratorButton.addActionListener(new SubmitRequest());
            refreshButton.addActionListener(new RefreshMainPanel());
            // open the xml Response File
            viewResult.addActionListener(new ActionListener() {
                public void actionPerformed( ActionEvent event ) {
                    File aFile = getFichier();
                    if ( aFile != null ) {
                        new OpenBrowser(aFile);
                    }
                }
            });
            // display the table response
            viewResponseTable.addActionListener(new OpenTable());
            
            //tableBaseInstances.ch changeSelection(tableBaseInstances.getRowCount() - 1, 0, false, false);
            //tableBaseInstances.requestFocusInWindow();
            //tableIncludedObjectTypes.changeSelection(tableIncludedObjectTypes.getRowCount() - 1, 0, false, false);
            //tableIncludedObjectTypes.requestFocusInWindow();
            // requestedBatchSize
            
            requestedBatchSize = new Long(requestedBatchSizeTextField.getText());
            
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
            
            if (getInventoryRequest) {
                try {
                    // call getInventory operation
                    client.sendGetInventory(baseInstancesMap, tableBaseInstances.getRowCount(),
                            includedObjectTypesMap,tableIncludedObjectTypes.getRowCount(),
                            requestedBatchSize);
                } catch (ProcessingFailureException ex) {
                    exceptionLabel.setForeground(Color.RED);
                    exceptionLabel.setText(ex.getFaultInfo().getReason());
                    System.out.println(ex.getFaultInfo().getReason());
                    exception = true;
                    
                }
                nbrequests++;
            }
            
            else {
                // call getInventoryIterator operation
                try {
                    client.sendGetInventoryIterator(requestedBatchSize);
                }  catch (ProcessingFailureException ex) {
                    exceptionLabel.setForeground(Color.RED);
                    exceptionLabel.setText(ex.getFaultInfo().getReason());
                    System.out.println(ex.getFaultInfo().getReason());
                    exception = true;
                    buttonPanel.removeAll();
                    buttonPanel.add(exceptionLabel);
                    buttonPanel.add(submit);
                }
                nbrequests++;
            }
              /* if (exception) {
                    // the result of the request is an exception
                    //mainPanel.remove(displayResultPanel);
                    // mainPanel.removeAll();
                    //mainPanel.add(exceptionPanel, BorderLayout.SOUTH);
                    //mainPanel.repaint();
                    //mainPanel.revalidate();
                    buttonPanel.remove(submit);
                    buttonPanel.add(exceptionLabel);
                    buttonPanel.add(newRequestButton);
                    mainPanel.repaint();
                    mainPanel.revalidate();
                    exception = false;
                }*/
            
            buttonPanel.removeAll();
            if (exception) {
                buttonPanel.add(exceptionLabel);
                buttonPanel.add(refreshButton);
            }
            else {
            buttonPanel.add(viewResult);
            buttonPanel.add(viewResponseTable);
            buttonPanel.add(submit);
           
            if (requestedBatchSize.intValue() > 1) {
                freezeTables();
                // next requests will be getInventoryIterator requests
                buttonPanel.removeAll();
                buttonPanel.add(viewResult);
                buttonPanel.add(viewResponseTable);
                buttonPanel.add(getInventoryIteratorButton);
                buttonPanel.add(refreshButton);
                getInventoryRequest = false;
            }
           }
            
            mainPanel.repaint();
            mainPanel.revalidate();
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
    /*
    public  void printBaseInstance(HashMap hm) {
        Map map = hm;
        System.out.println("*** printbaseInstance ***row : "+ row);
        for (int k = 0; k <= row; k++) {
            System.out.println("HashMapType["+ k+"]= " + hm.get("baseInstanceType"+k+"1"));
            System.out.println("BIHashMapValue["+ k+"]= " + hm.get("baseInstanceValue"+k+"1"));
            System.out.println("BIHashMapType["+ k+"]= " + hm.get("baseInstanceType"+k+"2"));
            System.out.println("BIHashMapValue["+ k+"]= " + hm.get("baseInstanceValue"+k+"2"));
            System.out.println("HashMapType["+ k+"]= " + hm.get("baseInstanceType"+k+"3"));
            System.out.println("HashMapValue["+ k+"]= " + hm.get("baseInstanceValue"+k+"3"));
            System.out.println("HashMapType["+ k+"]= " + hm.get("baseInstanceType"+k+"4"));
            System.out.println("HashMapValue["+ k+"]= " + hm.get("baseInstanceValue"+k+"4"));
        }
    }
     
    public  void printIncludedObjectType(HashMap hm) {
        Map map = hm;
        System.out.println("*** printIncludedObjectType ***row : "+ row);
        for (int k = 0; k <= row; k++) {
            System.out.println("ObjectAcronym["+ k+"]= " + hm.get("objectAcronym"+k));
            System.out.println("Granularity["+ k+"]= " + hm.get("granularity"+k));
        }
    }
     */
    /*
    public File marshallResponse(GetInventoryResponseT getInventoryResponse) {
        System.out.println("************GetInventoryImpl:marshallResponse***********");
        try {
            InventoryDataT inv = getInventoryResponse.getInventoryData();
            JAXBContext jc = JAXBContext.newInstance("v1.tmf854");
            GetInventoryResponseT getInv = new GetInventoryResponseT();
            getInv.setInventoryData(inv);
            Marshaller marshaller= jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            //StringWriter writer = new StringWriter();
            File res = new File("getInventory-response.xml");
            OutputStream os = new FileOutputStream(res);
            marshaller.marshal(getInv, os );
            return res;
        }   catch(IOException e){
            e.printStackTrace();
        }  catch( JAXBException je ) {
            je.printStackTrace();
        }  catch(NullPointerException e) {
            System.err.println("Element Object Type is not in the database");
        }
     
        return null;
    }*/
    
    public File getFichier() {
        //JFileChooser choixFichier = new JFileChooser();
        JFileChooser fc = new JFileChooser("getInventory-response.xml");
        
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
    
    public static void main(String[] args) {
        TableRowColumn2 frame = new TableRowColumn2();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }
}