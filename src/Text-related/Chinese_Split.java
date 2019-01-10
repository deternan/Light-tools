package Text_related;

/*
 * Chinese_Split
 * 
 * version: January 10, 2019 01:20 PM
 * Last revision: January 10, 2019 01:20 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

/*
 * Reference
 * 
 * 
 *   在GBK编码中，一个中文字符占2个字节，UTF-8编码格式，一个中文字符占3个字节。
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class Chinese_Split {

	public static final String chineseString = "手機收不到災防告警訊息，5 個原因先查看";

	/*
	 * English & Number = 1
	 * Traditional Chinese = 2
	 * Simplified Chinese = 3 
	 */
	int cha_num = 2;	
	
	
	public Chinese_Split()
	{
		// Remove Symbol
		String inputStr = Remove_Symbol(chineseString);
		System.out.println(inputStr);
		
		// Chinese Character split
		List<String> splitStringList = chineseSplitFunction(inputStr, cha_num);
		for (String split : splitStringList) {
			System.out.println(split.trim());
		}
	}
	
	public static List<String> chineseSplitFunction(String src, int bytes) 
	{
		try {
			if (src == null) {
				return null;
			}
			List<String> splitList = new ArrayList<String>();
			int startIndex = 0; 
			int endIndex = bytes > src.length() ? src.length() : bytes;
			while (startIndex < src.length()) {
				String subString = src.substring(startIndex, endIndex);
				
				
				while (subString.getBytes("GBK").length > bytes) {
					--endIndex;
					subString = src.substring(startIndex, endIndex);
				}
				splitList.add(src.substring(startIndex, endIndex));
				startIndex = endIndex;
				
				endIndex = (startIndex + bytes) > src.length() ? src.length() : startIndex + bytes;

			}
			return splitList;

		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return null;
	}

	private String Remove_Symbol(String input_str)
	{
		String str = input_str.replaceAll("(?i)[^a-zA-Z0-9\u4E00-\u9FA5]", " ");
		
		//System.out.println(str);
		
		return str;
	}
	
	public static void main(String[] args) {
		Chinese_Split CS = new Chinese_Split();
	}
}
