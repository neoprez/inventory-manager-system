package com.ims.classes;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Product implements Serializable{
	/**
	 * Necessary for object serialization 
	 */
	private static final long serialVersionUID = 5950169519310163575L;
	private String upc;
	private String name;
	private double price;
	private int category;
	private static DecimalFormat formatter = new DecimalFormat("$0.00");
	
	public Product(String upc, String name, double price, int category){
		this.upc 		= upc;
		this.name 		= name;
		this.price 		= price;
		this.category 	= category;
	}
	
	public Product() {
		this("", "", 0.0, 0);
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

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}
	
	public String toString() {
		return String.format("%1$-22s %2$-55s %3$5s", this.upc, this.name, formatter.format(this.price));
	}
}
