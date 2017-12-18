package html;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;
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
	Document doc = Jsoup.connect(url).get();
	
	String title_text;
	String content_text;
	String keywords_text = "";
	Vector keywords_array = new Vector();
	// Json
	private JSONArray json_array = new JSONArray();
	private JSONObject obj = new JSONObject();
	// output text
	private String outputpath = "";
	private String output_folder = "";
	private String output_file = "";	
	
	public Html_Parser_PanSci() throws Exception
	{				 		
		Title();
		Text();
		Tagging();
        
		// Fileter		
		Filter();		
		// Json generation
		Json_generation();
		// export
		Export();
	}
	
	private void Title()
	{
		title_text = doc.select("meta[property=og:title]").first().attr("content"); 
		//System.out.println(title_text);
	}
	
	private void Text() throws Exception
	{				
		Elements entrycontent = doc.getElementsByClass("pure_content");
		content_text = entrycontent.text().toString();		
	}
	
	private void Tagging()
	{				
		Elements metaOgImage = doc.select("meta[property=article:tag]");
		for (Element Tags : metaOgImage)
		{
			keywords_array.add(Tags.attr("content"));
			//System.out.println(Tags.attr("content"));
		}		
	}
	
	private void Filter()
	{
		// Title		  
		String title_fit_str = "- PanSci 泛科學";
		int title_fit_index = title_text.indexOf(title_fit_str);		
		title_text = title_text.substring(0, title_fit_index);
		//System.out.println(title_text);
		
		// Content			
		String content_fit_str = "泛科學獨家推出創新";
		int content_fit_index = content_text.indexOf(content_fit_str);		
		content_text = content_text.substring(0, content_fit_index);
		//System.out.println(content_text);			
	}
	
	private void Json_generation() throws Exception
	{		
		obj.put("Title", title_text.trim());
		obj.put("Content", content_text.trim());
		if(keywords_array.size() > 0){
			obj.put("Keywords", keywords_array);
		}else{
			obj.put("Keywords", "No data");
		}		
		json_array.put(obj);
		System.out.println(json_array);
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
			Html_Parser_PanSci htmlparser = new Html_Parser_PanSci();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
