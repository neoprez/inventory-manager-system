package com.ims.components;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.ims.classes.Category;
import com.ims.classes.Distributor;
import com.ims.classes.InventoryProduct;
import com.ims.classes.Manufacturer;
import com.ims.classes.Product;

public class DBUtilities {
	private static final String CONNECTOR = "jdbc:mysql://";
	private static final String DBNAME = "inventory_manager"; // This is and shall be the only db
	private static String HOST;
	private static String PORT;
	private static String USER;
	private static String PASSWORD;
	
	/*
	 * Initialization block needed to get the information for
	 * connecting to the database.
	 * 
	 * The information to connect to the database must be stored in 
	 * a file named dbconfig.json. The file contains a JSON object
	 * that contains the following fields:
	 *  
	 *  host: ""  		// The host of the db. usually localhost
	 *  port: 0000 		// The port to connect to the db. i.e.: 8889
	 *  user: "" 		// The user that has access to the db.
	 *  password: "" 	// The password of the user.
	 */
	static {
		FileReader fr = null; 
		BufferedReader br = null;
		
		try {
			fr = new FileReader(new File("dbconfig.json"));
			br = new BufferedReader(fr);

			String jsonString = br.readLine();
			
			try {
				JSONParser jp 	= new JSONParser();
				Object obj 		= jp.parse(jsonString);
				
				JSONObject jo 	= (JSONObject)obj;
				HOST 			= (String)jo.get("host");
				USER 			= (String)jo.get("user");
				PORT 			= (String)jo.get("port");
				PASSWORD 		= (String)jo.get("password");
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} catch(FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fr != null ){
					fr.close();
				}	
				
				if(br != null) {
					br.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	/*
	 * Gets a connection to the database
	 */
	private Connection getConnection() {
		Connection con = null;
		
		String url = DBUtilities.CONNECTOR + DBUtilities.HOST + ":" + 
				DBUtilities.PORT + "/" + DBUtilities.DBNAME;
		
		try {
			con = DriverManager.getConnection(url, DBUtilities.USER, DBUtilities.PASSWORD);
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
	
		return con;
	}
	
	private void closeConnection(Connection con) {
		try {
			if( con != null) {
				con.close();	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addProductToInventory() {
		
	}
	
	public void removeProductFromInventory() {
		
	}
	
	public void setNotificationForProduct() {
		
	}
	
	public void getUpdateFequencyForStore() {
		
	}
	
	public void removeNotificationForProduct() {
		
	}
	
	public void setThresholdForProduct() {
		
	}
	
	/**
	 * This function decreases the product count in stock for the supermarket.
	 * 
	 * If at least one of the products could not be updated it, it returns false.
	 * 
	 * @param storeID
	 * @param upcs
	 * @return
	 */
	public boolean decreaseProductCount(int supermarketId, HashMap<String, Integer> upcs) {
		boolean success = false;
		/*
		 * Test if any products upcs.
		 */
		if( upcs.isEmpty() ) { 
			success = false;
		} else {
			String query	= "UPDATE supermarkets_stock SET product_count" + 
							"=product_count-? WHERE product_upc= ? and supermarket_id=?";
			Connection con 	= this.getConnection();
			
			try {
				Set<String> keys = upcs.keySet();
				for(String upc : keys ) {
					PreparedStatement statement = con.prepareStatement(query);
					statement.setInt(1, upcs.get(upc));
					statement.setString(2, upc);
					statement.setInt(3, supermarketId);
					success = statement.execute();					
				}
				
				success = true;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			this.closeConnection(con);
		}
		
		

		return success;
	}
	
	/**
	 * This function increases the product count in stock for the supermarket.
	 * 
	 * If at least one of the products could not be updated it, it returns false.
	 * 
	 * @param storeID
	 * @param upcs
	 * @return
	 */
	public boolean increaseProductCount(int supermarketId, HashMap<String, Integer> upcs) {
		boolean success = false;
		/*
		 * Test if any products upcs.
		 */
		if( upcs.isEmpty() ) { 
			success = false;
		} else {
			String query	= "UPDATE supermarkets_stock SET product_count" + 
							"=product_count+? WHERE product_upc= ? and supermarket_id=?";
			Connection con 	= this.getConnection();
			
			try {
				Set<String> keys = upcs.keySet();
				for(String upc : keys ) {
					PreparedStatement statement = con.prepareStatement(query);
					statement.setInt(1, upcs.get(upc));
					statement.setString(2, upc);
					statement.setInt(3, supermarketId);
					success = statement.execute();					
				}
				
				success = true;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			this.closeConnection(con);
		}
		
		

		return success;
	}
	
	/**
	 * Gets the category given its categoryId
	 * @param categoryId
	 * @return Returns a Category. 
	 */
	public Category getCategoryById(int categoryId) {
		String query 	= "SELECT * FROM categories WHERE id=?";
		Category category = new Category();
		Connection con = this.getConnection();
		
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, categoryId);
			ResultSet result = st.executeQuery();
			
			if( result.next() ) {
				category.setId(result.getInt("id"));
				category.setName(result.getString("name"));
			}
		} catch(SQLException ex ){
			ex.printStackTrace();
		} finally {
			this.closeConnection(con);			
		}

		return category;
	}
	
	/**
	 * Gets the Distributor given its distributorId
	 * @param distributorId
	 * @return Returns a Distributor. 
	 */
	public Distributor getDistributorById(int distributorId) {
		String query 	= "SELECT * FROM distributors WHERE id=?";
		Distributor distributor = new Distributor();
		Connection con = this.getConnection();
		
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, distributorId);
			ResultSet result = st.executeQuery();
			
			if( result.next() ) {
				distributor.setId(result.getInt("id"));
				distributor.setName(result.getString("name"));
			}
		} catch(SQLException ex ){
			ex.printStackTrace();
		} finally {
			this.closeConnection(con);			
		}
		
		return distributor;
	}
	
	/**
	 * Gets the Manufacturer given its manufacturerId
	 * @param manufacturerId
	 * @return Returns a Manufacturer. 
	 */
	public Manufacturer getManufacturerById(int manufacturerId) {
		String query 	= "SELECT * FROM manufacturers WHERE id=?";
		Manufacturer manufacturer = new Manufacturer();
		Connection con = this.getConnection();
		
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, manufacturerId);
			ResultSet result = st.executeQuery();
			
			if( result.next() ) {
				manufacturer.setId(result.getInt("id"));
				manufacturer.setName(result.getString("name"));
			}
		} catch(SQLException ex ){
			ex.printStackTrace();
		} finally {
			this.closeConnection(con);			
		}
		
		return manufacturer;
	}
	
	/*
	 * This function returns a product from the database given its upc.
	 * 
	 * If the product exists it returns a new Product object 
	 */
	public Product getProductByUPC(String upc) {
		String query 	= "SELECT * FROM products WHERE upc='" + upc + "'";
		Connection con 	= this.getConnection();
		Product p		= null;
				
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next()){
				p = new Product(
							rs.getString("upc"),
							rs.getString("name"),
							rs.getDouble("price"),
							getCategoryById(rs.getInt("category_id")),
							getDistributorById(rs.getInt("distributor_id")),
							getManufacturerById(rs.getInt("manufacturer_id")),
							new Date(rs.getLong("date_created"))
						);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeConnection(con);	
		}
		
		return p;
	}
	
	public void getProductByName() {
		
	}
	
	/**
	 * This function returns all the products in inventory for the supermarket.
	 * It selects all the upc from the supermarkets_stock table for which the 
	 * supermarket_id = supermarketId.
	 * 
	 * If the supermarkets has any products in his inventory the an ArrayList of
	 * InventoryProduct is returned otherwise an empty list.
	 * 
	 * @param supermarketId The id of the supermarket
	 * @return ArrayList<InventoryProduct> if no products are found or the supermarket doesn't exists
	 * this list is empty.
	 */
	public ArrayList<InventoryProduct> getProductsOnInventoryForSupermarket(int supermarketId) {
		String stockQuery = "SELECT * FROM supermarkets_stock WHERE supermarket_id=?";
		ArrayList<InventoryProduct> products = new ArrayList<InventoryProduct>();
		
		Connection con = this.getConnection();
		try{
			PreparedStatement stockStatement 	= con.prepareStatement(stockQuery);
			stockStatement.setInt(1, supermarketId);
			
			ResultSet stockResult  				= stockStatement.executeQuery();

			while(stockResult.next()) {
				Product p = getProductByUPC( stockResult.getString("product_upc") );
				products.add(new InventoryProduct(p, 
						stockResult.getBoolean("has_notification"),
						stockResult.getInt("supermarket_id"),
						stockResult.getInt("product_count"),
						new Date(stockResult.getLong("date_added")),
						new Date(stockResult.getLong("date_last_updated"))
						));
			}
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			this.closeConnection(con);
		}
		
		return products;
	}
}
