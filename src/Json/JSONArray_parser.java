package Json;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

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
 */

public class JSONArray_parser 
{
	private String input_array = "[[\"可變電容\", 0.9595925211906433], [\"電阻\", 0.9593324661254883]]";
	
	JSONParser parser = new JSONParser();
	
	public JSONArray_parser() throws Exception
	{
		 JSONArray jsonObject = (JSONArray) parser.parse(input_array);
		 
		for (int i = 0; i < jsonObject.size(); i++) 
		{
			//System.out.println(jsonObject.get(i));
			JSONArray names = (JSONArray) parser.parse(jsonObject.get(i).toString());
			System.out.println(names.get(0)+"	"+names.get(1));
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
