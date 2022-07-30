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


public class Results extends JFrame {

	private JTable table;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Results frame = new Results();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Results() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 937, 536);
		String[] columnname= {"Party Name", "Votes"};
		Object[][] data= new Object[3][2];
		int i=0;
		File file=new File("Pollcount.txt");
		String winner="BJP";
	    Scanner myReader;
		try {
			myReader = new Scanner(file);
			while (myReader.hasNextLine()) {
		        String dat = myReader.nextLine();
		        String[] tokens=dat.split(" ");
		        data[0][1]=tokens[0];
		        data[1][1]=tokens[1];
		        data[2][1]=tokens[2];
		        i++;
		        data[0][0]="BJP";
				data[1][0]="INC";
				data[2][0]="AAP";
				if((Integer.parseInt(tokens[0])<Integer.parseInt(tokens[1])) && (Integer.parseInt(tokens[2])<Integer.parseInt(tokens[1])))winner="INC";
				if((Integer.parseInt(tokens[0])<Integer.parseInt(tokens[2])) && (Integer.parseInt(tokens[1])<Integer.parseInt(tokens[2])))winner="AAP";
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
		pane.setBounds(235, 265, 452, 83);
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
		
		JLabel lblNewLabel = new JLabel("Result!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(367, 30, 236, 52);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("The Winner is "+winner);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(285, 126, 568, 83);
		getContentPane().add(lblNewLabel_1);
		
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
		btnLogout.setBounds(755, 27, 136, 55);
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
