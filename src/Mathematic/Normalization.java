package Mathematic;

/*
 * data normalization
 * 
 * version: August 30, 2018 11:26 AM
 * Last revision: August 30, 2018 11:26 AM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

public class Normalization 
{
	public Normalization()
	{
		double X = 42;
		
		double maxNum = 100;
		double minNum = 0;
		double norMax = 1;
		double norMin = 0;
		
		double norValue = ((X - minNum) / (maxNum - minNum)) * (norMax - norMin) + norMin;
		
		System.out.println(norValue);
	}
	
	public static void main(String args[])
	{
		Normalization nor = new Normalization();
	}
	
}
