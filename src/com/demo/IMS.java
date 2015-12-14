package com.demo;
import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.ims.gui.inventoryManagementSystemView;
import com.ims.gui.inventoryView;



public class IMS extends JFrame {
	
		
		public IMS() {
			
			setSize(1280, 750);
			add(new inventoryView(), BorderLayout.EAST);
			add(new inventoryManagementSystemView(), BorderLayout.CENTER);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
	public static void main(String[] args) {
		new IMS();
	}
}
