package Thread;

/*
 * Thread
 * 
 * version: January 24 20, 2018 04:03 PM
 * Last revision: March 11, 2019 04:34 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

public class Thread_Run 
{
	// Random
	private int min = 0;
	private int max = 100;
	// Time
	TimeZone tz = TimeZone.getTimeZone("Asia/Taipei");		
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S"); // Quoted "Z" to indicate UTC, no timezone offset
	String nowAsISO;
	
	int times = 100;
	
	public Thread_Run() 
	{
//		System.out.println(Thread.currentThread().getName());
//		
//		for (int i = 0; i < 10; i++) 
//		{
//			new Thread("" + i) {
//				public void run() 
//				{
//					System.out.println("Thread: " + getName() + " running	");
//					Random_generator();
//				}
//			}.start();
//		}
		
		for (int i=0; i<times; i++)
		{
			try {
	            Thread.sleep((int)20000);
	        } catch (InterruptedException e) {
	        }
			
			Thread thread = new Thread("New Thread") 
			{
			      public void run(){
			        //System.out.println("run by: " + getName());
			        
			    	// Random number
			    	Random rand = new Random();		
			  		int randomNum = min + rand.nextInt(max);		
			  		
			  		// Timer			  		
					df.setTimeZone(tz);
					nowAsISO = df.format(new Date());					
					
					
			  		System.out.println(getName()+"	"+randomNum+"	"+nowAsISO);
			      }
			};
			
			thread.start();
			//System.out.println(thread.getName());
		}
		
	}

	private void Random_generator()
	{
		Random rand = new Random();		
		int randomNum = min + rand.nextInt(max);		
		System.out.println(randomNum);
	}
	
	public static void main(String[] args) 
	{
		Thread_Run thread = new Thread_Run();
	}
}