package Sort;

/*
 * ArrayList Bubble Sort 
 * 
 * version: December 13, 2018 02:20 PM
 * Last revision: December 13, 2018 02:20 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import java.util.ArrayList;

public class ArrayList_bubbleSort 
{
	ArrayList<Integer> input = new ArrayList<Integer>(); 
	
	
	public ArrayList_bubbleSort()
	{
		input.add(02);
		input.add(21);
		input.add(01);
		input.add(27);
		input.add(11);
		input.add(28);
		
		ArrayList<Integer> inputSort = new ArrayList<Integer>();		
		inputSort = BubbleSort(input);
		for(int i=0; i<inputSort.size(); i++)
		{
			System.out.println(inputSort.get(i));
		}
		
		
	}
	
	private ArrayList<Integer> BubbleSort(ArrayList<Integer> input)
    {
    	int lenD = input.size();
		int j = 0;
		int tmp = 0;
		
		for(int i=0; i<lenD; i++)
		{
		    j = i;
		    for(int k=i; k<lenD; k++)
		    {
		      //if(input[j] < input[k]){
		    	if(input.get(j) < input.get(k)){
		        j = k;		        
		      }
		    }
		    
		    tmp = input.get(i);		    		  
		    input.set(i, input.get(j));
		    input.set(j, tmp);
		}
		
		return input;
    }
	
	public static void main(String args[])
	{
		ArrayList_bubbleSort arraylistSort = new ArrayList_bubbleSort();
	}
	
}
