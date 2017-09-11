package Mongo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/*
* version: August 29, 2017 09:32 AM
* Last revision: September 11, 2017 10:49 AM
* 
* Author : Chao-Hsuan Ke
* Institute: Delta Research Center
* Company : Delta Electronics Inc. (Taiwan)
*/  

public class MongoDB_BasicQuery 
{
	private String host = "10.120.81.141";    
    private int port = 27017;    
    String dbName = "etube";
    String colName = "LogAction_Video";
    // Query
    private DBCollection dbcollection;
	
	public MongoDB_BasicQuery() throws Exception
	{		
		// MongoDB
		MongoClient mongoClient = new MongoClient(host, port);
		DB db = mongoClient.getDB(dbName);		
		dbcollection = db.getCollection(colName);

		// Search (User id)
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("username", "User 1");
		// latest (time)
		BasicDBObject query = new BasicDBObject();
//		latestQuery.put("timestamp", -1);
		
		dbcollection = db.getCollection(colName);		
		//DBCursor cursor = dbcollection.find();
		DBCursor cursor = dbcollection.find(query);
				
		while(cursor.hasNext())
		{												
			DBObject obj = cursor.next();			
			System.out.println(obj.get("_id")+"	"+obj.get("username")+"	"+obj.get("timeStamp"));		
		}
		cursor.close();
		mongoClient.close();
		
	}
	
	public static void main(String[] args) 
	{
		try {
			MongoDB_BasicQuery mongo_time = new MongoDB_BasicQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
