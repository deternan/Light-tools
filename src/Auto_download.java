
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
 * Last revision: December 31, 2016	12:30 PM
 */


import java.io.OutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Auto_download 
{
	private String Source_ = "http://www.ored.com.tw/AUTHAdmin_SJW/file_upload/";
	private String Target_folder = "C:\\Users\\user\\Desktop\\Constract\\";
	
	//String server = "www.ored.com.tw/AUTHAdmin_SJW/file_upload/";
    
	// 
	private OutputStream outStream_file;
    
	public Auto_download() throws Exception
	{
		
		Document doc = Jsoup.connect(Source_).get();
        for (Element file : doc.select("a"))
        {
            System.out.println(file.attr("href"));
        }
		
	}
	
	private void Download_file(String remoteFile) throws IOException
	{
		String temp;		
		String nxml_tar[] = remoteFile.split("/");
		
		temp = "pub/pmc/".concat(remoteFile);
		//outStream_file = new FileOutputStream(current_path+"/"+TAR_folder+"/".concat(nxml_tar[3]));	
		//client_nxml.retrieveFile(temp, outStream_nxml);		
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
