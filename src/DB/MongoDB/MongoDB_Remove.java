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
* version: August 29, 2017 10:43 AM
* Last revision: August 29, 2017 10:43 AM
* 
* Author : Chao-Hsuan Ke
* Institute: Delta Research Center
* Company : Delta Electronics Inc. (Taiwan)
*/  

public class MongoDB_Remove 
{
	private String host = "";
    private int port = 27017;    
    String dbName = "";
    String colName = "";
    // Query
    private DBCollection dbcollection;
	
	
	public MongoDB_Remove() throws Exception
	{
		// Timestamp Range					// 2017-05-05T15:05:46.316+08:00		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.TAIWAN);
		//SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.TAIWAN);
		String date = "2017-01-01 00:00:00"; 
		String date1 = "2017-07-01 00:00:00";
		Date startDate = formatter.parse(date);
		Date endDate = formatter.parse(date1);		
		BasicDBObject query = new BasicDBObject("timestamp", new BasicDBObject("$gte",startDate).append("$lt",endDate ));
		
		// MongoDB
		MongoClient mongoClient = new MongoClient(host, port);
		DB db = mongoClient.getDB(dbName);
		dbcollection = db.getCollection(colName);		

		// Query
		//DBCursor cursor = dbcollection.find();
//		DBCursor cursor = dbcollection.find(query);		
//		while(cursor.hasNext())
//		{												
//			DBObject obj = cursor.next();			
//			System.out.println(obj.get("_id")+"	"+obj.get("user name")+"	"+obj.get("timestamp"));			
//		}
//		cursor.close();
		
		
		// Remove
//		BasicDBObject bd = new BasicDBObject(query);
//		dbcollection.remove(bd);
		
		
		mongoClient.close();
	}
	
	public static void main(String[] args) 
	{
		try {
			MongoDB_Remove mongo_remove = new MongoDB_Remove();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
