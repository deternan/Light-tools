/*
 * Bobble Sort (Array)
 * 
 * version: January 25, 2018 06:39 PM
 * Last revision: January 25, 2018 06:39 PM
 * 
 * Author : Chao-Hsuan Ke
 * 
 */

package Algorithms;

public class BubbleSort_Array 
{

	public BubbleSort_Array(double[] input)
	{
		int lenD = input.length;
		int j = 0;
		double tmp = 0;
		String videoid_temp = "";
		String videourl_temp = "";
		
		for(int i=0; i<lenD; i++)
		{
		    j = i;
		    for(int k=i; k<lenD; k++)
		    {
		      if(input[j] < input[k]){
		        j = k;		        
		      }
		    }
		    // Numerical
		    tmp = input[i];		   
		    input[i] = input[j];
		    input[j] = tmp;		   
		}
		
		for(int i=0; i<input.length; i++)
		{
			System.out.println(input[i]);
		}
	}
	
	public static void main(String[] args)
	{
		double[] input = {88, 81, 74, 68, 78, 76, 77, 85, 95, 93};
		
		BubbleSort_Array BS_array = new BubbleSort_Array(input);
	}
	
}
