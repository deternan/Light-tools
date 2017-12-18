import java.text.SimpleDateFormat;
import java.util.Calendar;

/*
 * Date_Translation
 * 
 * Copyright (C) 2016 Phelps Ke, phelpske.dev at gmail dot com
 *  
 * Last revision: July 04, 2017 09:28 PM
 */

public class Date_Translation 
{

	public Date_Translation()
	{
		// Current data & time
		Calendar c = Calendar.getInstance();
        long milliseconds = c.getTimeInMillis();
        System.out.println("Data now (milliseconds):"+milliseconds);
        
        //
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        System.out.println("SimpleDateFormat: "+sdf.format(milliseconds));
	}
	
	public static void main(String args[])
	{
		Date_Translation DT = new Date_Translation();
	}
	
}
