import java.util.Scanner;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.net.URI;
import java.awt.BorderLayout;
import java.awt.event.*;
public class LAUNCH extends JFrame{

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
	
	
	
	public LAUNCH() {
		
		this.setTitle("Ticket Logger MIL");
		this.setSize(width,height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setVisible(true);
		
		
}
	
	public void launcher() {
		
		page = new JButton("New Ticket!");
		page.addActionListener(new thebuttonListener());
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
	}
	
	private class thebuttonListener implements ActionListener{

		public void actionPerformed(ActionEvent e){


			try{
			URI link = new URI("https://loc.servicenowservices.com");


			java.awt.Desktop.getDesktop().browse(link);
			JOptionPane.showMessageDialog(null, "New Ticket Page launched!", "Webpage Message", JOptionPane.ERROR_MESSAGE);

		}
			catch(Exception d){
				d.printStackTrace();
			}

		}

	}
	
	
	
	
	
	
	public static void main(String[] args) {
		

	}

}
