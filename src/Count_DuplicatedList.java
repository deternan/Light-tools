
/*
 * Count Duplicated List 
 * 
 * version: December 13, 2018 11:55 AM
 * Last revision: December 13, 2018 11:55 AM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import java.util.ArrayList;  
import java.util.Collections;  
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;   
import java.util.Set;  
  

public class Count_DuplicatedList 
{

	public Count_DuplicatedList()
	{
		List list = new ArrayList();  
        list.add("abc");  
        list.add("bca");  
        list.add("cab");  
        list.add("ddd");  
        list.add("bca");  
        list.add("cab");  
        list.add("abc");  
        list.add("acb");  
        list.add("abc");  
        
        // Specific 
 //       System.out.println("abc : " + Collections.frequency(list, "abc"));  
        
        // All list
        Set<String> setlist = new HashSet(list);
        Iterator<String> it = setlist.iterator();
        while(it.hasNext())
        {
        	String abc = it.next();
        	System.out.println(abc + ": " + Collections.frequency(list, abc));
        }
        	
 
	}
	
	public static void main(String args[])
	{
		Count_DuplicatedList DuplicatedList = new Count_DuplicatedList();
	}
	
}
