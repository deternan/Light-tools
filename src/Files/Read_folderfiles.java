package Files;

/*
 * 
 * version: August 23, 2017 06:02 PM
 * Last revision: May 07, 2019 10:27 AM
 * 
 * Author : Chao-Hsuan Ke
 * 
 */

import java.io.File;
import java.util.Arrays;

public class Read_folderfiles 
{
	private String folder_source = "C:\\Users\\Barry.Ke\\Desktop\\wikitext\\chinese\\";
	
	public Read_folderfiles()
	{
		File folder = new File(folder_source);
		File[] listOfFiles = folder.listFiles();
		Arrays.sort(listOfFiles);
		
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
