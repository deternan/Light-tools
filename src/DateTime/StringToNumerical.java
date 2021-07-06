/*
 * Time. String to Numerical 
 * 
 * version: June 05, 2018 09:14 AM
 * Last revision: June 05, 2018 09:14 AM
 * 
 * Author : Chao-Hsuan Ke 
 * 
 */

package DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class StringToNumerical 
{
	private String isotime_pattern = "EEE MMM dd HH:mm:ss zzz yyyy";		// Thu Nov 30 16:34:55 CST 2017		
	private String time_1 = "Wed Aug 02 15:33:25 CST 2017";
	private String data_spec_str = "星期五 十二月 01 12:17:04 TST 2017";
	
	
	public StringToNumerical() throws Exception
	{
		Date date_format_spec = new SimpleDateFormat(isotime_pattern, Locale.ENGLISH).parse(time_1);
		//Date date_format_spec = new SimpleDateFormat(isotime_pattern, Locale.TRADITIONAL_CHINESE).parse(data_spec_str);
		System.out.println(date_format_spec);
		long milliseconds = date_format_spec.getTime();
		
		System.out.println(milliseconds);
	}
	
	public static void main(String []args)
	{
		try {
			StringToNumerical SN = new StringToNumerical();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
