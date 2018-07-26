
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

public class Random_generator_Double 
{
	private int min = 0;
	private int max = 1;
	private double randomNum;
	
	public Random_generator_Double()
	{
		Random rand = new Random();
		randomNum = min + (max - min) * rand.nextDouble();
		
		System.out.println(randomNum);
	}
	
	public static void main(String args[])
	{
		Random_generator_Double ran_dou = new Random_generator_Double();
	}	
}
