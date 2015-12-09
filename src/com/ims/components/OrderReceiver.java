package com.ims.components;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.ims.classes.Order;
/*
 * This classes receives the orders from the incoming connections and parses
 * the bytes into objects and pass them to the orderProcessor
 */
public class OrderReceiver implements Runnable {
	private static OrderProcessor orderProcessor = null; // a single instance for all components
	private ServerSocket imsSocket;
	//private static OrderReceiver self = new OrderReceiver();
	private final String COMPONENT_NAME = "ORDER RECEIVER";
	/*
	 * A single OrderReceiver per IMS
	 */
	public OrderReceiver() {}
	
	/*
	 * To initialize this IMS
	 */
	/*
	 * Wait for orders in whatever we decide to use
	 */
	public void start() {
		try {
			imsSocket = new ServerSocket(6789);
			System.out.print(COMPONENT_NAME);
			System.out.println(" - Initialized on port 6789...");
		} catch (IOException e) {
			e.printStackTrace();
		}
		getOrderFromCashierSystems();
	}
	
	private void getOrderFromCashierSystems() {
        Socket connectionSocket;
        
        while(true)
        {
           try {
        	   System.out.print(COMPONENT_NAME);
        	   System.out.println( " - Waiting for orders...");
        	   connectionSocket = imsSocket.accept();
        	   System.out.print(COMPONENT_NAME);
        	   System.out.println(" - Incomming connection...");
        	   new OrderReceiverThread(connectionSocket.getInputStream()).start();;
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
	}

	public void run() {
		this.start();
	}
}

class OrderReceiverThread extends Thread {
	private ObjectInputStream inputStream;
	
	public OrderReceiverThread(InputStream inputStream) {
		try {
			this.inputStream = new ObjectInputStream(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void start() {
		Order order = null;
		try {
			order = (Order)inputStream.readObject();
			System.out.println("Order #" + order.getId() + " from cashier id#" + order.getEmployeeId() +" received, sending to ORDER PROCESSOR...");
	        System.out.println(order);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
