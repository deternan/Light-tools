package Files;

/*
 * Version: 
 * Move allfiles from path_A to path_B 
 * 
 * Version: April 27, 2017	01:42 PM
 * Last revision: April 27, 2017	01:42 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

public class Move_files 
{
	private String command_str;
	private String path_A;
	private String path_B;
	
	public Move_files()
	{
		command_str = "cp " + path_A + "* "+ path_B;

		Process proc = null;
		try {
			proc = Runtime.getRuntime().exec(new String[] { "/bin/sh"//$NON-NLS-1$
					, "-c", command_str });//$NON-NLS-1$
			if (proc != null) {
				proc.waitFor();
			}
		} catch (Exception e) {
			// Handle
			return;
		}
	}
	
	public static void main(String args[])
	{
		Move_files mf = new Move_files();
	}
	
}
