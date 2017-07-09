import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * http://www.geeksforgeeks.org/regular-expressions-in-java/
 * 
 * 
 * Last revision: July 09, 2017 04:40 PM
 * 
 */

public class Regular_Expression 
{
	String pattern = "[0-9]+";	
	String temp_str = "056894";

	public Regular_Expression()
	{
		Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(temp_str);
        
        while(m.find()){
        	System.out.println(m.group());
        }
	}
	
	public static void main(String args[])
	{
		Regular_Expression RE = new Regular_Expression();
	}
	
}
