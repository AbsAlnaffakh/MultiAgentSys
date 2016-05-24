package org.eclipse.wb.swing;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.wb.swing.CommClass;


public class TheBuyingAgent {
	
	private CommClass CreateFileUponRec = new CommClass();
	private String ProductName ="";
	private MessageExchange HandleMessages = new MessageExchange();
	private static File f = new File("C:/Users/Aboudi's/Desktop/ToSellingAgent.xml");
	
	
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
			 
			 
			
			
			
			
		 }	
		 catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	private void PerfromRecomendation() throws ParserConfigurationException, IOException{
		
			
		
		
		// call this method upon making a recommendation
		CreateFileUponRec.CreateFile(ProductName, "ToSellingAgent");
		
	}
	
	
	
	

}
