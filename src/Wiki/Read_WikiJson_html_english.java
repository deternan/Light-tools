package Wiki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Vector;

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

public class Read_WikiJson_html_english 
{
	// Wiki
	private String input_title = "pizza";

	JSONObject get_json = null;
	private String wikitext_all;
	private Vector wikitext_vec = new Vector();
	private String wikitext_english;
	
	public Read_WikiJson_html_english()
	{
		// Get Json from html
		readJsonFromUrl("https://en.wikipedia.org/w/api.php?action=query&redirects=&converttitles=&prop=revisions&rvprop=content&format=json&titles=" + input_title);
		// Parser Json
		Parser(get_json);
		//System.out.println(get_json);
		// Filter
		Separation();
		// Get English words
		wikitext_english = Text_filter();
		System.out.println(wikitext_english);
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
		
		String front_term;
		String temp_;
		for(int i=0; i<temp.length; i++)
		{
			if(temp[i].contains(".")){
				front_term = temp[i].substring(0, 1);				
				if(English_filter(front_term)){
					temp_ = Remove_tag(temp[i]);
					//System.out.println(English_filter(front_term)+"	"+temp_);
					
					wikitext_vec.add(temp_);
				}				
			}			
		}
	}
	
	private boolean English_filter(String input_str)
	{
		boolean check;		
		check = input_str.matches("[a-zA-Z]+");
		
		return check;
	}
	
	private String Remove_tag(String input_str)
	{
		input_str = input_str.replace("[[", "");
		input_str = input_str.replace("]]", "");
		input_str = input_str.replace("''", "");
		input_str = input_str.replace("\\\"", "");
		int ref_index = input_str.indexOf("<ref");
		int ref_end = input_str.indexOf("</ref>");
		if((ref_index>0) && (ref_end>0)){
			String ref_str = input_str.substring(ref_index, ref_end+"</ref>".length());
			//System.out.println(ref_str);
			input_str = input_str.replace(ref_str, "");			
		}
		
		return input_str;
	}
	
	private String Text_filter()
	{
		String sentence = "";
		
		for(int i=0; i<wikitext_vec.size(); i++)
		{
			sentence += wikitext_vec.get(i).toString()+"\\s";
			//for(int j=0; j<wikitext_vec.get(i).toString().length(); j++)
			{  
				
//			    String test = wikitext_vec.get(i).toString().substring(j, j+1);		    
//			    if(test.matches("[{0-9}{a-z}{A-Z}.]+")){			        
//			    	
//			    }  		      
			}	
		}
		
		return sentence;
	}
	
	public static void main(String args[]) 
	{
		Read_WikiJson_html_english read = new Read_WikiJson_html_english();
	}
	
}
