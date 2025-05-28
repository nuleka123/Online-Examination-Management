package Feedbackpackage;

import java.sql.Connection;
import java.sql.DriverManager;

public class FeedbackDBConnection {
	
	private static String url ="jdbc:mysql://127.0.0.1:3306/onlineexammanagement";
	private static String user = "root";
	private static String pass = "Janith135";
	private static Connection con;
	
	
	public static Connection  getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // ✅ correct for MySQL 8+
			con=DriverManager.getConnection(url,user,pass);
			System.out.println("succesfully");
		}
		catch(Exception e) {
			
			e.printStackTrace();
			System.out.println("Database not connection");
			
		}
			
			return con;
	}

}
