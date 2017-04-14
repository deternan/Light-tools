package Text_related;

/*
 * Version: 
 * Remove non-English characters
 * 
 * Version: April 14, 2017 01:15 PM
 * Last revision: April 14, 2017 01:15 PM 
 * 
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class English_filter 
{
	private Pattern target;
	private Matcher matcher;
	
	private String input = "The Bhagavad Gita (Penguin Classics) abc,.";
	
	public English_filter()
	{
		target = Pattern.compile("[a-zA-Z0-9]+", Pattern.CASE_INSENSITIVE);		
		
		matcher = target.matcher(input);
		while(matcher.find())
		{
			System.out.println(matcher.group());
		}
	}
}
