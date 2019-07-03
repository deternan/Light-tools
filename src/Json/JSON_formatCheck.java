package Json;

/*
 * Json format check
 * version: May 03, 2019 05:33 PM
 * Last revision: June 03, 2019 11:59 PM
 * 
 * Author : Chao-Hsuan Ke
 * 
 */

/*
 * JAR
 * jackson-databind.2.9.8
 * gson-2.8.2.jar  
 * 
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class JSON_formatCheck {

	private String folder_source = "D";
	private BufferedReader bfr;
	
	private static final Gson gson = new Gson();
	
	private String jsonStr = "{\"stat\":\"OK\",\"date\":\"20190101\",\"title\":\"108年01月 2388 威盛             各日成交資訊\",\"fields\":[\"日期\",\"成交股數\",\"成交金額\",\"開盤價\",\"最高價\",\"最低價\",\"收盤價\",\"漲跌價差\",\"成交筆數\"],\"data\":[[\"108/01/02\",\"1,441,179\",\"37,412,266\",\"26.45\",\"26.65\",\"25.60\",\"25.95\",\"-0.35\",\"773\"],[\"108/01/03\",\"1,494,531\",\"38,203,377\",\"25.50\",\"26.35\",\"24.90\",\"25.20\",\"-0.75\",\"853\"],[\"108/01/04\",\"1,803,599\",\"43,538,926\",\"24.60\",\"24.65\",\"23.80\",\"24.00\",\"-1.20\",\"1,045\"],[\"108/01/07\",\"1,229,264\",\"30,446,344\",\"24.80\",\"25.20\",\"24.50\",\"24.60\",\"+0.60\",\"724\"],[\"108/01/08\",\"799,621\",\"19,645,956\",\"24.85\",\"24.85\",\"24.25\",\"24.65\",\"+0.05\",\"511\"],[\"108/01/09\",\"1,798,144\",\"45,490,367\",\"24.90\",\"25.70\",\"24.85\",\"25.00\",\"+0.35\",\"956\"],[\"108/01/10\",\"1,075,120\",\"26,682,061\",\"25.00\",\"25.40\",\"24.50\",\"24.85\",\"-0.15\",\"589\"],[\"108/01/11\",\"1,446,613\",\"36,395,016\",\"25.20\",\"25.75\",\"24.65\",\"24.65\",\"-0.20\",\"939\"],[\"108/01/14\",\"1,066,500\",\"26,551,722\",\"25.00\",\"25.35\",\"24.50\",\"24.70\",\"+0.05\",\"614\"],[\"108/01/15\",\"904,289\",\"22,409,209\",\"24.75\",\"25.10\",\"24.55\",\"24.70\",\" 0.00\",\"542\"],[\"108/01/16\",\"1,330,400\",\"33,099,940\",\"25.05\",\"25.20\",\"24.65\",\"24.70\",\" 0.00\",\"681\"],[\"108/01/17\",\"2,597,078\",\"62,369,889\",\"25.00\",\"25.00\",\"23.75\",\"23.80\",\"-0.90\",\"1,317\"],[\"108/01/18\",\"1,548,117\",\"36,869,787\",\"23.80\",\"24.20\",\"23.50\",\"23.80\",\" 0.00\",\"781\"],[\"108/01/21\",\"2,196,751\",\"53,960,799\",\"24.15\",\"24.95\",\"24.00\",\"24.60\",\"+0.80\",\"1,305\"],[\"108/01/22\",\"1,700,329\",\"42,364,909\",\"24.80\",\"25.45\",\"24.65\",\"24.65\",\"+0.05\",\"972\"],[\"108/01/23\",\"959,287\",\"23,703,188\",\"24.60\",\"24.90\",\"24.30\",\"24.85\",\"+0.20\",\"541\"],[\"108/01/24\",\"1,725,530\",\"43,442,417\",\"25.10\",\"25.40\",\"24.90\",\"25.05\",\"+0.20\",\"929\"],[\"108/01/25\",\"1,630,743\",\"41,199,106\",\"25.40\",\"25.55\",\"25.00\",\"25.05\",\" 0.00\",\"824\"],[\"108/01/28\",\"4,376,499\",\"114,512,442\",\"25.30\",\"26.85\",\"25.15\",\"25.85\",\"+0.80\",\"2,579\"],[\"108/01/29\",\"2,519,272\",\"65,882,046\",\"25.65\",\"26.65\",\"25.65\",\"26.10\",\"+0.25\",\"1,420\"],[\"108/01/30\",\"1,371,678\",\"35,556,671\",\"26.45\",\"26.45\",\"25.65\",\"25.65\",\"-0.45\",\"745\"]],\"notes\":[\"符號說明:+/-/X表示漲/跌/不比價\",\"當日統計資訊含一般、零股、盤後定價、鉅額交易，不含拍賣、標購。\",\"ETF證券代號第六碼為K、M、S、C者，表示該ETF以外幣交易。\"]}";
	//private String jsonStr = "";
	
	public JSON_formatCheck() throws Exception
	{
//		File folder = new File(folder_source);
//		File[] listOfFiles = folder.listFiles();
//
//		for (File file : listOfFiles) {
//		    if (file.isFile()) {
//// 		        System.out.println(file.getName());
//		        		        
//		        // Read files
//		        ReadFile(folder_source + file.getName(), file.getName());
//		    }
//		}
		
		// JSONObject check
		boolean check = false;
		//check = isJSONValid_Jackson(jsonStr);
		//check = isJSONValid_gson(jsonStr);
		JsonParser parser = new JsonParser();
		JsonElement aaa = parser.parse(jsonStr);
		System.out.println(aaa.isJsonObject());
	}
	
//	private void ReadFile(String path, String filename) throws Exception
//	{
//		FileReader fr = new FileReader(path);
//		bfr = new BufferedReader(fr);
//		String Line;
//		String allText = "";
//		while((Line = bfr.readLine())!=null)
//		{								
//			allText += Line;			
//		}
//		fr.close();
//		bfr.close();	
//		
//		// check format
//		boolean checkTag;
//		checkTag = check(allText);
//		
//		System.out.println(filename+"	"+checkTag);
//	}
	
	// com.alibaba.fastjson.JSONObject
//	private boolean check(String jsonStr)
//	{
//		 try {
//		        JSONObject jsonobj = JSONObject.parseObject(jsonStr);
//		        return  true;
//		   } catch (Exception e) {
//		        return false;
//		  }
//	}
	
	// Jackson library
	private boolean isJSONValid_Jackson(String jsonInString ) {
	    try {
	       final ObjectMapper mapper = new ObjectMapper();
	       mapper.readTree(jsonInString);
	       return true;
	    } catch (IOException e) {
	       return false;
	    }
	  }
	
	// 
	public static boolean isJSONValid_gson(String jsonInString) {
		
	      try {
	          gson.fromJson(jsonInString, Object.class);
	          return true;
	      } catch(Exception ex) {
	      //catch(com.google.gson.JsonSyntaxException ex) { 
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
