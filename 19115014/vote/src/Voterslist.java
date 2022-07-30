import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Voterslist extends JFrame {

	private JTable table;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Voterslist frame = new Voterslist();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Voterslist() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 937, 536);
		String[] columnname= {"VoterId", "Username", "Mobile Number"};
		Object[][] data= new Object[100][3];
		int i=0;
		File file=new File("Voterlist.txt");
	    Scanner myReader;
		try {
			myReader = new Scanner(file);
			while (myReader.hasNextLine()) {
		        String dat = myReader.nextLine();
		        String[] tokens=dat.split(" ");
		        data[i][0]=tokens[0];
		        data[i][1]=tokens[1]+" "+tokens[2];
		        data[i][2]=tokens[3];
		        i++;
		     }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getContentPane().setLayout(null);
		table = new JTable(data,columnname) {
			public boolean isCellEditable(int data,int column) {
				return false;
			}
		};
		table.setBounds(33, 96, 822, 350);
		JScrollPane pane=new JScrollPane(table);
		pane.setBorder(UIManager.getBorder("InternalFrame.border"));
		pane.setBounds(40, 80, 853, 402);
		getContentPane().add(pane); 
		setCellsAlignment(table, SwingConstants.CENTER);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Admin newFrame = new Admin();
				newFrame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 10, 99, 33);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Voters List");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(361, 30, 236, 40);
		getContentPane().add(lblNewLabel);
		
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
		btnLogout.setBounds(764, 10, 136, 55);
		getContentPane().add(btnLogout);
	}
	
	    public static void setCellsAlignment(JTable table, int alignment)
	    {
	        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
	        rightRenderer.setHorizontalAlignment(alignment);

	        TableModel tableModel = table.getModel();

	        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
	        {
	            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
	        }
	    }
	
}
