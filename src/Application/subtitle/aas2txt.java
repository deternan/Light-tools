package Application.subtitle;

/*
 * Transfer *.ass to *.txt format
 * 
 * version: October 25, 2017 10:17 AM
 * Last revision: October 25, 2017 10:17 AM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class aas2txt 
{
	// Read files
	private String folder_source = "";
	private String file = "";
	private BufferedReader bfr;	
	// subtitle string
	private String total_str = "";
	// Write output
	private String output_folder = "";
	private String output_file;
	
	public aas2txt() throws Exception
	{
		// Read file
		File folder = new File(folder_source);
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
		    if (file.isFile()) {
		    	total_str = "";
		        System.out.println(file.getName());
		        output_file = file.getName() + ".txt";
		        Parser_subtitle(folder_source + file.getName());        
		        //System.out.println(total_str);
		        
		        // output
		        Output_txt(output_file, total_str);
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
			if(Line.indexOf("Dialogue") == 0){				
				temp = Line.substring(Line.indexOf("Default")+"\"Default,,0,0,0,,\"".length()-2, Line.length());				
				total_str += temp + "\n";				
			}
		}
		fr.close();
		bfr.close();
	}
	
	private void Output_txt(String outputfilename, String str)
	{
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output_folder + outputfilename), "utf-8"));
			if(str.length() > 0){
				writer.write(str);
			}			
			writer.close();
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[])
	{
		try {
			aas2txt a2t = new aas2txt();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}
