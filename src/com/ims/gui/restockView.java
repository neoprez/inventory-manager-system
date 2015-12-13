package com.ims.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.ims.classes.InventoryProduct;
import com.ims.components.DBUtilities;

public class restockView extends JFrame implements ActionListener {

	DBUtilities db = new DBUtilities();


	JButton returnButton = new JButton("Return");
	JButton searchButton = new JButton("Search");
	JButton restockButton = new JButton("Restock Inventory");
	JButton cancelButton = new JButton("Cancel");
	JButton resetButton = new JButton("Reset Field");

	JTextField searchTextField = new JTextField(20);
	JTextArea productArea = new JTextArea();
	JPanel buttonPanel = new JPanel();

	JLabel restockLabel = new JLabel("Restock");

	JScrollPane scrollPane = new JScrollPane();

	String[] columnNames = {"Name",
			"UPC",
			"Manufacturer",
			"Distributor",
			"Category", "Check"};



	Object[][] product;

	DefaultTableModel model = new DefaultTableModel(product, columnNames);
	JTable table = new JTable(model);


	public restockView(){

		setSize(1280, 750);
		setLayout(new BorderLayout());
		setBackground(Color.lightGray);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	
		DBUtilities db = new DBUtilities();
		
		ArrayList<InventoryProduct> products = db.getProductsOnInventoryForSupermarket(2);
		
		product = new Object[products.size()][6];
		
		int row= 0;
		
		for(InventoryProduct p: products) {
			product[row][0] = p.getName();
			product[row][1] = p.getUpc();
			product[row][2] = p.getManufacturer().getName();
			product[row][3] = p.getDistributor().getName();
			product[row][4] = p.getCategory().getName();
			product[row][5] = false;
			row++;	
		}
		table = new JTable( new DefaultTableModel(product, columnNames) );
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);
		

		add(searchTextField, BorderLayout.NORTH);


		add(buttonPanel, BorderLayout.WEST);

		buttonPanel.setLayout(new GridLayout(0,1));

		buttonPanel.add(restockLabel);
		restockLabel.setBorder(BorderFactory.createEmptyBorder(0, 165, 0, 0));

		buttonPanel.add(searchButton);
		searchButton.setPreferredSize(new Dimension(400, 200));

		buttonPanel.add(restockButton);
		restockButton.setPreferredSize(new Dimension(400, 200));

		buttonPanel.add(cancelButton);
		cancelButton.setPreferredSize(new Dimension(400, 200));

		buttonPanel.add(returnButton);
		returnButton.setPreferredSize(new Dimension(400, 200));
		returnButton.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()==("Return")){
			super.dispose();
		}
		else if(e.getActionCommand()==("Restock Inventory")){
			// Some restock() method
		}
		else if(e.getActionCommand()==("Cancel")){
			
		}
		else if(e.getActionCommand()==("Search")){
			// some search() method will go here
		}
		else if(e.getActionCommand()==("Reset")){ 
			inventoryManagementSystemView.searchField.setText("");
		}
	}
}
