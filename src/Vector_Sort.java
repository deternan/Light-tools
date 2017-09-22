import java.util.Collections;
import java.util.Vector;

public class Vector_Sort 
{

	public Vector_Sort()
	{
		Vector temp = new Vector();
		temp.add("abc");
		temp.add("bca");
		temp.add("cab");
		temp.add("cba");
		temp.add("abcbc");
				
		// Sort
		Collections.sort(temp);
		
		for(int i=0; i<temp.size(); i++)
		{
			System.out.println(temp.get(i));
		}
	}
	
	public static void main(String args[])
	{
		Vector_Sort sort = new Vector_Sort();
	}
	
}
