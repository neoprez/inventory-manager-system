package com.ims.gui;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class inventoryView extends JPanel implements ActionListener {

		JLabel inventoryLabel = new JLabel("INVENTORY");
		JButton updateInventory = new JButton("Update Inventory");
		JButton restockInventory = new JButton("Restock Inventory");
		JButton generateReportforInventory = new JButton ("Generate Report");	
		
		public inventoryView() {
			
		
		setLayout(new GridLayout(0,1));
		
		add(inventoryLabel);
		inventoryLabel.setBorder(BorderFactory.createEmptyBorder(0, 165, 0, 0));
		
		add(updateInventory);
		updateInventory.setPreferredSize(new Dimension(400, 200));
		updateInventory.addActionListener(this);
		
		add(restockInventory);
		restockInventory.setPreferredSize(new Dimension(400, 200));
		restockInventory.addActionListener(this);
		
		add(generateReportforInventory);
		generateReportforInventory.setPreferredSize(new Dimension(400, 200));
		generateReportforInventory.addActionListener(this);
			
		
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand()==("Update Inventory")){
				// system will update inventory from here
			}
			else if(e.getActionCommand()==("Restock Inventory")){
				// system will restock inventory from here
			}
			else if(e.getActionCommand()==("Generate Report")){
				// system will generate report of inventory
			}
		}
	
}
