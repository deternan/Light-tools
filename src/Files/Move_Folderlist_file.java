package Files;

/*
 * Read folder list
 * 
 * version: October 25, 2019 11:11 AM
 * Last revision: October 25, 2019 11:11 AM
 * 
 * 
 */

import java.io.File;
import java.util.Arrays;

public class Move_Folderlist_file 
{
	String dirPath = "C:\\Users\\barry.ke\\Desktop\\etubeSL4SM\\all\\";	
	String tarrgetFolder = "C:\\Users\\barry.ke\\Desktop\\etubeSL4SM\\file\\";
	private String command_str;
	
	public Move_Folderlist_file()
	{
		// Read Folder
		File dir = new File(dirPath);
		String[] files = dir.list();
		if (files.length == 0) {
		    System.out.println("The directory is empty");
		} else {
		    for (String folername : files) {		        
		    	//System.out.println(folername);
		    	
		    	// Read filelist in folder
		    	Read_folderfiles(dirPath, folername);
		    }
		}
	}
	
	private void Read_folderfiles(String Rootfolder, String foldername)
	{
		File folder = new File(Rootfolder + foldername + "\\");
		File[] listOfFiles = folder.listFiles();
		Arrays.sort(listOfFiles);
		
		for (File file : listOfFiles) {
		    if (file.isFile()) {
		        //System.out.println("filename	"+file.getName());
		        Move_files(Rootfolder + foldername + "\\"+ file.getName());
		    }
		}
	}
	
	private void Move_files(String sourceFolderFile)
	{
		command_str = "cp " + sourceFolderFile + "* "+ tarrgetFolder;
		System.out.println(command_str);
		Process proc = null;
		try {
			proc = Runtime.getRuntime().exec(new String[] { "/bin/sh"//$NON-NLS-1$
					, "-c", command_str });//$NON-NLS-1$
			if (proc != null) {
				proc.waitFor();
			}
		} catch (Exception e) {
			// Handle
			return;
		}
	}
	
	public static void main(String args[])
	{
		Move_Folderlist_file mflf = new Move_Folderlist_file();
	}
	
}
