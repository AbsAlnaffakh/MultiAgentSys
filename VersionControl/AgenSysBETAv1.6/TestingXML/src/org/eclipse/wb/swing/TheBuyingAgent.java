package org.eclipse.wb.swing;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.wb.swing.CommClass;


public class TheBuyingAgent {
	
	private CommClass CreateFileUponRec = new CommClass();
	//private String ProductName ="";
	private MessageExchange HandleMessages = new MessageExchange();
	private static File f = new File("C:/Users/Aboudi's/Desktop/ToBuyingAgent.xml");
	
	
	/*
	 * 1. calls the calculate average function
	 * 2. Performs a recommendation and creates a new file
	 * 3. calls the function to deal with existing messages
	 * 4. All called within one method 
	 */
	
	
	public void InitialiseAndLaunch(){
		
		 try {
			 
			// this should calculate the average for all products
			 
				
			// this should loop independantly from any other statement	
			HandleMessages.MonitorReadRespondModify(f, "BuyingAgent");
			PerfromRecomendation();		
			
			
		 }	
		 catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	private void PerfromRecomendation() throws ParserConfigurationException, IOException{
		
		DBinteractions Execute = new DBinteractions();
		try{
		String stmnt = "SELECT ProductName FROM ToBeBoughtProducts  WHERE ProductStatus = 'True'";
		//ResultSet rs = s.executeQuery(stmnt); // execute a statement without returning anything
		ResultSet rs= Execute.ExecuteDBQuery(stmnt);
						
		while(rs.next())  {
			String ProductName = rs.getString("ProductName");
								
			String stmnt2 ="SELECT * From ToBeBoughtProductDetails WHERE ProductName = '"+ProductName+"'";//"+ProductName+"WII U WIFI
			ResultSet rs3= Execute.ExecuteDBQuery(stmnt2);
			
			String Source;
			float SourceRating;
			float ProductValue;
			boolean DeliveryAvailability;
			boolean StockAvailability;
			
			String ProductNameInRT;
			float SourceRatingInRT;
			float ProductValueInRT;
			boolean DeliveryAvailabilityInRT;
			boolean StockAvailabilityInRT;
			
			while(rs3.next()){
				// these are the values from the ProductDetailsTable
				Source= rs3.getString("Source");
				SourceRating= rs3.getFloat("SourceRating");
				ProductValue= rs3.getFloat("ProductValue");
				DeliveryAvailability= rs3.getBoolean("DeliveryAvailability");
				StockAvailability= rs3.getBoolean("StockAvailability");
				
																
				//if((ProductValue <= AverageValue )&&( SourceRating>= 2.5)&&(DeliveryAvailability=true)&&(StockAvailability=true)){  // defining the recommendation criteria
				if(( SourceRating>= 2.5)&&(DeliveryAvailability=true)&&(StockAvailability=true)){  // defining the recommendation criteria
					String stmnt3 ="SELECT * From RecommendedProducts WHERE ProductName = '"+ProductName+"' AND RecommendationType='ToBeBoughtProduct'";						
					ResultSet rs4 = Execute.ExecuteDBQuery(stmnt3);
					
					/*if(rs4.wasNull()){ // this is to be used to check whether the product exists within the DB or not, if not it adds it
						String stmnt5 ="INSERT INTO RecommendedProducts (ProductName, Source, SourceRating,ProductValue,DeliveryAvailability,StockAvailability) VALUES ('"+ProductName+"','"+Source+"','"+SourceRating+"','"+ProductValue+"','"+DeliveryAvailability+"','"+StockAvailability+"')";//"+ProductName+"WII U WIFI
						System.out.println("this should work");
						s5.execute(stmnt5);
						/ call the create file method
					}*/ // ask radi
					
					while(rs4.next()){
											
						ProductNameInRT= rs4.getString("ProductName");
						SourceRatingInRT= rs4.getFloat("SourceRating");
						ProductValueInRT= rs4.getFloat("ProductValue");
						DeliveryAvailabilityInRT= rs4.getBoolean("DeliveryAvailability");
						StockAvailabilityInRT= rs4.getBoolean("StockAvailability");
								
						System.out.println("penguin");
						System.out.println(ProductNameInRT);
						System.out.println(ProductValue);
						System.out.println(Source);
						System.out.println(SourceRating);
						System.out.println(DeliveryAvailability);
						System.out.println(StockAvailability); //keep for trouble shooting purpouses then delete it
														
						if((ProductValue < ProductValueInRT)&&(SourceRating>SourceRatingInRT)) {
							
							String stmnt4 ="INSERT INTO RecommendedProducts (ProductName,Source,SourceRating,ProductValue,DeliveryAvailability,StockAvailability,RecommendationType) VALUES ("+"'"+ProductName+"'"+", "+"'"+Source+"'"+" ,"+"'"+SourceRating+"'"+","+"'"+ProductValue+"'"+","+"'"+DeliveryAvailability+"'"+","+"'"+StockAvailability+"'"+", 'ToBeBoughtProduct')";
							Execute.ExecuteDBQueryNoReturn(stmnt4);
							//make "execute" a private class variable
							
							String StmntD = "DELETE FROM RecommendedProducts WHERE ProductValue='"+ProductValueInRT+"'";
							Execute.ExecuteDBQueryUpdate(StmntD);									
							// call the create file method
							// call this method upon making a recommendation
							CreateFileUponRec.CreateFile(ProductName, "ToSellingAgent");
							
						}// other comparison methods can be implemented by adding more if statements in priotorial order
						else if(!ProductName.equals(ProductNameInRT)){  /// ! not equal .equal(other) if its not in the DB then add it however it does not execute because of the first if statement
							String stmnt5 ="INSERT INTO RecommendedProducts (ProductName, Source, SourceRating,ProductValue,DeliveryAvailability,StockAvailability) VALUES ('"+ProductName+"','"+Source+"','"+SourceRating+"','"+ProductValue+"','"+DeliveryAvailability+"','"+StockAvailability+"')";
							Execute.ExecuteDBQueryNoReturn(stmnt5);	
							//call the create file method
							// call this method upon making a recommendation
							CreateFileUponRec.CreateFile(ProductName, "ToSellingAgent");
							
						}																
					}																		
				}												
			}					
		}	
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	

}
