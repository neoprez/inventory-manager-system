package com.demo;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.ims.classes.Order;

/*
 * This class serves as a client to send the orders completed by 
 * the cashier machines to the IMS
 */
public class OrderSender{
	public void sendOrder(Order order) {
		Socket orderReceiverSocket = null;
		try {
			/*
			 * socket 
			 */
			orderReceiverSocket = new Socket("localhost", 6789);
			ClientSender cs = new ClientSender(orderReceiverSocket, order);
	        cs.start();
		} catch(Exception ex){
			ex.printStackTrace();
		} finally {
			if( orderReceiverSocket != null) {
				try {
					orderReceiverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

class ClientSender extends Thread {
	private Socket orderReceiverSocket;
	private Order order;
	
	public ClientSender(Socket orderReceiverSocket, Order order) {
		this.orderReceiverSocket = orderReceiverSocket;
		this.order 				 = order;
	}
	
	public void start() {
		ObjectOutputStream outToServer;
		try {
			outToServer = new ObjectOutputStream(orderReceiverSocket.getOutputStream());
	        System.out.print("ORDER SENDER - ");
	        System.out.println("SERIALIZING OBJECT....");
	        outToServer.writeObject(order);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}