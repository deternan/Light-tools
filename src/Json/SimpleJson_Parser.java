package Json;

/*
 * Json Parser 
 * 
 * version: December 13, 2018 11:21 AM
 * Last revision: December 13, 2018 11:21 AM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SimpleJson_Parser 
{
	private String jsonString = "{\"permission\" : \"public\",\r\n" + 
			"    \"tags\" : [ \r\n" + 
			"        \"security\", \r\n" + 
			"        \"vulnerability\", \r\n" + 
			"        \"security in design\", \r\n" + 
			"        \"OWASP top 10\"\r\n" + 
			"    ]}";
	
	
	public SimpleJson_Parser() throws ParseException 
	{
		//System.out.println(jsonString);
		
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(jsonString);
		
		System.out.println(json.get("permission"));
		System.out.println(json.get("tags"));
	}

	public static void main(String args[])
	{
		try {
			SimpleJson_Parser simpleparser = new SimpleJson_Parser();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
