package DateTime;

/*
 * version: February 22, 2018 06:23 PM
 * Last revision: July 01, 2019 00:26 AM
 * 
 * Author : Chao-Hsuan Ke
 * E-mail : phelpske.dev at gmail dot com
 * 
 */

import java.sql.Timestamp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.lucene.document.DateTools;
import org.apache.lucene.document.DateTools.Resolution;

public class DateTime_function {
	private String basic_pattern = "yyyyMMdd";
	DateFormat df = new SimpleDateFormat(basic_pattern, Locale.getDefault());

	// Pattern
	private String isotime_pattern = "EEE MMM dd HH:mm:ss zzz yyyy"; // Thu Nov 30 16:34:55 CST 2017

	private Pattern p;
	private Matcher m;

	// Week days
	LocalDate WeekstartDate;
	LocalDate WeekendDate;

	// private String data_spec_str = "星期五 十二月 01 12:17:04 TST 2017";
	private String data_spec_str = "Tue Jul 24 14:38:50 CST 2018";

	public DateTime_function() throws Exception {
		// time to string
		// example : 2018-02
		// String date_str = Time_to_String("2018-09");
		// System.out.println(date_str);

		// Week Days Range(2018,02,21);
		// ArrayList<String> day_array;
		// day_array = Date_separation("20190624");
		// Week_Days(Integer.parseInt(day_array.get(0)),
		// Integer.parseInt(day_array.get(1)), Integer.parseInt(day_array.get(2)));

		// Translation
		// FormatTranslation();

		// Today
		//Today();
		// // Date Parser
		// ISODateParser();
		// // Date comparison
		// String today_temp = "2018-09-09";
		// DateTimeFormatter formatter = DateTimeFormatter.ofPattern(basic_pattern,
		// Locale.TAIWAN);
		// LocalDate dateNow = LocalDate.parse(today_temp, formatter);
		// System.out.println(dateNow);
		// DayInWeek_check(dateNow, WeekstartDate, WeekendDate);

		// Today (hours range)
		// TodayHoursRange();
		// setting date (hours range)
		// DateHoursRange(2019,03,05);
		// Week of this Year
		// WeekNoofYear();
		// Week range date
		// WeekRange(10);
		// Month of this year
		// WeekNoofYear();
		// MonthRange(6);
		// WeekRange (based on specific date)
		// WeekRange_basedonSpecificDate("20190624", 10);

		// DateRange
		// int daysgap2 = getDayLength("20181215", "20181216");
		// daysgap2++;
		// System.out.println(daysgap2);
		// Before Date
		// String todayStr = "20190523";
		// // This week
		// String thisweekStartDate = getBeforeDateStrType(todayStr, 6);
		// String thisweekEndDate = todayStr;
		// System.out.println(thisweekStartDate+" "+thisweekEndDate);
		// // Last week
		// String lastweekStartDate = getBeforeDateStrType(thisweekStartDate, 7);
		// String lastweekEndDate = getBeforeDateStrType(thisweekStartDate, 1);
		// System.out.println(lastweekStartDate+" "+lastweekEndDate);

		// list all date
		// ListAllDate();
		// Month Increment
		//MonthIncrement();
		// Month gap
//			Date today = Calendar.getInstance().getTime();
//			SimpleDateFormat sdf  = new SimpleDateFormat(basic_pattern);
//	        String todayStr = sdf.format(today);
//			String string_date = "20190618";
//			SimpleDateFormat f = new SimpleDateFormat(basic_pattern); // yyyy-MM-dd
//			Date specificDate = f.parse(string_date);
		//MonthDiff(today, specificDate);
			//MonthDiff(todayStr, string_date);
		// AD to TW
		convertTWDate("2018/07/13");
		
	}

	private void FormatTranslation() throws Exception {
		// long to Date
		long longDate = 1560219996522L;
		Date timeTmp = new Timestamp(longDate);
		System.out.println(longDate + "	" + timeTmp);

		// Date to long
		String string_date = "2019-06-21";
		SimpleDateFormat f = new SimpleDateFormat(basic_pattern); // yyyy-MM-dd
		Date d = f.parse(string_date);
		long milliseconds = d.getTime();
		System.out.println(milliseconds);
	}

