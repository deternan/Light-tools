package Files;


/*
 * File content combination
 * 
 * version: November 14, 2017 02:49 PM
 * Last revision: May 07, 2019 10:27 AM
 * 
 * Author : Chao-Hsuan Ke
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
import java.util.Arrays;

public class File_Combination 
{
	// folder source
	private String source_folder = "C:\\Users\\Barry.Ke\\Desktop\\eTube sub\\word2vec\\深入淺出 VR 虛擬實境開發 (2)\\";
	private BufferedReader bfr;	
	// Content
	private String combined_content = "";
	// output
	private String output_folder = "C:\\Users\\Barry.Ke\\Desktop\\";
	private String output_file = "深入淺出 VR 虛擬實境開發 (2).txt";		
	
	public File_Combination()
	{
		File folder = new File(source_folder);
		File[] listOfFiles = folder.listFiles();
		Arrays.sort(listOfFiles);
		
		for (File file : listOfFiles) {
		    if (file.isFile()) {
		        //System.out.println(file.getName());
		        
		        // Combination
		        Combinate_contenxt(file.toString());
		    }
		}
		
		// output
		Output();
	}
	
	private void Combinate_contenxt(String filepath)
	{
		String Line = "";
		FileReader fr;
		try {
			fr = new FileReader(filepath);
			
			bfr = new BufferedReader(fr);
			
			while((Line = bfr.readLine())!=null)
			{
				//System.out.println(Line);
				combined_content += Line +"\n";
			}
			fr.close();
			bfr.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	private void Output()
	{		
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output_folder + output_file), "utf-8"));
			writer.write(combined_content);
			writer.close();
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		File_Combination FC = new File_Combination();
	}
	
}
