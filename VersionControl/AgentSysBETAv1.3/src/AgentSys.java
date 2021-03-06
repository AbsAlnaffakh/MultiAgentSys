import java.awt.EventQueue;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.eclipse.wb.swing.UIclass;
import org.eclipse.wb.swing.CommClass;
import org.eclipse.wb.swing.DBinteractions;
import org.eclipse.wb.swing.MessageExchange;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

import java.sql.*;
import java.io.File;
import java.io.FileOutputStream;
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
					//AgentsGUI window = new AgentsGUI();
					//window.frmSystemUtilitie.setVisible(true);
					
					
					//CommClass newf = new CommClass();  // tested creating a new file
					//newf.CreateFile("Penguin", "test");
						
					UIclass InitializeUI = new UIclass();
					InitializeUI.AgentsGUI();
										
					final String ucannaccessString = "jdbc:ucanaccess://h:/FYP/Implementation Files/Project Files/AgentsDataBase/AgentsDataBase.accdb";									
					///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					
					//CommClass ChnageFileStatus = new CommClass(); 
					//File f = new File("C:/Users/Aboudi's/Desktop/ToSellingAgent.xml");
					//ChnageFileStatus.MarkMessageAsRead(f);
					File f = new File("C:/Users/Aboudi's/Desktop/ToSellingAgent.xml");
					
					
					MessageExchange testtt = new MessageExchange();
					testtt.MonitorReadRespondModify(f, "SellingAgent");
					
					
					
					/*
					if(f.exists() && !f.isDirectory()) { 
						System.out.println("the file exists");
						String ProductNameInFile="";
					    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
							
						DocumentBuilder builder = factory.newDocumentBuilder();
						Document doc = builder.parse(f); // "C:/Users/Aboudi's/Desktop/ToSellingAgent.xml" //not needed use f instead
					
						NodeList list = doc.getElementsByTagName("CommValue");
						
						
						System.out.println(list.getLength());
										
						for (int i = 0; i < list.getLength(); i++) {
							Element item = (Element)list.item(i);
							System.out.print(((Node) item).getFirstChild().getNodeValue());
							ProductNameInFile = (((Node) item).getFirstChild().getNodeValue());
							item.getFirstChild().setTextContent("ItsNowRead");
							// if the tag within the file is read then dont add it
							
							String stmnt40 = "INSERT INTO ToBeSoldProducts (ProductName, ProductStatus) VALUES ("+"'"+ProductNameInFile+"'"+", 'True' )";
							DBinteractions UpdateFileContentstoDB = new DBinteractions();
							UpdateFileContentstoDB.ExecuteDBQueryNoReturn(stmnt40);
							
											
						}					
					}
					else {
						System.out.println("does not exist exists");
					}
					*/
								
					//1. read contents of the file (tick)
					//2. check if the file exists (tick)
					//3. Update file 
					//4. respond to contents// add to the DB  (tick)
					//5. check if its in the data base before addingit it!
					//4. DeleteFile (tick)
					//6. this functionality should be called when an agent makes a recommendation 
					
				/* an agent class is required 
				 * 1. A function that calculates the average price
				 * 2. A function that makes the recommendation
				 * NOTE: the DBinteractions class and the CommsClass and subs will get used here!
				 * 
				 */
				
					
					
					
					/*
					 * 1. the delete file method can be continuesly called by the two agents
					 * 2. the create file method can be called each time a new recommendation is added
					 * 3. the read and respond to file contents method should be continuesly called by both agents
					 * 4. 
					 */
					
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





