package com.demo;

import java.util.ArrayList;

import com.ims.classes.Category;
import com.ims.classes.Distributor;
import com.ims.classes.InventoryProduct;
import com.ims.classes.Manufacturer;
import com.ims.classes.Product;
import com.ims.components.DBUtilities;

public class DBUtilitiesDemo {
	public static void main(String[] args) {
		DBUtilities db = new DBUtilities();
		InventoryProduct p = new InventoryProduct();
		p.setUpc("384293829823");
		p.setPrice(10.00);
		p.setName("Dog food");
		p.setCategory(new Category(3, "Dog Food"));
		p.setDistributor(new Distributor(1, "Alabama"));
		p.setManufacturer(new Manufacturer(1, "THe manufacturer"));
		p.setHasNotification(false);
		p.setSupermarketID(2);
		p.setCount(470);
		
		/*if( db.addProductToInventory(p.getSupermarketID(), p) ) {
			System.out.println("Success");
		} else {
			System.out.println("Error");
		}
		ArrayList<Product> products = db.getAllProducts();
		for(Product product: products) {
			System.out.println(product);
		}*/
		
		db.removeProductFromInventory(1, "1000000033");
	}
}
