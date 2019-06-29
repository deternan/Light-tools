
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/*
 * html parser 
 * 
 * Web: TechOrange
 * 
 * version: December 13, 2017 05:25 PM
 * Last revision: December 18, 2017 03:12 PM
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

public class Html_Parser_TechOrange 
{
	// html information
	String url = "https://buzzorange.com/techorange/2017/12/13/visa-sound/";	
	Document doc = Jsoup.connect(url).get();
	
	String title_text;
	String content_text;
	String keywords_text;
	String keywords_array[];
	// Json
	private JSONArray json_array = new JSONArray();
	private JSONObject obj = new JSONObject();
	// output text
	private String outputpath = "";
	private String output_folder = "";
	private String output_file;	
	
	public Html_Parser_TechOrange() throws Exception
	{					
		Title();
		Text();
		Keywords();
        
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
		Document doc = Jsoup.connect(url).get();

		// Text
		// TechOrange, TechNews
		Elements entrycontent = doc.getElementsByClass("entry-content");
		content_text = entrycontent.text().toString();
		//System.out.println(entrycontent.text()+"	"+content_text);
		//System.out.println(content_text);
		
		// 經理人
		// Elements entrycontent = doc.getElementsByClass("row htmlview");
		// System.out.println(entrycontent.text());
		
	}
	
	private void Keywords()
	{		
		keywords_text = doc.select("meta[name=keywords]").first().attr("content"); 
		//System.out.println(keywords_text);
	}
	
	private void Filter()
	{
		// Title		  
		String title_fit_str = "|";
		int title_fit_index = title_text.indexOf(title_fit_str);		
		title_text = title_text.substring(0, title_fit_index);
		//System.out.println(title_text);
		
		// Content			
		String content_fit_str = "你對製作這些科技趨勢內容有興趣嗎";
		int content_fit_index = content_text.indexOf(content_fit_str);		
		content_text = content_text.substring(0, content_fit_index);
		//System.out.println(content_text);
		
		// Keywords
		keywords_array = keywords_text.split(",");
		//System.out.println(keywords_array.length);
	}
	
	private void Json_generation() throws Exception
	{		
		obj.put("Title", title_text.trim());
		obj.put("Content", content_text.trim());
		obj.put("Keywords", keywords_array);
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
			Html_Parser_TechOrange htmlparser = new Html_Parser_TechOrange();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
