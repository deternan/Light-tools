package Text_related;

/*
 * Split string into individual words 
 * 
 * version: July 26, 2018 06:36 PM
 * Last revision: July 26, 2018 06:36 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

public class SplitString2IndividualWords 
{
	String s = "It could be you, or it could be us, but there's no page here.";
	
	public SplitString2IndividualWords()
	{
		
		String[] arr = s.split(" ");    

		for (int i=0; i<arr.length; i++) {
		    System.out.println(arr[i]);
		}
	}
	
	public static void main(String[] args)
	{
		SplitString2IndividualWords split = new SplitString2IndividualWords();
	}
}
