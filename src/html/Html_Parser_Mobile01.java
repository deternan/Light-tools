package html;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/*
 * html parser 
 * 
 * Web: Mobile 01
 * 
 * version: January 02, 2018 04:08 PM
 * Last revision: January 02, 2018 05:17 PM
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

public class Html_Parser_Mobile01 
{
	String url = "https://www.mobile01.com/topicdetail.php?f=232&t=5320958&p=1";	
	Document doc = Jsoup.connect(url).get();
	
	String title_text;
	String content_text;
	
	
	
	// Json
	private JSONArray json_array = new JSONArray();
	private JSONObject obj = new JSONObject();
	// output text
	private String outputpath = "";
	private String output_folder = "";
	private String output_file;	
	
	public Html_Parser_Mobile01() throws Exception
	{		
		doc = Jsoup.connect(url).get();		
//		Title();
		
		id_list();
		
//		Keywords();
		
		// Fileter
//		Filter();
		// Json generation
//		Json_generation();
		// export
//		Export();
	}
	
	private void Title()
	{
		title_text = doc.select("meta[property=og:title]").first().attr("content"); 
		//System.out.println(title_text);
	}
	
	private void id_list() throws Exception
	{		
		// Text		
		//Elements allid = doc.getElementsByClass("div[class=single-post-content]");
		Elements allclass = doc.select("div[class=single-post-content]");
		
		System.out.println(allclass.size());
		for (int i=0; i<allclass.size(); i++) 
		{
			//System.out.println(allclass.get(i).child(0).id());
			
			Text(allclass.get(i).child(0).id());
		}
		
	}	

	private void Text(String id)
	{
		Elements idtext = doc.select("div[id="+id+"]");
		System.out.println(id+"	"+idtext.text());
	}
	
	private void Filter()
	{		
		// Content
		String content_fit_str = "你可能有興趣的文章";
		int content_fit_index;
		if(content_text.indexOf(content_fit_str) > 0){
			content_fit_index = content_text.indexOf(content_fit_str);
		}else{
			content_fit_str = "延伸閱讀";
			content_fit_index = content_text.indexOf(content_fit_str);
			content_text = content_text.substring(0, content_fit_index);
		}
		
				
		
		//System.out.println(content_text);		
	}
	
	private void Json_generation() throws Exception
	{		
		obj.put("Title", title_text.trim());
		obj.put("Content", content_text.trim());
		
		json_array.put(obj);
		//System.out.println(json_array);
	}
	
	private void Export()
	{
		if(title_text.trim().length() > 0){
			output_file = title_text.trim() + ".json";
		}else{
			output_file = "No title.json";
		}		 
		
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputpath + output_folder + output_file), "utf-8"));
			writer.write(json_array.toString());
			writer.close();
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		try {
			Html_Parser_Mobile01 htmlparser = new Html_Parser_Mobile01();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
