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
	private long updateFrequency; // 60 seconds
	Thread processorThread;
	Thread receiverThread;
	Thread trackerThread;
	
	public IMSServer(long updateFrequency) {
		this.updateFrequency = updateFrequency;
		orderProcessor = new OrderProcessor();
		orderReceiver = new OrderReceiver();
		productsTracker = new ProductsTracker(updateFrequency);
		orderReceiver.setOrderProcessor(orderProcessor);
		processorThread = new Thread(orderProcessor);
		receiverThread = new Thread(orderReceiver);
		trackerThread = new Thread(productsTracker);
	}
	
	public IMSServer() {
		this(10000); //10 seconds default
	}
	
	public void setUpdateFrequency(long updateFrequency) {
		this.updateFrequency = updateFrequency;
		this.productsTracker.setUpdateFrequency(updateFrequency);
	}
	
	public long getUpdateFrequency() {
		return this.updateFrequency;
	}
	
	public void run() {
		if( !processorThread.isAlive() ) {
			processorThread = new Thread(orderProcessor);
		}
		
		if( !receiverThread.isAlive() ) {
			receiverThread = new Thread(orderReceiver);
		}
		
		if( !trackerThread.isAlive() ) {
			trackerThread = new Thread(productsTracker);
		}
		processorThread.start();
		receiverThread.start();
		trackerThread.start();
	}
	
	public void stopServicest() {
		if( processorThread.isAlive() )
			processorThread.interrupt();
		
		if( receiverThread.isAlive() )
			receiverThread.interrupt();
		
		if( trackerThread.isAlive() )
			trackerThread.interrupt();
	}
	
	public static void main(String[] args) {
		IMSServer ims = new IMSServer();
		ims.start();
	}
}
