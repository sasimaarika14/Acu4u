package Acupo;

//A program for multiple entries
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.lang.String;
import java.lang.Iterable;





		public class test {
			private ArrayList<String> namen = new ArrayList<>();
			
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
			             
			            int h=0;
			            while (rs.next()) {
			                System.out.println(rs.getString("Disease"));
			                for(h=2;h<=5;h++)
			            namen.add(rs.getString(h));
			                for(String display:namen)
			                {
			                	System.out.println(display);
			                }
			                namen.removeAll(Collections.singleton(null));
			                Set<String> unique = new HashSet<String>(namen);
			                for (String key : unique) {
			                    System.out.println(key + ": " + Collections.frequency(namen, key));
			                }
			                
			                String mrw
			                = namen.stream()
			                      .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
			                      .entrySet()
			                      .stream()
			                      .max(Comparator.comparing(Entry::getValue))
			                      .get()
			                      .getKey();
			                System.out.println("The best acupoint is "+mrw);
					       
			            }}
			        } catch (SQLException e) {
			            System.out.println(e.getMessage());
			        }
				    }
			
		            
			       	    
			
			

			public static void main(String[] args) {
				
		        test app= new test();
		          app.disp();
				
			}

		}
		
		

	


