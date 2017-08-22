package Json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

/*
 * 
 * version: August 22, 2017 02:24 PM
 * Last revision: August 22, 2017 02:24 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

public class Read_Json_html 
{
	JSONObject get_json = null;
	
	public Read_Json_html()
	{
		readJsonFromUrl("https://zh.wikipedia.org/w/api.php?action=query&titles=%E5%88%A9%E5%AE%B3%E9%97%9C%E4%BF%82%E4%BA%BA&redirects=&converttitles=&prop=revisions&rvprop=content&format=json");
		
		System.out.println(get_json);
	}
	
	private void readJsonFromUrl(String url)  
	{		
		InputStream is;
		String jsonText = "";
		
		try {
			is = new URL(url).openStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			//String jsonText = readAll(rd);
			StringBuilder sb = new StringBuilder();
		    int cp;
		    while ((cp = rd.read()) != -1) {
		      sb.append((char) cp);
		    }
		    jsonText = sb.toString();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		try {
			get_json = new JSONObject(jsonText);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void main(String args[]) 
	{
		Read_Json_html read = new Read_Json_html();
	}
	
}
