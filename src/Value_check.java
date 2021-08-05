
/* 
 * version: July 28, 2018 12:11 PM
 * Last revision: July 28, 2018 12:11 PM
 * 
 * Author : Chao-Hsuan Ke
 * 
 */

public class Value_check 
{

	public Value_check()
	{
		NaN_check();
				
		
	}
	
	private void NaN_check()
	{
		double aa = 0.0;
		double divided = 0;
		
		double result = aa / divided;
		
		if(Double.isNaN(result)){
			System.out.println("NaN");
		}else{
			System.out.println(aa);
		}
	}
	
	public static void main(String args[])
	{
		Value_check vc = new Value_check();
	}
	
}
