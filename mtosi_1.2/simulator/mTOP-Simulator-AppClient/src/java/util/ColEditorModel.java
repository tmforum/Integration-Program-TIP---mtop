
package util;

import javax.swing.table.*;
import java.util.*;

 public class ColEditorModel extends DefaultTableModel
 {
      private Hashtable data;
      public ColEditorModel()
      {
          data = new Hashtable();
      }
      
      public ColEditorModel(Object[][] data, String[] s) {
          super(data, s);
      }
      
     public void addEditorForRow(int row, TableCellEditor e )
     {
            data.put(new Integer(row), e);
     }
     public void removeEditorForRow(int row)
     {
         data.remove(new Integer(row));
     }
     public TableCellEditor getEditor(int row)
     {
         return (TableCellEditor)data.get(new Integer(row));
     }
     
     public boolean isRowEmpy(int row) {
        Integer rowKey = new Integer(row);
	HashMap rows = (HashMap)data.get(rowKey);
        
       return rows.isEmpty();
     }
     
     public Map getRow (int row) {
         Integer rowKey = new Integer(row);
	 HashMap row1 = (HashMap)data.get(rowKey);
         
         return row1;
     }
     
 }