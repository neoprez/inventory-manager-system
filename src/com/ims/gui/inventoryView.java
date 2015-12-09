package com.ims.gui;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class inventoryView extends JPanel implements ActionListener {

		JLabel inventoryLabel = new JLabel("INVENTORY");
		JButton addInventoryButton = new JButton("Add Product to Inventory");
		JButton removeProductFromInventoryButton = new JButton("Remove Product From Inventory");
		JButton generateReportforInventoryButton = new JButton ("Generate Report");	
		JButton restockInventoryButton = new JButton("Restock Inventory");
		
		public inventoryView() {
			
		
		setLayout(new GridLayout(0,1));
		
		add(inventoryLabel);
		inventoryLabel.setBorder(BorderFactory.createEmptyBorder(0, 165, 0, 0));
		
		add(addInventoryButton);
		addInventoryButton.setPreferredSize(new Dimension(400, 200));
		addInventoryButton.addActionListener(this);
		
		add(removeProductFromInventoryButton);
		removeProductFromInventoryButton.setPreferredSize(new Dimension(400, 200));
		removeProductFromInventoryButton.addActionListener(this);
		
		add(generateReportforInventoryButton);
		generateReportforInventoryButton.setPreferredSize(new Dimension(400, 200));
		generateReportforInventoryButton.addActionListener(this);
			
		add(restockInventoryButton);
		restockInventoryButton.setPreferredSize(new Dimension(400, 200));
		restockInventoryButton.addActionListener(this);
		
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand()==("Add Product to Inventory")){
				int answer = JOptionPane.showConfirmDialog(null,
						"Would you like to set an alert to be notified if you need to restock your inventory?",
						"Title",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
					if(answer == 0){
						addProductToInventoryView frame = new addProductToInventoryView();// you can have your own parameters of course	
						frame.setVisible(true);
					}
					else{
						JOptionPane.showMessageDialog(null, "You have cancelled the notification");
			
					}

			}
			
			else if(e.getActionCommand()==("Restock Inventory")){
				int answer = JOptionPane.showConfirmDialog(null,
						"Would you like to set an alert to be notified if you need to restock your inventory?",
						"Title",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
					if(answer == 0){
						inventoryRestockView frame = new inventoryRestockView();// you can have your own parameters of course	
						frame.setVisible(true);
					}
					else{
						JOptionPane.showMessageDialog(null, "You have cancelled the notification");
			
					}
			}
			
			else if(e.getActionCommand()==("Remove Product From Inventory")){
				int answer = JOptionPane.showConfirmDialog(null,
						"Would you like to set an alert to be notified if you need to restock your inventory?",
						"Title",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
					if(answer == 0){
						removeProductFromInventoryView frame = new removeProductFromInventoryView();// you can have your own parameters of course	
						frame.setVisible(true);
					}
					else{
						JOptionPane.showMessageDialog(null, "You have cancelled the notification");
			
					}
			}
			else if(e.getActionCommand()==("Generate Report")){
				int answer = JOptionPane.showConfirmDialog(null,
						"Would you like to set an alert to be notified if you need to restock your inventory?",
						"Title",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
					if(answer == 0){
						generateReportView frame = new generateReportView();// you can have your own parameters of course	
						frame.setVisible(true);
					}
					else{
						JOptionPane.showMessageDialog(null, "You have cancelled the notification");
			
					}
				
			}
		}
	
}
