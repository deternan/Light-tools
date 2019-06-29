package html_download;

/*
 * Auto_download.java
 * 
 * Copyright (C) 2016 Phelps Ke, phelpske.dev at gmail dot com
 * 
 * Automatic download
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * 
 * Jar
 * jsoup-1.10.2.jar
 * 
 * Last revision: March 09, 2017	11:27 PM
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Get_openfind_embed_video 
{
	private String url = "";
	
	private String Revised_str;
	
	public Get_openfind_embed_video() throws Exception
	{
		
		// JSoup Example 2 - Reading HTML page from URL
		Document doc = Jsoup.connect(url).timeout(5000).get();
		doc.outputSettings().charset("UTF-8");
		String title = doc.title();		
		// Title
		System.out.println(title);
		
		boolean check_exist = false;
		
		// iframe		
		Elements iframe_ele = doc.select("td iframe");
		if((iframe_ele.size() > 0) && (iframe_ele.toString().contains("https"))){
			Revised(iframe_ele);
			check_exist = true;
		}
		// embed
		Elements embed_ele = doc.select("div embed");
		if((embed_ele.size() > 0) && (embed_ele.toString().contains("https"))){
			Revised(embed_ele);
			check_exist = true;
		}
		
		if(check_exist == false){
			System.out.println("No video");
		}
	}
	
		
	private void Revised(Elements elements)
	{		
		String temp_url;
		
		//System.out.println(elements.get(0));
		temp_url = elements.get(0).attr("src");
		Revised_str = temp_url.replace("embed", "f");
			
		System.out.println(Revised_str);		
	}
	
	public static void main(String[] args)
	{
		try {
			Get_openfind_embed_video gt = new Get_openfind_embed_video();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
