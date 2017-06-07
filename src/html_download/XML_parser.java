/*
 * XML parser
 * 
 * version: June 08, 2017 01:07 AM
 * Last revision: June 08, 2017 01:07 AM,
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class XML_parser 
{
	// Get
	private final String USER_AGENT = "Mozilla/5.0";
	private String url = "";
	
	public XML_parser() throws Exception
	{
		httpsendGet();
		
	}
	
	private void httpsendGet() throws Exception 
	{
		

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		System.out.println(response.toString());

	}
	
	public static void main(String[] args) 
	{
		try {
			XML_parser xml = new XML_parser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
