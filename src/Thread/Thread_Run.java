package Thread;
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
		
		for (int i = 0; i < 100; i++)
		{
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
			  		
			  		System.out.println("run by: " + getName()+"	"+randomNum+"	"+nowAsISO);
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