package RegularExpression;

/*
 * regular expression (double) parsing
 * 
 * version: June 04, 2018 08:45 PM
 * Last revision: July 11, 2019 05:56 PM
 * 
 */

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegularExpression_NumberParsing 
{
	String content = "[標的] 1447 力鵬 請益 原文恕刪 被台積嘎到的小弟又來了，前幾天蓋住的那張剛好是力鵬，只買了80張，均價在8.1元。 這兩天賣了60張掉，小賺50K而已，這檔做了67年了，其實滿少虧錢的，也沒有賺超過30 %過就是了（那個1股就是某次配股賣不乾淨的，已經放好久了） 這兩三年大概就是5000張以上的大量收個黑K或上影線就會先收個一半起來，或是爆量紅K 被吃掉一半也會先收一半起來，過幾天沒過高再陸陸續續賣掉，只是平常的時候量太小， 要買到近百張也只能等這兩天有量才出的掉這點很麻煩就是了，拿來偶爾賺點小外快也不 錯 附上出貨單 https://i.imgur.com/OdsDesR.jpg https://i.imgur.com/3jNfdQ6.jpg 這樣就不會誤會了 大哥這個一次我都10張20張賣，賣給不同人系統就會這樣列一次賣一張也太閒了 吧";
	//String content = "[心得] 1447 力鵬 請益 原文恕刪 被台積嘎到的小弟又來了";
	
	//String regex = "([0-9]+\\.{1}[0-9]+)";
	//String regex = "([0-9]+\\.?[0-9]?)";
	String regex = "(標的)|(心得)";
	 
	
	private Pattern pattern;	
	
	
	public RegularExpression_NumberParsing()
	{
		pattern = Pattern.compile(regex, Pattern.MULTILINE);
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) 
		{			
			System.out.println(matcher.group());
		}
		
		System.out.println(pattern.matcher(content).find());
		
	}
	
	public static void main (String args[])
	{
		RegularExpression_NumberParsing RENP = new RegularExpression_NumberParsing();
	}
	
}
