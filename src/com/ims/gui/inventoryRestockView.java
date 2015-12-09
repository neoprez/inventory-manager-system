package com.ims.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class inventoryRestockView extends JFrame {

	

	JButton searchButton = new JButton("Search");
	JButton addButton = new JButton("Add");
	JButton cancelButton = new JButton("Cancel");
	
	//JButton returnButton = new JButton("Return to Previous Page");
	JTextField searchTextField = new JTextField(20);
	JTextArea productArea = new JTextArea();
	JPanel buttonPanel = new JPanel();
	JPanel windowPanel = new JPanel();
	
	
		public inventoryRestockView(){
			
		add(windowPanel);
		windowPanel.add(buttonPanel);
		
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
		
	
}
	
}
