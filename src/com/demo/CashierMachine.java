package com.demo;

import java.util.Random;

import com.ims.classes.Cashier;
import com.ims.classes.CustomerOrder;
import com.ims.classes.ExchangeOrder;
import com.ims.classes.Product;
import com.ims.classes.ReturnOrder;
import com.ims.classes.Supermarket;

public class CashierMachine {
	private Cashier cashier;
	private CustomerOrder order;
	private ReturnOrder returnOrder;
	private ExchangeOrder exchangeOrder;
	private Supermarket supermarket;
	private int id;
	
	public CashierMachine(Cashier cashier, Supermarket supermarket) {
		this.cashier 		= cashier;
	
		if( this.cashier != null){
			this.cashier.setOnMachine(true);
		}

		this.supermarket 	= supermarket;
		this.order 			= null;
		this.returnOrder	= null;
		this.exchangeOrder	= null;
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
	
	public void startCustomerOrder() {
		this.order = new CustomerOrder(this.supermarket.getId(), this.cashier.getId());
		this.order.setId(new Random().nextInt(100)+1);
		System.out.print("CASHIER MACHINE #" + this.id);
		System.out.println(" - started order #" + this.order.getId());
	}
	
	public void startReturnOrder() {
		this.returnOrder = new ReturnOrder(this.supermarket.getId(), this.cashier.getId());
		this.returnOrder.setId(new Random().nextInt(100)+1);
		System.out.print("CASHIER MACHINE #" + this.id);
		System.out.println(" - started order #" + this.order.getId());
	}
	
	public void startExchangeOrder() {
		this.exchangeOrder = new ExchangeOrder(this.supermarket.getId(), this.cashier.getId());
		this.exchangeOrder.setId(new Random().nextInt(100)+1);
		System.out.print("CASHIER MACHINE #" + this.id);
		System.out.println(" - started order #" + this.order.getId());
	}
	
	public void addProduct(Product p) {
		this.order.addProduct(p);
	}
	
	public CustomerOrder completeCustomerOrder() {
		/*
		 * Save to database then pay
		 */
		CustomerOrder theOrder 	= this.order;
		System.out.print("CASHIER MACHINE #" + this.id);
		System.out.println(" - order #" + this.order.getId() + " has been completed.");
		this.order 		= null;
		return theOrder;
	}
	
	public ExchangeOrder completeExchangeOrder() {
		/*
		 * Save to database then pay
		 */
		ExchangeOrder theOrder 	= this.exchangeOrder;
		System.out.print("CASHIER MACHINE #" + this.id);
		System.out.println(" - order #" + this.exchangeOrder.getId() + " has been completed.");
		this.exchangeOrder 		= null;
		return theOrder;
	}
	
	public ReturnOrder completeReturnOrder() {
		/*
		 * Save to database then pay
		 */
		ReturnOrder theOrder 	= this.returnOrder;
		System.out.print("CASHIER MACHINE #" + this.id);
		System.out.println(" - order #" + this.returnOrder.getId() + " has been completed.");
		this.returnOrder 		= null;
		return theOrder;
	}
	
	public void cancelOrder() {
		this.order = null;
		this.returnOrder = null;
		this.exchangeOrder = null;
	}
	
	public boolean hasCashierAssigned() {
		return this.cashier != null;
	}
	
	public Product removeProductFromCustomerOrder(int idx) {
		return this.order.removeProduct(idx);
	}
	
	public Product removeProductFromExchangeOrder(int idx) {
		return this.exchangeOrder.removeProduct(idx);
	}
	
	public Product removeProductFromReturnOrder(int idx) {
		return this.returnOrder.removeProduct(idx);
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
}
