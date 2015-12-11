package com.demo;

import java.util.Random;

import com.ims.classes.Cashier;
import com.ims.classes.CustomerOrder;
import com.ims.classes.Order;
import com.ims.classes.Product;

public class CashierMachine {
	private Cashier cashier;
	private CustomerOrder order;
	private Supermarket supermarket;
	private int id;
	
	public CashierMachine(Cashier cashier, Supermarket supermarket) {
		this.cashier 		= cashier;
	
		if( this.cashier != null){
			this.cashier.setOnMachine(true);
		}

		this.supermarket 	= supermarket;
		this.order 			= null;
		this.id 			= 0;
	}
	
	/*
	 * This allows the initialization of a cashier machine without a cashier 
	 * being logged in. The supermarket instance is necessary so that
	 * we know to which supermarket this cashier machine belongs to.
	 */
	public CashierMachine(Supermarket supermarket) {
		this(null, supermarket);
	}
	
	public void setCashier(Cashier cashier) {
		 this.cashier = cashier;
		 this.cashier.setOnMachine(true);
	}
	
	public Cashier getCashier() {
		return cashier;
	}
	
	public void startOrder() {
		this.order = new CustomerOrder(this.supermarket.getId(), this.cashier.getId());
		this.order.setId(new Random().nextInt(100)+1);
		System.out.print("CASHIER MACHINE #" + this.id);
		System.out.println(" - started order #" + this.order.getId());
	}
	
	public void addProduct(Product p) {
		this.order.addProduct(p);
	}
	
	public CustomerOrder completeOrder() {
		/*
		 * Save to database then pay
		 */
		CustomerOrder theOrder 	= this.order;
		System.out.print("CASHIER MACHINE #" + this.id);
		System.out.println(" - order #" + this.order.getId() + " has been completed.");
		this.order 		= null;
		return theOrder;
	}
	
	public void cancelOrder() {
		this.order = null;
	}
	
	public boolean hasCashierAssigned() {
		return this.cashier != null;
	}
	
	public Product removeProduct(int idx) {
		return this.order.removeProduct(idx);
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
}
