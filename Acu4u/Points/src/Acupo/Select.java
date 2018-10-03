package Acupo;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {

	public Connection connect() {
	      
		
	        String url = "jdbc:sqlite:C:/sqlite33/db/acupointss.db";
	        Connection conn = null;
	        try {
	            conn = DriverManager.getConnection(url);
	            
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return conn;
	    }
	
	 public void selectAll(){
	        String sql = "SELECT Disease, P1 FROM Facepoints";
	        
	        try (Connection conn = this.connect();
	             Statement stmt  = conn.createStatement();
	             ResultSet rs    = stmt.executeQuery(sql)){
	            
	           
	            while (rs.next()) {
	                System.out.println(rs.getString("Disease") + "\t" +
	                                   rs.getString("P1"));
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	    
	public static void main(String[] args) {
		
		Select app = new Select();
        app.selectAll();
		

	}

}
