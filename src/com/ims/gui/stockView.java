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
import javax.swing.SwingConstants;

public class stockView extends JPanel implements ActionListener {

		
		int inventoryCurrent = 250;
		int inventoryThreshold = 100;
		JLabel stock_Window = new JLabel ("STOCK");
		JButton addItemToStock = new JButton ("Add Item");
		JButton updateItemToStock = new JButton("Update Item");
		JButton removeItemFromStock = new JButton("Remove Item");
		
		public stockView(){
			
		
			setLayout(new GridLayout(0,1));
			

			add(stock_Window);
			stock_Window.setBorder(BorderFactory.createEmptyBorder(0, 180, 0, 0));
			
			
			add(addItemToStock);
			addItemToStock.setPreferredSize(new Dimension(400, 200));
			addItemToStock.addActionListener(this);
			
			add(updateItemToStock);
			updateItemToStock.setPreferredSize(new Dimension(400, 200));
			updateItemToStock.addActionListener(this);
			
			add(removeItemFromStock);
			removeItemFromStock.setPreferredSize(new Dimension(400, 200));
			removeItemFromStock.addActionListener(this);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand()==("Add Item")){
				// system will add item to stock
				
				inventoryCurrent +=1;
			}
			
			else if(e.getActionCommand()==("Update Item")){
				// system will update item to stock
			}
			
			else if(e.getActionCommand()==("Remove Item")){
				// system will remove item from stock
				
				inventoryCurrent-=1;
				if(inventoryCurrent<inventoryThreshold){
					JOptionPane.showMessageDialog(null, ("Inventory is below Threshold"));
				}
			}
		}
	
}
