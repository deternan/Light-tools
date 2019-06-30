package File;

public class RemoveExtensionName 
{
	String filename;
	
	public RemoveExtensionName(String input)
	{
		filename = input.toString().replaceFirst("[.][^.]+$", "");
	}
	
}
