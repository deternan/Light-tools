package DateTime;

/*
 * Show DataTime
 * version: April 16, 2019 11:54 AM
 * Last revision: April 16, 2019 12:04 PM	
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShowDateTime {

	public ShowDateTime()
	{
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		String strDate = sdFormat.format(date);
		System.out.println(strDate);
	}
	
	public static void main(String[] args)
	{
		ShowDateTime show = new ShowDateTime();
	}
	
}
