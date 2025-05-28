package UserPackage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Feedbackpackage.FeedbackDBConnection;

public class UserController {

    // Insert data
    public static boolean insertdata(String name, String phone, String email, String userName, String password) {
        boolean isSuccess = false;

        try {
            Connection con = FeedbackDBConnection.getConnection();
            Statement stmt = con.createStatement();

            String sql = "INSERT INTO Register VALUES (0, '" + name + "', '" + phone + "', '" + email + "', '" + userName + "', '" + password + "')";
            int result = stmt.executeUpdate(sql);

            isSuccess = result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isSuccess;
    }

    // Login validation
    public static List<UserModel> loginValidate(String userName, String password) {
        ArrayList<UserModel> user = new ArrayList<>();

        try {
            Connection con = FeedbackDBConnection.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM Register WHERE userName='" + userName + "' AND password='" + password + "'";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                UserModel u = new UserModel(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("phone"),
                    rs.getString("email"),
                    rs.getString("userName"),
                    rs.getString("password")
                );
                user.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    // Update user profile
    public static boolean updateProfile(String id, String name, String phone, String email, String userName, String password) {
        boolean isSuccess = false;

        String sql = "UPDATE Register SET name=?, phone=?, email=?, userName=?, password=? WHERE id=?";

        try (Connection con = FeedbackDBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, phone);
            pstmt.setString(3, email);
            pstmt.setString(4, userName);
            pstmt.setString(5, password);
            pstmt.setString(6, id);

            int result = pstmt.executeUpdate();
            isSuccess = result > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isSuccess;
    }


    // Get user by ID
    public static List<UserModel> getById(String id) {
        ArrayList<UserModel> userList = new ArrayList<>();

        try {
            Connection con = FeedbackDBConnection.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM Register WHERE id='" + id + "'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                UserModel u = new UserModel(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("phone"),
                    rs.getString("email"),
                    rs.getString("userName"),
                    rs.getString("password")
                );
                userList.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userList;
    }
    
 //delete data
    
    public static boolean deleteAccount(String id) {
        int convId = Integer.parseInt(id);
        boolean isSuccess = false;

        try {
            // DB connection
            Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();

            // Actual DELETE SQL query
            String sql = "DELETE FROM Register WHERE id = " + convId;

            int rs = stmt.executeUpdate(sql);

            if (rs > 0) {
                isSuccess = true;
            } else {
                isSuccess = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isSuccess;
    }
}
