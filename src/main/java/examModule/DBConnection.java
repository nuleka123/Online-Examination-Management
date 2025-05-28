package examModule;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	private static String url ="jdbc:mysql://127.0.0.1:3306/onlineexammanagement";
	private static String user = "root";
	private static String pass = "Janith135";
	private static Connection conn;
	
	public static Connection getconnection () {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
				
		}
		catch(Exception e) {
			System.out.println("database not connect");
		}
		return conn;
	}
}
