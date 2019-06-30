package Files;

/*
 * trs to Json 
 * output : words counnt
 * 
 * version: October 31, 2016	09:41 AM
 * Last revision: October 31, 2016	04:38 PM
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class trs2Json_wordcount 
{
	// Defined
	private double Frequency_gap;
	// Statistical
		// All
		private int Words_time_all[][];		// Speak time
		private int Words_count_all[][];		// Speak words count
		
	
	// Speaker	
	private String defined_speaker = "<Speaker id=\"";
	private String speaker_regEx = "<Speaker id=\"(spk[0-9]?).*";
	private Pattern speaker_pattern;
	private Matcher speaker_match;
	private double speaker_value;
	private int speaker_number = 0;
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
		// Section speaker
		private String defined_sec_speaker_s = "<Turn speaker=\"";
		private String defined_sec_speaker_e = "\" startTime";
		private String sec_speaker_str;

	// JSON
	private JSONObject json_all = new JSONObject();
	private JSONObject obj;
	private JSONArray list;
	
	// Output
	private String OUTPUT_FILE;
	
	public trs2Json_wordcount(String lvcsr_path_file, double Frequency_gap, String OUTPUT_FILE) throws Exception
	{		
		this.Frequency_gap = Frequency_gap;
		this.OUTPUT_FILE = OUTPUT_FILE;
		FileWriter file = new FileWriter(this.OUTPUT_FILE);
				
		// JSON array
			list = new JSONArray();		
		
		String line = "";
		
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(lvcsr_path_file), "UTF8"));
		while ((line = in.readLine()) != null) 
		{
            // Speaker
			Speaker(line);
			// Report			
			Report(line);
			// Section
			Turn_section(line);
			
			//Time_Parser(line);
			//Text_Parser(line);
        }
		in.close();
		
		for(int j=0; j<Words_time_all[0].length; j++)
		{
			// All			
			JSON_generation("Speak_All", Words_time_all[0][j], Words_count_all[0][j], ((j+1)*Frequency_gap));			
			// speak 1
			//System.out.println(Words_time_all[1][j]+"	"+Words_count_all[1][j]);
			// speak 2
			//System.out.println(Words_time_all[2][j]+"	"+Words_count_all[2][j]);				
		}					
				
		// JSON (all)
		json_all.put("All_Frequency", list);
		file.write(json_all.toJSONString());
		file.close();
		
		System.out.println("Finished");
	}
	
	private void Speaker(String line)
	{
		if(line.contains(defined_speaker)){
			
			speaker_pattern = Pattern.compile(speaker_regEx);
			speaker_match = speaker_pattern.matcher(line);
			
			if(speaker_match.matches()){				
				speaker_number++;
			}
		}
	}
	
	private void Report(String line)
	{
		
		if(line.contains(defined_report))
		{			
			endtime_pattern = Pattern.compile(endtime_regEx);
			endtime_match = endtime_pattern.matcher(line);
			if(endtime_match.matches())
			{				
				endtime_value = Double.parseDouble(endtime_match.group(1).toString());				
			}
			
			// Initial
			Words_time_all = new int[speaker_number+1][(int) (endtime_value/Frequency_gap)];
			Words_count_all = new int[speaker_number+1][(int) (endtime_value/Frequency_gap)];			
		}
		
	}
	
	private void Turn_section(String line)
	{
		// Start
		if(line.indexOf(defined_turnstart) == 0){
			section_start = true;
			section_end = false;
		}
		// End
		if(line.indexOf(defined_turnstop) == 0){
			result.append(line);
			section_end = true;
			section_start = false;			
			
				// Parser Time & Text
				Section_Time_Text_Parser();
			
			// Clear
			result.delete(0, result.length());
		}
		
		if(section_start == true){
			result.append(line+"\n");
			//System.out.println(line);
		}
	}
	
	private void Section_Time_Text_Parser()
	{				
		// Speaker
			sec_speaker_str = result.toString().substring(defined_sec_speaker_s.length(), result.toString().indexOf(defined_sec_speaker_e));
		
		// endTime Parser			
			String temp = result.toString().substring(result.toString().indexOf(defined_secendTime_s)+defined_secendTime_s.length(), result.toString().indexOf(defined_secendTime_e)-3);
			//System.out.println(temp);
			sec_endtime_value = Double.parseDouble(temp);
			
		// Text Parser
			sec_text_str = result.toString().substring(result.toString().indexOf(defined_text_s)+defined_text_s.length()+1, result.toString().indexOf(defined_text_e)-1);			
			double word_temp = Words_count_Chinese(sec_text_str);
		
		
		for(int i=1; i<=speaker_number; i++)
		{
			if(("spk"+Integer.toString(i)).equalsIgnoreCase(sec_speaker_str)){
				//System.out.println(sec_speaker_str+"	"+i);
				for(int j=0; j< Words_time_all[i-1].length; j++)
				{
					//System.out.println(i*Frequency_gap);
					if(sec_endtime_value < ((j+1)*Frequency_gap)){
						Words_time_all[i][j]++;
						Words_count_all[i][j] += word_temp;
						
						Words_time_all[0][j]++;
						Words_count_all[0][j] += word_temp;
						break;
					}
				}
			}
		}
		
	}
	
	private int Words_count_Chinese(String sec_text_str)
	{
		//int wordcount = 0;
		int chinese = 0;
	    //int english= 0;
	    for (int i = 0; i < sec_text_str.length(); i++ ){
	        char c = sec_text_str.charAt(i);
	        if ((int) c < 256) {
	            //english ++;
	        } else {
	            chinese ++;
	        }        
	    }
	    
		return chinese;
	}
	
	private void JSON_generation(String user, int speak_time, int word_number, double time_gap)
	{		
		obj = new JSONObject();
		obj.put("User", user);
		obj.put("Time_Gap", time_gap);
		obj.put("Speak_time", speak_time);
		obj.put("Speak_words_number", word_number);
		
		list.add(obj);
	}
	
	
	public static void main(String[] args) throws Exception
	{
		/*
		// Defined
		//double Frequency_gap = 5;			// Initial = 5 sec
		String lvcsr_path_file = "C:\\Users\\Barry.Ke\\Desktop\\20160129.lvcsr.trs";
		//String lvcsr_path_file;
		double Frequency_gap;
		String OUTPUT_FILE ;
		
		if(args.length != 2){			
			System.out.println("Input Error");
		}else{
			
			lvcsr_path_file = args[0];
			Frequency_gap = Double.parseDouble(args[1]);		
			OUTPUT_FILE = lvcsr_path_file + ".json";
					
			// Check extension name
			String extension = "";
			if(lvcsr_path_file != null){
				int startIndex = lvcsr_path_file.lastIndexOf(46) + 1;
				int endIndex = lvcsr_path_file.length();
				extension = lvcsr_path_file.substring(startIndex, endIndex);			
			}
			
			boolean exercise_check = false;
			if(Frequency_gap>0){
				if(extension.equalsIgnoreCase("trs")){
					exercise_check = true;
				}else{
					System.out.println("The input file is wrong");
				}
			}else{
				System.out.println("The time gap format is wrong");				
			}
			
			if(exercise_check == true){
				try {
					Lvcsr2Json L2J = new Lvcsr2Json(lvcsr_path_file, Frequency_gap, OUTPUT_FILE);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		*/
		double Frequency_gap = 5;			// Initial = 5 sec
		String lvcsr_path_file = "C:\\Users\\Barry.Ke\\Desktop\\to Text\\subtitle\\Voice team meeting\\MMWM0066_2015-09-24_MeetingRoom2_mix2_16k_sennheiser.trs";
		String OUTPUT_FILE = "C:\\Users\\Barry.Ke\\Desktop\\MMWM0066_2015-09-24_MeetingRoom2.lvcsr.trs.json";
		trs2Json_wordcount L2J = new trs2Json_wordcount(lvcsr_path_file, Frequency_gap, OUTPUT_FILE);
	}
	
}
