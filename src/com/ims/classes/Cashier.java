package com.ims.classes;

public class Cashier extends Employee {
	private boolean isOnMachine;
	
	public Cashier(String firstName, String lastName, String emailAddress) {
		super(firstName, lastName, Position.CASHIER, emailAddress);
		isOnMachine = false;
	}
	
	public boolean hasMachineAssigned() {
		return this.isOnMachine == true;
	}
	
	public void setOnMachine(boolean b){
		this.isOnMachine = b;
	}
}
