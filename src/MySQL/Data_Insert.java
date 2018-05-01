package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;


/*
 * data insert
 * 
 * version: April 30, 2018 09:06 PM
 * Last revision: April 30, 2018 09:06 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

public class Data_Insert 
{
	String admin_name = "";
	String admin_pass = "";

	public Data_Insert() throws Exception
	{
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	    String myUrl = "jdbc:mysql://localhost:3306/javatest";
	    Class.forName(JDBC_DRIVER);
	    Connection conn = DriverManager.getConnection(myUrl, admin_name, admin_pass);
	 
	    // create a sql date object so we can use it in our INSERT statement
	     Calendar calendar = Calendar.getInstance();
	     java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
	    // the mysql insert statement
	      String query = " insert into users (name1, name2, date_created, is_admin, num_points)"+ " values (?, ?, ?, ?, ?)";
	      
	   // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setString (1, "abc");
	      preparedStmt.setString (2, "ddd");
	      preparedStmt.setDate   (3, startDate);
	      preparedStmt.setBoolean(4, false);
	      preparedStmt.setInt    (5, 2000);
	      
	   // execute the preparedstatement
	      preparedStmt.execute();
	      
	      conn.close();
	}
	
	public static void main(String[] args)
	{
		try {
			Data_Insert DI = new Data_Insert();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
