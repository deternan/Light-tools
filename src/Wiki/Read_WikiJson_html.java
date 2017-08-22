package Wiki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * 
 * version: August 22, 2017 02:24 PM
 * Last revision: August 22, 2017 05:26 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

public class Read_WikiJson_html 
{
	// Wiki
	private String input_title = "利害關係人";

	JSONObject get_json = null;
	private String wikitext_all;
	private Vector wikitext_vec = new Vector();
	private String wikitext_chinese;
	
	public Read_WikiJson_html()
	{
		// Get Json from html
		readJsonFromUrl("https://zh.wikipedia.org/w/api.php?action=query&redirects=&converttitles=&prop=revisions&rvprop=content&format=json&titles=" + input_title);
		// Parser Json
		Parser(get_json);
		//System.out.println(get_json);
		// Filter
		Separation();
		// Get Chinese words
		wikitext_chinese = Chinese_Text_filter();
		System.out.println(wikitext_chinese);
	}
	
	private void readJsonFromUrl(String url)  
	{		
		InputStream is;
		String jsonText = "";
		
		try {
			is = new URL(url).openStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			//String jsonText = readAll(rd);
			StringBuilder sb = new StringBuilder();
		    int cp;
		    while ((cp = rd.read()) != -1) {
		      sb.append((char) cp);
		    }
		    jsonText = sb.toString();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		try {
			get_json = new JSONObject(jsonText);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void Parser(JSONObject obj)
	{
		try {
			JSONObject query = new JSONObject(obj.get("query").toString());			
			//System.out.println(query);
			JSONObject pages = new JSONObject(query.get("pages").toString());
			//System.out.println(pages);
			//System.out.println(pages.names());
			int page_number = pages.names().getInt(0);
			//System.out.println(page_number);
			JSONObject pagenumber = new JSONObject(pages.get(String.valueOf(page_number)).toString());			
			//System.out.println(pagenumber.getJSONArray("revisions").get(0));
			JSONObject revisions_json = new JSONObject(pagenumber.getJSONArray("revisions").get(0).toString());
			//System.out.println(revisions_json);
			// wiki text
			wikitext_all = revisions_json.getString("*");
			//System.out.println(wikitext);			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	private void Separation()
	{
		String[] temp;
		temp = wikitext_all.split("\\n");
		//System.out.println(wikitext_all);		
		//System.out.println(temp.length);
		
		for(int i=0; i<temp.length; i++)
		{
			if(temp[i].contains("。")){
				//System.out.println(temp[i]);
				wikitext_vec.add(temp[i]);
			}			
		}
	}
	
	private String Chinese_Text_filter()
	{
		String sentence = "";
		
		for(int i=0; i<wikitext_vec.size(); i++)
		{
			for(int j=0; j<wikitext_vec.get(i).toString().length(); j++)
			{  
			    String test = wikitext_vec.get(i).toString().substring(j, j+1);		    
			    if(test.matches("[\\u4E00-\\u9FA5，。]+")){
			        //System.out.printf("\t[Info] %s -> 中文!\n", test);
			    	sentence += test;
			    }  		      
			}	
		}
			
		
		
//		for(int i=0; i<input_str.length();i++)
//		{  
//		    String test = input_str.substring(i, i+1);  		    
//		    if(test.matches("[\\u4E00-\\u9FA5，。]+")){
//		        //System.out.printf("\t[Info] %s -> 中文!\n", test);
//		    	sentence += test;
//		    }  		      
//		}
		
		return sentence;
	}
	
	public static void main(String args[]) 
	{
		Read_WikiJson_html read = new Read_WikiJson_html();
	}
	
}
