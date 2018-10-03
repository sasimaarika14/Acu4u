package Acupo;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import java.lang.String;



public class UInput {
	Scanner input= new Scanner(System.in);
	PreparedStatement pstmt = null;
	String sql;
	
	public Connection c() {
		
		 String url = "jdbc:sqlite:C:/sqlite33/db/acupointss.db";
	        Connection conn = null;
	        try {
	            conn = DriverManager.getConnection(url);
	            
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	      

		    System.out.println("Enter the disease\n");
		    String n= input.nextLine();
		    	   
		    sql = "SELECT * FROM Facepoints WHERE Disease ='"+n+"'";
		    
		    return conn; 
	       	    }
	
	 public void disp(){
		     
		 try {Connection conn = this.c();
	            
	             pstmt=conn.prepareStatement(sql);
	             ResultSet rs    = pstmt.executeQuery();
	            
	           
	            while (rs.next()) {
	                System.out.println(rs.getString("Disease") + "\t" +
	                                   rs.getString("P1"));
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }

	public static void main(String[] args) {
		
          UInput app= new UInput();
          app.disp();
		
	}

}
