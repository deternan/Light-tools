package Values;

/*
 * Normalization
 * 
 * version: July 12, 2019 10:42 AM
 * Last revision: July 12, 2019 10:42 AM
 * 				  
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

public class Normalization 
{

	public Normalization()
	{
		double maxNum = 50;		// dynamic parameter
		double minNum = 0;		// dynamic parameter
		double norMax = 1;
		double norMin = 0;
		
		double norValue;
		
		double inputValue = 16;
		
		if ((inputValue - minNum) > 0) {
			norValue = ((inputValue - minNum) / (maxNum - minNum)) * (norMax - norMin) + norMin;
		} else {
			norValue = 0;
		}
	
		System.out.println(norValue);
	}
	
	public static void main(String args[]) 
	{
		Normalization nor = new Normalization();
	}
	
}
