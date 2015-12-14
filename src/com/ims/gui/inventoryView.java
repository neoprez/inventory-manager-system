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

	JLabel inventoryLabel = new JLabel("Inventory Management System");
	JButton addInventoryButton = new JButton("Add Product to Inventory");
	JButton removeProductFromInventoryButton = new JButton("Remove Product From Inventory");
	JButton generateReportforInventoryButton = new JButton ("Generate Report");	
	JButton restockInventoryButton = new JButton("Restock Inventory");
	JButton setResupplyNotification = new JButton("Set Resupply Notification");
	JButton resetButton = new JButton("Reset");
	JButton signOffButton = new JButton("Sign Off");

	public inventoryView() {


		setLayout(new GridLayout(0,1));
		add(inventoryLabel);
		inventoryLabel.setBorder(BorderFactory.createEmptyBorder(0, 105, 0, 0));

		add(resetButton);
		resetButton.setPreferredSize(new Dimension(200, 400));
		resetButton.addActionListener(this);

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

		add(setResupplyNotification);
		setResupplyNotification.setPreferredSize(new Dimension(400, 200));
		setResupplyNotification.addActionListener(this);

		add(signOffButton);
		signOffButton.setPreferredSize(new Dimension(400, 200));
		signOffButton.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()==("Add Product to Inventory")){
			addProductToInventoryView frame = new addProductToInventoryView();	
			frame.setVisible(true);
		}

		else if(e.getActionCommand()==("Restock Inventory")){
			restockView frame = new restockView();
			frame.setVisible(true);
		}

		else if(e.getActionCommand()==("Remove Product From Inventory")){
			removeProductFromInventoryView frame = new removeProductFromInventoryView();
			frame.setVisible(true);

		}

		else if(e.getActionCommand()==("Generate Report")){
			generateReportView frame = new generateReportView();
			frame.setVisible(true);
		}
		
		else if(e.getActionCommand()==("Reset")){ 
			inventoryManagementSystemView.searchField.setText("");
		}

		else if(e.getActionCommand()==("Set Resupply Notification")){
			int answer = JOptionPane.showConfirmDialog(null,
					"Would you like to set an alert to be notified if you need to restock your inventory?",
					"Title",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if(answer == 0){
				resupplyNotificationView frame = new resupplyNotificationView();// you can have your own parameters of course	
				frame.setVisible(true);
			}
			else{
				JOptionPane.showMessageDialog(null, "You have cancelled the notification");

			}

		}
		else if(e.getActionCommand()==("Sign Off")){ 
			System.exit(0);
		}
	}

}
