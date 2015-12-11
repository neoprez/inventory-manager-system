package com.ims.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class addProductToInventoryView extends JFrame implements ActionListener {

	JButton returnButton = new JButton("Return");
	JButton searchButton = new JButton("Search");
	JButton addButton = new JButton("Add");
	JButton cancelButton = new JButton("Cancel");
	JButton resetButton = new JButton("Reset Field");


	JTextField searchTextField = new JTextField(20);
	JTextArea productArea = new JTextArea();
	JPanel buttonPanel = new JPanel();

	JLabel addLabel = new JLabel("Add");


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



	public void addProduct(){
		String searchWord = "";
		searchWord = inventoryManagementSystemView.getSearchField(searchWord);

	}


	public addProductToInventoryView(){

		setSize(1280, 750);
		setLayout(new BorderLayout());
		setBackground(Color.lightGray);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);


		add(table, BorderLayout.CENTER);
		add(searchTextField, BorderLayout.NORTH);


		add(buttonPanel, BorderLayout.WEST);

		buttonPanel.setLayout(new GridLayout(0,1));

		buttonPanel.add(addLabel);
		addLabel.setBorder(BorderFactory.createEmptyBorder(0, 165, 0, 0));
		
		buttonPanel.add(searchButton);
		searchButton.setPreferredSize(new Dimension(400, 200));

		buttonPanel.add(addButton);
		addButton.setPreferredSize(new Dimension(400, 200));

		buttonPanel.add(cancelButton);
		cancelButton.setPreferredSize(new Dimension(400, 200));

		buttonPanel.add(resetButton);
		resetButton.setPreferredSize(new Dimension(400, 200));
		resetButton.addActionListener(this);
		
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
		else if(e.getActionCommand()==("Reset")){ 
			inventoryManagementSystemView.searchField.setText("");
		}
	}

}
