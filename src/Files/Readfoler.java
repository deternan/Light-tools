package Files;

import java.io.File;

/*
 * Read folder list
 * 
 * version: October 20, 2017 01:41 PM
 * Last revision: October 20, 2017 01:41 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

public class Readfoler 
{
	private String dirPath = "";
	
	public Readfoler()
	{		
		File dir = new File(dirPath);
		String[] files = dir.list();
		if (files.length == 0) {
		    System.out.println("The directory is empty");
		} else {
		    for (String folername : files) {
		        System.out.println(folername);
		    }
		}
	}
	
	public static void main(String args[]) 
	{
		Readfoler r_folder = new Readfoler();
	}
	
}
