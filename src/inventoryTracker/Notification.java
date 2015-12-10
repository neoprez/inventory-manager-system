package inventoryTracker;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Notification{
	private String upc;
	private int storeiId;
	private int managerId;
	private int threshold;
	private final int update = 10;

	
	
	public String host = "jdbc:mysql://localhost:3306/inventory_manager";
	public String username = "root";
	public String password = "12345678";
	
	
	public void trackProduct(String upc, int storeID, int threshold){
		Connection connect;
		Statement statement = null;
		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		String sql= "insert into products (upc, name, stock_price, count, category_id)count values (?, ?, ?, ?, ?))";
		try {
//		Class.forName("com.mysql.jdbc.Driver");
		connect = DriverManager.getConnection(host,username,password);
		preparedStatement = connect.prepareStatement(sql);
		
		preparedStatement.setString(1, upc);
		preparedStatement.setInt(2, storeID);
		preparedStatement.setInt(3, threshold);
		
		preparedStatement.executeUpdate();
		
		
		
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
		
		
	}
	
	
   
    public static void main(String[] args){
    			   Notification test = new Notification();
    			   test.trackProduct("1234567891", 12222222, 9);
    		   }
}