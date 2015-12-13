package com.ims.classes;

public abstract class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private int supermarketId;
	private Position position;
	private String emailAddress;
	
	public Employee(String firstName, String lastName, Position position, String emailAddress) {
		this.firstName 			= firstName;
		this.lastName 			= lastName;
		this.position 			= position;
		this.id					= 0;
		this.supermarketId		= 0;
		this.emailAddress		= emailAddress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSupermarketId() {
		return supermarketId;
	}

	public void setSupermarketId(int supermarketId) {
		this.supermarketId = supermarketId;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getEmailAddress() {
		return this.emailAddress;
	}
	
}