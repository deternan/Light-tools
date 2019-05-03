package Json;

/*
 * Json format check
 * version: May 03, 2019 05:33 PM
 * Last revision: May 03, 2019 05:43 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

/*
 * JAR
 * jackson-databind.2.9.8
 * 
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.alibaba.fastjson.JSONObject;

public class JSON_formatCheck {

	private String folder_source = "D";
	private BufferedReader bfr;
	
	
	public JSON_formatCheck() throws Exception
	{
		File folder = new File(folder_source);
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
		    if (file.isFile()) {
// 		        System.out.println(file.getName());
		        		        
		        // Read files
		        ReadFile(folder_source + file.getName(), file.getName());
		    }
		}
	}
	
	private void ReadFile(String path, String filename) throws Exception
	{
		FileReader fr = new FileReader(path);
		bfr = new BufferedReader(fr);
		String Line;
		String allText = "";
		while((Line = bfr.readLine())!=null)
		{								
			allText += Line;			
		}
		fr.close();
		bfr.close();	
		
		// check format
		boolean checkTag;
		checkTag = check(allText);
		
		System.out.println(filename+"	"+checkTag);
	}
	
	private boolean check(String jsonStr)
	{
		 try {
		        JSONObject jsonobj = JSONObject.parseObject(jsonStr);
		        return  true;
		   } catch (Exception e) {
		        return false;
		  }
	}
	
	public static void main(String[] args) {
		
		try {
			JSON_formatCheck json_check = new JSON_formatCheck();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
