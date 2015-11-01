package br.sgm.conexao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StartBD {

	
	@SuppressWarnings("resource")
	public static void executeSqlScript(Connection conn) {  
		  
	    // Delimiter  
	    String delimiter = ";";  
	  
	    InputStream input = StartBD.class.getClass().getResourceAsStream("/SCRIPT.sql");
	    
	    // Create scanner  
	    Scanner scanner;  
	    
	    scanner = new Scanner(input).useDelimiter(delimiter);  
	    
	    // Loop through the SQL file statements   
	    Statement currentStatement = null;  
	    while(scanner.hasNext()) {  
	  
	        // Get statement   
	        String rawStatement = scanner.next() + delimiter;
	        try {  
	            // Execute statement  
	            currentStatement = conn.createStatement();  
	            currentStatement.execute(rawStatement);  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        } finally {  
	            // Release resources  
	            if (currentStatement != null) {  
	                try {  
	                    currentStatement.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	            currentStatement = null;  
	        }  
	    }  
	}  
}