	private String Time_to_String(String input) {
		String year_str = input.substring(0, input.indexOf("-"));
		String month_str = input.substring(input.indexOf("-") + 1, input.length());
		int year = Integer.parseInt(year_str);
		int month = Integer.parseInt(month_str);

		Calendar myCal = Calendar.getInstance();
		myCal.set(Calendar.YEAR, year);
		myCal.set(Calendar.MONTH, month - 1);
		myCal.set(Calendar.DAY_OF_MONTH, 01 + 1);
		myCal.set(Calendar.HOUR_OF_DAY, 0);
		myCal.set(Calendar.MINUTE, 0);
		myCal.set(Calendar.SECOND, 0);
		Date theDate = myCal.getTime();
		DateTools.dateToString(theDate, Resolution.MONTH);
		// System.out.println(DateTools.dateToString(theDate, Resolution.DAY));

		return DateTools.dateToString(theDate, Resolution.DAY);
	}

	private ArrayList Date_separation(String input) {
		Date return_date = null;
		ArrayList<String> obj = new ArrayList<String>();

		// String pattern = "([\\d]{4})-([\\d]{2})-([\\d]{2})";
		String pattern = "([\\d]{4})([\\d]{2})([\\d]{2})";

		p = Pattern.compile(pattern);
		m = p.matcher(input);

		while (m.find()) {
			obj.add(m.group(1));
			obj.add(m.group(2));
			obj.add(m.group(3));
		}

		return obj;
	}

