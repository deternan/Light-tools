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
* version: June 19, 2017 05:29 PM
* Last revision: October 23, 2017 04:24 PM
* 
* Author : Chao-Hsuan Ke
* Institute: Delta Research Center
* Company : Delta Electronics Inc. (Taiwan)
*/  


public class MongoDBQuery 
{
	private String host = "10.120.136.144";    
    private int port = 27017;    
    String dbName = "Recommendation";
    String colName = "recommended_video";
//    String userName = "admin";    
//    String userPwd = "admin";
	
    // Query
    private DBCollection dbcollection;
    
	public MongoDBQuery() throws Exception
	{
		findquery();
		getquery();
		// Query by timestamp (Time gap)
		Query_by_timestamp();
		// Query by latest time
		Query_by_latesttime();
	}

	private void findquery()
	{
		// MongoDB
		MongoClient mongoClient = new MongoClient(host, port);
		DB db = mongoClient.getDB(dbName);
		dbcollection = db.getCollection(colName);

		// Search (User id)
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("user name", "quinn.su");
		// latest (time)
		BasicDBObject latestQuery = new BasicDBObject();
		latestQuery.put("timestamp", -1);

		DBCursor cursor = dbcollection.find(searchQuery).sort(latestQuery)
				.limit(1);

		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}
		cursor.close();
		mongoClient.close();
	}
	
	private void getquery()
	{
		// MongoDB
		MongoClient mongoClient = new MongoClient(host, port);
		DB db = mongoClient.getDB(dbName);
		dbcollection = db.getCollection(colName);
		
		DBCursor cursor = dbcollection.find();
		
		while(cursor.hasNext())
		{												
			DBObject obj = cursor.next();			
			System.out.println(obj.get("_id"));
		}
		
		cursor.close();
		mongoClient.close();
	}
	
	private void ISOtime_process()
	{
		// ISO format
		SimpleDateFormat parserSDF = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
		// Timestamp	2017-06-19 14:22:50.645
		SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");		
	}
	
	private void Query_by_timestamp() throws Exception
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.TAIWAN);		
		String date = "2017-01-01 00:00:00"; 
		String date1 = "2017-06-02 00:00:00";
		Date startDate = formatter.parse(date);
		Date endDate = formatter.parse(date1);		
		BasicDBObject query = new BasicDBObject("timestamp", new BasicDBObject("$gte",startDate).append("$lt",endDate ));
		
		MongoClient mongoClient = new MongoClient(host, port);
		DB db = mongoClient.getDB(dbName);
		dbcollection = db.getCollection(colName);		
		//DBCursor cursor = dbcollection.find();
		DBCursor cursor = dbcollection.find(query);
				
		while(cursor.hasNext())
		{												
			DBObject obj = cursor.next();			
			System.out.println(obj.get("_id")+"	"+obj.get("timestamp"));			
		}
		
		cursor.close();
		mongoClient.close();
	}
	
	private void Query_by_latesttime()
	{
		//BasicDBObject latestQuery = new BasicDBObject();
		//latestQuery.put("timestamp", -1);
		//DBCursor cursor = dbcollection.find(searchQuery).limit(display_limit).sort(latestQuery).limit(1);
		//DBCursor cursor = dbcollection.find(searchQuery).limit(display_limit);
	}
	
	public static void main(String[] args) 
	{
		try {
			MongoDBQuery MQ = new MongoDBQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
