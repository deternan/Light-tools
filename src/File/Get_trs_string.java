package File;

/*
 * trs to String 
 *  
 * 
 * version: June 08, 2017 02:55 PM
 * Last revision: June 08, 2017 02:55 PM
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Get_trs_string 
{
	// Defined
	private double Frequency_gap;

	// Report
	private String defined_report = "<Section type=\"report\"";
//	private String defined_endtime = "endTime";
	private String endtime_regEx = ".*endTime=\"([0-9]+\\.?[0-9]?).*";
	private Pattern endtime_pattern;
	private Matcher endtime_match;
	private double endtime_value;
	// Turn Section check
	private String defined_turnstart = "<Turn speaker";
	private String defined_turnstop = "</Turn>";
	private boolean section_start = false;
	private boolean section_end = false;
	private StringBuilder result = new StringBuilder();
		// Regression
		// Section endtime
		private String defined_secendTime_s = "endTime=\"";
		private String defined_secendTime_e = "<Sync";
		private double sec_endtime_value;
		// Section text
		private String defined_text_s = "/>";
		private String defined_text_e = "</Turn>";
		private String sec_text_str;
	
	public Get_trs_string(String lvcsr_path_file) throws Exception
	{		
		String line = "";
		
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(lvcsr_path_file), "UTF8"));
		while ((line = in.readLine()) != null) 
		{
			if(line.contains("<") == false){
				System.out.println(line);
			}			
        }
		in.close();			
		System.out.println("Finished");
	}
	
	public static void main(String[] args) throws Exception
	{				
		String lvcsr_path_file = "";		
		Get_trs_string L2J = new Get_trs_string(lvcsr_path_file);
	}
	
}
