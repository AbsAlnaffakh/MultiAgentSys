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
import java.awt.Component;

public class AgentsGUI {

	private JFrame frmSystemUtilitie;
	private JTextField ToBeBoughtProductTF;
	private JTextField ToBeSoldProductTF;
	private JTextField AddRemoveWishlistProductTF;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable WishListTable;
	private JTable RecommendationsTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgentsGUI window = new AgentsGUI();
					window.frmSystemUtilitie.setVisible(true);
				} catch (Exception e) {
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
	private void initialize() {
		frmSystemUtilitie = new JFrame();
		frmSystemUtilitie.setTitle("System Utilitie");
		frmSystemUtilitie.setBounds(100, 100, 508, 416);
		frmSystemUtilitie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSystemUtilitie.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 472, 356);
		frmSystemUtilitie.getContentPane().add(tabbedPane);
		
		JPanel BuyingTab = new JPanel();
		tabbedPane.addTab("Buy", null, BuyingTab, null);
		BuyingTab.setLayout(null);
		
		JButton AddToBeBoughtProductB = new JButton("Submit");
		AddToBeBoughtProductB.setBounds(296, 57, 89, 23);
		BuyingTab.add(AddToBeBoughtProductB);
		
		ToBeBoughtProductTF = new JTextField();
		ToBeBoughtProductTF.setBounds(32, 58, 227, 20);
		BuyingTab.add(ToBeBoughtProductTF);
		ToBeBoughtProductTF.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter the description or name of the product you wish to buy in the text field below:");
		lblNewLabel.setBounds(10, 24, 411, 23);
		BuyingTab.add(lblNewLabel);
		
		JPanel SellingTab = new JPanel();
		tabbedPane.addTab("Sell", null, SellingTab, null);
		SellingTab.setLayout(null);
		
		Label label = new Label("Enter the description or name of the product you wish to sell in the text field below:");
		label.setBounds(10, 24, 411, 23);
		SellingTab.add(label);
		
		ToBeSoldProductTF = new JTextField();
		ToBeSoldProductTF.setBounds(32, 58, 227, 20);
		SellingTab.add(ToBeSoldProductTF);
		ToBeSoldProductTF.setColumns(10);
		
		JButton AddToBeSoldProductB = new JButton("Submit");
		AddToBeSoldProductB.setBounds(296, 58, 89, 23);
		SellingTab.add(AddToBeSoldProductB);
		
		JPanel WishlistTab = new JPanel();
		tabbedPane.addTab("Wishlist", null, WishlistTab, null);
		WishlistTab.setLayout(null);
		
		Label label_1 = new Label("To Add/Remove an item from/to the wishlist  enter the items name in the box below:");
		label_1.setBounds(22, 206, 422, 22);
		WishlistTab.add(label_1);
		
		JButton SubmitWishlistB = new JButton("Submit");
		SubmitWishlistB.setBounds(301, 253, 89, 23);
		WishlistTab.add(SubmitWishlistB);
		
		AddRemoveWishlistProductTF = new JTextField();
		AddRemoveWishlistProductTF.setBounds(55, 254, 195, 20);
		WishlistTab.add(AddRemoveWishlistProductTF);
		AddRemoveWishlistProductTF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("The table below shows current wishlist products:");
		lblNewLabel_1.setBounds(22, 31, 422, 14);
		WishlistTab.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 66, 422, 115);
		WishlistTab.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(105, 52, 1, 1);
		panel.add(scrollPane);
		
		WishListTable = new JTable();
		scrollPane.setViewportView(WishListTable);
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{scrollPane, WishListTable}));
		
		JPanel RecommendationsTab = new JPanel();
		tabbedPane.addTab("Recommendations", null, RecommendationsTab, null);
		RecommendationsTab.setLayout(null);
		
		JRadioButton ToBeBoughtRB = new JRadioButton("To Be Bought");
		ToBeBoughtRB.setBounds(51, 77, 109, 23);
		RecommendationsTab.add(ToBeBoughtRB);
		
		JRadioButton ToBeSoldRB = new JRadioButton("To Be Sold");
		ToBeSoldRB.setBounds(188, 77, 109, 23);
		RecommendationsTab.add(ToBeSoldRB);
		
		JRadioButton WishlistProductsRB = new JRadioButton("Wishlist Products");
		WishlistProductsRB.setBounds(309, 77, 109, 23);
		RecommendationsTab.add(WishlistProductsRB);
		
		JLabel lblNewLabel_2 = new JLabel("Below is the holding any recommendations made by the system:");
		lblNewLabel_2.setBounds(10, 20, 418, 14);
		RecommendationsTab.add(lblNewLabel_2);
		
		JTextArea lblNewLabel_3 = new JTextArea("Info displayed within the table below can be formatted by selecting by enabling \r\nthe buttons below:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3.setLineWrap(true);
		lblNewLabel_3.setEditable(false);
		lblNewLabel_3.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_3.setBounds(10, 40, 447, 40);
		RecommendationsTab.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(24, 118, 422, 187);
		RecommendationsTab.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 422, 187);
		panel_1.add(scrollPane_1);
		
		RecommendationsTable = new JTable();
		scrollPane_1.setViewportView(RecommendationsTable);
		
		JPanel SettingsTab = new JPanel();
		tabbedPane.addTab("Settings", null, SettingsTab, null);
		SettingsTab.setLayout(null);
		
		JCheckBox GlobalInteractionCB = new JCheckBox("Enable global site interactions");
		GlobalInteractionCB.setBounds(22, 36, 179, 23);
		SettingsTab.add(GlobalInteractionCB);
		
		JCheckBox SingleInteractionCB = new JCheckBox("Limit Interactions to a single site");
		SingleInteractionCB.setBounds(22, 84, 179, 23);
		SettingsTab.add(SingleInteractionCB);
		
		JCheckBox MultipleInteractionCB = new JCheckBox("Limit interactions to multiple sites");
		MultipleInteractionCB.setBounds(22, 141, 376, 23);
		SettingsTab.add(MultipleInteractionCB);
		
		textField_1 = new JTextField();
		textField_1.setBounds(46, 114, 329, 20);
		SettingsTab.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(46, 171, 329, 20);
		SettingsTab.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(47, 202, 328, 20);
		SettingsTab.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(47, 233, 328, 20);
		SettingsTab.add(textField_4);
		textField_4.setColumns(10);
		
		JButton ApplySettingsB = new JButton("Apply");
		ApplySettingsB.setBounds(251, 294, 89, 23);
		SettingsTab.add(ApplySettingsB);
		
		JButton CancelSettingsB = new JButton("Cancel");
		CancelSettingsB.setBounds(360, 294, 89, 23);
		SettingsTab.add(CancelSettingsB);
		
		JButton DefaultsB = new JButton("Revert to defaults");
		DefaultsB.setBounds(110, 294, 121, 23);
		SettingsTab.add(DefaultsB);
		
		JCheckBox AnimationsCB = new JCheckBox("Disable animations");
		AnimationsCB.setBounds(241, 36, 134, 23);
		SettingsTab.add(AnimationsCB);
		
		JCheckBox NotificationsCB = new JCheckBox("Disable notification");
		NotificationsCB.setBounds(241, 72, 157, 23);
		SettingsTab.add(NotificationsCB);
	}
}
