package Text_related;

/*
 *  Chinese Words check
 * 
 *	Version: September 22, 2017 03:17 PM
 * 	Last revision: September 22, 2017 03:17 PM
 * 
 */

//import java.nio.charset.Charset;

public class Chinese_check 
{
	private String input_str = "介紹Java判斷字符";
	
	public Chinese_check()
	{
		boolean check;
		
		// Chinese
		check = input_str.matches("[\u4e00-\u9fa5]+");
		
		System.out.println(check);
	}
	
	public static void main (String args[]) 
	{
		Chinese_check ec = new Chinese_check();
	}
	
}
