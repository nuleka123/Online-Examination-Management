package Feedbackpackage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FeedbackController{

    private static final String Id = null;
	private static boolean isSuccess;
    private static Connection con = null;
    private static Statement stmt = null;
    private static ResultSet rs=null;

    //insert Data function
    public static boolean insertdata(String Name, String Email, String Subject, String Message) {
        isSuccess = false;

        try {
        	
        	//DB connection call
        	
        	con=FeedbackDBConnection.getConnection();
        	stmt=con.createStatement();
        	
        	// query
        	 String sql = "INSERT INTO FeedBack values(0,'"+Name+"','"+Email+"','"+Subject+"','"+Message+"')";
        	 int rs=stmt.executeUpdate(sql);
        	 

            if (rs > 0) {
                isSuccess = true;
            }else {
            	isSuccess=false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isSuccess;
        
    }
    //
    public static List<FeedbackModel>getById(String id){
    	
    	int convertedId=Integer.parseInt(id);
    	
    	ArrayList <FeedbackModel>Feed= new ArrayList<>();
    	
    	try {
    		//DBConnection
    		con=FeedbackDBConnection.getConnection();
        	stmt=con.createStatement();
        	
        	//query
        	
        	String sql="select * from FeedBack where Id '"+convertedId+"'";
        	
    		rs=stmt.executeQuery(sql);
    		
    		while(rs.next()) {
    			
    			int Id=rs.getInt(1);
    			String Name=rs.getString(2);
    			String Email=rs.getString(3);
    			String Subject=rs.getString(4);
    			String Message=rs.getString(5);
    			
    			FeedbackModel Fb = new FeedbackModel(Id,Name,Email,Subject,Message);
    			
    			Feed.add(Fb);		
    		}
    	}
    	catch(Exception e) {
    		
    		e.printStackTrace();
    		
    	}
    	
    	return Feed;
    	
    }
    //GetAll Data
    
    public static List<FeedbackModel> getAllFeed(){
    	
    	ArrayList <FeedbackModel>Feeds= new ArrayList<>();
    	

    	try {
    		//DBConnection
    		con=FeedbackDBConnection.getConnection();
        	stmt=con.createStatement();
        	
        	//query
        	
        	String sql="select * from FeedBack ";
        	
    		rs=stmt.executeQuery(sql);
    		
    		while(rs.next()) {
    			
    			int Id=rs.getInt(1);
    			String Name=rs.getString(2);
    			String Email=rs.getString(3);
    			String Subject=rs.getString(4);
    			String Message=rs.getString(5);
    			
    			FeedbackModel Fb = new FeedbackModel(Id,Name,Email,Subject,Message);
    			
    			Feeds.add(Fb);
 			
    		}
    	}
    	catch(Exception e) {
    		
    		e.printStackTrace();
    		
    	}
    	
    	return Feeds;
    	
    }
    //Update data
  

    //
    public static boolean updatedata(String Id,String  Name,String Email,String Subject,String Message) {
    	
    	try {
    		
    		//DBConnection
    		con=FeedbackDBConnection.getConnection();
        	stmt=con.createStatement();
        	
        	
			//query
        	String sql="update FeedBack set Name='"+Name+"',Email='"+Email+"',Subject='"+Subject+"',Message='"+Message+"'"
        	+"where Id='"+Id+"'";
        	
        	int rs=stmt.executeUpdate(sql);
        	
        	  if (rs > 0) {
                  isSuccess = true;
              }
        	  else {
              	isSuccess=false;
              }
        	
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	return isSuccess;
    }
    //delete data
    
    public static boolean deletedata(String Id) {
        int convId = Integer.parseInt(Id);
        isSuccess = false;

        try {
            // DB connection
            con = FeedbackDBConnection.getConnection();
            stmt = con.createStatement();

            // Actual DELETE SQL query
            String sql = "DELETE FROM FeedBack WHERE Id = " + convId;

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


















