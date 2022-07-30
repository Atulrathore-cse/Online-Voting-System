import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;

public class Addvoter extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addvoter frame = new Addvoter("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Addvoter(String s) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 937, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Admin newFrame = new Admin();
				newFrame.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(10, 21, 99, 33);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(173, 121, 153, 68);
		contentPane.add(lblNewLabel);
		
		JLabel lblVoterid = new JLabel(s+" Id");
		lblVoterid.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblVoterid.setBounds(157, 199, 153, 78);
		contentPane.add(lblVoterid);
		
		JLabel lblRegisteredMobineNumber = new JLabel("Mobile Number");
		lblRegisteredMobineNumber.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblRegisteredMobineNumber.setBounds(147, 281, 179, 78);
		contentPane.add(lblRegisteredMobineNumber);
		
		JLabel lblAddVoter = new JLabel("Add "+s);
		lblAddVoter.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblAddVoter.setBounds(366, 43, 236, 40);
		contentPane.add(lblAddVoter);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(401, 142, 326, 47);
		contentPane.add(textField);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 91, 903, 9);
		contentPane.add(separator);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(401, 298, 326, 47);
		contentPane.add(textField_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 394, 903, 2);
		contentPane.add(separator_1);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Confirm if you want to add","Confirmation Message",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					Writer output;
					try {
						if(s=="Admin") {
						output = new BufferedWriter(new FileWriter("Adminlist.txt", true));
						}
						else {
							output = new BufferedWriter(new FileWriter("Voterlist.txt", true));
						}
						output.append("\n"+textField_2.getText()+" "+textField.getText()+" "+textField_1.getText());
						output.close();
					} catch (IOException e2) {
						e2.printStackTrace();
					}
					dispose();
					Admin newFrame = new Admin();
					newFrame.setVisible(true);
					
				}	
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnNewButton.setBounds(376, 428, 160, 50);
		contentPane.add(btnNewButton);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(401, 218, 326, 47);
		contentPane.add(textField_2);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int reply = JOptionPane.showConfirmDialog(null,"Do you want to logout?","Confirm",JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					dispose();
					frame2 nw=new frame2();
					String z[]= {"x"};
					nw.main(z);
				} else {
				    
				}
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnLogout.setBounds(761, 31, 136, 55);
		contentPane.add(btnLogout);
	}
}
