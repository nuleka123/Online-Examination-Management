package examModule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class modelController {
	//connection DB
	private static boolean isSuccess;
	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	//insert Data Function
	public static boolean insertdata(String moduleName, String moduleNum, String timeDiuration, String imagePath) {
	    boolean isSuccess = false;

	    try {
	        // DB connection
	        conn = DBConnection.getconnection();

	        // Use PreparedStatement to avoid SQL injection and handle strings safely
	        String sql = "INSERT INTO exammodule (id, moduleName, modulenum, timeDiuration, picture) VALUES (?, ?, ?, ?, ?)";
	        PreparedStatement pstmt = conn.prepareStatement(sql);

	        pstmt.setInt(1, 0); // assuming 'id' is auto-increment, you can set it to null or remove if needed
	        pstmt.setString(2, moduleName);
	        pstmt.setString(3, moduleNum);
	        pstmt.setString(4, timeDiuration);
	        pstmt.setString(5, imagePath);  // Save the file path instead of binary data

	        int rs = pstmt.executeUpdate();

	        if (rs > 0) {
	            isSuccess = true;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return isSuccess;
	}

	
	//get by id
	public static List<moduleModle> getById(String Id) {
	    List<moduleModle> moduleList = new ArrayList<>();
	    
	    int convertedID;
	    try {
	        convertedID = Integer.parseInt(Id);
	    } catch (NumberFormatException e) {
	        e.printStackTrace();
	        return moduleList; // return empty list if id is invalid
	    }

	    String sql = "SELECT * FROM exammodule WHERE id = ?";
	    
	    try (
	        Connection conn = DBConnection.getconnection();
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	    ) {
	        pstmt.setInt(1, convertedID);
	        try (ResultSet rs = pstmt.executeQuery()) {
	            while (rs.next()) {
	                int id = rs.getInt("id");  // or rs.getInt(1)
	                String moduleName = rs.getString("moduleName");  // or rs.getString(2)
	                String moduleNum = rs.getString("moduleNum");
	                String timeDiuration = rs.getString("timeDiuration");
	                String picture = rs.getString("picture");
	                
	                moduleModle mk = new moduleModle(id, moduleName, moduleNum, timeDiuration, picture);
	                moduleList.add(mk);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return moduleList;
	}
	
	//get all data
	public static List<moduleModle> getAllModle(){
		
		ArrayList <moduleModle> modules = new ArrayList<>();
		
		try {
			//DB connection called
			conn = DBConnection.getconnection();
			stmt = conn.createStatement();
			
			//query
			String sql = "select * from exammodule";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String moduleName = rs.getString(2);
				String moduleNum = rs.getString(3);
				String timeDiuration = rs.getString(4);
				String picture = rs.getString(5);
				System.out.println(picture);
				
				moduleModle mk = new moduleModle(id,moduleName,moduleNum,timeDiuration,picture);
				modules.add(mk);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return modules;
	}
	
	//update data
	public static boolean updatedata(String id, String moduleName, String moduleNum, String timeDiuration, byte[] picture){
		try {
			//DB connection called
			conn = DBConnection.getconnection();
			stmt = conn.createStatement();
			
			//SQL query
			
			String sql = "update exammodule set moduleName='"+moduleName+"',moduleNum='"+moduleNum+"',timeDiuration='"+timeDiuration+"',picture='"+picture+"'"
					+"where id='"+id+"'";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	//Delete data
	
	public static boolean deletedata(String id)
	{
		int convID = Integer.parseInt(id);
		try
		{
			//DB connection
			conn = DBConnection.getconnection();
			stmt = conn.createStatement();
			
			//SQL
			String sql = "delete from exammodule where id = '"+convID+"'";
			
			int rs = stmt.executeUpdate(sql);	
			if(rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	public static byte[] getImageById(String id) {
        byte[] image = null;

        try (Connection conn = DBConnection.getconnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT picture FROM exammodule WHERE id = ?")) {

            stmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                image = rs.getBytes("picture");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return image;
    }
	
	public static boolean updatedata(String id, String moduleName, String moduleNum, String timeDiuration, String picturePath) {
	    boolean result = false;
	    Connection con = null;
	    PreparedStatement ps = null;
	    try {
	        con = DBConnection.getconnection();
	        String sql = "UPDATE exammodule SET moduleName=?, moduleNum=?, timeDiuration=?, picture=? WHERE id=?";
	        ps = con.prepareStatement(sql);
	        ps.setString(1, moduleName);
	        ps.setString(2, moduleNum);
	        ps.setString(3, timeDiuration);
	        ps.setString(4, picturePath); // store path, NOT bytes
	        ps.setString(5, id);
	        int rowsUpdated = ps.executeUpdate();
	        result = (rowsUpdated > 0);
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	    	
	        // close Ps and Con
	    }
	    return result;
	}

}
