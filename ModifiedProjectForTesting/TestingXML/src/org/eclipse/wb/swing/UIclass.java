package org.eclipse.wb.swing;

import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.eclipse.wb.swing.DBinteractions;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import net.proteanit.sql.DbUtils;

public class UIclass {
	
	public JFrame frmSystemUtilitie;
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
	
	
	public void AgentsGUI() {
		initialize();
	}	

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	@SuppressWarnings("deprecation")
	private void initialize() {
		frmSystemUtilitie = new JFrame();
		frmSystemUtilitie.setTitle("System Utilitie");
		frmSystemUtilitie.setBounds(100, 100, 701, 445);
		frmSystemUtilitie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSystemUtilitie.getContentPane().setLayout(null);
		frmSystemUtilitie.setVisible(true);
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
					
				String stmnt = "INSERT INTO ToBeBoughtProducts (ProductName, ProductStatus) VALUES("+"'"+ToBeBoughtProductTF.getText()+"'"+",'True')";
				DBinteractions AddToBeBoughtProducts = new DBinteractions();
				AddToBeBoughtProducts.ExecuteDBQueryNoReturn(stmnt);
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
				
				String stmnt = "INSERT INTO ToBeSoldProducts (ProductName, ProductStatus) VALUES("+"'"+ToBeSoldProductTF.getText()+"'"+",'True')";
				DBinteractions AddToBeSoldProducts = new DBinteractions();
				AddToBeSoldProducts.ExecuteDBQueryNoReturn(stmnt);
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
		
		String stment = "SELECT ProductName FROM WishListProducts"; //selects data from the whish list table
		DBinteractions PopulateWishlistTable = new DBinteractions(); // 
		WishlistTable.setModel(DbUtils.resultSetToTableModel(PopulateWishlistTable.ExecuteDBQuery(stment))); // uses the dbutils method to populate the table with rs data
		
		JButton SubmitWishlistB = new JButton("Submit"); // declares a new button
		SubmitWishlistB.setBounds(301, 253, 89, 23);
		WishlistTab.add(SubmitWishlistB);
		
		SubmitWishlistB.addActionListener(new ActionListener() { // executes upon button press
			public void actionPerformed(ActionEvent arg0) {
				try {
			    
					String stmnt = "SELECT *  FROM WishListProducts WHERE ProductStatus = Yes"; //retireves all data
				
					DBinteractions AddRemoveWishlistProducts = new DBinteractions();
					//ResultSet rs = AddRemoveWishlistProducts.ExecuteDBQueryMR(stmnt);
					ResultSet rs = AddRemoveWishlistProducts.ExecuteDBQuery(stmnt);
					String ValueInBox = AddRemoveWishlistProductTF.getText();
			   
					while (rs.next()){ // reads every row
						
						String ProductName = rs.getString("ProductName"); // stores retrieved data for later processing from the "ProductName" coloumn
						System.out.println(ProductName);
						
					    if (ProductName.equals(ValueInBox)  ){ // if it exists within the DB then delete it
					    		
					    		stmnt = "DELETE FROM WishListProducts WHERE ProductName ="+"'"+ValueInBox+"'"+"";
								AddRemoveWishlistProducts.ExecuteDBQueryUpdate(stmnt);
					    	}
							 else if (ProductName != ValueInBox){ // if it does not exist within the DB then add it

					    		stmnt = "INSERT INTO WishListProducts (ProductName, ProductStatus) VALUES("+"'"+ValueInBox+"'"+",'True')";
					    		AddRemoveWishlistProducts.ExecuteDBQueryNoReturn(stmnt);
							}
					}
				} catch (SQLException e) {
					
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
		
		String stmnt = "SELECT ProductName, Source, SourceRating, ProductValue, AverageValue, StockAvailability, RecommendationType, "
				+ "ProductCondition FROM RecommendedProducts";
		DBinteractions PopulateTheRecommededProductsTable = new DBinteractions();
		table.setModel(DbUtils.resultSetToTableModel(PopulateTheRecommededProductsTable.ExecuteDBQuery(stmnt)));  // populates the recommendations table
		
		WishlistProductsRB.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
				    ToBeBoughtRB.setSelected(false);
					ToBeSoldRB.setSelected(false);
										
					String stmnt = "SELECT ProductName, Source, SourceRating, ProductValue, AverageValue, StockAvailability, RecommendationType, ProductCondition FROM RecommendedProducts WHERE RecommendationType = 'WishListProduct' ";
					DBinteractions PopulateTheRecommededProductsTableFiltered = new DBinteractions();
					table.setModel(DbUtils.resultSetToTableModel(PopulateTheRecommededProductsTableFiltered.ExecuteDBQuery(stmnt)));  // populates the recommendations table
					
			}
				
		});
		
		ToBeBoughtRB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				WishlistProductsRB.setSelected(false);
				ToBeSoldRB.setSelected(false);
				
				String stmnt = "SELECT ProductName, Source, SourceRating, ProductValue, AverageValue, "
						+ " StockAvailability, RecommendationType, ProductCondition FROM RecommendedProducts"
						+ " WHERE RecommendationType = 'ToBeBoughtProduct' ";
				DBinteractions PopulateTheRecommededProductsTableFiltered = new DBinteractions();
				table.setModel(DbUtils.resultSetToTableModel(PopulateTheRecommededProductsTableFiltered.ExecuteDBQuery(stmnt)));  // populates the recommendations table
			
			}
				
		});
		
		ToBeSoldRB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ToBeBoughtRB.setSelected(false);
				WishlistProductsRB.setSelected(false);
				
				String stmnt = "SELECT ProductName, Source, SourceRating, ProductValue, AverageValue, StockAvailability, RecommendationType, ProductCondition FROM RecommendedProducts WHERE RecommendationType = 'ToBeSoldProduct' ";
				DBinteractions PopulateTheRecommededProductsTableFiltered = new DBinteractions();
				table.setModel(DbUtils.resultSetToTableModel(PopulateTheRecommededProductsTableFiltered.ExecuteDBQuery(stmnt)));  // populates the recommendations table
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
						
	}
	
	
}
