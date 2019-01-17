
/*
 * Random SEED
 * 
 * version: January 17, 2019 12:00 PM
 * Last revision: January 17, 2019 12:00 PM
 * 
 * Author : Chao-Hsuan Ke
 * 
 */

import java.util.Random;

public class Random_SEED 
{
	private int min = 0;
	private int max = 100;	
	private int randomNum;
	private int SEED = 618;	
	
	private int testingTime = 10;
	
	public Random_SEED()
	{				
		Random rand = new Random(SEED);
		
		for(int i=0; i<testingTime; i++) {
			randomNum = min + rand.nextInt(max);
			System.out.println(i+"	"+randomNum);
		}
		
				
		
	}
	
	public static void main(String args[])
	{
		Random_SEED ran_int = new Random_SEED();
	}
	
}
