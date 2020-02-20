package DateTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Show DataTime
 * version: February 20, 2020 05:11 PM
 * Last revision: February 20, 2020 05:20 PM	
 * 
 * Author : Chao-Hsuan Ke 
 * 
 */

public class StringtoDate 
{
	String basic_pattern = "yyyyMMdd";
	
	
	public StringtoDate() throws Exception
	{
		// Method 1
		//String dateString = "20010-03-02 20:25:58";
		
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		
//		Date date = sdf.parse(dateString);
//		System.out.println(date);
		
		// Method 2
		String dateStr = "20200220";
		DateFormat sdf = new SimpleDateFormat(basic_pattern);
		Date date = sdf.parse(dateStr);
		
		System.out.println(date.toString());
	}
	
	public static void main(String[] args) 
	{
		try {
			StringtoDate st = new StringtoDate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
