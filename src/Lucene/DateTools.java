package Lucene;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.lucene.document.DateTools;

/*
 * DataTools (Lucene) 
 * 
 * version: January 24 20, 2018 02:03 PM
 * Last revision: January 24 20, 2018 02:03 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

public class DateTools 
{
	private String isotime_pattern = "EEE MMM dd HH:mm:ss zzz yyyy";		// Thu Nov 30 16:34:55 CST 2017
	
	private String time_1 = "Wed Aug 02 15:33:25 CST 2017";
	private String data_spec_str = "星期五 十二月 01 12:17:04 TST 2017";
	
	public DateTools()
	{
		Date date_format_spec = new SimpleDateFormat(isotime_pattern, Locale.ENGLISH).parse(time_1);
		//Date date_format_spec = new SimpleDateFormat(isotime_pattern, Locale.TRADITIONAL_CHINESE).parse(data_spec_str);
		System.out.println(date_format_spec);
		
		String dateStr = DateTools.dateToString(date_format_spec, DateTools.Resolution.MILLISECOND);
		System.out.println(dateStr);
	}
	
	public static void main(String []args)
	{
		DateTools DT = new DateTools();
	}
	
}
