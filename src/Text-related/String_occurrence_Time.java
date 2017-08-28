package Text_related;

/*
 *  The number of occurrences 
 * 
 *	Version: August 28, 2017 09:05 AM
 * 	Last revision: August 28, 2017 09:05 AM
 * 
 * 	Author : Chao-Hsuan Ke
 *  Institute: Delta Research Center
 *  Company : Delta Electronics Inc. (Taiwan)
 * 
 */


public class String_occurrence_Time
{
	private String sentence = "黃河之水來自海海上海海人生";
	private String str_ = "海海";
	private int count = 0;
	
	public String_occurrence_Time()
	{		
		int start = 0;
		
		while (sentence.indexOf(str_, start) >= 0 && start < sentence.length()) 
		{
			count++;
			start = sentence.indexOf(str_, start) + str_.length();
		}
		
		System.out.println("Occurrence times: " + count);
	}
	
	public static void main(String args[])
	{
		String_occurrence_Time sot = new String_occurrence_Time();
	}
	
}
