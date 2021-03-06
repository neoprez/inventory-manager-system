package com.ims.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.ims.classes.InventoryProduct;
import com.ims.components.DBUtilities;

public class resupplyNotificationView extends JFrame implements ActionListener {

	DBUtilities db = new DBUtilities();

	ArrayList<InventoryProduct> products;
	
	JButton searchButton = new JButton("Search");
	JButton acceptButton = new JButton("Accept");
	JButton cancelButton = new JButton("Cancel");
	JButton returnButton = new JButton("Return");
	JButton resetButton = new JButton("Reset Field");
	
	JTextField searchTextField = new JTextField(20);
	JTextArea productArea = new JTextArea();
	JPanel buttonPanel = new JPanel();
	
	JLabel restockLabel = new JLabel("Resupply Notification");
	
	
	String[] columnNames = {"Name",
            "UPC",
            "Manufacturer",
            "Distributor",
            "Category", "Check"};
	
	
	
	Object[][] product;
	
	
	DefaultTableModel model;
	JTable table;

	
	public resupplyNotificationView() {
		
		setSize(1280, 750);
		setLayout(new BorderLayout());
		setBackground(Color.lightGray);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		add(searchTextField, BorderLayout.NORTH);
		
		add(buttonPanel, BorderLayout.EAST);
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		buttonPanel.setLayout(new GridLayout(0,1));
		
		buttonPanel.add(restockLabel);
		restockLabel.setBorder(BorderFactory.createEmptyBorder(0, 140, 0, 0));
		
		buttonPanel.add(searchButton);
		searchButton.setPreferredSize(new Dimension(200, 150));
		searchButton.addActionListener(this);
		
		buttonPanel.add(acceptButton);
		acceptButton.setPreferredSize(new Dimension(200, 150));
		acceptButton.addActionListener(this);
		
		buttonPanel.add(cancelButton);
		cancelButton.setPreferredSize(new Dimension(200, 150));
		cancelButton.addActionListener(this);
		
		buttonPanel.add(resetButton);
		resetButton.setPreferredSize(new Dimension(400, 200));
		resetButton.addActionListener(this);

		products = db.getProductsOnInventoryForSupermarket(1);
		
		product = new Object[products.size()][6];
		
		int row= 0;
		
		for(InventoryProduct p: products) {
			product[row][0] = p.getName();
			product[row][1] = p.getUpc();
			product[row][2] = p.getManufacturer().getName();
			product[row][3] = p.getDistributor().getName();
			product[row][4] = p.getCategory().getName();
			product[row][5] = p.hasNotification();
			row++;	
		}
		
		model =  new DefaultTableModel(product, columnNames) {
			
			@Override
			public boolean isCellEditable(int row, int column){
			
			return column == 5;
			
		}
			

			//
		    // This method is used by the JTable to define the default
		    // renderer or editor for each cell. For example if you have
		    // a boolean data it will be rendered as a check box. A
		    // number value is right aligned.
		    //
			
		    @Override
		    public Class<?> getColumnClass(int columnIndex) {
		        return product[0][columnIndex].getClass();
		    }
		
		};
		
		
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);
	
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()==("Accept")){
			ArrayList<Integer> rows = new ArrayList<Integer>();
			for(int i = 0; i <table.getRowCount(); i ++){
				InventoryProduct product = products.get(i);
				if((Boolean)table.getValueAt(i, 5)==true) {
					rows.add(i);
					String count = JOptionPane.showInputDialog(null, "Please enter the amount for the threshold");
					int thresholdNumber = Integer.parseInt(count);
					db.setThresholdForProduct(product.getUpc(), product.getSupermarketID(), thresholdNumber);
					db.setNotificationForProduct(product.getUpc(), product.getSupermarketID() );
				}/*
				else{
					// DO IF USER CLICKS ACCEPT AND NOTHING CHEECKED
					if((Boolean)table.getValueAt(i, 5)==false){
					JOptionPane.showMessageDialog(null, "You must select a product");
					String count = JOptionPane.showInputDialog(null, "Please enter the amount for the threshold");
					int thresholdNumber = Integer.parseInt(count);
					db.setThresholdForProduct(product.getUpc(), product.getSupermarketID(), thresholdNumber);
					db.setNotificationForProduct(product.getUpc(), product.getSupermarketID() );
					}
				}*/
			}
		}
		else if(e.getActionCommand()==("Cancel")){
				ArrayList<Integer> rows = new ArrayList<Integer>();
				for(int i = 0; i <table.getRowCount(); i ++){
					if((Boolean)table.getValueAt(i, 5)==true && e.getActionCommand()!=("Accept")){
						rows.add(i);
						InventoryProduct product = products.get(i);
						db.removeNotificationForProduct(product.getUpc(), product.getSupermarketID());
						super.dispose();
					}
				}
				super.dispose();
		}
		else if(e.getActionCommand()==("Search")){
			// some search() method will go here
		}
		else if(e.getActionCommand()==("Reset Field")){ 
			searchTextField.setText("");
		}
	}
	
}
