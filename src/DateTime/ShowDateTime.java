package DateTime;

/*
 * Show DataTime
 * version: April 16, 2019 11:54 AM
 * Last revision: August 02, 2019 01:36 PM	
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ShowDateTime {

	//private String DateTimeFormat = "yyyy/MM/dd hh:mm:ss";
	private String DateTimeFormat = "EEE MMM dd HH:mm:ss zzz yyyy";
	
	public ShowDateTime() throws Exception
	{
		// Function 1
//		SimpleDateFormat sdFormat = new SimpleDateFormat(DateTimeFormat);
//		Date date = new Date();
//		String strDate = sdFormat.format(date);
//		System.out.println(strDate);
		
		// Function 2
//		TimeZone tz = TimeZone.getTimeZone("Asia/Taipei");
//		DateFormat df = new SimpleDateFormat(DateTimeFormat);
//		df.setTimeZone(tz);
//		String nowAsISO = df.format(new Date());
//		System.out.println(nowAsISO);
		
		// Function 3
		
		
		SimpleDateFormat myDate = new SimpleDateFormat(DateTimeFormat);
		myDate.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));
		String nowAsISO = myDate.format(new Date());
		Date newDate = myDate.parse(nowAsISO);
		System.out.println(newDate);
	}
	
	public static void main(String[] args)
	{
		try {
			ShowDateTime show = new ShowDateTime();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
