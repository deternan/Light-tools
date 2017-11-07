package Text_related;

/*
 * Terms frequency
 * 
 * version: November 07, 2017 03:19 PM
 * Last revision: November 07, 2017 03:19 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Term_Frequency 
{

	public Term_Frequency()
	{
		String findText = "Trump";	
		String term = "It just after 6 a.m. local time in Japan. President Trump is leaving the country today for South Korea and sent this tweet. Trump is wrapping up his second (and last) day in Japan, the first country on his five-nation tour of Asia.";
		
		int count = 0;
	    Pattern p = Pattern.compile(findText);
	    Matcher m = p.matcher(term);
	    while (m.find()) {
	        count++;
	    }
	    System.out.println(count);
	}
	
	public static void main(String args[])
	{
		Term_Frequency tf = new Term_Frequency();
	}
	
}
