package examples;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
 
public class TableActions extends JFrame
{
    public TableActions()
    {
        JTable table = new JTable(15, 5)
        {
            public boolean isCellEditable(int row, int column)
            {
              return column % 2 == 0;
//              return false;
            }
        };
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scrollPane = new JScrollPane( table );
        getContentPane().add( scrollPane );
 
        InputMap im = table.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
 
        //  Have the enter key work the same as the tab key
 
        KeyStroke tab = KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0);
        KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        im.put(enter, im.get(tab));
 
        //  Disable the right arrow key
 
        KeyStroke right = KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0);
        im.put(right, "none");
 
        //  Override the default tab behaviour
        //  Tab to the next editable cell. When no editable cells goto next cell.
 
        final Action oldTabAction = table.getActionMap().get(im.get(tab));
        Action tabAction = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                oldTabAction.actionPerformed( e );
                JTable table = (JTable)e.getSource();
                int rowCount = table.getRowCount();
                int columnCount = table.getColumnCount();
                int row = table.getSelectedRow();
                int column = table.getSelectedColumn();
 
                while (! table.isCellEditable(row, column) )
                {
                    column += 1;
 
                    if (column == columnCount)
                    {
                        column = 0;
                        row +=1;
                    }
 
                    if (row == rowCount)
                    {
                        row = 0;
                    }
 
                    //  Back to where we started, get out.
 
                    if (row == table.getSelectedRow()
                    &&  column == table.getSelectedColumn())
                    {
                        break;
                    }
                }
 
                table.changeSelection(row, column, false, false);
            }
        };
        table.getActionMap().put(im.get(tab), tabAction);
 
    }
 
    public static void main(String[] args)
    {
        TableActions frame = new TableActions();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }
}
