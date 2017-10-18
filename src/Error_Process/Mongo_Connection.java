package Error_Process;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/*
 * Error record (MongoDB connection)
 * 
 * version: October 18, 2017 11:24 AM
 * Last revision: October 18, 2017 11:24 AM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 */

public class Mongo_Connection 
{
	private String Errorlog_folder = "";
	private String Errorlog_file = "";
	
	public Mongo_Connection()
	{
		try {

			/*
			 * MongoDB connection
			 */

		} catch (Exception e) {

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
		sMsg = curDate + "	connected MongoDB Error";
		
		//BufferedWriter writer;
		FileWriter fw = new FileWriter(Errorlog_folder + Errorlog_file, true);
        fw.write("\n" + sMsg);
        fw.close();
	}
	
}
