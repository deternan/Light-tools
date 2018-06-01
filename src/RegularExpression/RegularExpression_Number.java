package RegularExpression;

/*
 * 
 * version: June 01, 2018 05:54 PM
 * Last revision: June 01, 2018 05:54 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

public class RegularExpression_Number 
{

	public RegularExpression_Number()
	{
		String regex = "[0-9]+";
		String data = "1234567";
		
		System.out.println(data.matches(regex));
		
	}
	
	public static void main (String args[])
	{
		RegularExpression_Number RE_num = new RegularExpression_Number();
	}
	
}
