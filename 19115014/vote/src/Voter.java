import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Voter extends JFrame {

	private JPanel contentPane; 
	ImageIcon icon1=new ImageIcon("BJP.png");
	ImageIcon icon2=new ImageIcon("inc.png");
	ImageIcon icon3=new ImageIcon("aap.png");
	 String[] tokens;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Voter frame = new Voter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void edit(int i) {
		PrintWriter writer;
		try {
			writer = new PrintWriter("Pollcount.txt");
			writer.print("");
			writer.close();
			int j=Integer.parseInt(tokens[i]);
			j++;
			tokens[i]=String.valueOf(j); 
			File file = new File("Pollcount.txt");
			FileWriter fr = new FileWriter(file, true);
			BufferedWriter br = new BufferedWriter(fr);
			br.write(tokens[0]+" "+tokens[1]+" "+tokens[2]);
			br.close();
			fr.close();	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

	/**
	 * Create the frame.
	 */
	public Voter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 937, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		try {
			File myObj;
		    myObj=new File("Pollcount.txt");
		    Scanner myReader = new Scanner(myObj);
		    while(myReader.hasNextLine()) {
		    String data = myReader.nextLine();
		    tokens=data.split(" ");
		    }
			}catch (FileNotFoundException e1) {
			      System.out.println("An error occurred.");
			      e1.printStackTrace();
			}
		
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 75, 903, 2);
		contentPane.add(separator);
		
		JLabel lblCastYourVote = new JLabel("Cast Your Vote");
		lblCastYourVote.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblCastYourVote.setBounds(314, 0, 388, 68);
		contentPane.add(lblCastYourVote);
		
		JLabel lblNewLabel = new JLabel(icon1);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setText("");
		lblNewLabel.setBounds(54, 142, 178, 124);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(icon2);
		lblNewLabel_1.setBounds(314, 124, 178, 159);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(icon3);
		lblNewLabel_2.setBounds(609, 162, 178, 104);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Vote");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int reply = JOptionPane.showConfirmDialog(null,"Do you want to vote BJP?","Confirm",JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					edit(0);
					dispose();
					Confirm newFrame = new Confirm();
		        	newFrame.setVisible(true);
				}	
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton.setBounds(82, 334, 123, 42);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Vote");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int reply = JOptionPane.showConfirmDialog(null,"Do you want to vote INC?","Confirm",JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					edit(1);
					dispose();
					Confirm newFrame = new Confirm();
		        	newFrame.setVisible(true);
				} else {
				    
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton_1.setBounds(348, 334, 123, 42);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Vote");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int reply = JOptionPane.showConfirmDialog(null,"Do you want to vote AAP?","Confirm",JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					edit(2);
					dispose();
					Confirm newFrame = new Confirm();
		        	newFrame.setVisible(true);
		        	
				} else {
				    
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton_1_1.setBounds(639, 334, 123, 42);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("Narendra Modi");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(97, 276, 108, 31);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Rahul Gandhi");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_1.setBounds(363, 276, 108, 31);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Arvind Kejriwal");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_2.setBounds(654, 276, 108, 31);
		contentPane.add(lblNewLabel_3_2);
		
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
		btnLogout.setBounds(762, 10, 136, 55);
		contentPane.add(btnLogout);
	    
	}
}
