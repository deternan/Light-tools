
/*
 *  Filter Chinese Words
 * 
 *	Version: October 05, 2016	10:51 AM
 * 	Last revision: December 12, 2019 02:48 PM
 * 
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ChineseWord_Filters
{
	private BufferedReader bfr;
	private StringBuffer sb = new StringBuffer();	
	// (Individual) Course terms
	private Vector Course_Terms;
	String TP = "假設我們給 RNN 餵進一個長度 N 的序列 x1, x2, ..., xn，RNN 會吐出與長度等長的序列 y1, y2, ..., yn";	
	
	// Limitation
	private int min_string_length = 2;
	
	// Regression
	String regEx="[a-zA-Z//./////+//#]+";
	Pattern pattern;
	Matcher match;
	
	public ChineseWord_Filters() throws Exception
	{
		Course_Terms = new Vector();
		
		pattern = Pattern.compile(regEx);				
		Word_Parser();
		
		for(int i=0;i<Course_Terms.size();i++)
		{
			System.out.println(Course_Terms.get(i));
		}
	}
	
	private void Sentence_Combination(String path) throws Exception
	{
		String Line = "";
		FileReader fr = new FileReader(path);
		bfr = new BufferedReader(fr);
		
		while((Line = bfr.readLine())!=null)
		{
			sb.append(Line+"\n");
		}
		fr.close();
		bfr.close();
	}
	
	private void Word_Parser()
	{
		String words[];			// Course_Terms_All
		String temp = "";		
		words = TP.replaceAll("\n"," ").split(" ");
		
		for(int i=0; i<words.length; i++)
		{									
			match = pattern.matcher(words[i]);
				
			if(match.matches())
			{
				temp = Remove_mark(match.group());								
				if(temp!=null && (temp.length() >= min_string_length)){											
					Course_Terms.add(temp);
				}
			}			
		}		
	}
	
	private String Remove_mark(String key)
	{		
		if(key.substring(key.length()-1, key.length()).equalsIgnoreCase("."))
		{
			key = key.substring(0, key.length()-1);
		}
		
		return key;
	}
	
	public static void main (String args[]) 
	{
		try {
			ChineseWord_Filters CFs = new ChineseWord_Filters();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
