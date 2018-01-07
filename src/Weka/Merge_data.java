package Weka;

/*
 * Merge data
 * 
 * version: December 19, 2017 02:22 PM
 * Last revision: December 25, 2017 01:32 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;

public class Merge_data 
{
	// source data (class)
	private String class_file = "";
	// (text folder)
	private String text_source_folder = "";
	// export
	private String output_folder = "";
	private String output_file = "Training_data.txt";
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output_folder + output_file), "utf-8"));
	
	private BufferedReader bfr;
	private StringBuffer sb = new StringBuffer();
	private Vector allclass_vec = new Vector();
	
	public Merge_data() throws Exception
	{
		
		Read_class();
		//System.out.println(allclass_vec.size());
		Read_Folder();
		
	}
	
	private void Read_class() throws Exception
	{
		String Line = "";
		FileReader fr = new FileReader(class_file);
		bfr = new BufferedReader(fr);
		//String[] temp;
		int count = 0;
		while((Line = bfr.readLine())!=null)
		{			
			//temp = Line.split("\t");
			//allclass_vec.add(temp[1]);
			//System.out.println(Line);
			allclass_vec.add(count);
			count++;
		}
		fr.close();
		bfr.close();
	}
	
	private void Read_Folder() throws Exception
	{
		File a = new File(text_source_folder);
			      
		String[] foldernames;
		String fullpath = a.getAbsolutePath();

		if (a.isDirectory()) {
			foldernames = a.list();
			for (int i = 0; i < foldernames.length; i++) {
				File tempFile = new File(fullpath + "\\" + foldernames[i]);
				if (tempFile.isDirectory()) {
					//System.out.println("目錄:" + foldernames[i]);
					Read_folder_list(foldernames[i]);
				} else{
					//System.out.println("檔案:" + filenames[i]);
				}
			}
		} else{
			System.out.println("[" + a + "]不是目錄");
		}

	}
	
	private void Read_folder_list(String foldername) throws Exception
	{
		File folder = new File(text_source_folder+foldername);
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
		    if (file.isFile()) {
//		        System.out.println(text_source_folder + foldername + "\\"+file.getName());
		        Read_Text(text_source_folder + foldername + "\\"+file.getName(), foldername);
		    }
		}
	}
	
	private void Read_Text(String source, String foldername) throws Exception
	{
		String Line = "";
		FileReader fr = new FileReader(source);
		bfr = new BufferedReader(fr);
		String jsonstr;
		while((Line = bfr.readLine())!=null)
		{
			jsonstr = Line;
			//sb.append(Line+"\n");
			Json2Text(jsonstr, foldername);
		}
		fr.close();
		bfr.close();
	}
	
	private void Json2Text(String jsonstr, String classname) throws Exception
	{
		JSONObject obj;
		JSONArray jsonarray = new JSONArray(jsonstr);
		String Title = "";
		String content = "";
		//System.out.println(jsonarray.get(0));
		for(int i=0; i<jsonarray.length(); i++)
		{
			obj = new JSONObject(jsonarray.get(i).toString());
			if(obj.has("Title")){
				//System.out.println(obj.get("Title"));
				Title = obj.get("Title").toString();
				//break;
			}
			if(obj.has("Content")){
				content = obj.get("Content").toString();
			}
			//writer.write(str);			
		}
		System.out.println(classname+"	"+Title);
		writer.write(classname+"	"+Title+", "+content+"\n");
	}
	
	
	public static void main(String[] args)
	{
		try {
			Merge_data tt = new Merge_data();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
