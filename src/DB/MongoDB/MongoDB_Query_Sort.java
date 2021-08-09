package Mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/*
* version: September 11, 2017 10:49 AM
* Last revision: December 15, 2017 10:50 AM
* 
* Author : Chao-Hsuan Ke
* Institute: Delta Research Center
* Company : Delta Electronics Inc. (Taiwan)
*/  

public class MongoDB_Query_Sort 
{
	private String host = "";    
    private int port = 27017;    
    String dbName = "";
    String colName = "";
	String property_tag = "";
    // Query
    private DBCollection dbcollection;
	
	public MongoDB_Query_Sort() throws Exception
	{		
		// MongoDB
		MongoClient mongoClient = new MongoClient(host, port);
		DB db = mongoClient.getDB(dbName);		
		dbcollection = db.getCollection(colName);
		
		// Sort (time)
		BasicDBObject latestQuery = new BasicDBObject();
		latestQuery.put(property_tag, -1);
		DBCursor cursor = dbcollection.find().sort(latestQuery);
					
		while(cursor.hasNext())
		{												
			DBObject obj = cursor.next();			
			System.out.println(obj);				
		}
		cursor.close();
		mongoClient.close();		
	}
	
	public static void main(String[] args) 
	{
		try {
			MongoDB_Query_Sort mongo_time = new MongoDB_Query_Sort();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
