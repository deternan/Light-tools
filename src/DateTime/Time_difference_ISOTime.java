/*
 * version: December 15, 2017 02:06 PM
 * Last revision: December 15, 2017 02:06 PM
 * 
 * Author : Chao-Hsuan Ke
 * 
 * Timestamp	https://docs.oracle.com/javase/8/docs/api/java/sql/Timestamp.html
 * 
 */

package DateTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Time_difference_ISOTime 
{
	private String isotime_pattern = "EEE MMM dd HH:mm:ss zzz yyyy";		// Thu Nov 30 16:34:55 CST 2017
	
	private String data_now; 	
	private String data_spec_str = "星期五 十二月 01 12:17:04 TST 2017";		
	private String before_day_str = "星期四 十一月 23 09:50:00 TST 2017";
	
	
	public Time_difference_ISOTime() throws Exception
	{		
		// Now
		TimeZone tz = TimeZone.getTimeZone("Asia/Taipei");		
		DateFormat df = new SimpleDateFormat(isotime_pattern); 				// Quoted "Z" to indicate UTC, no timezone offset
		df.setTimeZone(tz);
		String nowAsISO = df.format(new Date());
		System.out.println(nowAsISO);
//		Date date_format_now = new SimpleDateFormat(isotime_pattern).parse(nowAsISO);
//		System.out.println(date_format_now);
		
		// Specified Time
		Date date_format_spec = new SimpleDateFormat(isotime_pattern).parse(data_spec_str);
		System.out.println(date_format_spec);
		
		// Add time
		Add_Month(date_format_spec, 3);
		//Add_Day(date_format, 7);
		//Add_Hour(date_format, 10);
		// Less time
		//Less_Month(date_format_spec, 3);
		//Less_Day();
		
		// date comparison
//		Date date_format_comparison = new SimpleDateFormat(isotime_pattern).parse(before_day_str);
//		Day_compasion(date_format_now, date_format_comparison);		
		// time different
//		DateTime_different(date_format_now, date_format_comparison);
	}
	
	private Calendar Add_Month(Date datestr, int month) throws Exception	
	{		
		Calendar can_temp = Calendar.getInstance();		
		can_temp.setTime(datestr);
		can_temp.add(Calendar.MONTH, +month);
		
		//System.out.println(can_temp.toInstant());		
		return can_temp; 		
	}
	
	private Calendar Add_Day(Date datestr, int day) throws Exception	
	{
		//date_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(datestr);
		Calendar can_temp = Calendar.getInstance();		
		can_temp.setTime(datestr);
		can_temp.add(Calendar.DAY_OF_MONTH, +day);
		
		//System.out.println(can_temp.getTime());
		return can_temp; 		
	}
	
	private Calendar Add_Hour(Date datestr, int hour) throws Exception
	{
		//date_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(datestr);
		Calendar can_temp = Calendar.getInstance();		
		can_temp.setTime(datestr);
		can_temp.add(Calendar.HOUR_OF_DAY, +hour);
		
		//System.out.println(can_temp.getTime());
		return can_temp;
	}
	
	private Calendar Less_Month(Date datestr, int month) throws Exception	
	{
		Calendar can_temp = Calendar.getInstance();		
		can_temp.setTime(datestr);
		can_temp.add(Calendar.MONDAY, -month);
		
		System.out.println(can_temp.getTime());
		return can_temp;
	}
	
	private Calendar Less_Day(Date datestr, int day) throws Exception	
	{
		Calendar can_temp = Calendar.getInstance();		
		can_temp.setTime(datestr);
		can_temp.add(Calendar.DAY_OF_MONTH, -day);
		
		//System.out.println(can_temp.getTime());
		return can_temp;
	}
	
	private void Day_compasion(Date data_now, Date data_comparison) throws Exception
	{
		//Date date_format_now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(data_now);
		//Date date_format_comparison = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(data_comparison);
		
		System.out.println(data_now);
		System.out.println(data_comparison);
		
		if(data_now.after(data_comparison)){
			System.out.println("data_now > data_comparison");
		}else{
			System.out.println("data_now < data_comparison");
		}
	}
	
	private void DateTime_different(Date data_now, Date data_comparison)
	{        
        try {
            long diff = data_comparison.getTime() - data_now.getTime();
            
            long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);

            System.out.print(diffDays + " days, ");
            System.out.print(diffHours + " hours, ");
            System.out.print(diffMinutes + " minutes, ");
            System.out.print(diffSeconds + " seconds.");

        } catch (Exception e) {
            e.printStackTrace();
        }

	}
	
	public static void main(String args[]) 
	{
		try {
			Time_difference_ISOTime tf = new Time_difference_ISOTime();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
