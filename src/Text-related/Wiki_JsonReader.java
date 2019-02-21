package Text_related;

/*
* Get Wiki data (via Media Wiki)
*  
* version: June 17, 2015	11:15 AM
* Last revision: June 24, 2015	03:31 PM
* 
* Author: Chao-Hsuan Ke
* 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Wiki_JsonReader 
{	
	public String URL_str;
	public String title;
	public String extract;
	public String thu_source;
	
	public boolean language_check = true;
	
	String thu_defined;
	
	public Wiki_JsonReader(String query_str) 
	{		
		query_str.trim();
		// Space replace
		query_str = Space_replace(query_str);
		
		// Chinese & English check
		
		language_check = English_Chinese_check(query_str);
		if(language_check == true){
			// URL
			URL_str = en_URL_defined.concat(query_str);
			// thumbnail
			thu_defined = thu_defined_front.concat(query_str);
			thu_defined = thu_defined.concat(thu_defined_behind);
			thu_defined = thu_defined.concat(thu_size);
		}else if (language_check == false){
			// URL
			URL_str = zh_URL_defined.concat(query_str);
			// thumbnail
			thu_defined = thu_defined_front.concat(query_str);
			thu_defined = thu_defined.concat(thu_defined_behind);
			thu_defined = thu_defined.concat(thu_size);
		}
		
		
		try {
			JSONObject json_text = null;
			//JSONObject json = readJsonFromUrl("https://graph.facebook.com/19292868552");	
			if(language_check == true){
				json_text = readJsonFromUrl(en_query_defined + query_str);
			}else if (language_check == false){
				json_text = readJsonFromUrl(zh_query_defined + query_str);
			}
			
			JSONObject json_thum = readJsonFromUrl(thu_defined);
			//System.out.println(json.toString());
		     //System.out.println(json.get("id"));
		     //System.out.println(json.get("pages"));
		     
		      // JSON translation
		      JSON_Transfer(json_text.toString());
		      // Thumbnail
		      thumbnail_Transfer(json_thum.toString());
		      
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		  
		
		//Display();
	}
	
	private void Display()
	{
		System.out.println(pageid);
		System.out.println(title);
		System.out.println(extract);
		
		System.out.println(URL_str);
		
		System.out.println(thu_source);
	}
	
	private String Space_replace(String query_str)
	{
		Pattern pattern = Pattern.compile("\\s");
		Matcher matcher = pattern.matcher(query_str);
		boolean found = matcher.find();
		
		if(found){
			query_str = query_str.replaceAll("\\s", "%20");			
		}
		
		return query_str;
	}
	
	// ------------------------- JSON -------------------------	
	private void JSON_Transfer(String json_str) throws Exception
	{  		 
		JSONObject obj = new JSONObject(json_str);
		
		/*
		 * https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles=Pizza
		 */
		// query
		Object pages = obj.getJSONObject("query");
		Object id = obj.getJSONObject("query").getJSONObject("pages");
		// pages
		JSONArray id_array = obj.getJSONObject("query").getJSONObject("pages").names();
		String id_str = id_array.getString(0);
		// id 
		//Object id_num_object = obj.getJSONObject("query").getJSONObject("pages").getJSONObject(id_str);
		//pageid = (String) obj.getJSONObject("query").getJSONObject("pages").getJSONObject(id_str).get("pageid");
		
		JSONObject id_num_object = obj.getJSONObject("query").getJSONObject("pages").getJSONObject(id_str);  		  		
		
		if(id_num_object.isNull("pageid") == false){
			pageid = (int)id_num_object.get("pageid");
	  		title = (String)id_num_object.get("title");
	  		extract = (String)id_num_object.get("extract");
		}
		//System.out.println(id_array);
		//System.out.println(id_str);
		//System.out.println(id_num_object);  		
	}
	
	// ------------------------- thumbnail ------------------------- 
	private void thumbnail_Transfer(String thu_str) throws Exception
	{
		JSONObject obj = new JSONObject(thu_str);  	
		// query
		Object pages = obj.getJSONObject("query");
		Object id = obj.getJSONObject("query").getJSONObject("pages");
		// pages
		JSONArray id_array = obj.getJSONObject("query").getJSONObject("pages").names();
		String id_str = id_array.getString(0);
		// thumbnail
		JSONObject id_num_object = obj.getJSONObject("query").getJSONObject("pages").getJSONObject(id_str);
		if(id_num_object.isNull("pageid")==false){
			JSONObject thumbnail_object =  obj.getJSONObject("query").getJSONObject("pages").getJSONObject(id_str).getJSONObject("thumbnail");  		
	  		thu_source = (String)thumbnail_object.getString("source");
	  		width = (int)thumbnail_object.get("width");
	  		height = (int)thumbnail_object.get("height");
		}  		
	}
	
	// ------------------------- Wikipedia ------------------------- 	
	private static String readAll(Reader rd) throws IOException 
	{
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) 
		{
			sb.append((char) cp);
		}
		return sb.toString();
	}

	private static JSONObject readJsonFromUrl(String url) throws IOException, JSONException 
	{
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}
	
	private boolean English_Chinese_check(String input_str)
	{
		boolean check = true;		// true : English		// false : non English
									
		if(input_str.matches("[a-zA-Z0-9|\\.]*") )
		{						
			check = true;  // 只有英文數字的處理
		}
		else
		{
			check = false;  // 有其他自元的處理
		}
		return check;
	}
	
	/*
	public static void main(String[] args) throws IOException, JSONException 
	{
	  System.setProperty("java.net.useSystemProxies", "true");
	  
	  try {
		Wiki_JsonReader JR = new Wiki_JsonReader(query_str);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	*/
}
