package Application;

/*
 * Reas *.ass file
 * 
 * version: October 20, 2017 01:41 PM
 * Last revision: October 20, 2017 01:41 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class Readaas 
{
	private String folder_source = "";
	private String file = "";	
	private BufferedReader bfr;	
	
	private String total_str = "";
	
	public Readaas() throws Exception
	{
		File folder = new File(folder_source);
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
		    if (file.isFile()) {
		    	total_str = "";
		        //System.out.println(file.getName());
		        Parser_subtitle(folder_source + file.getName());
		        
		        System.out.println(total_str);
		    }
		}
	}
	
	private void Parser_subtitle(String source) throws Exception
	{
		String Line = "";
		FileReader fr = new FileReader(source);
		bfr = new BufferedReader(fr);
		String temp;
		while((Line = bfr.readLine())!=null)
		{			
			//System.out.println(source+"	"+Line);
			if(Line.indexOf("Dialogue") == 0){				
				temp = Line.substring(Line.indexOf("Default")+"\"Default,,0,0,0,,\"".length()-2, Line.length());				
				total_str += temp + ", ";				
			}
		}
		fr.close();
		bfr.close();
	}
	
	public static void main(String args[]) 
	{
		try {
			Readaas r_aas = new Readaas();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
