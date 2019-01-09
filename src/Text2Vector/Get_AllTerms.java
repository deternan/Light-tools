package Text2Vector;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.LinkedHashSet;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.ansj.splitWord.analysis.ToAnalysis;

import Application.jieba.JiebaSegmenter;
import Application.jieba.JiebaSegmenter.SegMode;

/*
 * Text to Vector
 * 
 * version: November 06, 2017 02:12 PM
 * Last revision: November 06, 2017 05:14 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */


public class Get_AllTerms extends Parameters
{
	//private Vector filename = new Vector();
	//private Vector all_text;
	private BufferedReader bfr;	
	private String input_str = "";
	
	// Stop Words
	private Vector stopwords = new Vector();
	// Jieba
	JiebaSegmenter segmenter = new JiebaSegmenter();
	Vector alltemp_vec = new Vector();
	Vector newVect = new Vector();

	
	public Get_AllTerms() throws Exception
	{
		// Read stopwords
		Read_stopwords();		
		// Read Text (content)
		Read_folder_file();		
		// Segmentation (Jieba)
		// Remove duplication
		Remove_duplication();
		// output all Terms (non-duplication)
		Output_text();
		
		// Transfer to *.arff
	}
		
	private void Read_folder_file() throws Exception
	{
		File folder = new File(sub_folder);
		File[] listOfFiles = folder.listFiles();		
		
		for (File file : listOfFiles) 
		{			
			if (file.isFile()) {				
				input_str = "";
				//temp_vec.clear();
		    	//filename.add(file.getName());	
				System.out.println(sub_folder + file.getName());
		    	Read_Text(sub_folder + file.getName());
		    	//System.out.println(input_str);
		    	
		    	// Segmentation
		    	Segmentation_Jieba(input_str);
		    	//System.out.println(alltemp_vec.size());
		    }
		}		
	}
	
	private void Read_Text(String folder_file)
	{
		//System.out.println(folder_file);
		
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
		
		//System.out.println(segmenter.process(input_str, SegMode.INDEX).size()+"	"+segmenter.process(input_str, SegMode.INDEX));
		//System.out.println(segmenter.process(input_str, SegMode.INDEX).size()+"	"+segmenter.process(input_str, SegMode.INDEX).get(0));
		String str_;
		for(int i=0; i<segmenter.process(input_str, SegMode.INDEX).size(); i++)
		{
			
			str_ = parser_array(segmenter.process(input_str, SegMode.INDEX).get(i).toString());
			//System.out.println(i+"	"+str_);
			if(str_.length()>1){
				//System.out.println(i+"	"+str_);
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
	
	private void Remove_duplication()
	{
		newVect = new Vector(new LinkedHashSet(alltemp_vec));
		//System.out.println(newVect.size());
	}
	
	private void Output_text()
	{
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output_folder + output_file), "utf-8"));
			//writer.write("QQQ");
			for(int i=0;i<newVect.size();i++)
			{
				writer.write(newVect.get(i).toString()+"\n");
			}
			writer.close();
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public static void main(String args[])
//	{
//		try {
//			AllTerms t2v = new AllTerms();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
}
