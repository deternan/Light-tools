
/*
 *  RemoveDuplicates (Array)
 * 
 * Version: April 10, 2017 03:32 PM
 * Last revision: April 10, 2017 03:32 PM 
 * 
 * Author : Chao-Hsuan Ke
 *  
 */

public class RemoveDuplicates 
{
	private int[] all = {1, 2, 2, 3, 9, 6, 8, 9, 12, 7, 15};
	
	public RemoveDuplicates()
	{
		int all_length = all.length;

	    for (int i = 0; i < all_length; i++) 
	    {
	        for (int j = i + 1; j < all_length; j++) 
	        {
	            if (all[i] == all[j]) {                  
	                int shiftLeft = j;
	                for (int k = j+1; k < all_length; k++, shiftLeft++) 
	                {
	                	all[shiftLeft] = all[k];
	                }
	                all_length--;
	                j--;
	            }
	        }
	    }

	    int[] remove_list = new int[all_length];
	    for(int i = 0; i < all_length; i++)
	    {
	    	remove_list[i] = all[i];
	    }
	   
	}
	
	public static void main(String args[])
	{
		RemoveDuplicates RD = new RemoveDuplicates();
	}
	
}
