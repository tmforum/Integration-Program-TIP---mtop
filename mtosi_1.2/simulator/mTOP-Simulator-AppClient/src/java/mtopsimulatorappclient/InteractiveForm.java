package mtopsimulatorappclient;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class InteractiveForm extends JFrame {
//    private final static String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//    public static final String[] columnNames = {
//        "Title", "Artist", "Album", ""
//    };
//    JTable table;
//    InteractiveTableModel tableModel;
//    JPanel buttonPanel;
//    JButton button;
//    protected JScrollPane scroller;
//    
//    public InteractiveForm() {
//        initComponent();
//    }
//    
//    public void initComponent() {
//         tableModel = new InteractiveTableModel(columnNames);
//         //tableModel.addTableModelListener(new InteractiveForm.InteractiveTableModelListener());
//         table = new JTable();
//         table.setModel(tableModel);
//       scroller = new javax.swing.JScrollPane(table);
//         table.setPreferredScrollableViewportSize(new java.awt.Dimension(500, 300));
//         setLayout(new BorderLayout());
//         add(scroller, BorderLayout.CENTER);
//         
//        button = new JButton( "Add Row" );
//        buttonPanel.add( button );
//        
//        button.addActionListener( new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                 int iRow = tableModel.getSelectedRow() + 1;
//                tableModel.insertRow();
//                //int row = table.getRowCount() - 1;
//                //table.changeSelection(row, row, false, false);
//                //table.requestFocusInWindow();
//            }
//        });
//        
//        //
////        
////        button = new JButton( "Insert Row" );
////        buttonPanel.add( button );
////        button.addActionListener( new ActionListener() {
////            public void actionPerformed(ActionEvent e) {
////                model.insertRow( 0, createRow() );
////                table.changeSelection(0, 0, false, false);
////                table.requestFocusInWindow();
////            }
////        });
////        
////        //
////        
////        button = new JButton( "Empty Row" );
////        buttonPanel.add( button );
////        button.addActionListener( new ActionListener() {
////            public void actionPerformed(ActionEvent e) {
////                model.setRowCount( model.getRowCount() + 1 );
////                int row = table.getRowCount() - 1;
////                table.changeSelection(row, row, false, false);
////                table.requestFocusInWindow();
////            }
////        });
////        //
////        button = new JButton( "Add Column" );
////        buttonPanel.add( button );
////        button.addActionListener( new ActionListener() {
////            public void actionPerformed(ActionEvent e) {
////                String header = "Col" + (table.getColumnCount() + 1);
////                model.addColumn( header );
////                table.requestFocusInWindow();
////            }
////        });
////        //
////        button = new JButton( "Add Column & Data" );
////        buttonPanel.add( button );
////        button.addActionListener( new ActionListener() {
////            public void actionPerformed(ActionEvent e) {
////                String header = "Col" + (table.getColumnCount() + 1);
////                
////                int rows = table.getRowCount();
////                String[] values = new String[rows];
////                
////                for (int j = 0; j < rows; j++) {
////                    values[j] = Integer.toString(j);
////                }
////                
////                model.addColumn( header, values );
////                table.requestFocusInWindow();
////            }
////        });
////        //
////        button = new JButton( "Add Column - No Reordering" );
////        buttonPanel.add( button );
////        button.addActionListener( new ActionListener() {
////            public void actionPerformed(ActionEvent e) {
////                //  Use this method when you don't want existing columns
////                //  to be rebuilt from the model.
////                //  (ie. moved columns will not be reordered)
////                
////                table.setAutoCreateColumnsFromModel( false );
////                String header = "Col" + (table.getColumnCount() + 1);
////                model.addColumn( header );
////                
////                //  AutoCreate is turned off so create table column here
////                
////                TableColumn column = new TableColumn( table.getColumnCount() );
////                column.setHeaderValue( header );
////                table.addColumn( column );
////                
////                // These won't work once setAutoCreate... has been set to false
////                buttonPanel.getComponent(3).setEnabled( false );
////                buttonPanel.getComponent(4).setEnabled( false );
////                table.requestFocusInWindow();
////            }
////        });
////        //
////        button = new JButton( "Remove Last Column" );
////        buttonPanel.add( button );
////        button.addActionListener( new ActionListener() {
////            public void actionPerformed(ActionEvent e) {
////                int columns = model.getColumnCount();
////                
////                if (columns > 0) {
////                    
////                    if (!table.getAutoCreateColumnsFromModel()) {
////                        int view =
////                                table.convertColumnIndexToView(columns - 1);
////                        TableColumn column =
////                                table.getColumnModel().getColumn(view);
////                        table.getColumnModel().removeColumn( column );
////                    }
////                    
////                    model.setColumnCount( columns - 1 );
////                }
////                table.requestFocusInWindow();
////            }
////        });
//        
//    }
//    
//     class InteractiveRenderer extends DefaultTableCellRenderer {
//         protected int interactiveColumn;
//
//         public InteractiveRenderer(int interactiveColumn) {
//             this.interactiveColumn = interactiveColumn;
//         }
//
//         public Component getTableCellRendererComponent(JTable table,
//            Object value, boolean isSelected, boolean hasFocus, int row,
//            int column)
//         {
//             Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//             if (column == interactiveColumn && hasFocus) {
//                 if ((InteractiveForm.this.tableModel.getRowCount() - 1) == row &&
//                    !InteractiveForm.this.tableModel.hasEmptyRow())
//                 {
//                     InteractiveForm.this.tableModel.addEmptyRow();
//                 }
//
//             }
//
//             return c;
//         }
//     }
//    
//    public static void main(String[] args) {
//        InteractiveForm frame = new InteractiveForm();
//        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
//        frame.pack();
//        frame.setVisible(true);
//    }
}
