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
	private Category category;
	private Manufacturer manufacturer;
	private Distributor distributor;
	private Date dateCreated;
	private static DecimalFormat formatter = new DecimalFormat("$0.00");
	
	public Product(String upc, String name, double price, Category category, Distributor distributor, Manufacturer manufacturer, Date dateCreated){
		this.upc 			= upc;
		this.name 			= name;
		this.price 			= price;
		this.category 		= category;
		this.distributor 	= distributor;
		this.manufacturer	= manufacturer;
		this.dateCreated	= dateCreated;
	}
	public Product(String upc, String name, double price, Category category, Distributor distributor, Manufacturer manufacturer){
		this(upc, name, price, category, distributor, manufacturer, null);
	}
	
	public Product(String upc, String name, double price, Category category){
		this(upc, name, price, category, null, null, null);
	}
	
	public Product() {
		this("", "", 0.0, null, null, null);
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Distributor getDistributor() {
		return distributor;
	}

	public void setDistributor(Distributor distributor) {
		this.distributor = distributor;
	}
	
	public Date getDateCreated() {
		return this.dateCreated;
	}
	
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String toString() {
		return String.format("upc: %1$-14s name: %2$-25s price: "
				+ "%3$5s category: %4$10s "
				+ "manufacturer: %5$10s "
				+ "distributor: %6$10s", 
				this.upc, this.name, formatter.format(this.price), 
				this.category.getName(),
				this.manufacturer.getName(),
				this.distributor.getName());
	}
}
