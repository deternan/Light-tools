package Text_related;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 * version: August 22, 2017 05:43 PM
 * Last revision: August 22, 2017 05:43 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

public class ngram 
{
	private int n_num = 3;
	private String input_sentence = "Go to Delta company";
	
	public ngram()
	{
		//for (int n = 1; n <= n_num; n++) 
		{
            for (String ngram : ngrams(n_num, input_sentence))
                System.out.println(ngram);
            System.out.println();
        }
	}
	
	private List<String> ngrams(int n, String str) 
	{
        List<String> ngrams = new ArrayList<String>();
        String[] words = str.split(" ");
        for (int i = 0; i < words.length - n + 1; i++)
            ngrams.add(concat(words, i, i+n));
        
        return ngrams;
    }
	
	private String concat(String[] words, int start, int end) 
	{
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++)
            sb.append((i > start ? " " : "") + words[i]);
        return sb.toString();
    }
	
	public static void main(String args[]) 
	{
		ngram ngram = new ngram();
	}
	
}
