package Wiki;

/*
 * Get Wiki data (via Media Wiki)
 *  
 * version: June 17, 2015	11:15 AM
 * Last revision: June 23, 2015	10:22 AM
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
	private static String query_str = "data mining";
	private static String thu_size = "200";
	
	// Wiki API (Text)
	private String query_defined = "https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles=";	
	private String URL_defined = "https://en.wikipedia.org/wiki/";
	private String URL_str;
	private int pageid;
	private String title;
	private String extract;
	// Wiki API (Thumbnail)
	private String thu_defined;			// https://en.wikipedia.org/w/api.php?action=query&titles=Pizza&prop=pageimages&format=json&pithumbsize=
	private String thu_defined_front = "https://en.wikipedia.org/w/api.php?action=query&titles=";
	private String thu_defined_behind = "&prop=pageimages&format=json&pithumbsize=";
	private int width;
	private int height;
	private String source;
	
	public Wiki_JsonReader(String query_str) 
	{		
		query_str.trim();
		// Space replace
		query_str = Space_replace(query_str);
		
		// URL
		URL_str = URL_defined.concat(query_str);
		// 
		thu_defined = thu_defined_front.concat(query_str);
		thu_defined = thu_defined.concat(thu_defined_behind);
		thu_defined = thu_defined.concat(thu_size);
		
		try {
			
			//JSONObject json = readJsonFromUrl("https://graph.facebook.com/19292868552");			
			JSONObject json_text = readJsonFromUrl(query_defined + query_str);
			//System.out.println(query_defined + query_str);
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
		  		
		Display();
	}
	
	private void Display()
	{
		// 
		System.out.println(pageid);
  		System.out.println(title);
  		System.out.println(extract);
  		// 
  		System.out.println(URL_str);  		
  		System.out.println(source);
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
  		//System.out.println(json_str);
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
  		}else{
  			pageid = -1;
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
  		if(id_num_object.isNull("pageid") == false){
  			JSONObject thumbnail_object =  obj.getJSONObject("query").getJSONObject("pages").getJSONObject(id_str).getJSONObject("thumbnail");  		
  	  		source = (String)thumbnail_object.getString("source");
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
  
}
