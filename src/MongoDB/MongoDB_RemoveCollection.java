package Mongo;

/*
 * Remove MongoDB collection
* version: April 03, 2018 03:45 PM
* Last revision: April 03, 2018 03:45 PM
* 
* Author : Chao-Hsuan Ke
* Institute: Delta Research Center
* Company : Delta Electronics Inc. (Taiwan)
*/ 


import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoDB_RemoveCollection 
{
	private String host;
	private int port;
	private String dbName = "";
	private String colName = "";
	
	public MongoDB_RemoveCollection()
	{
		MongoClient mongoClient = new MongoClient(host, port);
		DB db = mongoClient.getDB(dbName);
		DBCollection myCollection = db.getCollection(colName);
		myCollection.drop();
		
		mongoClient.close();
	}
	
	public static void main(String[] args)
	{
		MongoDB_RemoveCollection remove_col = new MongoDB_RemoveCollection();
	}
	
}
