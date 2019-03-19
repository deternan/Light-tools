package Application.subtitle;

/*
 * Transfer *.str to *.txt format
 * 
 * version: October 25, 2017 10:43 AM
 * Last revision: March 19, 2019 05:22 PM
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

public class srt2txt 
{
	// Read files
	private String folder_source = "";	
	private BufferedReader bfr;
	
	// Write output
	private String output_folder = "";
	private String output_file;
	
	private String sentence;
	
	Vector oriVec = new Vector();
	
	public srt2txt() throws Exception
	{
		System.getProperty("UTF-8");
		
		// Read file
		File folder = new File(folder_source);
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile()) {				
				//System.out.println(file.getName());
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
//			if(CJKV_check(Line) == true)
			{
				temp = new String(Line.getBytes("utf-8"), "utf-8");
				//System.out.println(new String(Line.getBytes("utf-8"), "utf-8"));
				//System.out.println(temp);
				filter(temp);				
			}
		}		
		fr.close();
		bfr.close();		
	}
	
	private void filter(String inputStr) {
		boolean lengthCheck = false;
		boolean tagCheck = false;
		boolean numCheck = false;
		
		// length check
		if(inputStr.trim().length() > 0) {
			//System.out.println(inputStr);
			lengthCheck = true;
		}
		// Tag check
		if(inputStr.contains("-->") == false) {
			tagCheck = true;
		}
		// Numerical check
		if((inputStr.trim().matches("[0-9]+") == false) && (inputStr.trim().length() >3)) {
			numCheck = true;
		}
		
		if((lengthCheck == true) && (tagCheck == true) && (numCheck == true)) {
			//System.out.println(inputStr);
			sentence += inputStr +"\n";
		}
		
	}
	
//	private boolean CJKV_check(String input_str)
//	{		
//		boolean check;
//		check = input_str.codePoints().anyMatch(codepoint ->
//	            Character.UnicodeScript.of(codepoint) == Character.UnicodeScript.HAN);
//		
//		return check;
//	}
	
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
