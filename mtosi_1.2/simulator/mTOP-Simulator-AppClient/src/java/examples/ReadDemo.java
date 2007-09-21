/*
 * ReadDemo.java
 *
 * Created on 10 juin 2007, 11:27
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package examples;


    import java.awt.*;
    import java.awt.event.*;
    import javax.swing.*;
    import javax.swing.text.*;
    import java.io.*;

    public class ReadDemo {

        // read the file into the pane

        static void readin(String fn, JTextComponent pane) {
            try {
                FileReader fr = new FileReader(fn);
                pane.read(fr, null);
                fr.close();
            }
            catch (IOException e) {
                System.err.println(e);
            }
        }

        public static void main(String args[]) {
            final JFrame frame = new JFrame("Read Demo");
            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });

            // set up the text pane, either a JTextArea or JTextPane

            final JTextComponent textpane = new JTextArea();
            //final JTextComponent textpane = new JTextPane();

            // set up a scroll pane for the text pane

            final JScrollPane pane = new JScrollPane(textpane);
            pane.setPreferredSize(new Dimension(600, 600));

            // set up the file chooser

            String cwd = System.getProperty("user.dir");
            final JFileChooser jfc = new JFileChooser(cwd);
            final JLabel elapsed = new JLabel("Elapsed time: ");

            JButton filebutton = new JButton("Choose File");
            filebutton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (jfc.showOpenDialog(frame) !=
                        JFileChooser.APPROVE_OPTION)
                            return;
                    File f = jfc.getSelectedFile();

                    // record the current time and read the file

                    final long s_time = System.currentTimeMillis();
                    frame.setCursor(Cursor.getPredefinedCursor(
                        Cursor.WAIT_CURSOR));
                    readin(f.toString(), textpane);

                    // wait for read to complete and update time

                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            frame.setCursor(Cursor.
                                getPredefinedCursor(
                                Cursor.DEFAULT_CURSOR));
                            long t = System.currentTimeMillis() -
                                   s_time;
                            elapsed.setText("Elapsed time: " + t);
                        }
                    });
                }
            });

            JPanel buttonpanel = new JPanel();
            buttonpanel.add(filebutton);
            buttonpanel.add(elapsed);

            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            panel.add("North", buttonpanel);
            panel.add("Center", pane);

            frame.getContentPane().add(panel);
            frame.pack();
            frame.setVisible(true);
        }
    }



 