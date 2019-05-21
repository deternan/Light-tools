package DateTime;

/*
 * version: February 22, 2018 06:23 PM
 * Last revision: May 21, 2019 01:16 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.lucene.document.DateTools;
import org.apache.lucene.document.DateTools.Resolution;

public class DateTime_function 
{
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
	// Pattern
	private String isotime_pattern = "EEE MMM dd HH:mm:ss zzz yyyy";		// Thu Nov 30 16:34:55 CST 2017
	private String basic_pattern = "yyyy-MM-dd";
	
	private Pattern p;
	private Matcher m;
	
	// Week days
	LocalDate WeekstartDate;
	LocalDate WeekendDate;
	
	//private String data_spec_str = "星期五 十二月 01 12:17:04 TST 2017";
	private String data_spec_str = "Tue Jul 24 14:38:50 CST 2018";
	
	public DateTime_function() throws Exception
	{
		// time to string 
			// example :  2018-02		
		String date_str = Time_to_String("2018-09");
		//System.out.println(date_str);
						
		//Week Days Range(2018,02,21);
//		ArrayList<String> day_array;
//		day_array = Date_separation("2018-09-01");
//		Week_Days(Integer.parseInt(day_array.get(0)), Integer.parseInt(day_array.get(1)), Integer.parseInt(day_array.get(2)));
		
		// Today
//		Today();
//		// Date Parser		
//		ISODateParser();		
//		// Date comparison
//		String today_temp = "2018-09-09";
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(basic_pattern, Locale.TAIWAN);
//		LocalDate dateNow = LocalDate.parse(today_temp, formatter);
//		System.out.println(dateNow);
//		DayInWeek_check(dateNow, WeekstartDate, WeekendDate);
		
		// Today (hours range)
//		TodayHoursRange();
		// setting date (hours range)
//		DateHoursRange(2019,03,05);
		// Week of this Year 
//		WeekNoofYear();
		// Week range date
		WeekRange(10);
		// Month of this year
//		WeekNoofYear();
//		MonthRange(6);
		// WeekRange (based on specific date)
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
	
	private void TodayHoursRange()
	{
		// 0 hour
		Calendar today0 = Calendar.getInstance();
		today0.set(Calendar.HOUR_OF_DAY, 0);
		today0.set(Calendar.MINUTE,  0);
		today0.set(Calendar.SECOND,  0);
		today0.set(Calendar.MILLISECOND,  0);
				
		Date todayZero = today0.getTime();
		System.out.println(todayZero);
		
		// 24 hour
		Calendar today24 = Calendar.getInstance();
		today24.set(Calendar.HOUR_OF_DAY, 23);
		today24.set(Calendar.MINUTE, 59);
		today24.set(Calendar.SECOND, 59);
		today24.set(Calendar.MILLISECOND, 99);
		
		Date todayTwentyFour = today24.getTime();
		System.out.println(todayTwentyFour);
	}
	
	private void DateHoursRange(int year, int month, int day) throws Exception
	{		
		Calendar setdate = Calendar.getInstance();
		setdate.set(year, month, day);
		
		Calendar today0 = setdate.getInstance();
		today0.set(setdate.HOUR_OF_DAY, 0);
		today0.set(setdate.MINUTE,  0);
		today0.set(setdate.SECOND,  0);
		today0.set(setdate.MILLISECOND, 0);
		
		Date todayZero = today0.getTime();
		System.out.println(todayZero);
		
		Calendar today24 = setdate.getInstance();
		today24.set(setdate.HOUR_OF_DAY, 23);
		today24.set(setdate.MINUTE, 59);
		today24.set(setdate.SECOND, 59);
		today24.set(setdate.MILLISECOND, 99);
		
		Date todayTwentyFour = today24.getTime();
		System.out.println(todayTwentyFour);
	}
	
	private void Week_Days(int year, int month, int day)
	{
		Calendar myCal = Calendar.getInstance();
		myCal.set(Calendar.YEAR, year);
		myCal.set(Calendar.MONTH, month-1);
		myCal.set(Calendar.DAY_OF_MONTH, day);		
		myCal.getTime();
		
		//DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
		myCal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);		
		String WeekstartDate_str = df.format(myCal.getTime());
		myCal.add(Calendar.DATE, 6);
		String WeekendDate_str = df.format(myCal.getTime());
		System.out.println("Start Date = " + WeekstartDate_str);
		System.out.println("End Date = " + WeekendDate_str);		
		
		// Transfer
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(basic_pattern, Locale.TAIWAN);
		WeekstartDate = LocalDate.parse(WeekstartDate_str, formatter);
		WeekendDate = LocalDate.parse(WeekendDate_str, formatter);
	}
	
	private void Today()
	{
		Date today = Calendar.getInstance().getTime();
		String today_str = df.format(today.getTime());
		System.out.println(today_str);
	}
	
	private void ISODateParser() throws Exception
	{		
		boolean chinesecheck;
		chinesecheck = isChinese(data_spec_str);
		//System.out.println(check);
		DateTimeFormatter formatter;
		if(chinesecheck == true) {
			formatter = DateTimeFormatter.ofPattern(isotime_pattern, Locale.TAIWAN);
		}else {
			formatter = DateTimeFormatter.ofPattern(isotime_pattern, Locale.ENGLISH);
		}		
		
		LocalDate dateTime = LocalDate.parse(data_spec_str, formatter);
		System.out.println(dateTime);
	}
	
	private void DayInWeek_check(LocalDate dateNow, LocalDate weekStart, LocalDate weekEnd) throws Exception
	{		
		
		if((dateNow.isAfter(weekStart)) && (dateNow.isBefore(weekEnd))){
			System.out.println("This week");
		}else{
			System.out.println("out of this week");
		}
	}
	
	private void WeekNoofYear()
	{
		// Today		
		Calendar cal = Calendar.getInstance();
		System.out.println("Current week of month is : " + (cal.get(Calendar.WEEK_OF_MONTH)+1));
		System.out.println("Current Date of this month is : " + cal.get(Calendar.WEEK_OF_YEAR));
		cal.add(Calendar.WEEK_OF_MONTH, 1);
		System.out.println("date after one week : " + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DATE) + "-"
				+ cal.get(Calendar.YEAR));
	}	
	
	private void WeekRange(int range)
	{
		int week_index; 
		Calendar cal = Calendar.getInstance();		
		System.out.println("Current week of year is : " + cal.get(Calendar.WEEK_OF_YEAR));
		week_index = cal.get(Calendar.WEEK_OF_YEAR);
		
		// This Week Start day
		int DAY_OF_WEEK = cal.get(Calendar.DAY_OF_WEEK);
		Calendar cal_Week_Start = Calendar.getInstance();
		cal_Week_Start.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
		Date date_format_Week_Start = cal_Week_Start.getTime();
		System.out.println("Week Start: "+date_format_Week_Start);
		// This Week End day
		Calendar cal_Week_End = cal_Week_Start;
		cal_Week_End.set(Calendar.DAY_OF_WEEK, +7);
		Date date_format_Week_End = cal_Week_End.getTime();
		System.out.println("Week End: "+date_format_Week_End);	
		
		Calendar Newcal_Week_Start = cal_Week_Start;

		for (int i = 0; i <= range; i++) 
		{
			if((week_index-i)<0) {				
				Newcal_Week_Start.set(Calendar.YEAR, cal.get(Calendar.YEAR) -1);
				week_index = Newcal_Week_Start.getWeeksInWeekYear() + 1;
				//System.out.println(week_index-i+"	"+cal.getTime());
			}
			
			//System.out.println(week_index-i);
			Newcal_Week_Start.set(Calendar.WEEK_OF_YEAR, week_index - i);
			Newcal_Week_Start.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
			Date Newdate_format_Week_Start = Newcal_Week_Start.getTime();
			Newdate_format_Week_Start = Set_Time_Zero(Newdate_format_Week_Start);

			Calendar Newcal_Week_End = cal_Week_Start;			
			Newcal_Week_End.set(Calendar.DAY_OF_WEEK, +7);
			Date Newdate_format_Week_End = Newcal_Week_End.getTime();			
			Newdate_format_Week_End = Set_Time_End(Newdate_format_Week_End);

			System.out.println((week_index-i)+"	"+Newdate_format_Week_Start+"	"+Newdate_format_Week_End);
		}
		
	}
	
	private void MonthNoofYear()
	{
		// Today		
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;
		// System.out.println("Current month of year is : " + cal.get(Calendar.MONTH));
		System.out.println(month);
	}
	
	private void MonthRange(int range)
	{											
		// This Month Start day
		Calendar cal = Calendar.getInstance();
		int DAY_OF_MONTH = cal.get(Calendar.DAY_OF_MONTH);
		cal.add(Calendar.MONTH, 1);
		cal.add(Calendar.DAY_OF_MONTH, -DAY_OF_MONTH+1);
		Date Newdate_format_month_Start = cal.getTime();
		Newdate_format_month_Start = Set_Time_Zero(Newdate_format_month_Start); 

		int totalday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
				
		Calendar calRange = cal;
		Calendar calAdd = Calendar.getInstance();
		
		for(int i=0; i<=range; i++)
		{
			// Month Start day
			calRange.add(calRange.MONTH, -1);
			
			DAY_OF_MONTH = cal.get(Calendar.DAY_OF_MONTH);		
			calRange.add(Calendar.DAY_OF_MONTH, -DAY_OF_MONTH+1);
			
			Date Newdate_month_Start = calRange.getTime();
			Newdate_month_Start = Set_Time_Zero(Newdate_month_Start);
			//System.out.println(Newdate_month_Start);
						
			totalday = calRange.getActualMaximum(calRange.DAY_OF_MONTH);
			
			// Month End day
			calAdd = calRange;
			calAdd.set(calRange.DAY_OF_MONTH, totalday);
			
			//calAdd.add(calRange.DAY_OF_MONTH, totalday);
			Date Newdate_month_End = calAdd.getTime();
			Newdate_month_End = Set_Time_End(Newdate_month_End);
			
			System.out.println(Newdate_month_Start+"	"+Newdate_month_End+"	"+totalday);			
		}
	}
	
	private Date Set_Time_Zero(Date inputdate)
    {
    	 Calendar cal = Calendar.getInstance();  
         cal.setTime(inputdate);
         cal.set(Calendar.HOUR_OF_DAY, 0);  
         cal.set(Calendar.MINUTE, 0);  
         cal.set(Calendar.SECOND, 0);  
         cal.set(Calendar.MILLISECOND, 0);  
         
         return cal.getTime(); 
    }
	
	private Date Set_Time_End(Date inputdate)
	{
		Calendar cal = Calendar.getInstance();  
        cal.setTime(inputdate);
        cal.set(Calendar.HOUR_OF_DAY, 23);  
        cal.set(Calendar.MINUTE, 59);  
        cal.set(Calendar.SECOND, 59);  
        cal.set(Calendar.MILLISECOND, 999);  
        
        return cal.getTime();
	}
	
	private boolean isChinese(String con)
	{
		for (int i = 0; i < con.substring(0, 3).length(); i++) {
			if (!Pattern.compile("[\u4e00-\u9fa5]").matcher(
					String.valueOf(con.charAt(i))).find()) {
				return false;
			}
		}

		return true;
	}
	
	public static void main(String[] args)
	{
		try {
			DateTime_function df = new DateTime_function();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
