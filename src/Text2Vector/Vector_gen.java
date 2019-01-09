package Text2Vector;

/*
 * Vector generation
 * 
 * version: November 07, 2017 10:06 AM
 * Last revision: November 08, 2017 09:35 AM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vector_gen extends Parameters
{
	private BufferedReader bfr;	
	// All Terms
	Vector alltemp_vec = new Vector();	
	private int vecspace[];
	private String all_sentences;
	// Pattern recognition
	Pattern p;
	Matcher m;
	// Encoding
	private String Class_Tag;
	// Output
	BufferedWriter writer;
	
	public Vector_gen() throws Exception
	{
		// otuput initilal			
		writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output_vec_folder + output_vec_filename + extension_str), "utf-8"));					
		//
		
		// Read All Terms
		Read_AllTerms();			
		vecspace = new int[alltemp_vec.size()];
		// Read Raw Text (content)
		Read_folder_file();
		
		// output close		
		writer.close();
	}
	
	private void Read_AllTerms()
	{
		String Line = "";
		FileReader fr;
		try {
			fr = new FileReader(output_folder + output_file);
			bfr = new BufferedReader(fr);
			
			while((Line = bfr.readLine())!=null)
			{			
				alltemp_vec.add(Line);
				//System.out.println(Line);
			}
			
			fr.close();
			bfr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	private void Read_folder_file() throws Exception
	{		
		File dir = new File(sub_folder);
		String[] files = dir.list();
		if (files.length == 0) {
		    System.out.println("The directory is empty");
		} else {
			// Read folder
		    for (String folername : files) 
		    {
		        System.out.println(folername);
		        //System.out.println("-------------------------------");
		    	File folder = new File(sub_folder + folername);
		    	File[] listOfFiles = folder.listFiles();
		    	for (File file : listOfFiles) 
		    	{			
					if (file.isFile()) {
						all_sentences = "";
						vecspace.clone();
						//System.out.println(folder_source + folername + separation + file.getName());						
						all_sentences = Read_Text(sub_folder + folername + separation + file.getName());
							//System.out.println(all_sentences.length()+"	"+file.getName());
						// Class Tag
						Class_Tag = Class_Tag(folername);
						//System.out.println(Class_Tag);
						// text to space
						vecspace = Text_to_Space(all_sentences);
						// Output (separation)
//						Output_vector_separation(folername, file.getName(), vecspace, Class_Tag);
						// Output (All)
						Output_vector(vecspace, Class_Tag);
					}
		    	}
		    }
		}		
	}
	
	private String Read_Text(String folder_file)
	{
		//System.out.println(folder_file);
		String input_str = "";
		String Line = "";
		FileReader fr;
		try {
			fr = new FileReader(folder_file);
			bfr = new BufferedReader(fr);
			
			while((Line = bfr.readLine())!=null)
			{				
				input_str += Line.trim()+"，"; 
			}			
			fr.close();
			bfr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return input_str;
	}
	
	private int[] Text_to_Space(String input_txt)
	{
		//vecspace.clone();
		int vecspace_temp[] = new int[alltemp_vec.size()];
		
		int count = 0;
		for(int i=0; i<alltemp_vec.size(); i++)
		{
			count = 0;
			p = Pattern.compile(alltemp_vec.get(i).toString().trim());
			m = p.matcher(input_txt);
		    while (m.find()) {
		        count++;
		    }
		    vecspace_temp[i] = count;
		    //System.out.print(vecspace_temp[i]+",");
		}
	    //System.out.println();
		//System.out.println(vecspace.length);
		
		return vecspace_temp;
	}
	
	private String Class_Tag(String folder_name)
	{
		String Tag = "";
		int start_;
		int end_;
		if((folder_name.contains("(")) && (folder_name.contains(")"))){
			start_ = folder_name.lastIndexOf("(");
			end_ = folder_name.lastIndexOf(")");
			Tag = folder_name.substring(start_+1, end_);
			
			return Tag;
		}else{
			System.out.println("No class Tag");
			
			return Tag;
		}		
	}
	
	private void Output_vector_separation(String foldername, String filename, int[] vecspace, String class_Tag)
	{
		//System.out.println(filename);
		String output_vec_file = RemoveExtensionName(filename);
		System.out.println(output_vec_file);
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output_vec_folder + foldername + separation + output_vec_file + extension_str), "utf-8"));			
			for(int i=0; i<vecspace.length; i++)
			{
				writer.write(vecspace[i]+",");
			}
			writer.write(class_Tag+"\n");
			writer.close();
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void Output_vector(int[] vecspace, String class_Tag)
	{		
		try {
			for(int i=0; i<vecspace.length; i++)
			{
				writer.write(vecspace[i] + ",");
			}
			writer.write(class_Tag+"\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	private String RemoveExtensionName(String input)
	{
		String filename = input.toString().replaceFirst("[.][^.]+$", "");
		
		return filename;
	}
	
}
