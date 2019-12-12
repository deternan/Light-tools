package Revised;

/*
 * Read folder list
 * 
 * version: November 07, 20179 11:30 AM
 * Last revision: November 07, 20179 01:25 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;


public class Jieba 
{
	private String orginalPath = "";
	private String orginalFile = "dict.txt.all.big";
	private String newPath = "";
	private String newFile = "dict.txt.tra.big";
	
	// Read
	private BufferedReader bfr;
	// Write
	private BufferedWriter writer;
	
	public Jieba() throws Exception
	{
		// output
		writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newPath + newFile), "utf-8"));
		
		String Line = "";
		FileReader fr = new FileReader(orginalPath + orginalFile);
		bfr = new BufferedReader(fr);
			
		String temp[];
		boolean Tra_check;
		while((Line = bfr.readLine())!=null)
		{		
			Tra_check = false;			
			temp = Line.split(" ");			
			Tra_check = isSimpleOrComplex(temp[0]);
			//System.out.println(temp[0]+"	"+Tra_check);
			if(Tra_check) {
				writer.write(Line+"\n");
			}
		}
		fr.close();
		bfr.close();
		
		
		writer.close();
		System.out.println("Finished");
	}
	
	private boolean isSimpleOrComplex(String str) {
		boolean returnTag = false;
		String encode = "GB2312";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                //System.out.println(str + "---是简体");
                returnTag = false;
            }else{
            	returnTag = true;
                //System.out.println(str + "---是繁体");
            }
        } catch (Exception e) {
        }
        
        return returnTag;
    }
	
	public static void main(String[] args) 
	{
		try {
			Jieba revised = new Jieba();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
