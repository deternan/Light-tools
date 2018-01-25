package Mongo;

/*
 * DBRef_Parser 
 * 
 * version: January 25, 2018 04:09 PM
 * Last revision: January 25, 2018 04:09 PM
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
	String port = "";
	String dbName = "";
	String colName = "";
	MongoClient mongoClient = new MongoClient(host);
	DB db = mongoClient.getDB(dbName);		
	DBCollection dbcollection = db.getCollection(colName);
	
	String field_str = "";
	
	public DBRef_Parser()
	{
		// MongoDB
		BasicDBObject Query = new BasicDBObject();
		DBCursor cursor = dbcollection.find(Query);
					
		while(cursor.hasNext())
		{
			DBObject obj = cursor.next();
			
			Object id = obj;
			  if (obj instanceof DBRef) {
			    DBRef ref=(DBRef)obj;
			    id = ref.getId();
			    System.out.println(field_str);
			  }
			
		}		
	}
	
	public static void main(String[] args) 
	{
		DBRef_Parser DBRef = new DBRef_Parser();  
	}
	
}
