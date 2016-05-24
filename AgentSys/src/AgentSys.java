import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Button;
import java.awt.TextField;
import java.awt.Label;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import java.awt.Checkbox;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.swing.JTextArea;
import java.awt.Font;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.eclipse.wb.swing.UIclass;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

//import com.sun.java.util.jar.pack.Attribute.Layout.Element;
import com.sun.org.apache.xerces.internal.util.ParserConfigurationSettings;
import com.sun.org.apache.xml.internal.serializer.ElemDesc;
import com.sun.xml.internal.txw2.Document;

import net.proteanit.sql.DbUtils;

import java.awt.Component;
import java.sql.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Panel;



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class AgentSys {

	/**
	 * Launch the application.
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public void DeleteFileWhenRead(File f) throws ParserConfigurationException  // This Function should be called by the agent that wants to delete a file
	, SAXException, IOException
	{
		String MessageStatus = "";
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			
		DocumentBuilder builder = factory.newDocumentBuilder();
		org.w3c.dom.Document doc = builder.parse("C:/Users/Aboudi's/Desktop/ToSellingAgent.xml");
	
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
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//AgentsGUI window = new AgentsGUI();
					//window.frmSystemUtilitie.setVisible(true);
					
					//UIclass Initialis = new UIclass();
					//Initialis.AgentsGUI().frmSystemUtilitie.setVisible(true);
					//Initialis.frm
					
					UIclass Initialis1 = new UIclass();
					//Initialis1.initialize().frmSystemUtilitie.setVisible(true);
					Initialis1.AgentsGUI();
					//Initialis1.frmSystemUtilitie.setVisible(true);
					
					final String ucannaccessString = "jdbc:ucanaccess://h:/FYP/Implementation Files/Project Files/AgentsDataBase/AgentsDataBase.accdb";									
					///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					
					//UIclass test = new UIclass();
					//System.out.print("Penguin"+test.test(1, 2));
					
					File f = new File("C:/Users/Aboudi's/Desktop/ToSellingAgent.xml");
					
					if(f.exists() && !f.isDirectory()) { 
						System.out.println("the file exists");
						String ProductNameInFile="";
					    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
							
						DocumentBuilder builder = factory.newDocumentBuilder();
						org.w3c.dom.Document doc = builder.parse(f); // "C:/Users/Aboudi's/Desktop/ToSellingAgent.xml" //not needed use f instead
					
						NodeList list = doc.getElementsByTagName("CommValue");
									
						System.out.println(list.getLength());
										
						for (int i = 0; i < list.getLength(); i++) {
							Element item = (Element)list.item(i);
							System.out.print(((Node) item).getFirstChild().getNodeValue());
							ProductNameInFile = (((Node) item).getFirstChild().getNodeValue());
							//item.getFirstChild().setNodeValue("read");
							Connection conn40=DriverManager.getConnection(ucannaccessString); // DB connection
							Statement s40 = conn40.createStatement(); // declaring a statement object (from JDBC lib)
							String stmnt40 = "INSERT INTO ToBeSoldProducts (ProductName, ProductStatus) VALUES ("+"'"+ProductNameInFile+"'"+", 'True' )";
							s40.execute(stmnt40); // execute a statement without returning anything
														
						}
					
					}
					else {
						System.out.println("does not exist exists");
					}
					
								
					//1. read contents of the file (tick)
					//2. check if the file exists (tick)
					//3. Update file 
					//4. respond to contents// add to the DB 
					//5. check if its in the data base before deleting it!
					//4. DeleteFile (tick)
					//6. this functionality should be called when an agent makes a recommendation 
					//7. create an XML file
					
				////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
					
				Connection conn=DriverManager.getConnection(ucannaccessString); // DB connection
				Statement s = conn.createStatement(); // declaring a statement object (from JDBC lib)
				String stmnt = "SELECT ProductName FROM ToBeBoughtProducts  WHERE ProductStatus = 'True'";
				ResultSet rs = s.executeQuery(stmnt); // execute a statement without returning anything
				
				
				Connection conn1=DriverManager.getConnection(ucannaccessString); // DB connection
				Statement s1 = conn1.createStatement(); // declaring a statement object (from JDBC lib)
				
				Connection conn2=DriverManager.getConnection(ucannaccessString); // DB connection
				Statement s2 = conn2.createStatement(); // declaring a statement object (from JDBC lib)
				Connection conn3=DriverManager.getConnection(ucannaccessString); // DB connection
				Statement s3 = conn3.createStatement(); // declaring a statement object (from JDBC lib)
				Connection conn4=DriverManager.getConnection(ucannaccessString); // DB connection
				Statement s4 = conn4.createStatement(); // declaring a statement object (from JDBC lib)
				Connection conn5=DriverManager.getConnection(ucannaccessString); // DB connection
				Statement s5 = conn5.createStatement(); // declaring a statement object (from JDBC lib)
				
				while(rs.next())  {
					String ProductName = rs.getString("ProductName");
										
					String stmnt2 ="SELECT * From ToBeBoughtProductDetails WHERE ProductName = '"+ProductName+"'";//"+ProductName+"WII U WIFI
					ResultSet rs3 = s2.executeQuery(stmnt2);
					
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
						
						Source= rs3.getString("Source");
						SourceRating= rs3.getFloat("SourceRating");
						ProductValue= rs3.getFloat("ProductValue");
						DeliveryAvailability= rs3.getBoolean("DeliveryAvailability");
						StockAvailability= rs3.getBoolean("StockAvailability");
						
						/*System.out.println(ProductName);
						System.out.println(ProductValue);
						System.out.println(Source);
						System.out.println(SourceRating);
						System.out.println(DeliveryAvailability);
						System.out.println(StockAvailability);*/
												
						//if((ProductValue <= AverageValue )&&( SourceRating>= 2.5)&&(DeliveryAvailability=true)&&(StockAvailability=true)){  // defining the recommendation criteria
						if(( SourceRating>= 2.5)&&(DeliveryAvailability=true)&&(StockAvailability=true)){  // defining the recommendation criteria
							String stmnt3 ="SELECT * From RecommendedProducts WHERE ProductName = '"+ProductName+"' AND RecommendationType='ToBeBoughtProduct'" ;//"+ProductName+"WII U WIFI
							ResultSet rs4 = s3.executeQuery(stmnt3);
							
							/*if(rs4.wasNull()){
								String stmnt5 ="INSERT INTO RecommendedProducts (ProductName, Source, SourceRating,ProductValue,DeliveryAvailability,StockAvailability) VALUES ('"+ProductName+"','"+Source+"','"+SourceRating+"','"+ProductValue+"','"+DeliveryAvailability+"','"+StockAvailability+"')";//"+ProductName+"WII U WIFI
								System.out.println("this should work");
								s5.execute(stmnt5);
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
								System.out.println(StockAvailability);
																
								if((ProductValue < ProductValueInRT)&&(SourceRating>SourceRatingInRT)) {
									
									//String stmnt4 ="INSERT INTO RecommendedProducts (ProductName, Source, SourceRating,ProductValue,DeliveryAvailability,StockAvailability) VALUES ('"+ProductName+"','"+Source+"','"+SourceRating+"','"+ProductValue+"','"+DeliveryAvailability+"','"+StockAvailability+"')";//"+ProductName+"WII U WIFI
									
									//String stmnt4 ="INSERT INTO RecommendedProducts (ProductName, Source, SourceRating,ProductValue,DeliveryAvailability,StockAvailability) VALUES ("+"'"+ProductName+"'"+"',"+"'"+Source+"'"+"',"+"'"+SourceRating+"'"+"',"+"'"+ProductValue+"'"+"',"+"'"+DeliveryAvailability+"'"+"',"+"'"+StockAvailability+"'"+"')";//"+ProductName+"WII U WIFI
									String stmnt4 ="INSERT INTO RecommendedProducts (ProductName,Source,SourceRating,ProductValue,DeliveryAvailability,StockAvailability,RecommendationType) VALUES ("+"'"+ProductName+"'"+", "+"'"+Source+"'"+" ,"+"'"+SourceRating+"'"+","+"'"+ProductValue+"'"+","+"'"+DeliveryAvailability+"'"+","+"'"+StockAvailability+"'"+", 'ToBeBoughtProduct')";//"+ProductName+"WII U WIFI
									s4.execute(stmnt4);
									
									String StmntD = "DELETE FROM RecommendedProducts WHERE ProductValue='"+ProductValueInRT+"'";
									s4.executeUpdate(StmntD);
								}
								else if(!ProductName.equals(ProductNameInRT)){  /// ! not equal .equal(other)
									String stmnt5 ="INSERT INTO RecommendedProducts (ProductName, Source, SourceRating,ProductValue,DeliveryAvailability,StockAvailability) VALUES ('"+ProductName+"','"+Source+"','"+SourceRating+"','"+ProductValue+"','"+DeliveryAvailability+"','"+StockAvailability+"')";//"+ProductName+"WII U WIFI
									System.out.println("this should work");
									s5.execute(stmnt5);
								}
								
								
							}
							
							
											
						}
						
								
						
					}
					
				}
				
					
				}
				catch(Exception e ){
					e.printStackTrace();
				}
				
				
			}
			
		});		
	}

	
}





