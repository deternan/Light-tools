import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * http://www.geeksforgeeks.org/regular-expressions-in-java/
 * 
 * Last revision: July 09, 2017 07:25 PM
 * 
 */

public class Regular_Expression 
{
	Pattern p;
	Matcher m;
	
	String num_pattern = "[0-9]{4}";
	String space_pattern = "^[0-9]";
			
	String temp_str = "1102　";

	public Regular_Expression()
	{
		// Number check
		p = Pattern.compile(num_pattern);
        m = p.matcher(temp_str);
        
        while(m.find()){
        	System.out.println(m.group());
        }
        
        // Space check
        String temp = temp_str.substring(4, 5);
        p = Pattern.compile(space_pattern);
        m = p.matcher(temp_str);
        while(m.find()){
        	System.out.println("Not Digital");
        }
	}
	
	public static void main(String args[])
	{
		Regular_Expression RE = new Regular_Expression();
	}
	
}
