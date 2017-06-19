package Mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class MongoDBQuery 
{
	private String host = "";    
    private int port = 27017;    
    String dbName = "";
    String colName = "";
    String userName = "";    
    String userPwd = "";
	String itemName = "";
    
    // Query
    private DBCollection dbcollection;
    
	public MongoDBQuery()
	{
		// MongoDB		
		MongoClient mongoClient = new MongoClient(host, port);
		DB db = mongoClient.getDB(dbName);		
		dbcollection = db.getCollection(colName);

		// Search (User id)
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put(itemName, "");
		// latest (timestamp)
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

	public static void main(String[] args) 
	{
		MongoDBQuery MQ = new MongoDBQuery();
	}
	
}
