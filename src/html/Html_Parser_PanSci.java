package html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * html parser 
 * 
 * Web: PanSci
 * 
 * version: December 13, 2017 05:25 PM
 * Last revision: December 13, 2017 05:25 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

/*
 * JAR
 * jsoup-1.10.2.jar
 */

/*
 * Reference
 * https://stackoverflow.com/questions/11656064/how-to-get-page-meta-title-description-images-like-facebook-attach-url-using
 * 
 */

public class Html_Parser_PanSci 
{
	String url = "http://pansci.asia/archives/131057";
	
	Document doc;
	
	public Html_Parser_PanSci() throws Exception
	{		
		doc = Jsoup.connect(url).get();
		
		Title();
//		Text();
//		Tagging();
        
	}
	
	private void Title()
	{
		String title = doc.select("meta[property=og:title]").first().attr("content"); 
		System.out.println(title);
	}
	
	private void Text() throws Exception
	{		
		// Text
		// TechOrange, TechNews
		// Elements entrycontent = doc.getElementsByClass("entry-content");
		// System.out.println(entrycontent.text());

		// 經理人
		// Elements entrycontent = doc.getElementsByClass("row htmlview");
		// System.out.println(entrycontent.text());

		// PanSci
		Elements entrycontent = doc.getElementsByClass("pure_content");
		System.out.println(entrycontent.text());
	}
	
	private void Tagging()
	{		
		Elements tagging = doc.getElementsByClass("pure_content");
		
		Elements metaOgImage = doc.select("meta[property=article:tag]");
		for (Element Tags : metaOgImage)
		{
			System.out.println(Tags.attr("content"));
		}
	}
	
	public static void main(String[] args)
	{
		try {
			Html_Parser_PanSci htmlparser = new Html_Parser_PanSci();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
