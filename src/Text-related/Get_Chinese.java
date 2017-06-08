package Text_related;

public class Get_Chinese 
{
	private String input_str;
	
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
