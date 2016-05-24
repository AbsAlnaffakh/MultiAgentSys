import java.awt.EventQueue;

import javax.xml.parsers.ParserConfigurationException;
import org.eclipse.wb.swing.UIclass;
import org.eclipse.wb.swing.TheSellingAgent;
import org.eclipse.wb.swing.TheBuyingAgent;
import org.eclipse.wb.swing.*;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class AgentSys {

	/**
	 * Launch the application.
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					/////////Initialises and loads the GUI///////////
					//UIclass InitializeUI = new UIclass();
					//InitializeUI.AgentsGUI();
					////////////////////////////////////////////////
					
					////////Initialises and launches the selling Agent///////
					//TheSellingAgent SellingAgent = new TheSellingAgent();
					//SellingAgent.InitialiseAndLaunch();
					/////////////////////////////////////////////////////////
					
					
					///////Initialises and launches the selling Agent////////
					//TheBuyingAgent BuyingAgent = new TheBuyingAgent();
					//BuyingAgent.InitialiseAndLaunch();
					/////////////////////////////////////////////////////////
					
					///////////////////////////////////////////everything above this point should not be changed testing tasks can be performed below////////////////////////
					
					
					//Testing the DBinteractionsClass
					
					//DBinteractions Testing = new DBinteractions();
					
					/*String TestStmnt = "DELETE FROM ToBeBoughtProducts WHERE ProductName = 'Headphones' ";
					Testing.ExecuteDBQueryUpdate(TestStmnt);*/
					
					/*String TestStmnt = "SELECT * From ToBeBoughtProducts";
					ResultSet rs = Testing.ExecuteDBQuery(TestStmnt);
					while(rs.next()){										
						System.out.println(rs.getInt("ProductID") +" "+ rs.getString("ProductName") +" "+ rs.getBoolean("ProductStatus"));
					}*/
					
					
					
					//String TestStmnt = "INSERT INTO ToBeBoughtProducts (ProductName, ProductStatus) VALUES ('Headphones', 'True')";
					//Testing.ExecuteDBQueryNoReturn(TestStmnt);
					
					
					
					//UIclass InitializeUI = new UIclass();
					//InitializeUI.AgentsGUI();
					
					//File f = new File("C:/Users/Aboudi's/Desktop/ToBuyingAgent.xml");
										
					//MessageExchange Test = new MessageExchange();
					//Test.MonitorReadRespondModify(f, "BuyingAgent");
					
					
					//CommClass Test = new CommClass();
					//Test.MarkMessageAsRead(f);
					
					
					
					//Test.CreateFile("Cisco I27" , "ToSellingAgent");
					
					//Agents Test = new Agents();
					//Test.CalculateAverageValue();
					
					
					//Test.DeleteFileWhenRead(f);
					
					
					TheBuyingAgent BuyingAgent = new TheBuyingAgent();
					BuyingAgent.InitialiseAndLaunch();
					
					
				
				}
				catch(Exception e ){
					e.printStackTrace();
				}
			}			
		});		
	}	
}





