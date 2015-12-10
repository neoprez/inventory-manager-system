package com.ims.components;

import java.util.LinkedList;
import java.util.Queue;

import com.ims.classes.Order;

public class OrderProcessor implements Runnable {
	private Queue<Order> orders;
	
	public OrderProcessor() {
		orders = new LinkedList<Order>();
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
}
