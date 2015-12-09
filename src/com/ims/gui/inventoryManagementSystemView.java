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
	JLabel nameLabel = new JLabel("Name:");
	JLabel upcLabel = new JLabel("UPC:");
	JLabel priceLabel = new JLabel("Price");
	JLabel manufacturerLabel = new JLabel("Manufacturer:");
	JLabel distributorLabel = new JLabel("Distributor:");
	JLabel categoryLabel = new JLabel("Category");
	
	JTextField nameTextField = new JTextField("Enter name");
	JTextField upcTextField = new JTextField("Enter the barcode");
	JTextField priceTextField = new JTextField("Enter the price");
	JTextField manufacturerTextField = new JTextField("Enter the Manufacturer");
	JTextField distributorTextField = new JTextField("Enter the distributor");
	JTextField categoryTextField = new JTextField("Enter the category");
	
	JButton setResupplyNotification = new JButton("Set Resupply Notification");
	JButton resetButton = new JButton("Reset");
	
	public inventoryManagementSystemView(){
		
		setBackground(Color.LIGHT_GRAY);
		setLayout(new GridLayout(0,2,30,30));
		add(IMSLabel);
		IMSLabel.setPreferredSize(new Dimension(400, 150));
		IMSLabel.setBorder(BorderFactory.createEmptyBorder(0, 106, 0, 0));
		
		add(productInfoLabel);
		
		add(nameLabel);
		nameLabel.setBorder(BorderFactory.createEmptyBorder(0, 75, 0, 0));
		add(nameTextField);
		
		
		add(upcLabel);
		upcLabel.setBorder(BorderFactory.createEmptyBorder(0, 75, 0, 0));
		add(upcTextField);
		
		
		add(priceLabel);
		priceLabel.setBorder(BorderFactory.createEmptyBorder(0, 75, 0, 0));
		add(priceTextField);
	
		
		add(manufacturerLabel);
		manufacturerLabel.setBorder(BorderFactory.createEmptyBorder(0, 75, 0, 0));
		add(manufacturerTextField);
		
		add(distributorLabel);
		distributorLabel.setBorder(BorderFactory.createEmptyBorder(0, 75, 0, 0));
		add(distributorTextField);
		
		add(categoryLabel);
		categoryLabel.setBorder(BorderFactory.createEmptyBorder(0, 75, 0, 0));
		add(categoryTextField);
		
		
		add(setResupplyNotification);
		setResupplyNotification.setPreferredSize(new Dimension(200, 150));
		setResupplyNotification.addActionListener(this);
		
		add(resetButton);
		resetButton.setPreferredSize(new Dimension(200, 150));
		resetButton.addActionListener(this);
		
		
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
			nameTextField.setText("");
			upcTextField.setText("");
			priceTextField.setText("");
			manufacturerTextField.setText("");
			distributorTextField.setText("");
			categoryTextField.setText("");
			
		}
	}
}
