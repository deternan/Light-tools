package Mongo;

import com.mongodb.BasicDBObject;

/*
 * Drop MongoDB collection data
 * 
* version: July 31, 2018 05:08 PM
* Last revision: July 31, 2018 05:08 PM
* 
* Author : Chao-Hsuan Ke
* Institute: Delta Research Center
* Company : Delta Electronics Inc. (Taiwan)
*/ 

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class MongoDB_DropCollectionData 
{
	private String host = "";
	private int port = 27017;
	private String dbName = "";
	private String colName = "";
	
	public MongoDB_DropCollectionData()
	{
		MongoClient mongoClient = new MongoClient(host , port);
		DB db = mongoClient.getDB(dbName);
		DBCollection dbcollection = db.getCollection(colName);

		BasicDBObject document = new BasicDBObject();
		
		dbcollection.remove(document);

		// Delete All documents from collection using DBCursor
		DBCursor cursor = dbcollection.find();
		while (cursor.hasNext()) {
			dbcollection.remove(cursor.next());
		}
		
		mongoClient.close();
	}
	
	public static void main(String[] args)
	{
		MongoDB_DropCollectionData remove_col = new MongoDB_DropCollectionData();
	}
	
}
