package http;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/*
 * 
 * Get web folder list
 * Copyright (C) 2017 Phelps Ke, phelpske.dev at gmail dot com
 * 
 * Last revision: July 22, 2017 03:59 PM
 * 
 * JAR
 * Jsoup-1.10.2.jar
 */

public class Web_folder 
{
	String url = "http://fund.bot.com.tw/z/ze/zeb/";
	
	public Web_folder() throws Exception
	{
		Document doc = Jsoup.connect(url).get();
        for (Element file : ((Element) doc).select("td.right td a")) {
            System.out.println(file.attr("href"));
        }
	}
	
	public static void main(String args[])
	{
		try {
			Web_folder wf = new Web_folder();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
