package com.ims.classes;

import java.io.Serializable;

public class Category implements Serializable {
	/**
	 * Necessary for object serialization 
	 */
	private static final long serialVersionUID = 5950169519310163575L;
	private String name;
	private int id;
	
	public Category(int id, String name) {
		this.name = name;
		this.id = id;
	}
	
	public Category() {
		this(0, "No Category");
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
		return "Category id #" + this.id + " name: " + this.name;
	}
}