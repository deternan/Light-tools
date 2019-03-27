package Algorithms.Sort;

/*
 * Bubble Sort 
 * 
 * version: March 27, 2019 06:29 PM
 * Last revision: March 27, 2019 06:29 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

public class BubbleSort 
{
	double[] input = {10,15,6,9,2,7,18};
	
	public BubbleSort()
	{
		int lenD = input.length;
		int j = 0;
		double tmp = 0;
		
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
		
		// Display
		for(int i=0; i<lenD; i++)
		{
			System.out.println(input[i]);
		}
		
	}
	
	public static void main(String args[]) {
		BubbleSort bs = new BubbleSort();
	}
	
}