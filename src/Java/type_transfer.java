package Java;

/*
 * eTube video content Search
 * 
 * version: March 07, 2018 03:02 PM
 * Last revision: March 07, 2018 03:02 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

public class type_transfer 
{

	public type_transfer()
	{
		Boolean2String();
		String2Boolean();
		
	}
	
	private void Boolean2String()
	{
		boolean bol_val = true;
		String str_val;
		
		str_val = String.valueOf(bol_val);
		
		System.out.println(str_val);
	}
	
	private void String2Boolean()
	{
		boolean bol_val;
		String str_val = "false";
		
		bol_val = Boolean.valueOf(str_val);
		System.out.println(bol_val);
	}
	
	public static void main(String[] args)
	{
		type_transfer tt = new type_transfer();
	}
	
}
