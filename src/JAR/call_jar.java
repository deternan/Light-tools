package JAR;

import java.io.File;

public class call_jar 
{

	public call_jar() throws Exception
	{
		// current path
		String path = new File(".").getCanonicalPath().toString();				
		System.out.println(path);
	}
	
	public static void main(String[] args)
	{
		try {
			call_jar jar = new call_jar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
