package Text_related;

/*
 * Text similarity
 * version: August 30, 2019 06:23 PM
 * Last revision: August 30, 2019 06:30 PM
 * 
 * Author : Chao-Hsuan Ke
 * E-mail : phelpske.dev at gmail dot com
 * 
 */

public class wordSim {

	public wordSim()
	{
		String aStr = "鴻海";
		String bStr = "各位我又回來啦，我們接下來，聯發科要開始進入我們專案的起始這個海階段";
		
		double score = sim(aStr, bStr);
		System.out.println(score);
		
		// 聯發 = 0.05882352941176472
		// 聯發科 = 0.08823529411764708
		// 鴻海 = 0.02941176470588236
	}
	
	public static double sim(String str1, String str2) {
		try {
			double ld = (double)ld(str1, str2);
			return (1-ld/(double)Math.max(str1.length(), str2.length()));
		} catch (Exception e) {
			return 0.1;
		}
	}

	public static int ld(String str1, String str2) {
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

	
	public static void main (String args[]) {
		wordSim ws = new wordSim();
	}
	
}
