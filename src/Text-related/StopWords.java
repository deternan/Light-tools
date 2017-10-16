package Text_related;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Vector;

/*
 * 
 * version: October 16, 2017 01:41 PM
 * Last revision: October 16, 2017 01:41 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 * English
 * source:	https://github.com/Alir3z4/stop-words/blob/master/english.txt
 * 
 */


public class StopWords 
{
	private String folder = "";
	private String file = "stopwords.txt";
	private BufferedReader bfr;
	private StringBuffer sb = new StringBuffer();
	
	private Vector stopwords = new Vector();
	
	public StopWords() throws Exception
	{
		String Line = "";
		FileReader fr = new FileReader(folder + file);
		bfr = new BufferedReader(fr);
		
		while((Line = bfr.readLine())!=null)
		{			
			stopwords.add(Line);
			System.out.println(Line);
		}
		fr.close();
		bfr.close();
	}
	
	public static void main(String args[]) 
	{
		try {
			StopWords sw = new StopWords();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
