package Application.subtitle;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Time translation
 * 
 * version: November 15, 2017 01:22 PM
 * Last revision: November 15, 2017 04:45 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

public class sec_translation 
{
	private String time_str = "00:00:54,000";	
	
	// Regular expression
	private String pattern = "(\\d{2}):(\\d{2}):(\\d{2}),(\\d)+";
	private Pattern p;
	private Matcher m;
	
	// Total
	private int totalsecs = 0;
	private int hoursec;
	private int minsec;
	private int sec;
	
	public sec_translation()
	{
		p = Pattern.compile(pattern);
        m = p.matcher(time_str);
        while (m.find()) 
        {
            //System.out.println(m.group());
            // hour to sec
            hoursec = hour_to_sec(m.group(1));
            // min to sec
            minsec = min_to_sec(m.group(2));
            // 
            sec = Integer.parseInt(m.group(3));
            
            totalsecs = hoursec + minsec + sec;
            //System.out.println(hoursec + "	"+ minsec + "	"+ sec);
            System.out.println(totalsecs);
        }
		
	}
	
	private int hour_to_sec(String hour)
	{
		int secs;
		secs = Integer.parseInt(hour) * 60 * 60;
		
		return secs;
	}
	
	private int min_to_sec(String min)
	{
		int secs;		
		secs = Integer.parseInt(min) * 60;
		
		return secs;
	}
	
	public static void main(String args[])
	{
		sec_translation st = new sec_translation();
	}
	
}
