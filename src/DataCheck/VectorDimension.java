package DataCheck;

/*
 * check data dimension
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

public class VectorDimension 
{
	private String folder = "";
	private String file = "";	
	private BufferedReader bfr;	
	
	public VectorDimension() throws Exception
	{
		
		String Line = "";
		FileReader fr = new FileReader(folder + file);
		bfr = new BufferedReader(fr);
		
		String temp[];
		String dim_temp[];
		while((Line = bfr.readLine())!=null)
		{					
			temp = Line.split("\t");
			
			dim_temp = temp[3].split(",");
			System.out.println(dim_temp.length);
		}
		fr.close();
		bfr.close();		
	}
	
	public static void main(String[] args)
	{
		try {
			VectorDimension vec = new VectorDimension();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
