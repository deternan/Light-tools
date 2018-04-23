package xAPI;

/*
 * xAPI parser
 * 
 * version: December 08, 2017 01:58 PM
 * Last revision: April 17, 2018 02:48 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import java.io.FileReader;

import org.json.simple.parser.JSONParser;
 
import org.json.*;

public class xAPI_JSON
{
	// source
	private String path = "C:\\Users\\Barry.Ke\\Desktop\\JSONExample.json";
	
	
	// Common parameters
	private String fixed_URL = "http://e4e.deltaww.com/etube/";
	
	//parameters
	private String video_tag = "videos" + "/";
	// ----------------------------------------------------------
	
	Object obj;
	JSONObject jo;
	
	// Actor
	String name;
	// Verb
	String verb;
	// Object
	
	// Content
	String con_videoId;
	
	public xAPI_JSON() throws Exception
	{
		obj = new JSONParser().parse(new FileReader(path));        
        // typecasting obj to JSONObject
        
		
		
//      Actor();
//      Verb();
//      Object();
        Context();
        
        
	}
	
	private void Actor()
	{
//		// getting actor
//	      // getting address
//	        Map actor_map = ((Map)jo.get("actor"));         
//	        // iterating address Map 
//	        Iterator<Map.Entry> itr1 = actor_map.entrySet().iterator();
//	        while (itr1.hasNext()){
//	            Map.Entry pair = itr1.next();
//	            // account
//	            if(pair.getKey().toString().equalsIgnoreCase("account")){
//	            	//String firstName = (String) jo.get("firstName");
//	            }else{
//	            	//System.out.println(pair.getKey() + " : " + pair.getValue());
//	            }                 
//	        }
//	        
//	        // name	(Actor)
//	        name = (String) actor_map.get("name");
//	        System.out.println(name);
	}
	
	private void Verb() throws Exception
	{
		 // Verb
//        Map verb_map = ((Map)jo.get("verb"));
//        Iterator<Map.Entry> itr2 = verb_map.entrySet().iterator();
//        while (itr2.hasNext()){
//            Map.Entry pair = itr2.next();            
//            
//            if(pair.getKey().toString().equalsIgnoreCase("display")){            	
//            	//System.out.println(pair.getKey() + " : " + pair.getValue());
//            	
//            	JSONObject jjj = (JSONObject) new JSONParser().parse(pair.getValue().toString());            	
//            	jjj.putAll((Map) pair.getValue());
//            	verb = jjj.get("en-US").toString();
//            	System.out.println(verb);
//            }else{
//            	
//            }            
//        }
	}
	
	private void Object()
	{
		
	}
	
	private void Context() throws Exception
	{
		JSONObject jObject = new JSONObject(obj.toString());
		//System.out.println(jObject_context.get("context"));
		JSONObject jObject_context = new JSONObject(jObject.get("context").toString());
		
		// extension
		String fixed_title = fixed_URL + video_tag;
		
		String title_1 = fixed_title + "clickSourceFrom";
		//System.out.println(title_1);				
		JSONObject jObject_extensions = new JSONObject(jObject_context.get("extensions").toString());
		
		System.out.println(jObject_extensions.get(title_1));		
		//System.out.println(jObject_extensions.get("startVideoTimePoint"));

	}
	
	public static void main(String[] args) throws Exception 
    {        
		xAPI_JSON jsonread = new xAPI_JSON();        
    }
}
