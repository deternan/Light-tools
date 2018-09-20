package Algorithms;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/*
 * Bobble Sort (Vector) - timestamp
 * 
 * version: September 20, 2018 04:53 PM
 * Last revision: September 20, 2018 04:53 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

public class BubbleSort_Vector_timestamp 
{
//	private Vector timestamp = new Vector();
	private String[] timestamp;
	DateTimeFormatter formatter;
	private String isotime_pattern = "EEE MMM dd HH:mm:ss zzz yyyy";

	String today_str;
	
	public BubbleSort_Vector_timestamp()
	{
		timestamp = new String[5];
		
		timestamp[0] = "Mon Jul 30 14:25:53 CST 2018";
		timestamp[1] = "Mon Aug 27 21:11:01 CST 2018";
		timestamp[2] = "Tue Dec 12 05:03:19 CST 2017";
		timestamp[3] = "Fri Jan 27 12:57:32 CST 2017";
		timestamp[4] = "Tue Jul 24 14:42:30 CST 2018";
		
		formatter = DateTimeFormatter.ofPattern(isotime_pattern, Locale.ENGLISH);
		 
		int j = 0;
		String tmp_str;
		
		for(int i=0; i<timestamp.length; i++)
		{
			LocalDate timestamp_i = LocalDate.parse(timestamp[i], formatter);
			
			j = i;
		    for(int k=i; k<timestamp.length; k++)
		    {
		    	LocalDate timestamp_j = LocalDate.parse(timestamp[j], formatter);
		    	LocalDate timestamp_k = LocalDate.parse(timestamp[k], formatter);
		    	if(timestamp_j.isBefore(timestamp_k)) {
		    		j = k;
		    	}
		    }
		    tmp_str = timestamp[i];
		    timestamp[i] = timestamp[j];
		    timestamp[j] = tmp_str;
		}
		
		for(int i=0; i<timestamp.length; i++)
		{
			System.out.println(timestamp[i]);
		}
	}
	
	public static void main(String[] args)
	{		
		BubbleSort_Vector_timestamp BS_array = new BubbleSort_Vector_timestamp();
	}
	
}
