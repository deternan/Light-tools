package System;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Execute_shell 
{
	private String command;
	
	public Execute_shell() throws Exception
	{
		// e.g. rm folder
		command = "rm -rf folder";
		
		Process pl = Runtime.getRuntime().exec(command);
        BufferedReader p_in = new BufferedReader(new InputStreamReader(pl.getInputStream()));
        
        try {
			pl.waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        p_in.close();
	}
	
}
