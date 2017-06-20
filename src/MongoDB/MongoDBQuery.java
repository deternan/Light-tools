package Mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongoDBQuery 
{
	private String host = "";    
    private int port = 27017;    
    String dbName = "";
    String colName = "";	
    
    // Query
    private DBCollection dbcollection;
    
	public MongoDBQuery()
	{
		findquery();
		getquery();
	}

	private void findquery()
	{
		// MongoDB
		MongoClient mongoClient = new MongoClient(host, port);
		DB db = mongoClient.getDB(dbName);
		dbcollection = db.getCollection(colName);

		// Search
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("", "");
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
	
	public static void main(String[] args) 
	{
		MongoDBQuery MQ = new MongoDBQuery();
	}
	
}
