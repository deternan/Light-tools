package xAPI;

/*
 * xAPI query 
 * data: MongoDB
 * 
 * version: December 28, 2017 09:35 AM
 * Last revision: April 17, 2018 04:16 PM
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

public class xAPI_JSON_dbparser 
{
	private String host = "";	
	private int port = ;  
	private String dbName = "";
	private String query_colName = "";
	
	MongoClient mongoClient = new MongoClient(host, port);
	DB db = mongoClient.getDB(dbName);	
	// Query
    private DBCollection dbcollection = db.getCollection(query_colName);
	
	
	public xAPI_JSON_dbparser() throws Exception
	{
		BasicDBObject videoQuery = new BasicDBObject();
//		videoQuery.put(uploadStatus, uploadStatus_success);
//		videoQuery.put("permission", "public");
//		videoQuery.put("publishedStatus", true);
//		videoQuery.put("deletedStatus", false);
//		videoQuery.put("videoType", "originalVideo");
		
		DBCursor cursor = dbcollection.find(videoQuery);
		System.out.println(cursor.count());
		
		
		String verb;
		
//		while(cursor.hasNext())
//		{
//			DBObject obj = cursor.next();
//			//System.out.println(obj);
//						
//			verb = obj.get("verb").toString();
//			JSONObject jsonobj = new JSONObject(verb);			
//			//System.out.println(jsonobj.get("display"));
//			JSONObject jsonobj_display = new JSONObject(jsonobj.get("display").toString());
//			System.out.println(jsonobj_display.get("en-US"));
//			
//			
//			
//		}
		
		cursor.close();
		mongoClient.close();
	}
	
	public static void main(String[] args)
	{
		try {
			xAPI_JSON_dbparser json_dbparser = new xAPI_JSON_dbparser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
