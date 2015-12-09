package com.ims.components;

public class OrderProcessorDemo {
	public static void main(String[] args) {
		OrderProcessor pr = new OrderProcessor();
		OrderReceiver rv = new OrderReceiver();
		Thread processor = new Thread(pr);
		rv.setOrderProcessor(pr);
		Thread receiver = new Thread(rv);
		receiver.start();
		processor.start();
		System.out.println("I am running");
	}
}
