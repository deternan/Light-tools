
public class get_path 
{

	public get_path()
	{
		String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
		System.out.println(path);
	}
	
	public static void main(String[] args)
	{
		get_path path = new get_path();
	}
	
}
