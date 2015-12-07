package com.ims.gui;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class resupplyNotificationView extends JPanel {

	JButton example = new JButton("Click here and nothing");
	
	public resupplyNotificationView() {
		
		setVisible(true);
		setBackground(Color.lightGray);
		add(example);
		
		
		
	}
	
}
