package Time;

/*
 * Unit transfer (sec to hour:min:sec)
 * 
 * version: January 11, 2019 05:42 PM
 * Last revision: January 11, 2019 05:42 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 */

public class UnitTransfer {

	public UnitTransfer()
	{
		 // TODO Auto-generated method stub  
	    System.out.println(getDuration(64517));  
	    
	}
	
	public static String getDuration(int durationSeconds){  
	    int hours = durationSeconds /(60*60);  
	    int leftSeconds = durationSeconds % (60*60);  
	    int minutes = leftSeconds / 60;  
	    int seconds = leftSeconds % 60;  
	      
	    StringBuffer sBuffer = new StringBuffer();  
	    sBuffer.append(addZeroPrefix(hours));  
	    sBuffer.append(":");  
	    sBuffer.append(addZeroPrefix(minutes));  
	    sBuffer.append(":");  
	    sBuffer.append(addZeroPrefix(seconds));  
	      
	    return sBuffer.toString();  
	}  
	
	public static String addZeroPrefix(int number){  
	    if(number < 10){  
	        return "0"+number;  
	    }else{  
	        return ""+number;  
	    }  
	  
	}  
	
	public static void main(String[] args)
	{
		UnitTransfer ut = new UnitTransfer();
	}
	
}
