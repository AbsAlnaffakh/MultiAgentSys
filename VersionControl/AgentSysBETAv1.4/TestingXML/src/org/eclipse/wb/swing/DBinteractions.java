package org.eclipse.wb.swing;

import java.sql.*;

public class DBinteractions {
	
	
	/*
	 * 1. A function that executes a SQL Statement returns a value
	 * 2. A Function that executes a SQL Statement and loops with a return value
	 * 3. A function that executes a SQL Statement an update statement required for delete operations
	 * 
	 * NOTE: connection and statement object are deliberatly not included as private class variables as they 
	 * 		 are meant to be local for each function
	 */
	final private String ucannaccessString = "jdbc:ucanaccess://h:/FYP/Implementation Files/Project Files/AgentsDataBase/AgentsDataBase.accdb";
	
	public ResultSet  ExecuteDBQuery(String SQLst){
		
		try{
			
			Connection conn =DriverManager.getConnection(ucannaccessString); // DB connection
			Statement s = conn.createStatement(); // declaring a statement object (from JDBC lib)
			ResultSet rs = s.executeQuery(SQLst); 
			
			return rs;
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
							
	}
	
	
	public ResultSet  ExecuteDBQueryMR(String SQLst){
		
		try{
			
			Connection conn =DriverManager.getConnection(ucannaccessString); // DB connection
			Statement s = conn.createStatement(); // declaring a statement object (from JDBC lib)
			ResultSet rs = s.executeQuery(SQLst); 
			rs.isBeforeFirst();
			while(rs.next()){return rs;}
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return null;
		
							
	}
	
	public void ExecuteDBQueryNoReturn(String SQLst){
				
		try{
			Connection conn =DriverManager.getConnection(ucannaccessString); // DB connection
			Statement s = conn.createStatement(); // declaring a statement object (from JDBC lib)
			s.executeUpdate(SQLst); // execute a statement without returning anything
			s.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void ExecuteDBQueryUpdate(String SQLst){
		
		try{
			Connection conn =DriverManager.getConnection(ucannaccessString); // DB connection
			Statement s = conn.createStatement(); // declaring a statement object (from JDBC lib)
			s.executeUpdate(SQLst);
			s.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

}
