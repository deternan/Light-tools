package Time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.lucene.document.DateTools;
import org.apache.lucene.document.DateTools.Resolution;

/*
 * version: February 22, 2018 06:23 PM
 * Last revision: February 26, 2018 04:51 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

public class DateTime_function 
{
	Pattern p;
	Matcher m;
	
	// Week days
	String week_start;
	
	public DateTime_function()
	{
		// time to string 
			// example :  2018-02		
		String date_str = Time_to_String("2018-02");
		System.out.println(date_str);
						
		//Week_Days(2018,02,21);
		ArrayList<String> day_array;
		day_array = Date_separation("2018-02-18");
		Week_Days(Integer.parseInt(day_array.get(0)), Integer.parseInt(day_array.get(1)), Integer.parseInt(day_array.get(2)));
	}
	
	private String Time_to_String(String input)
	{
		String year_str = input.substring(0, input.indexOf("-"));
		String month_str = input.substring(input.indexOf("-")+1, input.length());
		int year = Integer.parseInt(year_str);
		int month = Integer.parseInt(month_str);
		
		Calendar myCal = Calendar.getInstance();
		myCal.set(Calendar.YEAR, year);
		myCal.set(Calendar.MONTH, month-1);
		myCal.set(Calendar.DAY_OF_MONTH, 01+1);
		myCal.set(Calendar.HOUR_OF_DAY, 0);
		myCal.set(Calendar.MINUTE, 0);
		myCal.set(Calendar.SECOND, 0);
		Date theDate = myCal.getTime();		
		DateTools.dateToString(theDate, Resolution.MONTH);		
		//System.out.println(DateTools.dateToString(theDate, Resolution.DAY));				
		
		return DateTools.dateToString(theDate, Resolution.DAY);
	}
	
	private ArrayList Date_separation(String input)
	{		
		Date return_date = null;
		ArrayList<String> obj = new ArrayList<String>();
		
		String pattern = "([\\d]{4})-([\\d]{2})-([\\d]{2})";
		
		p = Pattern.compile(pattern);
        m = p.matcher(input);        
        
        while (m.find()) 
        {
        	obj.add(m.group(1));
        	obj.add(m.group(2));
        	obj.add(m.group(3));
        }
		
		return obj;
	}
	
	private void Week_Days(int year, int month, int day)
	{
		Calendar myCal = Calendar.getInstance();
		myCal.set(Calendar.YEAR, year);
		myCal.set(Calendar.MONTH, month-1);
		myCal.set(Calendar.DAY_OF_MONTH, day);		
		myCal.getTime();
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
		myCal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		String startDate = "";
		String endDate = "";
		startDate = df.format(myCal.getTime());
		myCal.add(Calendar.DATE, 6);
		endDate = df.format(myCal.getTime());
		System.out.println("Start Date = " + startDate);
		System.out.println("End Date = " + endDate);
	}
	
	public static void main(String[] args)
	{
		DateTime_function df = new DateTime_function();
	}
	
}
