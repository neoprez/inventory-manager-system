package com.ims.components;

import java.util.LinkedList;
import java.util.Queue;

import com.ims.classes.Order;

public class OrderProcessor implements Runnable {
	private Queue<Order> orders;
	static final Object lock = new Object();
	
	public OrderProcessor() {
		orders = new LinkedList<Order>();
	}
	
	public void start() {
		processOrders();
	}
	
	private void processOrders() {
		synchronized(orders) {
			while(true){
				if( this.anyOrders() ) {
					//update the inventory for the store in the order
					Order order = this.orders.poll();
					System.out.println("Order #" + order.getId());
				} else {
					// wait 5 secs for the orders Queue to have something
					try {
						System.out.println("No orders");
						orders.wait(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public void run() {
		this.start();
	}
	
	/*
	 * Returns true is any orders in the que
	 */
	private boolean anyOrders() {
		return orders.isEmpty() == false;
	}

	public void queueOrder(Order order) {
		orders.add(order);
	}
}
