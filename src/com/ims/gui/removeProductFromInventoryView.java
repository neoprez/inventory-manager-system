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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.ims.classes.InventoryProduct;
import com.ims.components.DBUtilities;

public class removeProductFromInventoryView extends JFrame implements ActionListener {

	DBUtilities db = new DBUtilities();

	JButton searchButton = new JButton("Search");
	JButton removeButton = new JButton("Remove");
	JButton cancelButton = new JButton("Cancel");
	JButton resetButton = new JButton("Reset Field");
	
	

	JTextField searchTextField = new JTextField(20);
	JTextArea productArea = new JTextArea();
	JPanel buttonPanel = new JPanel();

	JLabel removeLabel = new JLabel("Remove Product from Inventory");

	ArrayList<InventoryProduct> products;
	
	String[] columnNames = {"Name",
            "UPC",
            "Manufacturer",
            "Distributor",
            "Category", "Check"};
	
	
	
	Object[][] product;
		
		DefaultTableModel model;
	//JTable table = new JTable(model);
		JTable table;
	
	
		public removeProductFromInventoryView(){
			
		setSize(1280, 750);
		setLayout(new BorderLayout());
		setBackground(Color.lightGray);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		
		products = db.getProductsOnInventoryForSupermarket(1);
		
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
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout(5,10));

		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);
	
		
		add(searchTextField, BorderLayout.NORTH);
	
		
		add(buttonPanel, BorderLayout.WEST);
		
		buttonPanel.setLayout(new GridLayout(0,1));
		
		buttonPanel.add(removeLabel);
		removeLabel.setBorder(BorderFactory.createEmptyBorder(0, 120, 0, 0));
		
		buttonPanel.add(searchButton);
		searchButton.setPreferredSize(new Dimension(400, 200));
		searchButton.addActionListener(this);
		
		buttonPanel.add(removeButton);
		removeButton.setPreferredSize(new Dimension(400, 200));
		removeButton.addActionListener(this);
		
		buttonPanel.add(cancelButton);
		cancelButton.setPreferredSize(new Dimension(400, 200));
		cancelButton.addActionListener(this);
		
		
		buttonPanel.add(resetButton);
		resetButton.setPreferredSize(new Dimension(200, 400));
		resetButton.addActionListener(this);
	
}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand()==("Remove")){
				ArrayList<Integer> rows = new ArrayList<Integer>();
				for(int i = 0; i <table.getRowCount(); i ++){
					if((Boolean)table.getValueAt(i, 5)==true) {
						rows.add(i);
						InventoryProduct product = products.get(i);
						db.removeProductFromInventory(product.getSupermarketID(), product.getUpc());
					}
				}
				
				for(int i = rows.size(); i > 0; i --){
					int row = rows.get(i-1);
					
					model.removeRow(row);
					products.remove(row);
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