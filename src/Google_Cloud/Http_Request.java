
/*
 * Http Request
 * 
 * version: January 27, 2018 11:24 AM
 * Last revision: January 27, 2018 01:52 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

/*
 * Reference
 * https://cloud.google.com/community/tutorials/make-an-http-request-to-the-cloud-vision-api-from-java
 * 
 */

public class Http_Request 
{
	private static final String TARGET_URL = "https://vision.googleapis.com/v1/images:annotate?";
	private static final String API_KEY = "";				// key=YOUR_API_KEY"
	
	private String Json_input = "{\"requests\":  [{ \"features\":  [ {\"type\": \"LABEL_DETECTION\""
			 +"}], \"image\": {\"source\": { \"gcsImageUri\":"
			 +" \"gs://vision-sample-images/4_Kittens.jpg\"}}}]}";
	
	/*
	 * 
	 * 
	 */
	
	
	public Http_Request() throws Exception
	{
		URL serverUrl = new URL(TARGET_URL + API_KEY);
		URLConnection urlConnection = serverUrl.openConnection();
		HttpURLConnection httpConnection = (HttpURLConnection)urlConnection;
		
		httpConnection.setRequestMethod("POST");
		httpConnection.setRequestProperty("Content-Type", "application/json");
		httpConnection.setDoOutput(true);
		
		BufferedWriter httpRequestBodyWriter = new BufferedWriter(new OutputStreamWriter(httpConnection.getOutputStream()));
		httpRequestBodyWriter.write(Json_input);
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
	
	public static void main(String args[])
	{
		try {
			Http_Request gcv = new Http_Request();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
