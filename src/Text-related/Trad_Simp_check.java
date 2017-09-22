package Text_related;

/*
 *  Traditional & Simplified Words check
 * 
 *	Version: September 22, 2017 03:51 PM
 * 	Last revision: September 22, 2017 03:51 PM
 * 
 */

public class Trad_Simp_check 
{

	public Trad_Simp_check()
	{
		String str = "經常用到的並";
		String encode = "GB2312";

		try {
			if (!str.equals(new String(str.getBytes(encode), encode))) {
				System.out.println("繁体");
			} else {
				System.out.println("简体");
			}
		} catch (Exception exception3) {

		}
	}
	
	public static void main (String args[]) 
	{
		Trad_Simp_check ts = new Trad_Simp_check();
	}
	
}
