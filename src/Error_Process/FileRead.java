package Error_Process;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/*
 * Error record (file read)
 * 
 * version: October 18, 2017 10:55 AM
 * Last revision: October 18, 2017 10:55 AM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 */

public class FileRead 
{
	private String Errorlog_folder = "";
	private String Errorlog_file = "";
	
	public FileRead()
	{
		try{
			
			/*	Read file code
			 * 
			 *
			 */
			
		}catch (Exception e){
			
			try {
				Write_errorlog();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
	
	private void Write_errorlog() throws Exception
	{
		String sMsg = "";
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm"); 
		TimeZone timeZoneParis = TimeZone.getTimeZone("Asia/Taipei"); 
		Locale localeEN = Locale.TAIWAN; 
		Date curDate = new Date(); 
		dateFormat.setTimeZone(timeZoneParis); 		
		sMsg = curDate + "	Read file Error";
		
		//BufferedWriter writer;
		FileWriter fw = new FileWriter(Errorlog_folder + Errorlog_file, true);
        fw.write("\n" + sMsg);
        fw.close();
	}
	
}
