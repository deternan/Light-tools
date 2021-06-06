
/*
 * Get API
 * 
 * version: October 17, 2017 11:13 AM
 * Last revision: October 17, 2017 01:18 PM
 * 
 * Author : Chao-Hsuan Ke
 * 
 */

package API;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/*
 * JAR
 * httpclient-4.5.1.jar
 * httpcore-4.4.6.jar
 * apache-commons.jar
 * slf4j-api-1.7.12.jar
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
		//version_1();
		version_2();        
	}
	
	private void version_1() throws Exception
	{
		// version 1
		URL obj = new URL(get_url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		// optional default is GET
		con.setRequestMethod("GET");
		// add request header
		con.setDoOutput(true);
		con.setRequestProperty("Authorization", "Bearer " + token);
		InputStream content = (InputStream) con.getInputStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(content));
		String line;
		while ((line = in.readLine()) != null) {
			System.out.println(line);
			// Parser(line);
		}
	}
	
	private void version_2() throws Exception
	{
		// version 2        		
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(get_url);

		// add request header
		request.addHeader("User-Agent", USER_AGENT);

		HttpResponse response = client.execute(request);

		System.out.println("\nSending 'GET' request to URL : " + get_url);
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		System.out.println(result.toString());        
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
