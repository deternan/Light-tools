package Files;

/*
 * html parser 
 * 
 * version: December 14, 2017 10:02 AM
 * Last revision: December 14, 2017 10:02 AM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;

public class SplitText 
{
	// Segmentation num 
	private int segnum = 500;
	
	// Read data
	private String readfolder = "";
	private String readfile = "";
	private BufferedReader bfr;	
	// Saving
	private String output_folder = readfolder + "split\\";
	private String output_file;		
	BufferedWriter writer;
	
	public SplitText() throws Exception
	{
		String Line = "";
		FileReader fr = new FileReader(readfolder + readfile);
		bfr = new BufferedReader(fr);
		
		int count = 1;
		String str_ = "";
		while((Line = bfr.readLine())!=null)
		{
			str_ += Line + "\n";
			if((count%segnum) == 0){
				output_file = String.valueOf(count)+".txt";
				System.out.println(count+"	"+output_file);
				
				// Saving
				writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output_folder + output_file), "utf-8"));
				writer.write(str_);
				writer.close();
				str_ = "";
			}			
			
			count++;
		}
		fr.close();
		bfr.close();
	}
	
	
	
	public static void main(String[] args)
	{
		try {
			SplitText sp = new SplitText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
