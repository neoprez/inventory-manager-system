package com.ims.components;

/**
 * The purpose of this class is to initialize all the components
 * that forms the IMS on the server side.
 * 
 * The OrderReceiver component
 * The OrderProcessor component
 * and the ProductsTracker component are initialized in
 * this class.
 * @author rodnyperez
 *
 */
public class IMSServer extends Thread{
	private OrderProcessor orderProcessor;
	private OrderReceiver orderReceiver;
	private ProductsTracker productsTracker;
	private final long updateFrequency = 60000; // 60 seconds
	
	public IMSServer() {
		orderProcessor = new OrderProcessor();
		orderReceiver = new OrderReceiver();
		productsTracker = new ProductsTracker(updateFrequency);
		orderReceiver.setOrderProcessor(orderProcessor);
	}
	
	public void run() {
		Thread processorThread = new Thread(orderProcessor);
		Thread receiverThread = new Thread(orderReceiver);
		Thread trackerThread = new Thread(productsTracker);
		
		processorThread.start();
		receiverThread.start();
		trackerThread.start();
	}
	
	public static void main(String[] args) {
		IMSServer ims = new IMSServer();
		ims.start();
	}
}
