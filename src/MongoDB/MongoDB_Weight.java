package Mongo;

/*
 * xAPI weight 
 * data: MongoDB
 * 
 * version: May 18, 2018 05:18 PM
 * Last revision: May 18, 2018 05:18 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import java.util.Set;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoDB_Weight 
{
	private String host = "1";	
	private int port = 27017;  
	private String dbName = "";
	
	// MongoDB
	MongoClient mongoClient = new MongoClient(host, port);
	DB db = mongoClient.getDB(dbName);		 	
 	
	public MongoDB_Weight() throws Exception
	{
		// get all collection name
		MongoClient mongoClient = new MongoClient(host, port);
        DB db = mongoClient.getDB(dbName);
		
        Set<String> collections = db.getCollectionNames();

        for (String collectionName : collections) 
        {
        	System.out.println(collectionName);        	
        }		
        mongoClient.close();
	}
	
	public static void main(String[] args)
	{
		try {
			MongoDB_Weight json_dbparser = new MongoDB_Weight();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
