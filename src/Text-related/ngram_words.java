package Text_related;


import java.util.LinkedHashSet;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 
 * version: August 23, 2017 09:06 AM
 * Last revision: August 23, 2017 09:06 AM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

public class ngram_words 
{
	private int n_num = 5;
	
	// English filter
	private Pattern target;
	private Matcher matcher;
	private Vector Eng_vec = new Vector();
	
	// Chinese filter
	private String input_sentence = "LINE 從 2016 年 4 月 7 日開始提供免費「LINE BOT API 試用」帳號 (LINE BOT API Trial Account) 申請，讓任何人都可以在 LINE 的平台上開發聊天機器人的多元應用";
	private Vector Chinese_vec = new Vector();
	
	// n-gram
	private Vector ngram_chinese = new Vector();
	private Vector ngram_english = new Vector();
	
	public ngram_words()
	{
		// English filter
		English_filter();
		
		// Chinese filter
		Chinese_filter();
		
		// n-gram
		ngram(Chinese_vec);
	}
	
	private void English_filter()
	{
		target = Pattern.compile("[a-zA-Z]+", Pattern.CASE_INSENSITIVE);		
		
		matcher = target.matcher(input_sentence);
		while(matcher.find())
		{
			//System.out.println(matcher.group());
			Eng_vec.add(matcher.group().toString().trim());
		}
		//System.out.println(Eng_vec.size());
		// Remove duplication
		Eng_vec = RemoveDuplicates_vector(Eng_vec);
		
		// for(int i=0; i<Eng_vec.size(); i++)
		// {
		// 	System.out.println(Chinese_vec.get(i));
		// }
	}
	
	private void Chinese_filter()
	{
		for(int i=0; i<input_sentence.length();i++)
		{  
		    String test = input_sentence.substring(i, i+1);  
		    if(test.matches("[\\u4E00-\\u9FA5]+")){  
		        //System.out.printf("\t[Info] %s -> 中文!\n", test);
		    	//sentence += test;
		    	Chinese_vec.add(test);
		    }  
		}
//		System.out.println(Chinese_vec.size());
//		for(int i=0; i<Chinese_vec.size(); i++)
//		{
//			System.out.println(Chinese_vec.get(i));
//		}
		
	}
	
	private Vector RemoveDuplicates_vector(Vector input_vec)
	{
		Vector newVect = new Vector(new LinkedHashSet(input_vec));
		
		return newVect;
	}
	
	private void ngram(Vector input_vec)
	{
		String str_temp = "";
		for(int i=0; i<=input_vec.size() - n_num; i++)
		{
			String ngram_temp = input_vec.get(i).toString();
			for(int j=1; j<n_num; j++)
			{
				ngram_temp += input_vec.get(i+j).toString();
				//str_temp += input_vec.get(i)
			}
			System.out.println(ngram_temp);
			//str_temp = input_vec.get(i).toString()
		}
	}
	
	public static void main(String args[]) 
	{
		ngram_words ngram = new ngram_words();
	}
	
}
