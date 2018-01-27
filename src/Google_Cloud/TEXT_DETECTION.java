
/*
 * Http Request
 * 
 * version: January 28, 2018 01:54 AM
 * Last revision: January 28, 2018 03:30 AM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 */

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class TEXT_DETECTION 
{
	private static final String TARGET_URL = "https://vision.googleapis.com/v1/images:annotate?";
	private static final String API_KEY = "key=";				// key=YOUR_API_KEY"
	
	// Google Cloud
		// Bucket
		private String Bucket = "";
		// Picture
		private String image_name = "";
		
	private String Json_input = "{\"requests\":  [{ \"features\":  [ {\"type\": \"LABEL_DETECTION\""
			 +"}], \"image\": {\"source\": { \"gcsImageUri\":"
			 +" \"gs://vision-sample-images/4_Kittens.jpg\"}}}]}";
	
	JSONObject requests = new JSONObject();
	
	
	public TEXT_DETECTION() throws Exception
	{
		Json_Request();
		
		URL serverUrl = new URL(TARGET_URL + API_KEY);
		URLConnection urlConnection = serverUrl.openConnection();
		HttpURLConnection httpConnection = (HttpURLConnection)urlConnection;
		
		httpConnection.setRequestMethod("POST");
		httpConnection.setRequestProperty("Content-Type", "application/json");
		httpConnection.setDoOutput(true);
		
		BufferedWriter httpRequestBodyWriter = new BufferedWriter(new OutputStreamWriter(httpConnection.getOutputStream()));
		httpRequestBodyWriter.write(requests.toString());
		//httpRequestBodyWriter.write(Json_input);
		httpRequestBodyWriter.close();
		
		String response = httpConnection.getResponseMessage();
		
		if (httpConnection.getInputStream() == null) {
			   System.out.println("No stream");
			   return;
			}
		
		Scanner httpResponseScanner = new Scanner (httpConnection.getInputStream());
		String resp = "";
		while (httpResponseScanner.hasNext()) 
		{
		   String line = httpResponseScanner.nextLine();
		   resp += line;
		   System.out.println(line);  //  alternatively, print the line of response
		}
		httpResponseScanner.close();	
	}
	
	private void Json_Request() throws Exception
	{		
		JSONObject gcsImageUri = new JSONObject();
		gcsImageUri.put("gcsImageUri", "gs://"+Bucket+"/"+image_name);
		JSONObject source = new JSONObject();
		source.put("source", gcsImageUri);
		
		// features
		JSONArray type_array = new JSONArray();
		JSONObject type = new JSONObject();
		type.put("type", "TEXT_DETECTION");				
		type_array.put(type);		
			
		JSONObject temp = new JSONObject();				
		temp.put("image", source);
		temp.put("features", type_array);
		
		JSONArray temparray = new JSONArray();
		temparray.put(temp);
		
		// requests		
		requests.put("requests", temparray);
		System.out.println(requests);
	}
	
	private void Parser_response()
	{
		
	}
	
	public static void main(String args[])
	{
		try {
			TEXT_DETECTION TD = new TEXT_DETECTION();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
