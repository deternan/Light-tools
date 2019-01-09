package Text_related.subtitle;

/*
 * version: January 08, 2019 01:54 PM
 * Last revision: January 08, 2019 01:54 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;

public class subtitle_parser 
{
	// Read file
	private String folder = "";
	private String filename = "";
	private BufferedReader br = null;
	// Write file
	private String output_folder = "";
	private String output_file = filename+".output";		
	private BufferedWriter writer = null;
	
	public subtitle_parser() throws Exception
	{
		String line = "";
		boolean check;
		
		// Read file
		br = new BufferedReader(new FileReader(folder + filename));
		// Output file
		writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output_folder + output_file), "utf-8"));
		
		while ((line = br.readLine()) != null) 
        {			            			
			check = CJKV_check(line);
			if(check == true) {				
				writer.write(line+"\n");
			}			
        }
		writer.close();		
	}
	
	private boolean CJKV_check(String input_str)
	{
		boolean check;
		check = input_str.codePoints().anyMatch(codepoint ->
	            Character.UnicodeScript.of(codepoint) == Character.UnicodeScript.HAN);
		
		return check;
	}
	
	public static void main(String[] args)
	{
		try {
			subtitle_parser sp = new subtitle_parser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
