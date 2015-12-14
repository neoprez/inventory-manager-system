package com.ims.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.ims.components.IMSServer;

public class IMSServerGUI extends JFrame implements ActionListener {
	private	IMSServer server;
	private JButton startBtn;
	private JPanel mainPanel;
	private JButton closeBtn;
	private final JLabel theLabel = new JLabel("Inventory Manager System");
	
	public IMSServerGUI() {
		startBtn = new JButton(new ImageIcon("icons/play-black.png"));
		startBtn.setActionCommand("start");
		startBtn.addActionListener(this);
		closeBtn = new JButton(new ImageIcon("icons/shutdown.png"));
		closeBtn.setActionCommand("close");
		closeBtn.addActionListener(this);
		mainPanel = new JPanel(new BorderLayout());
		JPanel topPanel = new JPanel();
		topPanel.add(closeBtn);
		topPanel.add(startBtn);
		topPanel.add(theLabel);
		setTitle("Inventory Manager System Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theLabel.setFont(theLabel.getFont().deriveFont(32.0f).deriveFont(Font.BOLD));
		mainPanel.add(topPanel, BorderLayout.CENTER);
		setSize(600,80);
		add(mainPanel);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "start":
			if( server == null ) {
				server = new IMSServer();
			}
			server.start();
			break;
		case "close":
			System.exit(0);
			break;
		}
	}
	
	public static void main(String[] args) {
		new IMSServerGUI();
	}
}
