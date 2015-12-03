package com.ims.utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class DBQueryTool {
	
	/**
	 * This method returns all the employees from all stores.
	 * 
	 * Returns an 2D string array until Larry creates all the classes.
	 * 
	 * Note this method might never be used. But is good for testing purposes.
	 */
	public static String[][] getEmployees() {
		Statement st = null;
		ResultSet rs = null;
		Connection con = DBConnector.getConnection();

		String[][] employees = new String[1][6];
		
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM employees");
			
			while(rs.next()) {
				employees[0][0] = rs.getString("id");
				employees[0][1] = rs.getString("first_name");
				employees[0][2] = rs.getString("last_name");
				employees[0][3] = rs.getString("store_id");
				employees[0][4] = rs.getString("position");
				employees[0][5] = rs.getString("date_created");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if ( rs != null ) {
					rs.close();
				}
				
				if ( st != null ) {
					st.close();
				}
				DBConnector.closeConnection(con);
			} catch( SQLException ex ){
				ex.printStackTrace();
			}
		}
		
		return employees;
	}
	
	/**
	 * This method adds a new employee to the database.
	 * Necessary for the creation of employees.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param storeId
	 * @param position
	 */
	public static void addEmployee(String firstName, String lastName, int storeId, String position) {
		Connection con = DBConnector.getConnection();
		
		try {
			String query = "INSERT INTO employees (first_name, last_name, store_id, position) VALUES (?,?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, firstName);
			st.setString(2, lastName);
			st.setInt(3, storeId);
			st.setString(4, position);
			
			st.execute();
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			DBConnector.closeConnection(con);
		}
	}
	
	/**
	 * This function is to add a new product to the supermarkets database. 
	 * It is not meant to add a product to the supermarket stock.
	 * 
	 * It is for the "Add new product" requirement within the application.
	 * @param upc
	 * @param name
	 * @param stockPrice
	 * @param onSalePrice
	 * @param categoryID
	 * @param thumbnail
	 * Returns true if the product has been successfully added, otherwise false.
	 */
	public static boolean addProduct(String upc, String name, double stockPrice, 
								double onSalePrice, int categoryID, String thumbnail) {
		Connection con = DBConnector.getConnection();
		boolean hasBeenAdded = true;
		
		try {
			String query = "INSERT INTO products (upc, name, stock_price, on_sale_price, category_id, thumbnail) VALUES (?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1,  upc);
			st.setString(2, name);
			st.setDouble(3, stockPrice);
			st.setDouble(4, onSalePrice);
			st.setInt(5, categoryID);
			st.setString(6, thumbnail);
			st.execute();
		}  catch( MySQLIntegrityConstraintViolationException ex) { 
			System.out.println(ex.getMessage() );
			hasBeenAdded = false;
		} catch(SQLException ex) {
			ex.printStackTrace();
			hasBeenAdded = false;
		} finally {
			DBConnector.closeConnection(con);
		}
		
		return hasBeenAdded;
	}
	
	/**
	 * @return This function returns a list of all available products that are already 
	 * within the system's database.
	 * 
	 */
	public static ArrayList<String[]> getProducts() {
		Statement st = null;
		ResultSet rs = null;
		Connection con = DBConnector.getConnection();
		
		ArrayList<String[]> products = new ArrayList<String[]>();
		
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM products");
			
			while(rs.next()) {
				String[] product = new String[7];
				product[0] = rs.getString("date_created");
				product[1] = rs.getString("name");
				product[2] = rs.getString("upc");
				product[3] = rs.getString("stock_price");
				product[4] = rs.getString("on_sale_price");
				product[5] = rs.getString("category_id");
				product[6] = rs.getString("thumbnail");
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if ( rs != null ) {
					rs.close();
				}
				
				if ( st != null ) {
					st.close();
				}
				DBConnector.closeConnection(con);
			} catch( SQLException ex ){
				ex.printStackTrace();
			}
		}
		
		return products;
	}
	
	public static void main(String[] args) {
		/*DBQueryTool.addEmployee("Rodny", "Perez", 1, "Manager");*/
		/*if( DBQueryTool.addProduct("123212435412", "Pickles", 0.99, 1.1, 0, "") ) {
			System.out.println("Product successfully added.");
		}*/
		ArrayList<String[]> products = DBQueryTool.getProducts(); //DBQueryTool.getEmployees();
		
		for(String[] product : products ) {
			System.out.println(Arrays.toString(product));
		}
	}
}
