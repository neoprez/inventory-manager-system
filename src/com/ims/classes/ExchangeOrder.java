package com.ims.classes;

import java.io.Serializable;

public class ExchangeOrder extends Order implements Serializable {
	private static final long 	serialVersionUID = 5950169519310163575L;
	
	public ExchangeOrder(int supermarketId, int cashierId) {
		super(supermarketId, cashierId);
	}
}