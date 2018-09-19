package DateTime;

/*
 * version: February 22, 2018 06:23 PM
 * Last revision: September 19, 2018 03:49 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
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
						
		//Week_Days(2018,02,21);
		ArrayList<String> day_array;
		day_array = Date_separation("2018-09-01");
		Week_Days(Integer.parseInt(day_array.get(0)), Integer.parseInt(day_array.get(1)), Integer.parseInt(day_array.get(2)));
		
		// Today
		Today();
		
		// Date Parser		
		ISODateParser();
		
		// Date comparison
		String today_temp = "2018-09-09";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(basic_pattern, Locale.TAIWAN);
		LocalDate dateNow = LocalDate.parse(today_temp, formatter);
		System.out.println(dateNow);
		DayInWeek_check(dateNow, WeekstartDate, WeekendDate);
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
