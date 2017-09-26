package File;

/*
 * Version: 
 * Uncompression edx log file (.gz) 
 * 
 * 
 * Version: June 16, 2016	02:19 PM
 * Last revision: September 26, 2017	09:21 AM 
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.zip.GZIPInputStream;

public class Unzip_Tar
{
	private String decompre_Folder;
	private String decompre_file;
	private String Gz_Save_Path;
	// File				
	// Output
	private OutputStream decompre_output;
	// Combination
	private BufferedReader br = null;
	// Write file
	private FileOutputStream fileOutputStream;
	private OutputStreamWriter outputStreamWriter;
	
	public Unzip_Tar() throws Exception
	{
		// Decompression
		Decompression();
		
	}
	
	private void Decompression() throws IOException
	{
		// Read
		File folder = new File(Gz_Save_Path);
		File[] listOfFiles = folder.listFiles();
		
		Arrays.sort(listOfFiles);
		
		// Output
		// Open the output file
	    String target = decompre_Folder + decompre_file;	    
	    decompre_output = new FileOutputStream(target);
		
		for (int i = 0; i < listOfFiles.length; i++) 
		{			 
			if (listOfFiles[i].isFile()) {
		        //System.out.println("File " + listOfFiles[i].getName());
 
				if(listOfFiles[i].getName().contains(".gz")){
					decompress(Gz_Save_Path  + listOfFiles[i].getName());
					//System.out.println(listOfFiles[i].getName());
				}				
				
		      } else if (listOfFiles[i].isDirectory()) {
		        //System.out.println("Directory " + listOfFiles[i].getName());
		      }
		}
		
		decompre_output.close();
	}
	
	private void decompress(String source) throws IOException
	{				
	     GZIPInputStream in = new GZIPInputStream(new FileInputStream(source));
	     
	     // Transfer bytes from the compressed file to the output file
	     byte[] buf = new byte[1024];
	     int len;
	     while ((len = in.read(buf)) > 0)
	     {	         
	    	 decompre_output.write(buf, 0, len);	    	 
	     }
	}
	
}

