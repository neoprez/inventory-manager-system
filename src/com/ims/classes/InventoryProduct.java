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
		super(p.getUpc(), p.getName(), p.getPrice(), p.getCategoryId(),
			  p.getDistributorId(), p.getManufacturerId(), p.getDateCreated());
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
	
	public boolean isHasNotification() {
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