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
import java.util.HashMap;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
	
	public void setNotificationForProduct(int product_upc, int supermarket_id, int manager_id, int stock_threshold){
			String sql= "update into products (upc, name, stock_price, count, category_id) values (?, ?, ?, ?)";
			Connection con 	= this.getConnection();
			
			
			try {
			
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			
			preparedStatement.setInt(1, product_upc);
			preparedStatement.setInt(2, supermarket_id);
			preparedStatement.setInt(3, manager_id);
			preparedStatement.setInt(4, stock_threshold );
			preparedStatement.executeUpdate();
			
			
			}
			catch (Exception exc){
				exc.printStackTrace();
			}
			
			this.closeConnection(con);
	}
	
	public void getUpdateFequencyForStore() {
		
	}
	
	public void removeNotificationForProduct(int product_upc, int supermarket_id){
			String sql= "update products set  notify = (?) where product_upc = (?) and supermarket_id = (?);";
			Connection con 	= this.getConnection();
		
			try {
			
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			
			preparedStatement.setBoolean(1, false);
			preparedStatement.setInt(2, product_upc);
			preparedStatement.setInt(3, supermarket_id);

			preparedStatement.executeUpdate();
			
			
			}
			catch (Exception exc){
				exc.printStackTrace();
			}
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
							rs.getInt("category_id"),
							rs.getInt("distributor_id"),
							rs.getInt("manufacturer_id"),
							rs.getDate("date_created")
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
	
	public void getProductByBrand() {
		
	}
	
	public void getProductsBy() {
		
	}
	
	public void getProductsOnInventoryForStore() {
		
	}
	
	
	
	
}
