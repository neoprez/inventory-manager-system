package com.demo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import com.ims.classes.Cashier;
import com.ims.classes.CustomerOrder;
import com.ims.classes.InventoryProduct;
import com.ims.classes.Order;
import com.ims.classes.Supermarket;

public class IMSDemo extends JFrame implements ActionListener {
	private Order[] orders;
	private OrderSender os;
	private JSpinner supermarketsSpinner;
	private JSpinner cashierMachinesCountSpinner;
	private JSpinner producstPerMachineSpinner;
	private SpinnerNumberModel numberModel;
	private JPanel mainPanel;
	private JLabel supermarketsLabel;
	private JLabel cashiersLabel;
	private JLabel productsPerMachineLabel;
	private JButton startButton;
	
	public IMSDemo() {
		numberModel = new SpinnerNumberModel(1, 1, 10, 1);
		this.supermarketsSpinner = new JSpinner(numberModel);
		this.producstPerMachineSpinner = new JSpinner(numberModel);
		this.cashierMachinesCountSpinner = new JSpinner(numberModel);
		this.mainPanel = new JPanel(new GridLayout(4,2));
		supermarketsLabel = new JLabel("# of Supermarkets");
		cashiersLabel = new JLabel("# of cashier machines");
		productsPerMachineLabel = new JLabel("max # products per order");
		this.supermarketsSpinner = new JSpinner();
		this.producstPerMachineSpinner = new JSpinner();
		cashierMachinesCountSpinner = new JSpinner();
		this.mainPanel.add(supermarketsLabel);
		this.mainPanel.add(supermarketsSpinner);
		this.mainPanel.add(cashiersLabel);
		this.mainPanel.add(cashierMachinesCountSpinner);
		this.mainPanel.add(productsPerMachineLabel);
		this.mainPanel.add(producstPerMachineSpinner);
		
		startButton = new JButton("Start");
		startButton.addActionListener(this);
		mainPanel.add(startButton);
		
		add(mainPanel);
		setTitle("Cashier Machines Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	public void sendAllOrders() {
		for(Order order : orders ) {
			os.sendOrder(order);
		}
	}
	
	public void demo(int sCount, int productsCount, int cashiersCount) {
		Supermarket[] supermarkets 			= new Supermarket[sCount];
		int[] cashierMachinesCount			= new int[supermarkets.length]; // max amount of cashiers per supermarket
		OrderSender os						= new OrderSender();
		
		for(int i = 0; i < cashierMachinesCount.length; i++) {
			cashierMachinesCount[i] = new Random().nextInt(cashiersCount) + 1; // up to 10 cashier machines
		}

		for(int i = 0; i < supermarkets.length; i++) {
			supermarkets[i] = new Supermarket(i+1);
			for(int j = 0; j < cashierMachinesCount[i]; j++) {
				Cashier theCashier = new Cashier("Chupa", "Cabras", "chupacabras@localhost.com");
				theCashier.setId(j+1);
				CashierMachine machine = new CashierMachine(theCashier, supermarkets[i]);
				
				supermarkets[i].addCashier(theCashier);
				machine.setCashier(theCashier);
				supermarkets[i].addCashierMachine(machine);
			}
		}
		
		for(int r = 0; r < supermarkets.length; r++) {
			ArrayList<CashierMachine> machines = supermarkets[r].getCashierMachines();
			int[] amountOfProductsPerMachine = new int[machines.size()];
			
			for(int i = 0; i < amountOfProductsPerMachine.length; i++) {
				amountOfProductsPerMachine[i] = new Random().nextInt(productsCount) + 1; //up to 10 products per machine
			}
	
			ArrayList<InventoryProduct> products = supermarkets[r].getProducts();
	
			for(int j =0; j < machines.size(); j++ ) {
				machines.get(j).startCustomerOrder();
				for(int i = 0; i < amountOfProductsPerMachine[j]; i++) {
					machines.get(j).addProduct(products.get(new Random().nextInt(products.size())));
				}
				CustomerOrder order = machines.get(j).completeCustomerOrder();
				os.sendOrder(order);
			}
		}
	}
	
	public static void main(String[] args) {
		/*
		 * Horrible code. Please don't judge
		 */
		new IMSDemo();
		/**/
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "Start":
			Integer sCount = (Integer) supermarketsSpinner.getValue();
			Integer productsCount = (Integer) producstPerMachineSpinner.getValue();
			Integer cashiersCount = (Integer) cashierMachinesCountSpinner.getValue();
			demo(sCount, productsCount, cashiersCount);
			break;
		}
		
	}
}
