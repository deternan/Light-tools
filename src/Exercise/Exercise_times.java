package Exercise;

/*
 * 
 * version: September 25, 2017 04:07 PM
 * Last revision: September 25, 2017 04:07 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

public class Exercise_times 
{
	private long start_time;
	private long end_time;
	private long total_time;
	
	public Exercise_times()
	{
		// start
		start_time = System.currentTimeMillis();		
		
		int total = 0;
		for(int i=0; i<100000000; i++)
		{
			total += i;
		}
		
		// end
		end_time = System.currentTimeMillis();
		
		//System.out.println("Exercised time：" + (end_time - start_time)/1000 + "sec");
		System.out.println("Exercised time：" + (end_time - start_time) + " millisecond");
	}
	
	public static void main(String args[])
	{
		Exercise_times et = new Exercise_times();
	}
	
}
