/*
 * html parser 
 * 
 * version: December 13, 2017 05:25 PM
 * Last revision: December 13, 2017 07:00 PM
 * 
 * Author : Chao-Hsuan Ke
 */

package html.web;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/*
 * JAR
 * jsoup-1.10.2.jar
 */

public class Html_Parser 
{
	String url = "https://technews.tw/2017/12/12/apple-app-pre-order/";
	
	public Html_Parser() throws Exception
	{		
		Document doc = Jsoup.connect(url).get();
        
		// title
		String title = doc.title();
        System.out.println(title);
		
        // Text
        Elements entrycontent = doc.getElementsByClass("entry-content");
        System.out.println(entrycontent.text());
	}
	
	public static void main(String[] args)
	{
		try {
			Html_Parser htmlparser = new Html_Parser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
