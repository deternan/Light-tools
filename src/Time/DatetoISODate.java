package Time;

/*
 * Date to ISODate
 * 
 * version: December 05, 2018 04:15 PM
 * Last revision: December 05, 2018 04:15 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DatetoISODate 
{
	private String isotime_pattern = "EEE MMM dd HH:mm:ss zzz yyyy";
	
	public DatetoISODate() throws Exception
	{
		Date utilDateSetting = SettingDateString(2018,6,01);
		//System.out.println(utilDateSetting);
		
		
		System.out.println(getISO8601StringForDate(utilDateSetting));		
	}
	
	private Date SettingDateString(int year, int month, int day)
	{
		Calendar myCal = Calendar.getInstance();
		myCal.set(Calendar.YEAR, year);
		myCal.set(Calendar.MONTH, month-1);
		myCal.set(Calendar.DAY_OF_MONTH, 01+1);
		myCal.set(Calendar.HOUR_OF_DAY, 0);
		myCal.set(Calendar.MINUTE, 0);
		myCal.set(Calendar.SECOND, 0);
		
		Date utilDate = myCal.getTime();
		//System.out.println(utilDate);
		return utilDate;
		
//		Date theDate = myCal.getTime();		
//		DateTools.dateToString(theDate, Resolution.MONTH);					
//		
//		return DateTools.dateToString(theDate, Resolution.DAY);
	}
	
	private static String getISO8601StringForDate(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.TAIWAN);
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
				
		return dateFormat.format(date);
	}
	
	
	public static void main(String args[]) 
	{
		try {
			DatetoISODate tt = new DatetoISODate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
