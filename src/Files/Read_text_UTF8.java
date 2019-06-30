package File;

/*
 * Read folder list
 * 
 * version: September, 2018 11:34 AM
 * Last revision: November 03, 2018 12:13 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Read_text_UTF8 
{
	private String folder = "C:\\Users\\Barry.Ke\\Desktop\\";
	private String file = "output.txt";
	
	private BufferedReader bfr;	
	
	public Read_text_UTF8() throws Exception
	{
		String Line = "";
		
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(folder + file), "UTF8"));
		
		while ((Line = in.readLine()) != null) {
		    System.out.println(Line);
		}
		
		in.close();

	}
	
	public static void main(String[] args)
	{
		try {
			Read_text_UTF8 rt = new Read_text_UTF8();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
