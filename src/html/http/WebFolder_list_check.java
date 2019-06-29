import java.net.HttpURLConnection;
import java.net.URL;

/*
 * 
 * Web folder
 * Copyright (C) 2017 Phelps Ke, phelpske.dev at gmail dot com
 * 
 * Last revision: July 22, 2017 04:43 PM
 * 
 */

public class WebFolder_list_check 
{
	final String USER_AGENT = "Mozilla/5.0";	
	String base_url = "http://fund.bot.com.tw/z/ze/zeb/zebb_0";
	
	public WebFolder_list_check() throws Exception
	{
		// http://fund.bot.com.tw/z/ze/zeb/zebb_011.djhtm
		// http://fund.bot.com.tw/z/ze/zeb/zebb_012.djhtm
		// http://fund.bot.com.tw/z/ze/zeb/zebb_032.djhtm
		
		String url_temp;
		for(int i=0; i<=9; i++)
		{
			for(int j=0; j<=9; j++)
			{
				url_temp = base_url + Integer.toString(i)+Integer.toString(j) + ".djhtm";
				//System.out.println(url_temp);
				Access_check(url_temp);
			}
		}
		
	}
	
	private void Access_check(String url) throws Exception
	{		
		//System.out.println(url);
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		// optional default is GET
		con.setRequestMethod("GET");
		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		//System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println(url+"	Response Code : " + responseCode);
		
	}
	
	public static void main(String args[])
	{
		try {
			WebFolder_list_check wfl_check = new WebFolder_list_check();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
