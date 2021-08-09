package Mongo;

/*
 * DBRef_Parser 
 * 
 * version: January 25, 2018 04:09 PM
 * Last revision: May 01, 2018 11:03 AM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.DBRef;
import com.mongodb.MongoClient;

public class DBRef_Parser 
{
	String host = "";
	int port = 27017;
	String dbName = "";
	String colName = "";
	
	MongoClient mongoClient = new MongoClient(host);
	DB db = mongoClient.getDB(dbName);		
	DBCollection dbcollection = db.getCollection(colName);
	
	String field_str = "user";
	
	public DBRef_Parser()
	{
		// MongoDB
		BasicDBObject Query = new BasicDBObject();
		DBCursor cursor = dbcollection.find(Query);
		
		while(cursor.hasNext())
		{
			DBObject obj = cursor.next();			
			Object id = obj.get(field_str);
			String id_str;
			if (id instanceof DBRef) {				
			   DBRef ref=(DBRef)id;
			   id = ref.getId();
			   System.out.println(id);
			 }			
		}		
	}
	
	public static void main(String[] args) 
	{
		DBRef_Parser DBRef = new DBRef_Parser();  
	}
	
}
