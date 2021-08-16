package MySQL;

/*
 * data insert
 * 
 * version: April 30, 2018 09:06 PM
 * Last revision: May 28, 2018 10:09 AM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;


public class Data_Insert 
{
	String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	String serverName = "localhost"; 	
    String portNumber = "3306";
    String mydatabase = serverName + ":" + portNumber;
    String url = "jdbc:mysql://" + mydatabase + "/";
    String admin_name = "";
   	String admin_pass = "";
    
   	String DBname = "";
	String tablename = "";
   	
	public Data_Insert() throws Exception
	{		
		url = url + DBname;
		
	    Class.forName(JDBC_DRIVER);
	    Connection conn = DriverManager.getConnection(url, admin_name, admin_pass);
	 
	    // create a sql date object so we can use it in our INSERT statement
	     Calendar calendar = Calendar.getInstance();
	     java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
	    // the mysql insert statement
	      String query = " insert into "+ tablename +" (name1, name2, date_created, is_admin, num_points)"+ " values (?, ?, ?, ?, ?)";
	      
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
