package com.ims.tests;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import com.ims.components.DBUtilities;

public class DBUtilitiesTest {
	private DBUtilities dbAPI;
	
	@Before
	public void setUp() {
		dbAPI = new DBUtilities();
		System.out.println("@Before - setUp");
	}
	
	@Test
	public void testUpdateProductCountShouldBeFalse() {
		/*
		 * Passes an empty list to updateProductCount()
		 */
		HashMap<String, Integer> productsByUPC = new HashMap<String, Integer>();
		assertFalse(dbAPI.decreaseProductCount(0,productsByUPC));
		System.out.println("@Test- passing an empty map");
	}
	
	@Test
	public void testUpdateProductCountShouldBeTrue() {
		HashMap<String, Integer> productsByUPC = new HashMap<String, Integer>();
		productsByUPC.put("123143234312", 1);
		assertTrue(dbAPI.decreaseProductCount(0,productsByUPC));
		System.out.println("@Test- passing a valid map");
	}

}
