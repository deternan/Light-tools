package File;

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
 * File content combination
 * 
 * version: November 14, 2017 02:49 PM
 * Last revision: November 14, 2017 03:01 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

public class File_Combination 
{
	// folder source
	private String source_folder = "";
	private BufferedReader bfr;	
	// Content
	private String combined_content = "";
	// output
	private String output_folder = "";
	private String output_file = "*.output";		
	
	public File_Combination()
	{
		File folder = new File(source_folder);
		File[] listOfFiles = folder.listFiles();

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
