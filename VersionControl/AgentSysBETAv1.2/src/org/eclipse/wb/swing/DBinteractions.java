package org.eclipse.wb.swing;

import java.sql.*;

public class DBinteractions {
	
	
	/*
	 * 1. 
	 * 
	 * 
	 * 
	 */
	final private String ucannaccessString = "jdbc:ucanaccess://h:/FYP/Implementation Files/Project Files/AgentsDataBase/AgentsDataBase.accdb";
	
	public ResultSet  ExecuteDBQuery(String SQLst){
		
		try{
			
			Connection conn =DriverManager.getConnection(ucannaccessString); // DB connection
			Statement s = conn.createStatement(); // declaring a statement object (from JDBC lib)
			ResultSet rs = s.executeQuery(SQLst); // execute a statement without returning anything
			return rs;
			//s.close();// might not be needed
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
							
	}
	
	public void ExecuteDBQueryNoReturn(String SQLst){
				
		try{
			Connection conn =DriverManager.getConnection(ucannaccessString); // DB connection
			Statement s = conn.createStatement(); // declaring a statement object (from JDBC lib)
			s.execute(SQLst); // execute a statement without returning anything
			s.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

}
