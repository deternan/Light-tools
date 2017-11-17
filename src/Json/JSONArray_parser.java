package Json;

import org.json.JSONArray;
import org.json.JSONObject;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;

/*
 * JSONArray parser 
 * 
 * version: November 16, 2017 06:30 PM
 * Last revision: November 16, 2017 06:38 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

/*
 * JAR
 * json-simple-1.1.1.jar
 * 
 * java-json.jar
 */

public class JSONArray_parser 
{
	private String input_array = "[{\"word\": \"了解\", \"score\": 0.9747797250747681}, {\"word\": \"明白\", \"score\": 0.9727225303649902}]";
//	JSONParser parser = new JSONParser();
	
	public JSONArray_parser() throws Exception
	{
		// json-simple version
//		JSONArray jsonObject = (JSONArray) parser.parse(input_array);
//		 
//		for (int i = 0; i < jsonObject.size(); i++) 
//		{
//			//System.out.println(jsonObject.get(i));
//			JSONArray names = (JSONArray) parser.parse(jsonObject.get(i).toString());
//			System.out.println(names.get(0)+"	"+names.get(1));
//		}
		
		// java-json.jar version
		JSONArray jsonarray = new JSONArray(input_array);
		for (int i = 0; i < jsonarray.length(); i++) 
		{
			JSONObject jsonobject = jsonarray.getJSONObject(i);
			System.out.println(jsonobject.get("word"));
		}
		
	}
	
	public static void main(String[] args)
	{
		try {
			JSONArray_parser arrayparser = new JSONArray_parser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
