package com.ims.components;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Notification{
	private final int frequency = 10;
	
	// SQL Stuff
	public static Connection connect;
	public static PreparedStatement preparedStatement;
	
	;
	
	
	public static void setNotification(int product_upc, int supermarket_id, int manager_id, int stock_threshold){

		String sql = "update product_threshold_notification set stock_threshold = (?) where product_upc = (?) and supermarket_id = (?)";


		DBUtilities.getConnection();
		try{
		preparedStatement = connect.prepareStatement(sql);
		
		preparedStatement.setInt(1, product_upc);
		preparedStatement.setInt(2, supermarket_id);
		preparedStatement.setInt(3, manager_id);
		preparedStatement.setInt(4, stock_threshold );
		preparedStatement.executeUpdate();
		}
		catch(SQLException ex){
			
		}
		
	}
	
	
	public static void removeNotification(int product_upc, int supermarket_id){
		String sql= "update products set notify = (?) where product_upc = (?) and supermarket_id = (?);";
		
		DBUtilities.getConnection();
		try {
		
		preparedStatement = connect.prepareStatement(sql);
		
		preparedStatement.setBoolean(1, false);
		preparedStatement.setInt(2, product_upc);
		preparedStatement.setInt(3, supermarket_id);

		preparedStatement.executeUpdate();
		
		
		}
		catch (SQLException exc){
			exc.printStackTrace();
		}
		
		
	}
	
	public void getNotifications(){
		
		
		
	}
	
	public static void main(String[] args) {
		Notification.removeNotification(1, 2);
	}

}