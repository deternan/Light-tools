package Algorithms.Sort;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Vector;

public class Sort_timestamp 
{
	private Vector timestamp = new Vector();

	DateTimeFormatter formatter;
	
	public Sort_timestamp()
	{
		timestamp.add("Mon Jul 30 14:25:53 CST 2018");
		timestamp.add("Mon Aug 27 21:11:01 CST 2018");
		timestamp.add("Tue Jul 24 14:42:30 CST 2018");
		
		Collections.sort(timestamp);
		
        for(int i=0; i<timestamp.size(); i++)
        {
        	System.out.println(timestamp.get(i));
        }
	}
	
	public static void main(String[] args)
	{
		Sort_timestamp sort = new Sort_timestamp();
	}
	
}
