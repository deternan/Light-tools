package Application.subtitle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/*
 * Transfer *.str to *.txt format
 * 
 * version: October 25, 2017 10:43 AM
 * Last revision: October 25, 2017 11:31 AM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

public class srt2txt 
{
	// Read files
	private String folder_source = "C:\\Users\\Barry.Ke\\Desktop\\全部字幕\\深入淺出 VR 虛擬實境開發 (3)\\";
	private String file = "";
	private BufferedReader bfr;
	
	// Write output
	private String output_folder = "C:\\Users\\Barry.Ke\\Desktop\\全部字幕 (txt)\\深入淺出 VR 虛擬實境開發 (3)\\";
	private String output_file;
	
	private String sentence;
	
	public srt2txt() throws Exception
	{
		System.getProperty("UTF-8");
		
		// Read file
		File folder = new File(folder_source);
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile()) {				
				System.out.println(file.getName());
				output_file = file.getName() + ".txt";
				Parser_subtitle(folder_source + file.getName());
				// System.out.println(total_str);

				// output
				Output_txt(output_file, sentence);
			}
		}
	}
	
	private void Parser_subtitle(String source) throws Exception
	{
		sentence = "";
		String Line = "";
		FileReader fr = new FileReader(source);
		bfr = new BufferedReader(fr);
		String temp;
		while((Line = bfr.readLine())!=null)
		{						
			//System.out.println(Line);
			
			if(CJKV_check(Line) == true){
				//System.out.println(Line);
				sentence += Line +"\n";
			}
		}
		
		fr.close();
		bfr.close();
	}
	
	private boolean CJKV_check(String input_str)
	{		
		boolean check;
		check = input_str.codePoints().anyMatch(codepoint ->
	            Character.UnicodeScript.of(codepoint) == Character.UnicodeScript.HAN);
		
		return check;
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
			srt2txt st = new srt2txt();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
