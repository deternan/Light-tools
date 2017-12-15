package html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * html parser 
 * 
 * Web: TechNews
 * 
 * version: December 13, 2017 05:25 PM
 * Last revision: December 14, 2017 02:16 PM
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

public class Html_Parser_TechNews 
{
	String url = "https://technews.tw/2017/12/14/may-ai-chip-king-transfer-to-asic/";
	
	Document doc;
	
	public Html_Parser_TechNews() throws Exception
	{		
		doc = Jsoup.connect(url).get();		
//		Title();
//		Text();
		Keywords();
        
	}
	
	private void Title()
	{
		String title = doc.select("meta[property=og:title]").first().attr("content"); 
		System.out.println(title);
	}
	
	private void Text() throws Exception
	{		
		// Text
		//  TechNews
		Elements myin = doc.getElementsByClass("indent");
//		for(int i=0; i<myin.size(); i++)
//		{
//			if(myin.get(i).attr("p").isEmpty()){
//				//System.out.println(myin.get(i).text());	
//			}
//			
//		}
		System.out.println(myin.text());
		
	}
	
	private void Keywords()
	{				
		Elements keywords = doc.select("a[rel=tag]");		
		for (Element Tags : keywords)
		{
			System.out.println(Tags.text());
		}
	}
	
	public static void main(String[] args)
	{
		try {
			Html_Parser_TechNews htmlparser = new Html_Parser_TechNews();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
