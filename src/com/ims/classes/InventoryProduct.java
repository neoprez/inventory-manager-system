package com.ims.classes;

import java.util.Date;

public class InventoryProduct extends Product {
	/**
	 * Necessary for object serialization 
	 */
	private static final long serialVersionUID = 5950169519310163575L;
	private boolean hasNotification;
	private int supermarketID;
	private int count;
	private Date dateAdded;
	private Date dateLastUpdated;
	
	public InventoryProduct(Product p) {
		/*
		 * Does a shallow copy of the product. Whats important are the attributes
		 */
		super(p.getUpc(), p.getName(), p.getPrice(), p.getCategory(),
			  p.getDistributor(), p.getManufacturer(), p.getDateCreated());
		this.hasNotification = false;
		this.supermarketID	= 0;
		this.count = 0;
		this.dateAdded = null;
		this.dateLastUpdated = null;
	}
	
	public InventoryProduct(Product p, boolean hasNotification, int supermarketID, 
			int count, Date dateAdded, Date dateLastUpdated) {
		this(p);
		this.hasNotification = hasNotification;
		this.supermarketID	= supermarketID;
		this.count = count;
		this.dateAdded = dateAdded;
		this.dateLastUpdated = dateLastUpdated;
	}
	
	public InventoryProduct() {
		super();
		this.hasNotification = false;
		this.supermarketID = 0;
		this.count = 0;
		this.dateAdded = null;
		this.dateLastUpdated = null;
	}
	
	public boolean hasNotification() {
		return hasNotification;
	}
	public void setHasNotification(boolean hasNotification) {
		this.hasNotification = hasNotification;
	}
	public int getSupermarketID() {
		return supermarketID;
	}
	public void setSupermarketID(int supermarketID) {
		this.supermarketID = supermarketID;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	public Date getDateLastUpdated() {
		return dateLastUpdated;
	}
	public void setDateLastUpdated(Date dateLastUpdated) {
		this.dateLastUpdated = dateLastUpdated;
	}
	
	
}