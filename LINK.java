import javax.swing.*;
import java.net.URI;
import java.awt.event.*;
import java.awt.Desktop.*;
import java.awt.*;

public class LINK{

    private JFrame frame = new JFrame();

    private JButton link1 = new JButton("AD Manager");
    private JButton link2= new JButton("Citrix Admin");
    private JButton link3= new JButton("Approved Software List");
    private JButton link4 = new JButton("Account creation");

 
    public LINK(){
        // TODO Auto-generated method stub
        
    

        frame.setSize(500,350);
        frame.setTitle("HOTLINKS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2,2));
        link1.addActionListener(new link11());
        link2.addActionListener(new link22());
        link3.addActionListener(new link33());
        link4.addActionListener(new link44());
        frame.setResizable(false);
        frame.add(link1);
        frame.add(link2);
        frame.add(link3);
        frame.add(link4);
        frame.setVisible(true);
        

    }

    private class link11 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                URI Ilink = new URI("https://admpvwp01.loc.gov:9443/");
                java.awt.Desktop.getDesktop().browse(Ilink);
                JOptionPane.showMessageDialog(null, "All Assigned tickets!", "Webpage Message", JOptionPane.OK_OPTION);
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
                JOptionPane.showMessageDialog(null, "All Assigned tickets!", "Webpage Message", JOptionPane.OK_OPTION);
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
                JOptionPane.showMessageDialog(null, "All Assigned tickets!", "Webpage Message", JOptionPane.OK_OPTION);
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
                JOptionPane.showMessageDialog(null, "All Assigned tickets!", "Webpage Message", JOptionPane.OK_OPTION);
            }
            catch(Exception x){
                x.printStackTrace();
            }
        }
    }


}