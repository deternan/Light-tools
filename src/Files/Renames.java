package Files;

/*
 * files rename
 * version: July 02, 2019 11:15 PM
 * Last revision: July 02, 2019 11:15 PM
 * 
 * Author : Chao-Hsuan Ke
 * 
 */

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;

public class Renames
{
	private String sourceFolder = "/data/git/DataSet/ptt/Stock data/aa/";
	
	public Renames()
	{
		File folder = new File(sourceFolder);
		File[] listOfFiles = folder.listFiles();		
		// Sort filenames
		Arrays.sort(listOfFiles);
		
		String oldfilename;
		int index = 1;
		String indexStr;	int tmp;
		String fullStr;
		
		for (File file : listOfFiles) {
		    if (file.isFile()) {
		    	oldfilename = file.getName();
		        //System.out.println(file.getName());
		    	indexStr = String.valueOf(index);
		    	fullStr = "";
		    	tmp = 4 - indexStr.length();
		    	for(int i=0; i<tmp; i++) {
		    		fullStr += "0";
		    	}
		    	fullStr += indexStr;
		    	fullStr = "Stock_"+fullStr+".json";
		    	//System.out.println(fullStr);
		    	
		    	// Rename
		    	String newFilePath = file.getAbsolutePath().replace(file.getName(), "") + fullStr;
		    	  File newFile = new File(newFilePath);

		    	  try {
		    	    FileUtils.moveFile(file, newFile);
		    	  } catch (IOException e) {
		    	    e.printStackTrace();
		    	  }
		    	
		    	index++;
		    }
		}
	}
	
	public static void main(String args[])
	{
		Renames re = new Renames();
	}
	
}
