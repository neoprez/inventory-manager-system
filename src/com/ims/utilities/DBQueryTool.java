package com.ims.utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class DBQueryTool {
	
	/*
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
			DBConnector.closeConnection(con);
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		/*DBQueryTool.addEmployee("Rodny", "Perez", 1, "Manager");*/
		String[][] employees = DBQueryTool.getEmployees();
		
		System.out.println(Arrays.toString(employees[0]));
	}
}
