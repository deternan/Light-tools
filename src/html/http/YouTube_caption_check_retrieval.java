package http;

/*
 * get YouTube caption (No Authorization)
 * 
 * version: March 30, 2017 03:31 PM
 * Last revision: March 30, 2017 04:56 PM
 * 
 * Author : Chao-Hsuan Ke (Phelps Ke)
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc., Taiwan
 * 
 */

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;


/*
 *	Example 
 *
 *	English
 *	http://video.google.com/timedtext?lang=en&v=zzfCVBSsvqA 
 * 
 * 	Chinese
 * 	http://video.google.com/timedtext?lang=zh-TW&v=6i7RcP39NB0
 * 
 */

/*
 * JAR
 * jsoup-1.10.2.jar
 * 
 */

public class YouTube_caption_check_retrieval 
{	
	private String URL_ = "http://video.google.com/timedtext?lang=";
		
	public YouTube_caption_check_retrieval(String videoid, String language)
	{
		String URL = URL_ + language +"&v=" + videoid;
		//System.out.println(URL);
				
		try {
			Document doc = Jsoup.connect(URL).get();
			Elements content = doc.select("text");
			String str;
			for(int i=0; i<content.size(); i++)
			{				
				List<Node> nodeList = content.get(i).childNodes();
				str = content.get(i).childNodes().get(0).toString().trim();
				System.out.println(str);				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
	}
	
	public static void main(String[] args) 
	{
		// Video id, 
		// e.g. 6i7RcP39NB0
		// https://www.youtube.com/watch?v=6i7RcP39NB0
		YouTube_caption_check_retrieval cc = new YouTube_caption_check_retrieval("6i7RcP39NB0", "zh-TW");
	}
	
}
