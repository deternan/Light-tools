package File;

/*
 * Version: 
 * decompression file  
 * 
 * 
 * Version: June 07, 2016	02:19 PM
 * Last revision: June 07, 2016	02:19 PM 
 *  
 */

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;

/**
 * @param decompress tar (document)files and combined to one file
 */
public class Unzip_edx_Tar 
{
	// File
		// Input
		private String source_filder;	
		private String output_folder;
		private String output_file;
		private String output_path;	
	
		// Output
		private OutputStream out;

	
	public Unzip_edx_Tar(String source_filder, String output_folder, String output_file) throws IOException
	{
		this.source_filder = source_filder;
		this.output_folder = output_folder;
		this.output_file = output_file;
		output_path = this.output_folder + this.output_file;
		
		Read_Folder();
	}
	
	private void Read_Folder() throws IOException
	{
		// Read
		File folder = new File(this.source_filder);
		File[] listOfFiles = folder.listFiles();
		// Output
		// Open the output file
	    String target = output_folder + output_file;
	    out = new FileOutputStream(target);
		
		for (int i = 0; i < listOfFiles.length; i++) 
		{
			  if (listOfFiles[i].isFile()) {
		        //System.out.println("File " + listOfFiles[i].getName());
 
				decompress(this.source_filder + listOfFiles[i].getName());
				//System.out.println(listOfFiles[i].getName());
				
		      } else if (listOfFiles[i].isDirectory()) {
		        //System.out.println("Directory " + listOfFiles[i].getName());
		      }
		}
		
		out.close();
	}
	
	private void decompress(String source) throws IOException
	{				
	     GZIPInputStream in = new GZIPInputStream(new FileInputStream(source));
	     
	  // Transfer bytes from the compressed file to the output file
	     byte[] buf = new byte[1024];
	     int len;
	     while ((len = in.read(buf)) > 0) 
	     {	         
	    	 out.write(buf, 0, len);
	    	 //System.out.println(in);
	     }	     
	}
	
	public static void main(String args[])
	{
		String source_filder = args[0];
		String output_folder = args[1];
		String output_file = args[2];
		
		try {
			Unzip_edx_Tar unedxtar = new Unzip_edx_Tar(source_filder, output_folder, output_file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
