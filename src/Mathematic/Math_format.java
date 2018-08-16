package Mathematic;

/*
 * Mathematics format
 * 
 * version: August 16, 2018 11:07 AM
 * Last revision: August 16, 2018 07:36 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

public class Math_format 
{
	double input = 2;
	
	double result;
	
	public Math_format()
	{
		// square
		result = Math.pow(input, 2);
		System.out.println(result);
	}
	
	public static void main(String args[])
	{
		Math_format format = new Math_format();
	}
	
}
