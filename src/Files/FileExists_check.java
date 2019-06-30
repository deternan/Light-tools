package Files;

/*
 * file exist check
 * 
 * version: June 30, 2019 10:30 PM
 * Last revision: June 30, 2019 10:30 PM
 * 
 * Author : Chao-Hsuan Ke
 * 
 */

import java.io.File;

public class FileExists_check {

	private String folderfile = "/Users/phelps/Desktop/2388.txt";
	
	public FileExists_check()
	{
		File file = new File("C:/java.txt");
		
	    System.out.println(file.exists());
	}
	
	public static void main(String args[])
	{
		FileExists_check fc = new FileExists_check();
	}
}
