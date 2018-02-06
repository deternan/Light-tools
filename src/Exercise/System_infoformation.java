package Exercise;

import java.io.File;

/*
 * Display System information
 * 
 * version: February 07, 2018 02:15 PM
 * Last revision: February 07, 2018 02:31 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

public class System_infoformation 
{

	public System_infoformation() throws Exception
	{		
		System.out.println(System.getProperties().getProperty("os.name"));  
		System.out.println(System.getProperties().getProperty("file.separator"));  
		System.out.println(new File(".").getCanonicalPath().toString());
	}
	
	public static void main(String[] args)
	{
		try {
			System_infoformation si = new System_infoformation();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
