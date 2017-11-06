package Application;

/*
 * Jieba interface
 * 
 * version: November 06, 2017 03:39 PM
 * Last revision: November 06, 2017 03:39 PM
 * 
 * Author : Chao-Hsuan Ke
 * 
 */

import Application.jieba.JiebaSegmenter;
import Application.jieba.JiebaSegmenter.SegMode;

public class jieba_Interface 
{	
	JiebaSegmenter segmenter = new JiebaSegmenter();
	String input_str = "蘋果說明表示，如果使用者以傾斜角度觀察 iPhone X 的 OLED 螢幕，將會注意到輕微的顏色變化，這是 OLED 螢幕的特性和正常表現。";
	
	public jieba_Interface()
	{				
		// System.out.println(segmenter.process(sentence, SegMode.INDEX).size()+"	"+segmenter.process(sentence, SegMode.INDEX).get(0));
		System.out.println(segmenter.process(input_str, SegMode.INDEX).size()+"	"+segmenter.process(input_str, SegMode.INDEX));
		    
	}

	public static void main(String args[])
	{
		jieba_Interface inter = new jieba_Interface();
	}
}
