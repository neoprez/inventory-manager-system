package com.demo;

import com.ims.classes.Cashier;
import com.ims.classes.Order;
import com.ims.classes.Product;

public class IMSDemo {
	private Order[] orders;
	private OrderSender os;
	private Supermarket sm;
	
	public IMSDemo(int id, int n) {
		orders = new Order[n];
		sm = new Supermarket(id);
		os = new OrderSender();
		fillArray(id, n);
	}
	
	private void fillArray(int id, int n) {
		/*
		 * Employees
		 */
		Cashier cs = new Cashier("Chupa", "Cabras");
		Cashier cs2 = new Cashier("Lion", "King");
		cs.setId(1);
		cs2.setId(2);
		sm.addCashier(cs);
		sm.addCashier(cs2);
		
		/*
		 * Cashier machines
		 */
		CashierMachine cms = new CashierMachine(cs, sm);
		cms.setId(1);
		CashierMachine cms2 = new CashierMachine(cs2, sm);
		cms2.setId(2);
		/*
		 * Orders
		 */
		for(int i = 0; i < n; i++) {
			cms.startOrder();
			cms.addProduct(new Product("123456789012", "Banana", 0.99, 1));
			cms.addProduct(new Product("123498789012", "Apple", 1.00, 1));
			cms.addProduct(new Product("984023582395", "Cheese", 2.99, 2));
			cms.addProduct(new Product("123840320458", "Guacamole", 5.99,1));
			cms.addProduct(new Product("785325623552", "Bacon", 0.99,6));
			orders[i] = cms.completeOrder();
			orders[i].setId(i+1);
		}
	}
	
	public void sendAllOrders() {
		for(Order order : orders ) {
			os.sendOrder(order);
		}
	}
	
	public static void main(String[] args) {
		new Thread(){
			public void run() {
				IMSDemo cms1 = new IMSDemo(1,1000);
				cms1.sendAllOrders();
			}
		}.start();
		
		new Thread() {
			public void run() {
				IMSDemo cms2 = new IMSDemo(67,200);
				cms2.sendAllOrders();
			}
		}.start();
		
		
	}
}
