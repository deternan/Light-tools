package MongoDB;

import java.util.List;
import java.util.Set;

import com.mongodb.DB;
import com.mongodb.MongoClient;

/*
 * MongoDB connection
 * 
 * version: March 09, 2017 10:06 AM
 * Last revision: June 07, 2017 10:17 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. Taiwan
 * 
 */


/**
 * JAR
 * mongodb-driver-3.4.2.jar
 * mongodb-driver-core-3.4.2.jar
 * bson-3.4.2.jar
 */

public class MongoDBConn  
{	
    private String host = "localhost";    
    private int port = 27017;    
    String dbName = "";
    //String userName = "";    
    //String userPwd = "";           
	
	public MongoDBConn()
	{		
		ConnectionDB();
	}
	
	private void ConnectionDB()
	{				
		MongoClient mongoClient = new MongoClient(host, port);		
		List<String> databases = mongoClient.getDatabaseNames();		
		
        for (String dbName : databases) 
        {
            // DB names
        	System.out.println("Database: " + dbName);            
            DB db = mongoClient.getDB(dbName);
            
            // Collection
            Set<String> collections = db.getCollectionNames();
            for (String colName : collections) 
            {
                System.out.println("Collection: " + colName);
            }
        }
         
        mongoClient.close();
	}
	
	public static void main(String[] args) 
	{
		MongoDBConn DD = new MongoDBConn();		
	}
	
}
