package com.demo;
import java.util.ArrayList;

import com.ims.classes.Cashier;
import com.ims.classes.Manager;


public class Supermarket {
	private ArrayList<Cashier> 			cashiers;
	private ArrayList<CashierMachine> 	cashierMachines;
	private Manager						manager;
	private int 						id;
	
	public Supermarket(int id) {
		this.id 			= id;
		this.cashiers 		= new ArrayList<Cashier>();
		this.cashierMachines= new ArrayList<CashierMachine>();
		this.manager		= null;
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
}
