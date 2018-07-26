
/*
 * Update MongoDB
 * 
 * version: June 24, 2017 09:06 AM
 * Last revision: July 24, 2018 01:32 PM
 * 
 * Author : Chao-Hsuan Ke
 * 
 */

import java.util.Random;

public class Random_generator_Int 
{
	private int min = 0;
	private int max = 10;	
	private int randomNum;
		
	public Random_generator_Int()
	{				
		Random rand = new Random();
		randomNum = min + rand.nextInt(max);
		
		System.out.println(randomNum);
	}
	
	public static void main(String args[])
	{
		Random_generator_Int ran_int = new Random_generator_Int();
	}
	
}
