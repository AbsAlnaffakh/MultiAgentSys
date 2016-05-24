import java.awt.EventQueue;

import javax.xml.parsers.ParserConfigurationException;
import org.eclipse.wb.swing.UIclass;
import org.eclipse.wb.swing.TheSellingAgent;
import org.eclipse.wb.swing.TheBuyingAgent;
import org.xml.sax.SAXException;
import java.io.IOException;
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
					UIclass InitializeUI = new UIclass();
					InitializeUI.AgentsGUI();
					////////////////////////////////////////////////
					
					////////Initialises and launches the selling Agent///////
					TheSellingAgent SellingAgent = new TheSellingAgent();
					SellingAgent.InitialiseAndLaunch();
					/////////////////////////////////////////////////////////
					
					
					///////Initialises and launches the selling Agent////////
					TheBuyingAgent BuyingAgent = new TheBuyingAgent();
					BuyingAgent.InitialiseAndLaunch();
					/////////////////////////////////////////////////////////
					
					///////////////////////////////////////////everything above this point should not be changed testing tasks can be performed below////////////////////////
					
				
				}
				catch(Exception e ){
					e.printStackTrace();
				}
			}			
		});		
	}	
}





