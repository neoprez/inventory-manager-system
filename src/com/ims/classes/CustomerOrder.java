package com.ims.classes;

import java.io.Serializable;

public class CustomerOrder extends Order implements Serializable {
	private static final long 	serialVersionUID = 5950169519310163575L;
	
	public CustomerOrder(int supermarketId, int cashierId) {
		super(supermarketId, cashierId);
	}
}
