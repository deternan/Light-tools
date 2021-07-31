/*
 * version: August 25, 2018 04:53 PM
 * Last revision: May 07, 2019 10:28 AM
 * 
 * Author : Chao-Hsuan Ke
 * 
 */

package Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class Delete_files 
{

	private String folder_source = "D:\\Eclipse\\SL4SM\\data\\Index\\";	
	
	public Delete_files()
	{
		Delete_files_1();
		//Delete_files_2();
	}
	
	private void Delete_files_1()
	{
		File folder = new File(folder_source);
		File[] listOfFiles = folder.listFiles();
		Arrays.sort(listOfFiles);
		
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
	
	private void Delete_files_2() throws Exception
	{
		File folder = new File(folder_source);
		File[] listOfFiles = folder.listFiles();
		
		for (File file : listOfFiles)
		{
			if (file.isFile()) {
				File f1 = new File(folder_source + file.getName());
				System.out.println(f1);
				RandomAccessFile raf=new RandomAccessFile(f1,"rw");
				raf.close();
				f1.delete();
			}
			
		}
	}
	
	public static void main(String[] args)
	{
		Delete_files df = new Delete_files();
	}
	
}
