package com.ims.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class resupplyNotificationView extends JFrame implements ActionListener {

	
	
	JButton searchButton = new JButton("Search");
	JButton acceptButton = new JButton("Accept");
	JButton cancelButton = new JButton("Cancel");
	JButton returnButton = new JButton("Return");
	JButton resetButton = new JButton("Reset Field");
	
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
	
	
	ProductsTableModel model = new ProductsTableModel(product, columnNames);
	JTable table = new JTable(model);
	
	public void setNotification(){
		 
		/*   
		if(model.selected = true){
			int[] selection = table.getSelectedRows();
			   for (int i = 0; i < selection.length; i++) {
			     selection[i] = table.convertRowIndexToModel(selection[i]);
			     JOptionPane.showInputDialog(table, "Assign a count threshold by indicating a numeric value in an input field next to each of these "
			     		+ "products");
			   }
			   
		}
		else {
			   JOptionPane.showMessageDialog(null, "You have not selected any products");
		   } */
	}
	
	
	public void removeNotification(){
		
	}

	
	public resupplyNotificationView() {
		
		setSize(1280, 750);
		setLayout(new BorderLayout());
		setBackground(Color.lightGray);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		//add(returnButton, BorderLayout.SOUTH);
		add(buttonPanel, BorderLayout.EAST);
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		buttonPanel.setLayout(new GridLayout(0,1));
		
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
		
		buttonPanel.add(returnButton);
		returnButton.setPreferredSize(new Dimension(200, 150));
		returnButton.addActionListener(this);
		
		add(table, BorderLayout.CENTER);
		table.setBorder(BorderFactory.createLineBorder(Color.black));
	
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()==("Accept")){
			setNotification();
		}

		else if(e.getActionCommand()==("Cancel")){
			
		}
		else if(e.getActionCommand()==("Search")){
			// some search() method will go here
		}
		else if(e.getActionCommand()==("Return")){
			super.dispose();
		}
		else if(e.getActionCommand()==("Reset")){ 
			inventoryManagementSystemView.searchField.setText("");
		}
	}
	
}
