// VERSION: Beta v.1.0.4

import java.util.Properties;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
//import java.util.Scanner;
import java.util.Date;

//import java.util.Random;
import javax.swing.*;

import java.net.URI;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.Desktop.*;
import java.awt.*;


public class LAUNCH extends JFrame{

    //All variables, plan is to have a grid layout, three horizontal panels, middle has the ticket adder, bottom has HOTLINKS, Top has.. well.. no plan for that yet.
    private JPanel panel;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;


	private JLabel label;
	private JButton page;
	private JButton page2;
	private JButton page3;
    private JButton more;
    private JButton info;
    private JButton action;
    private JButton action2;
    private JButton addTicket;
    private JButton adddate;
	private JTextField text;
	private int width = 700;
	private int height = 550;
	private String path;
	private static boolean flag;
	//GUI Initializer constructor. 
	public LAUNCH() {

		
		this.setTitle("Ticket Log");
		this.setSize(width,height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBackground(Color.RED);
        this.setLayout(new BorderLayout());
        launcher();

        //first panel center component, has text feild 2 buttons and the LOC logo.
        this.add(panel, BorderLayout.CENTER);
        //Secone panel, frame has 3 buttons, includes the idaptive page and all service now buttons.
        this.add(panel2, BorderLayout.NORTH);
        this.add(panel3, BorderLayout.SOUTH);
        this.add(panel4, BorderLayout.EAST);
        this.add(panel5, BorderLayout.WEST);

        this.setVisible(true);
		
	}

    
    
    //HOTLINKS (Mostly label components).
	public void launcher() {
        
		ImageIcon icon = new ImageIcon("icon.png");
		
        text = new JTextField(12);
        text.setBackground(Color.BLACK);
        text.setForeground(Color.WHITE);

		label = new JLabel();
		label.setText("To save the PCID or ticket number, please type the text in the text box and click \"SaveTicket\" ");
		label.setIcon(icon);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		
		/* 
						
    TODO: Add a layout manager to align elements in a better position Must
    also add more buttons, maybe with custom Icons.
				
						*/
        
        
        page = new JButton("New Ticket!");
        page.setBackground(Color.ORANGE);
        page.setForeground(Color.BLACK);
        page.addActionListener(new service());
        //First Button Initialized..

        page2 = new JButton("Idaptive Page");
        page2.setBackground(Color.GREEN);
        page2.setForeground(Color.BLACK);
        page2.addActionListener(new idaptive());
        //Second Button Initialized.

        page3 = new JButton("Assigned Tickets");
        page3.setBackground(Color.ORANGE);
        page3.setForeground(Color.BLACK);
        page3.addActionListener(new AllTickets());
        //Opens all Assigned tickets.

        action = new JButton("ALL DATA");
        action.setBackground(Color.BLACK);
        action.setForeground(Color.WHITE);
        action.addActionListener(new TASK_GET_TEXT_ARRAY());
        //Third Button Initialized, frame is for the text file data.

        action2 = new JButton("Full Logs");
        action2.setBackground(Color.WHITE);
        action2.setForeground(Color.BLACK);
        action2.addActionListener(new TASK_GET_TEXT_FILE());

        addTicket = new JButton("Save Ticket");
        addTicket.setBackground(Color.BLUE);
        addTicket.setForeground(Color.white);
        addTicket.addActionListener(new TASK_ADD_TICKET());

        adddate = new JButton("WITH DATE");
        adddate.setBackground(Color.BLUE);
        adddate.setForeground(Color.WHITE);
        adddate.addActionListener(new TASK_ADD_TICKET_DATE());

        more = new JButton("links");
        more.addActionListener(new TASK_NEW_LINK());

        info = new JButton("Help?");
        info.addActionListener(new TASK_GET_INFO_FILE());

        //Central panel
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        //panel.add(page3); *
        panel.add(label);
        //panel.add(page); *
        //panel.add(page2); *
        //panel.add(action);
        //panel.add(action2);
        panel.add(addTicket);
        panel.add(adddate);
        panel.add(text);
        
        //North Panel
        panel2 = new JPanel();
        panel2.setBackground(Color.ORANGE);
        panel2.add(page);
        panel2.add(page2);
        panel2.add(page3);


        //South panel
        panel3 = new JPanel();
        panel3.setBackground(Color.ORANGE);
        panel3.add(action);
        panel3.add(action2);

        //East Panel
        panel4 = new JPanel();
        panel4.setBackground(Color.GRAY);
        panel4.add(more);

        //West panel.
        panel5 = new JPanel();
        panel5.setBackground(Color.GRAY);
        panel5.add(info);


	}
    

//frame function Uses a boolean flag to determin path_data and how to use the NEW_TICKET button.
    public static boolean PATH_DATA(){

        int ans;
        ans = JOptionPane.showConfirmDialog(null, "Are you a returning user?", "Confirmation dialog", JOptionPane.YES_NO_CANCEL_OPTION);

        if(ans == 0){
             flag = true;
      }     
            else if(ans == -1){ System.exit(0);}
            else{flag = false;}    


        //String ans;
        //ans = JOptionPane.showInputDialog("Are you a returning User? (y/n)");
       // if(ans.equalsIgnoreCase("y") || ans.equalsIgnoreCase("yes")){ flag = true;}
          //  else{flag = false;}
        return flag;
    }



    
 
 
    /*  public void addTickets(){
        String username = System.getProperty("user.name");
        String ans;
        String data = text.getText();
        SD_MIL existingFile = new SD_MIL();
        if(PATH_DATA() == true) {existingFile.fileStart(data);}
            else if(PATH_DATA() == false){
                ans = JOptionPane.showInputDialog(null, "Would you like to start a new file?", "FILE_!", JOptionPane.OK_CANCEL_OPTION);
                    if(ans.equalsIgnoreCase("y") || and.equalsIgnoreCase("yes")){
                        existingFile.fileOpen("C:\\Users\\"+Username+"\\Documents\\TASK_DATA.txt", data);
                        }
                        else if(and.equalsIgnoreCase("n") || ans.equalsIgnoreCase("no")){
                            JOptionPane.showMessageDialog(null, "warning! the program will now shut down!", "Warning!", JOptionPane.ERROR_MESSAGE);
                            System.exit(0);
                            }
                        }
                else{
                System.exit(0);
                }
            }
                */

    //How about an array of all the data i want to append?
    
    public void FUNCTION_ADD_ELEMENTS(String data, boolean addFlag){
        ArrayList <String> datas = new ArrayList <String>();
            while(true){
                datas.add(data); //Don't know if frame will work...
                    if(addFlag == false){ break; }
                }
            }


    //For the first Button.(Link)
	private class service implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
			    URI link = new URI("https://loc.servicenowservices.com/nav_to.do?uri=%2Fincident.do%3Fsys_id%3D-1%26sysparm_query%3Dactive%3Dtrue%26sysparm_stack%3Dincident_list.do%3Fsysparm_query%3Dactive%3Dtrue");
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
                URI Ilink = new URI("https://loc.my.idaptive.app/my#TXlBcHBz");
                java.awt.Desktop.getDesktop().browse(Ilink);
                JOptionPane.showMessageDialog(null, "Idaptive Page Lauched!", "Webpage Message", JOptionPane.OK_OPTION);
            }
            catch(Exception x){
                x.printStackTrace();
            }
        }
    }

    private class AllTickets implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                URI Ilink = new URI("https://loc.servicenowservices.com/nav_to.do?uri=%2F$pa_dashboard.do%3Fsysparm_dashboard%3D1157e7c01b89a050bbd1a8eae54bcb02%26sysparm_tab%3D91576bc01b89a050bbd1a8eae54bcb9a");
                java.awt.Desktop.getDesktop().browse(Ilink);
                JOptionPane.showMessageDialog(null, "All Assigned tickets!", "Webpage Message", JOptionPane.OK_OPTION);
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
            if(flag == true) {
            try {
				JOptionPane.showMessageDialog(null, TASK_DATA.IO_stream("C:\\Packages\\TASK_SD\\devyTEXT.txt"));
			} catch (HeadlessException | FileNotFoundException e1) {
				//catch block
				e1.printStackTrace();
			}
            	}
            else {JOptionPane.showMessageDialog(null, "The File does not EXIST!", "Missing file error", JOptionPane.ERROR_MESSAGE);}
    }
	}
    //For the fouth button, To launch the TXT file.
    private class TASK_GET_TEXT_FILE implements ActionListener{
        public void actionPerformed(ActionEvent e){

            String user;
            Desktop desktop = Desktop.getDesktop();
            user = System.getProperty("user.name");
            File file = new File("C:\\Packages\\TASK_SD\\devyTEXT.txt");
                if(file.exists()){
                    try {
						desktop.open(file);
					} catch (IOException e1) {
						// catch block
						e1.printStackTrace();
					}
                }
                    else{
                            JOptionPane.showMessageDialog(null, "Warning! File Does not Exist","", JOptionPane.ERROR_MESSAGE);
                    }
            }
        }

        private class TASK_GET_INFO_FILE implements ActionListener{
            public void actionPerformed(ActionEvent e){
    
                String user;
                Desktop desktop = Desktop.getDesktop();
                user = System.getProperty("user.name");
                File file = new File("C:\\Packages\\TASK_SD\\README.txt");
                    if(file.exists()){
                        try {
                            desktop.open(file);
                        } catch (IOException e1) {
                            // catch block
                            e1.printStackTrace();
                        }
                    }
                        else{
                                JOptionPane.showMessageDialog(null, "Warning! File Does not Exist","", JOptionPane.ERROR_MESSAGE);
                        }
                }
            }

        // Button that appends data to the file.
        private class TASK_ADD_TICKET implements ActionListener{
            public void actionPerformed(ActionEvent e){
                

                    String username = System.getProperty("user.name");
                    String ans;
                    String data = text.getText();
                    SD_MIL existingFile = new SD_MIL();
                    if(flag == true) {try {
						existingFile.fileOpen("C:\\Packages\\TASK_SD\\devyTEXT.txt",data);
					} catch (IOException e1) {
						// catch block
						e1.printStackTrace();
					}}
                        else if(flag == false){
                            ans = JOptionPane.showInputDialog(null, "Would you like to start a new file?", "FILE_!", JOptionPane.OK_CANCEL_OPTION);
                                if(ans.equalsIgnoreCase("y") || ans.equalsIgnoreCase("yes")){
                                    try {
										existingFile.fileStart(data);
									} catch (IOException e1) {
										//catch block
										e1.printStackTrace();
									}
                                    }
                                    else if(ans.equalsIgnoreCase("n") || ans.equalsIgnoreCase("no")){
                                        JOptionPane.showMessageDialog(null, "warning! the program will now shut down!", "Warning!", JOptionPane.ERROR_MESSAGE);
                                        System.exit(0);
                                        }
                                    }
                            else{
                            System.exit(0);
                            }
                        }  
            }

            private class TASK_ADD_TICKET_DATE implements ActionListener{
                public void actionPerformed(ActionEvent e){
                    
                        Date date = new Date();
                        String username = System.getProperty("user.name");
                        String ans;
                        String data = text.getText();
                        SD_MIL existingFile = new SD_MIL();
                        if(flag == true) {try {
                            existingFile.fileOpen("C:\\Packages\\TASK_SD\\devyTEXT.txt",username + ":- " + data + "\t\t- " + date.toString());
                        } catch (IOException e1) {
                            // catch block
                            e1.printStackTrace();
                        }}
                            else if(flag == false){
                                ans = JOptionPane.showInputDialog(null, "Would you like to start a new file?", "FILE_!", JOptionPane.OK_CANCEL_OPTION);
                                    if(ans.equalsIgnoreCase("y") || ans.equalsIgnoreCase("yes")){
                                        try {
                                            existingFile.fileStart(data);
                                        } catch (IOException e1) {
                                            //catch block
                                            e1.printStackTrace();
                                        }
                                        }
                                        else if(ans.equalsIgnoreCase("n") || ans.equalsIgnoreCase("no")){
                                            JOptionPane.showMessageDialog(null, "warning! the program will now shut down!", "Warning!", JOptionPane.ERROR_MESSAGE);
                                            System.exit(0);
                                            }
                                        }
                                else{
                                System.exit(0);
                                }
                            }                   
                }
        

                private class TASK_NEW_LINK implements ActionListener{

                    public void actionPerformed(ActionEvent e){

                        new LINK();

                    }

                }

	//Why do I need to return a boolean when I can just check for file Existence? SMH
	

                //Below is an email bot to send messages, Might add that button if permission is given.

            /*    
                public void EMAIL_BOT(String data){

                    frame.data = data;

                    String Dest;
                    Dest = JOptionPane.showInputDialog("Who would you like to EMAIL?");
              
                    Date date = new Date();

                    String Sub_date;
                    Subject = date.toString();
              
                    String sub_Message;
                    sub_Message = data;
              
              
              
              
                    String sendrmailid = "habdalla@loc.gov";
                    final String uname = "habdalla";
                    final String pwd = "pass";
              
                    //Add SMPT server, port number
                    Properties propvls = new Properties();
                    propvls.put("mail.smtp.auth", "true");
                    propvls.put("mail.smtp.starttls.enable", "true");
                    propvls.put("mail.smtp.host", "smtp.lib.loc.gov");
                    propvls.put("mail.smpt.port", "25");
              
                    Session sessionobj = Session.getInstance(propvls,
                       new javax.mail.Authenticator()
                       {
                          protected PasswordAuthentication getPasswordAuthentication()
                          {
                             return new PasswordAuthentication(uname, pwd);
                          }
                       });
              
                    try 
                    {
                       Message messageobj = new MimeMessage(sessionobj);
                       messageobj.setFrom(new InternetAddress(sendrmailid));
                   messageobj.setRecipients(Message.RecipientType.TO,InternetAddress.parse(Dest));
                   messageobj.setSubject();
                   messageobj.setText(sub_message);
              
                   Transport.send(messageobj);
                   JOptionPane.showMessageDialog(null, "Your email sent successfully....", "Email Confirmation", JOptionPane.OK_OPTION);
                } 
                catch (MessagingException exp) 
                {
                   throw new RuntimeException(exp);
                }

                }
                    */

	public static void main(String[] args) {
		PATH_DATA();
        new LAUNCH();
        //So far does not work
        
	}
        }

