package Text_related;

/*
 * Remove Symbol
 * 
 * version: January 23, 2018 03:34 PM
 * Last revision: January 23, 2018 03:34 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

public class Remove_Symbol 
{
	String input_str = "我接下來的回覆讓她嚇了一跳，但我說的卻是千真萬確";
	
	public Remove_Symbol()
	{
		//String str = input_str.replaceAll("(?i)[^a-zA-Z0-9\u4E00-\u9FA5]", "");	
		String str = input_str.replaceAll("(?i)[^a-zA-Z0-9\u4E00-\u9FA5]", " ");
		
		System.out.println(str);
	}
	
	public static void main(String args[])
	{
		Remove_Symbol RS = new Remove_Symbol();
	}
	
}
