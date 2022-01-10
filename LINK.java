import javax.swing.*;
import java.net.URI;
import java.awt.event.*;
import java.awt.Desktop.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class LINK{

    private JFrame frame = new JFrame();

    private JButton link1 = new JButton();
    private JButton link2= new JButton();
    private JButton link3= new JButton();
    private JButton link4 = new JButton();
    private JButton remote = new JButton();
    private JButton lync = new JButton();
    private ArrayList <String> linkbutton = new ArrayList<>();

    // Strings for links, will give access.

    private String linkS1;
    private String linkS2;
    private String linkS3;
    private String linkS4;


    //default constructor
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


    //setup constructor.
    public LINK(boolean flag) throws IOException{

        SETUP();
        initData();
        frame.setSize(500,350);
        frame.setTitle("HOTLINKS");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(2,3));
        
        link1.setName(linkbutton.get(4));
        link1.addActionListener(new link111());
        
        link2.setName(linkbutton.get(5));
        link2.addActionListener(new link222());
        
        link3.setName(linkbutton.get(6));
        link3.addActionListener(new link333());
        
        link4.setName(linkbutton.get(7));
        link4.addActionListener(new link444());

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
    // Post custom setup constructor.
    public LINK(String flag2) throws FileNotFoundException{

        if(flag2.equals("true")){


            initData();
            frame.setSize(500,350);
            frame.setTitle("HOTLINKS");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLayout(new GridLayout(2,3));
            
            link1.setName(linkbutton.get(4));
            link1.addActionListener(new link111());
            
            link2.setName(linkbutton.get(5));
            link2.addActionListener(new link222());
            
            link3.setName(linkbutton.get(6));
            link3.addActionListener(new link333());
            
            link4.setName(linkbutton.get(7));
            link4.addActionListener(new link444());
    
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

    }


    public void SETUP() throws IOException{

        JOptionPane.showMessageDialog(null, "now, we will go ahead and setup the links", "SETUP", JOptionPane.OK_OPTION);
        JOptionPane.showMessageDialog(null, "When prompted, please paste the links in the dialog box", "SETUP", JOptionPane.OK_OPTION);
        String linknum1 = JOptionPane.showInputDialog("Please enter the first link:");
        String name1 = JOptionPane.showInputDialog("Please enter the link name:");

        String linknum2 = JOptionPane.showInputDialog("Please enter the first link:");
        String name2 = JOptionPane.showInputDialog("Please enter the link name:");

        String linknum3 = JOptionPane.showInputDialog("Please enter the first link:");
        String name3 = JOptionPane.showInputDialog("Please enter the link name:");

        String linknum4 = JOptionPane.showInputDialog("Please enter the first link:");
        String name4 = JOptionPane.showInputDialog("Please enter the link name:");

        SD_MIL IO = new SD_MIL();

        IO.fileStart(linknum1, "LINKS.txt");

        IO.fileOpen("LINKS.txt", linknum2);
        IO.fileOpen("LINKS.txt", linknum3);
        IO.fileOpen("LINKS.txt", linknum4);

        IO.fileOpen("LINKS.txt", name2);
        IO.fileOpen("LINKS.txt", name2);
        IO.fileOpen("LINKS.txt", name3);
        IO.fileOpen("LINKS.txt", name4);
        

    }

    //call first in the Init.
    public void initData() throws FileNotFoundException{

        File file = new File("LINKS.txt");
        Scanner input = new Scanner(file);

        while(input.hasNextLine()){
            linkbutton.add(input.nextLine());
        }



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

///////////////////////////////////////////////
//
//
//
//              ##SETUP ACTION LISTENERS::
//
//
//
///////////////////////////////////////////////

private class link111 implements ActionListener{
    public void actionPerformed(ActionEvent e){
        try{
            URI Ilink1 = new URI(linkbutton.get(0));
            java.awt.Desktop.getDesktop().browse(Ilink1);
            JOptionPane.showMessageDialog(null, "AD Manager page", "Webpage Message", JOptionPane.OK_OPTION);
        }
        catch(Exception x){
            x.printStackTrace();
        }
    }
}
private class link222 implements ActionListener{
    public void actionPerformed(ActionEvent e){
        try{
            URI Ilink2 = new URI(linkbutton.get(1));
            java.awt.Desktop.getDesktop().browse(Ilink2);
            JOptionPane.showMessageDialog(null, "Citrix Administrator login", "Webpage Message", JOptionPane.OK_OPTION);
        }
        catch(Exception x){
            x.printStackTrace();
        }
    }
}
private class link333 implements ActionListener{
    public void actionPerformed(ActionEvent e){
        try{
            URI Ilink3 = new URI(linkbutton.get(2));
            java.awt.Desktop.getDesktop().browse(Ilink3);
            JOptionPane.showMessageDialog(null, "Approved software list!", "Webpage Message", JOptionPane.OK_OPTION);
        }
        catch(Exception x){
            x.printStackTrace();
        }
    }
}
private class link444 implements ActionListener{
    public void actionPerformed(ActionEvent e){
        try{
            URI Ilink4 = new URI(linkbutton.get(3));
            java.awt.Desktop.getDesktop().browse(Ilink4);
            JOptionPane.showMessageDialog(null, "Account Creation", "Webpage Message", JOptionPane.OK_OPTION);
        }
        catch(Exception x){
            x.printStackTrace();
        }
    }
}





////////////////////////////////////////////
//
//      ##DEFAULT APPS::
//
/////////////////////////////////////////////

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
