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
import java.util.Collection;
//import java.util.Scanner;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import javax.crypto.SecretKey;
//import java.util.Random;
import javax.swing.*;
import javax.swing.border.*;
import java.net.URI;
import java.nio.file.Path;
import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.Desktop.*;
import java.awt.*;
import javax.crypto.*;

public class LAUNCH extends JFrame{

    //All variables.
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
    private JButton getText;
	private JTextField text;
    private JRadioButton radio;
	private int width = 700;
    private int height = 550;
    private JMenuBar bar = new JMenuBar();
    private static File path; //Will be used along with file select.
    private static String pathFile;
    private static boolean flag;
    public static ArrayList <String> element = new ArrayList<String>();
    private static SecretKey key;
    
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
        
        
        this.setJMenuBar(bar);
        this.setVisible(true);
		
	}

    
    
    //HOTLINKS (Mostly label components).
	public void launcher() {
        


        radio = new JRadioButton("Stamp with username and date");
        radio.addActionListener(new TASK_ADD_TICKET_DATE());

        JMenu Helpme = new JMenu("Help?"); 
        JMenu filMenu = new JMenu("File");
        JMenu find = new JMenu("Find");
        bar.add(filMenu);
        bar.add(find);
        bar.add(Helpme);

        JMenuItem findItem = new JMenuItem("search for saved string data");
        JMenuItem changeFilePath = new JMenuItem("Change the default file or load new file");
        JMenuItem changeLinks = new JMenuItem("Change Link Buttons");

        findItem.addActionListener(new FUNCTION_ADD_MENU_QUERY());
        changeFilePath.addActionListener(new FUNCTION_CHANGE_PATH());
        changeLinks.addActionListener(new FUNCTION_EDIT_LINK());

        filMenu.add(changeLinks);
        filMenu.add(changeFilePath);
        find.add(findItem);


        Border border = BorderFactory.createLineBorder(Color.black,3);

		ImageIcon icon = new ImageIcon("icon.png");
		
        text = new JTextField(12);
        text.setBackground(Color.BLACK);
        text.setForeground(Color.WHITE);
        text.setCaretColor(Color.GREEN);

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

        getText = new JButton("List");
        getText.addActionListener(new TASK_GET_LIST());

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
        panel.add(radio);
        
        
        //North Panel
        panel2 = new JPanel();
        panel2.setBackground(Color.ORANGE);
        panel2.add(page);
        panel2.add(page2);
        panel2.add(page3);
        panel2.setBorder(border);

        //South panel
        panel3 = new JPanel();
        panel3.setBackground(Color.ORANGE);
        panel3.add(action);
        panel3.add(action2);
        panel3.setBorder(border);

        //East Panel
        panel4 = new JPanel();
        panel4.setBackground(Color.GRAY);
        panel4.add(more);
        panel4.add(getText);
        panel4.setBorder(border);
        //West panel.
        panel5 = new JPanel();
        panel5.setBackground(Color.GRAY);
        panel5.add(info);
        panel5.setBorder(border);

	}
    

    //setting accessor method for other classes{

    public ArrayList elments(){
        return element;
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


	public static void FUNCTION_SET_DEFAULT_FILE(){
		
        pathFile = "C:\\Packages\\TASK_SD\\devyTEXT.txt"; //Default File Path
        path = new File(pathFile);

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

    //
    
   /*
   
   Defunked function, no longer in use! 11/17/2021

   public void FUNCTION_ADD_ELEMENTS(String data, boolean addFlag){
        ArrayList <String> datas = new ArrayList <String>();
            while(true){
                datas.add(data); //Don't know if frame will work...
                    if(addFlag == false){ break; }
                }
            }
            */


            //Funtion to add a dynamic data structure to load all previous data. Will be used for later implementation.
    public static void FUNCTION_LOAD_ELEMENTS(){

            
        try {
            
            Scanner open = new Scanner(path);
            int i = 0;
        while(open.hasNextLine()){
            
            element.add(open.nextLine());

            i++;
        }

        
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "The System could not find the specified file!", "FileNotFoundException!", JOptionPane.ERROR_MESSAGE);

        }
            

    }
    // Sequential search algorithm. Will need to be changed later on..
    public static void FUNCTION_QUERY_ARRAYLIST(String QUERY){

        int num = 0;
        boolean b = true;
        for(int x = 0; x < element.size(); x++){
            
            num++;
            if(element.get(x).contains(QUERY)){
                b = true;
                break;
            }
                else{ b = false;}
           

        }


        if(b == false){
            JOptionPane.showMessageDialog(null, "The search query could not find the requested element ", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "The element " + element.get(num-1) + " was found in the program data on line" + num, "True", JOptionPane.INFORMATION_MESSAGE);
        }

    }


    public static void FUCNTION_QUERY_BINARY(String QUERY){

        HashMap <String, Integer> list = new HashMap<>();
        int keys = 0;
        for(String s: element){
            
            list.put(element.get(keys), keys);

            keys++;
        }

        int low = 0;
        int high = list.size()-1;
        int mid;
        while(low < high){

            mid = high/2;
            if(QUERY.equals(list.get(mid))){  
                JOptionPane.showMessageDialog(null, "The element " + list.get(mid) + " was found in the program data on line" + mid, "True", JOptionPane.INFORMATION_MESSAGE);
                break;
            }
            else{ 
                continue; 
            }

        }


    }


//Change the file path on the menu.
private class FUNCTION_CHANGE_PATH implements ActionListener{

    public void actionPerformed(ActionEvent e){

        JFileChooser FILE_PATH = new JFileChooser();
        int res = FILE_PATH.showOpenDialog(null); //select file to open

        if(res == JFileChooser.APPROVE_OPTION){
            pathFile = FILE_PATH.getSelectedFile().getAbsolutePath();
            path = new File(pathFile);
            JOptionPane.showMessageDialog(null, "The default file was changed successfully", "Success", JOptionPane.OK_OPTION);
        }

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
				JOptionPane.showMessageDialog(null, TASK_DATA.IO_stream(pathFile));
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
            
                if(path.exists()){
                    try {
						desktop.open(path);
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
                    element.add(data);
                    SD_MIL existingFile = new SD_MIL();
                    if(flag == true) {try {
						existingFile.fileOpen(pathFile,data);
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
                        element.add(data);
                        SD_MIL existingFile = new SD_MIL();
                        if(flag == true) {try {
                            existingFile.fileOpen(pathFile,username + ":- " + data + "\t\t- " + date.toString());
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

                // Linear Search function is called in, listener will be added to "find"
                private class FUNCTION_ADD_MENU_QUERY implements ActionListener{

                    public void actionPerformed(ActionEvent e){

                        String TEXT_QUERY;

                        TEXT_QUERY = JOptionPane.showInputDialog("Please enter the text you wish to query:");

                        FUNCTION_QUERY_ARRAYLIST(TEXT_QUERY);

                    }

                }

                private class FUNCTION_EDIT_LINK implements ActionListener{

                    public void actionPerformed(ActionEvent e){


                     int response;
                     String res = JOptionPane.showInputDialog("Please enter the number of the link you would like to change: ");

                        response = Integer.parseInt(res);
                        if(response == 1){
                            String ans = JOptionPane.showInputDialog(null, "Please paste the link below", "Link Editor");
                                LINK linker = new LINK();
                                linker.LINK_SET_1(ans);
                        }
                        else if(response == 2){
                            String ans = JOptionPane.showInputDialog(null, "Please paste the link below", "Link Editor");
                                LINK linker = new LINK();
                                linker.LINK_SET_2(ans);
                        }
                        else if(response == 3){
                            String ans = JOptionPane.showInputDialog(null, "Please paste the link below", "Link Editor");
                                LINK linker = new LINK();
                                linker.LINK_SET_3(ans);
                        }
                        else if(response == 4){
                            String ans = JOptionPane.showInputDialog(null, "Please paste the link below", "Link Editor");
                                LINK linker = new LINK();
                                linker.LINK_SET_4(ans);
                        }
                    }
                }


        

                private class TASK_NEW_LINK implements ActionListener{

                    public void actionPerformed(ActionEvent e){

                        new LINK();

                    }

                }

                private class TASK_GET_LIST implements ActionListener{

                    public void actionPerformed(ActionEvent e){

                        try {
                            new VIEW();
                        } catch (IOException e1) {
                            
                            JOptionPane.showMessageDialog(null, e1.getMessage(), "FileNotFoundException", JOptionPane.ERROR_MESSAGE);
                            
                        }

                    }

                }




                // Starting cryptographic function to encrypt data.

                public static String FUNCTION_ENCRYPT_ELEMENTS(String data)throws Exception{

                    byte[] dataToEnc = data.getBytes();
                    Cipher cipher = Cipher.getInstance("AES");
                    key = KeyGenerator.getInstance("AES").generateKey(); 
                    
                    cipher.init(Cipher.ENCRYPT_MODE, key);
                    byte[] c = cipher.doFinal(dataToEnc);
                    String Enc = new String(c);

                    return Enc;
                }
                // Function not in use at the moment.




                // Using a secondary thread to ensure new elements are added to the ArrayList during runtime.
                //I have to do this resource-consuming terribleness because the arrayList keeps failing at loading new elements at LN 518.
                //UPDATE, I am an idiot... I just checked on the program data and it truns out I have a 42 gigabyte file because of this awful code.
              /*  public static class CLASS_MULTI_THREAD extends Thread{

                    
                    @Override
                    public void run(){

                        try{
                        while(true){

                            FUNCTION_LOAD_ELEMENTS();
                            FUNCTION_BYTE_DATA();
                                Thread.sleep(1000);
                            }
                        }
                        catch(Exception e){
                            JOptionPane.showMessageDialog(null, "An Exception was caught in the secondary Thread!", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    
                    }
                    // Adding binary data file on second thread to preserve the data.
                    public void FUNCTION_BYTE_DATA()throws IOException{

                        File bfile = new File("byteFile.dat");

                        if(bfile.exists()){

                            DataOutputStream byteFile = new DataOutputStream(new FileOutputStream(bfile, true));
                            int x = 0;
                            for(String S: element){
    
                                byteFile.writeUTF(element.get(x));
                                x++;
    
                            }

                        }
                        else{
                            DataOutputStream byteFile = new DataOutputStream(new FileOutputStream(bfile));
                            int x = 0;
                            for(String S: element){
    
                                byteFile.writeUTF(element.get(x));
                                x++;
    
                            }
                        }
                      

                    }


                }
                */




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
        FUNCTION_SET_DEFAULT_FILE();
        FUNCTION_LOAD_ELEMENTS();
        //new CLASS_MULTI_THREAD().start();
        new LAUNCH();
        
        
	}
        }

