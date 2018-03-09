package Mongo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/*
 * MongoDB Add data
 * 
 * version: March 15, 2017 02:31 PM
 * Last revision: March 09, 2018 10:51 AM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

/*
 * JAR
 * mongodb-driver-3.4.2.jar
 * mongodb-driver-core-3.4.2.jar
 * json-simple-1.1.1.jar
 */

public class MongoDB_Add 
{	
    private String host = "localhost";    
    private int port = 27017;    
    String dbName = "";
    //String userName = "";    
    //String userPwd = "";           
	
    private MongoClient mongoClient;
    private DB db;
    private DBCollection collection;
    // MongoDB
    private String collectionName = "";
    
    // 
    private JSONArray array = new JSONArray();
    
	public MongoDB_Add() throws Exception
	{		
		// Connection
		ConnectionDB();
	}
	
	// Making a Connection
	private void ConnectionDB() throws Exception
	{				
		mongoClient = new MongoClient(host, port);
		db = mongoClient.getDB(dbName);
		// Create Collection
		
		// Add data to collection
		collection = db.getCollection(collectionName);
		Add_data();
		
        mongoClient.close();
	}
	
	private void Add_data() throws Exception
	{
		BasicDBObject document = new BasicDBObject();
		document.put("User id", "User 1");
		// Timestamp
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());				
		document.put("timestamp", timestamp);
		
		/*
		 * Example
		 * 
		 */		
		DBObject video1 = new BasicDBObject();
		video1.put("rank", 1);
		video1.put("score", 0.1);
		video1.put("recommended_video", "3657a731e60c498e9341d9c57a15ce7e");
		DBObject video2 = new BasicDBObject();
		video2.put("rank", 2);
		video2.put("score", 0.09);
		video2.put("recommended_video", "c5906533cf1a48f990b501785fb27c89");
		
		List<DBObject> documents = new ArrayList<>();
		documents.add(video1);
		documents.add(video2);
		
		document.put("Ranking", documents);
		
		
		// Insert
		collection.insert(document);
		
		System.out.println("Finished");
	}
	
	public static void main(String[] args) 
	{
		try {
			MongoDBConn DD = new MongoDBConn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
}
