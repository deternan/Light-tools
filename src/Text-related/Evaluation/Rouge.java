package Evaluation;

import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 
 * version: October 13, 2017 04:41 PM
 * Last revision: October 13, 2017 04:41 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 */

public class Rouge 
{
	private String summary_str = "Turning the bathroom light on also turns the counter light on, meaning a middle, of, the, night trip to the bathroom means the whole side of the room gets illuminated and the wooden shutters that were installed in place of traditional curtains to add to the hotel's theme do absolutely nothing to keep the room dark once the sun comes up. Some rooms had the bathroom sink outside the bathroom, which we would have preferred, but our sink was inside the bathroom.";
	private String summary_gold = "The rooms were not large but were clean and very comfortable. The bathroom size varied but generally they were fully stocked. There were some isolated problems with maintenance issues.";
	
	private int ROUGE_N = 1;
	
	String pattern = "[a-zA-Z]+";
	Pattern p;
	Matcher m;
	
	public Rouge()
	{
		p = Pattern.compile(pattern);
		
		String[] temp;
		
		Vector summary_str_separate = new Vector();
		Vector summary_gold_separate = new Vector();		
		
		temp = summary_str.split("\\s");		
		//System.out.println(temp.length);
		
		// original text
		for(int i=0; i<temp.length; i++)
		{			 
		     m = p.matcher(temp[i]);
		     while (m.find()) 
		     {
		    	 //System.out.println(m.group()); 
		    	 summary_str_separate.add(m.group());
		     }		     
		}
		
		// gold text
		temp = null;
		temp = summary_gold.split("\\s");
		for(int i=0; i<temp.length; i++)
		{			 
		     m = p.matcher(temp[i]);
		     while (m.find()) 
		     {		
		    	 summary_gold_separate.add(m.group());
		     }		     
		}
		
		System.out.println(summary_str_separate.size());
		System.out.println(summary_gold_separate.size()+"	"+summary_gold);
		
		String ngram = "";
		String temp_str = "";
		for(int i=0; i<summary_gold_separate.size(); i++)
		{
			temp_str = "";
			if(i<summary_gold_separate.size() - ROUGE_N){
				for(int j=0; j<ROUGE_N; j++)
				{
					temp_str += summary_gold_separate.get(i+j);
				}
				ngram = summary_gold_separate.get(i) + " " + temp_str;
				System.out.println(ngram);
			}			
		}
		
	}
	
	public static void main(String args[]) 
	{
		Rouge rouge = new Rouge();
	}
	
}
