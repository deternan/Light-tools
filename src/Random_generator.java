import java.util.Random;

public class Random_generator 
{
	private int min = 0;
	private int max = 2;
	
	private int randomNum;
	
	
	public Random_generator()
	{		
		
		Random rand = new Random();
		randomNum = min + rand.nextInt(max);
		
		System.out.println(randomNum);
	}
	
	public static void main(String args[])
	{
		Random_generator ran = new Random_generator();
	}
	
}
