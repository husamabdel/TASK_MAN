import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;
/*
*       THIS CLASS WILL BE LINKED TO MAIN (LAUNCH)
*       The main method here is only for testing.
*       Class will be used to view elements in array from the main.
*
*/

public class VIEW extends JFrame{

    
    public static String[] selected;
    private JPanel panel;
    private JPanel panel2;
    private JPanel panel3;
    private JList<String> elementList; // To hold months
    private JList<String> selectedElementList; // Selected months
    private JScrollPane scrollPane1; // Scroll pane - first list
    private JScrollPane scrollPane2; // Scroll pane - second list
    private JButton button; // A button
    private DefaultListModel<String> model = new DefaultListModel<>();


    public VIEW() throws IOException{

        
        this.setTitle("View Data");
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        //this.setSize(500, 500);
        this.setResizable(true);

        setPanel1();
        setPanel2();
        setPanel3();

        this.add(panel, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.CENTER);
        this.add(panel3, BorderLayout.SOUTH);

        this.setVisible(true);


    }



        public static void setArray() throws IOException{
            
            
            File file = new File("C:\\Packages\\TASK_SD\\devyTEXT.txt");
            Scanner filein = new Scanner(file);
            if(file.exists()){

                int x = 0;
                while(filein.hasNextLine()){

                    x++;

                }
                selected = new String[x];
                    
                    int y = 0;

                    while(filein.hasNextLine()){

                        selected[y] = filein.nextLine();

                        y++;
                    }


            }
                else{

                    JOptionPane.showMessageDialog(null, "Could not load data from the file!", "FileNotFoundException", JOptionPane.ERROR);

                }
                filein.close();

    
    
    }

        public void setPanel1(){

            panel = new JPanel();
            elementList = new JList<>(selected);
            elementList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            elementList.setVisibleRowCount(8);
            scrollPane1 = new JScrollPane(elementList);
            panel.add(scrollPane1);

        }

        public void setPanel2(){

            model.addElement("Default value");
            panel2 = new JPanel();
            selectedElementList = new JList<>(model);
            selectedElementList.setVisibleRowCount(8);;
            scrollPane2 = new JScrollPane(selectedElementList);
            panel2.add(scrollPane2);

        }

        public void setPanel3(){

            panel3 = new JPanel();
            button = new JButton("Show Item");
            button.addActionListener(new SHOW_ITEM());
            panel3.add(button);

        }

        private class SHOW_ITEM implements ActionListener{

            public void actionPerformed(ActionEvent e){

                
                model.addElement(elementList.getSelectedValue());

            
            }

        }

        public static void main(String[] args) {
            
            JOptionPane.showMessageDialog(null, "Thread is running", "alert", JOptionPane.ERROR_MESSAGE);

           
            try{
                setArray();
            new VIEW();
            }
            catch(IOException e){

                JOptionPane.showMessageDialog(null, e.getMessage(), "alert", JOptionPane.ERROR_MESSAGE);


            }

        }

}
