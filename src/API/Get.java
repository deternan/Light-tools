package API;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * Get API
 * 
 * version: October 17, 2017 11:13 AM
 * Last revision: October 17, 2017 11:13 AM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

public class Get 
{
	// Example (Central Weather Bureau)
	private String dataid = "O-A0003-001";
	private String key = "";
	
	private String get_url = "http://opendata.cwb.gov.tw/opendataapi?dataid="+ dataid +"&authorizationkey="+key;			// API URL
	// http
	private final String USER_AGENT = "Mozilla/5.0";
	// Response
	private String token;
	
	public Get() throws Exception
	{
		URL obj = new URL(get_url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();		
		// optional default is GET
		con.setRequestMethod("GET");
		//add request header
		con.setDoOutput(true);
        con.setRequestProperty  ("Authorization", "Bearer " + token);
        InputStream content = (InputStream)con.getInputStream();
        BufferedReader in = new BufferedReader (new InputStreamReader (content));
        String line;
        while ((line = in.readLine()) != null) 
        {
            System.out.println(line);
            //Parser(line);
        }  
		
	}
	
	private void Parser(String input) throws JSONException
	{		
		//JSONObject json_str = new JSONObject(input);
		JSONArray jsonarray = new JSONArray(input);
		
		JSONObject json_str;
		for(int i=0; i<jsonarray.length(); i++)
		{
			//System.out.println(jsonarray.get(i));
			if(jsonarray.get(i)!=null){
				json_str = new JSONObject(jsonarray.get(i).toString());
								
				//System.out.println("Subtitle: "+json_str.get("subtitle"));
			}			
		}
	}
	
	public static void main(String[] args)
	{
		try {
			Get get = new Get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
