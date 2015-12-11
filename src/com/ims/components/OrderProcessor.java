package com.ims.components;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import com.ims.classes.CustomerOrder;
import com.ims.classes.ExchangeOrder;
import com.ims.classes.Order;
import com.ims.classes.Product;
import com.ims.classes.ReturnOrder;

public class OrderProcessor implements Runnable {
	private Queue<Order> orders;
	private DBCommunicator dbAPI;
	
	public OrderProcessor() {
		orders 	= new LinkedList<Order>();
		dbAPI	= new DBCommunicator();
	}
	
	private void processOrders() {
		while(true){
			synchronized(orders) {
				if( this.anyOrders() ) {
					//update the inventory for the store in the order
					Order order = this.orders.poll();
					System.out.println("Processing Order #" + order.getId() + " from supermarket #" + order.getSupermarketId());
				} else {
					// wait 5 secs for the orders Queue to have something
					try {
						System.out.println("No orders");
						orders.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public void run() {
		processOrders();
	}
	
	/*
	 * Returns true is any orders in the que
	 */
	private boolean anyOrders() {
		return orders.isEmpty() == false;
	}

	public void queueOrder(Order order) {
		synchronized(orders){
			orders.add(order);
			orders.notifyAll();
		}
	}
	
	
	private HashMap<String, Integer> computeCountForProductsInOrder(Order order) {
		HashMap<String, Integer> productsCountByUPC = new HashMap<String, Integer>();
		
		// To compute the count of each product in the order.
		for(Product product : order.getProducts() ) {
			String upc = product.getUpc();
			if( productsCountByUPC.containsKey(upc) ) {
				// Get current count
				int count = productsCountByUPC.get(upc);
				// Increase count in the map
				productsCountByUPC.put(upc, count);
			} else {
				productsCountByUPC.put(upc, 1);
			}
		}
		
		return productsCountByUPC;
	}
	
	private boolean isCustomerOrder(Order o) {
		return o instanceof CustomerOrder;
	}
	
	private boolean isReturnOrder(Order o) {
		return o instanceof ReturnOrder;
	}
	
	private boolean isExchangeOrder(Order o) {
		return o instanceof ExchangeOrder;
	}
}
