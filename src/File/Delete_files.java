package File;

/*
 * version: August 25, 2018 04:53 PM
 * Last revision: August 25, 2018 04:53 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import java.io.File;

public class Delete_files 
{

	private String folder_source = "D:\\Eclipse\\SL4SM\\data\\Index\\";	
	
	public Delete_files()
	{
		File folder = new File(folder_source);
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
		    if (file.isFile()) {
		        System.out.println(file.getName());
		    	
		        File deletefile = new File(folder_source + file.getName());
		        
		        if(deletefile.delete()){
		            System.out.println("File deleted successfully");
		        }else{
		            System.out.println("Failed to delete the file");
		        }
		    }
		}

	}
	
	public static void main(String[] args)
	{
		Delete_files df = new Delete_files();
	}
	
}
