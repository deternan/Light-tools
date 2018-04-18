package Mongo;

/*
* version: April 18, 2018 11:24 AM
* Last revision: April 18, 2018 11:24 AM
* 
* Author : Chao-Hsuan Ke
* Institute: Delta Research Center
* Company : Delta Electronics Inc. (Taiwan)
*/ 

import java.util.Set;

import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class MongoDB_Allcollection 
{
	private String host = "";	
	private int port = ;  
	private String dbName = "";			// query DB name
	
	public MongoDB_Allcollection()
	{
		MongoClient mongoClient;
        
		mongoClient = new MongoClient(host, port);
        DB db = mongoClient.getDB(dbName);
		
        Set<String> collections = db.getCollectionNames();

        for (String collectionName : collections) {
        	System.out.println(collectionName);
        }
		
	}
	
	public static void main(String[] args) 
	{
		MongoDB_Allcollection Allcollection = new MongoDB_Allcollection(); 
	}
	
}
