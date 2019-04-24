package Text_related;

/*
 * Character Counter (Chinese and English) 
 * 
 * version: April 24, 2019 02:10 PM
 * Last revision: April 24, 2019 02:10 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

public class CharacterCount {

	public CharacterCount() {
		
		String a = "1234繁體567890+-()简体abcXYZ";
		
	    int chinese = 0;
	    int english= 0;
	    for (int i = 0; i < a.length(); i++ ){

	        char c = a.charAt(i);
	        if ((int) c < 256) {
	            english ++;
	        } else {

	            chinese ++;
	        }        
	    }
	    System.out.println("English:"+english+", Chinese:"+chinese);		
	}
	
	public static void main(String[] args)
	{
		CharacterCount cc = new CharacterCount();
	}
	
}
