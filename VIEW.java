import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.datatransfer.Clipboard;
/*
*       THIS CLASS WILL BE LINKED TO MAIN (LAUNCH)
*       The main method here is only for testing.
*       Class will be used to view elements in array from the main.
*       This gives user way to scroll through the data and inspect in a window other than notepad.
*/

public class VIEW extends JFrame{

    public String[] axis;
    public static ArrayList<String> selected;
    private JPanel panel;
    private JPanel panel2;
    private JPanel panel3;
    private JList<String> elementList; // To hold months
    private JList<String> selectedElementList; // Selected months
    private JScrollPane scrollPane1; // Scroll pane - first list
    private JScrollPane scrollPane2; // Scroll pane - second list
    private JScrollPane scrollPane;
    private JButton button; // A button
    private JButton clear;
    private static DefaultListModel<String> model = new DefaultListModel<>();
    private static DefaultListModel<String> model2 = new DefaultListModel<>();
    private JMenuBar bar;


    public VIEW() throws IOException{

        setArray();
        this.setTitle("View Data");
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        this.setSize(500, 500);
        this.setResizable(false);

        setPanel1();
        setPanel2();
        setPanel3();

        this.add(panel, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.CENTER);
        this.add(panel3, BorderLayout.SOUTH);
        this.setVisible(true);


    }



        public static void setArray() throws IOException{
            
            
            File file = new File("ALL_TASK_DATAS.txt");
            Scanner filein = new Scanner(file);
            if(file.exists()){



                selected = new ArrayList <>();
                    
                int y2 = 0;

                while(filein.hasNextLine()){

                    selected.add(filein.nextLine());

                    y2++;
                }



                int y = 0;
               
                while(y<selected.size()){

                    //model.addElement(filein.nextLine());

                    model.addElement(String.valueOf(y));

                    y++;
                }

                }
                else{

                    JOptionPane.showMessageDialog(null, "Could not load data from the file!", "FileNotFoundException", JOptionPane.ERROR);

                }
                filein.close();

    
    
    }

    

        public void setMenu(){

            bar = new JMenuBar();
            JMenu menu = new JMenu("file");
            JMenuItem item =  new JMenuItem("Find Element");


            menu.add(item);
            bar.add(menu);

        }




        public void setPanel1(){

            panel = new JPanel();
            elementList = new JList<>(model);
            elementList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            elementList.setVisibleRowCount(8);
            scrollPane1 = new JScrollPane(elementList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            
            panel.add(scrollPane1);

        }

    //After countless hours of trying to get this garbage to work I give up.
    //I am just glad it even shows up on the screen but something was causing this function call to put the entire 
    //CONTINUED >> window away.. as if it were a daemon.
    //The issue for now is that this garbage is not setting up to the specified bounds, it shrinks back to the text size. 12/16/2021.
        public void setPanel2(){

            model2.addElement("==========================FULL LOG LIST==========================");
            panel2 = new JPanel();
            selectedElementList = new JList<>(model2);
            selectedElementList.setVisibleRowCount(15);
            selectedElementList.setBounds(0,0,100,50);
            scrollPane2 = new JScrollPane(selectedElementList);
            scrollPane2.setBounds(0, 0, 100, 50);
            panel2.add(scrollPane2);

        }

        public void setPanel3(){

            panel3 = new JPanel();
            button = new JButton("Show Item");
            clear = new JButton("clear");
            button.addActionListener(new SHOW_ITEM());
            clear.addActionListener(new CLEAR());
            panel3.add(button);
            panel3.add(clear);

        }

        private class SHOW_ITEM implements ActionListener{

            public void actionPerformed(ActionEvent e){

                int item = elementList.getSelectedIndex();
                
                model2.addElement(selected.get(item));
                
            
            }

        }

        private class CLEAR implements ActionListener{

            public void actionPerformed(ActionEvent e){

                model2.clear();

            }

        }


        /*
        public static void main(String[] args) {
            
            JOptionPane.showMessageDialog(null, "Thread is running", "alert", JOptionPane.ERROR_MESSAGE);

           
            try{
                
            new VIEW();
            }
            catch(IOException e){

                JOptionPane.showMessageDialog(null, e.getMessage(), "alert", JOptionPane.ERROR_MESSAGE);

            }

        }
        */
        
}
