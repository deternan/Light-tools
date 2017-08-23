package File;

/*
 * 
 * version: August 23, 2017 06:02 PM
 * Last revision: August 23, 2017 06:02 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import java.io.File;

public class Read_folderfiles 
{
	private String folder_source = "";
	
	public Read_folderfiles()
	{
		File folder = new File(folder_source);
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
		    if (file.isFile()) {
		        System.out.println(file.getName());
		    }
		}
	}
	
	public static void main(String args[]) 
	{
		Read_folderfiles folderfiles = new Read_folderfiles();
	}
	
}
