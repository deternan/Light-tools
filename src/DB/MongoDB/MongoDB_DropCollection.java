package Mongo;

/*
 * Drop MongoDB collection
 * 
* version: April 03, 2018 03:45 PM
* Last revision: July 31, 2018 04:57 PM
* 
* Author : Chao-Hsuan Ke
* Institute: Delta Research Center
* Company : Delta Electronics Inc. (Taiwan)
*/ 


import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoDB_DropCollection 
{
	private String host;
	private int port;
	private String dbName = "";
	private String colName = "";
	
	public MongoDB_DropCollection()
	{
		MongoClient mongoClient = new MongoClient(host, port);
		DB db = mongoClient.getDB(dbName);
		DBCollection myCollection = db.getCollection(colName);
		myCollection.drop();
		
		mongoClient.close();
	}
	
	public static void main(String[] args)
	{
		MongoDB_DropCollection remove_col = new MongoDB_DropCollection();
	}
	
}
