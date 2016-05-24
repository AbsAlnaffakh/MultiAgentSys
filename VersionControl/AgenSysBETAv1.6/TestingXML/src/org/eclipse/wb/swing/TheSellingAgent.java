package org.eclipse.wb.swing;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;



/*
 * simply has one functionality for now, to check with radi if more needs to be added
 */

public class TheSellingAgent {
	
	private MessageExchange HandleMessages = new MessageExchange();
	private static File f = new File("C:/Users/Aboudi's/Desktop/ToSellingAgent.xml");	

	public void InitialiseAndLaunch() throws ParserConfigurationException, SAXException, IOException{
		
		HandleMessages.MonitorReadRespondModify(f, "SellingAgent");
		
		
	}
	
	
}
