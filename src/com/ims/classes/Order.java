package com.ims.classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable{
	private static final long 	serialVersionUID = 5950169519310163575L;
	private int 				id;
	private int 				supermarketId;
	private int 				employeeId;
	private ArrayList<Product> 	products;
	
	public Order(int id, int supermarketId, int employeeId) {
		this.id				= id;
		this.supermarketId	= supermarketId;
		this.employeeId		= employeeId;
		this.products 		= new ArrayList<Product>();
	}
	
	public Order() {
		this(0, 0, 0);
	}
	
	public Order(int supermarketId, int employeeId) {
		this(0, supermarketId, employeeId);
	}
	
	public void addProduct(Product p) {
		this.products.add(p);
	}
	
	public Product removeProduct(int idx) {
		return this.products.remove(idx);
	}
	
	public ArrayList<Product> getProducts() {
		return products;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSupermarketId() {
		return supermarketId;
	}

	public void setSupermarketId(int supermarketId) {
		this.supermarketId = supermarketId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
	/*
	 * True if not empty
	 */
	public boolean hasProducts() {
		return !products.isEmpty();
	}
	
	public int getProductsCount() {
		return products.size();
	}
	
	public String toString() {
		String str = String.format("%1$-22s %2$-55s %3$s", "UPC", "TITLE", "PRICE");
		str += "\n";
		for(Product p : this.products) {
			str += p + "\n";
		}
		return str;
	}
}