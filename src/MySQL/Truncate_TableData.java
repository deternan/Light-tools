package MySQL;

/*
 * data truncate
 * 
 * version: May 25, 2018 07:29 PM
 * Last revision: May 25, 2018 07:57 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Truncate_TableData 
{
	String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	String serverName = "";
    String portNumber = "";
    String mydatabase = serverName + ":" + portNumber;
    String url = "jdbc:mysql://" + mydatabase;
    String admin_name = "";
	String admin_pass = "";
    
	String DBname = "javatest";
	String tablename = "new_video";
	
	public Truncate_TableData() throws Exception
	{
		Class.forName(JDBC_DRIVER);		
		Connection connection = DriverManager.getConnection(url, admin_name, admin_pass);
		Statement stmt = connection.createStatement();

		// Use TRUNCATE
	    String sql = "TRUNCATE "+DBname+"."+tablename;
	    // Execute deletion
	    stmt.executeUpdate(sql);
	    // Use DELETE
	    //sql = "DELETE FROM my_table";
	    // Execute deletion
	    //stmt.executeUpdate(sql);
	    
	    System.out.println("Finished");
	}
	
	public static void main(String[] args)
	{
		try {
			Truncate_TableData dr = new Truncate_TableData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
