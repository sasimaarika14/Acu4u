package Acupo;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;




public class Framee {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblEnterTheDisease;
	public static Connection conn= null;
	PreparedStatement pstmt = null;
	String sql;String disease, ipoint;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Framee window = new Framee();
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
	public Framee() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String d= textField.getText();
				
				 sql = "SELECT Disease, P1 FROM Facepoints WHERE Disease= \""+d+"\"";
				 System.out.println(sql);
				 try
				 { 
						Class.forName("org.sqlite.JDBC");
					    System.out.println("Line 1");
						Connection conn=DriverManager.getConnection("jdbc:sqlite:C:/sqlite33/db/acupointss.db");
						System.out.println("Line 2");
		            if(conn!=null){
	             pstmt=conn.prepareStatement(sql);
		            
	             ResultSet rs    = pstmt.executeQuery();
		            
	             
		            while (rs.next()) {
		            	 disease= rs.getString("Disease");
	                    ipoint=  rs.getString("P1");
	                    System.out.println(disease+"   "+ipoint);
		            }
		            }
		            else{
		            	JOptionPane.showMessageDialog(frame, "Error in Connection");
		            }
		          }
			
	             catch (SQLException e) {
	 	            //System.out.println(e.getMessage());
						JOptionPane.showMessageDialog(null,"Enter the disease is not available");
	 	        } catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(disease==null && ipoint==null){

				}
				else{
					JOptionPane.showMessageDialog(null, disease+"   "+ipoint);
				}
			}
		});
		btnEnter.setBounds(158, 159, 89, 23);
		frame.getContentPane().add(btnEnter);
		
		textField = new JTextField();
		textField.setBounds(124, 52, 179, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblEnterTheDisease = new JLabel("Enter the Disease");
		 
		lblEnterTheDisease.setBounds(158, 21, 102, 14);
		frame.getContentPane().add(lblEnterTheDisease);
	
	}

}
