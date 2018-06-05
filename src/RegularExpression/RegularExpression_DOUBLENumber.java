package RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 
 * version: June 01, 2018 05:54 PM
 * Last revision: June 05, 2018 07:27 PM
 * 
 * Author : Chao-Hsuan Ke
 * 
 */

public class RegularExpression_DOUBLENumber 
{
	String regex = "([0-9]+\\.?[0-9]+)";
	Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
	
	public RegularExpression_DOUBLENumber()
	{		
		String data = "12.45aa69.7";
		
		// Parsing
		Matcher matcher = pattern.matcher(data);        
        while(matcher.find())
        {
        	System.out.println(matcher.group());
        }
	}
	
	public static void main (String args[])
	{
		RegularExpression_DOUBLENumber RE_num = new RegularExpression_DOUBLENumber();
	}
	
}
