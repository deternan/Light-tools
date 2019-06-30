package Files;

import java.io.FileWriter;

/*
 * Continued output file (data will be written at the end of file)
 * 
 * version: August 14, 2017 11:27 AM
 * Last revision: August 14, 2017 11:27 AM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

public class Continue_Write 
{
	// Write output
	private String output_folder = "";
	private String output_file = "";	

	public Continue_Write() throws Exception
	{
		String sMsg = "DEF";
		
		FileWriter fw = new FileWriter(output_folder + output_file, true);
        fw.write("\n"+sMsg);
        fw.close();
	}
	
	public static void main(String args[])
	{
		try {
			Continue_Write CW = new Continue_Write();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
