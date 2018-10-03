package Acupo;

//A program for multiple entries
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.lang.String;




		public class Comp {
			
			PreparedStatement pstmt = null;
			String sql;
			String n; int num=0,i;
			
			 public void disp(){
				 String url = "jdbc:sqlite:C:/sqlite33/db/acupointss.db";
			        Connection conn = null;
			        try {
			            conn = DriverManager.getConnection(url);
			            
			        } catch (SQLException e) {
			            System.out.println(e.getMessage());
			        }
			      
			        Scanner in= new Scanner(System.in);

				    System.out.printf("Please enter the number of symptoms: ");        
				    String[] input = new String[in.nextInt()];
				    in.nextLine(); //consuming the <enter> from input above

				    for (int i = 0; i < input.length; i++) {
				        input[i] = in.nextLine();
				    }
             try{
				    System.out.printf("\n output\n");
				    for (String n : input) {  
				   
			     sql = "SELECT * FROM Facepoints WHERE Disease ='"+n+"'";
				  
				     
				
				 
			             pstmt=conn.prepareStatement(sql);
			             ResultSet rs    = pstmt.executeQuery();
			            
			            
			            while (rs.next()) {
			                System.out.println(rs.getString("Disease") + "\t" +
			                                   rs.getString("P1"));
			            
			            }}
			        } catch (SQLException e) {
			            System.out.println(e.getMessage());
			        }
				    }
			
		            
			       	    
			
			

			public static void main(String[] args) {
				
		        Comp app= new Comp();
		          app.disp();
				
			}

		}
		
		

	


