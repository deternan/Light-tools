package Mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/*
 * MongoDB search (Text)
 * 
 * version: December 18, 2017 10:28 AM
 * Last revision: January 15, 2018 04:48 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */


public class MongoDB_search 
{
	private String host = "";    
    private int port = 27017;    
    String dbName = "";
    String colName = "";
	
	MongoClient mongoClient = new MongoClient(host, port);
	DB db = mongoClient.getDB(dbName);	
	// Query
    private DBCollection dbcollection = db.getCollection(colName);

    private String query_str = "123";
    
	public MongoDB_search() throws Exception
	{
		
		MongoDB_get_videos();
	}
	
	private void MongoDB_get_videos() throws Exception
	{							
		
		BasicDBObject q = new BasicDBObject();
		q.put("title",  java.util.regex.Pattern.compile(query_str));
		
		DBCursor cursor = dbcollection.find(q);
		//System.out.println(cursor.count());
		
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
			MongoDB_search allvideos = new MongoDB_search();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
