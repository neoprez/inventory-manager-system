package com.ims.gui;
import java.awt.BorderLayout;

import javax.swing.JFrame;



public class Inventory_Management_System extends JFrame {
	private generateReportView theReportView = null;
		
		public Inventory_Management_System() {
			this.theReportView = new generateReportView();
			setSize(1280, 750);
			add(new stockView(), BorderLayout.WEST);
			add(new inventoryView(), BorderLayout.EAST);
			add(new inventoryManagementSystemView(), BorderLayout.CENTER);
			setVisible(true);
			add(new resupplyNotificationView());
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
	public static void main(String[] args) {
		new Inventory_Management_System();
	}
}
