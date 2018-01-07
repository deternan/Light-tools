package xAPI;

/*
 * xAPI query
 * 
 * version: December 28, 2017 09:35 AM
 * Last revision: December 28, 2017 09:35 AM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */


import org.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class xAPI_query 
{
	// DB info	
	private String host = "";	
	private int port = 27017;  
	private String dbName = "";
	private String query_colName = "";
	
	MongoClient mongoClient = new MongoClient(host, port);
	DB db = mongoClient.getDB(dbName);	
	// Query
    private DBCollection dbcollection = db.getCollection(query_colName);

	public xAPI_query() throws Exception
	{		
		BasicDBObject videoQuery = new BasicDBObject();
//		videoQuery.put(uploadStatus, uploadStatus_success);
		
		DBCursor cursor = dbcollection.find(videoQuery);
		//System.out.println(cursor.count());
		
		
		String verb;
		
		while(cursor.hasNext())
		{
			DBObject obj = cursor.next();
			//System.out.println(obj);
						
			verb = obj.get("verb").toString();
			JSONObject jsonobj = new JSONObject(verb);			
			//System.out.println(jsonobj.get("display"));
			JSONObject jsonobj_display = new JSONObject(jsonobj.get("display").toString());
			System.out.println(jsonobj_display.get("en-US"));
			
			//if(jsonobj_display.get("en-US").toString().equalsIgnoreCase(""))
			{
				
			}
			
			
			//JSONObject
		}
		
		cursor.close();
		mongoClient.close();
	}
	
	public static void main(String[] args)
	{
		try {
			xAPI_query query = new xAPI_query();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
