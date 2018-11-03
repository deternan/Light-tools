package File;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Read_text_UTF8 
{
	private String folder = "";
	private String file = "";
	
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
