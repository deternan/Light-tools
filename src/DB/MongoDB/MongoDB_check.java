package Mongo;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;

/*
* version: July 27, 2018 03:44 PM
* Last revision: July 27, 2018 03:44 PM
* 
* Author : Chao-Hsuan Ke
* Institute: Delta Research Center
* Company : Delta Electronics Inc. (Taiwan)
*/  

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongoDB_check 
{
	private String host = "";
    private int port = ;    
    String dbName = "";
    String colName = "";
    
    private MongoClient mongoClient = new MongoClient(host, port);
	private DB db = mongoClient.getDB(dbName);	   
    // Query
    private DBCollection dbcollection;
	
    private String query_Name = "";
    
	public MongoDB_check()
	{
		dbcollection = db.getCollection(colName);
		DBCursor cursor;

		BasicDBObject basicquery = new BasicDBObject();
		basicquery.put("_id", new ObjectId("{input id}"));
	    DBObject dbObj = dbcollection.findOne(basicquery);
	    
		cursor = dbcollection.find(dbObj);	
		while(cursor.hasNext())
		{
			DBObject _obj = cursor.next();
			if(_obj.containsField(query_Name)){
				
			}
			
		}
	}
	
	public static void main(String[] args) 
	{
		MongoDB_check check = new MongoDB_check();
	}
	
}
