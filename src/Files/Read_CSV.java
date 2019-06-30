package Files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * 
 * version: September 22, 2017 01:07 PM
 * Last revision: September 22, 2017 01:07 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

public class Read_CSV 
{
	private String folder = "";
	private String filename = "";
	private BufferedReader br = null;
    
    String cvsSplitBy = ",";
	
	
	public Read_CSV()
	{
		String line = "";
		
		try {
			br = new BufferedReader(new FileReader(folder + filename));
			
			while ((line = br.readLine()) != null) 
	        {
				// use comma as separator
                String[] str_ = line.split(cvsSplitBy);
                System.out.println(str_[0]);
	        }
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	public static void main(String args[])
	{
		Read_CSV r_csv = new Read_CSV();
	}
	
}
