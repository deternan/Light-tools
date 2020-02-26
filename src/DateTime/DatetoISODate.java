package DateTime;

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
import java.util.TimeZone;

public class DatetoISODate 
{
	private String isotime_pattern = "EEE MMM dd HH:mm:ss zzz yyyy";
	
	public DatetoISODate() throws Exception
	{
		Date utilDateSetting = SettingDateString(2018,06,01);
		System.out.println(utilDateSetting);
		
		//2018-07-09 15:37:25.440+08:00
		//2018-07-09T00:00:00.000Z
		System.out.println(getISO8601StringForDate(utilDateSetting));		
	}
	
	private Date SettingDateString(int year, int month, int day)
	{
		Calendar myCal = Calendar.getInstance();		
		myCal.set(Calendar.YEAR, year);
		myCal.set(Calendar.MONTH, month-1);
		myCal.set(Calendar.DATE, day);
		//myCal.set(Calendar.HOUR, 0 - 4);
		myCal.set(Calendar.HOUR_OF_DAY, 0);
		myCal.set(Calendar.MINUTE, 0);
		myCal.set(Calendar.SECOND, 0);
		
		Date utilDate = myCal.getTime();
		//System.out.println(utilDate);
		return utilDate;
	}
	
	private static String getISO8601StringForDate(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sss'Z'");
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
