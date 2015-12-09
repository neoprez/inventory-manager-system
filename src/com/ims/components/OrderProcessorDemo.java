package com.ims.components;

public class OrderProcessorDemo {
	public static void main(String[] args) {
		Thread receiver = new Thread(new OrderReceiver());
		receiver.start();
		System.out.println("I am running");
	}
}
