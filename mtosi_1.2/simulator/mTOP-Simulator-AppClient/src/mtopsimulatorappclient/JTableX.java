/*
 * JTableX.java
 *
 * Created on 10 juin 2007, 10:03
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mtopsimulatorappclient;

import javax.swing.*;
import javax.swing.table.*;
import java.util.Vector;

public class JTableX extends JTable {
    protected ColEditorModel rm;
    
    public JTableX() {
        super();
        rm = null;
    }
    
    public JTableX(TableModel tm) {
        super(tm);
        rm = null;
    }
    
   /*  public JTableX(TableModel tm, TableColumnModel cm)
     {
         super(tm,cm);
         rm = null;
     }
    */
    /* public JTableX(TableModel tm, TableColumnModel cm,
      ListSelectionModel sm)
     {
         super(tm,cm,sm);
         rm = null;
     }*/
    
   /*  public JTableX(int rows, int cols)
     {
         super(rows,cols);
         rm = null;
     }
    */
    /* public JTableX(final Vector rowData, final Vector columnNames)
     {
         super(rowData, columnNames);
         rm = null;
     }
     
     public JTableX(final Object[][] rowData, final Object[] colNames)
     {
         super(rowData, colNames);
         rm = null;
     }
     */
    // new constructor
    /* public JTableX(TableModel tm, ColEditorModel rm)
     {
         super(tm,null,null);
         this.rm = rm;
     }*/
    
    public void setColEditorModel(ColEditorModel rm) {
        this.rm = rm;
    }
    
    public ColEditorModel getColEditorModel() {
        return rm;
    }
   /* 
    public boolean isCellEditable(int row, int col) {
      
      //  return false; // toutes les cellules seront non editables
    }*/
    
    
    public TableCellEditor getCellEditor(int row, int col) {
        TableCellEditor tmpEditor = null;
        if (rm!=null)
            tmpEditor = rm.getEditor(col);
        if (tmpEditor!=null)
            return tmpEditor;
        return super.getCellEditor(row,col);
    }
}