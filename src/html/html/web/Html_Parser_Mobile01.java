package html.web;

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
 * Last revision: January 02, 2018 06:49 PM
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
	String url = "https://www.mobile01.com/topicdetail.php?f=232&t=5320958&p=16";	
	Document doc = Jsoup.connect(url).get();
	
	String title_text;
	String content_text;
	
	int page_based = 0;
	
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
		
		Page_base();
		
//		Title();
		
		id_list();
		
//		Keywords();
		
		// Fileter
		
		// Json generation
//		Json_generation();

	}
	
	private void Page_base()
	{
		if(url.indexOf("&p=") > 0){
			//page_based = url.lastIndexOf(ch);
			//System.out.println(url.substring(url.indexOf("&p=") + "&p=".length(), url.length()));
			page_based = Integer.parseInt(url.substring(url.indexOf("&p=") + "&p=".length(), url.length()));
			
			//System.out.println(page_based);
		}
	}
	
	private void Title()
	{
		title_text = doc.select("meta[property=og:title]").first().attr("content"); 
		//System.out.println(title_text);
	}
	
	private void id_list() throws Exception
	{		
		int count;
		
		// Text				
		Elements allclass = doc.select("div[class=single-post-content]");
		
		//System.out.println(allclass.size());
		for (int i=0; i<allclass.size(); i++) 
		{
			//System.out.println(allclass.get(i).child(0).id());
			count = ((page_based-1) * 10) + i;
			Text(allclass.get(i).child(0).id(), count);
		}
		
	}	

	private void Text(String id, int count)
	{
		String text;
		String blockquote_text = "";
		Elements idtext = doc.select("div[id="+id+"]");
		
		// -----------------------------
		//System.out.println(idtext);
		Elements blockquote = idtext.select("blockquote");
		blockquote_text = blockquote.text();		
		//System.out.println(blockquote.text());
		
		text = blockquote(idtext.text(), blockquote_text);
		// -----------------------------
		
		// Filter
		text = Filter(text);
		
		System.out.println(count+"	"+id+"	"+text);
		
		// export
		Export(String.valueOf(count)+".txt", text);
	}
	
	private String blockquote(String idtext, String blockquote_text)
	{
		String blockquote = "";
		
		blockquote = idtext.replace(blockquote_text, "");
		
		return blockquote;
	}
	
	private String Filter(String text)
	{
		String text_temp = "";
		
		if(text.indexOf("wrote:") > 0){
			text_temp = text.substring(text.indexOf("wrote:")+"wrote:".length(), text.length());
		}else{
			text_temp = text;
		}
		
		return text_temp;
	}
	
	private void Json_generation() throws Exception
	{		
		obj.put("Title", title_text.trim());
		obj.put("Content", content_text.trim());
		
		json_array.put(obj);
		//System.out.println(json_array);
	}
	
	private void Export(String filename, String text)
	{
//		if(title_text.trim().length() > 0){
//			output_file = title_text.trim() + ".txt";
//		}else{
//			output_file = "No title.json";
//		}		 
		output_file = filename + ".txt";
		
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputpath + output_folder + output_file), "utf-8"));
			writer.write(text);
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
