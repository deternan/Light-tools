package API;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;
import java.net.URLEncoder;

/*
 * http POST
 * 
 * version: October 20, 2017 10:06 AM
 * Last revision: November 14, 2017 11:13 AM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

/*
 * JAR
 * jackson-1.4.2.jar 
 * slf4j-api-1.7.12.jar
 * apache-commons.jar
 * httpclient-4.5.1.jar
 * httpcore-4.4.6.jar
 * 
 */

public class POST 
{
	// http
	private final String USER_AGENT = "Mozilla/5.0";
	private String API_url = "http://nlp.deltaww.com/summary";
	
	private String input_str = "";
	
	public POST()
	{				
		
		URL url;
	    HttpURLConnection connection = null;  
	    try {
	    
	    	String urlParameters = "text=" + URLEncoder.encode(input_str, "UTF-8");
	    	
	      //Create connection
	      url = new URL(API_url);
	      connection = (HttpURLConnection)url.openConnection();
	      connection.setRequestMethod("POST");
	      connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				
	      connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));
	      //connection.setRequestProperty("Content-Language", "en-US");  
	      connection.setRequestProperty("Content-Language", "UTF-8");
				
	      connection.setUseCaches (false);
	      connection.setDoInput(true);
	      connection.setDoOutput(true);

	      //Send request
	      DataOutputStream wr = new DataOutputStream (
	                  connection.getOutputStream ());
	      wr.writeBytes (urlParameters);
	      wr.flush ();
	      wr.close ();

	      // Get Response code
	      if(connection.getResponseCode() == 200){
	    	  // 200 OK
	    	  InputStream is = connection.getInputStream();		     
		      BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		      String line;
		      StringBuffer response = new StringBuffer(); 
		      while((line = rd.readLine()) != null) {
		        response.append(line);
		        response.append('\r');
		      }
		      rd.close();
		      System.out.println(response.toString());   
	      }else if(connection.getResponseCode() == 404){
	    	  // 404 Not Found
	    	  
	      }else if(connection.getResponseCode() == 500){
	    	  // 500 Internal Server Error 
	    	  
	      }
	      
	      

	    } catch (Exception e) {

	      e.printStackTrace();
	      

	    } finally {

	      if(connection != null) {
	        connection.disconnect(); 
	      }
	    }
		
	}
	
	public static void main(String[] args)
	{
		try {
			POST post = new POST();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
