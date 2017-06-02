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
	private String input_str = "here is 臺中";
	
	public English_check()
	{
		boolean check;
		
		check = Charset.forName("US-ASCII").newEncoder().canEncode(input_str);
		System.out.println(check);
	}
	
	public static void main (String args[]) 
	{
		English_check ec = new English_check();
	}
	
}
