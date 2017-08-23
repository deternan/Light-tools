package Text_related;

/*
 *  English Words check
 * 
 *	Version: June 02, 2017 02:08 PM
 * 	Last revision: June 02, 2017 02:08 PM
 * 
 */


import java.nio.charset.Charset;

public class English_check 
{
	private String input_str = "ABC";
	
	public English_check()
	{
		boolean check;
		
		// ASCII code
		//check = Charset.forName("US-ASCII").newEncoder().canEncode(input_str);
		// English
		check = input_str.matches("[a-zA-Z]+");
		
		System.out.println(check);
	}
	
	public static void main (String args[]) 
	{
		English_check ec = new English_check();
	}
	
}
