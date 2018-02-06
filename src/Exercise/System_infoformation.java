package Exercise;

/*
 * Display System information
 * 
 * version: February 07, 2018 02:15 PM
 * Last revision: February 07, 2018 02:15 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

public class System_infoformation 
{

	public System_infoformation()
	{		
		System.out.println(System.getProperties().getProperty("os.name"));  
		System.out.println(System.getProperties().getProperty("file.separator"));  
		
	}
	
	public static void main(String[] args)
	{
		System_infoformation si = new System_infoformation();
	}
}
