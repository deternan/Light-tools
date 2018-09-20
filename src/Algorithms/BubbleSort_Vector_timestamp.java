package Algorithms;

/*
 * Bobble Sort (Vector) - timestamp
 * 
 * version: September 20, 2018 04:53 PM
 * Last revision: September 20, 2018 05:22 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class BubbleSort_Vector_timestamp 
{
	private String[] timestamp;
	DateTimeFormatter formatter;
	private String isotime_pattern = "EEE MMM dd HH:mm:ss zzz yyyy";

	String today_str;
	
	public BubbleSort_Vector_timestamp()
	{
		timestamp = new String[6];
		
		timestamp[0] = "Mon Jul 30 14:25:53 CST 2018";
		timestamp[1] = "Mon Aug 27 21:11:01 CST 2018";
		timestamp[2] = "Tue Dec 12 05:03:19 CST 2017";
		timestamp[3] = "Fri Jan 27 12:57:32 CST 2017";
		timestamp[4] = "Tue Jul 24 14:42:30 CST 2018";
		timestamp[5] = "Tue Jul 24 15:22:12 CST 2018";
		
		formatter = DateTimeFormatter.ofPattern(isotime_pattern, Locale.ENGLISH);
		 
		int j = 0;
		String tmp_str;
		
		for(int i=0; i<timestamp.length; i++)
		{
			LocalDateTime timestamp_i = LocalDateTime.parse(timestamp[i], formatter);
			
			j = i;
		    for(int k=i; k<timestamp.length; k++)
		    {
		    	LocalDateTime timestamp_j = LocalDateTime.parse(timestamp[j], formatter);
		    	LocalDateTime timestamp_k = LocalDateTime.parse(timestamp[k], formatter);
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
