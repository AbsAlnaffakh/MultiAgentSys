package org.eclipse.wb.swing;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Agents {
	
	
	/*
	 * 1. calculates the average of a product value of a set of products
	 *  	 */

	//The agent which the average is going to be calculated for
	public void CalculateAverageValue() throws SQLException{  // calculates the average for each product in the DB
	
		DBinteractions Execute = new DBinteractions(); // a new insance to allow for use of methods
			
		String stmnt = "SELECT ProductName FROM ToBeBoughtProducts  WHERE ProductStatus = 'True'";
		ResultSet rs = Execute.ExecuteDBQuery(stmnt); // returns and store the results
		
		float[] Value = new float[10]; // to store the 
		float AverageValue=0; // to hold the average value
		float cumulative = 0; // stores the cumulative of value
		int i=0; // incrementer to keep track of values
		
		while(rs.next()){
			String ProductName = rs.getString("ProductName");
			//System.out.println(ProductName);// it works so far
			
			String stmnt2 ="SELECT ProductValue From ToBeBoughtProductDetails WHERE ProductName = '"+ProductName+"'";//"+ProductName+"WII U WIFI
			ResultSet rs2 = Execute.ExecuteDBQuery(stmnt2);
			
			while(rs2.next()){
				float ProductValue = rs2.getFloat("ProductValue");
				//System.out.println("ProductValue var  = " +ProductValue);
				Value[i] = ProductValue;
				cumulative = cumulative+ Value[i];
				++i;				
				AverageValue= cumulative/i;
				//System.out.println("AverageValue =   "+AverageValue);
				//System.out.println(i);
			}
													
		}		
	}
	
	
	
	
	
	
	
	
}




