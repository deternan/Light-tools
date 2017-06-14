
public class Random 
{
	private int min = 0;
	private int max = 100;
	
	private int randomNum;
	
	
	public Random()
	{		
		randomNum = min + (int)(Math.random() * max); 
		
		System.out.println(randomNum);
	}
	
	public static void main(String args[])
	{
		Random ran = new Random();
	}
	
}
