import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class frame2 extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame2 window = new frame2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frame2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 937, 536);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(159, 170, 153, 68);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPassword.setBounds(159, 229, 153, 78);
		frame.getContentPane().add(lblPassword);
		
		String s1[]= {"Voter","Admin"};
		JComboBox comboBox = new JComboBox(s1);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setBounds(322, 104, 329, 48);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password=passwordField.getText();
				String username=textField.getText();
				String number=textField_1.getText();
				String selected=(String) comboBox.getItemAt(comboBox.getSelectedIndex());
				try {
				      File myObj;
				      if(selected=="Admin") {
				    	  myObj=new File("Adminlist.txt");
				      }
				      else {
				    	  myObj= new File("Voterlist.txt");
				      }
				      Scanner myReader = new Scanner(myObj);
				      boolean got=false;
				      while (myReader.hasNextLine()) {
				        String data = myReader.nextLine();
				        String[] tokens=data.split(" ");
				        if(username.contains(tokens[1]+" "+tokens[2]) && password.contains(tokens[0]) && number.contains(tokens[3])) {
				        	JOptionPane.showMessageDialog(null,"Logged in successfully!");
				        	got=true;
				        	frame.dispose();
				        	if(selected=="Admin") {
				        		Admin newFrame = new Admin();
					        	newFrame.setVisible(true);
				        	}
				        	else {	
				        		Voter newFrame = new Voter();
					        	newFrame.setVisible(true);	
				        	}
				        	break;
				        }
				
				      }
				      if(!got) {
				    	  JOptionPane.showMessageDialog(null,"Invalid Login Details","Login Error",JOptionPane.ERROR_MESSAGE);
				    	  textField.setText(null);
				    	  passwordField.setText(null);
				    	  textField_1.setText(null);
				      }
				      myReader.close();
				    } catch (FileNotFoundException e1) {
				      System.out.println("An error occurred.");
				      e1.printStackTrace();
				    }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(103, 416, 123, 48);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				passwordField.setText(null);
				textField_1.setText(null);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(377, 416, 123, 51);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(391, 0, 252, 70);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_1_1 = new JButton("Exit");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frmLoginSystem = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if you want to exit","Login Systems",
				JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_1.setBounds(687, 413, 123, 51);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(45, 384, 818, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(45, 80, 818, 2);
		frame.getContentPane().add(separator_1);
		
		textField = new JTextField();
		textField.setBounds(322, 191, 326, 38);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(322, 252, 326, 43);
		frame.getContentPane().add(passwordField);
		
		JLabel lblLoginAs = new JLabel("Login As");
		lblLoginAs.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblLoginAs.setBounds(159, 92, 153, 68);
		frame.getContentPane().add(lblLoginAs);
		
		JLabel lblRegisteredMobineNumber = new JLabel("Mobile Number");
		lblRegisteredMobineNumber.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblRegisteredMobineNumber.setBounds(133, 297, 179, 78);
		frame.getContentPane().add(lblRegisteredMobineNumber);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(322, 323, 326, 38);
		frame.getContentPane().add(textField_1);
	} 
}


