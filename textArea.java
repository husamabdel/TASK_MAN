
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
public class textArea extends JFrame {
    
private JScrollPane scroll;
private JTextArea area;
private ArrayList <String> data = new ArrayList<>();

public textArea(String filename) throws FileNotFoundException{


    File file = new File(filename);
    Scanner io = new Scanner(file);
    io.close();

    while(io.hasNextLine()){

        data.add(io.nextLine());

    }
    

    area = new JTextArea();
    area.setBounds(0,0,500,500);

    int x = 0;
    for(String s: data){

        area.append(data.get(x)+"\n");
        x++;
    }

    scroll = new JScrollPane(area);
    
    this.add(scroll);
    this.setTitle("Full Logs");
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(950, 550);
    
    //this.pack();
    this.setVisible(true);

}

public textArea(File file) throws FileNotFoundException{

    Scanner io = new Scanner(file);
    while(io.hasNextLine()){

        data.add(io.nextLine());

    }
    io.close();
    

    area = new JTextArea();
    area.setBounds(0,0,500,500);

    int x = 0;
    for(String s: data){

        area.append(data.get(x)+"\n");
        x++;
    }

    scroll = new JScrollPane(area);
    
    this.add(scroll);
    this.setTitle("Full Logs");
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(950, 550);
    
    //this.pack();
    this.setVisible(true);

}


}
