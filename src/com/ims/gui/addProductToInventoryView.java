package com.ims.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

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
import com.ims.classes.Product;
import com.ims.components.DBUtilities;

public class addProductToInventoryView extends JFrame implements ActionListener {


	DBUtilities db = new DBUtilities();

	ArrayList<Product> products;
	
	
	JButton returnButton = new JButton("Return");
	JButton searchButton = new JButton("Search");
	JButton addButton = new JButton("Add");
	JButton cancelButton = new JButton("Cancel");
	JButton resetButton = new JButton("Reset Field");


	JTextField searchTextField = new JTextField(20);
	JTextArea productArea = new JTextArea();
	JPanel buttonPanel = new JPanel();

	JLabel addLabel = new JLabel("Add Product to Inventory");
	
	
	
	String[] columnNames = {"Name",
			"UPC",
			"Manufacturer",
			"Distributor",
			"Category", "Count", "Check" };

	Object[][] product;


	DefaultTableModel model;
	JTable table;
	

	public addProductToInventoryView(){

		setSize(1280, 750);
		setLayout(new BorderLayout());
		setBackground(Color.lightGray);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout(5,10));

		add(searchTextField, BorderLayout.NORTH);
		
		add(buttonPanel, BorderLayout.WEST);

		buttonPanel.setLayout(new GridLayout(0,1));

		buttonPanel.add(addLabel);
		addLabel.setBorder(BorderFactory.createEmptyBorder(0, 120, 0, 0));
		
		buttonPanel.add(searchButton);
		searchButton.setPreferredSize(new Dimension(400, 200));
		searchButton.addActionListener(this);
		
		buttonPanel.add(addButton);
		addButton.setPreferredSize(new Dimension(400, 200));
		addButton.addActionListener(this);
		
		buttonPanel.add(cancelButton);
		cancelButton.setPreferredSize(new Dimension(400, 200));
		cancelButton.addActionListener(this);
		
		buttonPanel.add(resetButton);
		resetButton.setPreferredSize(new Dimension(400, 200));
		resetButton.addActionListener(this);
		
		products = db.getAllProducts();
		ArrayList<InventoryProduct> productsInInventory = db.getProductsOnInventoryForSupermarket(1);
		
		product = new Object[products.size()][7];
		
		int row= 0;
		
		for(Product p: products) {
			product[row][0] = p.getName();
			product[row][1] = p.getUpc();
			product[row][2] = p.getManufacturer().getName();
			product[row][3] = p.getDistributor().getName();
			product[row][4] = p.getCategory().getName();
			boolean isInInventory = false;
			for(int i = 0; i < productsInInventory.size(); i ++){
				if (productsInInventory.get(i).getUpc().equals(p.getUpc())){
					isInInventory = true;
					product[row][5] = productsInInventory.get(i).getCount();
					product[row][6] = true;
					break;
				}
			}
			if(!isInInventory){
				product[row][6] = false;
				product[row][5] = 0;
			}
		
			row++;	
		}
			model =  new DefaultTableModel(product, columnNames) {
			
			@Override
			public boolean isCellEditable(int row, int column){
			
			return column == 6;
			
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

		if(e.getActionCommand()==("Add")){
			ArrayList<Integer> rows = new ArrayList<Integer>();
			for(int i = 0; i <table.getRowCount(); i ++){
				if((Boolean)table.getValueAt(i, 6)==true) {
					rows.add(i);
					InventoryProduct product = new InventoryProduct(products.get(i));
					product.setCount(10);
					db.addProductToInventory(product.getSupermarketID(), product);
				}
				else{
					
				}
			}
		}
		else if(e.getActionCommand()==("Cancel")){
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
