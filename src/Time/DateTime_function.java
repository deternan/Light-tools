package Time;

import java.util.Calendar;
import java.util.Date;

import org.apache.lucene.document.DateTools;
import org.apache.lucene.document.DateTools.Resolution;

/*
 * version: February 22, 2018 06:23 PM
 * Last revision: February 22, 2018 06:23 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

public class DateTime_function 
{

	public DateTime_function()
	{
		// time to string 
			// example :  2018-02
		Time_to_String("2018-02");
	}
	
	private String Time_to_String(String input)
	{
		String datestr = "";
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

		System.out.println(DateTools.dateToString(theDate, Resolution.DAY));
		
		return datestr;
	}
	
	public static void main(String[] args)
	{
		DateTime_function df = new DateTime_function();
	}
	
}
