package com.ims.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class resupplyNotificationView extends JFrame {

	
	
	JButton searchButton = new JButton("Search");
	JButton addButton = new JButton("Add");
	JButton cancelButton = new JButton("Cancel");
	
	//JButton returnButton = new JButton("Return to Previous Page");
	JTextField searchTextField = new JTextField(20);
	JTextArea productArea = new JTextArea();
	JPanel buttonPanel = new JPanel();
	JPanel tablePanel = new JPanel();
	JPanel windowPanel = new JPanel();
	
	String[] columnNames = {"Name",
            "UPC",
            "Manufacturer",
            "Distributor",
            "Category", "Check"};
	
	
	
	Object[][] product = {
		    {"Banana", "24384445485",
		     "Ecuador", "Manga", "Food", false},
		    {"Apple", "3894745876485",
		     "USA", "Tupa", "Food", false},
		    {"Cake", "83945745864",
		     "Bakery", "HP", "Cleaning", false},

		};
	
	
	JTable table = new JTable(product, columnNames);
	
	
	
	public resupplyNotificationView() {
		
		add(windowPanel);
		windowPanel.add(buttonPanel);
		windowPanel.add(tablePanel);
		windowPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		setSize(1280, 750);
		//setLayout(new GridLayout());
		setBackground(Color.lightGray);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		//add(returnButton, BorderLayout.SOUTH);
		add(buttonPanel, BorderLayout.NORTH);
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		buttonPanel.setLayout(new GridLayout(0,4));
		
		buttonPanel.add(searchButton);
		searchButton.setPreferredSize(new Dimension(200, 150));
		buttonPanel.add(searchTextField);
		buttonPanel.add(addButton);
		addButton.setPreferredSize(new Dimension(200, 150));
		buttonPanel.add(cancelButton);
		cancelButton.setPreferredSize(new Dimension(200, 150));
		
		
		add(tablePanel, BorderLayout.CENTER);
		table.setBorder(BorderFactory.createLineBorder(Color.black));
		tablePanel.add(table);
		table.setPreferredSize(new Dimension(1000, 1000));
	}
	
}
