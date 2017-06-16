
/*
 * version: June 16, 2017 02:26 PM
 * Last revision: June 14, 2017 03:35 PM
 * 
 * Author : Chao-Hsuan Ke
 * 
 * 
 * Timestamp	https://docs.oracle.com/javase/8/docs/api/java/sql/Timestamp.html
 * 
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Time_difference 
{
	//private Date date_format; 	
	private String data_now_str = "2017-06-15 18:00:36.629";
	private String before_day_str = "2017-06-14 18:00:36.629";
	
	
	
	public Time_difference() throws Exception
	{		
		Date date_format_now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(data_now_str);
		
		//Add_Day(date_format, 7);
		//Add_Hour(date_format, 10);

		// date comparison
		Date date_format_comparison = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(before_day_str);
		Day_compasion(date_format_now, date_format_comparison);		
				
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
	
	public static void main(String args[]) 
	{
		try {
			Time_difference tf = new Time_difference();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
