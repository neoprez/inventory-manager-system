package com.ims.components;

public class ProductsTracker {
	private Notifier 		notifier;
	private OrderProcessor 	orderProcessor;
	
	public void start() {
		while(true){
			System.err.println("Hello Infinite");
		}
	}
	
	public void notifyManager() {
		
	}
	
	public static void main(String[] args) {
		OrderReceiver.initialize();
		//new InventoryTracker().start();
	}
}
