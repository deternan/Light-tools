package File;

/*
 * get file extension name
 * 
 * version: May 04, 2019 05:30 PM
 * Last revision: May 04, 2019 05:30 PM
 * 
 * Author : Chao-Hsuan Ke
 * 
 */

import java.io.BufferedReader;
import java.io.File;

public class ExtensionCheck {
	
	private String folder_source = "/Users/phelps/temp/";
	private BufferedReader bfr;
	
	public ExtensionCheck()
	{
		File folder = new File(folder_source);
		File[] listOfFiles = folder.listFiles();
		
		for (File file : listOfFiles) {
		    if (file.isFile()) {
		        System.out.println(file.getName());
		        		        
		        String extension = getFileExtension(new File(folder_source + file.getName()));
		        System.out.println("File Extension : " + extension.substring(1, extension.length()));
		        
		    }
		}
		
		
		
	}
	
	private static String getFileExtension(File file) {
        String extension = "";
 
        try {
            if (file != null && file.exists()) {
                String name = file.getName();
                extension = name.substring(name.lastIndexOf("."));
            }
        } catch (Exception e) {
            extension = "";
        }
 
        return extension;
 
    }

	public static void main(String args[])
	{
		ExtensionCheck ec = new ExtensionCheck();
	}
	
}
