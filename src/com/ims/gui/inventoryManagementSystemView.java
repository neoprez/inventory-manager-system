package com.ims.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class inventoryManagementSystemView extends JPanel implements ActionListener {

	String newName = "";
	int newBarcode = 0;
	int newPrice = 0;
	String newManufacturer = "";
	String newDistributor = "";
	String newCategory = "";
	
	JLabel IMSLabel = new JLabel("Inventory Management System");
	JLabel productInfoLabel = new JLabel("Product Information");
	
	
	
	
	
	String[] columnNames = {"Name",
            "UPC",
            "Manufacturer",
            "Distributor",
            "Category", "Check"};
	
	
	
	Object[][] product = {
		    {"Banana", "24384445485",
		     "Ecuador", "Manga", "Food", false},
		    {"Apple", "3894745876485",
		     "USA", "Tupa", "Food", true},
		    {"Cake", "83945745864",
		     "Bakery", "HP", "Cleaning", false},

		};
	
	
	JTable table = new JTable(product, columnNames);
	
	JButton setResupplyNotification = new JButton("Set Resupply Notification");
	JButton resetButton = new JButton("Reset");
	
	public inventoryManagementSystemView(){
		
		setBackground(Color.LIGHT_GRAY);
		setLayout(new GridLayout(0,1));
		add(IMSLabel);
		IMSLabel.setPreferredSize(new Dimension(400, 150));
		IMSLabel.setBorder(BorderFactory.createEmptyBorder(0, 106, 0, 0));
		add(productInfoLabel);
		
		add(table);
		
		
		
	}


	@Override
	
	// When the user clicks the "Resupply button, the system shall confirm with the user and then take the user to another screen (applet)	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()==("Set Resupply Notification")){
			int answer = JOptionPane.showConfirmDialog(null,
					"Would you like to set an alert to be notified if you need to restock your inventory?",
					"Title",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.ERROR_MESSAGE);
				if(answer == 0){
					resupplyNotificationView frame = new resupplyNotificationView();// you can have your own parameters of course	
					frame.setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(null, "You have cancelled the notification");
		
				}
			
		}
		// action to clear all the textfields
		else if(e.getActionCommand()==("Reset")){ 
			
			
		}
	}
}
