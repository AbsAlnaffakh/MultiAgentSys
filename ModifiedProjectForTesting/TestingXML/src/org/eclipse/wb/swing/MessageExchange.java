package org.eclipse.wb.swing;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.eclipse.wb.swing.CommClass;

public class MessageExchange {
	
	
	/*
	 * This class should inherit from the CommsClass
	 * 1. A function that reads and responds to file contents
	 * 	    - Checks if it should delete it
	 * 		- Checks if it exists
	 * 		- Gets the tag contents
	 * 		- Acts upon contents 
	 */
	//File f = new File("C:/Users/Aboudi's/Desktop/ToSellingAgent.xml");
	
	
	//parameters(name and directory of the file you want the agent to read,the name of this agent)
	public void MonitorReadRespondModify(File f, String AgentName) throws ParserConfigurationException, SAXException, IOException{
		
	if(!f.getName().contains(AgentName)){ // if it does not contain the name then it must be the sender, incharge of deleting when read
		// then check if the file is read, if its is delete if it is not then do nothing
		CommClass CheckIfItIsRead = new CommClass();
		CheckIfItIsRead.DeleteFileWhenRead(f);
	}	
	else if(f.exists() && !f.isDirectory()) { 
				
		String ProductNameInFile=""; // to hold the value stored within the value tag
	    String CommStatusInFile=""; // to hold the value stored within the CommStatus tag
				
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(f); // "C:/Users/Aboudi's/Desktop/ToSellingAgent.xml" //not needed use f instead
	
		NodeList list = doc.getElementsByTagName("CommValue");
		NodeList list2 = doc.getElementsByTagName("CommStatus");
		
						
		for (int i = 0; i < list.getLength(); i++) {
			Element item = (Element)list.item(i);
			Element item2 = (Element)list2.item(i);
						
			//System.out.print(((Node) item).getFirstChild().getNodeValue());
			ProductNameInFile = (((Node) item).getFirstChild().getNodeValue());
			CommStatusInFile=(((Node) item2).getFirstChild().getNodeValue());;
			
			String SalesTable ="ToBeSoldProducts";
			String BuyingTable="ToBeBoughtProducts";
			String VariableNeutral ="";
			
			if(f.getName().contains("Buying")){
				VariableNeutral = SalesTable;
			}else if(f.getName().contains("Buying")){
				VariableNeutral = BuyingTable;				
			}
				
			
			if(CommStatusInFile.equals("Read")){ // if the tag within the file is read then dont add it
				break;
			}
			else{ //// if the tag within the file is not read then add it 
			//String stmnt40 = "INSERT INTO "+VariableNeutral+" "+" "+" (ProductName, ProductStatus) VALUES ("+"'"+ProductNameInFile+"'"+", 'True')";
			String stmnt40 = "INSERT INTO ToBeBoughtProducts (ProductName, ProductStatus) VALUES ("+"'"+ProductNameInFile+"'"+", 'True')"; // this line should only be used for testing
			DBinteractions UpdateFileContentstoDB = new DBinteractions();
			UpdateFileContentstoDB.ExecuteDBQueryNoReturn(stmnt40);
			// then change the tag value by calling the modify
					
					CommClass ModifyIt = new CommClass();
					ModifyIt.MarkMessageAsRead(f);
			}
							
		}					
	}
	else {
		System.out.println("does not exist exists");
	}
	
	
	
	
}
}
