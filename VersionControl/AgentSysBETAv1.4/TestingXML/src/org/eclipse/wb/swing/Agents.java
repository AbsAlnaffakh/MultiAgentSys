package org.eclipse.wb.swing;

public class Agents {
	
	
	/*
	 * 1. calculates the average of a product value of a set of products
	 *  
	 */

	//The agent which the average is going to be calculated for
	public void CalculateAverageValue(){
		
		
	/////calculate average//////////////////
		/*final String ucannaccessString = "jdbc:ucanaccess://h:/FYP/Implementation Files/Project Files/AgentsDataBase/AgentsDataBase.accdb";
		Connection conn=DriverManager.getConnection(ucannaccessString); // DB connection
		Statement s = conn.createStatement(); // declaring a statement object (from JDBC lib)
		String stmnt = "SELECT ProductName FROM ToBeBoughtProducts  WHERE ProductStatus = 'True'";
		ResultSet rs = s.executeQuery(stmnt); // execute a statement without returning anything
		
		
		Connection conn1=DriverManager.getConnection(ucannaccessString); // DB connection
		Statement s1 = conn1.createStatement(); // declaring a statement object (from JDBC lib)
		
		Connection conn2=DriverManager.getConnection(ucannaccessString); // DB connection
		Statement s2 = conn2.createStatement(); // declaring a statement object (from JDBC lib)
		
		
		float[] Value = new float[10];
		float AverageValue=0;
		float cumulative = 0;
		int i=0;
		int test=0;
		
		while(rs.next()){
			String ProductName = rs.getString("ProductName");
			//System.out.println(ProductName);// it works so far
			
			String stmnt2 ="SELECT ProductValue From ToBeBoughtProductDetails WHERE ProductName = '"+ProductName+"'";//"+ProductName+"WII U WIFI
			ResultSet rs2 = s1.executeQuery(stmnt2);
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
		
		//System.out.println("AverageValue outside while =   "+AverageValue);
			
		*/
	}
	
	
	
	
	
	
	
	
}




