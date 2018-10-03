package Acupo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Table {
	
	public static void createNewTable() {
		 String url = "jdbc:sqlite:C:/sqlite33/db/acupointss.db";
		 
		 String sql ="CREATE TABLE Facepoints " +
				 "(Disease TEXT PRIMARY KEY," +
				 " P1 TEXT NOT NULL, " +
                    " P2 TEXT) " ;
		 
		 try { Connection conn = DriverManager.getConnection(url);
	                Statement stmt = conn.createStatement(); 
	            
	            stmt.execute(sql);
	            System.out.println("Table Created");
	            
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	

	public static void main(String[] args) {
		createNewTable();
		
	}

}
