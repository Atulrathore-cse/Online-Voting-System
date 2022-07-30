import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Admin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 937, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Admin Area");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(346, 10, 302, 68);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 96, 903, 2);
		contentPane.add(separator);
		
		JButton btnNewButton = new JButton(" Add Voter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Addvoter newFrame= new Addvoter("Voter");
				newFrame.setVisible(true);	
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(128, 175, 196, 49);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1_1 = new JButton(" Display Voter List");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Voterslist newFrame= new Voterslist();
					newFrame.setVisible(true);
				
	        	
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_1.setBounds(128, 277, 196, 49);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnAddCandidate = new JButton(" Add Admin");
		btnAddCandidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Addvoter newFrame= new Addvoter("Admin");
				newFrame.setVisible(true);
			}
		});
		btnAddCandidate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddCandidate.setBounds(548, 175, 196, 49);
		contentPane.add(btnAddCandidate);
		
		JButton btnNewButton_1_1_1 = new JButton(" Display Admin List");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Adminlist newFrame= new Adminlist();
					newFrame.setVisible(true);
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_1_1.setBounds(548, 277, 196, 49);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_2 = new JButton("Check Poll Results");
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Results newFrame= new Results();
					newFrame.setVisible(true);
			}
		});
		btnNewButton_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_1_2.setBounds(346, 403, 196, 49);
		contentPane.add(btnNewButton_1_1_2);
		
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
		btnLogout.setBounds(753, 23, 136, 55);
		contentPane.add(btnLogout);
	}
}
