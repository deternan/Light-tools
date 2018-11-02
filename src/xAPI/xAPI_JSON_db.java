package xAPI;

/*
 * xAPI parser
 * 
 * version: December 08, 2017 01:58 PM
 * Last revision: November 02, 2018 08:26 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import java.util.Iterator;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import org.bson.BasicBSONObject;
import org.json.*;

public class xAPI_JSON_db
{
	private String host = "";    
    private int port = ;    
    String dbName = "";
    String colName = "";    
	
    private static String actor_Field = "actor";
    private static String verb_Field = "verb";
    private static String context_Field = "context";
    private static String time_Field = "stored";
    
	// Common parameters
	private String fixed_URL = "";
	
	//parameters
	private String video_tag = "videos" + "/";
	// ----------------------------------------------------------
	
//	Object obj;
//	JSONObject jo;
	
	// Actor
	String name;
	// Verb
	String verb;
	// Object
	
	// Context	
	private String eventCategory;
	private String timestamp;
	
	public xAPI_JSON_db() throws Exception
	{
		// MongoDB
		MongoClient mongoClient = new MongoClient(host, port);
		DB db = mongoClient.getDB(dbName);
		DBCollection dbcollection = db.getCollection(colName);
	
		// latest (time)
		BasicDBObject latestQuery = new BasicDBObject();
		latestQuery.put(time_Field, 1);

		DBCursor cursor = dbcollection.find().sort(latestQuery);
		System.out.println(cursor.count());
		while (cursor.hasNext()) 
		{
			name = "";			
			verb = "";
			eventCategory = "";
			
			DBObject obj = cursor.next();
			
			// Actor			
			Actor(obj);
			// Verb 
			Verb(obj);
			//
			Object();
			// Context
			Context(obj);
			
			timestamp = obj.get(time_Field).toString();
			
			System.out.println(name+"	"+verb+"	"+eventCategory+"	"+timestamp);
		}
		cursor.close();
		mongoClient.close();
                
	}
	
	private void Actor(Object object) throws JSONException 
	{
		// getting actor		
		Map actor_map = ((Map) ((BasicBSONObject) object).get(actor_Field));
		// Map actor_map = ((Map)jo.get("actor"));
		// iterating address Map
		Iterator<Map.Entry> itr1 = actor_map.entrySet().iterator();
		while (itr1.hasNext()) {
			Map.Entry pair = itr1.next();
			// account
			if (pair.getKey().toString().equalsIgnoreCase("account")) {
				// String firstName = (String) jo.get("firstName");
			} else {
				// System.out.println(pair.getKey() + " : " + pair.getValue());
			}
		}

		// name (Actor)
		name = (String) actor_map.get("name");
		//System.out.println(name);
	}
	
	private void Verb(Object object) throws Exception
	{
		 // Verb
		Map verb_map = ((Map) ((BasicBSONObject) object).get(verb_Field));
        Iterator<Map.Entry> itr = verb_map.entrySet().iterator();
        while (itr.hasNext()){
            Map.Entry pair = itr.next();            
            
            if(pair.getKey().toString().equalsIgnoreCase("display")){            	
            	            	
            	JSONObject jsonObject = new JSONObject(pair.getValue().toString());            	
            	//System.out.println(jsonObject.get("en-US"));
            	verb = jsonObject.get("en-US").toString();            	
            }else{
            	
            }            
        }
	}
	
	private void Object()
	{
		
	}
	
	private void Context(Object object) throws Exception
	{
		Map context_map = ((Map) ((BasicBSONObject) object).get(context_Field));
        Iterator<Map.Entry> itr = context_map.entrySet().iterator();
        while (itr.hasNext()){
        	Map.Entry pair = itr.next();
        	
        	if(pair.getKey().toString().equalsIgnoreCase("extensions")){
        		JSONObject jsonObject = new JSONObject(pair.getValue().toString());            	
            	//System.out.println(jsonObject);
        		
        		if(jsonObject.has("eventCategory")) {
        			eventCategory = jsonObject.getString("eventCategory");
        		}
        		
        	}
        }
		
//		JSONObject jObject = new JSONObject(obj.toString());
//		//System.out.println(jObject_context.get("context"));
//		JSONObject jObject_context = new JSONObject(jObject.get("context").toString());
//		
//		// extension
//		String fixed_title = fixed_URL + video_tag;
//		
//		String title_1 = fixed_title + "clickSourceFrom";
//		//System.out.println(title_1);				
//		JSONObject jObject_extensions = new JSONObject(jObject_context.get("extensions").toString());
//		
//		System.out.println(jObject_extensions.get(title_1));		
		//System.out.println(jObject_extensions.get("startVideoTimePoint"));

	}
	
	public static void main(String[] args) throws Exception 
    {        
		xAPI_JSON_db jsonread = new xAPI_JSON_db();        
    }
}
