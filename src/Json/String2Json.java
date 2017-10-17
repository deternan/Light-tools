package Json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * Get ETube video meta-data
 * 
 * version: October 17, 2017 05:32 PM
 * Last revision: October 17, 2017 06:11 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

/*
 * java-json.jar
 * 
 */

public class String2Json 
{
	private String json_str = "[{\"id\":\"5930f45225c1394d3686b063\",\"title\":\"reThink 3 - 蘇州電博會 – 台達工業4.0顧問諮詢服務介紹\"}]";
	
	public String2Json()
	{		
		try {			
			//JSONObject obj = new JSONObject(json_str);
			//System.out.println(obj);
			
			// Json array
			JSONArray jsonarray = new JSONArray(json_str);
			JSONObject json_str;
			for(int i=0; i<jsonarray.length(); i++)
			{
				if(jsonarray.get(i)!=null){
					json_str = new JSONObject(jsonarray.get(i).toString());
					System.out.println(json_str);
				}
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String args[]) 
	{
		String2Json s2j = new String2Json();
	}
	
}
