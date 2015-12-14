package com.ims.classes;
import java.util.ArrayList;

import com.demo.CashierMachine;
import com.ims.components.DBUtilities;


public class Supermarket {
	private ArrayList<Cashier> 			cashiers;
	private ArrayList<CashierMachine> 	cashierMachines;
	private Manager						manager;
	private ArrayList<InventoryProduct> products;
	private int 						id;
	private DBUtilities					db = new DBUtilities();
	
	public Supermarket(int id) {
		this.id 			= id;
		this.cashiers 		= new ArrayList<Cashier>();
		this.cashierMachines= new ArrayList<CashierMachine>();
		this.manager		= null;
		this.products		= db.getProductsOnInventoryForSupermarket(id);
	}
	
	public void addCashier(Cashier c) {
		cashiers.add(c);
	}
	
	public void setManager(Manager m){
		this.manager = m;
	}
	
	public void addCashierMachine(CashierMachine cashierMachine) {
		this.cashierMachines.add(cashierMachine);
	}
	
	public int getId() {
		return this.id;
	}
	
	public ArrayList<Cashier> getCashiers() {
		return this.cashiers;
	}
	
	public Manager getManager() {
		return this.manager;
	}
	
	public ArrayList<InventoryProduct> getProducts() {
		return products;
	}
	
	public void addProduct(InventoryProduct inventoryProduct) {
		products.add(inventoryProduct);
	}
	
	public ArrayList<CashierMachine> getCashierMachines() {
		return this.cashierMachines;
	}
}
