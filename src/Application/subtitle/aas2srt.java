package Application.subtitle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*
 * Transfer *.aas to *.srt
 * 
 * version: November 16, 2017 10:17 AM
 * Last revision: November 16, 2017 11:47 AM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

public class aas2srt 
{
	// Read files
	private String folder_source = "";
	private String file = "";
	private BufferedReader bfr;
	// subtitle string
	private int count_index = 0;
	private String total_str = "";
	private String start_time;
	private String end_time;
	private String Tag_ = " --> ";
		// split
		private String start_ = "Dialogue: 0,";
		private String end_ = "Default,,0,0,0,,";
	// output
	private BufferedWriter writer;
	private String output_folder = "";
	private String output_file;
	private String fileextension = ".srt";
		
	public aas2srt() throws Exception
	{
		System.getProperty("UTF-8");
		
		// Read file
		File folder = new File(folder_source);
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile()) {				
				System.out.println(file.getName());
				
				// output initialize
				output_file = file.getName();
				writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output_folder + output_file + fileextension), "utf-8"));
				
				Parser_subtitle(folder_source + file.getName());
								
				writer.close();		
			}
		}
	}
	
	private void Parser_subtitle(String source) throws Exception
	{
		String Line = "";
		FileReader fr = new FileReader(source);
		bfr = new BufferedReader(fr);
		String txt_str;
		String time_str;
		
		while((Line = bfr.readLine())!=null)
		{						
			if(Line.indexOf("Dialogue") == 0){				
				time_str = Line.substring(start_.length(), Line.indexOf(end_)-1);				
				txt_str = Line.substring(Line.indexOf("Default")+"\"Default,,0,0,0,,\"".length()-2, Line.length());
				total_str = txt_str; 
				
				// Translation
				Translation(time_str, txt_str);
			}
		}
		fr.close();
		bfr.close();
	}
	
	private void Translation(String time_str, String txt_str) throws Exception
	{		
		
		if(txt_str.trim().length() > 0){
			count_index++;			
			
			// start time parser
			start_time = start_time_parser(time_str);
			// end time parser
			end_time = end_time_parser(time_str);
			
			// Display
//			System.out.println(count_index);
//			System.out.println(start_time + Tag_ + end_time);
//			System.out.println(txt_str);
//			System.out.println();
			// output
			writer.write(count_index+"\n");
			writer.write(start_time + Tag_ + end_time+"\n");
			writer.write(txt_str+"\n");
			writer.write("\n");
		}
		
	}
	
	private String start_time_parser(String input_time)
	{
		String start_time = "";
		start_time = input_time.substring(0, input_time.indexOf(","));
		
		return start_time;
	}
	
	private String end_time_parser(String input_time)
	{
		String end_time = "";
		end_time = input_time.substring(input_time.indexOf(",")+1, input_time.length());
		
		return end_time;
	}
	
	public static void main(String args[])
	{
		try {
			aas2srt a2s = new aas2srt();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
