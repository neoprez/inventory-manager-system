package com.ims.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.ims.classes.InventoryProduct;
import com.ims.components.DBUtilities;

@SuppressWarnings("serial")
public class inventoryManagementSystemView extends JPanel{
	
	
	static JTextField searchField = new JTextField();
	JScrollPane scrollPane = new JScrollPane();
	DBUtilities db = new DBUtilities();
	
	//ArrayList<InventoryProduct> products;
	
	String[] columnNames = {"Name",
            "UPC",
            "Manufacturer",
            "Distributor",
            "Category", "Count"};
	
	
	
	Object[][] product;
	
	

	JTable table;// = new JTable( new ProductsTableModel(product, columnNames) );
	

	
	public inventoryManagementSystemView(){
		
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
		
		table = new JTable( new DefaultTableModel(product, columnNames) );
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout(5,10));
		add(searchField, BorderLayout.NORTH);
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);

	}
}
