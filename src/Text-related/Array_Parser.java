package Text_related;

/*
 * Text Array parser 
 * 
 * version: October 09, 2018 01:30 PM
 * Last revision: October 09, 2018 01:30 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Array_Parser 
{
	private String input_array = "[\"data analytics\", \"industry 4.0\"]";
	
	// Regular expression	
	String regex = "\"[^\"]+\"";
	//String regex = "[^\"]+";
	private Pattern pattern;
	
	public Array_Parser()
	{		
		String text = input_array.substring(1, input_array.length()-1);
		//System.out.println(text);
		
		pattern = Pattern.compile(regex, Pattern.MULTILINE);
		Matcher matcher = pattern.matcher(text);
		
		String array_text;
		while (matcher.find()) 
		{			
			array_text = matcher.group().toString();
			
			System.out.println(array_text.substring(1, array_text.length()-1));
		}		
	}
	
	public static void main(String[] args) 
	{
		Array_Parser AP = new Array_Parser();
	}
	
}
