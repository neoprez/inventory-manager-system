package com.ims.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import com.ims.classes.InventoryProduct;
import com.ims.classes.Manager;

public class ProductsTracker implements Runnable {
	private Emailer 		emailer;
	private long 			updateFrequency;
	private long			lastTimeChecked;
	private DBUtilities		db = new DBUtilities();
	
	/**
	 * @param updateFrequency The updateFrequency in milliseconds
	 */
	public ProductsTracker(long updateFrequency) {
		this.updateFrequency 	= updateFrequency;
		emailer 				= new Emailer();
		lastTimeChecked			= 0;
	}
	
	public long notifyAboutProductsInNeedToOfRestock() {
		ArrayList<InventoryProduct> products = db.getProductsToBeRestocked();
		
		if( products.size() < 1 ) {
			return -1;
		}
		
		/*
		 * Notify the manager of each supermarket that
		 * these products need to be re-stocked
		 * 
		 * These products are added to map containing a list of products.
		 * The map is structured as supermarked_id => list of products
		 */
		HashMap<Integer, ArrayList<InventoryProduct> > listToNotify = new HashMap<Integer, ArrayList<InventoryProduct> >();
		
		/*
		 * Arrange products by supermarket so that a single message is sent
		 * to each supermarket
		 */
		for(InventoryProduct product : products ) {
			if( listToNotify.containsKey(product.getSupermarketID()) ) {
				listToNotify.get(product.getSupermarketID()).add(product);
			} else {
				ArrayList<InventoryProduct> list = new ArrayList<InventoryProduct>();
				list.add(product);
				listToNotify.put(product.getSupermarketID(), list);
			}
		}
		
		notifyManagers(listToNotify);
		
		/*
		 * The time that it finishes running
		 */
		return System.currentTimeMillis();
	}
	
	public void notifyManagers(HashMap<Integer, ArrayList<InventoryProduct> > listToNotify) {
		Set<Integer> supermarketsId = listToNotify.keySet();
		for(Integer supermarketId : supermarketsId) {
			Manager manager = db.getManagerBySupermarketId(supermarketId);
			/*
			 * Send email to managers in supermarket
			 */
			emailer.sendEmail(manager.getEmailAddress(), listToNotify.get(supermarketId));	
		}
	}

	@Override
	public void run() {
		while(true){
			try {
				notifyAboutProductsInNeedToOfRestock();
				/*
				 * Sleep until next time to update
				 */
				Thread.sleep(this.updateFrequency);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
