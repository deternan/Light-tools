

public class Get_Chinese 
{
	private String input_str = "LINE 從 2016 年 4 月 7 日開始提供免費「LINE BOT API 試用」帳號 (LINE BOT API Trial Account) 申請，讓任何人都可以在 LINE 的平台上開發聊天機器人的多元應用";
	
	public Get_Chinese()
	{
		String sentence = "";
		for(int i=0; i<input_str.length();i++)
		{  
		    String test = input_str.substring(i, i+1);  
		    if(test.matches("[\\u4E00-\\u9FA5]+")){  
		        //System.out.printf("\t[Info] %s -> 中文!\n", test);
		    	sentence += test;
		    }  
		      
		}
		if(sentence.length() > 0){
			System.out.println(sentence);
		}
	}
	
	public static void main(String[] args)
	{
		Get_Chinese chinese = new Get_Chinese();
	}
	
}
