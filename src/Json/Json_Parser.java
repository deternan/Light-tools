package Json;

import java.io.BufferedReader;
import java.io.FileReader;

import org.json.JSONObject;

public class Json_Parser 
{
	private String read_file_path = "";
	private String read_file_name = "";
	private BufferedReader bfr;
	
	
	public Json_Parser() throws Exception
	{
		String Line = "";
		FileReader fr = new FileReader(read_file_path + read_file_name);
		BufferedReader bfr = new BufferedReader(fr);
		
		JSONObject obj;
		while ((Line = bfr.readLine()) != null) {
			
			obj = new JSONObject(Line);			
			System.out.println(obj.get("timeStamp"));			
		}
		
		fr.close();
		bfr.close();
	}
	
}