	private void TodayHoursRange() {
		// 0 hour
		Calendar today0 = Calendar.getInstance();
		today0.set(Calendar.HOUR_OF_DAY, 0);
		today0.set(Calendar.MINUTE, 0);
		today0.set(Calendar.SECOND, 0);
		today0.set(Calendar.MILLISECOND, 0);

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

	private void DateHoursRange(int year, int month, int day) throws Exception {
		Calendar setdate = Calendar.getInstance();
		setdate.set(year, month, day);

		Calendar today0 = setdate.getInstance();
		today0.set(setdate.HOUR_OF_DAY, 0);
		today0.set(setdate.MINUTE, 0);
		today0.set(setdate.SECOND, 0);
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

	private void Week_Days(int year, int month, int day) {
		Calendar myCal = Calendar.getInstance();
		myCal.set(Calendar.YEAR, year);
		myCal.set(Calendar.MONTH, month - 1);
		myCal.set(Calendar.DAY_OF_MONTH, day);
		myCal.getTime();

		// DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
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

	private void Today() {
		Date today = Calendar.getInstance().getTime();
		String today_str = df.format(today.getTime());
		System.out.println(today_str);
	}

	private void ISODateParser() throws Exception {
		boolean chinesecheck;
		chinesecheck = isChinese(data_spec_str);
		// System.out.println(check);
		DateTimeFormatter formatter;
		if (chinesecheck == true) {
			formatter = DateTimeFormatter.ofPattern(isotime_pattern, Locale.TAIWAN);
		} else {
			formatter = DateTimeFormatter.ofPattern(isotime_pattern, Locale.ENGLISH);
		}

		LocalDate dateTime = LocalDate.parse(data_spec_str, formatter);
		System.out.println(dateTime);
	}

	private void DayInWeek_check(LocalDate dateNow, LocalDate weekStart, LocalDate weekEnd) throws Exception {

		if ((dateNow.isAfter(weekStart)) && (dateNow.isBefore(weekEnd))) {
			System.out.println("This week");
		} else {
			System.out.println("out of this week");
		}
	}

	private void WeekNoofYear() {
		// Today
		Calendar cal = Calendar.getInstance();
		System.out.println("Current week of month is : " + (cal.get(Calendar.WEEK_OF_MONTH) + 1));
		System.out.println("Current Date of this month is : " + cal.get(Calendar.WEEK_OF_YEAR));
		cal.add(Calendar.WEEK_OF_MONTH, 1);
		System.out.println("date after one week : " + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DATE) + "-"
				+ cal.get(Calendar.YEAR));
	}

	private void WeekRange(int range) {
		int week_index;
		Calendar cal = Calendar.getInstance();
		System.out.println("Current week of year is : " + cal.get(Calendar.WEEK_OF_YEAR));
		week_index = cal.get(Calendar.WEEK_OF_YEAR);

		// This Week Start day
		int DAY_OF_WEEK = cal.get(Calendar.DAY_OF_WEEK);
		Calendar cal_Week_Start = Calendar.getInstance();
		cal_Week_Start.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
		Date date_format_Week_Start = cal_Week_Start.getTime();
		System.out.println("Week Start: " + date_format_Week_Start);
		// This Week End day
		Calendar cal_Week_End = cal_Week_Start;
		cal_Week_End.set(Calendar.DAY_OF_WEEK, +7);
		Date date_format_Week_End = cal_Week_End.getTime();
		System.out.println("Week End: " + date_format_Week_End);

		Calendar Newcal_Week_Start = cal_Week_Start;

		for (int i = 0; i <= range; i++) {
			if ((week_index - i) < 0) {
				Newcal_Week_Start.set(Calendar.YEAR, cal.get(Calendar.YEAR) - 1);
				week_index = Newcal_Week_Start.getWeeksInWeekYear() + 1;
				// System.out.println(week_index-i+" "+cal.getTime());
			}

			// System.out.println(week_index-i);
			Newcal_Week_Start.set(Calendar.WEEK_OF_YEAR, week_index - i);
			Newcal_Week_Start.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
			Date Newdate_format_Week_Start = Newcal_Week_Start.getTime();
			Newdate_format_Week_Start = Set_Time_Zero(Newdate_format_Week_Start);

			Calendar Newcal_Week_End = cal_Week_Start;
			Newcal_Week_End.set(Calendar.DAY_OF_WEEK, +7);
			Date Newdate_format_Week_End = Newcal_Week_End.getTime();
			Newdate_format_Week_End = Set_Time_End(Newdate_format_Week_End);

			System.out.println((week_index - i) + "	" + Newdate_format_Week_Start + "	" + Newdate_format_Week_End);
		}

	}

	private void MonthNoofYear() {
		// Today
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;
		// System.out.println("Current month of year is : " + cal.get(Calendar.MONTH));
		System.out.println(month);
	}

	private void MonthRange(int range) {
		// This Month Start day
		Calendar cal = Calendar.getInstance();
		int DAY_OF_MONTH = cal.get(Calendar.DAY_OF_MONTH);
		cal.add(Calendar.MONTH, 1);
		cal.add(Calendar.DAY_OF_MONTH, -DAY_OF_MONTH + 1);
		Date Newdate_format_month_Start = cal.getTime();
		Newdate_format_month_Start = Set_Time_Zero(Newdate_format_month_Start);

		int totalday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		Calendar calRange = cal;
		Calendar calAdd = Calendar.getInstance();

		for (int i = 0; i <= range; i++) {
			// Month Start day
			calRange.add(calRange.MONTH, -1);

			DAY_OF_MONTH = cal.get(Calendar.DAY_OF_MONTH);
			calRange.add(Calendar.DAY_OF_MONTH, -DAY_OF_MONTH + 1);

			Date Newdate_month_Start = calRange.getTime();
			Newdate_month_Start = Set_Time_Zero(Newdate_month_Start);
			// System.out.println(Newdate_month_Start);

			totalday = calRange.getActualMaximum(calRange.DAY_OF_MONTH);

			// Month End day
			calAdd = calRange;
			calAdd.set(calRange.DAY_OF_MONTH, totalday);

			// calAdd.add(calRange.DAY_OF_MONTH, totalday);
			Date Newdate_month_End = calAdd.getTime();
			Newdate_month_End = Set_Time_End(Newdate_month_End);

			System.out.println(Newdate_month_Start + "	" + Newdate_month_End + "	" + totalday);
		}
	}

	private void WeekRange_basedonSpecificDate(String DateStr, int BeforeNum) throws Exception {
		for (int i = 1; i <= BeforeNum; i++) {
			Date beforeDays = getBeforeDate(DateStr, (i * 7) - 1);
			String aa = DateTools.dateToString(beforeDays, Resolution.DAY);
			Date newnew = getBeforeDate(aa, -7);

			System.out.println(beforeDays + "	" + aa + "	" + newnew);
			// System.out.println(beforeDays.getYear()+" "+beforeDays.getMonth()+"
			// "+beforeDays.getDay());
		}
	}

	private Date getBeforeDate(String dateString, int beforeDays) throws ParseException {

		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date inputDate = dateFormat.parse(dateString);
		Calendar cal = Calendar.getInstance();
		cal.setTime(inputDate);
		int inputDayOfYear = cal.get(Calendar.DAY_OF_YEAR);
		cal.set(Calendar.DAY_OF_YEAR, inputDayOfYear - beforeDays);

		return cal.getTime();
	}

	private String getBeforeDateStrType(String dateString, int beforeDays) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date dt = sdf.parse(dateString);
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(dt);
		// rightNow.add(Calendar.YEAR,-1);
		// rightNow.add(Calendar.MONTH,3);
		rightNow.add(Calendar.DAY_OF_YEAR, -beforeDays);
		Date dt1 = rightNow.getTime();
		String reStr = sdf.format(dt1);
		// System.out.println(reStr);

		return reStr;
	}

	private int getDayLength(String start_date, String end_date) throws Exception {

		String DATE_FORMAT_NORMAL = "yyyyMMdd";
		Date fromDate = getStrToDate(start_date, DATE_FORMAT_NORMAL);
		Date toDate = getStrToDate(end_date, DATE_FORMAT_NORMAL);
		long from = fromDate.getTime();
		long to = toDate.getTime();

		int day = (int) ((to - from) / (24 * 60 * 60 * 1000));

		return day;
	}

	private Date getStrToDate(String date, String fomtter) throws Exception {
		DateFormat df = new SimpleDateFormat(fomtter);

		return df.parse(date);
	}

	private Date Set_Time_Zero(Date inputdate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(inputdate);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return cal.getTime();
	}

	private Date Set_Time_End(Date inputdate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(inputdate);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);

		return cal.getTime();
	}

