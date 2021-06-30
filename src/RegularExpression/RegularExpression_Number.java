package RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 
 * version: June 01, 2018 05:54 PM
 * Last revision: June 02, 2018 01:35 PM
 * 
 * Author : Chao-Hsuan Ke
 * 
 */

public class RegularExpression_Number 
{
	String regex = "[0-9]+";
	Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
	
	public RegularExpression_Number()
	{		
		String data = "1234aa567";
		
		// True/false
		System.out.println(data.matches(regex));
		// Parsing
		Matcher matcher = pattern.matcher(data);        
        while(matcher.find())
        {
        	System.out.println(matcher.group());
        }
	}
	
	public static void main (String args[])
	{
		RegularExpression_Number RE_num = new RegularExpression_Number();
	}
	
}
