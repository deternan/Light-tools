/*
 * Segmentation by Jieba & Remove stopwords
 * 
 * version: November 06, 2017 02:12 PM
 * Last revision: November 06, 2017 05:16 PM
 * 
 * Author : Chao-Hsuan Ke
 * 
 */

package Application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.ansj.splitWord.analysis.ToAnalysis;

import Application.jieba.JiebaSegmenter;
import Application.jieba.JiebaSegmenter.SegMode;
import TF_IDF.Parameters;


public class Jieba_segmentation extends Parameters
{
	private String input_ = "";
	
	private BufferedReader bfr;	
	private String input_str = "";
	
	// Stop Words
	private String folder = "";
	private String file = "stopwords.txt";
	private Vector stopwords = new Vector();
	// Jieba
	JiebaSegmenter segmenter = new JiebaSegmenter();
	Vector alltemp_vec = new Vector();
	//Vector 
	
	public Jieba_segmentation() throws Exception
	{
		// Read stopwords
		Read_stopwords();
		
		// Segmentation
		Segmentation_Jieba(input_);
		System.out.println(alltemp_vec.size());
		// Read Text
//		Read_folder_file();			
		
	}
		
	private void Read_folder_file() throws Exception
	{
		
		
		
//		File folder = new File(folder_source);
//		File[] listOfFiles = folder.listFiles();		
//		
//		for (File file : listOfFiles) 
//		{			
//			if (file.isFile()) {				
//				input_str = "";
//				//temp_vec.clear();
//		    	//filename.add(file.getName());	
//				System.out.println(folder_source + file.getName());
//		    	Read_Text(folder_source + file.getName());
//		    	//System.out.println(input_str);
//		    	
//		    	// Segmentation
//		    	Segmentation_Jieba(input_str);
//		    	//System.out.println(alltemp_vec.size());
//		    }
//		}		
	}
	
	private void Read_Text(String folder_file)
	{		
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
		
		
	}
	
	// Segment words 
	private void Segmentation_Jieba(String input) throws Exception 
	{	
		//System.out.println(input);		
		System.out.println(segmenter.process(input, SegMode.INDEX).size()+"	"+segmenter.process(input, SegMode.INDEX));
		
		String str_;
		for(int i=0; i<segmenter.process(input, SegMode.INDEX).size(); i++)
		{			
			str_ = parser_array(segmenter.process(input_, SegMode.INDEX).get(i).toString());
			
			if(str_.length() >1)
			{
				System.out.println(str_);
				alltemp_vec.add(str_);
			}			
		}
	}
	
	private String parser_array(String input_array)
	{
		//int e_index = input_array.indexOf(",");
		String str_;		
		str_ = input_array.substring(1, input_array.indexOf(","));
		str_ = Stopword_filter(str_);
		
		return str_.trim();
	}
	
	private String Stopword_filter(String input)
	{
		boolean stopword_check = false;
		for(int i=0; i<stopwords.size(); i++)
		{
			if(input.trim().equalsIgnoreCase(stopwords.get(i).toString().trim())){
				stopword_check = true; 
				break;
			}
		}
		
		if(stopword_check == false){
			return input;
		}else{
			return "";
		}
	}
	
	private void Read_stopwords() throws Exception
	{
		String Line = "";
		FileReader fr = new FileReader(folder + file);
		bfr = new BufferedReader(fr);
		
		while((Line = bfr.readLine())!=null)
		{			
			stopwords.add(Line);
			//System.out.println(Line);
		}
		fr.close();
		bfr.close();
	}
	
	public static void main(String args[])
	{
		try {
			Jieba_segmentation t2v = new Jieba_segmentation();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
