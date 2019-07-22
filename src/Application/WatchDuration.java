package Application;

/*
 * watch duration
 * 
 * version: July 22, 2019 03:26 PM
 * Last revision: July 22, 2019 05:36 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

public class WatchDuration 
{
	
	String folder = "C:\\Users\\barry.ke\\Desktop\\";		// file folder
	String file = "jsonStr.json";							// JSON file
	private BufferedReader bfr;	
	
	String courseId;
	String userId;
	String verb;
	double timeAt;	
	String storedStr;
	
	// check duration
	String verb_f;
	String verb_e;
	double timeAt_f;
	double timeAt_e;
	String storedStr_f;
	String storedStr_e;
	
	double courseWatchDuration;
	
	// Temp
	String LinStr = "";
	
	boolean dateRepeat;
	
	//private String isotime_pattern = "EEE MMM dd HH:mm:ss zzz yyyy";
	private String isotime_pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
	
	public WatchDuration() throws Exception
	{
		ReadFile();
		
		JSONArray jsonarray = new JSONArray(LinStr);
		//System.out.println(jsonarray.length());
		for(int i=0; i<jsonarray.length(); i++) 
		{
			dateRepeat = false;
			courseWatchDuration = 0;
			
			JSONObject jsonobject = jsonarray.getJSONObject(i);			
			courseId = jsonobject.getString("courseId");
			userId = jsonobject.getString("userId");
						
			
			//System.out.println(courseId+"	"+userId);
			TimePointParsing(jsonobject.get("info").toString(), i);
			
			System.out.println(courseId+"	"+userId+"	"+courseWatchDuration);
		}
	}
	
	private void TimePointParsing(String objectStr, int index) throws Exception
	{		
		JSONArray jsonarray = new JSONArray(objectStr); 
		double watchdurationTmp = 0;
		//System.out.println(jsonarray.length());
		for(int i=0; i<jsonarray.length(); i++) {
						
			JSONObject jsonobject = jsonarray.getJSONObject(i);
			verb = jsonobject.getString("verb");
			timeAt = jsonobject.getDouble("timeAt");			
			storedStr = jsonobject.getString("stored");
			
			if(verb.equalsIgnoreCase("play") || verb.equalsIgnoreCase("initialplay")) {
				verb_f = verb;
				timeAt_f = timeAt;
				storedStr_f = storedStr;
				dateRepeat = false;
			}
			
			if(verb.equalsIgnoreCase("pause") || verb.equalsIgnoreCase("stop")) {
				
				if(dateRepeat == false) {
					verb_e = verb;
					timeAt_e = timeAt;
					storedStr_e = storedStr;
				}
				dateRepeat = true;
			}
			
//			System.out.println(index+"	"+storedStr+"	"+verb+"	"+timeAt+"	"+dateRepeat);
			if(dateRepeat) {
				
				boolean datacheck = false;
				if((storedStr_f!=null) && (storedStr_e!=null)) {
					datacheck = TimeGap(storedStr_f, storedStr_e);
				}
				
				if(datacheck) {
//					System.out.println(verb_f+"	"+timeAt_f+"	"+storedStr_f);
//					System.out.println(verb_e+"	"+timeAt_e+"	"+storedStr_e);
					if(timeAt_e >= timeAt_f) {
						watchdurationTmp = timeAt_e - timeAt_f;
					}
					courseWatchDuration += watchdurationTmp;
				}
			}
			
		}
	}	
	
	private boolean TimeGap(String storedStr_f, String storedStr_e) throws Exception
	{			
		DateFormat df1 = new SimpleDateFormat(isotime_pattern);		
		Date result_f = df1.parse(storedStr_f);
		Date result_e = df1.parse(storedStr_e);
		
		boolean response = DateTime_different(result_f, result_e);
		
		return response;
	}
	
	private boolean DateTime_different(Date data_now, Date data_comparison)
	{        
		boolean response = false;
		
        try {
            long diff = data_comparison.getTime() - data_now.getTime();
            
            //long diffSeconds = diff / 1000 % 60;
            //long diffMinutes = diff / (60 * 1000) % 60;
            //long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);

            if(diffDays == 0) {
            	response = true;
            }else{
            	response = false;
            }
            
            //System.out.print(diffDays + " days, ");
            //System.out.print(diffHours + " hours, ");
            //System.out.print(diffMinutes + " minutes, ");
            //System.out.print(diffSeconds + " seconds.");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
	}
	
	private void ReadFile() throws Exception
	{
		String Line = "";
		
		FileReader fr = new FileReader(folder + file);
		bfr = new BufferedReader(fr);
				
		//JSONObject obj;
		while((Line = bfr.readLine())!=null)
		{					
			LinStr += Line;						
		}
		fr.close();
		bfr.close();
	}
	
	public static void main(String args[])
	{
		try {
			WatchDuration WD = new WatchDuration();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
