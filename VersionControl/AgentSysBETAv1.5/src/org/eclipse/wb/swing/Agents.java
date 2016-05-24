package org.eclipse.wb.swing;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Agents {
	
	
	/*
	 * 1. calculates the average of a product value of a set of products
	 *  
	 */

	//calculates the averae value of all products within the DB
	public void CalculateAverageValue() throws SQLException{  // calculates the average for each product in the DB
	
		DBinteractions Execute = new DBinteractions();
				
		String stmnt = "SELECT ProductName FROM ToBeBoughtProducts  WHERE ProductStatus = 'True'";// Identifies which product to calculate the average for
				
		ResultSet rs = Execute.ExecuteDBQuery(stmnt);
		
		float[] Value = new float[10]; // holds each price value extracted from the DB // it would be better to use a vector
		float AverageValue=0; //holds the average value
		float cumulative = 0; // used to calculate the average
		int i=0; // just an itterator
		
		while(rs.next()){
			String ProductName = rs.getString("ProductName");
						
			String stmnt2 ="SELECT ProductValue From ToBeBoughtProductDetails WHERE ProductName = '"+ProductName+"'"; // retrieves the value
			ResultSet rs2 = Execute.ExecuteDBQuery(stmnt2);
			
			while(rs2.next()){ // an embedded loop that calculates the average based on all products that have the same name
				float ProductValue = rs2.getFloat("ProductValue"); //Extracts data from the product value coloumns
				Value[i] = ProductValue;
				cumulative = cumulative+ Value[i];
				++i;
				AverageValue= cumulative/i;
				
			}													
		}						
	}	
}
