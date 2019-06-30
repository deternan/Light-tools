package File;

/*
 * Read folder list
 * 
 * version: June 06, 2017 11:30 AM
 * Last revision: September, 2018 11:34 AM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import java.io.BufferedReader;
import java.io.FileReader;

public class Read_text 
{
	private String folder = "";
	private String file = "";
	
	private BufferedReader bfr;	
	
	public Read_text() throws Exception
	{
		String Line = "";
		FileReader fr = new FileReader(folder + file);
		bfr = new BufferedReader(fr);
				
		while((Line = bfr.readLine())!=null)
		{					
			System.out.println(Line);			
		}
		fr.close();
		bfr.close();
	}
	
	public static void main(String[] args)
	{
		try {
			Read_text rt = new Read_text();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
