package com.demo;

import com.ims.classes.Cashier;
import com.ims.classes.Category;
import com.ims.classes.CustomerOrder;
import com.ims.classes.Product;

public class IMSDemo {
	private CustomerOrder[] orders;
	private OrderSender os;
	private Supermarket sm;
	
	public IMSDemo(int id, int n) {
		orders = new CustomerOrder[n];
		sm = new Supermarket(id);
		os = new OrderSender();
		fillArray(id, n);
	}

	private void fillArray(int id, int n) {
		/*
		 * Employees
		 */
		Cashier cs = new Cashier("Chupa", "Cabras", "chupacabras@localhost.com");
		Cashier cs2 = new Cashier("Lion", "King", "lionking@localhost.com");
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
			cms.addProduct(new Product("384293829823", "Banana", 0.99, new Category(1, "Fruits")));
			cms.addProduct(new Product("123498789012", "Apple", 1.00, new Category(1, "Fruits")));
			cms.addProduct(new Product("984023582395", "Cheese", 2.99, new Category(2, "Dairy")));
			cms.addProduct(new Product("123840320458", "Guacamole", 5.99,new Category(1, "Fruits")));
			cms.addProduct(new Product("785325623552", "Bacon", 0.99,new Category(2, "Meat")));
			orders[i] = cms.completeOrder();
			orders[i].setId(i+1);
		}
	}

	public void sendAllOrders() {
		for(CustomerOrder order : orders ) {
			os.sendOrder(order);
		}
	}

	public static void main(String[] args) {
		new Thread(){
			public void run() {
				IMSDemo cms1 = new IMSDemo(1,99);
				cms1.sendAllOrders();
			}
		}.start();
		
		new Thread() {
			public void run() {
				IMSDemo cms2 = new IMSDemo(2,30);
				cms2.sendAllOrders();
			}
		}.start();	
	}
}
