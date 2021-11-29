import javax.swing.*;
import java.net.URI;
import java.awt.event.*;
import java.awt.Desktop.*;
import java.awt.*;
import java.io.*;

public class LINK{

    private JFrame frame = new JFrame();

    private JButton link1 = new JButton("AD Manager");
    private JButton link2= new JButton("Citrix Admin");
    private JButton link3= new JButton("Approved Software List");
    private JButton link4 = new JButton("Account creation");
    private JButton remote = new JButton("Remote Desktop");
    private JButton lync = new JButton("Skype");

    // Strings for links, will give access.

    private String linkS1;
    private String linkS2;
    private String linkS3;
    private String linkS4;

    public LINK(){
        // TODO Auto-generated method stub
        
    
        LINK_SET();
        frame.setSize(500,350);
        frame.setTitle("HOTLINKS");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(2,3));
        link1.addActionListener(new link11());
        link2.addActionListener(new link22());
        link3.addActionListener(new link33());
        link4.addActionListener(new link44());
        remote.addActionListener(new rdp());
        lync.addActionListener(new skype());
        frame.setResizable(false);
        frame.add(link1);
        frame.add(link2);
        frame.add(link3);
        frame.add(link4);
        frame.add(remote);
        frame.add(lync);
        frame.setVisible(true);
        

    }


    //Init String Links::

    public void LINK_SET(){

        linkS1 = "https://admpvwp01.loc.gov:9443/";
        linkS2 = "http://ctxadmvwp01/Director/LogOn.aspx?ReturnUrl=%2fDirector%2f&cc=true";
        linkS3 = "https://staff.loc.gov/wikis/pages/viewpage.action?spaceKey=EA&title=WCC+Approved+Software+List";
        linkS4 = "http://esevlp01.loc.gov/useraccounts/login";

    }

    public void LINK_SET_1(String linkset1){
        linkS1 = linkset1;
    }
    public void LINK_SET_2(String linkset2){
        linkS2 = linkset2;
    }
    public void LINK_SET_3(String linkset3){
        linkS3 = linkset3;
    }
    public void LINK_SET_4(String linkset4){
        linkS4 = linkset4;
    }





    private class link11 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                URI Ilink1 = new URI(linkS1);
                java.awt.Desktop.getDesktop().browse(Ilink1);
                JOptionPane.showMessageDialog(null, "AD Manager page", "Webpage Message", JOptionPane.OK_OPTION);
            }
            catch(Exception x){
                x.printStackTrace();
            }
        }
    }
    private class link22 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                URI Ilink2 = new URI(linkS2);
                java.awt.Desktop.getDesktop().browse(Ilink2);
                JOptionPane.showMessageDialog(null, "Citrix Administrator login", "Webpage Message", JOptionPane.OK_OPTION);
            }
            catch(Exception x){
                x.printStackTrace();
            }
        }
    }
    private class link33 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                URI Ilink3 = new URI(linkS3);
                java.awt.Desktop.getDesktop().browse(Ilink3);
                JOptionPane.showMessageDialog(null, "Approved software list!", "Webpage Message", JOptionPane.OK_OPTION);
            }
            catch(Exception x){
                x.printStackTrace();
            }
        }
    }
    private class link44 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                URI Ilink4 = new URI(linkS4);
                java.awt.Desktop.getDesktop().browse(Ilink4);
                JOptionPane.showMessageDialog(null, "Account Creation", "Webpage Message", JOptionPane.OK_OPTION);
            }
            catch(Exception x){
                x.printStackTrace();
            }
        }
    }

    private class rdp implements ActionListener{
        public void actionPerformed(ActionEvent e){



            Runtime runtime = Runtime.getRuntime();     //getting Runtime object
 
        try
        {
            runtime.exec("mstsc.exe");        //opens new RDP instance
 
            //OR runtime.exec("notepad");
        }
        catch (IOException d)
        {
            d.printStackTrace();
        }

        }
    }
    private class skype implements ActionListener{
        public void actionPerformed(ActionEvent e){


            String lync = "C:\\Program Files (x86)\\Microsoft Office\\Office16\\lync.exe";

            Runtime runtime = Runtime.getRuntime();     //getting Runtime object
 
        try
        {
            runtime.exec(lync);        //opens new SKYPE instance
 
        
        }
        catch (IOException d)
        {
            d.printStackTrace();
        }

        }
    }

}
