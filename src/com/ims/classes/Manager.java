package com.ims.classes;

public class Manager extends Employee {
	public Manager(String firstName, String lastName, String emailAddress) {
		super(firstName, lastName, Position.MANAGER, emailAddress);
	}
}