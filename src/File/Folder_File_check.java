package File;

import java.io.File;

/*
 * Folder & File check
 * 
 * version: December 19, 2017 11:48 AM
 * Last revision: December 19, 2017 11:48 AM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

public class Folder_File_check 
{
	private String folder_str = "";
	
	public Folder_File_check()
	{
		File a = new File(folder_str);

		String[] filenames;
		String fullpath = a.getAbsolutePath();

		if (a.isDirectory()) {
			filenames = a.list();
			for (int i = 0; i < filenames.length; i++) {
				File tempFile = new File(fullpath + "\\" + filenames[i]);
				if (tempFile.isDirectory()) {
					System.out.println("Folder:" + filenames[i]);
				} else{
					System.out.println("File:" + filenames[i]);
				}					
			}
		} else{
			System.out.println("[" + a + "] not folder");
		}			
	}
	
	public static void main(String args[])
	{
		Folder_File_check f_check = new Folder_File_check();
	}
	
}
