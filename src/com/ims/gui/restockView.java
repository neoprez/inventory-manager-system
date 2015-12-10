package com.ims.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class restockView extends JFrame implements ActionListener {

	


	JButton returnButton = new JButton("Return");
	JButton searchButton = new JButton("Search");
	JButton restockButton = new JButton("Restock Inventory");
	JButton cancelButton = new JButton("Cancel");
	

	JTextField searchTextField = new JTextField(20);
	JTextArea productArea = new JTextArea();
	JPanel buttonPanel = new JPanel();

	JLabel restockLabel = new JLabel("Restock");


	String[] columnNames = {"Name",
            "UPC",
            "Manufacturer",
            "Distributor",
            "Category", "Check"};
	
	
	
	Object[][] product = {
		    {"Banana", "24384445485",
		     "Ecuador", "Manga", "Food", Boolean.FALSE},
		    {"Apple", "3894745876485",
		     "USA", "Tupa", "Food", Boolean.FALSE},
		    {"Cake", "83945745864",
		     "Bakery", "HP", "Cleaning", Boolean.FALSE},

		};
	
	ProductsTableModel model = new ProductsTableModel(product, columnNames);
	JTable table = new JTable(model);
	
	
	
		public void removeProduct(){
		String searchWord = "";
		searchWord = inventoryManagementSystemView.getSearchField(searchWord);
		
	}
	
	
		public restockView(){
			
		setSize(1280, 750);
		setLayout(new BorderLayout());
		setBackground(Color.lightGray);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		
		add(table, BorderLayout.CENTER);
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
		}
}
