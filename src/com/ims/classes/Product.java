package com.ims.classes;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Date;

public class Product implements Serializable{
	/**
	 * Necessary for object serialization 
	 */
	private static final long serialVersionUID = 5950169519310163575L;
	private String upc;
	private String name;
	private double price;
	private int categoryId;
	private int manufacturerId;
	private int distributorId;
	private Date dateCreated;
	private static DecimalFormat formatter = new DecimalFormat("$0.00");
	
	public Product(String upc, String name, double price, int categoryId, int distributorId, int manufacturerId, Date dateCreated){
		this.upc 			= upc;
		this.name 			= name;
		this.price 			= price;
		this.categoryId 	= categoryId;
		this.distributorId 	= distributorId;
		this.manufacturerId	= manufacturerId;
		this.dateCreated	= dateCreated;
	}
	public Product(String upc, String name, double price, int categoryId, int distributorId, int manufacturerId){
		this(upc, name, price, categoryId, distributorId, manufacturerId, null);
	}
	
	public Product(String upc, String name, double price, int categoryId){
		this(upc, name, price, categoryId, 0, 0, null);
	}
	
	public Product() {
		this("", "", 0.0, 0, 0, 0);
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategory(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public int getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public int getDistributorId() {
		return distributorId;
	}

	public void setDistributorId(int distributorId) {
		this.distributorId = distributorId;
	}
	
	public Date getDateCreated() {
		return this.dateCreated;
	}
	
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String toString() {
		return String.format("%1$-22s %2$-55s %3$5s", this.upc, this.name, formatter.format(this.price));
	}
}
