package Application.subtitle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Get time gap
 * 
 * version: November 15, 2017 10:48 AM
 * Last revision: November 15, 2017 05:29 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

public class timegap 
{
	// Read files
	private String folder_source = "";
	private String file = "";
	private BufferedReader bfr;
	// Time gap
	private String lastendtime_str;
	private String starttime_str;
	private boolean time_index;
	private int timegap;
	private String tag_ = "-->";
	// time translation
	private String pattern = "(\\d{2}):(\\d{2}):(\\d{2}),(\\d)+";
	private Pattern p;
	private Matcher m;
	private int totalsecs = 0;
	private int hoursec;
	private int minsec;
	private int sec;
	
	// Test
	private double total_timegap = 0;
	private double average_timegap = 0;
	private int sentence_num = 0;
	
	public timegap() throws Exception
	{
		System.getProperty("UTF-8");
		
		// Read file
		File folder = new File(folder_source);
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile()) {
				average_timegap = 0;
				total_timegap = 0;
				sentence_num = 0;
				System.out.println(file.getName());
				
				Parser_subtitle(folder_source + file.getName());				
				//System.out.println("-------------------------------------");
				
				// Display
//				sentence_num--;
//				average_timegap =  total_timegap / sentence_num;
//				System.out.println("average: " + average_timegap+"	"+total_timegap + "	"+ sentence_num);
			}
		}
	}
	
	private void Parser_subtitle(String source) throws Exception
	{
		String Line = "";
		boolean timegap_check;
		String endtime_temp = "";
		FileReader fr = new FileReader(source);
		bfr = new BufferedReader(fr);
		String temp;
		int count_index = 0;
		while((Line = bfr.readLine())!=null)
		{									
			//System.out.println(Line);
			timegap_check = Timegap_check(Line);
			timegap = 0;
			
			if(timegap_check == true){				
				
				if(count_index == 0){
					lastendtime_str = Line.substring(Line.indexOf(tag_)+tag_.length(), Line.length());
					starttime_str = Line.substring(Line.indexOf(tag_)+tag_.length(), Line.length());
					endtime_temp = lastendtime_str;
				}else{
					lastendtime_str = endtime_temp;
					starttime_str =  Line.substring(0, Line.indexOf(tag_));
					endtime_temp = Line.substring(Line.indexOf(tag_)+tag_.length(), Line.length());
				}
				timegap = Sting2time(starttime_str) - Sting2time(lastendtime_str);
				total_timegap += timegap;
				sentence_num++;
				
//				System.out.println(Line+"			"+starttime_str+"	"+lastendtime_str+"	"+timegap);
				
				count_index++;
			}
		}
		
		fr.close();
		bfr.close();
	}
	
	private boolean Timegap_check(String input_)
	{
		boolean timegap = false;
		
		if(input_.contains(tag_)){
			timegap = true;
		}
		
		return timegap;
	}
	
	private int Sting2time(String time_)
	{
		totalsecs = 0;
		int return_totalsecs = totalsecs; 
		p = Pattern.compile(pattern);
        m = p.matcher(time_);
        
        while (m.find()) 
        {            
            // hour to sec
            hoursec = hour_to_sec(m.group(1));
            // min to sec
            minsec = min_to_sec(m.group(2));
            // 
            sec = Integer.parseInt(m.group(3));            
            totalsecs = hoursec + minsec + sec;    
            return_totalsecs = totalsecs;            
        }
        
        return totalsecs;
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
		try {
			timegap srt_tg = new timegap();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
