
/*
 * time gap
 * 
 * version: December 18, 2018 09:38 AM
 * Last revision: December 18, 2018 09:38 AM
 * 
 * Author : Chao-Hsuan Ke
 * 
 */

public class ProcessingTime 
{

	public ProcessingTime()
	{
		long startTime = System.currentTimeMillis();
		
		// Processing
		for(int i=1; i<=9; i++)
		{
			for(int j=1; j<=9; j++)
			{
				System.out.println(i+"x"+j+"="+(i*j));
			}			
		}
		
		long endTime = System.currentTimeMillis();
		
		long timegap = endTime - startTime;
		
		System.out.println(timegap);
	}
	
	public static void main(String[] args)
	{
		ProcessingTime PT = new ProcessingTime();
	}
	
}
