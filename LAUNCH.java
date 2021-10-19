import java.util.Scanner;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.net.URI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;
public class LAUNCH extends JFrame{

    //All variables, plan is to have a grid layout, three horizontal panels, middle has the ticket adder, bottom has HOTLINKS, Top has.. well.. no plan for that yet.
	private JPanel panel;
	private JLabel label;
	private JButton page;
	private JButton page2;
	private JButton page3;
	private JButton page4;
	private JButton action;
	private JTextField text;
	private int width = 750;
	private int height = 500;
	private String path;
	
	//GUI Initializer
	public LAUNCH() {
		
		this.setTitle("Ticket Logger MIL");
		this.setSize(width,height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setVisible(true);
	}
    
    
    
    //HOTLINKS.
	public void launcher() {
		
        page = new JButton("New Ticket!");
        page.setBackground(Color.ORANGE);
        page.setForeground(Color.BLACK);
        page.addActionListener(new service());
        //First Button Initialized..

        page2 = new JButton("Idaptive Page");
        page2.setBackgroud(Color.GREEN);
        page2.setForeground(Color.BLACK);
        page2.addActionListener(new Idaptive());
        //Second Button Initialized.

        action = new JButton("ALL DATA");
        action.setBackground(Color.BLACK);
        action.seForeground(Color.BLACK);
        action.addActionListener(new TASK_GET_TEXT_ARRAY());
        //Third Button Initialized, this is for the text file data.

        text = new JTextField(12);


        panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
	}
    


    public static boolean PATH_DATA(){
        boolean falg;
        String ans;
        ans = JOptionPane.showInputDialog("Are you a returning User? (y/n)");
        if(ans.equalsIgnoreCase("y") || ans.equalsIgnoreCase("yes")){ flag = true;}
            else{flag = false;}
            return flag;
    }



    //Uses boolean flag to determin path and data and how to use the NEW_TICKET object.
    public void addTickets(){

        String username = System.getProperty("user.name");
        String ans;
        String data = text.getText();
        SD_MIL existingFile = new SD_MIL();
        if(PATH_DATA() == true){
        existingFile.fileStart(data);
        }
        else if(PATH_DATA() == false){
            ans = JOptionPane.showInputDialog(null, "Would you like to start a new file?", "FILE_!", JOptionPane.OK_CANCEL_OPTION);
            if(ans.equalsIgnoreCase("y") || and.equalsIgnoreCase("yes")){
                existingFile.fileOpen("C:\\Users\\"+Username+"\\Documents\\TASK_DATA.txt", data);
            }
        }

    }



    //For the first Button.(Link)
	private class service implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
			    URI link = new URI("https://loc.servicenowservices.com");
                java.awt.Desktop.getDesktop().browse(link);
			    JOptionPane.showMessageDialog(null, "New Ticket Page launched!", "Webpage Message", JOptionPane.ERROR_MESSAGE);}
			catch(Exception d){
				d.printStackTrace();
			}
        }
    }
	//For the second Button.(Link)
	private class idaptive implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                URI link = new URI("https://loc.my.idaptive.app");
                java.awt.desktop.getDesktop().browse(link);
                JOptionPane.showMessageDialog(null, "Idaptive Page Lauched!", "Webpage Message", JOptionPane.OK_OPTION);
            }
            catch(Exception x){
                x.printStackTrace();
            }
        }
    }
    //For the Third Button.(Get the array of the .txt file.)
	private class TASK_GET_TEXT_ARRAY implements ActionListener{
        public void actionPerformed(ActionEvent e){

            SD_MIL TASK_DATA = new SD_MIL();
            JOptionPane.showMessageDialog(null, TASK_DATA.IO_stream(path));

        }
    }
	//Why do I need to return a boolean when I can just check for file Existence? SMH
	

	public static void main(String[] args) {
		

	}

}
