package Algorithms;

import java.util.ArrayList;

/*
 * Bobble Sort (ArrayList)
 * 
 * version: January 25, 2018 06:39 PM
 * Last revision: January 25, 2018 06:39 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

public class BubbleSort_ArrayList 
{
	ArrayList<String> arr_sort = new ArrayList<String>();
	
	
	public BubbleSort_ArrayList(ArrayList arrlist)
	{		
		arr_sort = arrlist;
		String time_temp = "";
	
		for(int j=0; j< arrlist.size(); j++)
		{			
			for(int i=j+1; i<arrlist.size(); i++)
			{
			    if((arr_sort.get(i)).compareToIgnoreCase(arr_sort.get(j))<0){
			    	time_temp = arr_sort.get(j);
			    	arr_sort.set( j, arr_sort.get(i));
			    	arr_sort.set( i, time_temp);			    	
			   }
			}
		}
		
		for(int i=0; i<arr_sort.size(); i++)
		{
			System.out.println(arr_sort.get(i));
		}
	}
	
	public static void main(String[] args)
	{
		ArrayList<String> arr = new ArrayList<String>();
		
		arr.add("A");
		arr.add("C");
		arr.add("Delta");
		arr.add("atled");
		arr.add("atleD");
		arr.add("I");
		
		BubbleSort_ArrayList bs_arraylist = new BubbleSort_ArrayList(arr);
	}
}
