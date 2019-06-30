package File;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.LinkedHashSet;
import java.util.Vector;

/*
 * Translate data to arff
 * 
 * version: November 08, 2017 11:53 AM
 * Last revision: November 08, 2017 03:00 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

public class Arff_translation 
{
	// Source
	private String data_folder = "C:\\Users\\Barry.Ke\\Desktop\\eTube sub\\vector\\";
	private String data_filename = "subtitle_vector.vec";
	private BufferedReader bfr;
	String line_one = "";
	private Vector class_tag = new Vector();
	private Vector content = new Vector();
	// output 
		// Arff annotation
		private String arff_annotation = "";
		private int dim_num;
	private String output_folder = data_folder;
	private String output_file = "subtitle_vector.vec.arff";	
		
	public Arff_translation()
	{		
		// Remove extension name
		String filename = RemoveExtensionName(data_filename);		
		// Read content
		Read_content();
			// Dimension
			Read_dim(line_one);
			// Remove duplicated class
			RemoveDuplicates_Hash_vector();
		// Generate new content	
		Generated_(filename);
		// Output
		Output_arff();
		//System.out.println(arff_annotation);
	}
	
	private void Read_content()
	{	
		// Dimension
			int index_ = 0;
			String Line = "";
			FileReader fr;
			try {
				fr = new FileReader(data_folder + data_filename);
				bfr = new BufferedReader(fr);
				
				while((Line = bfr.readLine())!=null)
				{
					if(index_ == 0){
						line_one = Line;						
					}
					content.add(Line);
					Readclass(Line);
					index_++;
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
	
	private String RemoveExtensionName(String input)
	{
		String filename = input.toString().replaceFirst("[.][^.]+$", "");
		
		return filename;
	}
	
	private void Read_dim(String input_content)
	{
		String temp[];
		temp = input_content.split(",");
		dim_num = temp.length - 1;
		//System.out.println(dim_num);
	}
	
	private void Readclass(String input_content)
	{
		// class_tag
		String temp[];
		temp = input_content.split(",");
		String tag_temp = temp[temp.length-1];
		//System.out.println(tag_temp);
		class_tag.add(tag_temp);
	}
	
	private void RemoveDuplicates_Hash_vector()
	{		
		class_tag = new Vector(new LinkedHashSet(class_tag));			
	}
	
	private void Generated_(String filename)
	{
		arff_annotation += "@RELATION " + filename + "\n";
		// Dimension
		for(int i=0; i<dim_num; i++)
		{
			arff_annotation += "@ATTRIBUTE " + i + "\t" + "REAL" + "\n";
		}
		arff_annotation += "@ATTRIBUTE class" + "\t" + "{";
		String class_tag_str = "";
		for(int i=0; i<class_tag.size(); i++)
		{
			class_tag_str += class_tag.get(i)+","; 
		}
		class_tag_str = class_tag_str.substring(0, class_tag_str.length()-1);		
		arff_annotation += class_tag_str +"}" + "\n"; 
		// Data
		arff_annotation += "@DATA" + "\n";
		for(int i=0; i<content.size(); i++)
		{
			arff_annotation += content.get(i) + "\n";
		}		
	}
	
	private void Output_arff()
	{
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output_folder + output_file), "utf-8"));
			writer.write(arff_annotation);
			writer.close();
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[])
	{
		Arff_translation arff_tra = new Arff_translation();
	}
	
}
