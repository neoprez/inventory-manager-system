package inventoryTracker;


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
	public Connection connect;
	public Statement statement = null;
	public PreparedStatement preparedStatement;
	public ResultSet resultSet = null;
	
	public String host = "jdbc:mysql://localhost:3306/inventory_manager";
	public String username = "root";
	public String password = "12345678";
	
	
	public void setNotification(int product_upc, int supermarket_id, int manager_id, int stock_threshold){
		String sql= "insert into products (upc, name, stock_price, count, category_id) values (?, ?, ?, ?, ?)";
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		connect = DriverManager.getConnection(host,username,password);
		
		preparedStatement = connect.prepareStatement(sql);
		
		preparedStatement.setInt(1, product_upc);
		preparedStatement.setInt(2, supermarket_id);
		preparedStatement.setInt(3, manager_id);
		preparedStatement.setInt(4, stock_threshold );
		preparedStatement.executeUpdate();
		
		
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
		
		
	}
	
	
	public void removeNotification(int product_upc, int supermarket_id){
		String sql= "update products set  notify = (?) where product_upc = (?) and supermarket_id = (?);";
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		connect = DriverManager.getConnection(host,username,password);
		
		preparedStatement = connect.prepareStatement(sql);
		
		preparedStatement.setBoolean(1, false);
		preparedStatement.setInt(2, product_upc);
		preparedStatement.setInt(3, supermarket_id);

		preparedStatement.executeUpdate();
		
		
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
		
		
	}
	
	public void getNotifications(){
		
		
		
	}
	
   
    public static void main(String[] args){
    			  
    		   }
}