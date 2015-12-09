package com.demo;

import com.ims.classes.Cashier;
import com.ims.classes.Order;
import com.ims.classes.Product;

public class IMSDemo {
	public static void main(String[] args) {
		Supermarket sm = new Supermarket(0);
		OrderSender os = new OrderSender();
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
		cms.startOrder();
		cms.addProduct(new Product("123456789012", "Banana", 0.99, 1));
		cms.addProduct(new Product("123498789012", "Apple", 1.00, 1));
		cms.addProduct(new Product("984023582395", "Cheese", 2.99, 2));
		cms.addProduct(new Product("123840320458", "Guacamole", 5.99,1));
		cms.addProduct(new Product("785325623552", "Bacon", 0.99,6));
		Order order1 = cms.completeOrder();
		os.sendOrder(order1);

		cms2.startOrder();
		cms2.addProduct(new Product("123456789012", "Guevos", 0.99, 1));
		cms2.addProduct(new Product("123498789012", "Name", 1.00, 1));
		Order order2 = cms2.completeOrder();
		os.sendOrder(order2);
		//os.startComponent();
	}
}
