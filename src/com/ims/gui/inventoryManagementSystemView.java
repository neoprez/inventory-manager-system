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

public class inventoryManagementSystemView extends JPanel{
	
	
	static JTextField searchField = new JTextField();
	
	public static String getSearchField(String searchWord){
		
		searchWord = searchField.getText();
		
		return searchWord;
	}
	
	String[] columnNames = {"Name",
            "UPC",
            "Manufacturer",
            "Distributor",
            "Category", "Count"};
	
	
	
	Object[][] product = {
		    {"Banana", "24384445485",
		     "Ecuador", "Manga", "Food", "5"},
		    {"Apple", "3894745876485",
		     "USA", "Tupa", "Food", "4"},
		    {"Cake", "83945745864",
		     "Bakery", "HP", "Cleaning", "23"},
		};
	
	
	JTable table = new JTable( new ProductsTableModel(product, columnNames) );
	
	
	
	public inventoryManagementSystemView(){
		
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout(5,10));
		add(searchField, BorderLayout.NORTH);
		add(table, BorderLayout.CENTER);
		
	}

}
