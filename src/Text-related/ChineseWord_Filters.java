package Text_related;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 *  Filter Chinese Words
 * 
 *	Version: October 05, 2016	10:51 AM
 * 	Last revision: June 02, 2017 09:55 AM
 * 
 */


public class ChineseWord_Filters
{
	private BufferedReader bfr;
	private StringBuffer sb = new StringBuffer();	
	// (Individual) Course terms
	private Vector Course_Terms;
	String TP = "各位我又回來啦，我們接下來要開始進入我們專案的起始這個階段，專案起始我們會跟各位介紹兩個非常重要的 concept 還有方法，第一個就是專案章程，我想各位有沒有聽過 project charter，應該沒聽過吧? 第二個就是 分析利害關係人，因為我們專案必須要了解你的利害關係人有誰，然後他們需要什麼以及怎麼樣去滿足他們的需求，所以我們在這兩個部分跟各位提到，那同時呢各位之後會有 homework 要做，那我們特地為各位選出了五個要點，五個項目，讓各位來練習 homework，你們可以自己選，你要做哪樣的一個 project，你要做 homework 你必須要有 excel 檔，我們也會提供給你一個 excel 檔，那同時呢，也要請各位記得下載我們的 OpenProj 這個軟體: OpenProj 以後你會使用這個軟體之後，你就不用老是使用excel檔了，除非你本來就是使用 Microsoft 的 project，否則呢你接下來就是用 OpenProj，你會發現這個操作實在太好用了，所以我們接下來就開始跟各位介紹我們的 project initiation。";	
	
	// Limitation
	private int min_string_length = 2;
	
	// Regression
	String regEx="[a-zA-Z//./////+//#]+";
	Pattern pattern;
	Matcher match;
	
	public ChineseWord_Filters() throws Exception
	{
		Course_Terms = new Vector();
		
		pattern = Pattern.compile(regEx);				
		Word_Parser();
		
		for(int i=0;i<Course_Terms.size();i++)
		{
			System.out.println(Course_Terms.get(i));
		}
	}
	
	private void Sentence_Combination(String path) throws Exception
	{
		String Line = "";
		FileReader fr = new FileReader(path);
		bfr = new BufferedReader(fr);
		
		while((Line = bfr.readLine())!=null)
		{
			sb.append(Line+"\n");
		}
		fr.close();
		bfr.close();
	}
	
	private void Word_Parser()
	{
		String words[];			// Course_Terms_All
		String temp = "";		
		words = TP.replaceAll("\n"," ").split(" ");
		
		for(int i=0; i<words.length; i++)
		{									
			match = pattern.matcher(words[i]);
				
			if(match.matches())
			{
				temp = Remove_mark(match.group());								
				if(temp!=null && (temp.length() >= min_string_length)){											
					Course_Terms.add(temp);
				}
			}			
		}		
	}
	
	private String Remove_mark(String key)
	{		
		if(key.substring(key.length()-1, key.length()).equalsIgnoreCase("."))
		{
			key = key.substring(0, key.length()-1);
		}
		
		return key;
	}
	
	public static void main (String args[]) 
	{
		try {
			ChineseWord_Filters CFs = new ChineseWord_Filters();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
