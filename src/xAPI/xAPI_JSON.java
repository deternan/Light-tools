package xAPI;

/*
 * xAPI parser
 * 
 * version: December 08, 2017 01:58 PM
 * Last revision: December 08, 2017 04:42 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
 
public class xAPI_JSON
{
	Object obj;
	JSONObject jo;
	
	String name;
	String verb;
	
	public xAPI_JSON() throws Exception
	{
		obj = new JSONParser().parse(new FileReader(""));        
        // typecasting obj to JSONObject
        jo = (JSONObject) obj;
        
//      Actor();
//      Verb();
        Object();
	}
	
	private void Actor()
	{
		// getting actor
	      // getting address
	        Map actor_map = ((Map)jo.get("actor"));         
	        // iterating address Map 
	        Iterator<Map.Entry> itr1 = actor_map.entrySet().iterator();
	        while (itr1.hasNext()){
	            Map.Entry pair = itr1.next();
	            // account
	            if(pair.getKey().toString().equalsIgnoreCase("account")){
	            	//String firstName = (String) jo.get("firstName");
	            }else{
	            	//System.out.println(pair.getKey() + " : " + pair.getValue());
	            }                 
	        }
	        
	        // name	(Actor)
	        name = (String) actor_map.get("name");
	        System.out.println(name);
	}
	
	private void Verb() throws Exception
	{
		 // Verb
        Map verb_map = ((Map)jo.get("verb"));
        Iterator<Map.Entry> itr2 = verb_map.entrySet().iterator();
        while (itr2.hasNext()){
            Map.Entry pair = itr2.next();            
            
            if(pair.getKey().toString().equalsIgnoreCase("display")){            	
            	//System.out.println(pair.getKey() + " : " + pair.getValue());
            	
            	JSONObject jjj = (JSONObject) new JSONParser().parse(pair.getValue().toString());            	
            	jjj.putAll((Map) pair.getValue());
            	verb = jjj.get("en-US").toString();
            	System.out.println(verb);
            }else{
            	
            }            
        }
	}
	
	private void Object()
	{
		
	}
	
	public static void main(String[] args) throws Exception 
    {        
		xAPI_JSON jsonread = new xAPI_JSON();        
    }
}
