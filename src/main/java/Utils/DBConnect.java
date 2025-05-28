package Utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url ="jdbc:mysql://127.0.0.1:3306/onlineexammanagement";
        	String user = "root";
        	String pass = "Janith135";

            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println("Database Connection Failed!");
            e.printStackTrace();
        }
        return con;
    }

    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("Connection successful!");
        }
    }

}
