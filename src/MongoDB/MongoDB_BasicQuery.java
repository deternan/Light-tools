package Mongo;

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
	private String host = "";    
    private int port = 27017;    
    String dbName = "";
    String colName = "";
    // Query
    private DBCollection dbcollection;
	
	public MongoDB_BasicQuery() throws Exception
	{		
		// MongoDB
		MongoClient mongoClient = new MongoClient(host, port);
		DB db = mongoClient.getDB(dbName);		
		dbcollection = db.getCollection(colName);
		
		// latest (time)
		BasicDBObject query = new BasicDBObject();
		
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