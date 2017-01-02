
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
 * Last revision: January 02, 2017	11:56 PM
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Auto_download 
{
	private String Source_ = "http://www.ored.com.tw/AUTHAdmin_SJW/file_upload/";
	private String Target_folder = "D:\\Constract\\";
	    
	// 
	private OutputStream outStream_file;
    // WWW
	private int port = 80;
	
	public Auto_download() throws Exception
	{
		String enc = System.getProperty("file.encoding");
		System.out.println(enc);
		

		String filename;
		Document doc = Jsoup.connect(Source_).get();
        String UTF_8_str;
		for (Element file : doc.select("a"))
        {
            //System.out.println(count+++"	"+file.attr("href"));
			filename = file.attr("href").toString().substring(file.attr("href").toString().lastIndexOf("/")+1, file.attr("href").toString().length());
			UTF_8_str = new String(filename.getBytes("UTF-8"), "UTF-8"); 
            
            System.out.println(UTF_8_str);
            if((UTF_8_str!=null)&&(UTF_8_str.length() >0)){
            	Download(UTF_8_str);
            }            
        }
		
	}
	
	private void Download(String filename) throws Exception
	{		
		System.out.println(Target_folder + filename);
		URL url = new URL(Source_ + filename);
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
		System.out.println(filename+" File downloaded");
		
		
		/*
		URL url = new URL(Source_ + filename);		
		InputStream in = url.openStream();
		Files.copy(in, Paths.get(Target_folder + filename), StandardCopyOption.REPLACE_EXISTING);
		in.close();
		*/
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

