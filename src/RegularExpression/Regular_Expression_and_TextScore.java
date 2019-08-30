package RegularExpression;

/*
 * Regular_Expression and Text Score
 * version: August 30, 2019 06:15 PM
 * Last revision: August 30, 2019 06:54 PM
 * 
 * Author : Chao-Hsuan Ke
 * E-mail : phelpske.dev at gmail dot com
 * 
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular_Expression_and_TextScore 
{
	String input = "各位我又回來啦，我們接下來，聯發科要開始進入我們專案的起始這個海階段";
	
	String tempArray[] = {"聯發", "聯發科", "鴻海"};
	
	// Regular expression
	Pattern pattern;
	Matcher matcher;
	
	public Regular_Expression_and_TextScore()
	{
		TitleContentDetection(input);
		
	}
	
	private void TitleContentDetection(String inputTitle) 
	{			
		String regexName = "";
		String tmpName;
		String patternName;
		
		//Vector nameScoreTmp = new Vector();
		double nameScoreTmp = -1000;
		String nameStrTmp = "";
		
		if(tempArray.length > 1) {
			for (int i=0; i<tempArray.length; i++) {
				patternName = "";

				// Name
				tmpName = tempArray[i].replace("-KY", "");
				tmpName = tmpName.replace("-DR", "");
				regexName = "(" + tmpName + ")+";
				pattern = Pattern.compile(regexName, Pattern.MULTILINE);
				matcher = pattern.matcher(inputTitle);
				while (matcher.find()) 
				{
					patternName = matcher.group();
					System.out.println(patternName);
					double score = sim(patternName, input);
					if(score > nameScoreTmp) {
						nameStrTmp = patternName;
						nameScoreTmp = score;
					}
					//break;
				}
			}
		}else if(tempArray.length == 1){
			nameStrTmp = tempArray[0];
		}
		
		System.out.println(nameStrTmp+"	"+nameScoreTmp);
		
	}
	
	private static double sim(String str1, String str2) 
	{
		try {
			double ld = (double)ld(str1, str2);
			return (1-ld/(double)Math.max(str1.length(), str2.length()));
		} catch (Exception e) {
			return 0.1;
		}
	}

	public static int ld(String str1, String str2) 
	{
		int d[][]; 
		int n = str1.length();
		int m = str2.length();
		int i; 
		int j; 
		char ch1; 
		char ch2; 
		int temp; 
		if (n == 0) {
			return m;
		}
		if (m == 0) {
			return n;
		}
		d = new int[n + 1][m + 1];
		for (i = 0; i <= n; i++) { 
			d[i][0] = i;
		}
		for (j = 0; j <= m; j++) { 
			d[0][j] = j;
		}
		for (i = 1; i <= n; i++) { 
			ch1 = str1.charAt(i - 1);
			
			for (j = 1; j <= m; j++) 
			{
				ch2 = str2.charAt(j - 1);
				if (ch1 == ch2) {
					temp = 0;
				} else {
					temp = 1;
				}
				
				d[i][j] = min(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1]+ temp);
			}
		}
		
		return d[n][m];
	}

	private static int min(int one, int two, int three) 
	{
		int min = one;
		if (two < min) {
			min = two;
		}
		if (three < min) {
			min = three;
		}
		
		return min;
	}
	
	public static void main (String args[]) 
	{
		Regular_Expression_and_TextScore REC = new Regular_Expression_and_TextScore();
	}
	
}
