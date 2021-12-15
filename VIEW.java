import javax.swing.*;
import javax.swing.text.View;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;

public class VIEW extends JFrame{

    
    public String[] selected;
    private JPanel panel;
    private JPanel panel2;
    private JPanel panel3;
    private JList elementList; // To hold months
    private JList selectedElementList; // Selected months
    private JScrollPane scrollPane1; // Scroll pane - first list
    private JScrollPane scrollPane2; // Scroll pane - second list
    private JButton button; // A button


    public VIEW() throws IOException{

        setArray();
        setTitle("View Data");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //pack();
        setResizable(true);

        setPanel1();
        setPanel2();
        setPanel3();

        add(panel, BorderLayout.NORTH);
        add(panel2, BorderLayout.CENTER);
        add(panel3, BorderLayout.SOUTH);

        setVisible(true);


    }



        public void setArray() throws IOException{
            
            
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
    
    
    }

        public void setPanel1(){

            panel = new JPanel();
            elementList = new JList(selected);
            elementList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            elementList.setVisibleRowCount(8);
            scrollPane1 = new JScrollPane(elementList);
            panel.add(scrollPane1);

        }

        public void setPanel2(){

            panel2 = new JPanel();
            selectedElementList = new JList();
            selectedElementList.setVisibleRowCount(8);
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

                Object[] selections = elementList.getSelectedValues();
                selectedElementList.setListData(selections);

            }

        }

        public static void main(String[] args) {
            

            try{
            new VIEW();
            }
            catch(IOException e){

                System.out.println(e.getMessage());

            }

        }

}