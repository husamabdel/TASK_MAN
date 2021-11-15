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
 
    public LINK(){
        // TODO Auto-generated method stub
        
    

        frame.setSize(500,350);
        frame.setTitle("HOTLINKS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

    private class link11 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                URI Ilink = new URI("https://admpvwp01.loc.gov:9443/");
                java.awt.Desktop.getDesktop().browse(Ilink);
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
                URI Ilink = new URI("http://ctxadmvwp01/Director/LogOn.aspx?ReturnUrl=%2fDirector%2f&cc=true");
                java.awt.Desktop.getDesktop().browse(Ilink);
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
                URI Ilink = new URI("https://staff.loc.gov/wikis/pages/viewpage.action?spaceKey=EA&title=WCC+Approved+Software+List");
                java.awt.Desktop.getDesktop().browse(Ilink);
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
                URI Ilink = new URI("http://esevlp01.loc.gov/useraccounts/login");
                java.awt.Desktop.getDesktop().browse(Ilink);
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
