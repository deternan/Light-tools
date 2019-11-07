package Text_related;

/*
 *  CJKV (Chinese, Japanese, Korean and Vietnamese) Words check
 * 
 *	Version: June 02, 2017 10:11 AM
 * 	Last revision: June 02, 2017 10:11 AM
 * 
 */

public class CJKV_check 
{
	private String input_str = "";
	
	public CJKV_check()
	{
		boolean check;
		check = input_str.codePoints().anyMatch(codepoint -> Character.UnicodeScript.of(codepoint) == Character.UnicodeScript.HAN);
		
		System.out.println(check);
	}
	
	public static void main (String args[]) 
	{
		CJKV_check cjkv = new CJKV_check();
	}
	
}
