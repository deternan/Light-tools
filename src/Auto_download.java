
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
 * jsoup-1.10.1.jar
 * 
 * Last revision: January 06, 2017	10:34 PM
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Base64;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Auto_download 
{
	private String Source_ = "http://www.ored.com.tw/AUTHAdmin_SJW/file_upload/";
	private String Target_folder = "D:\\Constract\\";
	    
	final Base64.Decoder decoder = Base64.getDecoder();	
	
	public Auto_download() throws Exception
	{				
		System.setProperty("file.encoding", "UTF-8");				
		
		String filename;
		String encoder_str;	String UTF_8_str;
		Document doc = Jsoup.connect(Source_).get();
        //String UTF_8_str = "";
		for (Element file : doc.select("a"))
        {
            //System.out.println(file.text());
            filename = file.text();
			
            encoder_str = file.attr("href").toString().substring(file.attr("href").toString().lastIndexOf("/")+1, file.attr("href").toString().length());
			UTF_8_str = new String(encoder_str.getBytes("UTF-8"), "UTF-8"); 
            
            if((filename!=null)&&(filename.length() >0)){            	            
            	// Extension
            	if(filename.contains(".")){
            		Download(filename, UTF_8_str);
            	}            	
            }            
        }		
	}
	
	private void Download(String filename, String encode_str) throws Exception
	{		
		//System.out.println(Target_folder + filename);
		//System.out.println(Target_folder + encode_str);
		System.out.println(Source_ + filename);
		//System.out.println(Source_ + encode_str);
				
		//URL url = new URL(Source_ + filename);
		URL url = new URL(Source_ + encode_str);
		InputStream in = url.openStream();
		FileOutputStream fos = new FileOutputStream(new File(Target_folder + filename));				
		
		int length = -1;
		byte[] buffer = new byte[1024];// buffer for portion of data from connection
		while ((length = in.read(buffer)) > -1) 
		{
		    fos.write(buffer, 0, length);
		}
		fos.close();
		in.close();
		//System.out.println(filename+" File downloaded");
	}
	
	public static void main(String args[])
	{
		try {
			Auto_download Ad = new Auto_download();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