	private boolean isChinese(String con) {
		for (int i = 0; i < con.substring(0, 3).length(); i++) {
			if (!Pattern.compile("[\u4e00-\u9fa5]").matcher(String.valueOf(con.charAt(i))).find()) {
				return false;
			}
		}

		return true;
	}

	private void ListAllDate() throws Exception {
		Calendar cal = Calendar.getInstance();
		String start = "2019-05-01";
		String end = "2019-07-31";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dBegin = sdf.parse(start);
		Date dEnd = sdf.parse(end);
		List<Date> lDate = findDates(dBegin, dEnd);
		for (Date date : lDate) {
			System.out.println(sdf.format(date));
		}
	}

	private static List<Date> findDates(Date dBegin, Date dEnd) {
		List lDate = new ArrayList();
		lDate.add(dBegin);
		Calendar calBegin = Calendar.getInstance();

		calBegin.setTime(dBegin);
		Calendar calEnd = Calendar.getInstance();

		calEnd.setTime(dEnd);

		while (dEnd.after(calBegin.getTime())) {

			calBegin.add(Calendar.DAY_OF_MONTH, 1);
			lDate.add(calBegin.getTime());
		}
		return lDate;
	}

	private void MonthIncrement() throws Exception{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
        String startDate="201805";
        int addMonths = 12;
        
        for(int i=0; i<=addMonths; i++){
        	//Thread.sleep(10000);
        	Date dt=sdf.parse(startDate);
        	Calendar rightNow = Calendar.getInstance();
        	rightNow.setTime(dt);
    		if(i != 0){
    			rightNow.add(Calendar.MONTH,1);
    		}
        	Date dt1=rightNow.getTime();
        	String reStr = sdf.format(dt1);
        	System.out.println(reStr);
        	startDate=reStr;
        }
	}
	
	private void MonthDiff(String d1, String d2) throws Exception
	{
        SimpleDateFormat sdf  = new SimpleDateFormat(basic_pattern);
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(d1));
        int year1 = c.get(Calendar.YEAR);
        int month1 = c.get(Calendar.MONTH);
         
        c.setTime(sdf.parse(d2));
        int year2 = c.get(Calendar.YEAR);
        int month2 = c.get(Calendar.MONTH);
         
        int result;
        if(year1 == year2) {
            result = month1 - month2;
        } else {
            result = 12*(year1 - year2) + month1 - month2;
        }
        System.out.println(result);
 	}
	
	private void convertTWDate(String AD) {
	    SimpleDateFormat df4 = new SimpleDateFormat("yyyy/MM/dd");
	    SimpleDateFormat df2 = new SimpleDateFormat("MMdd");
	    Calendar cal = Calendar.getInstance();
	    String TWDate = "";
	    try {
	        cal.setTime(df4.parse(AD));
	        cal.add(Calendar.YEAR, -1911);
	        TWDate = Integer.toString(cal.get(Calendar.YEAR)) + df2.format(cal.getTime());
	        //return TWDate;
	        System.out.println(TWDate);
	    } catch (Exception e) {
	        e.printStackTrace();
	        //return null;
	    }
	}
	
	public static void main(String[] args) {
		try {
			DateTime_function df = new DateTime_function();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
