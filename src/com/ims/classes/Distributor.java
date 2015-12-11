package com.ims.classes;

import java.io.Serializable;

public class Distributor implements Serializable {
	/**
	 * Necessary for object serialization 
	 */
	private static final long serialVersionUID = 5950169519310163575L;
	private String name;
	private int id;
	
	public Distributor(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Distributor() {
		this(0, "No distributor");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		return "Distributor id #" + this.id + " name: " + this.name;
	}
}
