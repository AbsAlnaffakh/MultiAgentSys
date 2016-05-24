package org.eclipse.wb.swing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class CommClass {
	

	/*
	 * 1. A function to delete files when read
	 * 2. A function to create files (protocol compliant)
	 * 3. A function that modifies the file contents to change message status
	 */
	
	
	public void DeleteFileWhenRead(File f) throws ParserConfigurationException  // This Function should be called by the agent that wants to delete a file
	, SAXException, IOException
	{
		String MessageStatus = "";
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			
		DocumentBuilder builder = factory.newDocumentBuilder();
		org.w3c.dom.Document doc = builder.parse(f); 
	
		NodeList list = doc.getElementsByTagName("CommStatus");
	
		System.out.println(list.getLength());
						
		for (int i = 0; i < list.getLength(); i++) {
			Element item = (Element)list.item(i);
			MessageStatus = (String) item.getFirstChild().getNodeValue();
		}
								
		if(MessageStatus.equals("Read"))
		{
			f.delete();
		}
	}
	
	
	// requires the file name of the file that should be modified passed to it
	public void MarkMessageAsRead(File f) throws IOException, SAXException, ParserConfigurationException{
		if(f.exists() && !f.isDirectory()) { 
			System.out.println("the file exists");
			
			String MessageStatus="";
		    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(f); // 
		
			NodeList list = doc.getElementsByTagName("CommStatus");
						
			System.out.println(list.getLength());
							
			for (int i = 0; i < list.getLength(); i++) {
				Element item = (Element)list.item(i);
				System.out.print(((Node) item).getFirstChild().getNodeValue());
				MessageStatus = (((Node) item).getFirstChild().getNodeValue());
				item.getFirstChild().setTextContent("Read");
										
				OutputFormat outFormat = new OutputFormat(doc);
				FileOutputStream outStream = new FileOutputStream(f);
				XMLSerializer Serializer = new XMLSerializer(outStream,outFormat);
				Serializer.serialize(doc);
											
			}					
		}
		else {
			System.out.println("does not exist exists");
		}
		
	}
	
	
	//To send in the name of the product to be recommended and the stated receptienest (ToSellingAgent)
	public void CreateFile (String ProductName, String Receptienest) throws ParserConfigurationException, IOException{
		
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document xmlDoc = docBuilder.newDocument();
			
			Text ProductNameToF = xmlDoc.createTextNode(ProductName);
			Text CommType = xmlDoc.createTextNode("MessageExchange");
			Text ReadStatus = xmlDoc.createTextNode("Unread");
						
			Element rootElement = xmlDoc.createElement("CommType");
			rootElement.appendChild(CommType); 
			
			Element Status = xmlDoc.createElement("CommStatus");
			Status.appendChild(ReadStatus);
			
			Element Value = xmlDoc.createElement("CommValue");
			Value.appendChild(ProductNameToF);// becomes the child of the tag Value
						
			rootElement.appendChild(Status);  // becomes the comm type of the tag Value
			rootElement.appendChild(Value); // becomes the commtype of the tag Value
			
			xmlDoc.appendChild(rootElement); // adds the root elements to the document
			OutputFormat outFormat = new OutputFormat(xmlDoc);
			
			File xmlFile = new File("C:/Users/Aboudi's/Desktop/"+Receptienest+".xml");
			FileOutputStream outStream = new FileOutputStream(xmlFile);
			XMLSerializer Serializer = new XMLSerializer(outStream,outFormat);
			Serializer.serialize(xmlDoc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	
	
	
	
	
	
	

}
