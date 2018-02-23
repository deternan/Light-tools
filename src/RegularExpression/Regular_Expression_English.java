package RegularExpression;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Regular_Expression_English 
{

	public Regular_Expression_English()
	{
		String input = "各位我又回來啦，我們接下來要開始進入我們專案的起始這個階段，專案起始我們會跟各位介紹兩個非常重要的 concept 還有方法，第一個就是專案章程，我想各位有沒有聽過 project charter";
        Pattern pattern = Pattern.compile("([a-zA-Z]+/s{1,3})", Pattern.MULTILINE);
 
        Matcher matcher = pattern.matcher(input);
        
        while(matcher.find())
        {
        	System.out.println(matcher.group());
        }
	}
	
	public static void main (String args[]) 
	{
		Regular_Expression_English REE = new Regular_Expression_English();
	}
	
}
