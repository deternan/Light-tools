package Files;

/*
 * get file extension name
 * 
 * version: May 04, 2019 05:30 PM
 * Last revision: May 06, 2019 00:40 PM
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
		        		        
		        String Getextension = getFileExtension(new File(folder_source + file.getName()));
		        String extension = Getextension.substring(1, Getextension.length());
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
