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
import javax.swing.JTextArea;
import java.awt.Font;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import net.proteanit.sql.DbUtils;

import java.awt.Component;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JMenu;
import java.awt.Button;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
/////////////////////////////////////////////////////////////



public class AgentsGUI {

	private JFrame frmSystemUtilitie;
	private JTextField ToBeBoughtProductTF;
	private JTextField ToBeSoldProductTF;
	private JTextField AddRemoveWishlistProductTF;
	private JTextField OneSiteTF;
	private JTextField limitedSites1TF;
	private JTextField LimitedSites2TF;
	private JTextField LimitedSites3TF;
	private JTable RecommendationsTable;
	private JTable WishlistTable;
	private JTable table;
	
	
	
		
	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgentsGUI window = new AgentsGUI();
					window.frmSystemUtilitie.setVisible(true);
					
					///////////////////////////////////////////////////////////////
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
					
								
				
						
					/////////////////////////////////////////////////////////////////

		
					
				} catch (Exception e) {
					e.printStackTrace();
				}*/
				
				//try{
					
				final String ucannaccessString = "jdbc:ucanaccess://h:/FYP/Implementation Files/Project Files/AgentsDataBase/AgentsDataBase.accdb";
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
							
							
							//check if the recommendations table has any recommendations of the same 
							//product name then delete it!!
							// then insert those details into the recommendations table
														
						}
						
						
						
						//also add comparisons (comparison could be with existing recommedation in the rec table)
						
						
					}
					
				}
				
				
				
				
				
				
				}
				catch(Exception e ){
					e.printStackTrace();
				}
			}
			
		});		
	}

	/**
	 * Create the application.
	 */
	public AgentsGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("deprecation")
	private void initialize() {
		frmSystemUtilitie = new JFrame();
		frmSystemUtilitie.setTitle("System Utilitie");
		frmSystemUtilitie.setBounds(100, 100, 701, 445);
		frmSystemUtilitie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSystemUtilitie.getContentPane().setLayout(null);
		
		final String ucannaccessString = "jdbc:ucanaccess://h:/FYP/Implementation Files/Project Files/AgentsDataBase/AgentsDataBase.accdb";
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 665, 385);
		frmSystemUtilitie.getContentPane().add(tabbedPane);
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/////Buying Tab////////
		
		JPanel BuyingTab = new JPanel();    // Declares a new tab
		tabbedPane.addTab("Buy", null, BuyingTab, null);
		BuyingTab.setLayout(null); 			// Adds the new tab to the window
		
		ToBeBoughtProductTF = new JTextField();  // a text field to hold the new products value
		ToBeBoughtProductTF.setBounds(32, 58, 227, 20);
		BuyingTab.add(ToBeBoughtProductTF);
		ToBeBoughtProductTF.setColumns(10);
		
		
		JButton AddToBeBoughtProductB = new JButton("Submit"); // declaring the button
		AddToBeBoughtProductB.setBounds(296, 57, 89, 23);
		BuyingTab.add(AddToBeBoughtProductB);
		
		AddToBeBoughtProductB.addActionListener(new ActionListener() {  // executes upon button press
			public void actionPerformed(ActionEvent arg0) {
				try {
								
					Connection conn=DriverManager.getConnection(ucannaccessString); // DB connection
					Statement s = conn.createStatement(); // declaring a statement object (from JDBC lib)
					// A string variable holds the SQL query
					String stmnt = "INSERT INTO ToBeBoughtProducts (ProductName, ProductStatus) VALUES("+"'"+ToBeBoughtProductTF.getText()+"'"+",'True')";
					s.execute(stmnt); // execute a statement without returning anything
					s.close();
										
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
				
		JLabel lblNewLabel = new JLabel("Enter the description or name of the product you wish to buy in the text field below:");
		lblNewLabel.setBounds(10, 24, 411, 23);
		BuyingTab.add(lblNewLabel);
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/////Selling Tab///////
		
		JPanel SellingTab = new JPanel();
		tabbedPane.addTab("Sell", null, SellingTab, null);
		SellingTab.setLayout(null);
		
		Label label = new Label("Enter the description or name of the product you wish to sell in the text field below:");
		label.setBounds(10, 24, 528, 23);
		SellingTab.add(label);
		
		ToBeSoldProductTF = new JTextField();
		ToBeSoldProductTF.setBounds(32, 58, 227, 20);
		SellingTab.add(ToBeSoldProductTF);
		ToBeSoldProductTF.setColumns(10);
		
		JButton AddToBeSoldProductB = new JButton("Submit");
		AddToBeSoldProductB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {					
						Connection conn=DriverManager.getConnection(ucannaccessString);
						Statement s = conn.createStatement();
						String stmnt = "INSERT INTO ToBeSoldProducts (ProductName, ProductStatus) VALUES("+"'"+ToBeSoldProductTF.getText()+"'"+",'True')";
						s.execute(stmnt);
						s.close();	
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		});
		AddToBeSoldProductB.setBounds(296, 58, 89, 23);
		SellingTab.add(AddToBeSoldProductB);
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////Wishlist Tab//////
		
		JPanel WishlistTab = new JPanel();  // declares a new tab
		tabbedPane.addTab("Wishlist", null, WishlistTab, null);
		WishlistTab.setLayout(null);
		
		Label label_1 = new Label("To Add/Remove an item from/to the wishlist  enter the items name in the box below:");
		label_1.setBounds(22, 226, 518, 22);
		WishlistTab.add(label_1);
		
		AddRemoveWishlistProductTF = new JTextField(); // a text field to hold the product name (string)
		AddRemoveWishlistProductTF.setBounds(55, 254, 195, 20);
		WishlistTab.add(AddRemoveWishlistProductTF);
		AddRemoveWishlistProductTF.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 49, 611, 151);
		WishlistTab.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 611, 151);
		panel.add(scrollPane);
		
		WishlistTable = new JTable(); // a table to display current wishlist items
		scrollPane.setViewportView(WishlistTable); //encapsulates the table within a scroll pane to enable scroling!
		
		try {
			Connection conn=DriverManager.getConnection(ucannaccessString);
			Statement s = conn.createStatement();
			String stmnt = "SELECT ProductName FROM WishListProducts"; 
			ResultSet rs = s.executeQuery(stmnt);
			WishlistTable.setModel(DbUtils.resultSetToTableModel(rs));  // using the dbutils method for table population
			s.close();		
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		JButton SubmitWishlistB = new JButton("Submit"); // declares a new button
		SubmitWishlistB.setBounds(301, 253, 89, 23);
		WishlistTab.add(SubmitWishlistB);
		
		SubmitWishlistB.addActionListener(new ActionListener() { // executes upon button press
			public void actionPerformed(ActionEvent arg0) {
				try{
				Connection conn=DriverManager.getConnection(ucannaccessString);
				Statement s = conn.createStatement();
				String stmnt = "SELECT *  FROM WishListProducts WHERE ProductStatus = Yes"; //retireves all data
				ResultSet rs = s.executeQuery(stmnt);
			    
				String ValueInBox = AddRemoveWishlistProductTF.getText();
			    
				while (rs.next()){ // reads ever
					String ProductName = rs.getString("ProductName"); // stores retrieved data for later processing
																		// from the "ProductName" coloumn
			        if (ProductName.equals(ValueInBox)  ){ // if it exists within the DB then delete it
			        		
			        		stmnt = "DELETE FROM WishListProducts WHERE ProductName ="+"'"+ValueInBox+"'"+"";
							s.executeUpdate(stmnt);
							break;
						 }
						 else if (ProductName != ValueInBox){ // if it does not exist within the DB then add it

			        		stmnt = "INSERT INTO WishListProducts (ProductName, ProductStatus) VALUES("+"'"+ValueInBox+"'"+",'True')";
			        		s.execute(stmnt);
			        		break;
						}	
				}
				s.close();
				}	
				catch(Exception e)
				{
					e.printStackTrace();
				} 
			}
		});
		
				
		JLabel lblNewLabel_1 = new JLabel("The table below shows current wishlist products:");
		lblNewLabel_1.setBounds(22, 31, 422, 14);
		WishlistTab.add(lblNewLabel_1);
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////Recommendations Tab////
		
		JPanel RecommendationsTab = new JPanel();
		tabbedPane.addTab("Recommendations", null, RecommendationsTab, null);
		RecommendationsTab.setLayout(null);
		
		final JRadioButton ToBeBoughtRB = new JRadioButton("To Be Bought");
		ToBeBoughtRB.setBounds(90, 77, 109, 23);
		RecommendationsTab.add(ToBeBoughtRB);
		
		
		
		final JRadioButton ToBeSoldRB = new JRadioButton("To Be Sold");
		ToBeSoldRB.setBounds(277, 77, 109, 23);
		RecommendationsTab.add(ToBeSoldRB);
		
		final JRadioButton WishlistProductsRB = new JRadioButton("Wishlist Products");
		WishlistProductsRB.setBounds(459, 77, 109, 23);
		RecommendationsTab.add(WishlistProductsRB);
		
		JLabel lblNewLabel_2 = new JLabel("Below is the holding any recommendations made by the system:");
		lblNewLabel_2.setBounds(10, 20, 418, 14);
		RecommendationsTab.add(lblNewLabel_2);
		
		JTextArea lblNewLabel_3 = new JTextArea("Info displayed within the table below can be formatted by selecting by enabling the buttons below:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3.setLineWrap(true);
		lblNewLabel_3.setEditable(false);
		lblNewLabel_3.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_3.setBounds(20, 45, 587, 23);
		RecommendationsTab.add(lblNewLabel_3);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(22, 108, 603, 228);
		RecommendationsTab.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 603, 228);
		panel_1.add(scrollPane_1);
		
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		try {
			final Connection conn=DriverManager.getConnection(ucannaccessString);
			Statement s = conn.createStatement();
			String stmnt = "SELECT ProductName, Source, SourceRating, ProductValue, AverageValue, StockAvailability, RecommendationType, "
					+ "ProductCondition FROM RecommendedProducts";
			ResultSet rs = s.executeQuery(stmnt);
			table.setModel(DbUtils.resultSetToTableModel(rs)); 	
			s.close();	
		}
		
		catch (Exception e) 
		{
			e.printStackTrace();
			
		}
		
		
		
		WishlistProductsRB.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
				    ToBeBoughtRB.setSelected(false);
					ToBeSoldRB.setSelected(false);
					
					try{
						
						Connection conn=DriverManager.getConnection(ucannaccessString);
						Statement s = conn.createStatement();
						String stmnt = "SELECT ProductName, Source, SourceRating, ProductValue, AverageValue, StockAvailability, RecommendationType, ProductCondition FROM RecommendedProducts WHERE RecommendationType = 'WishListProduct' ";
						ResultSet rs = s.executeQuery(stmnt);
						
						table.setModel(DbUtils.resultSetToTableModel(rs)); 
						
						s.close();
					}
					catch(Exception e){
						e.printStackTrace();
					}
			
			}
				
		});
		
		ToBeBoughtRB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				WishlistProductsRB.setSelected(false);
				ToBeSoldRB.setSelected(false);
				
				try{
					
					Connection conn=DriverManager.getConnection(ucannaccessString);
					Statement s = conn.createStatement();
					String stmnt = "SELECT ProductName, Source, SourceRating, ProductValue, AverageValue, "
							+ " StockAvailability, RecommendationType, ProductCondition FROM RecommendedProducts"
							+ " WHERE RecommendationType = 'ToBeBoughtProduct' ";
					ResultSet rs = s.executeQuery(stmnt);
					
					table.setModel(DbUtils.resultSetToTableModel(rs)); 
					
					s.close();
				}
				catch(Exception e){
					e.printStackTrace();
				}
			
			}
				
		});
		
		ToBeSoldRB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ToBeBoughtRB.setSelected(false);
				WishlistProductsRB.setSelected(false);
				
				try{
					
					Connection conn=DriverManager.getConnection(ucannaccessString);
					Statement s = conn.createStatement();
					String stmnt = "SELECT ProductName, Source, SourceRating, ProductValue, AverageValue, StockAvailability, RecommendationType, ProductCondition FROM RecommendedProducts WHERE RecommendationType = 'ToBeSoldProduct' ";
					ResultSet rs = s.executeQuery(stmnt);
					
					table.setModel(DbUtils.resultSetToTableModel(rs)); 
					
					s.close();
				}
				catch(Exception e){
					e.printStackTrace();
				}
				
				
			}
				
		});
		
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//// Settings Tab////
		
		
		JPanel SettingsTab = new JPanel();
		tabbedPane.addTab("Settings", null, SettingsTab, null);
		SettingsTab.setLayout(null);
		
		
		final JCheckBox SingleInteractionCB = new JCheckBox("Limit Interactions to a single site");
		final JCheckBox MultipleInteractionCB = new JCheckBox("Limit interactions to multiple sites");	
		final JCheckBox GlobalInteractionCB = new JCheckBox("Enable global site interactions");
		
		
		OneSiteTF = new JTextField();
		OneSiteTF.setBounds(46, 114, 329, 20);
		SettingsTab.add(OneSiteTF);
		OneSiteTF.setColumns(10);
		OneSiteTF.setEditable(false);
		
		
		GlobalInteractionCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SingleInteractionCB.setSelected(false);
				MultipleInteractionCB.setSelected(false);
				
			}
		});
		GlobalInteractionCB.setBounds(22, 36, 239, 23);
		SettingsTab.add(GlobalInteractionCB);
		
		
		SingleInteractionCB.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				if (SingleInteractionCB.isSelected()){
					MultipleInteractionCB.setSelected(false);
					GlobalInteractionCB.setSelected(false);
					OneSiteTF.setEditable(true);
				}
				else{
					OneSiteTF.setEditable(false);
				}
				
				
			}
		});
		
		limitedSites1TF = new JTextField();
		limitedSites1TF.setBounds(46, 171, 329, 20);
		SettingsTab.add(limitedSites1TF);
		limitedSites1TF.setColumns(10);
		limitedSites1TF.setEditable(false);
		
		LimitedSites2TF = new JTextField();
		LimitedSites2TF.setBounds(47, 202, 328, 20);
		SettingsTab.add(LimitedSites2TF);
		LimitedSites2TF.setColumns(10);
		LimitedSites2TF.setEditable(false);
		
		LimitedSites3TF = new JTextField();
		LimitedSites3TF.setBounds(47, 233, 328, 20);
		SettingsTab.add(LimitedSites3TF);
		LimitedSites3TF.setColumns(10);
		LimitedSites3TF.setEditable(false);
		
		
		SingleInteractionCB.setBounds(22, 84, 239, 23);
		SettingsTab.add(SingleInteractionCB);
		
		
		MultipleInteractionCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(MultipleInteractionCB.isSelected()){
					SingleInteractionCB.setSelected(false);
					GlobalInteractionCB.setSelected(false);
					LimitedSites3TF.setEditable(true);
					LimitedSites2TF.setEditable(true);
					limitedSites1TF.setEditable(true);
				}
				else{
					LimitedSites3TF.setEditable(false);
					LimitedSites2TF.setEditable(false);
					limitedSites1TF.setEditable(false);
				}
				
			}
		});
		MultipleInteractionCB.setBounds(22, 141, 376, 23);
		SettingsTab.add(MultipleInteractionCB);
		
		
		JButton ApplySettingsB = new JButton("Apply");
		ApplySettingsB.setBounds(492, 263, 141, 23);
		SettingsTab.add(ApplySettingsB);
		
		JButton CancelSettingsB = new JButton("Cancel");
		CancelSettingsB.setBounds(492, 304, 141, 23);
		SettingsTab.add(CancelSettingsB);
		
		JButton DefaultsB = new JButton("Revert to defaults");
		DefaultsB.setBounds(492, 220, 141, 23);
		SettingsTab.add(DefaultsB);
		
		JCheckBox AnimationsCB = new JCheckBox("Disable animations");
		AnimationsCB.setBounds(435, 36, 134, 23);
		SettingsTab.add(AnimationsCB);
		
		JCheckBox NotificationsCB = new JCheckBox("Disable notification");
		NotificationsCB.setBounds(435, 84, 157, 23);
		SettingsTab.add(NotificationsCB);
		
		
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
	}
}






