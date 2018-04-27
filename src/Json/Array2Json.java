package Json;

/*
 * Updated video tag 
 * 
 * version: April 27, 2018 06:20 PM
 * Last revision: April 27, 2018 06:20 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import java.util.Vector;

public class Array2Json 
{
	String array_str = "[mp4, toystory, mp4, toystory]";
	
	public Array2Json()
	{
		//System.out.println(array_str);		
		
		Vector<String> vector = new Vector<String>();
		vector.add("Item1");
	    vector.add("Item2");
	     
	    //System.out.println(vector);
	    String[] array = vector.toArray(new String[vector.size()]);
	    for(int i=0; i<array.length; i++)
	    {
	    	System.out.println(array[i]);	
	    }
	    
	}
	
	public static void main(String args[]) 
	{
		Array2Json a2j = new Array2Json();
	}
	
}
