package com.ims.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.ims.classes.InventoryProduct;
import com.ims.components.DBUtilities;

public class inventoryManagementSystemView extends JPanel{
	
	
	static JTextField searchField = new JTextField();
	JScrollPane scrollPane = new JScrollPane();
	
	
	public static String getSearchField(String searchWord){
		
		searchWord = searchField.getText();
		
		return searchWord;
	}
	
	String[] columnNames = {"Name",
            "UPC",
            "Manufacturer",
            "Distributor",
            "Category", "Count"};
	
	
	
	Object[][] product;/* = {
		    {"Banana", "24384445485",
		     "Ecuador", "Manga", "Food", "5"},
		    {"Apple", "3894745876485",
		     "USA", "Tupa", "Food", "4"},
		    {"Cake", "83945745864",
		     "Bakery", "HP", "Cleaning", "23"},
		};*/
	
	
	JTable table;// = new JTable( new ProductsTableModel(product, columnNames) );
	
	
	
	public inventoryManagementSystemView(){
		DBUtilities db = new DBUtilities();
		for(int i = 0; i < 6; i++){
		ArrayList<InventoryProduct> products = db.getProductsOnInventoryForSupermarket(1);
		
		product = new Object[products.size()][6];
		
		int row= 0;
		
		for(InventoryProduct p: products) {
			product[row][0] = p.getName();
			product[row][1] = p.getUpc();
			product[row][2] = p.getManufacturer().getName();
			product[row][3] = p.getDistributor().getName();
			product[row][4] = p.getCategory().getName();
			product[row][5] = p.getCount();
			row++;	
		}
		}
		table = new JTable( new ProductsTableModel(product, columnNames) );
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout(5,10));
		add(searchField, BorderLayout.NORTH);
		add(table, BorderLayout.CENTER);
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
	}

}
